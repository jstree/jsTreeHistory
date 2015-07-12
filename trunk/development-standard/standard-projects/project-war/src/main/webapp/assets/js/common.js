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
			                "<a href='" + product.url + "' target='_self'><img src='./assets/images/no-image.png?20' class='block no-image' /></a>");
			    } else {
			        var imageData = '';
			
			        for (var x = 0, l = product.images.length; x < l; x++) {
			            imageData += '<div class="item"><a href="' + product.url + '" target="_blank" class="quick-look-featured-image text-center block"><img src="' + product.images[x] + '" class="block" /></a></div>';
			        }
			
			        $('.shopify-quick-look-overlay .quick-look-image')
			            .html(
			                '<div id="quick-look-images-carousel-container" class="clearfix"><div id="quick-look-images-carousel" class="owl-carousel owl-theme">' + imageData + '</div><div class="prev tip-t-fade" data-tooltip="Previous"></div><div class="next tip-t-fade" data-tooltip="Next"></div></div>');
			
			        var $quickLookImages = $('#quick-look-images-carousel');
			
			        $quickLookImages.owlCarousel({
			            slideSpeed: 500,
			            paginationSpeed: 1500,
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
			    if (product.description.length > 1000)
			        var description = $.trim(product.description).substring(0, 800)
			            .split(' ').slice(0, -1).join(' ') + '...';
			    else
			        var description = product.description;
			
			    $('.shopify-quick-look-overlay .quick-look-title').html(
			        '<a href="' + product.url + '" target="_self">' + product.title + '</a>');
			    $('.shopify-quick-look-overlay .quick-look-description').html(
			        description);
			    $('.shopify-quick-look-overlay .quick-look-price').html(
			        '<small>From </small>' + product.price_min);
			
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

jQuery.fn.serializeObject = function() {
	
	var object = null;
	
	if (this[0] && this[0].tagName == 'FORM') {
		var array = this.serializeArray();
		
		if (array) {
			var obj = {};
			
			jQuery.each(array, function() {
				obj[this.name] = this.value;
			});
			
			object = obj;
		}
	}
	
	return object;
};

jQuery.submitDynamicForm = function( action, params ) 
{
	if( action == null ) return;
	
	var $form = $('<form/>');
	$form.attr('action', action);
	$form.attr('method', 'post');
	
	$.each( params, function( key, value ) 
	{
		$('<input/>').attr({ type  : 'hidden'
                           , name  : key
		                   , value : value
                           }).appendTo($form);
	});
	
	$form.submit();
};



/** 
 * Sha 256 Encryption 
 * 추가자 : 전경훈
 * 추가일자 : 2015.07.12
 * 사용법 : Sha256.hash(text)
 * */

/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -  */
/*  SHA-256 implementation in JavaScript                (c) Chris Veness 2002-2014 / MIT Licence  */
/*                                                                                                */
/*  - see http://csrc.nist.gov/groups/ST/toolkit/secure_hashing.html                              */
/*        http://csrc.nist.gov/groups/ST/toolkit/examples.html                                    */
/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -  */

/* jshint node:true *//* global define, escape, unescape */
'use strict';


/**
 * SHA-256 hash function reference implementation.
 *
 * @namespace
 */
var Sha256 = {};


/**
 * Generates SHA-256 hash of string.
 *
 * @param   {string} msg - String to be hashed
 * @returns {string} Hash of msg as hex character string
 */
Sha256.hash = function(msg) {
    // convert string to UTF-8, as SHA only deals with byte-streams
    msg = msg.utf8Encode();
    
    // constants [§4.2.2]
    var K = [
        0x428a2f98, 0x71374491, 0xb5c0fbcf, 0xe9b5dba5, 0x3956c25b, 0x59f111f1, 0x923f82a4, 0xab1c5ed5,
        0xd807aa98, 0x12835b01, 0x243185be, 0x550c7dc3, 0x72be5d74, 0x80deb1fe, 0x9bdc06a7, 0xc19bf174,
        0xe49b69c1, 0xefbe4786, 0x0fc19dc6, 0x240ca1cc, 0x2de92c6f, 0x4a7484aa, 0x5cb0a9dc, 0x76f988da,
        0x983e5152, 0xa831c66d, 0xb00327c8, 0xbf597fc7, 0xc6e00bf3, 0xd5a79147, 0x06ca6351, 0x14292967,
        0x27b70a85, 0x2e1b2138, 0x4d2c6dfc, 0x53380d13, 0x650a7354, 0x766a0abb, 0x81c2c92e, 0x92722c85,
        0xa2bfe8a1, 0xa81a664b, 0xc24b8b70, 0xc76c51a3, 0xd192e819, 0xd6990624, 0xf40e3585, 0x106aa070,
        0x19a4c116, 0x1e376c08, 0x2748774c, 0x34b0bcb5, 0x391c0cb3, 0x4ed8aa4a, 0x5b9cca4f, 0x682e6ff3,
        0x748f82ee, 0x78a5636f, 0x84c87814, 0x8cc70208, 0x90befffa, 0xa4506ceb, 0xbef9a3f7, 0xc67178f2 ];
    // initial hash value [§5.3.1]
    var H = [
        0x6a09e667, 0xbb67ae85, 0x3c6ef372, 0xa54ff53a, 0x510e527f, 0x9b05688c, 0x1f83d9ab, 0x5be0cd19 ];

    // PREPROCESSING 
 
    msg += String.fromCharCode(0x80);  // add trailing '1' bit (+ 0's padding) to string [§5.1.1]

    // convert string msg into 512-bit/16-integer blocks arrays of ints [§5.2.1]
    var l = msg.length/4 + 2; // length (in 32-bit integers) of msg + ‘1’ + appended length
    var N = Math.ceil(l/16);  // number of 16-integer-blocks required to hold 'l' ints
    var M = new Array(N);

    for (var i=0; i<N; i++) {
        M[i] = new Array(16);
        for (var j=0; j<16; j++) {  // encode 4 chars per integer, big-endian encoding
            M[i][j] = (msg.charCodeAt(i*64+j*4)<<24) | (msg.charCodeAt(i*64+j*4+1)<<16) | 
                      (msg.charCodeAt(i*64+j*4+2)<<8) | (msg.charCodeAt(i*64+j*4+3));
        } // note running off the end of msg is ok 'cos bitwise ops on NaN return 0
    }
    // add length (in bits) into final pair of 32-bit integers (big-endian) [§5.1.1]
    // note: most significant word would be (len-1)*8 >>> 32, but since JS converts
    // bitwise-op args to 32 bits, we need to simulate this by arithmetic operators
    M[N-1][14] = ((msg.length-1)*8) / Math.pow(2, 32); M[N-1][14] = Math.floor(M[N-1][14]);
    M[N-1][15] = ((msg.length-1)*8) & 0xffffffff;


    // HASH COMPUTATION [§6.1.2]

    var W = new Array(64); var a, b, c, d, e, f, g, h;
    for (var i=0; i<N; i++) {

        // 1 - prepare message schedule 'W'
        for (var t=0;  t<16; t++) W[t] = M[i][t];
        for (var t=16; t<64; t++) W[t] = (Sha256.σ1(W[t-2]) + W[t-7] + Sha256.σ0(W[t-15]) + W[t-16]) & 0xffffffff;

        // 2 - initialise working variables a, b, c, d, e, f, g, h with previous hash value
        a = H[0]; b = H[1]; c = H[2]; d = H[3]; e = H[4]; f = H[5]; g = H[6]; h = H[7];

        // 3 - main loop (note 'addition modulo 2^32')
        for (var t=0; t<64; t++) {
            var T1 = h + Sha256.Σ1(e) + Sha256.Ch(e, f, g) + K[t] + W[t];
            var T2 =     Sha256.Σ0(a) + Sha256.Maj(a, b, c);
            h = g;
            g = f;
            f = e;
            e = (d + T1) & 0xffffffff;
            d = c;
            c = b;
            b = a;
            a = (T1 + T2) & 0xffffffff;
        }
         // 4 - compute the new intermediate hash value (note 'addition modulo 2^32')
        H[0] = (H[0]+a) & 0xffffffff;
        H[1] = (H[1]+b) & 0xffffffff; 
        H[2] = (H[2]+c) & 0xffffffff; 
        H[3] = (H[3]+d) & 0xffffffff; 
        H[4] = (H[4]+e) & 0xffffffff;
        H[5] = (H[5]+f) & 0xffffffff;
        H[6] = (H[6]+g) & 0xffffffff; 
        H[7] = (H[7]+h) & 0xffffffff; 
    }

    return Sha256.toHexStr(H[0]) + Sha256.toHexStr(H[1]) + Sha256.toHexStr(H[2]) + Sha256.toHexStr(H[3]) + 
           Sha256.toHexStr(H[4]) + Sha256.toHexStr(H[5]) + Sha256.toHexStr(H[6]) + Sha256.toHexStr(H[7]);
};


/**
 * Rotates right (circular right shift) value x by n positions [§3.2.4].
 * @private
 */
Sha256.ROTR = function(n, x) {
    return (x >>> n) | (x << (32-n));
};

/**
 * Logical functions [§4.1.2].
 * @private
 */
Sha256.Σ0  = function(x) { return Sha256.ROTR(2,  x) ^ Sha256.ROTR(13, x) ^ Sha256.ROTR(22, x); };
Sha256.Σ1  = function(x) { return Sha256.ROTR(6,  x) ^ Sha256.ROTR(11, x) ^ Sha256.ROTR(25, x); };
Sha256.σ0  = function(x) { return Sha256.ROTR(7,  x) ^ Sha256.ROTR(18, x) ^ (x>>>3);  };
Sha256.σ1  = function(x) { return Sha256.ROTR(17, x) ^ Sha256.ROTR(19, x) ^ (x>>>10); };
Sha256.Ch  = function(x, y, z) { return (x & y) ^ (~x & z); };
Sha256.Maj = function(x, y, z) { return (x & y) ^ (x & z) ^ (y & z); };


/**
 * Hexadecimal representation of a number.
 * @private
 */
Sha256.toHexStr = function(n) {
    // note can't use toString(16) as it is implementation-dependant,
    // and in IE returns signed numbers when used on full words
    var s="", v;
    for (var i=7; i>=0; i--) { v = (n>>>(i*4)) & 0xf; s += v.toString(16); }
    return s;
};


/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -  */


/** Extend String object with method to encode multi-byte string to utf8
 *  - monsur.hossa.in/2012/07/20/utf-8-in-javascript.html */
if (typeof String.prototype.utf8Encode == 'undefined') {
    String.prototype.utf8Encode = function() {
        return unescape( encodeURIComponent( this ) );
    };
}

/** Extend String object with method to decode utf8 string to multi-byte */
if (typeof String.prototype.utf8Decode == 'undefined') {
    String.prototype.utf8Decode = function() {
        try {
            return decodeURIComponent( escape( this ) );
        } catch (e) {
            return this; // invalid UTF-8? return as-is
        }
    };
}


/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -  */
if (typeof module != 'undefined' && module.exports) module.exports = Sha256; // CommonJs export
if (typeof define == 'function' && define.amd) define([], function() { return Sha256; }); // AMD
