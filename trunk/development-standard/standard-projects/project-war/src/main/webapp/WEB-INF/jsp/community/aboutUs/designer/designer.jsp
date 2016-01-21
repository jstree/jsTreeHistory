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
		#page_wrap{width:1180px; height:1322px; padding-top:30px; margin:0 auto;}

		#header{ width:1180px; height:151px;}
		#d_title{ width:171px; height:65px; margin:0 auto;}
		#d_title h2{ display:block; width:122px; font-size:30px; color:#f32d20; margin:0 auto 14px;}
		#d_list{ display:block; width:158px; height:12px; margin:0 auto;}
		#d_title #d_list li { float:left; color:#575757;}
		#d_title #d_list li a{margin:0 2px; color:#575757;}
		#d_title #d_list li a:hover{ color:#f32d20;}

		#intro{ height:1284px; widows:1180px;}
		
		/*1/3*/	
		#leftD{ width:1180px; height:252px; border-bottom:7px solid #f32d20; margin-bottom:27px}
		#leftD p img{ float:left;}
		#leftD .dwrap{ width:362px; height:245px; float:left;}
		#leftD .dwrap #designer{display:block; width:106px; height:24px; font-size:24px; color:#f32d20; position:relative; top:85px; left:140px;}
		#leftD .dwrap #name{display:block; width:200px; height:28px; font-size:28px; position:relative; top:104px; left:85px;}
		#leftD .dwrap #name2{display:block; width:200px; height:28px; font-size:28px; position:relative; top:104px; left:105px;}
		#leftD .infowrap{ width:449px; height:245px; float:left;}
		#leftD .infowrap #info{font-size:24px; color:#f32d20; display:block; position:relative; top:95px; left:55px;}
		#leftD .infowrap .career{font-size:15px; color:#575757; position:relative; top:40px; left:150px;}
		#leftD .infowrap #cha_sns{  width:126px; height:36px; margin:0; position:relative; top:70px; left:330px;}
		#leftD .infowrap #cha_sns li{float:right; width:36px; height:36px; margin-right:6px;}
	    
	    
	    /*2/4*/
	    #rightD{ width:1180px; height:252px; border-bottom:7px solid #f32d20; margin-bottom:27px;}
		#rightD .infowrap{ width:467px; height:246px; float:left;}
		#rightD .infowrap #kim_sns{ position:relative; top:200px; left:13px; width:126px; height:36px;}
		#rightD .infowrap #kim_sns li{float:left; width:36px; height:36px; margin-right:6px;}
		#rightD .infowrap #info{font-size:24px; color:#f32d20; display:block; position:relative; top:75px; left:126px;}
		#rightD .infowrap .career{font-size:15px; color:#575757; position:relative; top:25px; left:214px;}
		#rightD .infowrap .career span{margin-right:30px;}
		#rightD .dwrap{ width:352px; height:253px; float:left;}
		#rightD .dwrap #designer{display:block; width:106px; height:24px; font-size:24px; color:#f32d20; position:relative; top:85px; left:128px;}
		#rightD .dwrap #name{display:block; width:200px; height:28px; font-size:28px; color:#575757; position:relative; top:104px; left:90px;}
		#rightD .dwrap #name3{display:block; width:200px; height:28px; font-size:28px; color:#575757; position:relative; top:104px; left:100px;}
		#rightD p img{ float:left; z-index:5;}
		
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
    	<div id="leftD">
			<p><img src="http://nas.313.co.kr:5002/Component/jsp/community/aboutUs/designer/img/cha.jpg" alt="차승원 디자이너"/></p>
		    <div class="dwrap">
		    	<span id="designer">Designer</span>
        		<span id="name">Cha Seungwon</span>
    		</div><!--//dwrap-->
			<div class="infowrap">
    			<span id="info">Info</span>
        		<ul class="career">
        			<li>91-96 현대 자동차 디자인팀</li>
					<li>97-00 구몬 웹 디자인팀</li>
					<li>01-04 롯데 시네마 디자인팀</li>
					<li>04-08 다음 디자인팀</li>
					<li>09-12 이재석 디자인 연구소</li>
					<li>13-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;313 웹디자인 소속</li>
    			</ul>
    			<ul id="cha_sns">
					<li><a href="#"><img src="http://nas.313.co.kr:5002/Component/jsp/community/aboutUs/designer/img/mail.png" alt="이메일"/></a></li>
					<li><a href="#"><img src="http://nas.313.co.kr:5002/Component/jsp/community/aboutUs/designer/img/facebook.png" alt="페이스북"/></a></li>
					<li><a href="#"><img src="http://nas.313.co.kr:5002/Component/jsp/community/aboutUs/designer/img/twt.png" alt="트위터"/></a></li>
   	 			</ul>
    		</div><!--//infowrap-->
		</div><!--//leftD-->
        
        <div id="rightD">
			<div class="infowrap">
    			<ul id="kim_sns">
					<li><a href="#"><img src="http://nas.313.co.kr:5002/Component/jsp/community/aboutUs/designer/img/mail.png" alt="이메일"/></a></li>
					<li><a href="#"><img src="http://nas.313.co.kr:5002/Component/jsp/community/aboutUs/designer/img/facebook.png" alt="페이스북"/></a></li>
					<li><a href="#"><img src="http://nas.313.co.kr:5002/Component/jsp/community/aboutUs/designer/img/twt.png" alt="트위터"/></a></li>
   	 			</ul>
    			<span id="info">Info</span>
    		    <ul class="career">
        			<li>91-96 현대 자동차 디자인팀</li>
					<li>97-00 구몬 웹 디자인팀</li>
					<li>01-04 롯데 시네마 디자인팀</li>
					<li>04-08 다음 디자인팀</li>
					<li>09-12 이재석 디자인 연구소</li>
					<li>13-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;313 웹디자인 소속</li>
    		    </ul>
			</div><!--//infowrap-->
    		<div class="dwrap">
    			<span id="designer">Designer</span>
	    	    <span id="name">Kim hyunjoo</span>
    		</div><!--//dwrap-->
    		<p><img src="http://nas.313.co.kr:5002/Component/jsp/community/aboutUs/designer/img/kim.jpg" alt="김현주 디자이너"/></p>
		</div><!--//rightD-->
		
		<div id="leftD">
			<p><img src="http://nas.313.co.kr:5002/Component/jsp/community/aboutUs/designer/img/an.jpg" alt="안재홍 디자이너"/></p>
		    <div class="dwrap">
		    	<span id="designer">Designer</span>
        		<span id="name2">An Jaehong</span>
    		</div><!--//dwrap-->
			<div class="infowrap">
    			<span id="info">Info</span>
        		<ul class="career">
        			<li>91-96 현대 자동차 디자인팀</li>
					<li>97-00 구몬 웹 디자인팀</li>
					<li>01-04 롯데 시네마 디자인팀</li>
					<li>04-08 다음 디자인팀</li>
					<li>09-12 이재석 디자인 연구소</li>
					<li>13-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;313 웹디자인 소속</li>
    			</ul>
    			<ul id="cha_sns">
					<li><a href="#"><img src="http://nas.313.co.kr:5002/Component/jsp/community/aboutUs/designer/img/mail.png" alt="이메일"/></a></li>
					<li><a href="#"><img src="http://nas.313.co.kr:5002/Component/jsp/community/aboutUs/designer/img/facebook.png" alt="페이스북"/></a></li>
					<li><a href="#"><img src="http://nas.313.co.kr:5002/Component/jsp/community/aboutUs/designer/img/twt.png" alt="트위터"/></a></li>
   	 			</ul>
    		</div><!--//infowrap-->
		</div><!--//leftD-->
		
		<div id="rightD">
			<div class="infowrap">
    			<ul id="kim_sns">
					<li><a href="#"><img src="http://nas.313.co.kr:5002/Component/jsp/community/aboutUs/designer/img/mail.png" alt="이메일"/></a></li>
					<li><a href="#"><img src="http://nas.313.co.kr:5002/Component/jsp/community/aboutUs/designer/img/facebook.png" alt="페이스북"/></a></li>
					<li><a href="#"><img src="http://nas.313.co.kr:5002/Component/jsp/community/aboutUs/designer/img/twt.png" alt="트위터"/></a></li>
   	 			</ul>
    			<span id="info">Info</span>
    		    <ul class="career">
        			<li>91-96 현대 자동차 디자인팀</li>
					<li>97-00 구몬 웹 디자인팀</li>
					<li>01-04 롯데 시네마 디자인팀</li>
					<li>04-08 다음 디자인팀</li>
					<li>09-12 이재석 디자인 연구소</li>
					<li>13-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;313 웹디자인 소속</li>
    		    </ul>
			</div><!--//infowrap-->
    		<div class="dwrap">
    			<span id="designer">Designer</span>
	    	    <span id="name3">Park Haejin</span>
    		</div><!--//dwrap-->
    		<p><img src="http://nas.313.co.kr:5002/Component/jsp/community/aboutUs/designer/img/park.jpg" alt="박해진 디자이너"/></p>
		</div><!--//rightD-->
        
        
    </div><!--//intro-->
   
</div><!--//page_wrap-->   
	</body>
</html>
