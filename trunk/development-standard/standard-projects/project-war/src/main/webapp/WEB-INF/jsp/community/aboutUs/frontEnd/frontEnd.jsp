<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
    <!DOCTYPE html>
    <html lang="ko" class="no-js">
    <!--<![endif]-->

    <head>
        <link href="${pageContext.request.contextPath}/assets/js/usquare_jquery/css/usquare_style.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/assets/js/usquare_jquery/css/jquery.mCustomScrollbar.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/assets/js/usquare_jquery/css/jcarousel.css" rel="stylesheet" type="text/css" />

        <link href="${pageContext.request.contextPath}/assets/js/usquare_jquery/style.css" rel="stylesheet" type="text/css" />

        <script src="${pageContext.request.contextPath}/assets/js/jquery-ui-1.11.2/jquery-ui.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/usquare_jquery/scripts/jquery.mousewheel.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/usquare_jquery/scripts/jquery.mCustomScrollbar.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/usquare_jquery/scripts/jcarousel.min.js"></script>

        <script src="${pageContext.request.contextPath}/assets/js/usquare_jquery/scripts/jquery.usquare.js" type="text/javascript" charset="UTF-8"></script>
        <script>
            (function($) {
                $(document).ready(function() {
                    $(".usquare_module_wrapper").uSquare({
                        opening_speed: 300,
                        closing_speed: 500,
                        easing: 'swing'
                    });

                    $('.jcarousel-skin-tango').jcarousel();
                });


            })(jQuery);
        </script>
    </head>

    <body>
				<div class="one-whole">
					<div class="text-center">
						<h1 style="height: 31; color: #f45b4f; font-family: Alegreya Sans,sans-serif; font-size: 2em;">
							FrontEnd
						</h1>
						<p class="bm-remove">
							<a href="${pageContext.request.contextPath}/" target="_self">Home</a>
							&nbsp;/&nbsp;
							About Us
							&nbsp;/&nbsp;
							FrontEnd
						</p>
						<br/><br/>
					</div>
					</div>
        <div class="page_wrapper">
            <div class="selectors">
 <!--사용하지않을거같아서 일단 주석처리 해놨습니다.!!!
<h3 style="color:#313131;">Previews:</h3>

<a href="${pageContext.request.contextPath}/frontEnd/frontEnd.jsp">Our team</a> <a href="${pageContext.request.contextPath}/frontEnd/logos.jsp">Logos</a>  -->
                <!--
