//	Nero v1.1.1, Copyright 2014, Joe Mottershaw, https://github.com/joemottershaw/
//	==============================================================================

//	Table of Contents
//	==================================================
//		#Navigation Dropdown
//		#Tipsy
//		#FitVids
//		#Litebox
//		#Quantity Steps
//		#Wishlist
//		#Login
//		#Password Input
//		#Address
//		#Void Links
//		#Scrolling
//		#Query String Variables


//	#Navigation Dropdown
//	==================================================

	$(document).ready(function() {

		$('#click-nav .nav-item.has-dropdown').click(function(e) {
			e.preventDefault();

			var subNav = $(this).attr('data-sub-nav');

			$('#click-nav .has-dropdown-icon').html('+');

			if ($(this).hasClass('active')) {
				$(this).removeClass('active');
				$('#secondary-navigation').slideUp(500, 'easeInQuint', function() {
					$('#secondary-navigation .sub-nav').hide();
				});
			} else {
				$('.has-dropdown-icon', this).html('-');
				$('#click-nav .nav-item.has-dropdown.active').removeClass('active');
				$(this).addClass('active');
				$('#secondary-navigation .sub-nav').hide();
				$('#secondary-navigation').slideDown(500, 'easeOutQuint', function(){
					$('#secondary-navigation .sub-nav#' + subNav).show();
				});
			}
		});

		$('#touch-nav .toggle-icon').on('click', function(e) {
			e.preventDefault();
			
			$(this).next('.slide-menu').stop().slideToggle();
		});

		$('#touch-nav .nav-item .parent-link').on('click', function(e) {
			e.preventDefault();

			$(this).next('.sub-nav').stop().slideToggle(500, 'easeInOutQuint');

			$(this).toggleClass('active');

			if ($(this).hasClass('active')) {
				$('.has-dropdown-icon', this).html('-');
			} else {
				$('.has-dropdown-icon', this).html('+');
			}
		});
	});


//	#Tipsy
//	==================================================

	$(document).ready(function() {
		// Show/Hide
			$('.tip-tl').tipsy({ gravity: 'se', html: true, title: 'data-tooltip', offset: 5, live: true });
			$('.tip-t').tipsy({ gravity: 's', html: true, title: 'data-tooltip', offset: 5, live: true });
			$('.tip-tr').tipsy({ gravity: 'sw', html: true, title: 'data-tooltip', offset: 5, live: true });
			$('.tip-r').tipsy({ gravity: 'w', html: true, title: 'data-tooltip', offset: 5, live: true });
			$('.tip-br').tipsy({ gravity: 'nw', html: true, title: 'data-tooltip', offset: 5, live: true });
			$('.tip-b').tipsy({ gravity: 'n', html: true, title: 'data-tooltip', offset: 5, live: true });
			$('.tip-bl').tipsy({ gravity: 'ne', html: true, title: 'data-tooltip', offset: 5, live: true });
			$('.tip-l').tipsy({ gravity: 'e', html: true, title: 'data-tooltip', offset: 5, live: true });

		// Fade In/Out
			$('.tip-tl-fade').tipsy({ gravity: 'se', html: true, title: 'data-tooltip', offset: 5, fade: true, live: true });
			$('.tip-t-fade').tipsy({ gravity: 's', html: true, title: 'data-tooltip', offset: 5, fade: true, live: true });
			$('.tip-tr-fade').tipsy({ gravity: 'sw', html: true, title: 'data-tooltip', offset: 5, fade: true, live: true });
			$('.tip-r-fade').tipsy({ gravity: 'w', html: true, title: 'data-tooltip', offset: 5, fade: true, live: true });
			$('.tip-br-fade').tipsy({ gravity: 'nw', html: true, title: 'data-tooltip', offset: 5, fade: true, live: true });
			$('.tip-b-fade').tipsy({ gravity: 'n', html: true, title: 'data-tooltip', offset: 5, fade: true, live: true });
			$('.tip-bl-fade').tipsy({ gravity: 'ne', html: true, title: 'data-tooltip', offset: 5, fade: true, live: true });
			$('.tip-l-fade').tipsy({ gravity: 'e', html: true, title: 'data-tooltip', offset: 5, fade: true, live: true });
	});


//	#FitVids
//	==================================================

	$(document).ready(function() {
		$('body').fitVids();
	});


//	#Litebox
//	==================================================

	$(document).ready(function() {
		$('.litebox').liteBox();
	});


//	#Quantity Steps
//	==================================================

	// Set as function for Shopify Quick Look init

	function initQtySteps() {
		$('.input-quantity-minus').on('click', function(e) {
			e.preventDefault();
			
			var	input = $(this).next('input'),
				inputQty = parseInt($(input).val()),
				min = parseInt($(input).attr('data-qty-min')),
				step = parseInt($(input).attr('data-qty-step'));

			if (!min || min == '') min = 1;
			if (!step || step == '') step = 1;

			var	qty = (inputQty - step);

			if (inputQty % 1 != 0) qty = 1;

			if (qty >= min) $(input).val(qty);
		});

		$('.input-quantity-plus').on('click', function(e) {
			e.preventDefault();
			
			var input = $(this).prev('input'),
				inputQty = parseInt($(input).val()),
				max = parseInt($(input).attr('data-qty-max')),
				step = parseInt($(input).attr('data-qty-step'));

			if (!max || max == '') max = 9999;
			if (!step || step == '') step = 1;

			var	qty = (inputQty + step);

			if (inputQty % 1 != 0) qty = 1;

			if (qty <= max) {
				$(input).val(qty);
			} else {
				$('body').edgeAlerts({
					title: 'Update Error',
					message: 'There are only ' + max + ' of these available.'
				});
			}
		});
	}

	$(document).ready(function() {
		initQtySteps();
	});


