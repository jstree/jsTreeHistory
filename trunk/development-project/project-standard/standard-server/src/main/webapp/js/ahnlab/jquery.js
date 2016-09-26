$(function(){

	$(document).click(function (){
		$(".locLi").removeClass("on");
		$(".globalSiteCombo").removeClass("on");
		$(".familySiteCombo").removeClass("on");
	});

	//메인 gnb메뉴 외에 레이어 팝업이 있는 객체 click
	$(".muProd, .muSecurity, .muPurchase, .muDown, .muSupport, .muInfo, .locSite, .familySite, .familyWrap, .locSiteWrap").hover(function(){
        $(this).addClass("on");
	},function(){
        $(this).removeClass("on");
	}).focusin(function(){
        $(this).addClass("on");
	}).focusout(function(){
        $(this).removeClass("on");
	});

	//블로그
	$("#ablogLayer").focusin(function(){
		$(this).siblings("#blogLayerId").show();
	});

	//로케이션 마우스오버시&포커트시 레이어 펼침.
	$(".LocationNavi").mouseenter(function(){
		$(this).addClass("on");
	});

	$(".locLink").focus(function(){
		$(this).closest(".LocationNavi").addClass("on");
	});


	// 로케이션 마우스아웃시 레이어 닫힘.
	$(".LocationNavi").mouseleave(function(){
		$(this).removeClass("on");
	});

	//로케이션 레이어 포커스 나갔을때 팝업 닫힘
	$(".locList > p > a").focusout(function (){
		if(($(this).parent().index() + 1) == $(this).parents(".locList").children().length){
			$(this).parents(".LocationNavi").removeClass("on");
		}
	});

	//콤보박스 클릭시 레이어 팝업 펼침/닫힘
	$(".comboLink").click(function(){
		if($(this).parent().hasClass("on"))
			$(this).parent().removeClass("on");
		else
			$(this).parent().addClass("on");

	});

	//콤보박스 클릭시 레이어 팝업 펼침/닫힘
	$(".comboLink2").click(function(){
		if($(this).parent().parent().hasClass("on"))
			$(this).parent().parent().removeClass("on");
		else
			$(this).parent().parent().addClass("on");
	});

	//페이지 네비게이션 버튼.
	$(".paging > .btnMove").click(function(){
		var txt =$(this).attr("href");
		txt = txt.replace("javascript:", "");
		if(txt != "#"){
			eval(txt);
		}
	});

	//컨텐츠의 사이즈 재조정
	if ( isIE() ){
		//바닥 사이즈
		$(".contents .bbsViewCont img").each(function (){
	    	var w = $(this).width();
	    	if(w > 930){
	    		$(this).width('930px');
	    	}
	    });
		//팝업 사이즈
		$(".popWrap .bbsViewCont img").each(function (){
	    	var w = $(this).width();
	    	if(w > 510){
	    		$(this).width('510px');
	    	}
	    });
	}else{
		//바닥 사이즈
		$(".contents .bbsViewCont img").load(function (){
	    	var w = $(this).width();
	    	if(w > 930){
	    		$(this).width('930px');
	    	}
	    });
		//팝업 사이즈
		$(".popWrap .bbsViewCont img").load(function (){
	    	var w = $(this).width();
	    	if(w > 510){
	    		$(this).width('510px');
	    	}
	    });
	}

	//a 태그에 dim처리 된 객체에 대체택스트 제공.
	$("a").each(function (){
		if($(this).hasClass("disable")){
			$(this).attr("title", "제공하지 않는 서비스입니다.");
		}
	});
});
