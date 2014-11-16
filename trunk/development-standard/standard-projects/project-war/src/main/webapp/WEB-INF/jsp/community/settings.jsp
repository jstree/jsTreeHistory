<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!-- Nero v1.1.1, Copyright 2014, Cloud Eight, http://www.cloud-eight.com
========================================================================= -->

<!-- Table of Contents
==================================================
	 #General
	 #Typography
	 #Forms
	 #Header
	 #Frontpage
	 #Collection Listing
	 #Product Listing
	 #Search
	 #Product
	 #Blogs and Articles
	 #Contact Us
	 #Cart
	 #Footer
	 #Checkout
	 #Animations
	 #Miscellaneous

-->

	<h2>
		Nero v1.1.1 by Cloud Eight -
		<a href="http://www.cloud-eight.com/docs/themes/shopify/nero/v1.1.1" target="_blank">Documentation</a> /
		<a href="http://www.cloud-eight.com/themes/shopify/nero/#support" target="_blank">Support</a>
	</h2>


<!-- #General
================================================== -->

	<fieldset>

		<legend>General</legend>

			<!-- Page Styles -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Page Styles</strong></h3></td>
					</tr>
					<tr>
						<td><label for="primary_color">Primary Color</label></td>
						<td><input type="text" name="primary_color" id="primary_color" class="color" value="#f45b4f" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					</tr>
					<tr>
						<td><label for="bg_color">Background Color</label></td>
						<td><input type="text" name="bg_color" id="bg_color" class="color" value="#ffffff" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					</tr>
					<tr>
						<td><label for="body_border_size">Page Border</label></td>
						<td>
							<input type="text" name="body_border_size" id="body_border_size" size="5" value="10" /> <sub>px</sub>&nbsp;
							<input type="text" name="body_border_color" id="body_border_color" class="color" value="#e8e8e8" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</td>
					</tr>
					<tr>
						<td></td>
						<td><small>Width and color</small></td>
					</tr>
				</table>

				<br />

			<!-- Grid Content Boxes -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Grid Content Boxes</strong></h3></td>
					</tr>
					<tr>
						<td><label for="grid_boxed_bg_color">Background</label></td>
						<td class="lh-match-input">
							<input type="text" name="grid_boxed_bg_color" id="grid_boxed_bg_color" class="color" value="#ffffff" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</td>
					</tr>
					<tr>
						<td><label for="grid_boxed_padding">Padding</label></td>
						<td>
							<select name="grid_boxed_padding" id="grid_boxed_padding">
								<option value="p-remove">0px</option>
								<option value="p-ten">10px</option>
								<option value="p-twenty" selected="selected">20px</option>
								<option value="p-thirty">30px</option>
								<option value="p-fourty">40px</option>
								<option value="p-fifty">50px</option>
							</select>
						</td>
					</tr>
					<tr>
						<td><label for="grid_boxed_border_top_size">Border</label></td>
						<td>
							<input type="text" name="grid_boxed_border_top_size" id="grid_boxed_border_top_size" size="5" value="1" /> <sub>px</sub>&nbsp;
							<input type="text" name="grid_boxed_border_right_size" id="grid_boxed_border_right_size" size="5" value="1" /> <sub>px</sub>&nbsp;
							<input type="text" name="grid_boxed_border_bottom_size" id="grid_boxed_border_bottom_size" size="5" value="1" /> <sub>px</sub>&nbsp;
							<input type="text" name="grid_boxed_border_left_size" id="grid_boxed_border_left_size" size="5" value="1" /> <sub>px</sub>&nbsp;
						</td>
					</tr>
					<tr>
						<td></td>
						<td>
							<input type="text" name="grid_boxed_border_top_left_radius" id="grid_boxed_border_top_left_radius" size="5" value="0" /> <sub>px</sub>&nbsp;
							<input type="text" name="grid_boxed_border_top_right_radius" id="grid_boxed_border_top_right_radius" size="5" value="0" /> <sub>px</sub>&nbsp;
							<input type="text" name="grid_boxed_border_bottom_right_radius" id="grid_boxed_border_bottom_right_radius" size="5" value="0" /> <sub>px</sub>&nbsp;
							<input type="text" name="grid_boxed_border_bottom_left_radius" id="grid_boxed_border_bottom_left_radius" size="5" value="0" /> <sub>px</sub>&nbsp;
						</td>
					</tr>
					<tr>
						<td></td>
						<td>
							<select name="grid_boxed_border_style" id="grid_boxed_border_style">
								<option value="solid" selected="selected">Solid</option>
								<option value="dotted">Dotted</option>
								<option value="dashed">Dashed</option>
								<option value="double">Double</option>
							</select>
							<input type="text" name="grid_boxed_border_color" id="grid_boxed_border_color" class="color" value="#e8e8e8" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</td>
					</tr>
					<tr>
						<td></td>
						<td>
							<small>
								Top Width, Right Width, Bottom Width and Left Width<br />
								Top Left Radius, Top Right Radius, Bottom Right Radius and Bottom Left Radius<br />
								Style and Color<br /><br />
							</small>
						</td>
					</tr>
				</table>

				<br />

	</fieldset>


<!-- #Typography
================================================== -->

	<fieldset>

		<legend>Typography</legend>

			<!-- Body -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Body</strong></h3></td>
					</tr>
					<tr>
						<td><label for="body_font_web_safe">Font</label></td>
						<td>
							<select name="body_font_web_safe" id="body_font_web_safe">
								<optgroup label="Sans-serif">
									<option value="Helvetica, Arial, sans-serif">Helvetica/Arial</option>
									<option value="Impact, Charcoal, Helvetica, Arial, sans-serif">Impact</option>
									<option value="'Lucida Grande', 'Lucida Sans Unicode', 'Lucida Sans', Lucida, Helvetica, Arial, sans-serif">Lucida Grande</option>
									<option value="Trebuchet MS, sans-serif">Trebuchet MS</option>
									<option value="Verdana, Helvetica, Arial, sans-serif">Verdana</option>
								</optgroup>
								<optgroup label="Serif">
									<option value="Garamond, Baskerville, Caslon, serif">Garamond</option>
									<option value="Georgia, Utopia, 'Times New Roman', Times, serif">Georgia</option>
									<option value="Palatino, 'Palatino Linotype', 'Book Antiqua', serif">Palatino</option>
									<option value="'Times New Roman', Times, serif">Times New Roman</option>
								</optgroup>
								<optgroup label="Monospace">
									<option value="'Courier New', Courier, monospace">Courier New</option>
									<option value="Monaco, 'Lucida Console', 'DejaVu Sans Mono', monospace">Monaco/Lucida Console</option>
								</optgroup>
								<optgroup label="Other">
									<option value="" selected="selected">Google Web Font</option>
								</optgroup>
							</select>
							<input type="text" name="body_font_google" id="body_font_google" value="Oxygen" />
							<select name="body_font_google_type" id="body_font_google_type">
								<option value="sans-serif" selected="selected">Sans Serif</option>
								<option value="serif">Serif</option>
								<option value="monospace">MonoSpace</option>
								<option value="cursive">Cursive</option>
							</select>
						</td>
					</tr>
					<tr>
						<td></td>
						<td>
							<input type="text" name="body_font_color" id="body_font_color" class="color" value="#474747" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="text" name="body_font_size" id="body_font_size" size="5" value=".8" /> <sub>em</sub>&nbsp;
							<select name="body_font_weight" id="body_font_weight">
								<option value="100">Thin</option>
								<option value="200">Extra Light</option>
								<option value="300">Light</option>
								<option value="400" selected="selected">Normal</option>
								<option value="500">Medium</option>
								<option value="600">Semi Bold</option>
								<option value="700">Bold</option>
								<option value="800">Extra Bold</option>
								<option value="900">Ultra Bold</option>
							</select>
							<input type="text" name="body_font_line_height" id="body_font_line_height" size="5" value="1.8" /> <sub>em</sub>&nbsp;
						</td>
					</tr>
					<tr>
						<td></td>
						<td><small>Web Safe, Google Font, Google Font Type, Color, Size, Weight and Line Height</small></td>
					</tr>
				</table>

				<br />

			<!-- Links -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Links</strong></h3></td>
					</tr>
					<tr>
						<td class="va-t"><label for="link_color">Color</label></td>
						<td>
							<input type="text" name="link_color" id="link_color" class="color" value="#f45b4f" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="text" name="link_color_hover" id="link_color_hover" class="color" value="#f56558" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</td>
					</tr>
					<tr>
						<td></td>
						<td><small>Color and Hover Color</small></td>
					</tr>
				</table>

				<br />

			<!-- Horizontal Rule -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Horizontal Rule</strong></h3></td>
					</tr>
					<tr>
						<td><label for="horizontal_rule_size">Style</label></td>
						<td>
							<input type="text" name="horizontal_rule_size" id="horizontal_rule_size" size="5" value="1" /> <sub>px</sub>&nbsp;
							<select name="horizontal_rule_style" id="horizontal_rule_style">
								<option value="solid" selected="selected">Solid</option>
								<option value="dotted">Dotted</option>
								<option value="dashed">Dashed</option>
								<option value="double">Double</option>
							</select>
							<input type="text" name="horizontal_rule_color" id="horizontal_rule_color" class="color" value="#e8e8e8" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</td>
					</tr>
					<tr>
						<td></td>
						<td><small>Size, Style and Color</small></td>
					</tr>
				</table>

				<br />

			<!-- Headers -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Headers</strong></h3></td>
					</tr>

					<!-- Special Header -->
						<tr>
							<td><label for="special_header_font_web_safe">Special Header</label></td>
							<td>
								<select name="special_header_font_web_safe" id="special_header_font_web_safe">
									<optgroup label="Sans-serif">
										<option value="Helvetica, Arial, sans-serif">Helvetica/Arial</option>
										<option value="Impact, Charcoal, Helvetica, Arial, sans-serif">Impact</option>
										<option value="'Lucida Grande', 'Lucida Sans Unicode', 'Lucida Sans', Lucida, Helvetica, Arial, sans-serif">Lucida Grande</option>
										<option value="Trebuchet MS, sans-serif">Trebuchet MS</option>
										<option value="Verdana, Helvetica, Arial, sans-serif">Verdana</option>
									</optgroup>
									<optgroup label="Serif">
										<option value="Garamond, Baskerville, Caslon, serif">Garamond</option>
										<option value="Georgia, Utopia, 'Times New Roman', Times, serif">Georgia</option>
										<option value="Palatino, 'Palatino Linotype', 'Book Antiqua', serif">Palatino</option>
										<option value="'Times New Roman', Times, serif">Times New Roman</option>
									</optgroup>
									<optgroup label="Monospace">
										<option value="'Courier New', Courier, monospace">Courier New</option>
										<option value="Monaco, 'Lucida Console', 'DejaVu Sans Mono', monospace">Monaco/Lucida Console</option>
									</optgroup>
									<optgroup label="Other">
										<option value="" selected="selected">Google Web Font</option>
									</optgroup>
								</select>
								<input type="text" name="special_header_font_google" id="special_header_font_google" value="Alegreya Sans" />
								<select name="special_header_font_google_type" id="special_header_font_google_type">
									<option value="sans-serif" selected="selected">Sans Serif</option>
									<option value="serif">Serif</option>
									<option value="monospace">MonoSpace</option>
									<option value="cursive">Cursive</option>
								</select>
							</td>
						</tr>
						<tr>
							<td></td>
							<td>
								<input type="text" name="special_header_font_color" id="special_header_font_color" class="color" value="#f45b4f" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="text" name="special_header_font_size" id="special_header_font_size" size="5" value="2" /> <sub>em</sub>&nbsp;
								<select name="special_header_font_weight" id="special_header_font_weight">
									<option value="100">Thin</option>
									<option value="200">Extra Light</option>
									<option value="300">Light</option>
									<option value="400" selected="selected">Normal</option>
									<option value="500">Medium</option>
									<option value="600">Semi Bold</option>
									<option value="700">Bold</option>
									<option value="800">Extra Bold</option>
									<option value="900">Ultra Bold</option>
								</select>
								<select name="special_header_text_align" id="special_header_text_align">
									<option value="left">Left</option>
									<option value="center" selected="selected">Center</option>
									<option value="right">Right</option>
								</select>
							</td>
						</tr>
						<tr>
							<td></td>
							<td>
								<small>
									Web Safe, Google Font, Google Font Type, Size, Weight and Alignment<br />
									Colors for this Header are generated based on the Body Background Color<br /><br />
								</small>
							</td>
						</tr>

					<!-- Header 1 -->
						<tr>
							<td><label for="h1_font_web_safe">Header 1</label></td>
							<td>
								<select name="h1_font_web_safe" id="h1_font_web_safe">
									<optgroup label="Sans-serif">
										<option value="Helvetica, Arial, sans-serif">Helvetica/Arial</option>
										<option value="Impact, Charcoal, Helvetica, Arial, sans-serif">Impact</option>
										<option value="'Lucida Grande', 'Lucida Sans Unicode', 'Lucida Sans', Lucida, Helvetica, Arial, sans-serif">Lucida Grande</option>
										<option value="Trebuchet MS, sans-serif">Trebuchet MS</option>
										<option value="Verdana, Helvetica, Arial, sans-serif">Verdana</option>
									</optgroup>
									<optgroup label="Serif">
										<option value="Garamond, Baskerville, Caslon, serif">Garamond</option>
										<option value="Georgia, Utopia, 'Times New Roman', Times, serif">Georgia</option>
										<option value="Palatino, 'Palatino Linotype', 'Book Antiqua', serif">Palatino</option>
										<option value="'Times New Roman', Times, serif">Times New Roman</option>
									</optgroup>
									<optgroup label="Monospace">
										<option value="'Courier New', Courier, monospace">Courier New</option>
										<option value="Monaco, 'Lucida Console', 'DejaVu Sans Mono', monospace">Monaco/Lucida Console</option>
									</optgroup>
									<optgroup label="Other">
										<option value="" selected="selected">Google Web Font</option>
									</optgroup>
								</select>
								<input type="text" name="h1_font_google" id="h1_font_google" value="Alegreya Sans" />
								<select name="h1_font_google_type" id="h1_font_google_type">
									<option value="sans-serif" selected="selected">Sans Serif</option>
									<option value="serif">Serif</option>
									<option value="monospace">MonoSpace</option>
									<option value="cursive">Cursive</option>
								</select>
							</td>
						</tr>
						<tr>
							<td></td>
							<td>
								<input type="text" name="h1_font_color" id="h1_font_color" class="color" value="#f45b4f" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="text" name="h1_font_size" id="h1_font_size" size="5" value="2" /> <sub>em</sub>&nbsp;
								<select name="h1_font_weight" id="h1_font_weight">
									<option value="100">Thin</option>
									<option value="200">Extra Light</option>
									<option value="300">Light</option>
									<option value="400" selected="selected">Normal</option>
									<option value="500">Medium</option>
									<option value="600">Semi Bold</option>
									<option value="700">Bold</option>
									<option value="800">Extra Bold</option>
									<option value="900">Ultra Bold</option>
								</select>
							</td>
						</tr>
						<tr>
							<td></td>
							<td><small>Web Safe, Google Font, Google Font Type, Color, Size and Weight<br /><br /></small></td>
						</tr>

					<!-- Header 2 -->
						<tr>
							<td><label for="h2_font_web_safe">Header 2</label></td>
							<td>
								<select name="h2_font_web_safe" id="h2_font_web_safe">
									<optgroup label="Sans-serif">
										<option value="Helvetica, Arial, sans-serif">Helvetica/Arial</option>
										<option value="Impact, Charcoal, Helvetica, Arial, sans-serif">Impact</option>
										<option value="'Lucida Grande', 'Lucida Sans Unicode', 'Lucida Sans', Lucida, Helvetica, Arial, sans-serif">Lucida Grande</option>
										<option value="Trebuchet MS, sans-serif">Trebuchet MS</option>
										<option value="Verdana, Helvetica, Arial, sans-serif">Verdana</option>
									</optgroup>
									<optgroup label="Serif">
										<option value="Garamond, Baskerville, Caslon, serif">Garamond</option>
										<option value="Georgia, Utopia, 'Times New Roman', Times, serif">Georgia</option>
										<option value="Palatino, 'Palatino Linotype', 'Book Antiqua', serif">Palatino</option>
										<option value="'Times New Roman', Times, serif">Times New Roman</option>
									</optgroup>
									<optgroup label="Monospace">
										<option value="'Courier New', Courier, monospace">Courier New</option>
										<option value="Monaco, 'Lucida Console', 'DejaVu Sans Mono', monospace">Monaco/Lucida Console</option>
									</optgroup>
									<optgroup label="Other">
										<option value="" selected="selected">Google Web Font</option>
									</optgroup>
								</select>
								<input type="text" name="h2_font_google" id="h2_font_google" value="Alegreya Sans" />
								<select name="h2_font_google_type" id="h2_font_google_type">
									<option value="sans-serif" selected="selected">Sans Serif</option>
									<option value="serif">Serif</option>
									<option value="monospace">MonoSpace</option>
									<option value="cursive">Cursive</option>
								</select>
							</td>
						</tr>
						<tr>
							<td></td>
							<td>
								<input type="text" name="h2_font_color" id="h2_font_color" class="color" value="#f45b4f" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="text" name="h2_font_size" id="h2_font_size" size="5" value="1.8" /> <sub>em</sub>&nbsp;
								<select name="h2_font_weight" id="h2_font_weight">
									<option value="100">Thin</option>
									<option value="200">Extra Light</option>
									<option value="300">Light</option>
									<option value="400" selected="selected">Normal</option>
									<option value="500">Medium</option>
									<option value="600">Semi Bold</option>
									<option value="700">Bold</option>
									<option value="800">Extra Bold</option>
									<option value="900">Ultra Bold</option>
								</select>
							</td>
						</tr>
						<tr>
							<td></td>
							<td><small>Web Safe, Google Font, Google Font Type, Color, Size and Weight<br /><br /></small></td>
						</tr>

					<!-- Header 3 -->
						<tr>
							<td><label for="h3_font_web_safe">Header 3</label></td>
							<td>
								<select name="h3_font_web_safe" id="h3_font_web_safe">
									<optgroup label="Sans-serif">
										<option value="Helvetica, Arial, sans-serif">Helvetica/Arial</option>
										<option value="Impact, Charcoal, Helvetica, Arial, sans-serif">Impact</option>
										<option value="'Lucida Grande', 'Lucida Sans Unicode', 'Lucida Sans', Lucida, Helvetica, Arial, sans-serif">Lucida Grande</option>
										<option value="Trebuchet MS, sans-serif">Trebuchet MS</option>
										<option value="Verdana, Helvetica, Arial, sans-serif">Verdana</option>
									</optgroup>
									<optgroup label="Serif">
										<option value="Garamond, Baskerville, Caslon, serif">Garamond</option>
										<option value="Georgia, Utopia, 'Times New Roman', Times, serif">Georgia</option>
										<option value="Palatino, 'Palatino Linotype', 'Book Antiqua', serif">Palatino</option>
										<option value="'Times New Roman', Times, serif">Times New Roman</option>
									</optgroup>
									<optgroup label="Monospace">
										<option value="'Courier New', Courier, monospace">Courier New</option>
										<option value="Monaco, 'Lucida Console', 'DejaVu Sans Mono', monospace">Monaco/Lucida Console</option>
									</optgroup>
									<optgroup label="Other">
										<option value="" selected="selected">Google Web Font</option>
									</optgroup>
								</select>
								<input type="text" name="h3_font_google" id="h3_font_google" value="Alegreya Sans" />
								<select name="h3_font_google_type" id="h3_font_google_type">
									<option value="sans-serif" selected="selected">Sans Serif</option>
									<option value="serif">Serif</option>
									<option value="monospace">MonoSpace</option>
									<option value="cursive">Cursive</option>
								</select>
							</td>
						</tr>
						<tr>
							<td></td>
							<td>
								<input type="text" name="h3_font_color" id="h3_font_color" class="color" value="#f45b4f" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="text" name="h3_font_size" id="h3_font_size" size="5" value="1.6" /> <sub>em</sub>&nbsp;
								<select name="h3_font_weight" id="h3_font_weight">
									<option value="100">Thin</option>
									<option value="200">Extra Light</option>
									<option value="300">Light</option>
									<option value="400" selected="selected">Normal</option>
									<option value="500">Medium</option>
									<option value="600">Semi Bold</option>
									<option value="700">Bold</option>
									<option value="800">Extra Bold</option>
									<option value="900">Ultra Bold</option>
								</select>
							</td>
						</tr>
						<tr>
							<td></td>
							<td><small>Web Safe, Google Font, google Font Type, Color, Size and Weight<br /><br /></small></td>
						</tr>

					<!-- Header 4 -->
						<tr>
							<td><label for="h4_font_web_safe">Header 4</label></td>
							<td>
								<select name="h4_font_web_safe" id="h4_font_web_safe">
									<optgroup label="Sans-serif">
										<option value="Helvetica, Arial, sans-serif">Helvetica/Arial</option>
										<option value="Impact, Charcoal, Helvetica, Arial, sans-serif">Impact</option>
										<option value="'Lucida Grande', 'Lucida Sans Unicode', 'Lucida Sans', Lucida, Helvetica, Arial, sans-serif">Lucida Grande</option>
										<option value="Trebuchet MS, sans-serif">Trebuchet MS</option>
										<option value="Verdana, Helvetica, Arial, sans-serif">Verdana</option>
									</optgroup>
									<optgroup label="Serif">
										<option value="Garamond, Baskerville, Caslon, serif">Garamond</option>
										<option value="Georgia, Utopia, 'Times New Roman', Times, serif">Georgia</option>
										<option value="Palatino, 'Palatino Linotype', 'Book Antiqua', serif">Palatino</option>
										<option value="'Times New Roman', Times, serif">Times New Roman</option>
									</optgroup>
									<optgroup label="Monospace">
										<option value="'Courier New', Courier, monospace">Courier New</option>
										<option value="Monaco, 'Lucida Console', 'DejaVu Sans Mono', monospace">Monaco/Lucida Console</option>
									</optgroup>
									<optgroup label="Other">
										<option value="" selected="selected">Google Web Font</option>
									</optgroup>
								</select>
								<input type="text" name="h4_font_google" id="h4_font_google" value="Alegreya Sans" />
								<select name="h4_font_google_type" id="h4_font_google_type">
									<option value="sans-serif" selected="selected">Sans Serif</option>
									<option value="serif">Serif</option>
									<option value="monospace">MonoSpace</option>
									<option value="cursive">Cursive</option>
								</select>
							</td>
						</tr>
						<tr>
							<td></td>
							<td>
								<input type="text" name="h4_font_color" id="h4_font_color" class="color" value="#f45b4f" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="text" name="h4_font_size" id="h4_font_size" size="5" value="1.4" /> <sub>em</sub>&nbsp;
								<select name="h4_font_weight" id="h4_font_weight">
									<option value="100">Thin</option>
									<option value="200">Extra Light</option>
									<option value="300">Light</option>
									<option value="400" selected="selected">Normal</option>
									<option value="500">Medium</option>
									<option value="600">Semi Bold</option>
									<option value="700">Bold</option>
									<option value="800">Extra Bold</option>
									<option value="900">Ultra Bold</option>
								</select>
							</td>
						</tr>
						<tr>
							<td></td>
							<td><small>Web Safe, Google Font, Google Font Type, Color, Size and Weight<br /><br /></small></td>
						</tr>

					<!-- Header 5 -->
						<tr>
							<td><label for="h5_font_web_safe">Header 5</label></td>
							<td>
								<select name="h5_font_web_safe" id="h5_font_web_safe">
									<optgroup label="Sans-serif">
										<option value="Helvetica, Arial, sans-serif">Helvetica/Arial</option>
										<option value="Impact, Charcoal, Helvetica, Arial, sans-serif">Impact</option>
										<option value="'Lucida Grande', 'Lucida Sans Unicode', 'Lucida Sans', Lucida, Helvetica, Arial, sans-serif">Lucida Grande</option>
										<option value="Trebuchet MS, sans-serif">Trebuchet MS</option>
										<option value="Verdana, Helvetica, Arial, sans-serif">Verdana</option>
									</optgroup>
									<optgroup label="Serif">
										<option value="Garamond, Baskerville, Caslon, serif">Garamond</option>
										<option value="Georgia, Utopia, 'Times New Roman', Times, serif">Georgia</option>
										<option value="Palatino, 'Palatino Linotype', 'Book Antiqua', serif">Palatino</option>
										<option value="'Times New Roman', Times, serif">Times New Roman</option>
									</optgroup>
									<optgroup label="Monospace">
										<option value="'Courier New', Courier, monospace">Courier New</option>
										<option value="Monaco, 'Lucida Console', 'DejaVu Sans Mono', monospace">Monaco/Lucida Console</option>
									</optgroup>
									<optgroup label="Other">
										<option value="" selected="selected">Google Web Font</option>
									</optgroup>
								</select>
								<input type="text" name="h5_font_google" id="h5_font_google" value="Alegreya Sans" />
								<select name="h5_font_google_type" id="h5_font_google_type">
									<option value="sans-serif" selected="selected">Sans Serif</option>
									<option value="serif">Serif</option>
									<option value="monospace">MonoSpace</option>
									<option value="cursive">Cursive</option>
								</select>
							</td>
						</tr>
						<tr>
							<td></td>
							<td>
								<input type="text" name="h5_font_color" id="h5_font_color" class="color" value="#f45b4f" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="text" name="h5_font_size" id="h5_font_size" size="5" value="1.2" /> <sub>em</sub>&nbsp;
								<select name="h5_font_weight" id="h5_font_weight">
									<option value="100">Thin</option>
									<option value="200">Extra Light</option>
									<option value="300">Light</option>
									<option value="400" selected="selected">Normal</option>
									<option value="500">Medium</option>
									<option value="600">Semi Bold</option>
									<option value="700">Bold</option>
									<option value="800">Extra Bold</option>
									<option value="900">Ultra Bold</option>
								</select>
							</td>
						</tr>
						<tr>
							<td></td>
							<td><small>Web Safe, Google Font, Google Font Type, Color, Size and Weight<br /><br /></small></td>
						</tr>

					<!-- Header 6 -->
						<tr>
							<td><label for="h6_font_web_safe">Header 6</label></td>
							<td>
								<select name="h6_font_web_safe" id="h6_font_web_safe">
									<optgroup label="Sans-serif">
										<option value="Helvetica, Arial, sans-serif">Helvetica/Arial</option>
										<option value="Impact, Charcoal, Helvetica, Arial, sans-serif">Impact</option>
										<option value="'Lucida Grande', 'Lucida Sans Unicode', 'Lucida Sans', Lucida, Helvetica, Arial, sans-serif">Lucida Grande</option>
										<option value="Trebuchet MS, sans-serif">Trebuchet MS</option>
										<option value="Verdana, Helvetica, Arial, sans-serif">Verdana</option>
									</optgroup>
									<optgroup label="Serif">
										<option value="Garamond, Baskerville, Caslon, serif">Garamond</option>
										<option value="Georgia, Utopia, 'Times New Roman', Times, serif">Georgia</option>
										<option value="Palatino, 'Palatino Linotype', 'Book Antiqua', serif">Palatino</option>
										<option value="'Times New Roman', Times, serif">Times New Roman</option>
									</optgroup>
									<optgroup label="Monospace">
										<option value="'Courier New', Courier, monospace">Courier New</option>
										<option value="Monaco, 'Lucida Console', 'DejaVu Sans Mono', monospace">Monaco/Lucida Console</option>
									</optgroup>
									<optgroup label="Other">
										<option value="" selected="selected">Google Web Font</option>
									</optgroup>
								</select>
								<input type="text" name="h6_font_google" id="h6_font_google" value="Alegreya Sans" />
								<select name="h6_font_google_type" id="h6_font_google_type">
									<option value="sans-serif" selected="selected">Sans Serif</option>
									<option value="serif">Serif</option>
									<option value="monospace">MonoSpace</option>
									<option value="cursive">Cursive</option>
								</select>
							</td>
						</tr>
						<tr>
							<td></td>
							<td>
								<input type="text" name="h6_font_color" id="h6_font_color" class="color" value="#f45b4f" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="text" name="h6_font_size" id="h6_font_size" size="5" value="1.1" /> <sub>em</sub>&nbsp;
								<select name="h6_font_weight" id="h6_font_weight">
									<option value="100">Thin</option>
									<option value="200">Extra Light</option>
									<option value="300">Light</option>
									<option value="400" selected="selected">Normal</option>
									<option value="500">Medium</option>
									<option value="600">Semi Bold</option>
									<option value="700">Bold</option>
									<option value="800">Extra Bold</option>
									<option value="900">Ultra Bold</option>
								</select>
							</td>
						</tr>
						<tr>
							<td></td>
							<td><small>Web Safe, Google Font, Google Font Type, Color, Size and Weight</small></td>
						</tr>
				</table>

				<br />

	</fieldset>