//	#Wishlist
//	==================================================

	function removeTag(tagID, productTitle, productID) {
		$('#remove-value-' + productID).val(tagID);

		$('body').edgeAlerts({
			type: 'confirm',
			title: productTitle,
			message: 'Are you sure you wish to remove this item?',
			cancelText: 'No',
			continueText: 'Yes',
			callbackConfirm: function() {
				$('#remove-from-wishlist-' + productID).submit();
			}
		});
	}

	$(document).ready(function() {
		$('#product-page-add-to-wishlist').on('click', function(e) {
			e.preventDefault();

			$(this).parents('form').submit();
		});
	});


//	#Login
//	==================================================

	function showForgotPasswordForm() {
		window.location.hash = '#recover';

		$('#customer-login-breadcrumb-header, #customer-login-breadcrumb, #customer-login-form, #recover-show').addClass('no-display');
		$('#customer-recover-breadcrumb-header, #customer-recover-breadcrumb, #customer-recover-form, #recover-hide').removeClass('no-display');

		return false;
	}

	function hideForgotPasswordForm() {
		window.location.hash = '#login';

		$('#customer-login-breadcrumb-header, #customer-login-breadcrumb, #customer-login-form, #recover-show').removeClass('no-display');
		$('#customer-recover-breadcrumb-header, #customer-recover-breadcrumb, #customer-recover-form, #recover-hide').addClass('no-display');

		return false;
	}

	$(document).ready(function() {
		$('#recover-show').on('click', function(e) {
			e.preventDefault();

			showForgotPasswordForm();
		});

		$('#recover-hide').on('click', function(e) {
			e.preventDefault();

			hideForgotPasswordForm();
		});


		if (window.location.hash == '#recover')
			showForgotPasswordForm();
	});


//	#Password Input
//	==================================================

	$(document).ready(function() {
		$('.fake-password').focus(function() {
			$(this).hide().next('input').removeClass('no-display').focus();
		});

		$('.true-password').blur(function() {
			var truePassword = $(this).val();

			if (!truePassword.length) $(this).addClass('no-display').focus().prev('input').show();
		});
	});


//	#Address
//	==================================================

	$(document).ready(function() {
		$('.add-address').on('click', function() {
			$('#add-address').toggleClass('no-display');
		});

		$('.edit-address').on('click', function() {
			var id = $(this).attr('data-address-id');

			$('#edit-address-' + id).toggleClass('no-display');
		});

		$('.delete-address').on('click', function() {
			var id = $(this).attr('data-address-id');

			$('body').edgeAlerts({
				type: 'confirm',
				title: 'Delete Address',
				message: 'Are you sure you want to delete this address?',
				cancelText: 'No',
				continueText: 'Yes',
				callbackConfirm: function() {
					Shopify.postLink('/account/addresses/'+ id, { 'parameters': { '_method': 'delete' } });
				}
			});
		});
	});


//	#Void Links
//	==================================================

	$(document).ready(function() {
		$('.void-link').on('click', function(e) {
			e.preventDefault();
		});
	});


//	#Scrolling
//	==================================================

	$(function() {
		$('a[href*=#]:not([href=#])').on('click', function() {
			if ($(this).parents('.responsive-tabs').length === 0) {
				if (location.pathname.replace(/^\//,'') == this.pathname.replace(/^\//,'') && location.hostname == this.hostname) {
					var target = $(this.hash);

					target = target.length ? target : $('[name=' + this.hash.slice(1) +']');

					if (target.length) 
						$('html, body').animate({ scrollTop: target.offset().top - 40 }, 1400, 'easeInOutQuart');
						return false;
				}
			}
		});
	});

	$(window).scroll(function () {
		if ($(this).scrollTop() > 200)
			$('.scroll-to-top').addClass('active');
		else
			$('.scroll-to-top').removeClass('active');

		$('.tipsy').fadeOut(200, function() {
			$(this).remove();
		})
	});

	$(document).ready(function() {
		$('.scroll-to-top').on('click', function() {
			$('html, body').animate({ scrollTop: 0 }, 1600, 'easeInOutQuart');
			return false;
		});

		if (window.location.hash == '#article-comments') {
			$('html, body').animate({ scrollTop: $('#article-comments').offset().top - 40 }, 1400, 'easeInOutQuart');
			return false;
		}

		if (window.location.hash == '#post-comment') {
			$('html, body').animate({ scrollTop: $('#post-comment').offset().top - 40 }, 1400, 'easeInOutQuart');
			return false;
		}

		$('#cart-scroll a').click(function () {
			$('html, body').animate({ scrollTop: $('#cart-scroll-to').offset().top - 40 }, 1400, 'easeInOutQuart');
			return false;
		});

		if (window.location.hash == '#contact-post') {
			$('html, body').animate({ scrollTop: $('#contact-post').offset().top - 40 }, 1400, 'easeInOutQuart');
			return false;
		}
	});


//	#Query String Variables
//	==================================================

	function getQueryVariable(variable) {
		var query = window.location.search.substring(1);
		var vars = query.split("&");

		for (var i=0; i<vars.length; i++) {
			var pair = vars[i].split("=");

			if (pair[0] == variable)
				return pair[1];
		}

		return(false);
	}