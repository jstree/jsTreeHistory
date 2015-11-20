$(document).ready(
		function() {
			var _openedMenu = "";
			// responsive menu icon click//
			$("#responsive-menu").click(function() {
				$("#responsive-admin-menu #menu").slideToggle();
			});
			// responsive menu icon click//

			// responsive remove style
			$(window).resize(function() {
				$("#responsive-admin-menu #menu").removeAttr("style");
			});
			// responsive remove style

			// sub menu open / close
			$("#menu a.submenu").click(function() {
				if (_openedMenu != "") {
					$("#" + _openedMenu).prev("a").removeClass("downarrow");
					$("#" + _openedMenu).slideUp("fast");
				}
				if (_openedMenu == $(this).attr("name")) {
					$("#" + $(this).attr("name")).slideUp("fast");
					$(this).removeClass("downarrow");
					_openedMenu = "";
				} else {
					$("#" + $(this).attr("name")).slideDown("fast");
					_openedMenu = $(this).attr("name");
					$(this).addClass("downarrow");
				}
				return false;
			});
			// sub menu open / close

			// window 로드, 리사이징시 margin left 조절
			var quickMenu = $("#responsive-admin-menu");
			$(window).on(
					'resize load',
					function() {
						var quickWidth = quickMenu.outerWidth();
						($(this).width() < 980) ? $(".page-border").css(
								'marginLeft', '0') : $(".page-border").css(
								'marginLeft', quickWidth);
					});
		});
// 2015-06-22 : 네비 스크롤
$(document).ready(function() {
	mobileAdminNavHeight();
});
function mobileAdminNavHeight() {
	$('#responsive-admin-menu').css('max-height', $(window).height());
	$('#responsive-admin-menu').on('mouseover', function() {
		$(this).focus();
	});
	$('#responsive-admin-menu').on('mouseout', function() {
		$(this).blur();
	});
}