<!-- #Forms
================================================== -->

	<fieldset>

		<legend>Forms</legend>

			<!-- Inputs -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Inputs</strong></h3></td>
					</tr>
					<tr>
						<td><label for="input_bg_color">Background</label></td>
						<td><input type="text" name="input_bg_color" id="input_bg_color" class="color" value="#ffffff" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					</tr>
					<tr>
						<td><label for="input_border_size_top">Border</label></td>
						<td>
							<input type="text" name="input_border_size_top" id="input_border_size_top" size="5" value="1" /> <sub>px</sub>&nbsp;
							<input type="text" name="input_border_size_right" id="input_border_size_right" size="5" value="1" /> <sub>px</sub>&nbsp;
							<input type="text" name="input_border_size_bottom" id="input_border_size_bottom" size="5" value="1" /> <sub>px</sub>&nbsp;
							<input type="text" name="input_border_size_left" id="input_border_size_left" size="5" value="1" /> <sub>px</sub>&nbsp;
						</td>
					</tr>
					<tr>
						<td></td>
						<td>
							<input type="text" name="input_border_radius_top_left" id="input_border_radius_top_left" size="5" value="0" /> <sub>px</sub>&nbsp;
							<input type="text" name="input_border_radius_top_right" id="input_border_radius_top_right" size="5" value="0" /> <sub>px</sub>&nbsp;
							<input type="text" name="input_border_radius_bottom_right" id="input_border_radius_bottom_right" size="5" value="0" /> <sub>px</sub>&nbsp;
							<input type="text" name="input_border_radius_bottom_left" id="input_border_radius_bottom_left" size="5" value="0" /> <sub>px</sub>&nbsp;
						</td>
					</tr>
					<tr>
						<td></td>
						<td>
							<select name="input_border_style" id="input_border_style">
								<option value="solid" selected="selected">Solid</option>
								<option value="dotted">Dotted</option>
								<option value="dashed">Dashed</option>
								<option value="double">Double</option>
							</select>
							<input type="text" name="input_border_color" id="input_border_color" class="color" value="#e3e3e3" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</td>
					</tr>
					<tr>
						<td></td>
						<td>
							<small>
								Top Width, Right Width, Bottom Width and Left Width<br />
								Top Left Radius, Top Right Radius, Bottom Right Radius and Bottom Left Radius<br />
								Style and Color<br /><br />
							</small>
						</td>
					</tr>
					<tr>
						<td><label for="input_font_web_safe">Font</label></td>
						<td>
							<select name="input_font_web_safe" id="input_font_web_safe">
								<optgroup label="Sans-serif">
									<option value="Helvetica, Arial, sans-serif">Helvetica/Arial</option>
									<option value="Impact, Charcoal, Helvetica, Arial, sans-serif">Impact</option>
									<option value="'Lucida Grande', 'Lucida Sans Unicode', 'Lucida Sans', Lucida, Helvetica, Arial, sans-serif">Lucida Grande</option>
									<option value="Trebuchet MS, sans-serif">Trebuchet MS</option>
									<option value="Verdana, Helvetica, Arial, sans-serif" selected="selected">Verdana</option>
								</optgroup>
								<optgroup label="Serif">
									<option value="Garamond, Baskerville, Caslon, serif">Garamond</option>
									<option value="Georgia, Utopia, 'Times New Roman', Times, serif">Georgia</option>
									<option value="Palatino, 'Palatino Linotype', 'Book Antiqua', serif">Palatino</option>
									<option value="'Times New Roman', Times, serif">Times New Roman</option>
								</optgroup>
								<optgroup label="Monospace">
									<option value="'Courier New', Courier, monospace">Courier New</option>
									<option value="Monaco, 'Lucida Console', 'DejaVu Sans Mono', monospace">Monaco/Lucida Console</option>
								</optgroup>
								<optgroup label="Other">
									<option value="">Google Web Font</option>
								</optgroup>
							</select>
							<input type="text" name="input_font_google" id="input_font_google" />
							<select name="input_font_google_type" id="input_font_google_type">
								<option value="sans-serif" selected="selected">Sans Serif</option>
								<option value="serif">Serif</option>
								<option value="monospace">MonoSpace</option>
								<option value="cursive">Cursive</option>
							</select>
						</td>
					</tr>
					<tr>
						<td></td>
						<td>
							<input type="text" name="input_font_color" id="input_font_color" class="color" value="#999999" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="text" name="input_font_size" id="input_font_size" size="5" value="1" /> <sub>em</sub>&nbsp;
							<select name="input_font_weight" id="input_font_weight">
								<option value="100">Thin</option>
								<option value="200">Extra Light</option>
								<option value="300">Light</option>
								<option value="400" selected="selected">Normal</option>
								<option value="500">Medium</option>
								<option value="600">Semi Bold</option>
								<option value="700">Bold</option>
								<option value="800">Extra Bold</option>
								<option value="900">Ultra Bold</option>
							</select>
						</td>
					</tr>
					<tr>
						<td></td>
						<td><small>Web Safe, Google Font, Google Font Type, Color, Size and Weight</small></td>
					</tr>
				</table>

				<br />

			<!-- Buttons -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Buttons</strong></h3></td>
					</tr>
					<tr>
						<td><label for="button_bg_color">Background</label></td>
						<td>
							<input type="text" name="button_bg_color" id="button_bg_color" class="color" value="#f45b4f" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="text" name="button_bg_color_hover" id="button_bg_color_hover" class="color" value="#f56558" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="text" name="button_bg_color_click" id="button_bg_color_click" class="color" value="#f04939" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</td>
					</tr>
					<tr>
						<td></td>
						<td><small>Color, Hover Color and Click Color<br /><br /></small></td>
					</tr>
					<tr>
						<td><label for="button_border_top_size">Border</label></td>
						<td>
							<input type="text" name="button_border_top_size" id="button_border_top_size" size="5" value="0" /> <sub>px</sub>&nbsp;
							<input type="text" name="button_border_right_size" id="button_border_right_size" size="5" value="0" /> <sub>px</sub>&nbsp;
							<input type="text" name="button_border_bottom_size" id="button_border_bottom_size" size="5" value="0" /> <sub>px</sub>&nbsp;
							<input type="text" name="button_border_left_size" id="button_border_left_size" size="5" value="0" /> <sub>px</sub>&nbsp;
						</td>
					</tr>
					<tr>
						<td></td>
						<td>
							<input type="text" name="button_border_top_left_radius" id="button_border_top_left_radius" size="5" value="0" /> <sub>px</sub>&nbsp;
							<input type="text" name="button_border_top_right_radius" id="button_border_top_right_radius" size="5" value="0" /> <sub>px</sub>&nbsp;
							<input type="text" name="button_border_bottom_right_radius" id="button_border_bottom_right_radius" size="5" value="0" /> <sub>px</sub>&nbsp;
							<input type="text" name="button_border_bottom_left_radius" id="button_border_bottom_left_radius" size="5" value="0" /> <sub>px</sub>&nbsp;
						</td>
					</tr>
					<tr>
						<td></td>
						<td>
							<select name="button_border_style" id="button_border_style">
								<option value="solid" selected="selected">Solid</option>
								<option value="dotted">Dotted</option>
								<option value="dashed">Dashed</option>
								<option value="double">Double</option>
							</select>
							<input type="text" name="button_border_color" id="button_border_color" class="color" value="#f45b4f" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="text" name="button_border_color_hover" id="button_border_color_hover" class="color" value="#f45b4f" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="text" name="button_border_color_click" id="button_border_color_click" class="color" value="#f45b4f" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</td>
					</tr>
					<tr>
						<td></td>
						<td>
							<small>
								Top Width, Right Width, Bottom Width and Left Width<br />
								Top Left Radius, Top Right Radius, Bottom Right Radius and Bottom Left Radius<br />
								Style, Color, Hover Color and Click Color<br /><br />
							</small>
						</td>
					</tr>
					<tr>
						<td><label for="button_font_web_safe">Font</label></td>
						<td>
							<select name="button_font_web_safe" id="button_font_web_safe">
								<optgroup label="Sans-serif">
									<option value="Helvetica, Arial, sans-serif">Helvetica/Arial</option>
									<option value="Impact, Charcoal, Helvetica, Arial, sans-serif">Impact</option>
									<option value="'Lucida Grande', 'Lucida Sans Unicode', 'Lucida Sans', Lucida, Helvetica, Arial, sans-serif">Lucida Grande</option>
									<option value="Trebuchet MS, sans-serif">Trebuchet MS</option>
									<option value="Verdana, Helvetica, Arial, sans-serif">Verdana</option>
								</optgroup>
								<optgroup label="Serif">
									<option value="Garamond, Baskerville, Caslon, serif">Garamond</option>
									<option value="Georgia, Utopia, 'Times New Roman', Times, serif">Georgia</option>
									<option value="Palatino, 'Palatino Linotype', 'Book Antiqua', serif">Palatino</option>
									<option value="'Times New Roman', Times, serif">Times New Roman</option>
								</optgroup>
								<optgroup label="Monospace">
									<option value="'Courier New', Courier, monospace">Courier New</option>
									<option value="Monaco, 'Lucida Console', 'DejaVu Sans Mono', monospace">Monaco/Lucida Console</option>
								</optgroup>
								<optgroup label="Other">
									<option value="" selected="selected">Google Web Font</option>
								</optgroup>
							</select>
							<input type="text" name="button_font_google" id="button_font_google" value="Oxygen" />
							<select name="button_font_google_type" id="button_font_google_type">
								<option value="sans-serif" selected="selected">Sans Serif</option>
								<option value="serif">Serif</option>
								<option value="monospace">MonoSpace</option>
								<option value="cursive">Cursive</option>
							</select>
						</td>
					</tr>
					<tr>
						<td></td>
						<td>
							<input type="text" name="button_font_color" id="button_font_color" class="color" value="#ffffff" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="text" name="button_font_color_hover" id="button_font_color_hover" class="color" value="#ffffff" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="text" name="button_font_color_click" id="button_font_color_click" class="color" value="#ffffff" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</td>
					</tr>
					<tr>
						<td></td>
						<td>
							<input type="text" name="button_font_size" id="button_font_size" size="5" value="1" /> <sub>em</sub>&nbsp;
							<select name="button_font_weight" id="button_font_weight">
								<option value="100">Thin</option>
								<option value="200">Extra Light</option>
								<option value="300">Light</option>
								<option value="400" selected="selected">Normal</option>
								<option value="500">Medium</option>
								<option value="600">Semi Bold</option>
								<option value="700">Bold</option>
								<option value="800">Extra Bold</option>
								<option value="900">Ultra Bold</option>
							</select>
						</td>
					</tr>
					<tr>
						<td></td>
						<td><small>Web Safe, Google Font, Google Font Type, Color, Hover Color, Click Cover, Size and Weight</small></td>
					</tr>
				</table>

				<br />

	</fieldset>


<!-- #Header
================================================== -->

	<fieldset>

		<legend>Header</legend>

			<!-- Logo -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Logo Image</strong></h3></td>
					</tr>
					<tr>
						<td><label for="use_logo">Use Logo?</label></td>
						<td><input type="checkbox" name="use_logo" id="use_logo" /></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="file" name="logo.png" id="logo_file" data-max-width="500" data-max-height="500" /></td>
					</tr>
					<tr>
						<td></td>
						<td>
							<small>
								Max width: 500px<br />
								Max height: 500px<br />
								Format: .png
							</small>
						</td>
					</tr>
				</table>

				<br />

				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Logo Textual</strong></h3></td>
					</tr>
					<tr>
						<td><label for="logo_font_web_safe">Font</label></td>
						<td>
							<select name="logo_font_web_safe" id="logo_font_web_safe">
								<optgroup label="Sans-serif">
									<option value="Helvetica, Arial, sans-serif">Helvetica/Arial</option>
									<option value="Impact, Charcoal, Helvetica, Arial, sans-serif">Impact</option>
									<option value="'Lucida Grande', 'Lucida Sans Unicode', 'Lucida Sans', Lucida, Helvetica, Arial, sans-serif">Lucida Grande</option>
									<option value="Trebuchet MS, sans-serif">Trebuchet MS</option>
									<option value="Verdana, Helvetica, Arial, sans-serif">Verdana</option>
								</optgroup>
								<optgroup label="Serif">
									<option value="Garamond, Baskerville, Caslon, serif">Garamond</option>
									<option value="Georgia, Utopia, 'Times New Roman', Times, serif">Georgia</option>
									<option value="Palatino, 'Palatino Linotype', 'Book Antiqua', serif">Palatino</option>
									<option value="'Times New Roman', Times, serif">Times New Roman</option>
								</optgroup>
								<optgroup label="Monospace">
									<option value="'Courier New', Courier, monospace">Courier New</option>
									<option value="Monaco, 'Lucida Console', 'DejaVu Sans Mono', monospace">Monaco/Lucida Console</option>
								</optgroup>
								<optgroup label="Other">
									<option value="" selected="selected">Google Web Font</option>
								</optgroup>
							</select>
							<input type="text" name="logo_font_google" id="logo_font_google" value="PT Sans Narrow" />
							<select name="logo_font_google_type" id="logo_font_google_type">
								<option value="sans-serif">Sans Serif</option>
								<option value="serif">Serif</option>
								<option value="monospace">MonoSpace</option>
								<option value="cursive" selected="selected">Cursive</option>
							</select>
						</td>
					</tr>
					<tr>
						<td></td>
						<td>
							<input name="logo_font_color" id="logo_font_color" class="color" value="#000000" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input name="logo_font_size" id="logo_font_size" size="5" value="2" /> <sub>em</sub>&nbsp;
							<select name="logo_font_weight" id="logo_font_weight">
								<option value="100">Thin</option>
								<option value="200">Extra Light</option>
								<option value="300">Light</option>
								<option value="400" selected="selected">Normal</option>
								<option value="500">Medium</option>
								<option value="600">Semi Bold</option>
								<option value="700">Bold</option>
								<option value="800">Extra Bold</option>
								<option value="900">Ultra Bold</option>
							</select>
						</td>
					</tr>
					<tr>
						<td></td>
						<td><small>Web Safe, Google Font, Google Font Type, Color, Size and Weight</small></td>
					</tr>
				</table>

				<br />

			<!-- Navigation -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Navigation</strong></h3></td>
					</tr>
					<tr>
						<td><label for="navigation_full_width">Full Width</label></td>
						<td><input type="checkbox" name="navigation_full_width" id="navigation_full_width" /></td>
					</tr>
				</table>

				<br />

	</fieldset>


