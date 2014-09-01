<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<script src="http://nas.313.co.kr:5002/Source/Script/ajax/ajax.js" charset="UTF-8"></script>
	<script type="text/javascript" src="http://nas.313.co.kr:5002/Source/Script/jQuery/jquery.com/jquery-1.7.2.js"></script> 
	<script type="text/javascript" src="http://nas.313.co.kr:5002/Source/Script/jQuery/jQueryPlugIns/jnotify_v2.1/jquery/jNotify.jquery.js"></script>
	<link rel="stylesheet" href="http://nas.313.co.kr:5002/Source/Css/widget/style.css" media="screen" />
</head>
<body>
	<div id="container"> 
		<ul class="tabs"> 
			<li class="active" rel="tab1">bloter</li>
			<li rel="tab2">zdnet</li> 
			<li rel="tab3">google Search</li> 
		</ul> 
		<div class="tab_container"> 
			<div id="tab1" class="tab_content"> 
    		</div><!-- #tab1 --> 
		    <div id="tab2" class="tab_content"> 
		    </div><!-- #tab2 --> 
		    <div id="tab3" class="tab_content"> 
		    </div><!-- #tab3 --> 
    	</div> <!-- .tab_container --> 
	</div> <!-- #container --> 
	
	<script type="text/javascript"> 
		$(function() { 
			$(".tab_content").hide(); 
			var url = "http://localhost:8080/templateWeb/sitemesh/jsp/community/component/business/widget/rss/bloter.do";
			$.get(url, function(data) {
				$("#tab1").text("");	
				$("#tab1").append(data);	
			});
			
			$(".tab_content:first").show(); 
			
			
			$("ul.tabs li").click(function() { 
				$("ul.tabs li").removeClass("active").css("color","#333"); 
				$(this).addClass("active").css("color","darkred"); 
				$(".tab_content").hide();
				var activeTab = $(this).attr("rel"); 
				
				var url = null;
				if(activeTab == "tab1"){
					var url = "http://localhost:8080/templateWeb/sitemesh/jsp/community/component/business/widget/rss/bloter.do";
				}else if(activeTab == "tab2"){
					var url = "http://localhost:8080/templateWeb/sitemesh/jsp/community/component/business/widget/rss/zdnet.do";
				}else if(activeTab == "tab3"){
					var url = "http://localhost:8080/templateWeb/sitemesh/jsp/community/component/business/widget/rss/google.do";
				}
				callAjax(null, url, "#" + activeTab , "POST", "html");
				/*
				$.get(url, function(data) {
					$("#" + activeTab).text("");	
					$("#" + activeTab).append(data);	
				});
				*/
				$("#" + activeTab).fadeIn();
			}); 
		});
	</script> 
</body>
</html>