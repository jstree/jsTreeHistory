<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" autoFlush="true"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ taglib tagdir="/WEB-INF/tags" prefix="customTags"%>

<!DOCTYPE html> 
<html lang="ko-KR">
<head>
<style>
</style>

<!-- JavaScript neccessary for the tree -->
<script type="text/javascript">
// <![CDATA[
$(document).ready(function($){

});
// ]]>
</script>
</head> 

<body id="demo_body">
	<div class="quick-look-markup">
		<form action="/cart/add" method="post" enctype="multipart/form-data" novalidate="">
			<div class="two-third-percent omega bm-remove">
				<h3 class="quick-look-title bm-small"><a href="/products/blogger-cropped-top-t-shirt" target="_self">#blogger Cropped Top T-Shirt</a></h3>
			</div>
			<div class="one-third-percent alpha bm-remove last">
				<h3 class="quick-look-price bm-small text-right"><small>From </small>${actionTarget}</h3>
			</div>

			<hr>

			<div class="clearfix">
				<div class="one-third-percent omega bm-remove">
					<div class="quick-look-image"><div id="quick-look-images-carousel-container" class="clearfix"><div id="quick-look-images-carousel" class="owl-carousel owl-theme" style="opacity: 1; display: block;"><div class="owl-wrapper-outer"><div class="owl-wrapper" style="width: 1944px; left: 0px; display: block; transition: all 500ms ease; transform: translate3d(-729px, 0px, 0px);"><div class="owl-item" style="width: 243px;"><div class="item"><a href="/products/blogger-cropped-top-t-shirt" target="_self" class="quick-look-featured-image text-center block"><img src="//cdn.shopify.com/s/files/1/0522/9261/products/blogger-cropped-top-tshirt-003.jpg?v=1404046432" class="block"></a></div></div><div class="owl-item" style="width: 243px;"><div class="item"><a href="/products/blogger-cropped-top-t-shirt" target="_self" class="quick-look-featured-image text-center block"><img src="//cdn.shopify.com/s/files/1/0522/9261/products/blogger-cropped-top-tshirt-004.jpg?v=1404046432" class="block"></a></div></div><div class="owl-item" style="width: 243px;"><div class="item"><a href="/products/blogger-cropped-top-t-shirt" target="_self" class="quick-look-featured-image text-center block"><img src="//cdn.shopify.com/s/files/1/0522/9261/products/blogger-cropped-top-tshirt-002.jpg?v=1404046432" class="block"></a></div></div><div class="owl-item" style="width: 243px;"><div class="item"><a href="/products/blogger-cropped-top-t-shirt" target="_self" class="quick-look-featured-image text-center block"><img src="//cdn.shopify.com/s/files/1/0522/9261/products/blogger-cropped-top-tshirt-001.jpg?v=1404046432" class="block"></a></div></div></div></div><div class="owl-controls clickable"><div class="owl-pagination"><div class="owl-page"><span class=""></span></div><div class="owl-page"><span class=""></span></div><div class="owl-page"><span class=""></span></div><div class="owl-page active"><span class=""></span></div></div></div></div><div class="prev tip-t-fade" data-tooltip="Previous"></div><div class="next tip-t-fade" data-tooltip="Next"></div></div></div>
					<div class="quick-look-spacer"></div>
				</div>

				<div class="two-third-percent alpha bm-remove last">
					<div class="quick-look-description bm-medium"><p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean ac egestas odio. Quisque nec sem eu nisl ornare interdum. Praesent eget scelerisque lorem. Sed vel nisi aliquet nisl iaculis porttitor ac at massa. Cras tempor, enim sed aliquet posuere, libero sapien adipiscing tortor, id pretium...</p></div>
					
					<div class="quick-look-available clearfix">
						<div class="quick-look-variants">
							<div class="one-third-percent bm-remove omega">
								<p class="text-right" style="line-height: 40px;"><label for="quick-look-variants" class="bm-remove">Options</label></p>
							</div>
							<div class="two-third-percent bm-remove alpha last">
								<div class="quick-look-option-variant"><select name="id" id="quick-look-variants" class="w-full"><option value="728596859">Small - £10.00</option><option value="728596863">Medium - £10.00</option><option value="728596867">Large - £10.00</option></select></div>
							</div>
						</div>

						
							<div class="one-third-percent bm-remove omega">
								<p class="text-right" style="line-height: 40px;"><label for="quick-look-quantity" class="bm-remove">Quantity</label></p>
							</div>
							<div class="two-third-percent bm-remove alpha last">
								<div class="input-quantity-container clearfix">
									<a href="#" target="_self" class="input-quantity-minus tip-t-fade" data-tooltip="Decrease"><i class="fa fa-minus fa-fw"></i></a>
									<input type="text" name="quantity" id="quick-look-quantity" class="input-quantity" value="1">
									<a href="#" target="_self" class="input-quantity-plus tip-t-fade" data-tooltip="Increase"><i class="fa fa-plus fa-fw"></i></a>
								</div>
							</div>
						

						<button type="button" class="bm-remove float-right quick-look-add-to-cart">Add To Cart</button>
					</div>
					
					<div class="quick-look-not-available clearfix" style="display: none;">
						<button type="button" class="disabled bm-remove float-right">Sold Out</button>
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html> 