<!-- #Frontpage
================================================== -->

	<fieldset>

		<legend>Frontpage</legend>

			<!-- Image Slider -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Image Slider</strong></h3></td>
					</tr>
					<tr>
						<td><label for="show_image_slider">Show Image Slider?</label></td>
						<td><input type="checkbox" name="show_image_slider" id="show_image_slider" checked="checked" /></td>
					</tr>
					<tr>
						<td><label for="image_slider_full_width">Full Width</label></td>
						<td><input type="checkbox" name="image_slider_full_width" id="image_slider_full_width" /></td>
					</tr>
					<tr>
						<td><label for="image_slider_transition">Transition</label></td>
						<td>
							<select name="image_slider_transition" id="image_slider_transition">
								<option value="">Slide</option>
								<option value="fade">Fade</option>
								<option value="fadeUp" selected="selected">Fade Up</option>
								<option value="backSlide">Back Slide</option>
								<option value="goDown">Go Down</option>
							</select>
						</td>
					</tr>
					<tr>
						<td><label for="image_slider_pause_time">Pause Time</label></td>
						<td><input type="text" name="image_slider_pause_time" id="image_slider_pause_time" size="5" value="5000" /> <sub>ms</sub>&nbsp;</td>
					</tr>
					<tr>
						<td><label for="image_slider_transition_speed">Transition Speed</label></td>
						<td><input type="text" name="image_slider_transition_speed" id="image_slider_transition_speed" size="5" value="500" /> <sub>ms</sub>&nbsp;</td>
					</tr>
				</table>

				<br />

			<!-- Slides -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Slides</strong></h3></td>
					</tr>
					<tr>
						<td><label for="show_slide_1">Show Slide 1?</label></td>
						<td><input type="checkbox" name="show_slide_1" id="show_slide_1" checked="checked" /></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="file" name="slide-1.jpg" id="slide_1_file" data-max-width="1600" data-max-height="1000" /></td>
					</tr>
					<tr>
						<td></td>
						<td>
							<input type="text" name="slide_1_link" id="slide_1_link" value="" />
							<input type="text" name="slide_1_alt" id="slide_1_alt" value="Slide One" />
						</td>
					</tr>
					<tr>
						<td><label for="show_slide_2">Show Slide 2?</label></td>
						<td><input type="checkbox" name="show_slide_2" id="show_slide_2" checked="checked" /></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="file" name="slide-2.jpg" id="slide_2_file" data-max-width="1600" data-max-height="1000" /></td>
					</tr>
					<tr>
						<td></td>
						<td>
							<input type="text" name="slide_2_link" id="slide_2_link" value="" />
							<input type="text" name="slide_2_alt" id="slide_2_alt" value="Slide Two" />
						</td>
					</tr>
					<tr>
						<td><label for="show_slide_3">Show Slide 3?</label></td>
						<td><input type="checkbox" name="show_slide_3" id="show_slide_3" checked="checked" /></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="file" name="slide-3.jpg" id="slide_3_file" data-max-width="1600" data-max-height="1000" /></td>
					</tr>
					<tr>
						<td></td>
						<td>
							<input type="text" name="slide_3_link" id="slide_3_link" value="" />
							<input type="text" name="slide_3_alt" id="slide_3_alt" value="Slide Three" />
						</td>
					</tr>
					<tr>
						<td><label for="show_slide_4">Show Slide 4?</label></td>
						<td><input type="checkbox" name="show_slide_4" id="show_slide_4" checked="checked" /></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="file" name="slide-4.jpg" id="slide_4_file" data-max-width="1600" data-max-height="1000" /></td>
					</tr>
					<tr>
						<td></td>
						<td>
							<input type="text" name="slide_4_link" id="slide_4_link" value="" />
							<input type="text" name="slide_4_alt" id="slide_4_alt" value="Slide Four" />
						</td>
					</tr>
					<tr>
						<td><label for="show_slide_5">Show Slide 5?</label></td>
						<td><input type="checkbox" name="show_slide_5" id="show_slide_5" checked="checked" /></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="file" name="slide-5.jpg" id="slide_5_file" data-max-width="1600" data-max-height="1000" /></td>
					</tr>
					<tr>
						<td></td>
						<td>
							<input type="text" name="slide_5_link" id="slide_5_link" value="" />
							<input type="text" name="slide_5_alt" id="slide_5_alt" value="Slide Five" />
						</td>
					</tr>
					<tr>
						<td></td>
						<td>
							<small>
								Max width: 1600px<br />
								Max height: 1000px<br />
								Format: .jpeg<br />
								URL Link and Alt Text
							</small>
						</td>
					</tr>
				</table>

				<br />

			<!-- Content -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Content</strong></h3></td>
					</tr>
					<tr>
						<td><label for="show_frontpage_content">Show Content?</label></td>
						<td><input type="checkbox" name="show_frontpage_content" id="show_frontpage_content" /></td>
					</tr>
					<tr>
						<td><label for="frontpage_content_page">Content Page</label></td>
						<td><select name="frontpage_content_page" id="frontpage_content_page" class="page" /></td>
					</tr>
				</table>

				<br />

			<!-- Collections -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Collections</strong></h3></td>
					</tr>
					<tr>
						<td><label for="show_frontpage_collections">Show Collections?</label></td>
						<td><input type="checkbox" name="show_frontpage_collections" id="show_frontpage_collections" /></td>
					</tr>
					<tr>
						<td><label for="frontpage_collections_title">Title</label></td>
						<td><input type="text" name="frontpage_collections_title" id="frontpage_collections_title" value="Featured Collections" /></td>
					</tr>
					<tr>
						<td><label for="frontpage_collections_link_list">Collections Link List</label></td>
						<td><select name="frontpage_collections_link_list" id="frontpage_collections_link_list" class="linklist" /></td>
					</tr>
					<tr>
						<td><label for="frontpage_collections_x_per_row">Display</label></td>
						<td>
							<select name="frontpage_collections_x_per_row" id="frontpage_collections_x_per_row">
								<option value="one-per-row">One Collection Per Row</option>
								<option value="two-per-row">Two Collections Per Row</option>
								<option value="three-per-row" selected="selected">Three Collections Per Row</option>
								<option value="four-per-row">Four Collections Per Row</option>
							</select>
							<select name="frontpage_collections_return_amount" id="frontpage_collections_return_amount">
								<option value="1">Return 1 Collection</option>
								<option value="2">Return 2 Collections</option>
								<option value="3" selected="selected">Return 3 Collections</option>
								<option value="4">Return 4 Collections</option>
								<option value="5">Return 5 Collections</option>
								<option value="6">Return 6 Collections</option>
								<option value="7">Return 7 Collections</option>
								<option value="8">Return 8 Collections</option>
								<option value="9">Return 9 Collections</option>
								<option value="10">Return 10 Collections</option>
								<option value="11">Return 11 Collections</option>
								<option value="12">Return 12 Collections</option>
								<option value="13">Return 13 Collections</option>
								<option value="14">Return 14 Collections</option>
								<option value="15">Return 15 Collections</option>
								<option value="16">Return 16 Collections</option>
								<option value="17">Return 17 Collections</option>
								<option value="18">Return 18 Collections</option>
								<option value="19">Return 19 Collections</option>
								<option value="20">Return 20 Collections</option>
							</select>
						</td>
					</tr>
				</table>

				<br />

			<!-- Products -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Products</strong></h3></td>
					</tr>
					<tr>
						<td><label for="show_frontpage_products">Show Products?</label></td>
						<td><input type="checkbox" name="show_frontpage_products" id="show_frontpage_products" /></td>
					</tr>
					<tr>
						<td><label for="frontpage_products_title">Title</label></td>
						<td><input type="text" name="frontpage_products_title" id="frontpage_products_title" value="Featured Products" /></td>
					</tr>
					<tr>
						<td><label for="frontpage_products_collection">Collection</label></td>
						<td><select name="frontpage_products_collection" id="frontpage_products_collection" class="collection" /></td>
					</tr>
					<tr>
						<td><label for="frontpage_products_x_per_row">Display</label></td>
						<td>
							<select name="frontpage_products_x_per_row" id="frontpage_products_x_per_row">
								<option value="one-per-row">One Product Per Row</option>
								<option value="two-per-row">Two Products Per Row</option>
								<option value="three-per-row">Three Products Per Row</option>
								<option value="four-per-row" selected="selected">Four Products Per Row</option>
							</select>
							<select name="frontpage_products_return_amount" id="frontpage_products_return_amount">
								<option value="1">Return 1 Product</option>
								<option value="2">Return 2 Products</option>
								<option value="3">Return 3 Products</option>
								<option value="4">Return 4 Products</option>
								<option value="5">Return 5 Products</option>
								<option value="6">Return 6 Products</option>
								<option value="7">Return 7 Products</option>
								<option value="8">Return 8 Products</option>
								<option value="9">Return 9 Products</option>
								<option value="10">Return 10 Products</option>
								<option value="11">Return 11 Products</option>
								<option value="12" selected="selected">Return 12 Products</option>
								<option value="13">Return 13 Products</option>
								<option value="14">Return 14 Products</option>
								<option value="15">Return 15 Products</option>
								<option value="16">Return 16 Products</option>
								<option value="17">Return 17 Products</option>
								<option value="18">Return 18 Products</option>
								<option value="19">Return 19 Products</option>
								<option value="20">Return 20 Products</option>
							</select>
						</td>
					</tr>
				</table>

				<br />

			<!-- Articles -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Articles</strong></h3></td>
					</tr>
					<tr>
						<td><label for="show_frontpage_articles">Show Articles?</label></td>
						<td><input type="checkbox" id="show_frontpage_articles" name="show_frontpage_articles" /></td>
					</tr>
					<tr>
						<td><label for="frontpage_articles_title">Title</label></td>
						<td><input type="text" id="frontpage_articles_title" name="frontpage_articles_title" value="Latest News" /></td>
					</tr>
					<tr>
						<td><label for="frontpage_articles_blog">Blog</label></td>
						<td><select name="frontpage_articles_blog" id="frontpage_articles_blog" class="blog" /></td>
					</tr>
					<tr>
						<td><label for="frontpage_articles_x_per_row">Display</label></td>
						<td>
							<select name="frontpage_articles_x_per_row" id="frontpage_articles_x_per_row">
								<option value="one-per-row">One Article Per Row</option>
								<option value="two-per-row" selected="selected">Two Articles Per Row</option>
								<option value="three-per-row">Three Articles Per Row</option>
								<option value="four-per-row">Four Articles Per Row</option>
							</select>
							<select name="frontpage_articles_return_amount" id="frontpage_articles_return_amount">
								<option value="1">Return 1 Article</option>
								<option value="2" selected="selected">Return 2 Articles</option>
								<option value="3">Return 3 Articles</option>
								<option value="4">Return 4 Articles</option>
								<option value="5">Return 5 Articles</option>
								<option value="6">Return 6 Articles</option>
								<option value="7">Return 7 Articles</option>
								<option value="8">Return 8 Articles</option>
								<option value="9">Return 9 Articles</option>
								<option value="10">Return 10 Articles</option>
								<option value="11">Return 11 Articles</option>
								<option value="12">Return 12 Articles</option>
								<option value="13">Return 13 Articles</option>
								<option value="14">Return 14 Articles</option>
								<option value="15">Return 15 Articles</option>
								<option value="16">Return 16 Articles</option>
								<option value="17">Return 17 Articles</option>
								<option value="18">Return 18 Articles</option>
								<option value="19">Return 19 Articles</option>
								<option value="20">Return 20 Articles</option>
							</select>
							<input type="text" id="frontpage_article_truncate" name="frontpage_article_truncate" size="5" value="25" /> <sub>Words</sub>&nbsp;
						</td>
					</tr>
				</table>

				<br />

			<!-- Module Order -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Module Order</strong></h3></td>
					</tr>
					<tr>
						<td><label for="frontpage_module_1">Module 1</label></td>
						<td>
							<select name="frontpage_module_1" id="frontpage_module_1">
								<option value="">Empty</option>
								<option value="frontpage-content" selected="selected">Content</option>
								<option value="frontpage-collections">Collections</option>
								<option value="frontpage-products">Products</option>
								<option value="frontpage-articles">Articles</option>
							</select>
						</td>
					</tr>
					<tr>
						<td><label for="frontpage_module_2">Module 2</label></td>
						<td>
							<select name="frontpage_module_2" id="frontpage_module_2">
								<option value="">Empty</option>
								<option value="frontpage-content">Content</option>
								<option value="frontpage-collections" selected="selected">Collections</option>
								<option value="frontpage-products">Products</option>
								<option value="frontpage-articles">Articles</option>
							</select>
						</td>
					</tr>
					<tr>
						<td><label for="frontpage_module_3">Module 3</label></td>
						<td>
							<select name="frontpage_module_3" id="frontpage_module_3">
								<option value="">Empty</option>
								<option value="frontpage-content">Content</option>
								<option value="frontpage-collections">Collections</option>
								<option value="frontpage-products" selected="selected">Products</option>
								<option value="frontpage-articles">Articles</option>
							</select>
						</td>
					</tr>
					<tr>
						<td><label for="frontpage_module_4">Module 4</label></td>
						<td>
							<select name="frontpage_module_4" id="frontpage_module_4">
								<option value="">Empty</option>
								<option value="frontpage-content">Content</option>
								<option value="frontpage-collections">Collections</option>
								<option value="frontpage-products">Products</option>
								<option value="frontpage-articles" selected="selected">Articles</option>
							</select>
						</td>
					</tr>
				</table>

				<br />

	</fieldset>


<!-- #Collection Listing
================================================== -->

	<fieldset>

		<legend>Collection Listing</legend>

			<!-- Display -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Collections</strong></h3></td>
					</tr>
					<tr>
						<td><label for="collections_x_per_row">Display</label></td>
						<td>
							<select name="collections_x_per_row" id="collections_x_per_row">
								<option value="one-per-row">One Collection Per Row</option>
								<option value="two-per-row">Two Collections Per Row</option>
								<option value="three-per-row">Three Collections Per Row</option>
								<option value="four-per-row" selected="selected">Four Collections Per Row</option>
							</select>
							<select name="collections_per_page" id="collections_per_page">
								<option value="1">Return 1 Collection Per Page</option>
								<option value="2">Return 2 Collections Per Page</option>
								<option value="3">Return 3 Collections Per Page</option>
								<option value="4">Return 4 Collections Per Page</option>
								<option value="5">Return 5 Collections Per Page</option>
								<option value="6">Return 6 Collections Per Page</option>
								<option value="7">Return 7 Collections Per Page</option>
								<option value="8">Return 8 Collections Per Page</option>
								<option value="9">Return 9 Collections Per Page</option>
								<option value="10">Return 10 Collections Per Page</option>
								<option value="11">Return 11 Collections Per Page</option>
								<option value="12">Return 12 Collections Per Page</option>
								<option value="13">Return 13 Collections Per Page</option>
								<option value="14">Return 14 Collections Per Page</option>
								<option value="15">Return 15 Collections Per Page</option>
								<option value="16">Return 16 Collections Per Page</option>
								<option value="17">Return 17 Collections Per Page</option>
								<option value="18">Return 18 Collections Per Page</option>
								<option value="19">Return 19 Collections Per Page</option>
								<option value="20" selected="selected">Return 20 Collections Per Page</option>
								<option value="21">Return 21 Collections Per Page</option>
								<option value="22">Return 22 Collections Per Page</option>
								<option value="23">Return 23 Collections Per Page</option>
								<option value="24">Return 24 Collections Per Page</option>
								<option value="25">Return 25 Collections Per Page</option>
								<option value="26">Return 26 Collections Per Page</option>
								<option value="27">Return 27 Collections Per Page</option>
								<option value="28">Return 28 Collections Per Page</option>
								<option value="29">Return 29 Collections Per Page</option>
								<option value="30">Return 20 Collections Per Page</option>
								<option value="31">Return 31 Collections Per Page</option>
								<option value="32">Return 32 Collections Per Page</option>
								<option value="33">Return 33 Collections Per Page</option>
								<option value="34">Return 34 Collections Per Page</option>
								<option value="35">Return 35 Collections Per Page</option>
								<option value="36">Return 36 Collections Per Page</option>
								<option value="37">Return 37 Collections Per Page</option>
								<option value="38">Return 38 Collections Per Page</option>
								<option value="39">Return 39 Collections Per Page</option>
								<option value="40">Return 40 Collections Per Page</option>
								<option value="41">Return 41 Collections Per Page</option>
								<option value="42">Return 42 Collections Per Page</option>
								<option value="43">Return 43 Collections Per Page</option>
								<option value="44">Return 44 Collections Per Page</option>
								<option value="45">Return 45 Collections Per Page</option>
								<option value="46">Return 46 Collections Per Page</option>
								<option value="47">Return 47 Collections Per Page</option>
								<option value="48">Return 48 Collections Per Page</option>
								<option value="49">Return 49 Collections Per Page</option>
								<option value="50">Return 50 Collections Per Page</option>
							</select>
						</td>
					</tr>
				</table>

				<br />

	</fieldset>


<!-- #Product Listing
================================================== -->

	<fieldset>

		<legend>Product Listing</legend>

			<!-- Display -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Products</strong></h3></td>
					</tr>
					<tr>
						<td><label for="products_x_per_row">Display</label></td>
						<td>
							<select name="products_x_per_row" id="products_x_per_row">
								<option value="one-per-row">One Product Per Row</option>
								<option value="two-per-row">Two Products Per Row</option>
								<option value="three-per-row">Three Products Per Row</option>
								<option value="four-per-row" selected="selected">Four Products Per Row</option>
							</select>
							<select name="products_per_page" id="products_per_page">
								<option value="1">Return 1 Product Per Page</option>
								<option value="2">Return 2 Products Per Page</option>
								<option value="3">Return 3 Products Per Page</option>
								<option value="4">Return 4 Products Per Page</option>
								<option value="5">Return 5 Products Per Page</option>
								<option value="6">Return 6 Products Per Page</option>
								<option value="7">Return 7 Products Per Page</option>
								<option value="8">Return 8 Products Per Page</option>
								<option value="9">Return 9 Products Per Page</option>
								<option value="10">Return 10 Products Per Page</option>
								<option value="11">Return 11 Products Per Page</option>
								<option value="12">Return 12 Products Per Page</option>
								<option value="13">Return 13 Products Per Page</option>
								<option value="14">Return 14 Products Per Page</option>
								<option value="15">Return 15 Products Per Page</option>
								<option value="16">Return 16 Products Per Page</option>
								<option value="17">Return 17 Products Per Page</option>
								<option value="18">Return 18 Products Per Page</option>
								<option value="19">Return 19 Products Per Page</option>
								<option value="20" selected="selected">Return 20 Products Per Page</option>
								<option value="21">Return 21 Products Per Page</option>
								<option value="22">Return 22 Products Per Page</option>
								<option value="23">Return 23 Products Per Page</option>
								<option value="24">Return 24 Products Per Page</option>
								<option value="25">Return 25 Products Per Page</option>
								<option value="26">Return 26 Products Per Page</option>
								<option value="27">Return 27 Products Per Page</option>
								<option value="28">Return 28 Products Per Page</option>
								<option value="29">Return 29 Products Per Page</option>
								<option value="30">Return 20 Products Per Page</option>
								<option value="31">Return 31 Products Per Page</option>
								<option value="32">Return 32 Products Per Page</option>
								<option value="33">Return 33 Products Per Page</option>
								<option value="34">Return 34 Products Per Page</option>
								<option value="35">Return 35 Products Per Page</option>
								<option value="36">Return 36 Products Per Page</option>
								<option value="37">Return 37 Products Per Page</option>
								<option value="38">Return 38 Products Per Page</option>
								<option value="39">Return 39 Products Per Page</option>
								<option value="40">Return 40 Products Per Page</option>
								<option value="41">Return 41 Products Per Page</option>
								<option value="42">Return 42 Products Per Page</option>
								<option value="43">Return 43 Products Per Page</option>
								<option value="44">Return 44 Products Per Page</option>
								<option value="45">Return 45 Products Per Page</option>
								<option value="46">Return 46 Products Per Page</option>
								<option value="47">Return 47 Products Per Page</option>
								<option value="48">Return 48 Products Per Page</option>
								<option value="49">Return 49 Products Per Page</option>
								<option value="50">Return 50 Products Per Page</option>
							</select>
						</td>
					</tr>
				</table>

				<br />

	</fieldset>


