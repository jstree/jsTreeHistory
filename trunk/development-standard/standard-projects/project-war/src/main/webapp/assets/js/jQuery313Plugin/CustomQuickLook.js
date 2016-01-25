//	Shopify QuickLook v1.0, Copyright 2014, Joe Mottershaw, https://github.com/joemottershaw/
//	=========================================================================================

! function(o) {
    function e(e, n) {
        this.element = e, 
        this.$element = o(this.element), 
        this.options = o.extend({}, i, n), 
        this._defaults = i, 
        this._name = t, 
        this.init()
    }
    var t = "customQuickLook",
        i = {
            width: 800,
            revealSpeed: 400,
            background: "rgba(0,0,0,.8)",
            overlayClose: !0,
            escKey: !0,
            markupContainer: ".quick-look-markup",
            adjustScroll: !1,
            closeTip: "tip-l-fade",
            closeTipText: "Close",
            callbackInit: function() {},
            callbackBeforeOpen: function() {},
            callbackAfterOpen: function() {},
            callbackBeforeClose: function() {},
            callbackAfterClose: function() {}
        };
    e.prototype = {
        init: function() {
            var e = this;
            this.$element.on("click", function(t) {
                t.preventDefault();
                var i = o(this).attr("data-quick-look-handle");
                e.openQuickLook(i);
            }), this.options.callbackInit.call(this)
        },
        openQuickLook: function(e,contentCallBack) {
            var t = this,
            	content = null;
            this.options.callbackBeforeOpen.call(this);
            
            if(this.options.render && o.isFunction(this.options.render)){
            	var renderFn = this.options.render;
            	if(e){
            		var server = o.ajax({
            			dataType : "json",
            			url : e+".json",
            			async : false
            		})
            		.done(function(data){
            			content = renderFn(data);
            		});
            	}else{
            		content = renderFn();
            	}
            	
            }else{
            	Shopify.getProduct(e),
            	content = o(this.options.markupContainer).clone();
            }
            
            $overlay = o("<div>", {
                "class": "shopify-quick-look-overlay"
            }), 
            $close = o("<div>", {
                "class": "shopify-quick-look-close " + this.options.closeTip,
                "data-tooltip": this.options.closeTipText
            }), 
            $container = o("<div>", {
                "class": "shopify-quick-look-container"
            }), 
            this.options.adjustScroll && o("body").addClass("no-scroll"), 
            o("body").prepend($overlay.css({
                "background-color": this.options.background
            }).append($close).append($container.css({
                width: this.options.width
            }).append(content))), $container.animate({
                top: "0"
            }, 400).fadeIn({
                queue: !1,
                duration: 400
            }), 
            $overlay.fadeIn(this.options.revealSpeed), keyEsc = 27, t.options.overlayClose && $overlay.on("click", function(o) {
                o.target === this && t.closeQuickLook()
            }), 
            $close.on("click", function() {
                t.closeQuickLook()
            }), 
            o("body").off("keyup").on("keyup", function(o) {
                t.options.escKey && o.keyCode == keyEsc && t.closeQuickLook()
            }), this.options.callbackAfterOpen.call(this)
        },
        closeQuickLook: function() {
            this.options.callbackBeforeClose.call(this), $container.animate({
                top: "-200px"
            }, 400).fadeOut({
                queue: !1,
                duration: 400
            }), this.options.adjustScroll && o("body").removeClass("no-scroll"), $overlay.fadeOut(this.options.revealSpeed, function() {
                $container.empty().remove(), $overlay.empty().remove()
            }), o(".tipsy").fadeOut(this.options.revealSpeed, function() {
                o(this).remove()
            }), this.options.callbackAfterClose.call(this)
        }
    }, o.fn[t] = function(i) {
        return this.each(function() {
            o.data(this, t) || o.data(this, t, new e(this, i))
        })
    }
}(jQuery, window, document);