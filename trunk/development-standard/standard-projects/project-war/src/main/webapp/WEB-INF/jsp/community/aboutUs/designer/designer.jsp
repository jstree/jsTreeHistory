<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="ko" class="no-js">
<!--<![endif]-->
	<head>		
		<script>
	    $(function(){
	        //here is jquery and javascript code input
	        alert('min min fighting and youv got passaion for your youth');
	        }); 
		</script>
		<!-- CSS for Committer Profile Section -->
		<style type="text/css">
		/*reset*/
		body,p,h1,h2,h3,h4,h5,h6,ul,ol,li,dl,dt,dd,form,fieldset,input,button { margin:0; padding:0}
		body,h1,h2,h3,h4,h5,h6,th,td,button,input{ font:12px "나눔고딕",Nanum Gothic,sans-serif;}
		ul,ol,li { list-style:none;}
		a { text-decoration:none;}

		/*album*/
		#page_wrap{width:1180px; height:1372px; padding-top:40px; margin:0 auto;}

		#header{ width:1180px; height:151px;}
		#d_title{ width:171px; height:65px; margin:0 auto;}
		#d_title h2{ display:block; width:122px; font-size:30px; color:#f32d20; margin:0 auto 14px;}
		#d_list{ display:block; width:158px; height:12px; margin:0 auto;}
		#d_title #d_list li { float:left; color:#575757;}
		#d_title #d_list li a{margin:0 2px; color:#575757;}
		#d_title #d_list li a:hover{ color:#f32d20;}

		#intro{ height:1284px; widows:1180px;}
		/*1/3*/
		.leftD{ height:252px; border-bottom:7px solid #f32d20; margin-bottom:27px;}
		.leftD #cha{ width:360px; height:253px; float:left; z-index:1;}
		.leftD .liw{ float:left;}
		.leftD #cha_sns li a{ width:36px; height:36px; margin:4px;}
		.liw .d_n{ float:left; width:386px;}
		.liw .d_n .dsn{ width:211px; height:68px; margin:75px auto 0;}
		.liw .d_n .dsn .designer{ display:block; width:106px; height:24px; font-size:24px; color:#f32d20; margin:0 auto 4px;}
		.liw .d_n .dsn .dName{ display:block; width:200px; height:28px; font-size:28px; color:#575757; margin:0 auto;}
		.liw .careerW{ float:left;}
		.liw .careerW .info{display:block; width:76px; height:24px; float:left; font-size:24px; color:#f32d20; margin-top:94px;}
		.liw .careerW .career{ float:left; display:block; width:306px; font-size:15px; color:#575757; margin-top:61px;}
	    
	    
	    /*2/4*/
	    .rightD{ height:252px; border-bottom:7px solid #f32d20; margin-bottom:27px;}
	    .rightD .riw{ float:left; width:820px; height:245px; background-color:#575757;}
	    .rightD #kim{float:right; z-index:1; height:253px; width:360px;}
	    
	    
	    /*.riw .carrerW2{width:556px; float: left; }
	    .riw .carrerW2 #sns2{}
	    .riw .carrerW2 .info2{display:block; width:76px; height:24px; float:left; font-size:24px; color:#f32d20; margin-top:94px;}
	    .riw .carrerW2 .info2 .career2{ float:left; display:block; width:306px; font-size:15px; color:#575757; margin-top:61px;}
	    .riw .d_n{ float:left; width:386px;}/*
	    
		
		</style>	
	</head>
	<body>
		<div id="page_wrap">

	<div id="header">
		<div id="d_title">
    		<h2>Designer</h2>
        	<ul id="d_list">
        		<li><a href="#">Home</a>/</li>
            	<li><a href="#">About Us</a>/</li>
            	<li><a href="#">FrontEnd</a></li>
        	</ul>
    	</div><!--//d_title-->
	</div><!--//header-->
    
    
    <div id="intro">
    	<div class="leftD">
            <span id="cha"><img src="http://nas.313.co.kr:5002/Component/jsp/community/aboutUs/designer/img/cha.jpg" alt="차승원 디자이너"/></span>
            <div class="liw">
                <div class="d_n">
                	<div class="dsn">
                    	<h2 class="designer">Designer</h2>
                    	<h3 class="dName">Cha Seungwon</h3>
                    </div><!--//dsn-->
                </div><!--//d_n-->
                <div class="careerW">
                    <h2 class="info">Info</h2>
                    <ol class="career">
                        <li>96 - 98  &nbsp;르노삼성 디자인팀</li>
                        <li>98 - 03  &nbsp;동화 삽화 디자인</li>
                        <li>03 - 07  &nbsp;롯데제과 패키지 디자인</li>
                        <li>07 - 11  &nbsp;네이버 웹디자인</li>
                        <li>12- &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;313웹 디자인</li>
                    </ol>
                </div><!--//carrerW-->
            </div><!--//liw-->
            <div id="sns1">
                    <ul id="cha_sns">
                        <li><a href="#"><img src="http://nas.313.co.kr:5002/Component/jsp/community/aboutUs/designer/img/mail.png" alt="이메일"/></a></li>
                        <li><a href="#"><img src="http://nas.313.co.kr:5002/Component/jsp/community/aboutUs/designer/img/facebook.png" alt="페이스북"/></a></li>
                        <li><a href="#"><img src="http://nas.313.co.kr:5002/Component/jsp/community/aboutUs/designer/img/twt.png" alt="트위터"/></a></li>
                    </ul>
                </div><!--//sns1-->
        </div><!--//leftD-->
        
        
        <div class="rightD">
            <div class="riw">
            	<div class="careerW2">
            		<div id="sns2">
                    	<ul id="kim_sns">
                    	   <li><a href="#"><img src="http://nas.313.co.kr:5002/Component/jsp/community/aboutUs/designer/img/mail.png" alt="이메일"/></a></li>
                    	   <li><a href="#"><img src="http://nas.313.co.kr:5002/Component/jsp/community/aboutUs/designer/img/facebook.png" alt="페이스북"/></a></li>
                    	   <li><a href="#"><img src="http://nas.313.co.kr:5002/Component/jsp/community/aboutUs/designer/img/twt.png" alt="트위터"/></a></li>
                	 </ul>
            		</div><!--//sns2-->
                    <h2 class="info2">Info</h2>
                    <ol class="career2">
                        <li>96 - 98  &nbsp;르노삼성 디자인팀</li>
                        <li>98 - 03  &nbsp;동화 삽화 디자인</li>
                        <li>03 - 07  &nbsp;롯데제과 패키지 디자인</li>
                        <li>07 - 11  &nbsp;네이버 웹디자인</li>
                        <li>12- &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;313웹 디자인</li>
                    </ol>
                </div><!--//carrerW-->
                <div class="d_n">
                	<div class="dsn">
                    	<h2 class="designer">Designer</h2>
                    	<h3 class="dName">Kim hyunjoo</h3>
                    </div><!--//dsn-->
                </div><!--//d_n-->
            </div><!--//riw-->
            <span id="kim"><img src="http://nas.313.co.kr:5002/Component/jsp/community/aboutUs/designer/img/kim.jpg" alt="김현주 디자이너"/></span>
        </div><!--//rightD-->
        
        
        
    </div><!--//intro-->
   
</div><!--//page_wrap-->   
	</body>
</html>