<!-- #Search
================================================== -->

	<fieldset>

		<legend>Search</legend>

			<!-- Search Bar -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Search Bar</strong></h3></td>
					</tr>
					<tr>
						<td><label for="search_bar_placeholder_text">Placeholder Text</label></td>
						<td><input type="text" name="search_bar_placeholder_text" id="search_bar_placeholder_text" value="SEARCH FOR A PRODUCT" /></td>
					</tr>
				</table>

				<br />

			<!-- Results -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Results</strong></h3></td>
					</tr>
					<tr>
						<td><label for="search_results_x_per_row">Display</label></td>
						<td>
							<select name="search_results_x_per_row" id="search_results_x_per_row">
								<option value="one-per-row">One Product Per Row</option>
								<option value="two-per-row">Two Products Per Row</option>
								<option value="three-per-row">Three Products Per Row</option>
								<option value="four-per-row" selected="selected">Four Products Per Row</option>
							</select>
							<select name="search_results_per_page" id="search_results_per_page">
								<option value="1">Return 1 Product Per Page</option>
								<option value="2">Return 2 Products Per Page</option>
								<option value="3">Return 3 Products Per Page</option>
								<option value="4">Return 4 Products Per Page</option>
								<option value="5">Return 5 Products Per Page</option>
								<option value="6">Return 6 Products Per Page</option>
								<option value="7">Return 7 Products Per Page</option>
								<option value="8">Return 8 Products Per Page</option>
								<option value="9">Return 9 Products Per Page</option>
								<option value="10">Return 10 Products Per Page</option>
								<option value="11">Return 11 Products Per Page</option>
								<option value="12">Return 12 Products Per Page</option>
								<option value="13">Return 13 Products Per Page</option>
								<option value="14">Return 14 Products Per Page</option>
								<option value="15">Return 15 Products Per Page</option>
								<option value="16">Return 16 Products Per Page</option>
								<option value="17">Return 17 Products Per Page</option>
								<option value="18">Return 18 Products Per Page</option>
								<option value="19">Return 19 Products Per Page</option>
								<option value="20" selected="selected">Return 20 Products Per Page</option>
								<option value="21">Return 21 Products Per Page</option>
								<option value="22">Return 22 Products Per Page</option>
								<option value="23">Return 23 Products Per Page</option>
								<option value="24">Return 24 Products Per Page</option>
								<option value="25">Return 25 Products Per Page</option>
								<option value="26">Return 26 Products Per Page</option>
								<option value="27">Return 27 Products Per Page</option>
								<option value="28">Return 28 Products Per Page</option>
								<option value="29">Return 29 Products Per Page</option>
								<option value="30">Return 20 Products Per Page</option>
								<option value="31">Return 31 Products Per Page</option>
								<option value="32">Return 32 Products Per Page</option>
								<option value="33">Return 33 Products Per Page</option>
								<option value="34">Return 34 Products Per Page</option>
								<option value="35">Return 35 Products Per Page</option>
								<option value="36">Return 36 Products Per Page</option>
								<option value="37">Return 37 Products Per Page</option>
								<option value="38">Return 38 Products Per Page</option>
								<option value="39">Return 39 Products Per Page</option>
								<option value="40">Return 40 Products Per Page</option>
								<option value="41">Return 41 Products Per Page</option>
								<option value="42">Return 42 Products Per Page</option>
								<option value="43">Return 43 Products Per Page</option>
								<option value="44">Return 44 Products Per Page</option>
								<option value="45">Return 45 Products Per Page</option>
								<option value="46">Return 46 Products Per Page</option>
								<option value="47">Return 47 Products Per Page</option>
								<option value="48">Return 48 Products Per Page</option>
								<option value="49">Return 49 Products Per Page</option>
								<option value="50">Return 50 Products Per Page</option>
							</select>
						</td>
					</tr>
				</table>

				<br />

	</fieldset>


<!-- #Product
================================================== -->

	<fieldset>

		<legend>Product</legend>

			<!-- Quick Look -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Quick Look</strong></h3></td>
					</tr>
					<tr>
						<td><label for="use_quick_look">Use Quick Look?</label></td>
						<td><input type="checkbox" name="use_quick_look" id="use_quick_look" checked="checked" /></td>
					</tr>
				</table>

				<br />

			<!-- Wishlist -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Wishlist</strong></h3></td>
					</tr>
					<tr>
						<td><label for="use_wishlist">Use Wishlist?</label></td>
						<td><input type="checkbox" name="use_wishlist" id="use_wishlist" /></td>
					</tr>
					<!--<tr>
						<td><label for="show_wishlist_item_count">Show Wishlist Item Count?</label></td>
						<td><input type="checkbox" name="show_wishlist_item_count" id="show_wishlist_item_count" /></td>
					</tr>-->
					<tr>
						<td></td>
						<td><small><strong>Be sure to read the Documentation to understand how Wishlists work on this theme before enabling it</strong></small></td>
					</tr>
				</table>

				<br />

			<!-- Images -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Images</strong></h3></td>
					</tr>
					<tr>
						<td><label for="use_product_hover_zoom">Use Hover Zoom?</label></td>
						<td><input type="checkbox" name="use_product_hover_zoom" id="use_product_hover_zoom" checked="checked" /></td>
					</tr>
					<tr>
						<td><label for="use_product_click_lightbox">Use Click Lightbox?</label></td>
						<td><input type="checkbox" name="use_product_click_lightbox" id="use_product_click_lightbox" checked="checked" /></td>
					</tr>
					<tr>
						<td><label for="product_hover_zoom_type">Zoom Type</label></td>
						<td>
							<select name="product_hover_zoom_type" id="product_hover_zoom_type">
								<option value="window">Window</option>
								<option value="inner">Inner</option>
								<option value="lens" selected="selected">Lens</option>
							</select>
						</td>
					</tr>
				</table>

				<br />

			<!-- Quantity -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Quantity</strong></h3></td>
					</tr>
					<tr>
						<td><label for="show_quantity_inputs">Show Quantity Inputs?</label></td>
						<td><input type="checkbox" name="show_quantity_inputs" id="show_quantity_inputs" checked="checked" /></td>
					</tr>
					<tr>
						<td></td>
						<td><small>This affects product pages, quick look modals and the cart page</small></td>
					</tr>
				</table>

				<br />

			<!-- Details -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Details</strong></h3></td>
					</tr>
					<tr>
						<td><label for="show_product_reviews">Show Product Reviews?</label></td>
						<td>
							<input type="checkbox" name="show_product_reviews" id="show_product_reviews" checked="checked" />
						</td>
					</tr>
					<tr>
						<td></td>
						<td>
							<small>
								This requires you have installed the <a href="https://apps.shopify.com/product-reviews" target="_blank">Shopify Product Reviews</a> App<br />
								Styles are auto generated from your Theme Settings not the App Settings
							</small>
						</td>
					</tr>
					<tr>
						<td><label for="show_product_type">Show Product Type?</label></td>
						<td><input type="checkbox" name="show_product_type" id="show_product_type" checked="checked" /></td>
					</tr>
					<tr>
						<td><label for="show_product_vendor">Show Product Vendor?</label></td>
						<td><input type="checkbox" name="show_product_vendor" id="show_product_vendor" checked="checked" /></td>
					</tr>
					<tr>
						<td><label for="show_product_tags">Show Product Tags?</label></td>
						<td><input type="checkbox" name="show_product_tags" id="show_product_tags" checked="checked" /></td>
					</tr>
					<tr>
						<td><label for="show_product_pagination">Show Product Prev/Next buttons?</label></td>
						<td><input type="checkbox" name="show_product_pagination" id="show_product_pagination" checked="checked" /></td>
					</tr>
					<tr>
						<td></td>
						<td><small>Prev/Next buttons only appear when viewing products within a collection</small></td>
					</tr>
				</table>

				<br />

			<!-- Sharing -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Sharing</strong></h3></td>
					</tr>
					<tr>
						<td><label for="show_product_sharing_icons">Show Sharing Icons?</label></td>
						<td><input type="checkbox" name="show_product_sharing_icons" id="show_product_sharing_icons" checked="checked" /></td>
					</tr>
					<tr>
						<td><label for="show_product_sharing_facebook">Show Facebook Icon?</label></td>
						<td><input type="checkbox" name="show_product_sharing_facebook" id="show_product_sharing_facebook" checked="checked" /></td>
					</tr>
					<tr>
						<td><label for="show_product_sharing_twitter">Show Twitter Icon?</label></td>
						<td><input type="checkbox" name="show_product_sharing_twitter" id="show_product_sharing_twitter" checked="checked" /></td>
					</tr>
					<tr>
						<td><label for="show_product_sharing_google_plus">Show Google+ Icon?</label></td>
						<td><input type="checkbox" name="show_product_sharing_google_plus" id="show_product_sharing_google_plus" checked="checked" /></td>
					</tr>
					<tr>
						<td><label for="show_product_sharing_pinterest">Show Pinterest Icon?</label></td>
						<td><input type="checkbox" name="show_product_sharing_pinterest" id="show_product_sharing_pinterest" checked="checked" /></td>
					</tr>
					<tr>
						<td><label for="show_product_sharing_email">Show Email Icon?</label></td>
						<td><input type="checkbox" name="show_product_sharing_email" id="show_product_sharing_email" checked="checked" /></td>
					</tr>
				</table>

				<br />

			<!-- Related Products -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Related Products</strong></h3></td>
					</tr>
					<tr>
						<td><label for="show_related_products">Show Related Products?</label></td>
						<td><input type="checkbox" name="show_related_products" id="show_related_products" checked="checked" /></td>
					</tr>
					<tr>
						<td><label for="related_products_title">Title</label></td>
						<td><input type="text" name="related_products_title" id="related_products_title" value="Related Products" /></td>
					</tr>
					<tr>
						<td><label for="related_products_x_per_row">Display</label></td>
						<td>
							<select name="related_products_x_per_row" id="related_products_x_per_row">
								<option value="one-per-row">One Product Per Row</option>
								<option value="two-per-row">Two Products Per Row</option>
								<option value="three-per-row">Three Products Per Row</option>
								<option value="four-per-row" selected="selected">Four Products Per Row</option>
							</select>
							<select name="related_products_return_amount" id="related_products_return_amount">
								<option value="1">Return 1 Product</option>
								<option value="2">Return 2 Products</option>
								<option value="3">Return 3 Products</option>
								<option value="4" selected="selected">Return 4 Products</option>
								<option value="5">Return 5 Products</option>
								<option value="6">Return 6 Products</option>
								<option value="7">Return 7 Products</option>
								<option value="8">Return 8 Products</option>
								<option value="9">Return 9 Products</option>
								<option value="10">Return 10 Products</option>
								<option value="11">Return 11 Products</option>
								<option value="12">Return 12 Products</option>
								<option value="13">Return 13 Products</option>
								<option value="14">Return 14 Products</option>
								<option value="15">Return 15 Products</option>
								<option value="16">Return 16 Products</option>
								<option value="17">Return 17 Products</option>
								<option value="18">Return 18 Products</option>
								<option value="19">Return 19 Products</option>
								<option value="20">Return 20 Products</option>
							</select>
						</td>
					</tr>
				</table>

				<br />

	</fieldset>


<!-- #Blogs and Articles
================================================== -->

	<fieldset>

		<legend>Blogs and Articles</legend>

			<!-- Blog -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Blog</strong></h3></td>
					</tr>
					<tr>
						<td><label for="articles_x_per_row">Articles Per Page</label></td>
						<td>
							<select name="articles_x_per_row" id="articles_x_per_row">
								<option value="one-per-row">One Article Per Row</option>
								<option value="two-per-row" selected="selected">Two Articles Per Row</option>
								<option value="three-per-row">Three Articles Per Row</option>
								<option value="four-per-row">Four Articles Per Row</option>
							</select>
							<select name="articles_per_page" id="articles_per_page">
								<option value="5">Return 5 Articles</option>
								<option value="10">Return 10 Articles</option>
								<option value="15">Return 15 Articles</option>
								<option value="20" selected="selected">Return 20 Articles</option>
								<option value="25">Return 25 Articles</option>
								<option value="30">Return 30 Articles</option>
								<option value="35">Return 35 Articles</option>
								<option value="40">Return 40 Articles</option>
								<option value="45">Return 45 Articles</option>
								<option value="50">Return 50 Articles</option>
							</select>

							<input type="text" id="article_truncate" name="article_truncate" size="5" value="200" /> <sub>Words</sub>&nbsp;
						</td>
					</tr>
				</table>

				<br />

			<!-- Article -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Article</strong></h3></td>
					</tr>
					<tr>
						<td><label for="show_article_tags">Show Article Tags?</label></td>
						<td><input type="checkbox" name="show_article_tags" id="show_article_tags" checked="checked" /></td>
					</tr>
					<tr>
						<td><label for="show_article_pagination">Show Article Prev/Next buttons?</label></td>
						<td><input type="checkbox" name="show_article_pagination" id="show_article_pagination" checked="checked" /></td>
					</tr>
					<tr>
						<td><label for="comments_per_page">Comments Per Page</label></td>
						<td>
							<select name="comments_per_page" id="comments_per_page">
								<option value="5">Return 5 Comments</option>
								<option value="10">Return 10 Comments</option>
								<option value="15">Return 15 Comments</option>
								<option value="20">Return 20 Comments</option>
								<option value="25">Return 25 Comments</option>
								<option value="30">Return 30 Comments</option>
								<option value="35">Return 35 Comments</option>
								<option value="40">Return 40 Comments</option>
								<option value="45">Return 45 Comments</option>
								<option value="50" selected="selected">Return 50 Comments</option>
							</select>
						</td>
					</tr>
				</table>

				<br />

			<!-- Sharing -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Sharing</strong></h3></td>
					</tr>
					<tr>
						<td><label for="show_article_sharing_icons">Show Sharing Icons?</label></td>
						<td><input type="checkbox" name="show_article_sharing_icons" id="show_article_sharing_icons" checked="checked" /></td>
					</tr>
					<tr>
						<td><label for="show_article_sharing_facebook">Show Facebook Icon?</label></td>
						<td><input type="checkbox" name="show_article_sharing_facebook" id="show_article_sharing_facebook" checked="checked" /></td>
					</tr>
					<tr>
						<td><label for="show_article_sharing_twitter">Show Twitter Icon?</label></td>
						<td><input type="checkbox" name="show_article_sharing_twitter" id="show_article_sharing_twitter" checked="checked" /></td>
					</tr>
					<tr>
						<td><label for="show_article_sharing_google_plus">Show Google+ Icon?</label></td>
						<td><input type="checkbox" name="show_article_sharing_google_plus" id="show_article_sharing_google_plus" checked="checked" /></td>
					</tr>
					<tr>
						<td><label for="show_article_sharing_pinterest">Show Pinterest Icon?</label></td>
						<td><input type="checkbox" name="show_article_sharing_pinterest" id="show_article_sharing_pinterest" checked="checked" /></td>
					</tr>
					<tr>
						<td><label for="show_article_sharing_email">Show Email Icon?</label></td>
						<td><input type="checkbox" name="show_article_sharing_email" id="show_article_sharing_email" checked="checked" /></td>
					</tr>
				</table>

				<br />

	</fieldset>


<!-- #Contact Us
================================================== -->

	<fieldset>

		<legend>Contact Us</legend>

			<!-- Google Maps -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Google Maps</strong></h3></td>
					</tr>
					<tr>
						<td><label for="show_google_maps">Show Google Maps?</label></td>
						<td><input type="checkbox" id="show_google_maps" name="show_google_maps" checked="checked" /></td>
					</tr>
					<tr>
						<td><label for="google_maps_code">Embed Code</label></td>
						<td><input type="text" name="google_maps_code" id="google_maps_code" /></td> <!-- <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d158858.18237072713!2d-0.10159865000001353!3d51.52864165000001!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x47d8a00baf21de75%3A0x52963a5addd52a99!2sLondon%2C+UK!5e0!3m2!1sen!2s!4v1414115863877" width="600" height="450" frameborder="0" style="border:0"></iframe> -->
					</tr>
					<tr>
						<td></td>
						<td><small>For instructions on adding your Google Map location follow the Documentation provided</small></td>
					</tr>
				</table>

	</fieldset>


<!-- #Cart
================================================== -->

	<fieldset>

		<legend>Cart</legend>

			<!-- Checkout Options -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Checkout Options</strong></h3></td>
					</tr>
					<tr>
						<td><label for="show_cart_special_instructions">Show special instructions textbox?</label></td>
						<td><input type="checkbox" name="show_cart_special_instructions" id="show_cart_special_instructions" checked="checked" /></td>
					</tr>
				</table>

				<br />

			<!-- Shipping Calculator -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Shipping Calculator</strong></h3></td>
					</tr>
					<tr>
						<td><label for="show_shipping_calculator">Show shipping calculator?</label></td>
						<td><input type="checkbox" name="show_shipping_calculator" id="show_shipping_calculator" checked="checked" /></td>
					</tr>
					<tr>
						<td><label for="shipping_calculator_default_country">Default country selection</label></td>
						<td><input type="text" name="shipping_calculator_default_country" id="shipping_calculator_default_country" value="United States" /></td>
					</tr>
					<tr>
						<td></td>
						<td><small>If your customer is logged-in, the country in their default shipping address will be selected</small></td>
					</tr>
				</table>

				<br />

			<!-- Collection -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Collection</strong></h3></td>
					</tr>
					<tr>
						<td><label for="show_cart_collection">Show Collection?</label></td>
						<td><input type="checkbox" name="show_cart_collection" id="show_cart_collection" /></td>
					</tr>
					<tr>
						<td><label for="cart_collection_title">Title</label></td>
						<td><input type="text" name="cart_collection_title" id="cart_collection_title" value="You May Also Like" /></td>
					</tr>
					<tr>
						<td><label for="cart_collection">Collection</label></td>
						<td><select name="cart_collection" id="cart_collection" class="collection" /></td>
					</tr>
					<tr>
						<td><label for="cart_collection_x_per_row">Display</label></td>
						<td>
							<select name="cart_collection_x_per_row" id="cart_collection_x_per_row">
								<option value="one-per-row">One Product Per Row</option>
								<option value="two-per-row">Two Products Per Row</option>
								<option value="three-per-row">Three Products Per Row</option>
								<option value="four-per-row" selected="selected">Four Products Per Row</option>
							</select>
							<select name="cart_collection_return_amount" id="cart_collection_return_amount">
								<option value="1">Return 1 Product</option>
								<option value="2">Return 2 Products</option>
								<option value="3">Return 3 Products</option>
								<option value="4" selected="selected">Return 4 Products</option>
								<option value="5">Return 5 Products</option>
								<option value="6">Return 6 Products</option>
								<option value="7">Return 7 Products</option>
								<option value="8">Return 8 Products</option>
								<option value="9">Return 9 Products</option>
								<option value="10">Return 10 Products</option>
								<option value="11">Return 11 Products</option>
								<option value="12">Return 12 Products</option>
								<option value="13">Return 13 Products</option>
								<option value="14">Return 14 Products</option>
								<option value="15">Return 15 Products</option>
								<option value="16">Return 16 Products</option>
								<option value="17">Return 17 Products</option>
								<option value="18">Return 18 Products</option>
								<option value="19">Return 19 Products</option>
								<option value="20">Return 20 Products</option>
							</select>
						</td>
					</tr>
				</table>

				<br />

	</fieldset>


