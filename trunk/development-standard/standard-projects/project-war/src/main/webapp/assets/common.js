/**
 * 기존 index.html 상에 있던 JS 모음
 * 전경훈 2014.10.28
 */
if ((typeof Shopify) === 'undefined')
			    var Shopify = {};
			
			Shopify.onItemAdded = function(line_item) {
			    var line_item_url;
			
			    if (line_item.image)
			        line_item_image = '<a href="' + line_item.url + '" target="_self" class="line-item-image"><img src="' + line_item.image + '" /></a>';
			
			    $('body')
			        .popGrowl({
			            id: 'cart-notifications',
			            html: '<div class="cart-notification-added clearfix">' + line_item_image + '<div class="cart-details"><p><strong><a href="' + line_item.url + '" target="_self">' + line_item.title + '</a></strong></p><p>This item has been added to your cart</p><div class="text-right"></div></div></div><a href="/cart" target="_self" class="button bm-remove tm-small w-full h-small">VIEW CART</a>'
			        });
			
			    Shopify.getCart();
			};
			
			Shopify.onCartUpdate = function(cart) {
			    $('#ajax-header-cart-item-count, #ajax-breadcrumb-cart-item-count')
			        .html(cart.item_count);
			    $(
			            '#ajax-header-cart-total-price, #ajax-breadcrumb-cart-total-price, #ajax-subtotal-cart-total-price')
			        .html(
			            Shopify.formatMoney(cart.total_price,
			                '&#8361;{{amount_no_decimals}}'));
			
			    if (cart.item_count == 1)
			        $('#ajax-header-cart-item-text, #ajax-breadcrumb-cart-item-text')
			        .html('Item');
			    else
			        $('#ajax-header-cart-item-text, #ajax-breadcrumb-cart-item-text')
			        .html('Items');
			};
			
			Shopify.onProduct = function(product) {
			    // Image
			    if (product.featured_image === null) {
			        $('.shopify-quick-look-overlay .quick-look-image')
			            .html(
			                "<a href='" + product.url + "' target='_self'><img src='./assets/no-image.png?20' class='block no-image' /></a>");
			    } else {
			        var imageData = '';
			
			        for (var x = 0, l = product.images.length; x < l; x++) {
			            imageData += '<div class="item"><a href="' + product.url + '" target="_self" class="quick-look-featured-image text-center block"><img src="' + product.images[x] + '" class="block" /></a></div>';
			        }
			
			        $('.shopify-quick-look-overlay .quick-look-image')
			            .html(
			                '<div id="quick-look-images-carousel-container" class="clearfix"><div id="quick-look-images-carousel" class="owl-carousel owl-theme">' + imageData + '</div><div class="prev tip-t-fade" data-tooltip="Previous"></div><div class="next tip-t-fade" data-tooltip="Next"></div></div>');
			
			        var $quickLookImages = $('#quick-look-images-carousel');
			
			        $quickLookImages.owlCarousel({
			            slideSpeed: 500,
			            paginationSpeed: 500,
			            singleItem: true,
			            autoPlay: true,
			            stopOnHover: true
			        });
			
			        $('#quick-look-images-carousel-container .prev').on('click',
			            function() {
			                $quickLookImages.trigger('owl.prev');
			            });
			
			        $('#quick-look-images-carousel-container .next').on('click',
			            function() {
			                $quickLookImages.trigger('owl.next');
			            });
			    }
			
			    // General
			    if (product.description.length > 500)
			        var description = $.trim(product.description).substring(0, 300)
			            .split(' ').slice(0, -1).join(' ') + '...';
			    else
			        var description = product.description;
			
			    $('.shopify-quick-look-overlay .quick-look-title').html(
			        '<a href="' + product.url + '" target="_self">' + product.title + '</a>');
			    $('.shopify-quick-look-overlay .quick-look-description').html(
			        description);
			    $('.shopify-quick-look-overlay .quick-look-price').html(
			        '<small>From </small>' + Shopify.formatMoney(product.price_min,
			            '&#8361;{{amount_no_decimals}}'));
			
			    if (product.available) {
			        // Show availbility
			        $('.shopify-quick-look-overlay .quick-look-available').show();
			        $('.shopify-quick-look-overlay .quick-look-not-available').hide();
			
			        initQtySteps();
			
			        // Variables
			        var $variantSelect = $('<select>', {
			                'name': 'id',
			                'id': 'quick-look-variants',
			                'class': 'w-full'
			            }),
			            $variantOption = '';
			
			        // Loop variants
			        for (var x = 0; x < product.variants.length; x++) {
			            if (product.variants[x].available)
			                if (product.variants[x].compare_at_price > product.variants[x].price)
			                    $variantOption += '<option value="' + product.variants[x].id + '">' + product.variants[x].title + ' - ' + Shopify.formatMoney(
			                        product.variants[x].price,
			                        '&#8361;{{amount_no_decimals}}') + ' (was ' + Shopify.formatMoney(
			                        product.variants[x].compare_at_price,
			                        '&#8361;{{amount_no_decimals}}') + ') </option>';
			                else
			                    $variantOption += '<option value="' + product.variants[x].id + '">' + product.variants[x].title + ' - ' + Shopify.formatMoney(
			                        product.variants[x].price,
			                        '&#8361;{{amount_no_decimals}}') + '</option>';
			        }
			
			        // Display variant options
			        if (product.variants.length === 1)
			            $('.quick-look-variants').hide();
			        else
			            $('.quick-look-variants').show();
			
			        $variantSelect.append($variantOption);
			
			        $('.shopify-quick-look-overlay .quick-look-option-variant').append(
			            $variantSelect);
			    } else {
			        // Hide availability
			        $('.shopify-quick-look-overlay .quick-look-available').hide();
			        $('.shopify-quick-look-overlay .quick-look-not-available').show();
			    }
			};
			
			Shopify.onError = function(XMLHttpRequest, textStatus) {
			    var data = eval('(' + XMLHttpRequest.responseText + ')');
			
			    $('body').edgeAlerts({
			        title: 'Error',
			        message: data.description
			    });
			};
			
			$(document)
			    .ready(
			        function() {
			
			            $('.quick-look')
			                .shopifyQuickLook({
			                    callbackAfterOpen: function() {
			                        $(
			                                '.shopify-quick-look-overlay .quick-look-add-to-cart')
			                            .on(
			                                'click',
			                                function() {
			                                    var product_id = $(
			                                            '#quick-look-variants option:selected')
			                                        .val(),
			                                        product_qty = $(
			                                            '#quick-look-quantity')
			                                        .val();
			
			                                    Shopify
			                                        .addItem(
			                                            product_id,
			                                            product_qty);
			
			                                    $(
			                                            '.shopify-quick-look-container')
			                                        .animate({
			                                                'top': '-200px'
			                                            },
			                                            400)
			                                        .fadeOut({
			                                            queue: false,
			                                            duration: 400
			                                        });
			
			                                    $('body')
			                                        .removeClass(
			                                            'no-scroll')
			
			                                    $(
			                                            '.shopify-quick-look-overlay')
			                                        .fadeOut(
			                                            400,
			                                            function() {
			                                                $(
			                                                        '.shopify-quick-look-container')
			                                                    .empty()
			                                                    .remove();
			                                                $(
			                                                        '.shopify-quick-look-overlay')
			                                                    .empty()
			                                                    .remove();
			                                            });
	                                		});
			                    }
			                });
			
			            $('.product-add-to-cart')
			                .on(
			                    'click',
			                    function(e) {
			                        e.preventDefault();
			
			                        var product_id = $(
			                                '#product-select option:selected')
			                            .val(),
			                            product_qty = $(
			                                '#quantity').val();
			
			                        console.log(product_id);
			                        console.log(product_qty);
			
			                        Shopify.addItem(product_id,
			                            product_qty);
			                    });
			
			            $('.cart-update-item')
			                .on(
			                    'click',
			                    function(e) {
			                        e.preventDefault();
			
			                        var itemID = $(this).attr(
			                                'data-item-id'),
			                            itemName = $(
			                                this)
			                            .attr('data-item-name'),
			                            itemQuantity = parseInt($(
			                                    '#' + $(this)
			                                    .attr(
			                                        'data-item-quantity'))
			                                .val()),
			                            itemPrice = parseInt($(
			                                this).attr(
			                                'data-item-price')),
			                            itemStock = parseInt($(
			                                this).attr(
			                                'data-item-stock')),
			                            itemBackorder = $(
			                                this).attr(
			                                'data-item-backorder');
			
			                        if (itemQuantity < 1) {
			                            $('#cart-remove-item-' + itemID)
			                                .trigger('click');
			                        } else {
			                            if (itemQuantity > itemStock) {
			                                if (itemBackorder == 'continue') {
			                                    Shopify.changeItem(
			                                        itemID,
			                                        itemQuantity);
			
			                                    $(
			                                            '#ajax-cart-item-line-price-' + itemID)
			                                        .html(
			                                            Shopify
			                                            .formatMoney(
			                                                itemPrice * itemQuantity,
			                                                '&#8361;{{amount_no_decimals}}'));
			
			                                    $('body')
			                                        .edgeAlerts({
			                                            title: itemName,
			                                            message: 'There are now ' + itemQuantity + ' of these items in your cart but only ' + itemStock + ' in stock.<br /><br />' + (itemQuantity - itemStock) + ' of these will be back-ordered for you.'
			                                        });
			                                } else {
			                                    $('#quantity-' + itemID)
			                                        .val(itemStock);
			
			                                    Shopify.changeItem(
			                                        itemID,
			                                        itemStock);
			
			                                    $(
			                                            '#ajax-cart-item-line-price-' + itemID)
			                                        .html(
			                                            Shopify
			                                            .formatMoney(
			                                                itemPrice * itemStock,
			                                                '&#8361;{{amount_no_decimals}}'));
			
			                                    $('body')
			                                        .edgeAlerts({
			                                            title: itemName,
			                                            message: 'There are only ' + itemStock + ' of these items available.<br /><br />We have placed all ' + itemStock + ' of these in your cart.'
			                                        });
			                                }
			                            } else {
			                                Shopify.changeItem(itemID,
			                                    itemQuantity);
			
			                                $(
			                                        '#ajax-cart-item-line-price-' + itemID)
			                                    .html(
			                                        Shopify
			                                        .formatMoney(
			                                            itemPrice * itemQuantity,
			                                            '&#8361;{{amount_no_decimals}}'));
			
			                                $('body')
			                                    .edgeAlerts({
			                                        title: itemName,
			                                        message: 'There are now ' + itemQuantity + ' of these items in your cart.'
			                                    });
			                            }
			                        }
			                    });
			
			            $('.cart-remove-item')
			                .on(
			                    'click',
			                    function(e) {
			                        e.preventDefault();
			
			                        var itemID = $(this).attr(
			                                'data-item-id'),
			                            itemName = $(
			                                this)
			                            .attr('data-item-name');
			
			                        $('body')
			                            .edgeAlerts({
			                                type: 'confirm',
			                                title: itemName,
			                                message: 'Are you sure you wish to remove this item?',
			                                cancelText: 'No',
			                                continueText: 'Yes',
			                                callbackConfirm: function() {
			                                    Shopify
			                                        .removeItem(itemID);
			
			                                    $(
			                                            '#cart-item-' + itemID)
			                                        .remove();
			
			                                    if ($(
			                                            '.cart-item')
			                                        .size() < 1)
			                                        window.location
			                                        .replace('/');
			                                }
			                            });
			                    });
			        });

			
