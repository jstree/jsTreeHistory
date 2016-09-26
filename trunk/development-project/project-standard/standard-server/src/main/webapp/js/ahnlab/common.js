function getBrowser(){
	var agt = navigator.userAgent.toLowerCase();
	if (agt.indexOf("chrome") != -1) return 'Chrome';
	if (agt.indexOf("opera") != -1) return 'Opera';
	if (agt.indexOf("staroffice") != -1) return 'Star Office';
	if (agt.indexOf("webtv") != -1) return 'WebTV';
	if (agt.indexOf("beonex") != -1) return 'Beonex';
	if (agt.indexOf("chimera") != -1) return 'Chimera';
	if (agt.indexOf("netpositive") != -1) return 'NetPositive';
	if (agt.indexOf("phoenix") != -1) return 'Phoenix';
	if (agt.indexOf("firefox") != -1) return 'Firefox';
	if (agt.indexOf("safari") != -1) return 'Safari';
	if (agt.indexOf("skipstone") != -1) return 'SkipStone';
	if (agt.indexOf("msie") != -1) return 'Internet Explorer';
	if (agt.indexOf("netscape") != -1) return 'Netscape';
	if (agt.indexOf("mozilla/5.0") != -1) return 'Mozilla';
}

var Common = {
    /**
     * 필드가 비어 있는 지 검사
     */
    isValue: function(str){
    	if (( str == null) || (str == "") || Common.isblank(str))
    		return false;
    	return true;
    },

    /**
     * 문자열에 공백 문자만 포함된 경우에는 true를 반환하는 유틸리티 함수
     */
    isblank: function(str) {
    	for(var i = 0; i < str.length ; i++ ){
    		var c = str.charAt(i);
    		if ( (c != ' ') && (c != '\n') && (c != '\et')) {
    			return false;
    		}
    	}
    	return true;
    },
    /**
    * 문자열 길이가 제한수를 넘지 않으면 true를 반환
    */
    chkByteLen: function(field, maxlimit) {

    	var str = $("#"+field).val();
        var len = 0;
        var intMax = 0;
        var onechar;

        for(var i=0; i<str.length; i++) {
            len += (str.charCodeAt(i) > 128) ? 3 : 1;
            onechar = str.charAt(i);

            if(escape(onechar)=='%0A') {
                len++;
            }
            if (intMax == 0 && len > maxlimit){
                intMax = i;
            }
        }

        if (len > maxlimit) {
            alert("최대 " + maxlimit + "byte 이므로 초과된 글자수는 자동으로 삭제됩니다.");
            $("#"+field).attr("value", str.substring(0, intMax-1));
            len = maxlimit;
            return false;
        }

        return true;
    },
    /**
     * 정규식(Regular Expression)을 사용한 앞뒤 트림임다.
     */
    trim: function(str) {
    	 regExp = /([^\s*$]?)(\s*$)/;
    	 newStr = str.replace(regExp, "$1");
    	 regExp = /(^\s*)(.+)/;
    	 newStr = newStr.replace(regExp, "$2");

    	 return newStr;
     },
     /**
      * 파일 확장자 체크.
      * @param {checkExt} 허용하는 확장자 (eg. jpg|gif|bmp|...)
      */
     checkExt: function(str, checkExt) {

    	 if(str == "") return true;

    	 var dotIndex = str.lastIndexOf(".");
    	 var ext = str.substring(dotIndex+1).toLowerCase();
    	 var pattern = eval("/^(" + checkExt.toLowerCase() + "){1}$/");

    	 return (ext.search(pattern) != -1);
     },
     /**
     * 로그인 체크
     * @param {redirct url}
     */
     login : function(webserver, from_url) {

    	 location.href = webserver+"/kr/site/login/loginForm.do?from_url="+escape(from_url);
     },
     /**
     * 로그인 체크(메세지 포함, 세션키존재시:true)
     * @param {redirct url, sessionKey}
     */
     checkLogin : function(webserver, from_url, sessionKey) {

    	 var bRtn = false;

    	 if(sessionKey == "") {

    		 if(confirm("로그인 후 사용이 가능합니다.\n\n로그인 하시겠습니까?"))
    			 location.href = webserver+"/kr/site/login/loginForm.do?from_url="+escape(from_url);
    	 }
    	 else
    		 bRtn = true;

    	 return bRtn;
     }
};

