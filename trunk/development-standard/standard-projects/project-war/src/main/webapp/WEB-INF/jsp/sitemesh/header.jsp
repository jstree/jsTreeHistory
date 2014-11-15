<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="ko" class="no-js">
<!--<![endif]-->
	<head></head>
	<body>
		<header class="clearfix">
			<div id="header" class="container">
				<div id="header-search" class="one-third bm-remove">
					<form action="/search" method="get" class="clearfix" novalidate>
						<input type="hidden" name="type" value="product">
						<input type="text" name="q" class="inline-block w-small bm-remove tip-r-fade" placeholder="KEYWORD SEARCH" autocomplete="off" value="" data-tooltip="Press Enter To Search" />
						<button type="submit" class="tablet-mobile bm-remove tip-r-fade" data-tooltip="Search">
						<i class="fa fa-search"></i>
						</button>
					</form>
				</div>
				<div id="header-logo" class="one-third bm-remove">
					<a href="/" target="_self">
						<img src="${pageContext.request.contextPath}/assets/logo.jpg" alt="313 developer group logo">
					</a>
				</div>
				<div id="header-cart" class="one-third bm-remove last">
					<a href="/cart" target="_self"><i class="fa fa-shopping-cart fa-fw"></i> Login (<span id="ajax-header-cart-item-count">0</span> <span id="ajax-header-cart-item-text">items</span> - <span id="ajax-header-cart-total-price">£0.00</span>)</a>
				</div>
			</div>
		</header>	
	</body>
</html>