/* */
//<![CDATA[
var Shopify = Shopify || {};
Shopify.shop = "dongmin-lee.myshopify.com";
Shopify.theme = {
    "name": "themeforest-8207504-nero-responsive-shopify-theme",
    "id": 11765543,
    "theme_store_id": null,
    "role": "main"
};

//]]>


/* */
//<![CDATA[
(function() {
    function asyncLoad() {
        var urls = ["//cdn.shopify.com/s/javascripts/shopify_stats.js?v=6"];
        for (var i = 0; i < urls.length; i++) {
            var s = document.createElement('script');
            s.type = 'text/javascript';
            s.async = true;
            s.src = urls[i];
            var x = document.getElementsByTagName('script')[0];
            x.parentNode.insertBefore(s, x);
        }
    }
    window.attachEvent ? window.attachEvent('onload', asyncLoad) : window
        .addEventListener('load', asyncLoad, false);
})();

//]]>

/* */
function getStyle(el, styleProp) {
    var x = el;
    if (x.currentStyle)
        var y = x.currentStyle[styleProp];
    else if (window.getComputedStyle)
        var y = document.defaultView.getComputedStyle(x, null)
            .getPropertyValue(styleProp);
    return y;
}

function doShift(down) {
    var allElements = document.getElementsByTagName('*');
    for (var i = 0; i < allElements.length; i++) {
        if (allElements[i].id != "admin_bar_iframe" && getStyle(allElements[i], "position") == "fixed")
            allElements[i].style.top = parseInt(getStyle(allElements[i],
                "top"), 10) + (down ? 40 : -40) + "px";
    }
}
window.onload = function() {
    doShift(true);
}

if (window.addEventListener) {
    addEventListener("message", receiveABMessage, false);
} else {
    window.attachEvent("onmessage", receiveABMessage)
}

function setABVCookie(value) {
    var ex = new Date();
    ex.setDate(ex.getDate() + 720);
    document.cookie = "_abv=" + value + ";expires=" + ex.toUTCString() + ";path=/";
}

function receiveABMessage(event) {
    if (event.origin != 'https://dongmin-lee.myshopify.com')
        return;

    if (event.data == '1') {
        document.body.style.position = 'relative';
        document.documentElement.style.marginTop = "40px";
        doShift(true);
        var element = document.getElementById("admin_bar_iframe");
        element.style.width = '100%';
        element.style.backgroundColor = '#191919';
        element.style.right = 'auto';
        element.style.left = 0;
        setABVCookie('1');
    } else if (event.data == '0') {
        document.body.style.position = 'relative';
        document.documentElement.style.marginTop = "0px";
        doShift(false);
        var element = document.getElementById("admin_bar_iframe");
        element.style.backgroundColor = 'transparent';
        element.style.right = '0px';
        element.style.left = 'auto';
        element.style.width = '40px';
        setABVCookie('0');
    }
}

/* */

			
			