<a href="${pageContext.request.contextPath}/frontEnd/products.jsp">Products</a> -->
            </div>

            <div class="usquare_module_wrapper">

                <div class="usquare_module_shade"></div>
                <!-- section 1 -->
                <div class="usquare_block">
                    <img src="${pageContext.request.contextPath}/images/frontEnd/profile/LDM.jpeg" class="usquare_square" alt="" />
                    <div class="usquare_square usquare_square_bg1">
                        <div class="usquare_square_text_wrapper">
                            <img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/arrow.png" class="usquare_arrow" alt="arrow" />
                            <div class="clear"></div>
                            <h2>이동민</h2>
                            <span>graphic designer / illustrator</span>
                            <div class="clear"></div>
                        </div>
                        <!-- usquare_square_wrapper -->
                    </div>
                    <!--div    usquare_square -->
                    <div class="usquare_block_extended usquare_square_bg1">
                        <a href="#" class="close"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/close.png" alt="close" /></a>
                        <ul class="social_background">
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-fb.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-tw.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-in.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-pint.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-yah.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-dig.png" alt="social" /></a>
                            </li>
                        </ul>

                        <div class="clear"></div>

                        <span class="bold">info:</span>
                        <div class="usquare_about">
                            Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.

                            <ul class="jcarousel-skin-tango">
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider1.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider2.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider3.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider4.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider5.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider6.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider7.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider8.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider9.png" width="63" height="48" alt="" /></li>
                            </ul>
                        </div>
                    </div>
                    <!-- usquare_block_extended -->
                </div>
                <!-- usquare_block -->
                <!-- section 2 -->
                <div class="usquare_block">
                    <img src="${pageContext.request.contextPath}/images/frontEnd/profile/LCY.jpg" class="usquare_square" alt="" />
                    <div class="usquare_square usquare_square_bg2">
                        <div class="usquare_square_text_wrapper">
                            <img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/arrow.png" class="usquare_arrow" alt="arrow" />
                            <div class="clear"></div>
                            <h2>이창용</h2>
                            <span>web designer / illustrator</span>
                            <div class="clear"></div>
                        </div>
                        <!-- usquare_square_wrapper -->
                    </div>
                    <!--div    usquare_square -->
                    <div style="display:none;" class="usquare_block_extended usquare_square_bg2">
                        <a href="" class="close"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/close.png" alt="close" /></a>

                        <ul class="social_background">
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-fb.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-tw.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-in.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-pint.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-yah.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-dig.png" alt="social" /></a>
                            </li>
                        </ul>

                        <div class="clear"></div>
                        <span class="bold">info:</span>
                        <div class="usquare_about">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.

                            <ul class="jcarousel-skin-tango">
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider1.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider2.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider3.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider4.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider5.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider6.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider7.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider8.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider9.png" width="63" height="48" alt="" /></li>
                            </ul>
                        </div>
                    </div>
                    <!-- usquare_block_extended -->

                </div>
                <!-- usquare_block -->
                <!-- section 3 -->
                <div class="usquare_block">
                    <img src="${pageContext.request.contextPath}/images/frontEnd/profile/ESM.jpg" class="usquare_square" alt="" />
                    <div class="usquare_square usquare_square_bg3">
                        <div class="usquare_square_text_wrapper">
                            <img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/arrow.png" class="usquare_arrow" alt="arrow" />
                            <div class="clear"></div>
                            <h2>엄선미</h2>
                            <span>학생</span>
                            <div class="clear"></div>
                        </div>
                        <!-- usquare_square_wrapper -->
                    </div>
                    <!--div    usquare_square -->
                    <div style="display:none;" class="usquare_block_extended usquare_square_bg3">
                        <a href="" class="close"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/close.png" alt="close" /></a>

                        <ul class="social_background">
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-fb.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-tw.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-in.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-pint.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-yah.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-dig.png" alt="social" /></a>
                            </li>
                        </ul>

                        <div class="clear"></div>
                        <span class="bold">info:</span>
                        <div class="usquare_about"> 현재 4학년 재학중입니다. 경기도 군포시 거주

                            <ul class="jcarousel-skin-tango">
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider1.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider2.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider3.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider4.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider5.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider6.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider7.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider8.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider9.png" width="63" height="48" alt="" /></li>
                            </ul>
                        </div>
                    </div>
                    <!-- usquare_block_extended -->
                </div>
                <!-- usquare_block -->
                <!-- section 4 -->
                <div class="usquare_block">
                    <div class="usquare_square usquare_square_bg4">
                        <div class="usquare_square_text_wrapper">
                            <img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/arrow_r.png" class="usquare_arrow usquare_arrow_r" alt="arrow" />
                            <div class="clear"></div>
                            <h2 class="usquare_r">윤봉태</h2>
                            <span class="usquare_r">graphic designer / illustrator</span>
                            <div class="clear"></div>
                        </div>
                        <!-- usquare_square_wrapper -->
                    </div>
                    <!--div    usquare_square -->
                    <img src="${pageContext.request.contextPath}/images/frontEnd/profile/YBT.jpg" class="usquare_square" alt="" />
                    <div style="display:none;" class="usquare_block_extended usquare_square_bg4">
                        <a href="" class="close close_left_side"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/close.png" alt="close" /></a>

                        <ul class="social_background">
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-fb.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-tw.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-in.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-pint.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-yah.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-dig.png" alt="social" /></a>
                            </li>
                        </ul>

                        <div class="clear"></div>
                        <span class="bold">info:</span>
                        <div class="usquare_about">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.

                            <ul class="jcarousel-skin-tango">
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider1.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider2.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider3.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider4.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider5.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider6.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider7.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider8.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider9.png" width="63" height="48" alt="" /></li>
                            </ul>
                        </div>
                    </div>
                    <!-- usquare_block_extended -->
                </div>
                <!-- usquare_block -->
                <!-- section 5 -->
                <div class="usquare_block">
                    <div class="usquare_square usquare_square_bg5">
                        <div class="usquare_square_text_wrapper">
                            <img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/arrow_r.png" class="usquare_arrow usquare_arrow_r" alt="arrow" />
                            <div class="clear"></div>
                            <h2 class="usquare_r">이혜진</h2>
                            <span class="usquare_r">graphic designer / illustrator</span>
                            <div class="clear"></div>
                        </div>
                        <!-- usquare_square_wrapper -->
                    </div>
                    <!--div    usquare_square -->
                    <img src="${pageContext.request.contextPath}/images/frontEnd/profile/LHJ.jpg" class="usquare_square" alt="" />
                    <div style="display:none;" class="usquare_block_extended usquare_square_bg5">
                        <a href="" class="close close_left_side"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/close.png" alt="close" /></a>

                        <ul class="social_background">
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-fb.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-tw.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-in.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-pint.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-yah.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-dig.png" alt="social" /></a>
                            </li>
                        </ul>

                        <div class="clear"></div>
                        <span class="bold">info:</span>
                        <div class="usquare_about">web desinger

                            <ul class="jcarousel-skin-tango">
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider1.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider2.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider3.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider4.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider5.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider6.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider7.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider8.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider9.png" width="63" height="48" alt="" /></li>
                            </ul>
                        </div>
                    </div>
                    <!-- usquare_block_extended -->
                </div>
                <!-- usquare_block -->
                <!-- section 6 -->
                <div class="usquare_block">
                    <div class="usquare_square usquare_square_bg6">
                        <div class="usquare_square_text_wrapper">
                            <img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/arrow_r.png" class="usquare_arrow usquare_arrow_r" alt="arrow" />
                            <div class="clear"></div>
                            <h2 class="usquare_r">최승현</h2>
                            <span class="usquare_r">graphic designer / illustrator</span>
                            <div class="clear"></div>
                        </div>
                        <!-- usquare_square_wrapper -->
                    </div>
                    <!--div    usquare_square -->
                    <img src="${pageContext.request.contextPath}/images/frontEnd/profile/CSH.jpg" class="usquare_square" alt="" />
                    <div style="display:none;" class="usquare_block_extended usquare_square_bg6">
                        <a href="" class="close close_left_side"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/close.png" alt="close" /></a>

                        <ul class="social_background">
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-fb.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-tw.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-in.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-pint.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-yah.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-dig.png" alt="social" /></a>
                            </li>
                        </ul>

                        <div class="clear"></div>
                        <span class="bold">info:</span>
                        <div class="usquare_about">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.

                            <ul class="jcarousel-skin-tango">
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider1.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider2.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider3.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider4.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider5.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider6.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider7.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider8.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider9.png" width="63" height="48" alt="" /></li>
                            </ul>
                        </div>
                    </div>
                    <!-- usquare_block_extended -->
                </div>
                <!-- usquare_block -->
                <!-- section 7 -->
                <div class="usquare_block">
                    <img src="${pageContext.request.contextPath}/images/frontEnd/profile/PJK.jpg" class="usquare_square" alt="" />
                    <div class="usquare_square usquare_square_bg7">
                        <div class="usquare_square_text_wrapper">
                            <img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/arrow.png" class="usquare_arrow usquare_arrow" alt="arrow" />
                            <div class="clear"></div>
                            <h2>박진경</h2>
                            <span>graphic designer / illustrator</span>
                            <div class="clear"></div>
                        </div>
                        <!-- usquare_square_wrapper -->
                    </div>
                    <!--div    usquare_square -->
                    <div style="display:none;" class="usquare_block_extended usquare_square_bg7">
                        <a href="" class="close"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/close.png" alt="close" /></a>

                        <ul class="social_background">
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-fb.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-tw.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-in.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-pint.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-yah.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-dig.png" alt="social" /></a>
                            </li>
                        </ul>

                        <div class="clear"></div>
                        <span class="bold">info:</span>
                        <div class="usquare_about">안녕하세요

                            <ul class="jcarousel-skin-tango">
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider1.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider2.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider3.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider4.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider5.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider6.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider7.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider8.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider9.png" width="63" height="48" alt="" /></li>
                            </ul>
                        </div>
                    </div>
                    <!-- usquare_block_extended -->
                </div>
                <!-- usquare_block -->
                <!-- section 8 -->
                <div class="usquare_block">
                    <img src="${pageContext.request.contextPath}/images/frontEnd/profile/CKS.jpg" class="usquare_square" alt="" /> 
                    <div class="usquare_square usquare_square_bg8">
                        <div class="usquare_square_text_wrapper">
                            <img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/arrow.png" class="usquare_arrow" alt="arrow" />
                            <div class="clear"></div>
                            <h2>최경석</h2>
                            <span>web designer / illustrator</span>
                            <div class="clear"></div>
                        </div>
                        <!-- usquare_square_wrapper -->
                    </div>
                    <!--div    usquare_square -->
                    <div style="display:none;" class="usquare_block_extended usquare_square_bg8">
                        <a href="" class="close"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/close.png" alt="close" /></a>

                        <ul class="social_background">
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-fb.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-tw.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-in.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-pint.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-yah.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-dig.png" alt="social" /></a>
                            </li>
                        </ul>

                        <div class="clear"></div>
                        <span class="bold">info:</span>
                        <div class="usquare_about">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.

                            <ul class="jcarousel-skin-tango">
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider1.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider2.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider3.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider4.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider5.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider6.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider7.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider8.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider9.png" width="63" height="48" alt="" /></li>
                            </ul>
                        </div>
                    </div>
                    <!-- usquare_block_extended -->
                </div>
                <!-- usquare_block -->

                <!-- section 9 -->
                <div class="usquare_block">
                    <img src="${pageContext.request.contextPath}/images/frontEnd/profile/ZJH.jpg" class="usquare_square" alt="" />
                    <div class="usquare_square usquare_square_bg9">
                        <div class="usquare_square_text_wrapper">
                            <img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/arrow.png" class="usquare_arrow" alt="arrow" />
                            <div class="clear"></div>
                            <h2>전진홍</h2>
                            <span>SEO & SEM specialist</span>
                            <div class="clear"></div>
                        </div>
                        <!-- usquare_square_wrapper -->
                    </div>
                    <!--div    usquare_square -->
                    <div style="display:none;" class="usquare_block_extended usquare_square_bg9">
                        <a href="" class="close"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/close.png" alt="close" /></a>

                        <ul class="social_background">
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-fb.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-tw.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-in.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-pint.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-yah.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-dig.png" alt="social" /></a>
                            </li>
                        </ul>

                        <div class="clear"></div>
                        <span class="bold">info:</span>
                        <div class="usquare_about">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.

                            <ul class="jcarousel-skin-tango">
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider1.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider2.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider3.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider4.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider5.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider6.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider7.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider8.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider9.png" width="63" height="48" alt="" /></li>
                            </ul>
                        </div>
                    </div>
                    <!-- usquare_block_extended -->
                </div>
                <!-- usquare_block -->

                <!-- section 10-->
                <div class="usquare_block">
                    <div class="usquare_square usquare_square_bg4">
                        <div class="usquare_square_text_wrapper">
                            <img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/arrow_r.png" class="usquare_arrow usquare_arrow_r" alt="arrow" />
                            <div class="clear"></div>
                            <h2 class="usquare_r">김희준</h2>
                            <span class="usquare_r">graphic designer / illustrator</span>
                            <div class="clear"></div>
                        </div>
                        <!-- usquare_square_wrapper -->
                    </div>
                    <!--div    usquare_square -->
                    <img src="${pageContext.request.contextPath}/images/frontEnd/profile/KHJ.jpeg" class="usquare_square" alt="" />
                    <div style="display:none;" class="usquare_block_extended usquare_square_bg4">
                        <a href="" class="close close_left_side"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/close.png" alt="close" /></a>

                        <ul class="social_background">
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-fb.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-tw.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-in.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-pint.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-yah.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-dig.png" alt="social" /></a>
                            </li>
                        </ul>

                        <div class="clear"></div>
                        <span class="bold">info:</span>
                        <div class="usquare_about">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.

                            <ul class="jcarousel-skin-tango">
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider1.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider2.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider3.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider4.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider5.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider6.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider7.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider8.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider9.png" width="63" height="48" alt="" /></li>
                            </ul>
                        </div>
                    </div>
                    <!-- usquare_block_extended -->
                </div>
                <!-- usquare_block -->
                <!-- section 11 -->
                <div class="usquare_block">
                    <div class="usquare_square usquare_square_bg5">
                        <div class="usquare_square_text_wrapper">
                            <img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/arrow_r.png" class="usquare_arrow usquare_arrow_r" alt="arrow" />
                            <div class="clear"></div>
                            <h2 class="usquare_r">정재호</h2>
                            <span class="usquare_r">graphic designer / illustrator</span>
                            <div class="clear"></div>
                        </div>
                        <!-- usquare_square_wrapper -->
                    </div>
                    <!--div    usquare_square -->
                    <img src="${pageContext.request.contextPath}/images/frontEnd/profile/JJH.jpg" class="usquare_square" alt="" />
                    <div style="display:none;" class="usquare_block_extended usquare_square_bg5">
                        <a href="" class="close close_left_side"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/close.png" alt="close" /></a>

                        <ul class="social_background">
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-fb.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-tw.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-in.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-pint.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-yah.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-dig.png" alt="social" /></a>
                            </li>
                        </ul>

                        <div class="clear"></div>
                        <span class="bold">info:</span>
                        <div class="usquare_about">web desinger

                            <ul class="jcarousel-skin-tango">
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider1.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider2.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider3.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider4.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider5.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider6.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider7.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider8.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider9.png" width="63" height="48" alt="" /></li>
                            </ul>
                        </div>
                    </div>
                    <!-- usquare_block_extended -->
                </div>
                <!-- usquare_block -->
                <!-- section 12 -->
                <div class="usquare_block">
                    <div class="usquare_square usquare_square_bg6">
                        <div class="usquare_square_text_wrapper">
                            <img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/arrow_r.png" class="usquare_arrow usquare_arrow_r" alt="arrow" />
                            <div class="clear"></div>
                            <h2 class="usquare_r">전옥현</h2>
                            <span class="usquare_r">graphic designer / illustrator</span>
                            <div class="clear"></div>
                        </div>
                        <!-- usquare_square_wrapper -->
                    </div>
                    <!--div    usquare_square -->
                    <img src="${pageContext.request.contextPath}/images/frontEnd/profile/JOH.jpg" class="usquare_square" alt="" />
                    <div style="display:none;" class="usquare_block_extended usquare_square_bg6">
                        <a href="" class="close close_left_side"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/close.png" alt="close" /></a>

                        <ul class="social_background">
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-fb.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-tw.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-in.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-pint.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-yah.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-dig.png" alt="social" /></a>
                            </li>
                        </ul>

                        <div class="clear"></div>
                        <span class="bold">info:</span>
                        <div class="usquare_about">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.

                            <ul class="jcarousel-skin-tango">
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider1.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider2.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider3.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider4.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider5.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider6.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider7.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider8.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider9.png" width="63" height="48" alt="" /></li>
                            </ul>
                        </div>
                    </div>
                    <!-- usquare_block_extended -->
                </div>
                <!-- usquare_block -->
                <!-- section 13 -->
                <div class="usquare_block">
                    <img src="${pageContext.request.contextPath}/images/frontEnd/profile/JHJ.jpg" class="usquare_square" alt="" />
                    <div class="usquare_square usquare_square_bg1">
                        <div class="usquare_square_text_wrapper">
                            <img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/arrow.png" class="usquare_arrow" alt="arrow" />
                            <div class="clear"></div>
                            <h2>정해정</h2>
                            <span>graphic designer / illustrator</span>
                            <div class="clear"></div>
                        </div>
                        <!-- usquare_square_wrapper -->
                    </div>
                    <!--div    usquare_square -->
                    <div class="usquare_block_extended usquare_square_bg1">
                        <a href="#" class="close"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/close.png" alt="close" /></a>
                        <ul class="social_background">
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-fb.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-tw.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-in.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-pint.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-yah.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-dig.png" alt="social" /></a>
                            </li>
                        </ul>

                        <div class="clear"></div>

                        <span class="bold">info:</span>
                        <div class="usquare_about">
                            Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.

                            <ul class="jcarousel-skin-tango">
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider1.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider2.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider3.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider4.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider5.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider6.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider7.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider8.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider9.png" width="63" height="48" alt="" /></li>
                            </ul>
                        </div>
                    </div>
                    <!-- usquare_block_extended -->
                </div>
                <!-- usquare_block -->
                <!-- section 14 -->
                <div class="usquare_block">
                    <img src="${pageContext.request.contextPath}/images/frontEnd/profile/CYJ.jpg" class="usquare_square" alt="" />
                    <div class="usquare_square usquare_square_bg2">
                        <div class="usquare_square_text_wrapper">
                            <img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/arrow.png" class="usquare_arrow" alt="arrow" />
                            <div class="clear"></div>
                            <h2>최유진</h2>
                            <span>web designer / illustrator</span>
                            <div class="clear"></div>
                        </div>
                        <!-- usquare_square_wrapper -->
                    </div>
                    <!--div    usquare_square -->
                    <div style="display:none;" class="usquare_block_extended usquare_square_bg2">
                        <a href="" class="close"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/close.png" alt="close" /></a>

                        <ul class="social_background">
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-fb.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-tw.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-in.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-pint.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-yah.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-dig.png" alt="social" /></a>
                            </li>
                        </ul>

                        <div class="clear"></div>
                        <span class="bold">info:</span>
                        <div class="usquare_about">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.

                            <ul class="jcarousel-skin-tango">
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider1.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider2.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider3.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider4.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider5.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider6.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider7.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider8.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider9.png" width="63" height="48" alt="" /></li>
                            </ul>
                        </div>
                    </div>
                    <!-- usquare_block_extended -->

                </div>
                <!-- usquare_block -->
                <!-- section 15 -->
                <div class="usquare_block">
                    <img src="${pageContext.request.contextPath}/images/frontEnd/profile/LMY.jpg" class="usquare_square" alt="" />
                    <div class="usquare_square usquare_square_bg3">
                        <div class="usquare_square_text_wrapper">
                            <img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/arrow.png" class="usquare_arrow" alt="arrow" />
                            <div class="clear"></div>
                            <h2>이미영</h2>
                            <span></span>
                            <div class="clear"></div>
                        </div>
                        <!-- usquare_square_wrapper -->
                    </div>
                    <!--div    usquare_square -->
                    <div style="display:none;" class="usquare_block_extended usquare_square_bg3">
                        <a href="" class="close"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/close.png" alt="close" /></a>

                        <ul class="social_background">
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-fb.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-tw.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-in.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-pint.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-yah.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-dig.png" alt="social" /></a>
                            </li>
                        </ul>

                        <div class="clear"></div>
                        <span class="bold">info:</span>
                        <div class="usquare_about">

                            <ul class="jcarousel-skin-tango">
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider1.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider2.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider3.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider4.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider5.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider6.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider7.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider8.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider9.png" width="63" height="48" alt="" /></li>
                            </ul>
                        </div>
                    </div>
                    <!-- usquare_block_extended -->
                </div>
                <!-- usquare_block -->
                <!-- section 16 -->
                <div class="usquare_block">
                    <div class="usquare_square usquare_square_bg4">
                        <div class="usquare_square_text_wrapper">
                            <img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/arrow_r.png" class="usquare_arrow usquare_arrow_r" alt="arrow" />
                            <div class="clear"></div>
                            <h2 class="usquare_r">정종석</h2>
                            <span class="usquare_r">graphic designer / illustrator</span>
                            <div class="clear"></div>
                        </div>
                        <!-- usquare_square_wrapper -->
                    </div>
                    <!--div    usquare_square -->
                    <img src="${pageContext.request.contextPath}/images/frontEnd/profile/JJS.jpg" class="usquare_square" alt="" />
                    <div style="display:none;" class="usquare_block_extended usquare_square_bg4">
                        <a href="" class="close close_left_side"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/close.png" alt="close" /></a>

                        <ul class="social_background">
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-fb.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-tw.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-in.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-pint.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-yah.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-dig.png" alt="social" /></a>
                            </li>
                        </ul>

                        <div class="clear"></div>
                        <span class="bold">info:</span>
                        <div class="usquare_about">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.

                            <ul class="jcarousel-skin-tango">
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider1.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider2.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider3.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider4.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider5.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider6.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider7.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider8.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider9.png" width="63" height="48" alt="" /></li>
                            </ul>
                        </div>
                    </div>
                    <!-- usquare_block_extended -->
                </div>
                <!-- usquare_block -->
                <!-- section 17 -->
                <div class="usquare_block">
                    <div class="usquare_square usquare_square_bg5">
                        <div class="usquare_square_text_wrapper">
                            <img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/arrow_r.png" class="usquare_arrow usquare_arrow_r" alt="arrow" />
                            <div class="clear"></div>
                            <h2 class="usquare_r">이승희</h2>
                            <span class="usquare_r">graphic designer / illustrator</span>
                            <div class="clear"></div>
                        </div>
                        <!-- usquare_square_wrapper -->
                    </div>
                    <!--div    usquare_square -->
                    <img src="${pageContext.request.contextPath}/images/frontEnd/profile/LSH.jpg" class="usquare_square" alt="" />
                    <div style="display:none;" class="usquare_block_extended usquare_square_bg5">
                        <a href="" class="close close_left_side"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/close.png" alt="close" /></a>

                        <ul class="social_background">
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-fb.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-tw.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-in.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-pint.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-yah.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-dig.png" alt="social" /></a>
                            </li>
                        </ul>

                        <div class="clear"></div>
                        <span class="bold">info:</span>
                        <div class="usquare_about">web desinger

                            <ul class="jcarousel-skin-tango">
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider1.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider2.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider3.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider4.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider5.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider6.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider7.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider8.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider9.png" width="63" height="48" alt="" /></li>
                            </ul>
                        </div>
                    </div>
                    <!-- usquare_block_extended -->
                </div>
                <!-- usquare_block -->
                <!-- section 18 -->
                <div class="usquare_block">
                    <div class="usquare_square usquare_square_bg6">
                        <div class="usquare_square_text_wrapper">
                            <img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/arrow_r.png" class="usquare_arrow usquare_arrow_r" alt="arrow" />
                            <div class="clear"></div>
                            <h2 class="usquare_r">정시연</h2>
                            <span class="usquare_r">graphic designer / illustrator</span>
                            <div class="clear"></div>
                        </div>
                        <!-- usquare_square_wrapper -->
                    </div>
                    <!--div    usquare_square -->
                    <img src="${pageContext.request.contextPath}/images/frontEnd/profile/JSY.jpg" class="usquare_square" alt="" />
                    <div style="display:none;" class="usquare_block_extended usquare_square_bg6">
                        <a href="" class="close close_left_side"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/close.png" alt="close" /></a>

                        <ul class="social_background">
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-fb.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-tw.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-in.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-pint.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-yah.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-dig.png" alt="social" /></a>
                            </li>
                        </ul>

                        <div class="clear"></div>
                        <span class="bold">info:</span>
                        <div class="usquare_about">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.

                            <ul class="jcarousel-skin-tango">
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider1.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider2.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider3.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider4.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider5.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider6.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider7.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider8.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider9.png" width="63" height="48" alt="" /></li>
                            </ul>
                        </div>
                    </div>
                    <!-- usquare_block_extended -->
                </div>
                <!-- usquare_block -->
                <!-- section 19 -->
                <div class="usquare_block">
                    <img src="${pageContext.request.contextPath}/images/frontEnd/profile/HC.jpg" class="usquare_square" alt="" />
                    <div class="usquare_square usquare_square_bg7">
                        <div class="usquare_square_text_wrapper">
                            <img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/arrow.png" class="usquare_arrow usquare_arrow" alt="arrow" />
                            <div class="clear"></div>
                            <h2>김범룡</h2>
                            <span>graphic designer / illustrator</span>
                            <div class="clear"></div>
                        </div>
                        <!-- usquare_square_wrapper -->
                    </div>
                    <!--div    usquare_square -->
                    <div style="display:none;" class="usquare_block_extended usquare_square_bg7">
                        <a href="" class="close"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/close.png" alt="close" /></a>

                        <ul class="social_background">
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-fb.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-tw.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-in.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-pint.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-yah.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-dig.png" alt="social" /></a>
                            </li>
                        </ul>

                        <div class="clear"></div>
                        <span class="bold">info:</span>
                        <div class="usquare_about">

                            <ul class="jcarousel-skin-tango">
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider1.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider2.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider3.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider4.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider5.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider6.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider7.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider8.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider9.png" width="63" height="48" alt="" /></li>
                            </ul>
                        </div>
                    </div>
                    <!-- usquare_block_extended -->
                </div>
                <!-- usquare_block -->
                <!-- section 20-->
                <div class="usquare_block">
                    <img src="${pageContext.request.contextPath}/images/frontEnd/profile/HC.jpg" class="usquare_square" alt="" />
                    <div class="usquare_square usquare_square_bg8">
                        <div class="usquare_square_text_wrapper">
                            <img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/arrow.png" class="usquare_arrow" alt="arrow" />
                            <div class="clear"></div>
                            <h2>이은철</h2>
                            <span>web designer / illustrator</span>
                            <div class="clear"></div>
                        </div>
                        <!-- usquare_square_wrapper -->
                    </div>
                    <!--div    usquare_square -->
                    <div style="display:none;" class="usquare_block_extended usquare_square_bg8">
                        <a href="" class="close"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/close.png" alt="close" /></a>

                        <ul class="social_background">
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-fb.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-tw.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-in.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-pint.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-yah.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-dig.png" alt="social" /></a>
                            </li>
                        </ul>

                        <div class="clear"></div>
                        <span class="bold">info:</span>
                        <div class="usquare_about">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.

                            <ul class="jcarousel-skin-tango">
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider1.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider2.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider3.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider4.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider5.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider6.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider7.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider8.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider9.png" width="63" height="48" alt="" /></li>
                            </ul>
                        </div>
                    </div>
                    <!-- usquare_block_extended -->
                </div>
                <!-- usquare_block -->

                <!-- section 21 -->
                <div class="usquare_block">
                    <img src="${pageContext.request.contextPath}/images/frontEnd/profile/HC.jpg" class="usquare_square" alt="" />
                    <div class="usquare_square usquare_square_bg9">
                        <div class="usquare_square_text_wrapper">
                            <img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/arrow.png" class="usquare_arrow" alt="arrow" />
                            <div class="clear"></div>
                            <h2>양희성</h2>
                            <span>SEO & SEM specialist</span>
                            <div class="clear"></div>
                        </div>
                        <!-- usquare_square_wrapper -->
                    </div>
                    <!--div    usquare_square -->
                    <div style="display:none;" class="usquare_block_extended usquare_square_bg9">
                        <a href="" class="close"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/close.png" alt="close" /></a>

                        <ul class="social_background">
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-fb.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-tw.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-in.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-pint.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-yah.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-dig.png" alt="social" /></a>
                            </li>
                        </ul>

                        <div class="clear"></div>
                        <span class="bold">info:</span>
                        <div class="usquare_about">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.

                            <ul class="jcarousel-skin-tango">
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider1.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider2.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider3.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider4.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider5.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider6.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider7.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider8.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider9.png" width="63" height="48" alt="" /></li>
                            </ul>
                        </div>
                    </div>
                    <!-- usquare_block_extended -->
                </div>
                <!-- usquare_block -->
                <!-- section 22 -->
                <div class="usquare_block">
                    <div class="usquare_square usquare_square_bg4">
                        <div class="usquare_square_text_wrapper">
                            <img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/arrow_r.png" class="usquare_arrow usquare_arrow_r" alt="arrow" />
                            <div class="clear"></div>
                            <h2 class="usquare_r">유정우</h2>
                            <span class="usquare_r">graphic designer / illustrator</span>
                            <div class="clear"></div>
                        </div>
                        <!-- usquare_square_wrapper -->
                    </div>
                    <!--div    usquare_square -->
                    <img src="${pageContext.request.contextPath}/images/frontEnd/profile/YJW.jpg" class="usquare_square" alt="" />
                    <div style="display:none;" class="usquare_block_extended usquare_square_bg4">
                        <a href="" class="close close_left_side"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/close.png" alt="close" /></a>

                        <ul class="social_background">
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-fb.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-tw.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-in.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-pint.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-yah.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-dig.png" alt="social" /></a>
                            </li>
                        </ul>

                        <div class="clear"></div>
                        <span class="bold">info:</span>
                        <div class="usquare_about">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.

                            <ul class="jcarousel-skin-tango">
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider1.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider2.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider3.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider4.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider5.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider6.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider7.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider8.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider9.png" width="63" height="48" alt="" /></li>
                            </ul>
                        </div>
                    </div>
                    <!-- usquare_block_extended -->
                </div>



                <div class="clear"></div>
            </div>
            <!-- usquare_module_wrapper -->

            <div class="selectors"></div>




        </div>
        <!-- page_wrapper -->
    </body>

    </html>