var POPUP = {
    open: function(url, popname, options) {
		var width = options.width;
		var height = options.height;
		var top = (screen.height - height) / 2 - 50;
		var left = (screen.width - width) / 2;
		var scroll = options.scroll;
		var resize = options.resize;
		var properties = 'width=' + width + ',height=' + height + ',top=' + top + ',left=' + left;
		properties += scroll && scroll === true ? ",scrollbars=yes" : "";
		properties += resize && resize === true ? ",resizable=yes" : "";
		var pop = window.open(url, popname, properties);
		pop.focus();
	},
	reload: function() {
		location.reload();
	},
	reloadAndClose: function() {
		opener.location.reload();
		self.close();
	},
	close: function() {
		self.close();
	}
};

var POPUP_CHECK = {
	    open: function(url, popname, options) {
			var width = options.width;
			var height = options.height;
			var top = (screen.height - height) / 2 - 50;
			var left = (screen.width - width) / 2;
			var scroll = options.scroll;
			var resize = options.resize;
			var properties = 'width=' + width + ',height=' + height + ',top=' + top + ',left=' + left;
			properties += scroll && scroll === true ? ",scrollbars=yes" : "";
			properties += resize && resize === true ? ",resizable=yes" : "";
			var pop = window.open(url, popname, properties);
			if (pop == null) { alert('차단된 팝업창을 허용해 주십시오.'); } else { pop.focus(); }
		},
		reload: function() {
			location.reload();
		},
		reloadAndClose: function() {
			opener.location.reload();
			self.close();
		},
		close: function() {
			self.close();
		}
	};

