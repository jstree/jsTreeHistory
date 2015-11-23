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
						<h1 style="height: 31; color: #f45b4f; font-family: Dotum; font-size: 2em;">
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
                    <img src="${pageContext.request.contextPath}/assets/images/community/frontendProfile/LDM.jpeg" class="usquare_square" alt="" />
                    <div class="usquare_square usquare_square_bg1">
                        <div class="usquare_square_text_wrapper">
                            <img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/arrow.png" class="usquare_arrow" alt="arrow" />
                            <div class="clear"></div>
                            <h2>이동민</h2>
                            <span>Java Developer / Architecture</span>
                            <div class="clear"></div>
                        </div>
                        <!-- usquare_square_wrapper -->
                    </div>
                    <!--div    usquare_square -->
                    <div class="usquare_block_extended usquare_square_bg1">
                        <a href="#" class="close"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/close.png" alt="close" /></a>
                        <ul class="social_background">
                            <li><a href="mailto:313@313.co.kr"><i class="fa fa-envelope-o fa-2x"></i></a></li>
                            <li>
                                <a href="https://www.facebook.com/"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-fb.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href="https://twitter.com/"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-tw.png" alt="social" /></a>
                            </li>
                        </ul>

                        <div class="clear"></div>

                        <span class="bold">info:</span>
                        <div class="usquare_about">
								My name is Lee DongMin.<br>
								I am currently working as a Java developer in AhnLab.<br>
								My motto is "Simple is Best"
							<%-- <ul class="jcarousel-skin-tango">
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider1.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider2.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider3.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider4.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider5.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider6.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider7.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider8.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider9.png" width="63" height="48" alt="" /></li>
                            </ul> --%>	
                        </div>
                    </div>
                    <!-- usquare_block_extended -->
                </div>
                <!-- usquare_block -->
                <!-- section 2 -->
                <div class="usquare_block">
                    <img src="${pageContext.request.contextPath}/assets/images/community/frontendProfile/LCY.jpg" class="usquare_square" alt="" />
                    <div class="usquare_square usquare_square_bg2">
                        <div class="usquare_square_text_wrapper">
                            <img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/arrow.png" class="usquare_arrow" alt="arrow" />
                            <div class="clear"></div>
                            <h2>이창용</h2>
                            <span>Web Programmer</span>
                            <div class="clear"></div>
                        </div>
                        <!-- usquare_square_wrapper -->
                    </div>
                    <!--div    usquare_square -->
                    <div style="display:none;" class="usquare_block_extended usquare_square_bg2">
                        <a href="" class="close"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/close.png" alt="close" /></a>

                        <ul class="social_background">
                        	<li>
                        		<a href="mailto:lcy9002@naver.com"><i class="fa fa-envelope-o fa-2x"></i></a>
                        	</li>
                        </ul>

                        <div class="clear"></div>
                        <span class="bold">info:</span>
                        <div class="usquare_about">
                        		My name is Lee ChangYong.<br>
								I am currently working as a Web Programmer in Maius.<br>
								My motto is "Do not give others the damage"
                           <%--  <ul class="jcarousel-skin-tango">
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider1.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider2.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider3.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider4.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider5.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider6.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider7.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider8.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider9.png" width="63" height="48" alt="" /></li>
                            </ul> --%>
                        </div>
                    </div>
                    <!-- usquare_block_extended -->

                </div>
                <!-- usquare_block -->
                <!-- section 3 -->
                <div class="usquare_block">
                    <img src="${pageContext.request.contextPath}/assets/images/community/frontendProfile/ESM.jpg" class="usquare_square" alt="" />
                    <div class="usquare_square usquare_square_bg3">
                        <div class="usquare_square_text_wrapper">
                            <img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/arrow.png" class="usquare_arrow" alt="arrow" />
                            <div class="clear"></div>
                            <h2>엄선미</h2>
                            <span>Student</span>
                            <div class="clear"></div>
                        </div>
                        <!-- usquare_square_wrapper -->
                    </div>
                    <!--div    usquare_square -->
                    <div style="display:none;" class="usquare_block_extended usquare_square_bg3">
                        <a href="" class="close"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/close.png" alt="close" /></a>
						
                        <ul class="social_background">
                            <li>
                        		<a href="mailto:vsmumv@gmail.com"><i class="fa fa-envelope-o fa-2x"></i></a>
                        	</li>
                        </ul>

                        <div class="clear"></div>
                        <span class="bold">info:</span>
                        <div class="usquare_about">
                        		My name is Eom SeonMi.<br>
								I am currently studying in college graduates.<br>
								I live in Gunpo-si, Gyeonggi-do, Korea 

                           <%--  <ul class="jcarousel-skin-tango">
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider1.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider2.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider3.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider4.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider5.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider6.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider7.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider8.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider9.png" width="63" height="48" alt="" /></li>
                            </ul> --%>
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
                            <span class="usquare_r">Publisher</span>
                            <div class="clear"></div>
                        </div>
                        <!-- usquare_square_wrapper -->
                    </div>
                    <!--div    usquare_square -->
                    <img src="${pageContext.request.contextPath}/assets/images/community/frontendProfile/YBT.jpg" class="usquare_square" alt="" />
                    <div style="display:none;" class="usquare_block_extended usquare_square_bg4">
                        <a href="" class="close close_left_side"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/close.png" alt="close" /></a>

                        <ul class="social_background">
                        	<li>
                        		<a href="mailto:ybt8901@naver.com"><i class="fa fa-envelope-o fa-2x"></i></a>
                        	</li>
                            <li>
                                <a href="https://www.facebook.com/bongtae.yun"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-fb.png" alt="social" /></a>
                            </li>
                        </ul>

                        <div class="clear"></div>
                        <span class="bold">info:</span>
                        <div class="usquare_about">
                        		My name is Yun Bongtae.<br>
								I am currently working as a Publisher in Eilab.<br>
								My motto is "Everyone just look at the world only within the limits of his own understanding of and appreciation"

                            <%-- <ul class="jcarousel-skin-tango">
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider1.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider2.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider3.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider4.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider5.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider6.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider7.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider8.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider9.png" width="63" height="48" alt="" /></li>
                            </ul> --%>
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
                            <span class="usquare_r">Publisher</span>
                            <div class="clear"></div>
                        </div>
                        <!-- usquare_square_wrapper -->
                    </div>
                    <!--div    usquare_square -->
                    <img src="${pageContext.request.contextPath}/assets/images/community/frontendProfile/LHJ.jpg" class="usquare_square" alt="" />
                    <div style="display:none;" class="usquare_block_extended usquare_square_bg5">
                        <a href="" class="close close_left_side"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/close.png" alt="close" /></a>

                        <ul class="social_background">
                        	<li>
                        		<a href="mailto:atelier.jiny@gmail.com"><i class="fa fa-envelope-o fa-2x"></i></a>
                        	</li>
                            <li>
                                <a href="www.facebook.com/hyejiny.1204"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-fb.png" alt="social" /></a>
                            </li>
                            <%-- <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-tw.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-in.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-pint.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-dig.png" alt="social" /></a>
                            </li> --%>
                        </ul>

                        <div class="clear"></div>
                        <span class="bold">info:</span>
                        <div class="usquare_about">
								My name is Lee Hyejin.<br>
								I am currently working as a Publisher in Tqoon.<br>
								My motto is "365 new days, 365 new chances."
                            <%-- <ul class="jcarousel-skin-tango">
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider1.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider2.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider3.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider4.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider5.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider6.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider7.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider8.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider9.png" width="63" height="48" alt="" /></li>
                            </ul> --%>
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
                            <h2 class="usquare_r">양희성</h2>
                            <span class="usquare_r">Java Developer</span>
                            <div class="clear"></div>
                        </div>
                        <!-- usquare_square_wrapper -->
                    </div>
                    <!--div    usquare_square -->
                    <img src="${pageContext.request.contextPath}/assets/images/community/frontendProfile/YHS.jpg" class="usquare_square" alt="" />
                    <div style="display:none;" class="usquare_block_extended usquare_square_bg6">
                        <a href="" class="close close_left_side"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/close.png" alt="close" /></a>

                        <ul class="social_background">
                        	<li>
                        		<a href="mailto:love-hiro@nate.com"><i class="fa fa-envelope-o fa-2x"></i></a>
                        	</li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-fb.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-tw.png" alt="social" /></a>
                            </li>
                            <%-- <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-in.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-pint.png" alt="social" /></a>
                            </li>
                           
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-dig.png" alt="social" /></a>
                            </li> --%>
                        </ul>

                        <div class="clear"></div>
                        <span class="bold">info:</span>
                        <div class="usquare_about">
                        		My name is Yang HeeSeong.<br>
								I am currently working as a Java Developer in EduZone.<br>
								My motto is "If you do not sleep Sleep now I am dreaming achieving your dream.",<br>
								"Do not repeat the same mistakes"
								
									
                           <%--  <ul class="jcarousel-skin-tango">
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider1.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider2.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider3.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider4.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider5.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider6.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider7.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider8.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider9.png" width="63" height="48" alt="" /></li>
                            </ul> --%>
                        </div>
                    </div>
                    <!-- usquare_block_extended -->
                </div>
                <!-- usquare_block -->
                <!-- section 7 -->
                <div class="usquare_block">
                    <img src="${pageContext.request.contextPath}/assets/images/community/frontendProfile/PJK.jpg" class="usquare_square" alt="" />
                    <div class="usquare_square usquare_square_bg7">
                        <div class="usquare_square_text_wrapper">
                            <img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/arrow.png" class="usquare_arrow usquare_arrow" alt="arrow" />
                            <div class="clear"></div>
                            <h2>박진경</h2>
                            <span>Publisher</span>
                            <div class="clear"></div>
                        </div>
                        <!-- usquare_square_wrapper -->
                    </div>
                    <!--div    usquare_square -->
                    <div style="display:none;" class="usquare_block_extended usquare_square_bg7">
                        <a href="" class="close"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/close.png" alt="close" /></a>

                        <ul class="social_background">
                        	<li>
                        		<a href="mailto:pdid1004@gmail.com"><i class="fa fa-envelope-o fa-2x"></i></a>
                        	</li>
                            <li>
                                <a href="https://www.facebook.com/profile.php?id=100003669255182"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-fb.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href="https://twitter.com/pdid1004"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-tw.png" alt="social" /></a>
                            </li>
                           <%--  <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-in.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-pint.png" alt="social" /></a>
                            </li>
                            
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-dig.png" alt="social" /></a>
                            </li> --%>
                        </ul>

                        <div class="clear"></div>
                        <span class="bold">info:</span>
                        <div class="usquare_about">
                        		My name is Park Jingyeong.<br>
								I am currently working as a Publisher in ZIONID.<br>
								My motto is "Past time does not come back again."

                            <%-- <ul class="jcarousel-skin-tango">
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider1.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider2.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider3.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider4.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider5.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider6.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider7.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider8.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider9.png" width="63" height="48" alt="" /></li>
                            </ul> --%>
                        </div>
                    </div>
                    <!-- usquare_block_extended -->
                </div>
                <!-- usquare_block -->
                <!-- section 8 -->
                <div class="usquare_block">
                    <img src="${pageContext.request.contextPath}/assets/images/community/frontendProfile/CKS.jpg" class="usquare_square" alt="" /> 
                    <div class="usquare_square usquare_square_bg8">
                        <div class="usquare_square_text_wrapper">
                            <img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/arrow.png" class="usquare_arrow" alt="arrow" />
                            <div class="clear"></div>
                            <h2>최경석</h2>
                            <span>Java Developer</span>
                            <div class="clear"></div>
                        </div>
                        <!-- usquare_square_wrapper -->
                    </div>
                    <!--div    usquare_square -->
                    <div style="display:none;" class="usquare_block_extended usquare_square_bg8">
                        <a href="" class="close"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/close.png" alt="close" /></a>

                        <ul class="social_background">
                        	<li>
                        		<a href="mailto:ssingame@nate.com"><i class="fa fa-envelope-o fa-2x"></i></a>
                        	</li>
                            <li>
                                <a href="fb.me/ssingame"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-fb.png" alt="social" /></a>
                            </li>
                            <%-- <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-tw.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-in.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-pint.png" alt="social" /></a>
                            </li>
                            
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-dig.png" alt="social" /></a>
                            </li> --%>
                        </ul>

                        <div class="clear"></div>
                        <span class="bold">info:</span>
                        <div class="usquare_about">
                        		My name is Choi KyoungSeok.<br>
								I am currently working as a Java Developer in Osse / Operating System Support Office .<br>
								My motto is "If it is the."

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
                    <img src="${pageContext.request.contextPath}/assets/images/community/frontendProfile/LEC.jpg" class="usquare_square" alt="" />
                    <div class="usquare_square usquare_square_bg9">
                        <div class="usquare_square_text_wrapper">
                            <img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/arrow.png" class="usquare_arrow" alt="arrow" />
                            <div class="clear"></div>
                            <h2>이은철</h2>
                            <span>Java Developer</span>
                            <div class="clear"></div>
                        </div>
                        <!-- usquare_square_wrapper -->
                    </div>
                    <!--div    usquare_square -->
                    <div style="display:none;" class="usquare_block_extended usquare_square_bg9">
                        <a href="" class="close"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/close.png" alt="close" /></a>

                        <ul class="social_background">
                        	<li>
                        		<a href="mailto:topdevlee@gmail.com"><i class="fa fa-envelope-o fa-2x"></i></a>
                        	</li>
                            <li>
                                <a href="https://www.facebook.com/euncheol.lee.52"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-fb.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href="https://twitter.com/Cessiah"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-tw.png" alt="social" /></a>
                            </li>
                            <%-- <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-in.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-pint.png" alt="social" /></a>
                            </li>
                            
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-dig.png" alt="social" /></a>
                            </li> --%>
                        </ul>

                        <div class="clear"></div>
                        <span class="bold">info:</span>
                        <div class="usquare_about">
                        		My name is Lee Euncheol.<br>
								I am currently working as a Java Developer in YoungoneOutdoor.<br>
								My motto is "Live without regrets."

                            <%-- <ul class="jcarousel-skin-tango">
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider1.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider2.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider3.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider4.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider5.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider6.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider7.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider8.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider9.png" width="63" height="48" alt="" /></li>
                            </ul> --%>
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
                            <span class="usquare_r">Java Developer</span>
                            <div class="clear"></div>
                        </div>
                        <!-- usquare_square_wrapper -->
                    </div>
                    <!--div    usquare_square -->
                    <img src="${pageContext.request.contextPath}/assets/images/community/frontendProfile/KHJ.jpeg" class="usquare_square" alt="" />
                    <div style="display:none;" class="usquare_block_extended usquare_square_bg4">
                        <a href="" class="close close_left_side"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/close.png" alt="close" /></a>

                        <ul class="social_background">
                        	<li>
                        		<a href="mailto:slahsk@naver.com"><i class="fa fa-envelope-o fa-2x"></i></a>
                        	</li>
                            <li>
                                <a href=" https://www.facebook.com/slahsk?fref=ts"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-fb.png" alt="social" /></a>
                            </li>
                            <%-- <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-tw.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-in.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-pint.png" alt="social" /></a>
                            </li> --%>
                            <%-- <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-dig.png" alt="social" /></a>
                            </li> --%>
                        </ul>

                        <div class="clear"></div>
                        <span class="bold">info:</span>
                        <div class="usquare_about">
                        		My name is Kim HiJun.<br>
								I am currently working as a Java Developer in Mdct.<br>
								My motto is "Live without regrets."

                            <%-- <ul class="jcarousel-skin-tango">
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider1.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider2.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider3.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider4.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider5.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider6.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider7.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider8.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider9.png" width="63" height="48" alt="" /></li>
                            </ul> --%>
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
                            <span class="usquare_r">Java Developer </span>
                            <div class="clear"></div>
                        </div>
                        <!-- usquare_square_wrapper -->
                    </div>
                    <!--div    usquare_square -->
                    <img src="${pageContext.request.contextPath}/assets/images/community/frontendProfile/JJH.jpg" class="usquare_square" alt="" />
                    <div style="display:none;" class="usquare_block_extended usquare_square_bg5">
                        <a href="" class="close close_left_side"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/close.png" alt="close" /></a>

                        <ul class="social_background">
                        	<li>
                        		<a href="mailto:jungho461@naver.com"><i class="fa fa-envelope-o fa-2x"></i></a>
                        	</li>
                            <%-- <li>
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
                            </li> --%>
                        </ul>

                        <div class="clear"></div>
                        <span class="bold">info:</span>
                        <div class="usquare_about">
                        		국정원

                           <%--  <ul class="jcarousel-skin-tango">
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider1.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider2.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider3.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider4.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider5.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider6.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider7.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider8.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider9.png" width="63" height="48" alt="" /></li>
                            </ul> --%>
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
                            <span class="usquare_r">Publisher</span>
                            <div class="clear"></div>
                        </div>
                        <!-- usquare_square_wrapper -->
                    </div>
                    <!--div    usquare_square -->
                    <img src="${pageContext.request.contextPath}/assets/images/community/frontendProfile/JOH.jpg" class="usquare_square" alt="" />
                    <div style="display:none;" class="usquare_block_extended usquare_square_bg6">
                        <a href="" class="close close_left_side"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/close.png" alt="close" /></a>

                        <ul class="social_background">
                        	<li>
                        		<a href="mailto:usdrd90@gmail.com"><i class="fa fa-envelope-o fa-2x"></i></a>
                        	</li>
                            <%-- <li>
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
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-dig.png" alt="social" /></a>
                            </li>--%>
                        </ul> 

                        <div class="clear"></div>
                        <span class="bold">info:</span>
                        <div class="usquare_about">
								My name is Jeon Okhyeon.<br>
								I am currently working as a Publisher in Dodoom.<br>
								My motto is "Try your best"
                            <%-- <ul class="jcarousel-skin-tango">
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider1.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider2.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider3.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider4.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider5.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider6.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider7.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider8.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider9.png" width="63" height="48" alt="" /></li>
                            </ul> --%>
                        </div>
                    </div>
                    <!-- usquare_block_extended -->
                </div>
                <!-- usquare_block -->
                <!-- section 13 -->
                <div class="usquare_block">
                    <img src="${pageContext.request.contextPath}/assets/images/community/frontendProfile/KBR.jpg" class="usquare_square" alt="" />
                    <div class="usquare_square usquare_square_bg1">
                        <div class="usquare_square_text_wrapper">
                            <img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/arrow.png" class="usquare_arrow" alt="arrow" />
                            <div class="clear"></div>
                            <h2>김범룡</h2>
                            <span>Java Developer</span>
                            <div class="clear"></div>
                        </div>
                        <!-- usquare_square_wrapper -->
                    </div>
                    <!--div    usquare_square -->
                    <div class="usquare_block_extended usquare_square_bg1">
                        <a href="#" class="close"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/close.png" alt="close" /></a>
                        <ul class="social_background">
                        	<li>
                        		<a href="mailto:batstorm@naver.com"><i class="fa fa-envelope-o fa-2x"></i></a>
                        	</li>
                            <%-- <li>
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
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-dig.png" alt="social" /></a>
                            </li> --%>
                        </ul>

                        <div class="clear"></div>

                        <span class="bold">info:</span>
                        <div class="usquare_about">
                            	My name is Kim BeomRyong.<br>
								I am currently working as a Java Developer in Beintech.<br>
								My motto is "If you can not avoid Enjoy"

                           <%--  <ul class="jcarousel-skin-tango">
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider1.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider2.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider3.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider4.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider5.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider6.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider7.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider8.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider9.png" width="63" height="48" alt="" /></li>
                            </ul> --%>
                        </div>
                    </div>
                    <!-- usquare_block_extended -->
                </div>
                <!-- usquare_block -->
                <!-- section 14 -->
                <div class="usquare_block">
                    <img src="${pageContext.request.contextPath}/assets/images/community/frontendProfile/CYJ.jpg" class="usquare_square" alt="" />
                    <div class="usquare_square usquare_square_bg2">
                        <div class="usquare_square_text_wrapper">
                            <img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/arrow.png" class="usquare_arrow" alt="arrow" />
                            <div class="clear"></div>
                            <h2>최유진</h2>
                            <span>Publisher</span>
                            <div class="clear"></div>
                        </div>
                        <!-- usquare_square_wrapper -->
                    </div>
                    <!--div    usquare_square -->
                    <div style="display:none;" class="usquare_block_extended usquare_square_bg2">
                        <a href="" class="close"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/close.png" alt="close" /></a>

                        <ul class="social_background">
                        	<li>
                        		<a href="mailto:cej8971@naver.com"><i class="fa fa-envelope-o fa-2x"></i></a>
                        	</li>
                            <li>
                                <a href="https://www.facebook.com/yujin.eri.choi"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-fb.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href="https://twitter.com/cej8971"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-tw.png" alt="social" /></a>
                            </li>
                           <%--  <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-in.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-pint.png" alt="social" /></a>
                            </li>
                            
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-dig.png" alt="social" /></a>
                            </li> --%>
                        </ul>

                        <div class="clear"></div>
                        <span class="bold">info:</span>
                        <div class="usquare_about">
								My name is Choi YuJin.<br>
								I am currently working as a Publisher in SaraminHR.<br>
								My motto is "Begin right now. Be immersed in the present."
                           <%--  <ul class="jcarousel-skin-tango">
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider1.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider2.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider3.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider4.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider5.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider6.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider7.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider8.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider9.png" width="63" height="48" alt="" /></li>
                            </ul> --%>
                        </div>
                    </div>
                    <!-- usquare_block_extended -->

                </div>
                <!-- usquare_block -->
                <!-- section 15 -->
                <div class="usquare_block">
                    <img src="${pageContext.request.contextPath}/assets/images/community/frontendProfile/YJW.jpg" class="usquare_square" alt="" />
                    <div class="usquare_square usquare_square_bg3">
                        <div class="usquare_square_text_wrapper">
                            <img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/arrow.png" class="usquare_arrow" alt="arrow" />
                            <div class="clear"></div>
                            <h2>유정우</h2>
                            <span>Java Developer</span>
                            <div class="clear"></div>
                        </div>
                        <!-- usquare_square_wrapper -->
                    </div>
                    <!--div    usquare_square -->
                    <div style="display:none;" class="usquare_block_extended usquare_square_bg3">
                        <a href="" class="close"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/close.png" alt="close" /></a>

                        <ul class="social_background">
                        	<li>
                        		<a href="mailto:dreamsaspire7@gmail.com"><i class="fa fa-envelope-o fa-2x"></i></a>
                        	</li>
                            <li>
                                <a href="https://www.facebook.com/profile.php?id=100006993108849&ref=ts&fref=ts"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-fb.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href="https://twitter.com/holicplus"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-tw.png" alt="social" /></a>
                            </li>
                            <%-- <li>
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
                            </li> --%>
                        </ul>

                        <div class="clear"></div>
                        <span class="bold">info:</span>
                        <div class="usquare_about">
								My name is Yu JungWoo.<br>
								I am currently working as a Java Developer in Ezen.<br>
								My motto is "Better than yesterday"
                            <%-- <ul class="jcarousel-skin-tango">
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider1.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider2.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider3.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider4.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider5.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider6.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider7.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider8.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider9.png" width="63" height="48" alt="" /></li>
                            </ul> --%>
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
                            <span class="usquare_r">Web Programmer</span>
                            <div class="clear"></div>
                        </div>
                        <!-- usquare_square_wrapper -->
                    </div>
                    <!--div    usquare_square -->
                    <img src="${pageContext.request.contextPath}/assets/images/community/frontendProfile/JJS.jpg" class="usquare_square" alt="" />
                    <div style="display:none;" class="usquare_block_extended usquare_square_bg4">
                        <a href="" class="close close_left_side"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/close.png" alt="close" /></a>

                        <ul class="social_background">
                        	<li>
                        		<a href="mailto:lazyker@naver.com"><i class="fa fa-envelope-o fa-2x"></i></a>
                        	</li>
                            <li>
                                <a href="https://www.facebook.com/lazyker?fref=pymk"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-fb.png" alt="social" /></a>
                            </li>
                           <%--  <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-tw.png" alt="social" /></a>
                            </li> --%>
                            <li>
                                <a href="https://instagram.com/lazyker/"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-in.png" alt="social" /></a>
                            </li>
                            <%-- <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-pint.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-yah.png" alt="social" /></a>
                            </li>
                            <li>
                                <a href=""><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-dig.png" alt="social" /></a>
                            </li> --%>
                        </ul>

                        <div class="clear"></div>
                        <span class="bold">info:</span>
                        <div class="usquare_about">
								My name is Jeong Jongseok.<br>
								I am currently working as a Web Programmer in Zeniel.<br>
								My motto is "Positive'll stay"
                            <%-- <ul class="jcarousel-skin-tango">
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider1.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider2.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider3.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider4.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider5.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider6.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider7.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider8.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider9.png" width="63" height="48" alt="" /></li>
                            </ul> --%>
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
                            <span class="usquare_r">Publisher </span>
                            <div class="clear"></div>
                        </div>
                        <!-- usquare_square_wrapper -->
                    </div>
                    <!--div    usquare_square -->
                    <img src="${pageContext.request.contextPath}/assets/images/community/frontendProfile/LSH.jpg" class="usquare_square" alt="" />
                    <div style="display:none;" class="usquare_block_extended usquare_square_bg5">
                        <a href="" class="close close_left_side"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/close.png" alt="close" /></a>

                        <ul class="social_background">
                        	<li>
                        		<a href="mailto:sora7980@gmail.com"><i class="fa fa-envelope-o fa-2x"></i></a>
                        	</li>
                            <li>
                                <a href="https://www.facebook.com/profile.php?id=100006093545798&fref=tl_fr_box&pnref=lhc.friends"><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/images/social-fb.png" alt="social" /></a>
                            </li>
                            <%-- <li>
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
                            </li> --%>
                        </ul>

                        <div class="clear"></div>
                        <span class="bold">info:</span>
                        <div class="usquare_about">
                        		My name is Lee Seunghui.<br>
								I am currently working as a Publisher in freelancer.<br>
								My motto is "Until the end!"
                            <%-- <ul class="jcarousel-skin-tango">
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider1.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider2.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider3.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider4.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider5.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider6.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider7.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider8.png" width="63" height="48" alt="" /></li>
                                <li><img src="${pageContext.request.contextPath}/assets/js/usquare_jquery/content/jcarousel/slider9.png" width="63" height="48" alt="" /></li>
                            </ul> --%>
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