<!-- #Footer
================================================== -->

	<fieldset>

		<legend>Footer</legend>

			<!-- Colors -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Colors</strong></h3></td>
					</tr>
					<tr>
						<td><label for="footer_font_color">Font</label></td>
						<td>
							<input name="footer_font_color" id="footer_font_color" class="color" value="#c3c3c3" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</td>
					</tr>
					<tr>
						<td><label for="footer_link_color">Links</label></td>
						<td>
							<input name="footer_link_color" id="footer_link_color" class="color" value="#f45b4f" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input name="footer_link_color_hover" id="footer_link_color_hover" class="color" value="#f56558" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</td>
					</tr>
					<tr>
						<td></td>
						<td><small>Color and Hover Color</small></td>
					</tr>
				</table>

				<br />

			<!-- Headers -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Headers</strong></h3></td>
					</tr>
					<tr>
						<td><label for="footer_header_font_web_safe">Font</label></td>
						<td>
							<select name="footer_header_font_web_safe" id="footer_header_font_web_safe">
								<optgroup label="Sans-serif">
									<option value="Helvetica, Arial, sans-serif">Helvetica/Arial</option>
									<option value="Impact, Charcoal, Helvetica, Arial, sans-serif">Impact</option>
									<option value="'Lucida Grande', 'Lucida Sans Unicode', 'Lucida Sans', Lucida, Helvetica, Arial, sans-serif">Lucida Grande</option>
									<option value="Trebuchet MS, sans-serif">Trebuchet MS</option>
									<option value="Verdana, Helvetica, Arial, sans-serif">Verdana</option>
								</optgroup>
								<optgroup label="Serif">
									<option value="Garamond, Baskerville, Caslon, serif">Garamond</option>
									<option value="Georgia, Utopia, 'Times New Roman', Times, serif">Georgia</option>
									<option value="Palatino, 'Palatino Linotype', 'Book Antiqua', serif">Palatino</option>
									<option value="'Times New Roman', Times, serif">Times New Roman</option>
								</optgroup>
								<optgroup label="Monospace">
									<option value="'Courier New', Courier, monospace">Courier New</option>
									<option value="Monaco, 'Lucida Console', 'DejaVu Sans Mono', monospace">Monaco/Lucida Console</option>
								</optgroup>
								<optgroup label="Other">
									<option value="" selected="selected">Google Web Font</option>
								</optgroup>
							</select>
							<input type="text" name="footer_header_font_google" id="footer_header_font_google" value="Alegreya Sans" />
							<select name="footer_header_font_google_type" id="footer_header_font_google_type">
								<option value="sans-serif" selected="selected">Sans Serif</option>
								<option value="serif">Serif</option>
								<option value="monospace">MonoSpace</option>
								<option value="cursive">Cursive</option>
							</select>
						</td>
					</tr>
					<tr>
						<td></td>
						<td>
							<input type="text" name="footer_header_font_color" id="footer_header_font_color" class="color" value="#f45b4f" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="text" name="footer_header_font_size" id="footer_header_font_size" size="5" value="2.4" /> <sub>em</sub>&nbsp;
							<select name="footer_header_font_weight" id="footer_header_font_weight">
								<option value="100">Thin</option>
								<option value="200">Extra Light</option>
								<option value="300">Light</option>
								<option value="400" selected="selected">Normal</option>
								<option value="500">Medium</option>
								<option value="600">Semi Bold</option>
								<option value="700">Bold</option>
								<option value="800">Extra Bold</option>
								<option value="900">Ultra Bold</option>
							</select>
						</td>
					</tr>
					<tr>
						<td></td>
						<td><small>Web Safe, Google Font, Google Font Type, Color, Size and Weight</small></td>
					</tr>
				</table>

				<br />

			<!-- Custom 1 -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Custom 1</strong></h3></td>
					</tr>
					<tr>
						<td><label for="footer_custom_title_1">Title</label></td>
						<td><input type="text" name="footer_custom_title_1" id="footer_custom_title_1" value="Custom Block 1" /></td>
					</tr>
					<tr>
						<td><label for="footer_custom_text_1">Text</label></td>
						<td><input type="text" name="footer_custom_text_1" id="footer_custom_text_1" value="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut a nisl adipiscing, rhoncus leo at, porta ipsum." /></td>
					</tr>
				</table>

				<br />

			<!-- Custom 2 -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Custom 2</strong></h3></td>
					</tr>
					<tr>
						<td><label for="footer_custom_title_2">Title</label></td>
						<td><input type="text" name="footer_custom_title_2" id="footer_custom_title_2" value="Custom Block 2" /></td>
					</tr>
					<tr>
						<td><label for="footer_custom_text_2">Text</label></td>
						<td><input type="text" name="footer_custom_text_2" id="footer_custom_text_2" value="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut a nisl adipiscing, rhoncus leo at, porta ipsum." /></td>
					</tr>
				</table>

				<br />

			<!-- Link List 1 -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Link List 1</strong></h3></td>
					</tr>
					<tr>
						<td><label for="footer_link_list_title_1">Title</label></td>
						<td><input type="text" name="footer_link_list_title_1" id="footer_link_list_title_1" value="Links List 1" /></td>
					</tr>
					<tr>
						<td><label for="footer_link_list_1">Link List</label></td>
						<td><select name="footer_link_list_1" id="footer_link_list_1" class="linklist"></select></td>
					</tr>
				</table>

				<br />

			<!-- Link List 2 -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Link List 2</strong></h3></td>
					</tr>
					<tr>
						<td><label for="footer_link_list_title_2">Title</label></td>
						<td><input type="text" name="footer_link_list_title_2" id="footer_link_list_title_2" value="Links List 2" /></td>
					</tr>
					<tr>
						<td><label for="footer_link_list_2">Link List</label></td>
						<td><select name="footer_link_list_2" id="footer_link_list_2" class="linklist"></select></td>
					</tr>
				</table>

				<br />

			<!-- Social -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Social</strong></h3></td>
					</tr>
					<tr>
						<td><label for="footer_social_title">Title</label></td>
						<td><input type="text" name="footer_social_title" id="footer_social_title" value="Stay Connected" /></td>
					</tr>
					<tr>
						<td><label for="footer_social_text">Text</label></td>
						<td><input type="text" name="footer_social_text" id="footer_social_text" value="" /></td>
					</tr>
					<tr>
						<td><label for="footer_facebook">Facebook</label></td>
						<td><input type="text" name="footer_facebook" id="footer_facebook" value="http://www.facebook.com" /></td>
					</tr>
					<tr>
						<td><label for="footer_twitter">Twitter</label></td>
						<td><input type="text" name="footer_twitter" id="footer_twitter" value="http://www.twitter.com" /></td>
					</tr>
					<tr>
						<td><label for="footer_google_plus">Google+</label></td>
						<td><input type="text" name="footer_google_plus" id="footer_google_plus" value="https://plus.google.com" /></td>
					</tr>
					<tr>
						<td><label for="footer_vk">Google+</label></td>
						<td><input type="text" name="footer_vk" id="footer_vk" value="" /></td>
					</tr>
					<tr>
						<td><label for="footer_pinterest">Pinterest</label></td>
						<td><input type="text" name="footer_pinterest" id="footer_pinterest" value="" /></td>
					</tr>
					<tr>
						<td><label for="footer_instagram">Instagram</label></td>
						<td><input type="text" name="footer_instagram" id="footer_instagram" value="" /></td>
					</tr>
					<tr>
						<td><label for="footer_flickr">Flickr</label></td>
						<td><input type="text" name="footer_flickr" id="footer_flickr" value="" /></td>
					</tr>
					<tr>
						<td><label for="footer_youtube">YouTube</label></td>
						<td><input type="text" name="footer_youtube" id="footer_youtube" value="" /></td>
					</tr>
					<tr>
						<td><label for="footer_vimeo">Vimeo</label></td>
						<td><input type="text" name="footer_vimeo" id="footer_vimeo" value="" /></td>
					</tr>
					<tr>
						<td><label for="footer_vine">Vine</label></td>
						<td><input type="text" name="footer_vine" id="footer_vine" value="" /></td>
					</tr>
					<tr>
						<td><label for="footer_tumblr">Tumblr</label></td>
						<td><input type="text" name="footer_tumblr" id="footer_tumblr" value="" /></td>
					</tr>
					<tr>
						<td><label for="footer_foursquare">Foursquare</label></td>
						<td><input type="text" name="footer_foursquare" id="footer_foursquare" value="" /></td>
					</tr>
					<tr>
						<td><label for="footer_dribbble">Dribbble</label></td>
						<td><input type="text" name="footer_dribbble" id="footer_dribbble" value="" /></td>
					</tr>
					<tr>
						<td><label for="footer_linkedin">LinkedIn</label></td>
						<td><input type="text" name="footer_linkedin" id="footer_linkedin" value="http://www.linkedin.com" /></td>
					</tr>
					<tr>
						<td><label for="footer_skype">Skype</label></td>
						<td><input type="text" name="footer_skype" id="footer_skype" value="" /></td>
					</tr>
				</table>

				<br />

			<!-- Newsletter -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Newsletter</strong></h3></td>
					</tr>
					<tr>
						<td><label for="footer_newsletter_title">Title</label></td>
						<td><input type="text" name="footer_newsletter_title" id="footer_newsletter_title" value="Newsletter" /></td>
					</tr>
					<tr>
						<td><label for="footer_mailchimp_url">MailChimp URL</label></td>
						<td><input type="text" id="footer_mailchimp_url" name="footer_mailchimp_url" value="#" /></td>
					</tr>
					<tr>
						<td></td>
						<td><small><a href="http://docs.shopify.com/manual/configuration/store-customization/communicating-with-customers/accounts-and-newsletters/where-do-i-get-my-mailchimp-form-action" target="_blank">How do I to get my MailChimp URL?</a></small></td>
					</tr>
				</table>

				<br />

			<!-- Module Order -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Module Order</strong></h3></td>
					</tr>
					<tr>
						<td><label for="footer_module_columns">Module Columns</label></td>
						<td>
							<select name="footer_module_columns" id="footer_module_columns">
								<option value="one-half">Two</option>
								<option value="one-third">Three</option>
								<option value="one-quarter" selected="selected">Four</option>
							</select>
						</td>
					</tr>
					<tr>
						<td><label for="footer_module_1">Module 1</label></td>
						<td>
							<select name="footer_module_1" id="footer_module_1">
								<option value="">Empty</option>
								<option value="footer-custom-1" selected="selected">Custom Block 1</option>
								<option value="footer-custom-2">Custom Block 2</option>
								<option value="footer-linklist-1">Link List 1</option>
								<option value="footer-linklist-2">Link List 2</option>
								<option value="footer-social">Social</option>
								<option value="footer-newsletter">Newsletter</option>
							</select>
						</td>
					</tr>
					<tr>
						<td><label for="footer_module_2">Module 2</label></td>
						<td>
							<select name="footer_module_2" id="footer_module_2">
								<option value="">Empty</option>
								<option value="footer-custom-1">Custom Block 1</option>
								<option value="footer-custom-2">Custom Block 2</option>
								<option value="footer-linklist-1">Link List 1</option>
								<option value="footer-linklist-2">Link List 2</option>
								<option value="footer-social" selected="selected">Social</option>
								<option value="footer-newsletter">Newsletter</option>
							</select>
						</td>
					</tr>
					<tr>
						<td><label for="footer_module_3">Module 3</label></td>
						<td>
							<select name="footer_module_3" id="footer_module_3">
								<option value="">Empty</option>
								<option value="footer-custom-1">Custom Block 1</option>
								<option value="footer-custom-2">Custom Block 2</option>
								<option value="footer-linklist-1" selected="selected">Link List 1</option>
								<option value="footer-linklist-2">Link List 2</option>
								<option value="footer-social">Social</option>
								<option value="footer-newsletter">Newsletter</option>
							</select>
						</td>
					</tr>
					<tr>
						<td><label for="footer_module_4">Module 4</label></td>
						<td>
							<select name="footer_module_4" id="footer_module_4">
								<option value="">Empty</option>
								<option value="footer-custom-1">Custom Block 1</option>
								<option value="footer-custom-2">Custom Block 2</option>
								<option value="footer-linklist-1">Link List 1</option>
								<option value="footer-linklist-2">Link List 2</option>
								<option value="footer-social">Social</option>
								<option value="footer-newsletter" selected="selected">Newsletter</option>
							</select>
						</td>
					</tr>
				</table>

				<br />

			<!-- Card Payments -->
				<table class="standard-table">
					<tr>
						<td colspan="4"><h3><strong>Card Payments</strong></h3></td>
					</tr>
					<tr>
						<td class="col-report-title"><input type="checkbox" name="card_2co" id="card_2co" /> <label for="card_2co" class="inline">2Co</label></td>
						<td class="col-report-title"><input type="checkbox" name="card_american_express" id="card_american_express" checked="checked" /> <label for="card_american_express" class="inline">American Express</label></td>
						<td class="col-report-title"><input type="checkbox" name="card_bitcoin" id="card_bitcoin" checked="checked" /> <label for="card_bitcoin" class="inline">Bitcoin</label></td>
						<td class="col-report-title"><input type="checkbox" name="card_cirrus" id="card_cirrus" /> <label for="card_cirrus" class="inline">Cirrus</label></td>
					</tr>
					<tr>
						<td class="col-report-title"><input type="checkbox" name="card_delta" id="card_delta" /> <label for="card_delta" class="inline">Delta</label></td>
						<td class="col-report-title"><input type="checkbox" name="card_discover" id="card_discover" checked="checked" /> <label for="card_discover" class="inline">Discover</label></td>
						<td class="col-report-title"><input type="checkbox" name="card_google_wallet" id="card_google_wallet" checked="checked" /> <label for="card_google_wallet" class="inline">Google Wallet</label></td>
						<td class="col-report-title"><input type="checkbox" name="card_maestro" id="card_maestro" checked="checked" /> <label for="card_maestro" class="inline">Maestro</label></td>
					</tr>
					<tr>
						<td class="col-report-title"><input type="checkbox" name="card_mastercard" id="card_mastercard" checked="checked" /> <label for="card_mastercard" class="inline">Mastercard</label></td>
						<td class="col-report-title"><input type="checkbox" name="card_moneybookers" id="card_moneybookers" /> <label for="card_moneybookers" class="inline">Moneybookers</label></td>
						<td class="col-report-title"><input type="checkbox" name="card_paypal" id="card_paypal" checked="checked" /> <label for="card_paypal" class="inline">PayPal</label></td>
						<td class="col-report-title"><input type="checkbox" name="card_solo" id="card_solo" /> <label for="card_solo" class="inline">Solo</label></td>
					</tr>
					<tr>
						<td class="col-report-title"><input type="checkbox" name="card_switch" id="card_switch" checked="checked" /> <label for="card_switch" class="inline">Switch</label></td>
						<td class="col-report-title"><input type="checkbox" name="card_visa" id="card_visa" checked="checked" /> <label for="card_visa" class="inline">Visa</label></td>
						<td class="col-report-title" colspan="2"><input type="checkbox" name="card_western_union" id="card_western_union" checked="checked" /> <label for="card_western_union" class="inline">Western Union</label></td>
					</tr>
				</table>

				<br />

	</fieldset>


<!-- #Checkout
================================================== -->

	<fieldset>

		<legend>Checkout</legend>

			<!-- Notes -->
				<table class="standard-table">
					<tr>
						<td><h3><strong>Notes</strong></h3></td>
					</tr>
					<tr>
						<td>
							<small>
								Certain settings that you have set above will affect the checkout pages, such as the background color and grid content boxes
							</small>
						</td>
					</tr>
				</table>

				<br />

			<!-- Logo -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Logo</strong></h3></td>
					</tr>
					<tr>
						<td><label for="use_checkout_logo">Use logo?</label></td>
						<td><input type="checkbox" name="use_checkout_logo" id="use_checkout_logo" checked="checked" /></td>
					</tr>
				</table>

				<br />

			<!-- Colors -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Colors</strong></h3></td>
					</tr>
					<tr>
						<td><label for="checkout_primary_color">Primary</label></td>
						<td><input type="text" name="checkout_primary_color" id="checkout_primary_color" class="color" value="#f45b4f" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					</tr>
					<tr>
						<td><label for="checkout_secondary_color">Secondary</label></td>
						<td><input type="text" name="checkout_secondary_color" id="checkout_secondary_color" class="color" value="#ff9966" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					</tr>
					<tr>
						<td><label for="checkout_highlight_color">Price Background Highlight</label></td>
						<td><input type="text" name="checkout_highlight_color" id="checkout_highlight_color" class="color" value="#ffff99" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					</tr>
					<tr>
						<td><label for="checkout_headers_color">Headers</label></td>
						<td><input type="text" name="checkout_headers_color" id="checkout_headers_color" class="color" value="#f45b4f" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					</tr>
					<tr>
						<td><label for="checkout_font_color">Font</label></td>
						<td><input type="text" name="checkout_font_color" id="checkout_font_color" class="color" value="#474747" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					</tr>
					<tr>
						<td><label for="checkout_form_border_color">Form Element Border</label></td>
						<td><input type="text" name="checkout_form_border_color" id="checkout_form_border_color" class="color" value="#e3e3e3" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					</tr>
					<tr>
						<td><label for="checkout_form_bg_color">Form Element Background</label></td>
						<td><input type="text" name="checkout_form_bg_color" id="checkout_form_bg_color" class="color" value="#ffffff" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					</tr>
					<tr>
						<td><label for="checkout_form_font_color">Form Element Font</label></td>
						<td><input type="text" name="checkout_form_font_color" id="checkout_form_font_color" class="color" value="#999999" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					</tr>
					<tr>
						<td><label for="checkout_error_box_border_color">Error Box Border</label></td>
						<td><input type="text" name="checkout_error_box_border_color" id="checkout_error_box_border_color" class="color" value="#ffeb7a" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					</tr>
					<tr>
						<td><label for="checkout_error_box_bg_color">Error Box Background</label></td>
						<td><input type="text" name="checkout_error_box_bg_color" id="checkout_error_box_bg_color" class="color" value="#fffbe5" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					</tr>
					<tr>
						<td><label for="checkout_error_box_font_color">Error Box Font</label></td>
						<td><input type="text" name="checkout_error_box_font_color" id="checkout_error_box_font_color" class="color" value="#757575" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					</tr>
				</table>

				<br />

	</fieldset>


