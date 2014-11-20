<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="ko" class="no-js">
<!--<![endif]-->
<head></head>
<body>
	<div class="no-display">
		<div class="quick-look-markup">
			<form action="/cart/add" method="post" enctype="multipart/form-data" novalidate>
				<div class="two-third-percent omega bm-remove">
					<h3 class="quick-look-title bm-small"></h3>
				</div>
				<div class="one-third-percent alpha bm-remove last">
					<h3 class="quick-look-price bm-small text-right"></h3>
				</div>
				<hr />
				<div class="clearfix">
					<div class="one-third-percent omega bm-remove">
						<div class="quick-look-image"></div>
						<div class="quick-look-spacer"></div>
					</div>
					<div class="two-third-percent alpha bm-remove last">
						<div class="quick-look-description bm-medium"></div>
						<div class="quick-look-available clearfix">
							<div class="quick-look-variants">
								<div class="one-third-percent bm-remove omega">
									<p class="text-right" style="line-height: 40px;">
										<label for="quick-look-variants" class="bm-remove">Options</label>
									</p>
								</div>
								<div class="two-third-percent bm-remove alpha last">
									<div class="quick-look-option-variant"></div>
								</div>
							</div>
							<div class="one-third-percent bm-remove omega">
								<p class="text-right" style="line-height: 40px;">
									<label for="quick-look-quantity" class="bm-remove">Quantity</label>
								</p>
							</div>
							<div class="two-third-percent bm-remove alpha last">
								<div class="input-quantity-container clearfix">
									<a href="#" target="_self" class="input-quantity-minus tip-t-fade" data-tooltip="Decrease"><i class="fa fa-minus fa-fw"></i></a>
									<input type="text" name="quantity" id="quick-look-quantity" class="input-quantity" value="1" class="w-full" /> <a href="#" target="_self" class="input-quantity-plus tip-t-fade" data-tooltip="Increase"><i class="fa fa-plus fa-fw"></i></a>
								</div>
							</div>
							<button type="button" class="bm-remove float-right quick-look-add-to-cart">Add To Cart</button>
						</div>
						<div class="quick-look-not-available clearfix">
							<button type="button" class="disabled bm-remove float-right no-display">Sold Out
							</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