var Check = {
    /**
     * 영문만 사용가능
     */
    english: function(str) {
    	var valid_reg = /[A-Za-z]/;
    	if ( valid_reg.test( str ) )
    	{
    		return true;
    	}

    	return false;
    },
    /**
     * 한글만 사용가능
     */
    korea: function(msg) {
    	re = /^[ㄱ-힣]*$/;

        if(re.test(msg)){
        	return true;
        }else{
        	return false;
        }
    },
    /**
     * 전화번호 유효성 체크
     */
    phone: function(num) {
    	var tels = num.split('-');
    	if(tels.length == 2){
    		num = '02-' + num;
    		tels = num.split('-');
    	}

    	var valid_reg = /^[0-9]{1,}\-[0-9]{1,}\-[0-9]{1,}$/;
    	if ( !valid_reg.test( num ) )
    	{
    		return false;
    	}

    	if(tels[1].length > 4 || tels[2].length != 4)
    		return false;

    	return true;
    },
    /**
     * E-mail 체크
     */
    email: function(strMail) {
        var check1 = /(@.*@)|(\.\.)|(@\.)|(\.@)|(^\.)/;

        var check2 = /^[a-zA-Z0-9\+\-\.\_]+\@[a-zA-Z0-9\-\.\_]+\.([a-zA-Z]{2,4})$/;

        if ( !check1.test(strMail) && check2.test(strMail) ) {
            return true;
        } else {
            return false;
        }
    },
    /**
     * 숫자 체크
     */
    number: function(msg) {
    	re = /[0-9]/;

        if(re.test(msg)){
        	return true;
        }else{
        	return false;
        }
    },
    /**
     * 영문소문자숫자 체크
     */
    engandnumber: function(msg) {
    	re = /^[a-z0-9]*$/;

        if(re.test(msg)){
        	return true;
        }else{
        	return false;
        }
    },
    /**
     * 영문대소문자숫자 체크
     */
    engandnumber2: function(msg) {
    	re = /^[a-zA-Z0-9]*$/;

        if(re.test(msg)){
        	return true;
        }else{
        	return false;
        }
    },
    /**
     * 영문대소문자숫자_-. 체크
     */
    engandnumber3: function(msg) {
    	re = /^[a-zA-Z0-9$_$.$-]*$/;

        if(re.test(msg)){
        	return true;
        }else{
        	return false;
        }
    },
    /**
    * 영문대소문자숫자_-./ 체크
    */
   engandnumber4: function(msg) {
   	re = /^[a-zA-Z0-9$_$.$\/$-]*$/;

       if(re.test(msg)){
       	return true;
       }else{
       	return false;
       }
   },
   /**
    * 영문대소문자숫자_-./+ 체크
    */
   engandnumber5: function(msg) {
   	re = /^[a-zA-Z0-9$+$_$.$-]*$/;

       if(re.test(msg)){
       	return true;
       }else{
       	return false;
       }
   },
   /**
    * 영문소문자숫자+특수문자 체크
    */
   engandnumber6: function(msg) {

    	re = /^[a-z0-9$_$.$\/$!$@$%$^$&$*$+$?$#$~$-]*$/;

       if(re.test(msg)){
       	return true;
       }else{
       	return false;
       }
   },
    /**
     * 주민번호 체크
     */
    jumin: function(val1, val2){
		var tmp1,tmp2;
		var t1, t2, t3, t4, t5, t6;
		var t11, t12, t13, t14, t15, t16, t17;
		tmp1 = val1.substring(2,4);
		tmp2 = val1.substring(4);
		//alert(tmp1 + " - " + tmp2);
		if ((tmp1 < "01") || (tmp1 > "12")) return false;
		if ((tmp2 < "01") || (tmp2 > "31")) return false;
		t1 = val1.substring(0,1);
		t2 = val1.substring(1,2);
		t3 = val1.substring(2,3);
		t4 = val1.substring(3,4);
		t5 = val1.substring(4,5);
		t6 = val1.substring(5,6);
		t11 = val2.substring(0,1);
		t12 = val2.substring(1,2);
		t13 = val2.substring(2,3);
		t14 = val2.substring(3,4);
		t15 = val2.substring(4,5);
		t16 = val2.substring(5,6);
		t17 = val2.substring(6,7);

		var tot = t1*2 + t2*3 + t3*4 + t4*5 + t5*6 + t6*7;
		tot += t11*8 + t12*9 + t13*2 + t14*3 + t15*4 + t16*5 ;

		var result = tot % 11;
		result = (11 - result) % 10;
		if (result != t17) return false;
		return true;
	},
    /**
    * 10자리의 사업자등록번호에 대해 유효성 체크 결과(true/false)를 돌려주는 함수.(999-99-99999)
    */
    business_id: function(businessId){
		if (businessId.length != 12) {
		    return false;
		}
		  var strCk1 = businessId.substring(0, 3);
		  var strCk2 = businessId.substring(4, 6);
		  var strCk3 = businessId.substring(7, 12);
		  arrCkValue = new Array(10);

		if((strCk1.length==3) && (strCk2.length==2) && (strCk3.length==5)) {
		    arrCkValue[0] = ( parseFloat(strCk1.substring(0 ,1))  * 1 ) % 10;
		    arrCkValue[1] = ( parseFloat(strCk1.substring(1 ,2))  * 3 ) % 10;
		    arrCkValue[2] = ( parseFloat(strCk1.substring(2 ,3))  * 7 ) % 10;
		    arrCkValue[3] = ( parseFloat(strCk2.substring(0 ,1))  * 1 ) % 10;
		    arrCkValue[4] = ( parseFloat(strCk2.substring(1 ,2))  * 3 ) % 10;
		    arrCkValue[5] = ( parseFloat(strCk3.substring(0 ,1))  * 7 ) % 10;
		    arrCkValue[6] = ( parseFloat(strCk3.substring(1 ,2))  * 1 ) % 10;
		    arrCkValue[7] = ( parseFloat(strCk3.substring(2 ,3))  * 3 ) % 10;
		    intCkTemp     = parseFloat(strCk3.substring(3 ,4))  * 5  + "0";
			arrCkValue[8] = parseFloat(intCkTemp.substring(0,1)) + parseFloat(intCkTemp.substring(1,2));
			arrCkValue[9] = parseFloat(strCk3.substring(4,5));
			intCkLastid = ( 10 - ( ( arrCkValue[0]+arrCkValue[1]+arrCkValue[2]+arrCkValue[3]+arrCkValue[4]+arrCkValue[5]+arrCkValue[6]+arrCkValue[7]+arrCkValue[8] ) % 10 ) ) % 10;
	    if (arrCkValue[9] != intCkLastid) {
		  //alert ("잘못된 사업자등록번호입니다.\n사업자등록번호를 다시 입력하세요.");
		  //thisObj.select();
	      return false;
	    } else {
	      return true;
	    }
		} else {
		  //  alert("22사업자등록번호의 자릿수가 잘못 입력되었습니다.");
		  //thisObj.select();
		    return false;
		}
	}
};

/**
* CheckBox 컨트롤 및 밸리데이션
*/
var CheckBox = {

	/**
	* CheckBox 전체선택/전체해제 컨트롤
	* @param {chkBoxId}	전체선택용 체크박스 Id
	* @param {chkListId}다중체크박스 Id
	* @param {btnSpnId}	전체선택용 버튼 Span Id
	*/
	allCheck: function(chkBoxId, chkListId, btnSpnId) {

		if($("#"+chkBoxId).is(':checked')) {
			$("input:checkbox[id="+chkListId+"]").each(function() {
				$(this).prop("checked",true);
			});
			if(btnSpnId != "")
				$("#"+btnSpnId).find("a").html("전체해제");
		}
		else {
			$("input:checkbox[id="+chkListId+"]").each(function() {
				$(this).prop("checked",false);
			});
			if(btnSpnId != "")
				$("#"+btnSpnId).find("a").html("전체선택");
		}
	},
	/**
	* CheckBox 선택여부 판별(다중체크박스포함)
	* @param {chkBoxId} 체크박스 Id
	*/
	valChecked: function(chkBoxId) {

		if($("input:checkbox[id="+chkBoxId+"]:checked").length < 1)
			return false;
		else
			return true;
	},
	/**
	* CheckBox Multi Append
	* @param {divId} 	: 체크박스 그룹의 부모 div테그 Id
	* @param {chkBoxId} : 체크박스 Id
	* @param {labelName}: 체크박스 라벨명
	* @param {value}	: 체크박스 Value
	* @param {chkDiv} 	: 체크여부 (0:미체크/1:체크)
	*/
	append: function(divId, chkBoxId, labelName, value, chkDiv) {

		var htmlCheckBox= "";
		var strChecked	= "";

		if(chkDiv == 1)
			strChecked = "checked";

		htmlCheckBox += " <input type='checkbox' name='"+chkBoxId+"' id='"+chkBoxId+"' value='"+value+"' "+strChecked+" style='padding-bottom:5px;'/> "+labelName+"<br/>";

		return htmlCheckBox;

		/*
	    $("#"+divId).append(
        $(document.createElement("input")).attr({
                id		: chkBoxId
                ,name	: chkBoxId
                ,type	: "checkbox"
                ,value	: value
				,style	: "padding-bottom:5px;"
				,checked: chkDiv
        })).append(
             $(document.createElement('label')).attr({
            	 id		: "label"
        	}).text(" "+labelName)
		).append("<br/>");
	    */
	}
};

/**
* Dynamic Input 컨트롤
*/
var Input = {

	/**
	* Input Dynamic Append
	* @param {divId} 	: Append시킬 부모 노드의 Id
	* @param {inpType}	: Input Type (text, hidden..)
	* @param {inpId}	: Input Id
	* @param {inpName}	: Input Name
	* @param {inpValue}	: Input Value
	*/
	append: function(divId, inpType, inpId, inpName, inpValue) {

	    $("#"+divId).append(
        $(document.createElement("input")).attr({
                 id		: inpId
                ,name	: inpName
                ,type	: inpType
                ,value	: inpValue
        }));
	}
};

/**
* Dynamic SelectBox 컨트롤
*/
var selWidth=0;
var Select = {

	add : function(selId, keyValue, textValue) {

		var addOpt = document.createElement('option');
		var attWidth = (keyValue == "")? 50 : 30;
		var tmpWidth = (textValue.length * 11) + attWidth;

		if(selWidth < tmpWidth)
			selWidth = tmpWidth;

		addOpt.value = keyValue;
		addOpt.appendChild(document.createTextNode(textValue));

		$("#"+selId).css("width",selWidth);
		$("#"+selId).append(addOpt);
	},
	removeAll : function(selId) {
		$("#"+selId).find('option').each(function() {
			$(this).remove();
		});
	},
	removeUnit : function(selId) {
		$("#"+selId+" option:selected").remove();
	},
	length : function(selId) {
		var i = 0;
		$("#"+selId).find('option').each(function() {
			++i;
		});
		return i;
	}
};

/**
* 문자열 교체
* ex) str.replaceAll("a", "b") : "a"->"b"로 모두 교체
*/
String.prototype.replaceAll = replaceAll;
function replaceAll(strValue1, strValue2)
{
	var strTemp = ""+this;
	strTemp = strTemp.replace(new RegExp(strValue1, "g"), strValue2);
	return strTemp;
}

$.fn.ajaxSubmit = function(options) {
	var self = $(this);
	$(this).attr("showerrors", "true");
	if (self.valid()) {
		var params = {};
		self.find("input[checked], input[type=text], input[type=hidden], input[type=password], option[selected], textarea") .each(function() {var k = this.name || this.id || this.parentNode.name || this.parentNode.id;if (params[k]) {if ($.isArray(params[k])) {params[k].push(this.value);} else {params[k] = [params[k], this.value];}} else {params[k] = this.value;}});
		$.post(self.attr("action") + "?callType=ajax", params, function(json) {
			if (options && $.isFunction(options.success)) {
				options.success.call(null, json);
			}
		}, "json");
	}
	return this;
};

/**
* ajax - json 처리
* @param {String} 요청 url
* @param {String} callbackFunc
*/
$.fn.ajaxSubmitJSON = function(url, callbackFunc) {
	var self = $(this);
	$(this).attr("showerrors", "true");
	if (self.valid()) {
		var params = {};
		self.find("input[checked], input[type=text], input[type=hidden], input[type=password], option[selected], textarea") .each(function() {var k = this.name || this.id || this.parentNode.name || this.parentNode.id;if (params[k]) {if ($.isArray(params[k])) {params[k].push(this.value);} else {params[k] = [params[k], this.value];}} else {params[k] = this.value;}});
       $.getJSON(url + "?callType=ajax", params,
           function(data) {   // callback 후 수행할 부분
    	   	  //if(data['return']['code'] == '0'){
                   eval(callbackFunc(data));
               //}else{
                   //에러처리
               //}
           });

	}
	return this;
};

if ($.datepicker) {
	$.datepicker.setDefaults({
		dateFormat: "yy.mm.dd",
		monthNames: ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"],
		monthNamesShort: ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"],
		dayNamesMin: ["일", "월", "화", "수", "목", "금", "토"],
		dayNamesShort: ["일", "월", "화", "수", "목", "금", "토"],
		showOn: 'button', buttonImage: "/kr/common/img/calendar/ic_calendar.gif", buttonImageOnly: true
	});

	$(function() {
		var options = null;
		try {
			options = datepickerOptions.call(null);
		} catch (e) {
		}
		if (options != null) {
			$("input.ui-calendar").datepicker(options);
		} else {
			$("input.ui-calendar").datepicker();
		}
	});
}

/**
* ajax - html 처리
*/
$.fn.ajaxSubmitHtml = function(options) {
	var self = $(this);
	$(this).attr("showerrors", "true");
	if (self.valid()) {
		var params = {};
		self.find("input[checked], input[type=text], input[type=hidden], input[type=password], option[selected], textarea") .each(function() {var k = this.name || this.id || this.parentNode.name || this.parentNode.id;if (params[k]) {if ($.isArray(params[k])) {params[k].push(this.value);} else {params[k] = [params[k], this.value];}} else {params[k] = this.value;}});
		$.post(self.attr("action") + "?callType=ajax", params, function(html) {
			if (options && $.isFunction(options.success)) {
				options.success.call(null, html);
			}
		}, "html");
	}
	return this;
};

if ($.validator) {
	$.validator.addMethod("gt", function(value, element, params) {return isNaN(params) ? (value > params) : (parseInt(value) > params);}, "gt error");
	$.validator.addMethod("lt", function(value, element, params) {return isNaN(params) ? (value < params) : (parseInt(value) < params);}, "lt error");
	$.validator.addMethod("eq", function(value, element, params) {return value > params;}, "eq error");
	$.validator.addMethod("not", function(value, element, params) {return value != params;}, "not error");
	$.validator.addMethod("downToPoint", function(value, element, params) {return ((Math.pow(10,params)*value).toString()).indexOf(".")<0;}, "downToPoint error");
	$.validator.addMethod("greatThan", function(value, element, params) {var type = params && params.type ? params.type : null; var equal = params && params.equal === true ? true : false;var current = $(element).val(); var target = params && params.target ? $(params.target).val() || params.target : "";if (type == "calendar" && current) {current = parseInt(current.replace(/[-. :]/g, ''));target = parseInt(target.replace(/[-. :]/g, ''));if (current > target) return true;else if (current == target)	 return equal;else return false;}return true;});
	$.validator.addMethod("lessThan", function(value, element, params) {var type = params && params.type ? params.type : null;var equal = params && params.equal === true ? true : false;var current = $(element).val();var target = params && params.target ? $(params.target).val() || params.target : "";if (type == "calendar" && current) {current = parseInt(current.replace(/[-. :]/g, ''));target = parseInt(target.replace(/[-. :]/g, ''));if (current < target) return true;else if (current == target)	 return equal;else return false;}return true;});
}

function popAsecWarning(){
	POPUP.open('/kr/site/securitycenter/asec/popAsecWarning.do', 'popAsecWarning', {width: 600, height: 680});
}

function popAsecWarning_main(){
	POPUP.open('/kr/site/securitycenter/asec/popAsecWarning.do?svccode=aa1001&contentscode=293', 'popAsecWarning', {width: 650, height: 610});
}

function checkEmailHangle(){
	if(Check.engandnumber5($("#email1").val()) == false){
		$("#email1").attr("value", "");
		$("#email1").focus();
	}
}

function checkHangle(obj){
	if(Check.engandnumber2($("#" + obj).val()) == false){
		$("#" + obj).attr("value", "");
		$("#" + obj).focus();
	}
}

/**
* 기존에 가입한 사람의 id에 ._- 같은 특수문자 존재
*/
function checkHangle2(obj){
	if(Check.engandnumber3($("#" + obj).val()) == false){
		$("#" + obj).attr("value", "");
		$("#" + obj).focus();
	}
}

/**
* popup open
*/

/* scrollbars=no */
function popWin(url, target, intwidth, intheight) {
	window.open(url, target , "width="+intwidth+",height="+intheight+",resizable=0,scrollbars=0");
}

/* scrollbars=yes */
function popWinS(url, target, intwidth, intheight) {
	window.open(url, target , "width="+intwidth+",height="+intheight+",resizable=0,scrollbars=1");
}

/* window_close */
function popClose() {
	window.close();
}

/**
 * SNS 팝업 호출 공통 함수
 *
 * @param snsDiv tw : 트위터, fb : 페이스북, me : 미투데이, yz : 요즘, ln : LinkedIn
 * @param popId 팝업창 ID
 * @param titleParam 제목 (필요한 경우 escape, encodeURIComponent 등 선처리를 할 것!!)
 * @param longUrl 화면 URL (필요한 경우 escape, encodeURIComponent 등 선처리를 할 것!!)
 * @param eventTag TAG 문구 (필요한 경우 escape, encodeURIComponent 등 선처리를 할 것!!)
 */
function popSnsShare(snsDiv, popId, titleParam, longUrl, eventTag) {
	if (snsDiv == "tw" && longUrl != null && longUrl != "") {
		$.ajax({
			type : "GET",
			url : "http://durl.me/api/Create.do?type=json&longurl=" + longUrl + "&callback=?",
			dataType : "json",
			timeout : 6000,
			success : function(data, status) {
				if (data.status == "ok") {
					callBackSnsShare(snsDiv, popId, titleParam, data.shortUrl, eventTag);
				} else {
					callBackSnsShare(snsDiv, popId, titleParam, longUrl, eventTag);
				}
			},
			error : function(request, status, error) {
				callBackSnsShare(snsDiv, popId, titleParam, longUrl, eventTag);
			}
		});
	} else {
		callBackSnsShare(snsDiv, popId, titleParam, longUrl, eventTag);
	}
}

/**
 *
 * SNS 팝업 호출 공통 함수의 ajax 호출 부 통과 후 처리
 *
 */
function callBackSnsShare(snsDiv, popId, titleParam, linkUrl, eventTag) {
	var snsUrl = "";
	var options = null;

	if (snsDiv == "tw") {
		snsUrl = "http://twitter.com/home/?status=" + titleParam + " " + linkUrl + " " + eventTag;
		options = {width:800, height:600, scroll:true};
	} else if (snsDiv == "fb") {
		snsUrl = "http://www.facebook.com/sharer/sharer.php?u=" + linkUrl + "&t=" + titleParam;
		options = {width:800, height:600, scroll:true};
	} else if (snsDiv == "me") {
		snsUrl = "http://me2day.net/plugins/post/new?new_post[body]=\"" + titleParam + "\:" + linkUrl + "&new_post[tags]=" + eventTag;
		options = {width:800, height:600, scroll:true};
	} else if (snsDiv == "yz") {
		snsUrl = "http://yozm.daum.net/api/popup/prePost?prefix=" + titleParam + "&link=" + linkUrl;
		options = {width:800, height:600, scroll:true};
	} else if (snsDiv == "ln") {
		snsUrl = "http://www.linkedin.com/shareArticle?mini=true&url=" + linkUrl + "&title=" + titleParam + "&source=" + encodeURIComponent("AhnLab");
		options = {width:520, height:570, scroll:true};
	}

	POPUP.open(snsUrl, popId, options);
}


function chkPasswd2(){
    var chkArray = new Array();
    chkArray[0] = $("#custId").val();
    chkArray[1] = $("#telNo1").val() == undefined ? "0000" : $("#telNo1").val();
    chkArray[2] = $("#telNo2").val() == undefined ? "0000" : $("#telNo2").val();
    chkArray[3] = $("#telNo3").val() == undefined ? "0000" : $("#telNo3").val();
    chkArray[4] = $("#telNoCell1").val() == undefined ? "0000" : $("#telNoCell1").val();
    chkArray[5] = $("#telNoCell2").val() == undefined ? "0000" : $("#telNoCell2").val();
    chkArray[6] = $("#telNoCell3").val() == undefined ? "0000" : $("#telNoCell3").val();
    chkArray[7] = "0000";
    chkArray[8] = "1111";
    chkArray[9] = "2222";
    chkArray[10] = "3333";
    chkArray[11] = "4444";
    chkArray[12] = "5555";
    chkArray[13] = "6666";
    chkArray[14] = "7777";
    chkArray[15] = "8888";
    chkArray[16] = "9999";
    chkArray[17] = "00000";
    chkArray[18] = "11111";
    chkArray[19] = "22222";
    chkArray[20] = "33333";
    chkArray[21] = "44444";
    chkArray[22] = "55555";
    chkArray[23] = "66666";
    chkArray[24] = "77777";
    chkArray[25] = "88888";
    chkArray[26] = "99999";
    chkArray[27] = "1234";
    chkArray[28] = "12345";
    chkArray[29] = "123456";

    for(i = 0;i<chkArray.length;i++){
        if($("#password").val() == chkArray[i]) return false;
    }

    return true;
}

function chkPasswdContinue(String){
    var cnt = 0;
    for( var i=0; i < String.length; ++i)
    {
        if( String.charAt(0) == String.substring( i, i+1 ) ) ++cnt;
    }
    if( cnt != String.length ) {
        return true;
    }else{
        return false;
    }
}

function chkPasswdDanger(String){
    if(String.length < 8){
        return false;
    }else if(IsAlphabet(String)){
        return false;
    }else if(IsNumber(String)){
        return false;
    }else{
        return true;
    }
}

function checkMix2(String) {
    var valid = true;
    var chkArray = new Array("--",";","'");
    var resultArray = new Array(chkArray.length);
    var result;
    var count = 0;

    if (IsEmpty(String)) return false;

    for(var i=0;i<chkArray.length; i++){
        result = String.search(chkArray[i]);
        if(i == 0 && result != -1) {
            resultArray[i] = "보안상의 이유로 입력하신 -(하이픈)은 연속하여 사용하실 수 없습니다.";
            count++;
        }else if(i == 1 && result != -1){
            resultArray[i] = "보안상의 이유로 입력하신 ;(세미콜론)은 사용하실 수 없습니다.";
            count++;
        }else if(i == 2 && result != -1){
            resultArray[i] = "보안상의 이유로 입력하신 '(작은따옴표)은 사용하실 수 없습니다.";
            count++;
        }
    }

    if(count > 0) return resultArray;

    return 0;
}


function IsAlphabet(String) {

    if (IsEmpty(String))
       return false;

    for (var i=0; i < String.length; i++) {
       if ( ( (String.charAt(i) < "A") || (String.charAt(i) > "Z") ) &&
            ( (String.charAt(i) < "a") || (String.charAt(i) > "z") ) )
          return false;
    }

    return true;
 }

 function IsNumber(String) {

    if (IsEmpty(String))
       return false;

    for (var i=0; i < String.length; i++) {
       if ( (String.charAt(i) < "0") || (String.charAt(i) > "9") )
          return false;
    }

    return true;
 }

 function checkMix(String) {

     var valid1 = true;
     var valid2 = true;
     var valid3 = true;
     var as="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
     var bs="0123456789";
     var cs="~!@$%^&*/?#+_-";
     var count=0;

        if (IsEmpty(String))
           return false;

        for (var i=0; i < String.length; i++) {
            if(as.indexOf(String.charAt(i)) > -1 ){
                 valid1 = false;
             }
             if(bs.indexOf(String.charAt(i)) > -1){
                 valid2 = false;
             }
             if(cs.indexOf(String.charAt(i)) > -1){
                 valid3 = false;
             }
        }

       if(valid1) count++;
       if(valid2) count++;
       if(valid3) count++;

       if(count > 0){
           return false;
       }

       return true;

 }

 function IsEmpty(String) {

	   return !CheckValid(String, false);
	}

 function CheckValid(String, SpaceCheck) {

	   var retvalue = false;

	   for (var i=0; i<String.length; i++) {

	      if (SpaceCheck == true) {
	         if (String.charAt(i) == ' ') {
	            retvalue = true;
	            break;
	         }
	      } else {
	         if (String.charAt(i) != ' ') {
	            retvalue = true;
	            break;
	         }
	      }
	   }

	   return retvalue;
	}



	function chkPasswdBest(String){
		if(String.length > 8 && String.length < 17){
			return false;
		}else if(IsAlphaNumeric(String)){
			return false;
		}else{
			return true;
		}
	}


	function IsAlphaNumeric(String) {

		   if (IsEmpty(String))
		      return false;

		   for (var i=0; i < String.length; i++) {
		      if ( ( (String.charAt(i) < "0") || (String.charAt(i) > "9") ) &&
		           ( ( (String.charAt(i) < "A") || (String.charAt(i) > "Z") ) &&
		             ( (String.charAt(i) < "a") || (String.charAt(i) > "z") ) ) )
		         return false;
		   }

		   return true;
		}

	/**
	 * 스크랩하기
	 *
	 * @param scrapId : 스크랩할 영역의 ID
	 * @returns {Boolean}
	 */
	function copyScrap(scrapId) {
		var returnVal = true;

		if (window.clipboardData) {
			window.clipboardData.setData("text", $("#" + scrapId).html());
			window.clipboardData.setData("text", window.clipboardData.getData("text"));
		} else if (window.netscape) {
			try {
				netscape.security.PrivilegeManager.enablePrivilege('UniversalXPConnect');
				var clip = Components.classes['@mozilla.org/widget/clipboard;1'].createInstance(Components.interfaces.nsIClipboard);

				if (!clip) {
					returnVal = false;
					return returnVal;
				}

				var trans = Components.classes['@mozilla.org/widget/transferable;1'].createInstance(Components.interfaces.nsITransferable);

				if (!trans) {
					returnVal = false;
					return returnVal;
				}

				trans.addDataFlavor('text/unicode');
				var str = Components.classes["@mozilla.org/supports-string;1"].createInstance(Components.interfaces.nsISupportsString);
				var copytext = $("#" + scrapId).html();// 로컬변수에 복사
				str.data = copytext;
				trans.setTransferData("text/unicode", str, copytext.length * 2);
				var clipid = Components.interfaces.nsIClipboard;

				if (!clipid) {
					returnVal = false;
					return returnVal;
				}

				clip.setData(trans, null, clipid.kGlobalClipboard);
			} catch (e) {
				alert("스크랩하기 기능을 사용하시려면 \n\nURL창에 about:config 를 입력해  접근 후, 고급환경설정기능에서\n\nsigned.applets.codebase_principal_support 값을  true로 설정해 주셔야 됩니다.");
				returnVal = false;
				return returnVal;
			}
		} else {
			alert("지원하지 않는 브라우저입니다.");
			returnVal = false;
			return returnVal;
		}

		return returnVal;
	}

	function isIE() {
		return ((navigator.appName == 'Microsoft Internet Explorer') || ((navigator.appName == 'Netscape') && (new RegExp("Trident/.*rv:([0-9]{1,}[\.0-9]{0,})").exec(navigator.userAgent) != null)));
	}