<!-- #Animations
================================================== -->

	<fieldset>

		<legend>Animations</legend>

			<!-- Notes -->
				<table class="standard-table">
					<tr>
						<td><h3><strong>Notes</strong></h3></td>
					</tr>
					<tr>
						<td>
							<small>
								With certain content you have the choice to display 1, 2, 3 or 4 items per row.<br />
								For example you could chose to have 3 products per row and have a different animations for each column.<br />
								In this example column 4 settings would be ignored.<br />
								If you choose 1 item per row then animations will now affect rows rather than columns.
							</small>
						</td>
					</tr>
				</table>

				<br />

			<!-- Settings -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Settings</strong></h3></td>
					</tr>
					<tr>
						<td><label for="use_animations">Use Animations?</label></td>
						<td><input type="checkbox" name="use_animations" id="use_animations" checked="checked" /></td>
					</tr>
					<tr>
						<td></td>
						<td><small>Globally switch off <strong>all</strong> animations</small></td>
					</tr>
				</table>

				<br />

			<!-- Frontpage Collections -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Frontpage Collections</strong></h3></td>
					</tr>
					<tr>
						<td><label for="use_frontpage_collections_animations">Use Animations?</label></td>
						<td><input type="checkbox" name="use_frontpage_collections_animations" id="use_frontpage_collections_animations" checked="checked" /></td>
					</tr>
					<tr>
						<td><label for="frontpage_collections_animation_type_1">Column 1</label></td>
						<td>
							<select name="frontpage_collections_animation_type_1" id="frontpage_collections_animation_type_1">
								<optgroup label="Fade">
									<option value="fade-in" selected="selected">Fade In</option>
									<option value="fade-in-up">Fade In Up</option>
									<option value="fade-in-down">Fade In Down</option>
									<option value="fade-in-left">Fade In Left</option>
									<option value="fade-in-right">Fade In Right</option>
								</optgroup>
								<optgroup label="Bounce">
									<option value="bounce-in">Bounce In</option>
									<option value="bounce-in-up">Bounce In Up</option>
									<option value="bounce-in-down">Bounce In Down</option>
									<option value="bounce-in-left">Bounce In Left</option>
									<option value="bounce-in-right">Bounce In Right</option>
								</optgroup>
								<optgroup label="Zoom">
									<option value="zoom-in">Zoom In</option>
									<option value="zoom-in-up">Zoom In Up</option>
									<option value="zoom-in-down">Zoom In Down</option>
									<option value="zoom-in-left">Zoom In Left</option>
									<option value="zoom-in-right">Zoom In Right</option>
								</optgroup>
								<optgroup label="Flip">
									<option value="flip-in-x">Flip In X</option>
									<option value="flip-in-y">Flip In Y</option>
									<option value="flip-in-top-front">Flip In Top Front</option>
									<option value="flip-in-top-back">Flip In Top Back</option>
									<option value="flip-in-bottom-front">Flip In Bottom Front</option>
									<option value="flip-in-bottom-back">Flip In Bottom Back</option>
									<option value="flip-in-left-front">Flip In Left Front</option>
									<option value="flip-in-left-back">Flip In Left Back</option>
									<option value="flip-in-right-front">Flip In Right Front</option>
									<option value="flip-in-right-back">Flip In Right Back</option>
								</optgroup>
							</select>
							<input type="text" name="frontpage_collections_animation_delay_1" id="frontpage_collections_animation_delay_1" size="5" value="0" /> <sub>ms</sub>&nbsp;
						</td>
					</tr>
					<tr>
						<td><label for="frontpage_collections_animation_type_2">Column 2</label></td>
						<td>
							<select name="frontpage_collections_animation_type_2" id="frontpage_collections_animation_type_2">
								<optgroup label="Fade">
									<option value="fade-in" selected="selected">Fade In</option>
									<option value="fade-in-up">Fade In Up</option>
									<option value="fade-in-down">Fade In Down</option>
									<option value="fade-in-left">Fade In Left</option>
									<option value="fade-in-right">Fade In Right</option>
								</optgroup>
								<optgroup label="Bounce">
									<option value="bounce-in">Bounce In</option>
									<option value="bounce-in-up">Bounce In Up</option>
									<option value="bounce-in-down">Bounce In Down</option>
									<option value="bounce-in-left">Bounce In Left</option>
									<option value="bounce-in-right">Bounce In Right</option>
								</optgroup>
								<optgroup label="Zoom">
									<option value="zoom-in">Zoom In</option>
									<option value="zoom-in-up">Zoom In Up</option>
									<option value="zoom-in-down">Zoom In Down</option>
									<option value="zoom-in-left">Zoom In Left</option>
									<option value="zoom-in-right">Zoom In Right</option>
								</optgroup>
								<optgroup label="Flip">
									<option value="flip-in-x">Flip In X</option>
									<option value="flip-in-y">Flip In Y</option>
									<option value="flip-in-top-front">Flip In Top Front</option>
									<option value="flip-in-top-back">Flip In Top Back</option>
									<option value="flip-in-bottom-front">Flip In Bottom Front</option>
									<option value="flip-in-bottom-back">Flip In Bottom Back</option>
									<option value="flip-in-left-front">Flip In Left Front</option>
									<option value="flip-in-left-back">Flip In Left Back</option>
									<option value="flip-in-right-front">Flip In Right Front</option>
									<option value="flip-in-right-back">Flip In Right Back</option>
								</optgroup>
							</select>
							<input type="text" name="frontpage_collections_animation_delay_2" id="frontpage_collections_animation_delay_2" size="5" value="200" /> <sub>ms</sub>&nbsp;
						</td>
					</tr>
					<tr>
						<td><label for="frontpage_collections_animation_type_3">Column 3</label></td>
						<td>
							<select name="frontpage_collections_animation_type_3" id="frontpage_collections_animation_type_3">
								<optgroup label="Fade">
									<option value="fade-in" selected="selected">Fade In</option>
									<option value="fade-in-up">Fade In Up</option>
									<option value="fade-in-down">Fade In Down</option>
									<option value="fade-in-left">Fade In Left</option>
									<option value="fade-in-right">Fade In Right</option>
								</optgroup>
								<optgroup label="Bounce">
									<option value="bounce-in">Bounce In</option>
									<option value="bounce-in-up">Bounce In Up</option>
									<option value="bounce-in-down">Bounce In Down</option>
									<option value="bounce-in-left">Bounce In Left</option>
									<option value="bounce-in-right">Bounce In Right</option>
								</optgroup>
								<optgroup label="Zoom">
									<option value="zoom-in">Zoom In</option>
									<option value="zoom-in-up">Zoom In Up</option>
									<option value="zoom-in-down">Zoom In Down</option>
									<option value="zoom-in-left">Zoom In Left</option>
									<option value="zoom-in-right">Zoom In Right</option>
								</optgroup>
								<optgroup label="Flip">
									<option value="flip-in-x">Flip In X</option>
									<option value="flip-in-y">Flip In Y</option>
									<option value="flip-in-top-front">Flip In Top Front</option>
									<option value="flip-in-top-back">Flip In Top Back</option>
									<option value="flip-in-bottom-front">Flip In Bottom Front</option>
									<option value="flip-in-bottom-back">Flip In Bottom Back</option>
									<option value="flip-in-left-front">Flip In Left Front</option>
									<option value="flip-in-left-back">Flip In Left Back</option>
									<option value="flip-in-right-front">Flip In Right Front</option>
									<option value="flip-in-right-back">Flip In Right Back</option>
								</optgroup>
							</select>
							<input type="text" name="frontpage_collections_animation_delay_3" id="frontpage_collections_animation_delay_3" size="5" value="400" /> <sub>ms</sub>&nbsp;
						</td>
					</tr>
					<tr>
						<td><label for="frontpage_collections_animation_type_4">Column 4</label></td>
						<td>
							<select name="frontpage_collections_animation_type_4" id="frontpage_collections_animation_type_4">
								<optgroup label="Fade">
									<option value="fade-in" selected="selected">Fade In</option>
									<option value="fade-in-up">Fade In Up</option>
									<option value="fade-in-down">Fade In Down</option>
									<option value="fade-in-left">Fade In Left</option>
									<option value="fade-in-right">Fade In Right</option>
								</optgroup>
								<optgroup label="Bounce">
									<option value="bounce-in">Bounce In</option>
									<option value="bounce-in-up">Bounce In Up</option>
									<option value="bounce-in-down">Bounce In Down</option>
									<option value="bounce-in-left">Bounce In Left</option>
									<option value="bounce-in-right">Bounce In Right</option>
								</optgroup>
								<optgroup label="Zoom">
									<option value="zoom-in">Zoom In</option>
									<option value="zoom-in-up">Zoom In Up</option>
									<option value="zoom-in-down">Zoom In Down</option>
									<option value="zoom-in-left">Zoom In Left</option>
									<option value="zoom-in-right">Zoom In Right</option>
								</optgroup>
								<optgroup label="Flip">
									<option value="flip-in-x">Flip In X</option>
									<option value="flip-in-y">Flip In Y</option>
									<option value="flip-in-top-front">Flip In Top Front</option>
									<option value="flip-in-top-back">Flip In Top Back</option>
									<option value="flip-in-bottom-front">Flip In Bottom Front</option>
									<option value="flip-in-bottom-back">Flip In Bottom Back</option>
									<option value="flip-in-left-front">Flip In Left Front</option>
									<option value="flip-in-left-back">Flip In Left Back</option>
									<option value="flip-in-right-front">Flip In Right Front</option>
									<option value="flip-in-right-back">Flip In Right Back</option>
								</optgroup>
							</select>
							<input type="text" name="frontpage_collections_animation_delay_4" id="frontpage_collections_animation_delay_4" size="5" value="600" /> <sub>ms</sub>&nbsp;
						</td>
					</tr>
					<tr>
						<td></td>
						<td><small>Type and Delay</small></td>
					</tr>
				</table>

				<br />

			<!-- Frontpage Products -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Frontpage Products</strong></h3></td>
					</tr>
					<tr>
						<td><label for="use_frontpage_products_animations">Use Animations?</label></td>
						<td><input type="checkbox" name="use_frontpage_products_animations" id="use_frontpage_products_animations" checked="checked" /></td>
					</tr>
					<tr>
						<td><label for="frontpage_products_animation_type_1">Column 1</label></td>
						<td>
							<select name="frontpage_products_animation_type_1" id="frontpage_products_animation_type_1">
								<optgroup label="Fade">
									<option value="fade-in" selected="selected">Fade In</option>
									<option value="fade-in-up">Fade In Up</option>
									<option value="fade-in-down">Fade In Down</option>
									<option value="fade-in-left">Fade In Left</option>
									<option value="fade-in-right">Fade In Right</option>
								</optgroup>
								<optgroup label="Bounce">
									<option value="bounce-in">Bounce In</option>
									<option value="bounce-in-up">Bounce In Up</option>
									<option value="bounce-in-down">Bounce In Down</option>
									<option value="bounce-in-left">Bounce In Left</option>
									<option value="bounce-in-right">Bounce In Right</option>
								</optgroup>
								<optgroup label="Zoom">
									<option value="zoom-in">Zoom In</option>
									<option value="zoom-in-up">Zoom In Up</option>
									<option value="zoom-in-down">Zoom In Down</option>
									<option value="zoom-in-left">Zoom In Left</option>
									<option value="zoom-in-right">Zoom In Right</option>
								</optgroup>
								<optgroup label="Flip">
									<option value="flip-in-x">Flip In X</option>
									<option value="flip-in-y">Flip In Y</option>
									<option value="flip-in-top-front">Flip In Top Front</option>
									<option value="flip-in-top-back">Flip In Top Back</option>
									<option value="flip-in-bottom-front">Flip In Bottom Front</option>
									<option value="flip-in-bottom-back">Flip In Bottom Back</option>
									<option value="flip-in-left-front">Flip In Left Front</option>
									<option value="flip-in-left-back">Flip In Left Back</option>
									<option value="flip-in-right-front">Flip In Right Front</option>
									<option value="flip-in-right-back">Flip In Right Back</option>
								</optgroup>
							</select>
							<input type="text" name="frontpage_products_animation_delay_1" id="frontpage_products_animation_delay_1" size="5" value="0" /> <sub>ms</sub>&nbsp;
						</td>
					</tr>
					<tr>
						<td><label for="frontpage_products_animation_type_2">Column 2</label></td>
						<td>
							<select name="frontpage_products_animation_type_2" id="frontpage_products_animation_type_2">
								<optgroup label="Fade">
									<option value="fade-in" selected="selected">Fade In</option>
									<option value="fade-in-up">Fade In Up</option>
									<option value="fade-in-down">Fade In Down</option>
									<option value="fade-in-left">Fade In Left</option>
									<option value="fade-in-right">Fade In Right</option>
								</optgroup>
								<optgroup label="Bounce">
									<option value="bounce-in">Bounce In</option>
									<option value="bounce-in-up">Bounce In Up</option>
									<option value="bounce-in-down">Bounce In Down</option>
									<option value="bounce-in-left">Bounce In Left</option>
									<option value="bounce-in-right">Bounce In Right</option>
								</optgroup>
								<optgroup label="Zoom">
									<option value="zoom-in">Zoom In</option>
									<option value="zoom-in-up">Zoom In Up</option>
									<option value="zoom-in-down">Zoom In Down</option>
									<option value="zoom-in-left">Zoom In Left</option>
									<option value="zoom-in-right">Zoom In Right</option>
								</optgroup>
								<optgroup label="Flip">
									<option value="flip-in-x">Flip In X</option>
									<option value="flip-in-y">Flip In Y</option>
									<option value="flip-in-top-front">Flip In Top Front</option>
									<option value="flip-in-top-back">Flip In Top Back</option>
									<option value="flip-in-bottom-front">Flip In Bottom Front</option>
									<option value="flip-in-bottom-back">Flip In Bottom Back</option>
									<option value="flip-in-left-front">Flip In Left Front</option>
									<option value="flip-in-left-back">Flip In Left Back</option>
									<option value="flip-in-right-front">Flip In Right Front</option>
									<option value="flip-in-right-back">Flip In Right Back</option>
								</optgroup>
							</select>
							<input type="text" name="frontpage_products_animation_delay_2" id="frontpage_products_animation_delay_2" size="5" value="200" /> <sub>ms</sub>&nbsp;
						</td>
					</tr>
					<tr>
						<td><label for="frontpage_products_animation_type_3">Column 3</label></td>
						<td>
							<select name="frontpage_products_animation_type_3" id="frontpage_products_animation_type_3">
								<optgroup label="Fade">
									<option value="fade-in" selected="selected">Fade In</option>
									<option value="fade-in-up">Fade In Up</option>
									<option value="fade-in-down">Fade In Down</option>
									<option value="fade-in-left">Fade In Left</option>
									<option value="fade-in-right">Fade In Right</option>
								</optgroup>
								<optgroup label="Bounce">
									<option value="bounce-in">Bounce In</option>
									<option value="bounce-in-up">Bounce In Up</option>
									<option value="bounce-in-down">Bounce In Down</option>
									<option value="bounce-in-left">Bounce In Left</option>
									<option value="bounce-in-right">Bounce In Right</option>
								</optgroup>
								<optgroup label="Zoom">
									<option value="zoom-in">Zoom In</option>
									<option value="zoom-in-up">Zoom In Up</option>
									<option value="zoom-in-down">Zoom In Down</option>
									<option value="zoom-in-left">Zoom In Left</option>
									<option value="zoom-in-right">Zoom In Right</option>
								</optgroup>
								<optgroup label="Flip">
									<option value="flip-in-x">Flip In X</option>
									<option value="flip-in-y">Flip In Y</option>
									<option value="flip-in-top-front">Flip In Top Front</option>
									<option value="flip-in-top-back">Flip In Top Back</option>
									<option value="flip-in-bottom-front">Flip In Bottom Front</option>
									<option value="flip-in-bottom-back">Flip In Bottom Back</option>
									<option value="flip-in-left-front">Flip In Left Front</option>
									<option value="flip-in-left-back">Flip In Left Back</option>
									<option value="flip-in-right-front">Flip In Right Front</option>
									<option value="flip-in-right-back">Flip In Right Back</option>
								</optgroup>
							</select>
							<input type="text" name="frontpage_products_animation_delay_3" id="frontpage_products_animation_delay_3" size="5" value="400" /> <sub>ms</sub>&nbsp;
						</td>
					</tr>
					<tr>
						<td><label for="frontpage_products_animation_type_4">Column 4</label></td>
						<td>
							<select name="frontpage_products_animation_type_4" id="frontpage_products_animation_type_4">
								<optgroup label="Fade">
									<option value="fade-in" selected="selected">Fade In</option>
									<option value="fade-in-up">Fade In Up</option>
									<option value="fade-in-down">Fade In Down</option>
									<option value="fade-in-left">Fade In Left</option>
									<option value="fade-in-right">Fade In Right</option>
								</optgroup>
								<optgroup label="Bounce">
									<option value="bounce-in">Bounce In</option>
									<option value="bounce-in-up">Bounce In Up</option>
									<option value="bounce-in-down">Bounce In Down</option>
									<option value="bounce-in-left">Bounce In Left</option>
									<option value="bounce-in-right">Bounce In Right</option>
								</optgroup>
								<optgroup label="Zoom">
									<option value="zoom-in">Zoom In</option>
									<option value="zoom-in-up">Zoom In Up</option>
									<option value="zoom-in-down">Zoom In Down</option>
									<option value="zoom-in-left">Zoom In Left</option>
									<option value="zoom-in-right">Zoom In Right</option>
								</optgroup>
								<optgroup label="Flip">
									<option value="flip-in-x">Flip In X</option>
									<option value="flip-in-y">Flip In Y</option>
									<option value="flip-in-top-front">Flip In Top Front</option>
									<option value="flip-in-top-back">Flip In Top Back</option>
									<option value="flip-in-bottom-front">Flip In Bottom Front</option>
									<option value="flip-in-bottom-back">Flip In Bottom Back</option>
									<option value="flip-in-left-front">Flip In Left Front</option>
									<option value="flip-in-left-back">Flip In Left Back</option>
									<option value="flip-in-right-front">Flip In Right Front</option>
									<option value="flip-in-right-back">Flip In Right Back</option>
								</optgroup>
							</select>
							<input type="text" name="frontpage_products_animation_delay_4" id="frontpage_products_animation_delay_4" size="5" value="600" /> <sub>ms</sub>&nbsp;
						</td>
					</tr>
					<tr>
						<td></td>
						<td><small>Type and Delay</small></td>
					</tr>
				</table>

				<br />

			<!-- Frontpage Articles -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Frontpage Articles</strong></h3></td>
					</tr>
					<tr>
						<td><label for="use_frontpage_articles_animations">Use Animations?</label></td>
						<td><input type="checkbox" name="use_frontpage_articles_animations" id="use_frontpage_articles_animations" checked="checked" /></td>
					</tr>
					<tr>
						<td><label for="frontpage_articles_animation_type_1">Column 1</label></td>
						<td>
							<select name="frontpage_articles_animation_type_1" id="frontpage_articles_animation_type_1">
								<optgroup label="Fade">
									<option value="fade-in" selected="selected">Fade In</option>
									<option value="fade-in-up">Fade In Up</option>
									<option value="fade-in-down">Fade In Down</option>
									<option value="fade-in-left">Fade In Left</option>
									<option value="fade-in-right">Fade In Right</option>
								</optgroup>
								<optgroup label="Bounce">
									<option value="bounce-in">Bounce In</option>
									<option value="bounce-in-up">Bounce In Up</option>
									<option value="bounce-in-down">Bounce In Down</option>
									<option value="bounce-in-left">Bounce In Left</option>
									<option value="bounce-in-right">Bounce In Right</option>
								</optgroup>
								<optgroup label="Zoom">
									<option value="zoom-in">Zoom In</option>
									<option value="zoom-in-up">Zoom In Up</option>
									<option value="zoom-in-down">Zoom In Down</option>
									<option value="zoom-in-left">Zoom In Left</option>
									<option value="zoom-in-right">Zoom In Right</option>
								</optgroup>
								<optgroup label="Flip">
									<option value="flip-in-x">Flip In X</option>
									<option value="flip-in-y">Flip In Y</option>
									<option value="flip-in-top-front">Flip In Top Front</option>
									<option value="flip-in-top-back">Flip In Top Back</option>
									<option value="flip-in-bottom-front">Flip In Bottom Front</option>
									<option value="flip-in-bottom-back">Flip In Bottom Back</option>
									<option value="flip-in-left-front">Flip In Left Front</option>
									<option value="flip-in-left-back">Flip In Left Back</option>
									<option value="flip-in-right-front">Flip In Right Front</option>
									<option value="flip-in-right-back">Flip In Right Back</option>
								</optgroup>
							</select>
							<input type="text" name="frontpage_articles_animation_delay_1" id="frontpage_articles_animation_delay_1" size="5" value="0" /> <sub>ms</sub>&nbsp;
						</td>
					</tr>
					<tr>
						<td><label for="frontpage_articles_animation_type_2">Column 2</label></td>
						<td>
							<select name="frontpage_articles_animation_type_2" id="frontpage_articles_animation_type_2">
								<optgroup label="Fade">
									<option value="fade-in" selected="selected">Fade In</option>
									<option value="fade-in-up">Fade In Up</option>
									<option value="fade-in-down">Fade In Down</option>
									<option value="fade-in-left">Fade In Left</option>
									<option value="fade-in-right">Fade In Right</option>
								</optgroup>
								<optgroup label="Bounce">
									<option value="bounce-in">Bounce In</option>
									<option value="bounce-in-up">Bounce In Up</option>
									<option value="bounce-in-down">Bounce In Down</option>
									<option value="bounce-in-left">Bounce In Left</option>
									<option value="bounce-in-right">Bounce In Right</option>
								</optgroup>
								<optgroup label="Zoom">
									<option value="zoom-in">Zoom In</option>
									<option value="zoom-in-up">Zoom In Up</option>
									<option value="zoom-in-down">Zoom In Down</option>
									<option value="zoom-in-left">Zoom In Left</option>
									<option value="zoom-in-right">Zoom In Right</option>
								</optgroup>
								<optgroup label="Flip">
									<option value="flip-in-x">Flip In X</option>
									<option value="flip-in-y">Flip In Y</option>
									<option value="flip-in-top-front">Flip In Top Front</option>
									<option value="flip-in-top-back">Flip In Top Back</option>
									<option value="flip-in-bottom-front">Flip In Bottom Front</option>
									<option value="flip-in-bottom-back">Flip In Bottom Back</option>
									<option value="flip-in-left-front">Flip In Left Front</option>
									<option value="flip-in-left-back">Flip In Left Back</option>
									<option value="flip-in-right-front">Flip In Right Front</option>
									<option value="flip-in-right-back">Flip In Right Back</option>
								</optgroup>
							</select>
							<input type="text" name="frontpage_articles_animation_delay_2" id="frontpage_articles_animation_delay_2" size="5" value="200" /> <sub>ms</sub>&nbsp;
						</td>
					</tr>
					<tr>
						<td><label for="frontpage_articles_animation_type_3">Column 3</label></td>
						<td>
							<select name="frontpage_articles_animation_type_3" id="frontpage_articles_animation_type_3">
								<optgroup label="Fade">
									<option value="fade-in" selected="selected">Fade In</option>
									<option value="fade-in-up">Fade In Up</option>
									<option value="fade-in-down">Fade In Down</option>
									<option value="fade-in-left">Fade In Left</option>
									<option value="fade-in-right">Fade In Right</option>
								</optgroup>
								<optgroup label="Bounce">
									<option value="bounce-in">Bounce In</option>
									<option value="bounce-in-up">Bounce In Up</option>
									<option value="bounce-in-down">Bounce In Down</option>
									<option value="bounce-in-left">Bounce In Left</option>
									<option value="bounce-in-right">Bounce In Right</option>
								</optgroup>
								<optgroup label="Zoom">
									<option value="zoom-in">Zoom In</option>
									<option value="zoom-in-up">Zoom In Up</option>
									<option value="zoom-in-down">Zoom In Down</option>
									<option value="zoom-in-left">Zoom In Left</option>
									<option value="zoom-in-right">Zoom In Right</option>
								</optgroup>
								<optgroup label="Flip">
									<option value="flip-in-x">Flip In X</option>
									<option value="flip-in-y">Flip In Y</option>
									<option value="flip-in-top-front">Flip In Top Front</option>
									<option value="flip-in-top-back">Flip In Top Back</option>
									<option value="flip-in-bottom-front">Flip In Bottom Front</option>
									<option value="flip-in-bottom-back">Flip In Bottom Back</option>
									<option value="flip-in-left-front">Flip In Left Front</option>
									<option value="flip-in-left-back">Flip In Left Back</option>
									<option value="flip-in-right-front">Flip In Right Front</option>
									<option value="flip-in-right-back">Flip In Right Back</option>
								</optgroup>
							</select>
							<input type="text" name="frontpage_articles_animation_delay_3" id="frontpage_articles_animation_delay_3" size="5" value="400" /> <sub>ms</sub>&nbsp;
						</td>
					</tr>
					<tr>
						<td><label for="frontpage_articles_animation_type_4">Column 4</label></td>
						<td>
							<select name="frontpage_articles_animation_type_4" id="frontpage_articles_animation_type_4">
								<optgroup label="Fade">
									<option value="fade-in" selected="selected">Fade In</option>
									<option value="fade-in-up">Fade In Up</option>
									<option value="fade-in-down">Fade In Down</option>
									<option value="fade-in-left">Fade In Left</option>
									<option value="fade-in-right">Fade In Right</option>
								</optgroup>
								<optgroup label="Bounce">
									<option value="bounce-in">Bounce In</option>
									<option value="bounce-in-up">Bounce In Up</option>
									<option value="bounce-in-down">Bounce In Down</option>
									<option value="bounce-in-left">Bounce In Left</option>
									<option value="bounce-in-right">Bounce In Right</option>
								</optgroup>
								<optgroup label="Zoom">
									<option value="zoom-in">Zoom In</option>
									<option value="zoom-in-up">Zoom In Up</option>
									<option value="zoom-in-down">Zoom In Down</option>
									<option value="zoom-in-left">Zoom In Left</option>
									<option value="zoom-in-right">Zoom In Right</option>
								</optgroup>
								<optgroup label="Flip">
									<option value="flip-in-x">Flip In X</option>
									<option value="flip-in-y">Flip In Y</option>
									<option value="flip-in-top-front">Flip In Top Front</option>
									<option value="flip-in-top-back">Flip In Top Back</option>
									<option value="flip-in-bottom-front">Flip In Bottom Front</option>
									<option value="flip-in-bottom-back">Flip In Bottom Back</option>
									<option value="flip-in-left-front">Flip In Left Front</option>
									<option value="flip-in-left-back">Flip In Left Back</option>
									<option value="flip-in-right-front">Flip In Right Front</option>
									<option value="flip-in-right-back">Flip In Right Back</option>
								</optgroup>
							</select>
							<input type="text" name="frontpage_articles_animation_delay_4" id="frontpage_articles_animation_delay_4" size="5" value="600" /> <sub>ms</sub>&nbsp;
						</td>
					</tr>
					<tr>
						<td></td>
						<td><small>Type and Delay</small></td>
					</tr>
				</table>

				<br />

			<!-- Collection Listing -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Collection Listing</strong></h3></td>
					</tr>
					<tr>
						<td><label for="use_collections_animations">Use Animations?</label></td>
						<td><input type="checkbox" name="use_collections_animations" id="use_collections_animations" checked="checked" /></td>
					</tr>
					<tr>
						<td><label for="collections_animation_type_1">Column 1</label></td>
						<td>
							<select name="collections_animation_type_1" id="collections_animation_type_1">
								<optgroup label="Fade">
									<option value="fade-in" selected="selected">Fade In</option>
									<option value="fade-in-up">Fade In Up</option>
									<option value="fade-in-down">Fade In Down</option>
									<option value="fade-in-left">Fade In Left</option>
									<option value="fade-in-right">Fade In Right</option>
								</optgroup>
								<optgroup label="Bounce">
									<option value="bounce-in">Bounce In</option>
									<option value="bounce-in-up">Bounce In Up</option>
									<option value="bounce-in-down">Bounce In Down</option>
									<option value="bounce-in-left">Bounce In Left</option>
									<option value="bounce-in-right">Bounce In Right</option>
								</optgroup>
								<optgroup label="Zoom">
									<option value="zoom-in">Zoom In</option>
									<option value="zoom-in-up">Zoom In Up</option>
									<option value="zoom-in-down">Zoom In Down</option>
									<option value="zoom-in-left">Zoom In Left</option>
									<option value="zoom-in-right">Zoom In Right</option>
								</optgroup>
								<optgroup label="Flip">
									<option value="flip-in-x">Flip In X</option>
									<option value="flip-in-y">Flip In Y</option>
									<option value="flip-in-top-front">Flip In Top Front</option>
									<option value="flip-in-top-back">Flip In Top Back</option>
									<option value="flip-in-bottom-front">Flip In Bottom Front</option>
									<option value="flip-in-bottom-back">Flip In Bottom Back</option>
									<option value="flip-in-left-front">Flip In Left Front</option>
									<option value="flip-in-left-back">Flip In Left Back</option>
									<option value="flip-in-right-front">Flip In Right Front</option>
									<option value="flip-in-right-back">Flip In Right Back</option>
								</optgroup>
							</select>
							<input type="text" name="collections_animation_delay_1" id="collections_animation_delay_1" size="5" value="0" /> <sub>ms</sub>&nbsp;
						</td>
					</tr>
					<tr>
						<td><label for="collections_animation_type_2">Column 2</label></td>
						<td>
							<select name="collections_animation_type_2" id="collections_animation_type_2">
								<optgroup label="Fade">
									<option value="fade-in" selected="selected">Fade In</option>
									<option value="fade-in-up">Fade In Up</option>
									<option value="fade-in-down">Fade In Down</option>
									<option value="fade-in-left">Fade In Left</option>
									<option value="fade-in-right">Fade In Right</option>
								</optgroup>
								<optgroup label="Bounce">
									<option value="bounce-in">Bounce In</option>
									<option value="bounce-in-up">Bounce In Up</option>
									<option value="bounce-in-down">Bounce In Down</option>
									<option value="bounce-in-left">Bounce In Left</option>
									<option value="bounce-in-right">Bounce In Right</option>
								</optgroup>
								<optgroup label="Zoom">
									<option value="zoom-in">Zoom In</option>
									<option value="zoom-in-up">Zoom In Up</option>
									<option value="zoom-in-down">Zoom In Down</option>
									<option value="zoom-in-left">Zoom In Left</option>
									<option value="zoom-in-right">Zoom In Right</option>
								</optgroup>
								<optgroup label="Flip">
									<option value="flip-in-x">Flip In X</option>
									<option value="flip-in-y">Flip In Y</option>
									<option value="flip-in-top-front">Flip In Top Front</option>
									<option value="flip-in-top-back">Flip In Top Back</option>
									<option value="flip-in-bottom-front">Flip In Bottom Front</option>
									<option value="flip-in-bottom-back">Flip In Bottom Back</option>
									<option value="flip-in-left-front">Flip In Left Front</option>
									<option value="flip-in-left-back">Flip In Left Back</option>
									<option value="flip-in-right-front">Flip In Right Front</option>
									<option value="flip-in-right-back">Flip In Right Back</option>
								</optgroup>
							</select>
							<input type="text" name="collections_animation_delay_2" id="collections_animation_delay_2" size="5" value="200" /> <sub>ms</sub>&nbsp;
						</td>
					</tr>
					<tr>
						<td><label for="collections_animation_type_3">Column 3</label></td>
						<td>
							<select name="collections_animation_type_3" id="collections_animation_type_3">
								<optgroup label="Fade">
									<option value="fade-in" selected="selected">Fade In</option>
									<option value="fade-in-up">Fade In Up</option>
									<option value="fade-in-down">Fade In Down</option>
									<option value="fade-in-left">Fade In Left</option>
									<option value="fade-in-right">Fade In Right</option>
								</optgroup>
								<optgroup label="Bounce">
									<option value="bounce-in">Bounce In</option>
									<option value="bounce-in-up">Bounce In Up</option>
									<option value="bounce-in-down">Bounce In Down</option>
									<option value="bounce-in-left">Bounce In Left</option>
									<option value="bounce-in-right">Bounce In Right</option>
								</optgroup>
								<optgroup label="Zoom">
									<option value="zoom-in">Zoom In</option>
									<option value="zoom-in-up">Zoom In Up</option>
									<option value="zoom-in-down">Zoom In Down</option>
									<option value="zoom-in-left">Zoom In Left</option>
									<option value="zoom-in-right">Zoom In Right</option>
								</optgroup>
								<optgroup label="Flip">
									<option value="flip-in-x">Flip In X</option>
									<option value="flip-in-y">Flip In Y</option>
									<option value="flip-in-top-front">Flip In Top Front</option>
									<option value="flip-in-top-back">Flip In Top Back</option>
									<option value="flip-in-bottom-front">Flip In Bottom Front</option>
									<option value="flip-in-bottom-back">Flip In Bottom Back</option>
									<option value="flip-in-left-front">Flip In Left Front</option>
									<option value="flip-in-left-back">Flip In Left Back</option>
									<option value="flip-in-right-front">Flip In Right Front</option>
									<option value="flip-in-right-back">Flip In Right Back</option>
								</optgroup>
							</select>
							<input type="text" name="collections_animation_delay_3" id="collections_animation_delay_3" size="5" value="400" /> <sub>ms</sub>&nbsp;
						</td>
					</tr>
					<tr>
						<td><label for="collections_animation_type_4">Column 4</label></td>
						<td>
							<select name="collections_animation_type_4" id="collections_animation_type_4">
								<optgroup label="Fade">
									<option value="fade-in" selected="selected">Fade In</option>
									<option value="fade-in-up">Fade In Up</option>
									<option value="fade-in-down">Fade In Down</option>
									<option value="fade-in-left">Fade In Left</option>
									<option value="fade-in-right">Fade In Right</option>
								</optgroup>
								<optgroup label="Bounce">
									<option value="bounce-in">Bounce In</option>
									<option value="bounce-in-up">Bounce In Up</option>
									<option value="bounce-in-down">Bounce In Down</option>
									<option value="bounce-in-left">Bounce In Left</option>
									<option value="bounce-in-right">Bounce In Right</option>
								</optgroup>
								<optgroup label="Zoom">
									<option value="zoom-in">Zoom In</option>
									<option value="zoom-in-up">Zoom In Up</option>
									<option value="zoom-in-down">Zoom In Down</option>
									<option value="zoom-in-left">Zoom In Left</option>
									<option value="zoom-in-right">Zoom In Right</option>
								</optgroup>
								<optgroup label="Flip">
									<option value="flip-in-x">Flip In X</option>
									<option value="flip-in-y">Flip In Y</option>
									<option value="flip-in-top-front">Flip In Top Front</option>
									<option value="flip-in-top-back">Flip In Top Back</option>
									<option value="flip-in-bottom-front">Flip In Bottom Front</option>
									<option value="flip-in-bottom-back">Flip In Bottom Back</option>
									<option value="flip-in-left-front">Flip In Left Front</option>
									<option value="flip-in-left-back">Flip In Left Back</option>
									<option value="flip-in-right-front">Flip In Right Front</option>
									<option value="flip-in-right-back">Flip In Right Back</option>
								</optgroup>
							</select>
							<input type="text" name="collections_animation_delay_4" id="collections_animation_delay_4" size="5" value="600" /> <sub>ms</sub>&nbsp;
						</td>
					</tr>
					<tr>
						<td></td>
						<td><small>Type and Delay</small></td>
					</tr>
				</table>

				<br />

			<!-- Product Listing -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Product Listing</strong></h3></td>
					</tr>
					<tr>
						<td><label for="use_products_animations">Use Animations?</label></td>
						<td><input type="checkbox" name="use_products_animations" id="use_products_animations" checked="checked" /></td>
					</tr>
					<tr>
						<td><label for="products_animation_type_1">Column 1</label></td>
						<td>
							<select name="products_animation_type_1" id="products_animation_type_1">
								<optgroup label="Fade">
									<option value="fade-in" selected="selected">Fade In</option>
									<option value="fade-in-up">Fade In Up</option>
									<option value="fade-in-down">Fade In Down</option>
									<option value="fade-in-left">Fade In Left</option>
									<option value="fade-in-right">Fade In Right</option>
								</optgroup>
								<optgroup label="Bounce">
									<option value="bounce-in">Bounce In</option>
									<option value="bounce-in-up">Bounce In Up</option>
									<option value="bounce-in-down">Bounce In Down</option>
									<option value="bounce-in-left">Bounce In Left</option>
									<option value="bounce-in-right">Bounce In Right</option>
								</optgroup>
								<optgroup label="Zoom">
									<option value="zoom-in">Zoom In</option>
									<option value="zoom-in-up">Zoom In Up</option>
									<option value="zoom-in-down">Zoom In Down</option>
									<option value="zoom-in-left">Zoom In Left</option>
									<option value="zoom-in-right">Zoom In Right</option>
								</optgroup>
								<optgroup label="Flip">
									<option value="flip-in-x">Flip In X</option>
									<option value="flip-in-y">Flip In Y</option>
									<option value="flip-in-top-front">Flip In Top Front</option>
									<option value="flip-in-top-back">Flip In Top Back</option>
									<option value="flip-in-bottom-front">Flip In Bottom Front</option>
									<option value="flip-in-bottom-back">Flip In Bottom Back</option>
									<option value="flip-in-left-front">Flip In Left Front</option>
									<option value="flip-in-left-back">Flip In Left Back</option>
									<option value="flip-in-right-front">Flip In Right Front</option>
									<option value="flip-in-right-back">Flip In Right Back</option>
								</optgroup>
							</select>
							<input type="text" name="products_animation_delay_1" id="products_animation_delay_1" size="5" value="0" /> <sub>ms</sub>&nbsp;
						</td>
					</tr>
					<tr>
						<td><label for="products_animation_type_2">Column 2</label></td>
						<td>
							<select name="products_animation_type_2" id="products_animation_type_2">
								<optgroup label="Fade">
									<option value="fade-in" selected="selected">Fade In</option>
									<option value="fade-in-up">Fade In Up</option>
									<option value="fade-in-down">Fade In Down</option>
									<option value="fade-in-left">Fade In Left</option>
									<option value="fade-in-right">Fade In Right</option>
								</optgroup>
								<optgroup label="Bounce">
									<option value="bounce-in">Bounce In</option>
									<option value="bounce-in-up">Bounce In Up</option>
									<option value="bounce-in-down">Bounce In Down</option>
									<option value="bounce-in-left">Bounce In Left</option>
									<option value="bounce-in-right">Bounce In Right</option>
								</optgroup>
								<optgroup label="Zoom">
									<option value="zoom-in">Zoom In</option>
									<option value="zoom-in-up">Zoom In Up</option>
									<option value="zoom-in-down">Zoom In Down</option>
									<option value="zoom-in-left">Zoom In Left</option>
									<option value="zoom-in-right">Zoom In Right</option>
								</optgroup>
								<optgroup label="Flip">
									<option value="flip-in-x">Flip In X</option>
									<option value="flip-in-y">Flip In Y</option>
									<option value="flip-in-top-front">Flip In Top Front</option>
									<option value="flip-in-top-back">Flip In Top Back</option>
									<option value="flip-in-bottom-front">Flip In Bottom Front</option>
									<option value="flip-in-bottom-back">Flip In Bottom Back</option>
									<option value="flip-in-left-front">Flip In Left Front</option>
									<option value="flip-in-left-back">Flip In Left Back</option>
									<option value="flip-in-right-front">Flip In Right Front</option>
									<option value="flip-in-right-back">Flip In Right Back</option>
								</optgroup>
							</select>
							<input type="text" name="products_animation_delay_2" id="products_animation_delay_2" size="5" value="200" /> <sub>ms</sub>&nbsp;
						</td>
					</tr>
					<tr>
						<td><label for="products_animation_type_3">Column 3</label></td>
						<td>
							<select name="products_animation_type_3" id="products_animation_type_3">
								<optgroup label="Fade">
									<option value="fade-in" selected="selected">Fade In</option>
									<option value="fade-in-up">Fade In Up</option>
									<option value="fade-in-down">Fade In Down</option>
									<option value="fade-in-left">Fade In Left</option>
									<option value="fade-in-right">Fade In Right</option>
								</optgroup>
								<optgroup label="Bounce">
									<option value="bounce-in">Bounce In</option>
									<option value="bounce-in-up">Bounce In Up</option>
									<option value="bounce-in-down">Bounce In Down</option>
									<option value="bounce-in-left">Bounce In Left</option>
									<option value="bounce-in-right">Bounce In Right</option>
								</optgroup>
								<optgroup label="Zoom">
									<option value="zoom-in">Zoom In</option>
									<option value="zoom-in-up">Zoom In Up</option>
									<option value="zoom-in-down">Zoom In Down</option>
									<option value="zoom-in-left">Zoom In Left</option>
									<option value="zoom-in-right">Zoom In Right</option>
								</optgroup>
								<optgroup label="Flip">
									<option value="flip-in-x">Flip In X</option>
									<option value="flip-in-y">Flip In Y</option>
									<option value="flip-in-top-front">Flip In Top Front</option>
									<option value="flip-in-top-back">Flip In Top Back</option>
									<option value="flip-in-bottom-front">Flip In Bottom Front</option>
									<option value="flip-in-bottom-back">Flip In Bottom Back</option>
									<option value="flip-in-left-front">Flip In Left Front</option>
									<option value="flip-in-left-back">Flip In Left Back</option>
									<option value="flip-in-right-front">Flip In Right Front</option>
									<option value="flip-in-right-back">Flip In Right Back</option>
								</optgroup>
							</select>
							<input type="text" name="products_animation_delay_3" id="products_animation_delay_3" size="5" value="400" /> <sub>ms</sub>&nbsp;
						</td>
					</tr>
					<tr>
						<td><label for="products_animation_type_4">Column 4</label></td>
						<td>
							<select name="products_animation_type_4" id="products_animation_type_4">
								<optgroup label="Fade">
									<option value="fade-in" selected="selected">Fade In</option>
									<option value="fade-in-up">Fade In Up</option>
									<option value="fade-in-down">Fade In Down</option>
									<option value="fade-in-left">Fade In Left</option>
									<option value="fade-in-right">Fade In Right</option>
								</optgroup>
								<optgroup label="Bounce">
									<option value="bounce-in">Bounce In</option>
									<option value="bounce-in-up">Bounce In Up</option>
									<option value="bounce-in-down">Bounce In Down</option>
									<option value="bounce-in-left">Bounce In Left</option>
									<option value="bounce-in-right">Bounce In Right</option>
								</optgroup>
								<optgroup label="Zoom">
									<option value="zoom-in">Zoom In</option>
									<option value="zoom-in-up">Zoom In Up</option>
									<option value="zoom-in-down">Zoom In Down</option>
									<option value="zoom-in-left">Zoom In Left</option>
									<option value="zoom-in-right">Zoom In Right</option>
								</optgroup>
								<optgroup label="Flip">
									<option value="flip-in-x">Flip In X</option>
									<option value="flip-in-y">Flip In Y</option>
									<option value="flip-in-top-front">Flip In Top Front</option>
									<option value="flip-in-top-back">Flip In Top Back</option>
									<option value="flip-in-bottom-front">Flip In Bottom Front</option>
									<option value="flip-in-bottom-back">Flip In Bottom Back</option>
									<option value="flip-in-left-front">Flip In Left Front</option>
									<option value="flip-in-left-back">Flip In Left Back</option>
									<option value="flip-in-right-front">Flip In Right Front</option>
									<option value="flip-in-right-back">Flip In Right Back</option>
								</optgroup>
							</select>
							<input type="text" name="products_animation_delay_4" id="products_animation_delay_4" size="5" value="600" /> <sub>ms</sub>&nbsp;
						</td>
					</tr>
					<tr>
						<td></td>
						<td><small>Type and Delay</small></td>
					</tr>
				</table>

				<br />

			<!-- Search Results -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Search Results</strong></h3></td>
					</tr>
					<tr>
						<td><label for="use_search_results_animations">Use Animations?</label></td>
						<td><input type="checkbox" name="use_search_results_animations" id="use_search_results_animations" checked="checked" /></td>
					</tr>
					<tr>
						<td><label for="search_results_animation_type_1">Column 1</label></td>
						<td>
							<select name="search_results_animation_type_1" id="search_results_animation_type_1">
								<optgroup label="Fade">
									<option value="fade-in" selected="selected">Fade In</option>
									<option value="fade-in-up">Fade In Up</option>
									<option value="fade-in-down">Fade In Down</option>
									<option value="fade-in-left">Fade In Left</option>
									<option value="fade-in-right">Fade In Right</option>
								</optgroup>
								<optgroup label="Bounce">
									<option value="bounce-in">Bounce In</option>
									<option value="bounce-in-up">Bounce In Up</option>
									<option value="bounce-in-down">Bounce In Down</option>
									<option value="bounce-in-left">Bounce In Left</option>
									<option value="bounce-in-right">Bounce In Right</option>
								</optgroup>
								<optgroup label="Zoom">
									<option value="zoom-in">Zoom In</option>
									<option value="zoom-in-up">Zoom In Up</option>
									<option value="zoom-in-down">Zoom In Down</option>
									<option value="zoom-in-left">Zoom In Left</option>
									<option value="zoom-in-right">Zoom In Right</option>
								</optgroup>
								<optgroup label="Flip">
									<option value="flip-in-x">Flip In X</option>
									<option value="flip-in-y">Flip In Y</option>
									<option value="flip-in-top-front">Flip In Top Front</option>
									<option value="flip-in-top-back">Flip In Top Back</option>
									<option value="flip-in-bottom-front">Flip In Bottom Front</option>
									<option value="flip-in-bottom-back">Flip In Bottom Back</option>
									<option value="flip-in-left-front">Flip In Left Front</option>
									<option value="flip-in-left-back">Flip In Left Back</option>
									<option value="flip-in-right-front">Flip In Right Front</option>
									<option value="flip-in-right-back">Flip In Right Back</option>
								</optgroup>
							</select>
							<input type="text" name="search_results_animation_delay_1" id="search_results_animation_delay_1" size="5" value="0" /> <sub>ms</sub>&nbsp;
						</td>
					</tr>
					<tr>
						<td><label for="search_results_animation_type_2">Column 2</label></td>
						<td>
							<select name="search_results_animation_type_2" id="search_results_animation_type_2">
								<optgroup label="Fade">
									<option value="fade-in" selected="selected">Fade In</option>
									<option value="fade-in-up">Fade In Up</option>
									<option value="fade-in-down">Fade In Down</option>
									<option value="fade-in-left">Fade In Left</option>
									<option value="fade-in-right">Fade In Right</option>
								</optgroup>
								<optgroup label="Bounce">
									<option value="bounce-in">Bounce In</option>
									<option value="bounce-in-up">Bounce In Up</option>
									<option value="bounce-in-down">Bounce In Down</option>
									<option value="bounce-in-left">Bounce In Left</option>
									<option value="bounce-in-right">Bounce In Right</option>
								</optgroup>
								<optgroup label="Zoom">
									<option value="zoom-in">Zoom In</option>
									<option value="zoom-in-up">Zoom In Up</option>
									<option value="zoom-in-down">Zoom In Down</option>
									<option value="zoom-in-left">Zoom In Left</option>
									<option value="zoom-in-right">Zoom In Right</option>
								</optgroup>
								<optgroup label="Flip">
									<option value="flip-in-x">Flip In X</option>
									<option value="flip-in-y">Flip In Y</option>
									<option value="flip-in-top-front">Flip In Top Front</option>
									<option value="flip-in-top-back">Flip In Top Back</option>
									<option value="flip-in-bottom-front">Flip In Bottom Front</option>
									<option value="flip-in-bottom-back">Flip In Bottom Back</option>
									<option value="flip-in-left-front">Flip In Left Front</option>
									<option value="flip-in-left-back">Flip In Left Back</option>
									<option value="flip-in-right-front">Flip In Right Front</option>
									<option value="flip-in-right-back">Flip In Right Back</option>
								</optgroup>
							</select>
							<input type="text" name="search_results_animation_delay_2" id="search_results_animation_delay_2" size="5" value="200" /> <sub>ms</sub>&nbsp;
						</td>
					</tr>
					<tr>
						<td><label for="search_results_animation_type_3">Column 3</label></td>
						<td>
							<select name="search_results_animation_type_3" id="search_results_animation_type_3">
								<optgroup label="Fade">
									<option value="fade-in" selected="selected">Fade In</option>
									<option value="fade-in-up">Fade In Up</option>
									<option value="fade-in-down">Fade In Down</option>
									<option value="fade-in-left">Fade In Left</option>
									<option value="fade-in-right">Fade In Right</option>
								</optgroup>
								<optgroup label="Bounce">
									<option value="bounce-in">Bounce In</option>
									<option value="bounce-in-up">Bounce In Up</option>
									<option value="bounce-in-down">Bounce In Down</option>
									<option value="bounce-in-left">Bounce In Left</option>
									<option value="bounce-in-right">Bounce In Right</option>
								</optgroup>
								<optgroup label="Zoom">
									<option value="zoom-in">Zoom In</option>
									<option value="zoom-in-up">Zoom In Up</option>
									<option value="zoom-in-down">Zoom In Down</option>
									<option value="zoom-in-left">Zoom In Left</option>
									<option value="zoom-in-right">Zoom In Right</option>
								</optgroup>
								<optgroup label="Flip">
									<option value="flip-in-x">Flip In X</option>
									<option value="flip-in-y">Flip In Y</option>
									<option value="flip-in-top-front">Flip In Top Front</option>
									<option value="flip-in-top-back">Flip In Top Back</option>
									<option value="flip-in-bottom-front">Flip In Bottom Front</option>
									<option value="flip-in-bottom-back">Flip In Bottom Back</option>
									<option value="flip-in-left-front">Flip In Left Front</option>
									<option value="flip-in-left-back">Flip In Left Back</option>
									<option value="flip-in-right-front">Flip In Right Front</option>
									<option value="flip-in-right-back">Flip In Right Back</option>
								</optgroup>
							</select>
							<input type="text" name="search_results_animation_delay_3" id="search_results_animation_delay_3" size="5" value="400" /> <sub>ms</sub>&nbsp;
						</td>
					</tr>
					<tr>
						<td><label for="search_results_animation_type_4">Column 4</label></td>
						<td>
							<select name="search_results_animation_type_4" id="search_results_animation_type_4">
								<optgroup label="Fade">
									<option value="fade-in" selected="selected">Fade In</option>
									<option value="fade-in-up">Fade In Up</option>
									<option value="fade-in-down">Fade In Down</option>
									<option value="fade-in-left">Fade In Left</option>
									<option value="fade-in-right">Fade In Right</option>
								</optgroup>
								<optgroup label="Bounce">
									<option value="bounce-in">Bounce In</option>
									<option value="bounce-in-up">Bounce In Up</option>
									<option value="bounce-in-down">Bounce In Down</option>
									<option value="bounce-in-left">Bounce In Left</option>
									<option value="bounce-in-right">Bounce In Right</option>
								</optgroup>
								<optgroup label="Zoom">
									<option value="zoom-in">Zoom In</option>
									<option value="zoom-in-up">Zoom In Up</option>
									<option value="zoom-in-down">Zoom In Down</option>
									<option value="zoom-in-left">Zoom In Left</option>
									<option value="zoom-in-right">Zoom In Right</option>
								</optgroup>
								<optgroup label="Flip">
									<option value="flip-in-x">Flip In X</option>
									<option value="flip-in-y">Flip In Y</option>
									<option value="flip-in-top-front">Flip In Top Front</option>
									<option value="flip-in-top-back">Flip In Top Back</option>
									<option value="flip-in-bottom-front">Flip In Bottom Front</option>
									<option value="flip-in-bottom-back">Flip In Bottom Back</option>
									<option value="flip-in-left-front">Flip In Left Front</option>
									<option value="flip-in-left-back">Flip In Left Back</option>
									<option value="flip-in-right-front">Flip In Right Front</option>
									<option value="flip-in-right-back">Flip In Right Back</option>
								</optgroup>
							</select>
							<input type="text" name="search_results_animation_delay_4" id="search_results_animation_delay_4" size="5" value="600" /> <sub>ms</sub>&nbsp;
						</td>
					</tr>
					<tr>
						<td></td>
						<td><small>Type and Delay</small></td>
					</tr>
				</table>

				<br />

			<!-- Articles -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Articles</strong></h3></td>
					</tr>
					<tr>
						<td><label for="use_articles_animations">Use Animations?</label></td>
						<td><input type="checkbox" name="use_articles_animations" id="use_articles_animations" checked="checked" /></td>
					</tr>
					<tr>
						<td><label for="articles_animation_type_1">Column 1</label></td>
						<td>
							<select name="articles_animation_type_1" id="articles_animation_type_1">
								<optgroup label="Fade">
									<option value="fade-in" selected="selected">Fade In</option>
									<option value="fade-in-up">Fade In Up</option>
									<option value="fade-in-down">Fade In Down</option>
									<option value="fade-in-left">Fade In Left</option>
									<option value="fade-in-right">Fade In Right</option>
								</optgroup>
								<optgroup label="Bounce">
									<option value="bounce-in">Bounce In</option>
									<option value="bounce-in-up">Bounce In Up</option>
									<option value="bounce-in-down">Bounce In Down</option>
									<option value="bounce-in-left">Bounce In Left</option>
									<option value="bounce-in-right">Bounce In Right</option>
								</optgroup>
								<optgroup label="Zoom">
									<option value="zoom-in">Zoom In</option>
									<option value="zoom-in-up">Zoom In Up</option>
									<option value="zoom-in-down">Zoom In Down</option>
									<option value="zoom-in-left">Zoom In Left</option>
									<option value="zoom-in-right">Zoom In Right</option>
								</optgroup>
								<optgroup label="Flip">
									<option value="flip-in-x">Flip In X</option>
									<option value="flip-in-y">Flip In Y</option>
									<option value="flip-in-top-front">Flip In Top Front</option>
									<option value="flip-in-top-back">Flip In Top Back</option>
									<option value="flip-in-bottom-front">Flip In Bottom Front</option>
									<option value="flip-in-bottom-back">Flip In Bottom Back</option>
									<option value="flip-in-left-front">Flip In Left Front</option>
									<option value="flip-in-left-back">Flip In Left Back</option>
									<option value="flip-in-right-front">Flip In Right Front</option>
									<option value="flip-in-right-back">Flip In Right Back</option>
								</optgroup>
							</select>
							<input type="text" name="articles_animation_delay_1" id="articles_animation_delay_1" size="5" value="0" /> <sub>ms</sub>&nbsp;
						</td>
					</tr>
					<tr>
						<td><label for="articles_animation_type_2">Column 2</label></td>
						<td>
							<select name="articles_animation_type_2" id="articles_animation_type_2">
								<optgroup label="Fade">
									<option value="fade-in" selected="selected">Fade In</option>
									<option value="fade-in-up">Fade In Up</option>
									<option value="fade-in-down">Fade In Down</option>
									<option value="fade-in-left">Fade In Left</option>
									<option value="fade-in-right">Fade In Right</option>
								</optgroup>
								<optgroup label="Bounce">
									<option value="bounce-in">Bounce In</option>
									<option value="bounce-in-up">Bounce In Up</option>
									<option value="bounce-in-down">Bounce In Down</option>
									<option value="bounce-in-left">Bounce In Left</option>
									<option value="bounce-in-right">Bounce In Right</option>
								</optgroup>
								<optgroup label="Zoom">
									<option value="zoom-in">Zoom In</option>
									<option value="zoom-in-up">Zoom In Up</option>
									<option value="zoom-in-down">Zoom In Down</option>
									<option value="zoom-in-left">Zoom In Left</option>
									<option value="zoom-in-right">Zoom In Right</option>
								</optgroup>
								<optgroup label="Flip">
									<option value="flip-in-x">Flip In X</option>
									<option value="flip-in-y">Flip In Y</option>
									<option value="flip-in-top-front">Flip In Top Front</option>
									<option value="flip-in-top-back">Flip In Top Back</option>
									<option value="flip-in-bottom-front">Flip In Bottom Front</option>
									<option value="flip-in-bottom-back">Flip In Bottom Back</option>
									<option value="flip-in-left-front">Flip In Left Front</option>
									<option value="flip-in-left-back">Flip In Left Back</option>
									<option value="flip-in-right-front">Flip In Right Front</option>
									<option value="flip-in-right-back">Flip In Right Back</option>
								</optgroup>
							</select>
							<input type="text" name="articles_animation_delay_2" id="articles_animation_delay_2" size="5" value="200" /> <sub>ms</sub>&nbsp;
						</td>
					</tr>
					<tr>
						<td><label for="articles_animation_type_3">Column 3</label></td>
						<td>
							<select name="articles_animation_type_3" id="articles_animation_type_3">
								<optgroup label="Fade">
									<option value="fade-in" selected="selected">Fade In</option>
									<option value="fade-in-up">Fade In Up</option>
									<option value="fade-in-down">Fade In Down</option>
									<option value="fade-in-left">Fade In Left</option>
									<option value="fade-in-right">Fade In Right</option>
								</optgroup>
								<optgroup label="Bounce">
									<option value="bounce-in">Bounce In</option>
									<option value="bounce-in-up">Bounce In Up</option>
									<option value="bounce-in-down">Bounce In Down</option>
									<option value="bounce-in-left">Bounce In Left</option>
									<option value="bounce-in-right">Bounce In Right</option>
								</optgroup>
								<optgroup label="Zoom">
									<option value="zoom-in">Zoom In</option>
									<option value="zoom-in-up">Zoom In Up</option>
									<option value="zoom-in-down">Zoom In Down</option>
									<option value="zoom-in-left">Zoom In Left</option>
									<option value="zoom-in-right">Zoom In Right</option>
								</optgroup>
								<optgroup label="Flip">
									<option value="flip-in-x">Flip In X</option>
									<option value="flip-in-y">Flip In Y</option>
									<option value="flip-in-top-front">Flip In Top Front</option>
									<option value="flip-in-top-back">Flip In Top Back</option>
									<option value="flip-in-bottom-front">Flip In Bottom Front</option>
									<option value="flip-in-bottom-back">Flip In Bottom Back</option>
									<option value="flip-in-left-front">Flip In Left Front</option>
									<option value="flip-in-left-back">Flip In Left Back</option>
									<option value="flip-in-right-front">Flip In Right Front</option>
									<option value="flip-in-right-back">Flip In Right Back</option>
								</optgroup>
							</select>
							<input type="text" name="articles_animation_delay_3" id="articles_animation_delay_3" size="5" value="400" /> <sub>ms</sub>&nbsp;
						</td>
					</tr>
					<tr>
						<td><label for="articles_animation_type_4">Column 4</label></td>
						<td>
							<select name="articles_animation_type_4" id="articles_animation_type_4">
								<optgroup label="Fade">
									<option value="fade-in" selected="selected">Fade In</option>
									<option value="fade-in-up">Fade In Up</option>
									<option value="fade-in-down">Fade In Down</option>
									<option value="fade-in-left">Fade In Left</option>
									<option value="fade-in-right">Fade In Right</option>
								</optgroup>
								<optgroup label="Bounce">
									<option value="bounce-in">Bounce In</option>
									<option value="bounce-in-up">Bounce In Up</option>
									<option value="bounce-in-down">Bounce In Down</option>
									<option value="bounce-in-left">Bounce In Left</option>
									<option value="bounce-in-right">Bounce In Right</option>
								</optgroup>
								<optgroup label="Zoom">
									<option value="zoom-in">Zoom In</option>
									<option value="zoom-in-up">Zoom In Up</option>
									<option value="zoom-in-down">Zoom In Down</option>
									<option value="zoom-in-left">Zoom In Left</option>
									<option value="zoom-in-right">Zoom In Right</option>
								</optgroup>
								<optgroup label="Flip">
									<option value="flip-in-x">Flip In X</option>
									<option value="flip-in-y">Flip In Y</option>
									<option value="flip-in-top-front">Flip In Top Front</option>
									<option value="flip-in-top-back">Flip In Top Back</option>
									<option value="flip-in-bottom-front">Flip In Bottom Front</option>
									<option value="flip-in-bottom-back">Flip In Bottom Back</option>
									<option value="flip-in-left-front">Flip In Left Front</option>
									<option value="flip-in-left-back">Flip In Left Back</option>
									<option value="flip-in-right-front">Flip In Right Front</option>
									<option value="flip-in-right-back">Flip In Right Back</option>
								</optgroup>
							</select>
							<input type="text" name="articles_animation_delay_4" id="articles_animation_delay_4" size="5" value="600" /> <sub>ms</sub>&nbsp;
						</td>
					</tr>
					<tr>
						<td></td>
						<td><small>Type and Delay</small></td>
					</tr>
				</table>

				<br />

			<!-- Pages -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Pages</strong></h3></td>
					</tr>
					<tr>
						<td><label for="use_page_animations">Use Animation?</label></td>
						<td><input type="checkbox" name="use_page_animations" id="use_page_animations" checked="checked" /></td>
					</tr>
					<tr>
						<td><label for="page_animation_type">Animation</label></td>
						<td>
							<select name="page_animation_type" id="page_animation_type">
								<optgroup label="Fade">
									<option value="fade-in" selected="selected">Fade In</option>
									<option value="fade-in-up">Fade In Up</option>
									<option value="fade-in-down">Fade In Down</option>
									<option value="fade-in-left">Fade In Left</option>
									<option value="fade-in-right">Fade In Right</option>
								</optgroup>
								<optgroup label="Bounce">
									<option value="bounce-in">Bounce In</option>
									<option value="bounce-in-up">Bounce In Up</option>
									<option value="bounce-in-down">Bounce In Down</option>
									<option value="bounce-in-left">Bounce In Left</option>
									<option value="bounce-in-right">Bounce In Right</option>
								</optgroup>
								<optgroup label="Zoom">
									<option value="zoom-in">Zoom In</option>
									<option value="zoom-in-up">Zoom In Up</option>
									<option value="zoom-in-down">Zoom In Down</option>
									<option value="zoom-in-left">Zoom In Left</option>
									<option value="zoom-in-right">Zoom In Right</option>
								</optgroup>
								<optgroup label="Flip">
									<option value="flip-in-x">Flip In X</option>
									<option value="flip-in-y">Flip In Y</option>
									<option value="flip-in-top-front">Flip In Top Front</option>
									<option value="flip-in-top-back">Flip In Top Back</option>
									<option value="flip-in-bottom-front">Flip In Bottom Front</option>
									<option value="flip-in-bottom-back">Flip In Bottom Back</option>
									<option value="flip-in-left-front">Flip In Left Front</option>
									<option value="flip-in-left-back">Flip In Left Back</option>
									<option value="flip-in-right-front">Flip In Right Front</option>
									<option value="flip-in-right-back">Flip In Right Back</option>
								</optgroup>
							</select>
							<input type="text" name="page_animation_delay" id="page_animation_delay" size="5" value="0" /> <sub>ms</sub>&nbsp;
						</td>
					</tr>
					<tr>
						<td></td>
						<td><small>Type and Delay</small></td>
					</tr>
				</table>

				<br />

			<!-- Extras (Page Navigation etc) -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Extras (Page Navigation etc)</strong></h3></td>
					</tr>
					<tr>
						<td><label for="use_extras_animations">Use Animations?</label></td>
						<td><input type="checkbox" name="use_extras_animations" id="use_extras_animations" checked="checked" /></td>
					</tr>
					<tr>
						<td><label for="extras_animation_type">Animation</label></td>
						<td>
							<select name="extras_animation_type" id="extras_animation_type">
								<optgroup label="Fade">
									<option value="fade-in" selected="selected">Fade In</option>
									<option value="fade-in-up">Fade In Up</option>
									<option value="fade-in-down">Fade In Down</option>
									<option value="fade-in-left">Fade In Left</option>
									<option value="fade-in-right">Fade In Right</option>
								</optgroup>
								<optgroup label="Bounce">
									<option value="bounce-in">Bounce In</option>
									<option value="bounce-in-up">Bounce In Up</option>
									<option value="bounce-in-down">Bounce In Down</option>
									<option value="bounce-in-left">Bounce In Left</option>
									<option value="bounce-in-right">Bounce In Right</option>
								</optgroup>
								<optgroup label="Zoom">
									<option value="zoom-in">Zoom In</option>
									<option value="zoom-in-up">Zoom In Up</option>
									<option value="zoom-in-down">Zoom In Down</option>
									<option value="zoom-in-left">Zoom In Left</option>
									<option value="zoom-in-right">Zoom In Right</option>
								</optgroup>
								<optgroup label="Flip">
									<option value="flip-in-x">Flip In X</option>
									<option value="flip-in-y">Flip In Y</option>
									<option value="flip-in-top-front">Flip In Top Front</option>
									<option value="flip-in-top-back">Flip In Top Back</option>
									<option value="flip-in-bottom-front">Flip In Bottom Front</option>
									<option value="flip-in-bottom-back">Flip In Bottom Back</option>
									<option value="flip-in-left-front">Flip In Left Front</option>
									<option value="flip-in-left-back">Flip In Left Back</option>
									<option value="flip-in-right-front">Flip In Right Front</option>
									<option value="flip-in-right-back">Flip In Right Back</option>
								</optgroup>
							</select>
							<input type="text" name="extras_animation_delay" id="extras_animation_delay" size="5" value="0" /> <sub>ms</sub>&nbsp;
						</td>
					</tr>
					<tr>
						<td></td>
						<td><small>Type and Delay</small></td>
					</tr>
				</table>

				<br />

			<!-- Footer -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Footer</strong></h3></td>
					</tr>
					<tr>
						<td><label for="use_footer_animation">Use Animations?</label></td>
						<td><input type="checkbox" name="use_footer_animation" id="use_footer_animation" checked="checked" /></td>
					</tr>
					<tr>
						<td><label for="footer_animation_type">Animation</label></td>
						<td>
							<select name="footer_animation_type" id="footer_animation_type">
								<optgroup label="Fade">
									<option value="fade-in" selected="selected">Fade In</option>
									<option value="fade-in-up">Fade In Up</option>
									<option value="fade-in-down">Fade In Down</option>
									<option value="fade-in-left">Fade In Left</option>
									<option value="fade-in-right">Fade In Right</option>
								</optgroup>
								<optgroup label="Bounce">
									<option value="bounce-in">Bounce In</option>
									<option value="bounce-in-up">Bounce In Up</option>
									<option value="bounce-in-down">Bounce In Down</option>
									<option value="bounce-in-left">Bounce In Left</option>
									<option value="bounce-in-right">Bounce In Right</option>
								</optgroup>
								<optgroup label="Zoom">
									<option value="zoom-in">Zoom In</option>
									<option value="zoom-in-up">Zoom In Up</option>
									<option value="zoom-in-down">Zoom In Down</option>
									<option value="zoom-in-left">Zoom In Left</option>
									<option value="zoom-in-right">Zoom In Right</option>
								</optgroup>
								<optgroup label="Flip">
									<option value="flip-in-x">Flip In X</option>
									<option value="flip-in-y">Flip In Y</option>
									<option value="flip-in-top-front">Flip In Top Front</option>
									<option value="flip-in-top-back">Flip In Top Back</option>
									<option value="flip-in-bottom-front">Flip In Bottom Front</option>
									<option value="flip-in-bottom-back">Flip In Bottom Back</option>
									<option value="flip-in-left-front">Flip In Left Front</option>
									<option value="flip-in-left-back">Flip In Left Back</option>
									<option value="flip-in-right-front">Flip In Right Front</option>
									<option value="flip-in-right-back">Flip In Right Back</option>
								</optgroup>
							</select>
							<input type="text" name="footer_animation_delay" id="footer_animation_delay" size="5" value="0" /> <sub>ms</sub>&nbsp;
						</td>
					</tr>
					<tr>
						<td></td>
						<td><small>Type and Delay</small></td>
					</tr>
				</table>

				<br />

	</fieldset>


<!-- #Miscellaneous
================================================== -->

	<fieldset>

		<legend>Miscellaneous</legend>

			<!-- Smooth Scroll -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Smooth Scroll</strong></h3></td>
					</tr>
					<tr>
						<td><label for="use_smoothscroll">Use smooth scroll?</label></td>
						<td><input type="checkbox" name="use_smoothscroll" id="use_smoothscroll" checked="checked" /></td>
					</tr>
				</table>

				<br />

			<!-- Facebook OpenGraph -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Facebook OpenGraph</strong></h3></td>
					</tr>
					<tr>
						<td><label for="use_facebook_opengraph_image">Use image?</label></td>
						<td><input type="checkbox" name="use_facebook_opengraph_image" id="use_facebook_opengraph_image" /></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="file" name="facebook-opengraph-image.png" id="facebook_opengraph_image" data-max-width="750" data-max-height="750" /></td>
					</tr>
					<tr>
						<td></td>
						<td>
							<small>
								Max width: 750px<br />
								Max height: 750px<br />
								Format: .png
							</small>
						</td>
					</tr>
				</table>

				<br />

			<!-- Twitter -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Twitter Card</strong></h3></td>
					</tr>
					<tr>
						<td><label for="twitter_card_site_handle">Website Handle</label></td>
						<td><sub>@</sub> <input type="text" name="twitter_card_site_handle" id="twitter_card_site_handle" /></td>
					</tr>
				</table>

				<br />

			<!-- Icons -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Icons</strong></h3></td>
					</tr>
					<tr>
						<td><label for="fav_icon_file">Fav Icon - 16px</label></td>
						<td><input type="file" name="fav-icon.png" id="fav_icon_file" data-max-width="16" data-max-height="16" /></td>
					</tr>
					<tr>
						<td><label for="apple_icon_152_file">Apple Touch Icon - 152px</label></td>
						<td><input type="file" name="apple-icon-152.png" id="apple_icon_152_file" data-max-width="152" data-max-height="152" /></td>
					</tr>
					<tr>
						<td><label for="apple_icon_120_file">Apple Touch Icon - 120px</label></td>
						<td><input type="file" name="apple-icon-120.png" id="apple_icon_120_file" data-max-width="120" data-max-height="120" /></td>
					</tr>
					<tr>
						<td><label for="apple_icon_76_file">Apple Touch Icon - 76px</label></td>
						<td><input type="file" name="apple-icon-76.png" id="apple_icon_76_file" data-max-width="76" data-max-height="76" /></td>
					</tr>
					<tr>
						<td><label for="apple_icon_60_file">Apple Touch Icon - 60px</label></td>
						<td><input type="file" name="apple-icon-60.png" id="apple_icon_60_file" data-max-width="60" data-max-height="60" /></td>
					</tr>
					<tr>
						<td></td>
						<td>
							<small>
								Fav Icons and Apple Touch Icons vary depending on the device<br />
								The specified pixel value shown is for both the width and height of the icon<br />
								Your uploaded files will be resized to their respected dimensions<br />
								Format: .png
							</small>
						</td>
					</tr>
				</table>

				<br />

			<!-- Breadcrumb -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Breadcrumb</strong></h3></td>
					</tr>
					<tr>
						<td><label for="breadcrumb_alignment">Align Text</label></td>
						<td>
							<select name="breadcrumb_alignment" id="breadcrumb_alignment">
								<option value="text-left">Left</option>
								<option value="text-center" selected="selected">Center</option>
								<option value="text-right">Right</option>
							</select>
						</td>
					</tr>
					<tr>
						<td><label for="breadcrumb_separator">Separator</label></td>
						<td><input type="text" name="breadcrumb_separator" id="breadcrumb_separator" value="/" /></td>
					</tr>
					<tr>
						<td></td>
						<td><small>You can use HTML special character codes</small></td>
					</tr>
				</table>

				<br />

			<!-- Page Navigation -->
				<table class="standard-table">
					<tr>
						<td colspan="2"><h3><strong>Page Navigation</strong></h3></td>
					</tr>
					<tr>
						<td><label for="pagination_display">Display</label></td>
						<td>
							<select name="pagination_display" id="pagination_display">
								<option value="top">Top</option>
								<option value="top-bottom" selected="selected">Top and Bottom</option>
								<option value="bottom">Bottom</option>
							</select>
						</td>
					</tr>
					<tr>
						<td><label for="show_pagination_details">Show pagination details?</label></td>
						<td><input type="checkbox" name="show_pagination_details" id="show_pagination_details" checked="checked" /></td>
					</tr>
					<tr>
						<td></td>
						<td><small>Pagination Details only apply to bottom pagination links</small></td>
					</tr>
				</table>

				<br />

	</fieldset>