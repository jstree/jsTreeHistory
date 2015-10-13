<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko" class="no-js">
<!--<![endif]-->
	<head>
		<script type="text/javascript">
           
			function introduce(){
				alert("최유진입니다.");
			}

			function study(order) {
			
			    if(window.console == undefined){
					console = {log: function() {} };
				}
			    console.log("===============================");
			
			    switch (order) {
			        case 'ch1':
			            console.log("1장 자바스크립트의 기본 개념");
			            console.log("===============================");
			            console.log("* 숫자계산");
			            console.log("(1+2)+3 = " + (1 + 2) + 3);
			            console.log("* 프로그램실행");
			            console.log("square(4)	// 16 출력");
			            console.log(square(4));
			            console.log("var square = 0;	// 파싱할때 전의된 square 변수를 런타임에 덮어쓴다.");
			            console.log("function square(x){	// 함수 정의");
			            console.log("   return x*x;");
			            console.log("}");
			            var square = 0;
			
			            function square(x) {
			                return x * x;
			            }
			            console.log("console.log(square);	// 0출력");
			            console.log(square);
			            break;
			        case 'ch2':
			            console.log("2장 자바스크립트의 기본문법");
			            console.log("===============================");
			            console.log("* 숫자");
			            console.log("var v = \"123\"+ 123;");
			            var v = "123" + 123;
			            console.log("typeof v => " + typeof v + " 형태의 값 " + v);
			
			            console.log("\n* infinity");
			            var i = 1 / 0;
			            console.log("var i = 1/0; => " + i);
			            var ii = -Infinity;
			            console.log("var ii = -Infinity; => ii = " + ii + " typeof ii = " + typeof ii);
			            console.log("Infinity * 3	=> " + Infinity * 3);
			            console.log("Infinity - 999999999  => " + Number(Infinity - 999999999));
			
			            console.log("\n* NaN");
			            var aa = NaN;
			            console.log("var aa = NaN;");
			            console.log("typeof aa => " + typeof aa + " 형태의 " + aa);
			            console.log("var a = 10 * \"f\";");
			            var a = 10 * "f";
			            console.log("a => " + a);
			
			            console.log("\n* Number객체");
			            var str1 = new String("9");
			            var str2 = "9";
			            var str3 = "구";
			            console.log("var str1 = new String(\"9\");");
			            console.log("Number(str1); => " + Number(str1));
			            console.log("var str2 = \"9\";");
			            console.log("Number(str2); => " + Number(str2));
			            console.log("var str3 = \"구\";");
			            console.log("Number(str3); => " + Number(str3));
			
			            console.log("\n* 문자열");
			            var date = new Date();
			            console.log("var date = new Date();");
			            console.log("String(date); => " + String(date));
			            console.log("\'이 문자열은 \\n두 줄로 나타난다\'");
			            console.log("이 문자열은 \n두 줄로 나타난다");
			
			            console.log("\n* undefined");
			            console.log("var obj = {};");
			            var obj = {};
			            console.log("console.log(obj.p);");
			            console.log(obj.p);
			
			            console.log("\n* null과  undefined");
			            var a = undefined;
			            var b = null;
			            console.log("var a = undefined;\nvar b = null;");
			            console.log("console.log(a==b);");
			            console.log(a == b);
			            console.log("console.log(a===b);");
			            console.log(a === b);
			
			            console.log("\n* 증가,감소연산자");
			            console.log("function decrease(count){\n	return count--;\n}");
			            console.log("function increase(count){\n	return count++;\n}");
			
			            function decrease(count) {
			                return count--;
			            }
			
			            function increase(count) {
			                return count++;
			            }
			            console.log("console.log(decrease(1));");
			            console.log(decrease(1));
			            console.log("console.log(increase(1));");
			            console.log(increase(1));
			
			            console.log("\n* 비교 연산자");
			            var o1 = new String("hello");
			            var o2 = new Object("hello");
			            console.log("var o1 = new String(\"hello\");\nvar o2 = new Object(\"hello\");");
			            console.log("console.log(o1==o2);");
			            console.log(o1 == o2);
			
			            console.log("\n* 논리 연산자");
			            console.log("console.log((1+2)||{});");
			            console.log((1 + 2) || {});
			            console.log("console.log((1+2)&&{});");
			            console.log((1 + 2) && {});
			
			            console.log("\n* 실행 제어");
			            console.log("var r=2;\nif(r>2){\n\tconsole.log('a는 2보다 크다');\n}else{\n\tconsole.log('a는 2보다 작거나 같다');\n}");
			            var r = 2;
			            if (r > 2) {
			                console.log('a는 2보다 크다');
			            } else {
			                console.log('a는 2보다 작거나 같다');
			            }
			            console.log("r>2 ? console.log('a는 2보다 크다') : console.log('a는 2보다 작거나 같다');");
			            r > 2 ? console.log('a는 2보다 크다') : console.log('a는 2보다 작거나 같다');
			
			            console.log("\n* 반복문");
			            console.log("function f(count){\n\tfor(var i=0;i<count;i++){\n\t}\n\treturn i;\n}\nconsole.log(f(100));");
			
			            function f(count) {
			                for (var i = 0; i < count; i++) {}
			                return i;
			            }
			            console.log(f(100));
			
			            console.log("var myObject = {1 : \'a\', 2 : \'b\'};\nfor(var a in myObject){\n\tconsole.log(\"속성명 :\"+a+\", 값 :\"+myObject[a]);\n}");
			            var myObject = {
			                1: 'a',
			                2: 'b'
			            };
			            for (var a in myObject) {
			                console.log("속성명 :" + a + ", 값 :" + myObject[a]);
			            }
			            console.log("function w(count){\n\tvar i = 0;\n\twhile(i<count){\n\t\ti++;\n\t}\n\treturn i;\n}\nconsole.log(w(100));");
			
			            function w(count) {
			                var i = 0;
			                while (i < count) {
			                    i++;
			                }
			                return i;
			            }
			            console.log(w(100));
			
			            console.log("\n* try/catch");
			            console.log("try{\n\tthrow new Error(\"예외발생하였습니다.\");\n}catch(e){\n\tconsole.log(e.message);\n}finally{\n\tconsole.log(\"finally 입니다.\");\n}");
			            try {
			                throw new Error("예외발생하였습니다.");
			            } catch (e) {
			                console.log(e.message);
			            } finally {
			                console.log("finally 입니다.");
			            }
			            break;
			        case 'ch3':
			            console.log("3장 자바스크립트의 함수");
			            console.log("===============================");
			
			            console.log("\n* 함수 역할1");
			            console.log("function f1(){\n\tconsole.log(\"첫번째 역할을 하는 함수입니다.\");\n}\nf1();");
			
			            function f1() {
			                console.log("첫번째 역할을 하는 함수입니다.");
			            }
			            f1();
			
			            console.log("\n* 함수 역할2");
			            console.log("var f2  = function(x,y){return x+y;};\nconsole.log(f2(2,3););");
			            var f2 = function(x, y) {
			                return x + y;
			            };
			            console.log(f2(2, 3));
			
			            console.log("\n* 함수 역할3");
			            console.log("var f3 = new Function(\"x\", \"y\", \"return x+y;\");\nconsole.log(f3(2,3));");
			            var f3 = new Function("x", "y", "return x+y;");
			            console.log(f3(2, 3));
			            break;
			
			        case 'ex1':
			            console.log("1일차 과제 - 데이터타입 연산 ");
			            console.log("===============================");
			            console.log("* 데이터타입 연산 ");
			            var str = "a";
			            var num = 7;
			            var bo = true;
			            var n = null;
			            var un = undefined;
			
			
			            console.log(
			                typeof(str) + "+" + typeof(str) + "---------> " + (str + str) + "\n" +
			                typeof(str) + "+" + typeof(num) + "---------> " + (str + num) + "\n" +
			                typeof(str) + "+" + typeof(bo) + "---------> " + (str + bo) + "\n" +
			                typeof(str) + "+" + "null" + "---------> " + (str + n) + "\n" +
			                typeof(str) + "+" + typeof(un) + "---------> " + (str + un) + "\n" + "\n" +
			
			                typeof(num) + "+" + typeof(num) + "---------> " + (num + num) + "\n" +
			                typeof(num) + "+" + typeof(bo) + "---------> " + (num + bo) + "\n" +
			                typeof(num) + "+" + "null" + "---------> " + (num + n) + "\n" +
			                typeof(num) + "+" + typeof(un) + "---------> " + (num + un) + "\n" + "\n" +
			
			                typeof(bo) + "+" + typeof(bo) + "---------> " + (bo + bo) + "\n" +
			                typeof(bo) + "+" + "null" + "---------> " + (bo + n) + "\n" +
			                typeof(bo) + "+" + typeof(un) + "---------> " + (bo + un) + "\n" + "\n" +
			
			                "null" + "+" + "null" + "---------> " + (n + n) + "\n" +
			                "null" + "+" + typeof(un) + "---------> " + (n + un) + "\n" + "\n" +
			
			                typeof(un) + "+" + typeof(un) + "---------> " + un + un + "\n" + "\n" +
			
			                typeof([]) + "+" + typeof({}) + "---------> " + ([] + {}) + "\n" +
			                typeof({}) + "+" + typeof([]) + "---------> " + ({} + []) + "\n" +
			                typeof(1) + "+" + typeof({}) + "---------> " + (1 + {}) + "\n" +
			                typeof({}) + "+" + typeof(1) + "---------> " + ({} + 1) + "\n"
			            );
			            break;
			        case 'ex2':
			            console.log("2일차 과제");
			            console.log("===============================");
			            console.log("* jquery로 객체 생성 ");
			            $.extend({
			                createNumber: function(num) {
			                    return new Number(num)
			                }
			            });
			
			            var jqueryNumber = $.createNumber(1);
			
			            console.log(
			                new Number("1") + "/" + new Number(true) + "/" + new Number(undefined) + "/" + new Number(NaN) + "\n" +
			
			                Number("1") + "/" + Number(true) + "/" + Number(undefined) + "/" + Number(NaN) + "\n" +
			
			                parseFloat("1") + "/" + parseFloat(true) + "/" + parseFloat(undefined) + "/" + parseFloat(NaN) + "\n" +
			
			                parseInt("1") + "/" + parseInt(true) + "/" + parseInt(undefined) + "/" + parseInt(NaN) + "\n" +
			
			                "jqueryNumber=" + jqueryNumber 
			            );
			            break;
			        case 'ex3':
			            console.log("3일차 과제");
			            console.log("===============================");
			            console.log("* 동적으로 for/in문 ");
			            console.log("var myObject = {1 : 'a', 2 : 'b'};\n\tconsole.log(\"속성명 :\"+a+\", 값 :\"+myObject[a]);\n} ");
			            var myObject = {
			                1: 'a',
			                2: 'b'
			            };
			            for (var a in myObject) {
			                console.log("속성명 :" + a + ", 값 :" + myObject[a]);
			            }
			            console.log("\n* Error객체 확장 ");
			            console.log("try{\n\tthrow new Error(\"예외발생하였습니다.\");\n}catch(e){\n\tconsole.log(e.message);\n}finally{\n\tconsole.log(\"finally 입니다.\");\n}");
			            try {
			                throw new Error("예외발생하였습니다.");
			            } catch (e) {
			                console.log(e.message);
			            } finally {
			                console.log("finally 입니다.");
			            }
			            break;
			        case 'ex4':
			        	console.log("4일차 과제");
			            console.log("===============================");
			        	console.log("==========변수스코프, 실행코드블록 표시==========");
			        	//함수 객체 생성
			        	function add(){//변수스코프
			        		var a = 1;
			        		var b = 2;
			        		return a + b;//실행코드블록
			        	}
			        	console.log("==========변수, 함수 동적 추가==========");
			        	//변수 동적 추가
			        	add.prop="p";
			        	//추가되었는지 확인
			        	console.log(add.prop);
			        	//이때, prototype 상태
			        	console.log(add.prototype);
			        	
			        	//함수 동적 추가
			        	add.method=function minus(){var a = 1;var b = 2;return a-b;};
			        	//추가되었는지 확인
			        	console.log(add.method);
			        	//이때, prototype 상태
			        	console.log(add.prototype);
			        	
			        	console.log("==========prototype의 내용 찍기==========");
			        	//함수 객체 생성
			        	var man = function(name){
			        		this.name = name;
			        	};
			        	//prototype으로 함수 생성
			        	man.prototype.mouse = function(){console.log("말하다");}
			        	//인스턴스 생성
			        	var choi = new man("최유진");
			        	
			        	console.log("인스턴스가 생성됨, 현재이름은? :"+choi.name);
			        	console.log("프로토타입 출력 :" + man.prototype);
			        	
			        	console.log("==========프로토타입 객체로 변수스코프 접근하여 바꿔보기==========");
			        	console.log("prototype으로 함수 생성(변수스코프 변경 함수, prototype써줌)-->변경됨");
			        	man.prototype.nameChange = function(name){this.name = name};
			        	choi.nameChange("이름 바꾸기 성공");
			        	console.log("현재이름은? :"+choi.name);
			        	console.log(choi.mouse());
			        	console.log(man.prototype);
			        	
			        	console.log("prototype으로 함수 생성(변수스코프 변경 함수, prototype안써줌)-->에러가 나게됨");
			        	man.nameUpdate= function(name){this.name = name};
			        	choi.nameUpdate("이름 업데이트 성공");
			        	console.log("현재이름은? :"+choi.name);
			        	console.log(choi.mouse());
			        	console.log("프로토타입 출력 :" + man.prototype);
			        	break;
			        case 'ex5' :
			        	//팀장 객체 생성
			         	function yujin(){
			        		
			        		var yujin = {
			        				age : 27,
			        				setAge : function(age){
			        					this.age = age;
			        				},
			        				getAge : function(){
			        					return this.age;
			        				},
			        				doSpeak : function(){
			        					doSpeakCall();
			        				}
			        				
			        		};
			        		
			        		function doSpeakCall(){
	        					arguments.callee.doSpeakFunction();
	        				}
			        		doSpeakCall.doSpeakFunction = function(){
			        			console.log("말하기");
			        		}
			        		
			        		return yujin;
			        		
			        	}
			        	//객체 인스턴스 화
			        	var yujin_1 = new yujin();
			        	//값을 가지고옴 - 과제 1-1
			        	console.log(yujin_1.getAge());
			        	//값을 변경 - 과제 1-2
			        	yujin_1.setAge(100);
			        	//변경 값 확인 - 과제 1-2
			        	console.log(yujin_1.getAge());
			        	//공개 영역 변수 추가 - 과제 1-3
			        	yujin_1.name = "최유진";
			        	//공개 영역 변수 값 확인 - 과제 1-4
			        	console.log(yujin_1.name);
			        	
			        	//doSpeak을 callee로 출력하기
			        	yujin_1.doSpeak();
			        
			        	break;
			    }
			
			}
		</script>
		<style type="text/css">
			@import url(http://fonts.googleapis.com/earlyaccess/nanumgothiccoding.css);
			.container .overview {font-family:'Nanum Gothic Coding' !important; letter-spacing: -0.03em}
			.container .over_tit h4 {font-family:'Nanum Gothic Coding' !important; display:block; padding:8% 0 2% 15%; font-weight:bold; letter-spacing: -0.03em; line-height:1.2em}
			.container .overview_space {padding-left:25%; display:block;}
			.container .overview_space .add {position:relative; width:100%; padding-bottom:6%; display:block !important}
			.container .overview_space p.cap {position:absolute; right:75%; top:2%; font-size:0.9em}
			.container .over_link {font-family:'Nanum Gothic Coding' !important; padding:3% 0 0 25%}
			.container .over_link a.one {padding:30px 20px 2px 20px; font-size:0.9em; background:url(http://www.313.co.kr:5002/Component/jsp/community/jsTreeAlg/jsTreeApply/img/ico2.gif) 0 27px no-repeat; background-size:15px}
			.container .over_link a.two {padding:30px 20px 2px 20px; font-size:0.9em; background:url(http://www.313.co.kr:5002/Component/jsp/community/jsTreeAlg/jsTreeApply/img/ico3.gif) 0 27px no-repeat; background-size:15px}

			@media only screen and (max-width: 480px) {
				
				.container .overview_space {
					float:none;
					padding:0;
				}
				.container .overview_space .add {
					float:none;
					padding:0;
					width:100%;
				}
				.container .overview_space .over_tit {
					float:none;
					padding-top:5%;
					
				}
				.container .overview_space p.cap {
					position:static;
					display:block
				}
				.container .over_link {
					padding:8% 0 0 0
				}
				.container .over_tit h4 {
					padding-left:0
				}
			}
			
			/* lnb 추가 */
			#responsive-admin-menu {
				float: left;
				width: 200px;
				background-color: #404040;
				height: 100%;
				position: relative;
				overflow: hidden;
				left: 0px;
				min-height: 500px;
			
			}
			
			#content-wrapper {
				width: auto;
				margin-left: 200px;
				background-color: #ffffff;
				height: 1200px;
				padding: 15px;
			}
			
			#responsive-admin-menu #responsive-menu {
				height: 50px;
				display: none;
				line-height: 50px;
				cursor: pointer;
				color: #ffffff;
				text-indent: 10px;
			}
			
			
			#responsive-admin-menu #responsive-menu .menuicon {
				color: #ffffff;
				font-size: 24px;
				position: absolute;
				right: 10px;
				top: 0px;
			}
			#responsive-admin-menu #logo {
				background: url('../images/logo.png');
				background-position: -0px -36px;
				width: 174px;
				height: 40px;
				margin: 10px;
			}
			
			/* Menu Styles */
			#responsive-admin-menu #menu {
				width: 100%;
			}
			#responsive-admin-menu #menu a {
				border-bottom: 1px dotted #52535a;
				font-size: 14px;
				text-decoration: none;
				display: block;
				padding: 12px;
				color: #FFFFFF;
				position: relative;
				font-weight: 400;
				overflow: hidden;
			}
			#responsive-admin-menu #menu a:hover {
				color: #52535a;
				background-color:#fcfcfc;
			}
			#responsive-admin-menu #menu i {
				width: 16px;
				padding-right: 4px;
			}
			#responsive-admin-menu #menu div {
				display: none;
				width: 100%;
				background-color: #5c5d64;
				overflow: hidden;
			}
			#responsive-admin-menu #menu div a {
				color: #c0c0c0;
			}
			#responsive-admin-menu #menu div a:hover {
				color: #888888;
			}
			#responsive-admin-menu #menu a.submenu:before {
				font-family: FontAwesome;
				content: "\f054";
			}
			#responsive-admin-menu #menu a.downarrow:before {
				font-family: FontAwesome;
				content: "\f078";
			}
			#responsive-admin-menu #menu a.submenu:before {
				font-size: 14px;
				position: absolute;
				right: 15px;
				top: 17px;
			}
			/* Menu Styles */
			
			@media screen and (max-width: 960px) {
				#responsive-admin-menu #responsive-menu {
					display: none;
				}
				#responsive-admin-menu #menu a span {
					display: inline-block;
				}
			}
			@media screen and (max-width: 850px) {
				#responsive-admin-menu #menu a span {
					display: none;
				}
				#responsive-admin-menu {
					float: left;
					width: 40px;
					position: relative;
				}
				#responsive-admin-menu {
					height: 100%;
				}
				#content-wrapper {
					margin-left: 40px;
				}
				#responsive-admin-menu #menu a.submenu:before {
					font-size: 6px;
					right: 5px;
				}
				#responsive-admin-menu #logo {
					background: url('../images/logo.png');
					background-position: -0px -0px;
					width: 29px;
					height: 26px;
					margin: 10px 10px 10px 5px;
				}
			}
			@media screen and (max-width: 480px) {
				#responsive-admin-menu {
					min-height: 50px;
					float: left;
					width: 100%;
					background-color: #404040;
					height: auto;
					position: static;
					top: 0;
				}
				#responsive-admin-menu #logo {
					display: none;
				}
				#responsive-admin-menu #menu a span {
					display: inline-block;
				}
				#content-wrapper {
					margin-left: 0;
					padding-top: 60px;
				}
				#responsive-admin-menu #responsive-menu {
					display: block;
				}
				#responsive-admin-menu #menu {
					display: none;
				}
				#responsive-admin-menu #menu a {
					color: #FFFFFF;
				}
				#responsive-admin-menu #menu a.submenu:before {
					font-size: 14px;
					right: 15px;
				}
			}
			
			@font-face{
			  font-family:'FontAwesome';
			  src:url('font/fontawesome-webfont.eot?v=3.0.1');
			  src:url('font/fontawesome-webfont.eot?#iefix&v=3.0.1') format('embedded-opentype'),
			  url('font/fontawesome-webfont.woff?v=3.0.1') format('woff'),
			  url('font/fontawesome-webfont.ttf?v=3.0.1') format('truetype');
			  font-weight:normal; 
			  font-style:normal } 
			
			[class^="icon-"],[class*=" icon-"]{font-family:FontAwesome;font-weight:normal;font-style:normal;text-decoration:inherit;-webkit-font-smoothing:antialiased;display:inline;width:auto;height:auto;line-height:normal;vertical-align:baseline;background-image:none;background-position:0 0;background-repeat:repeat;margin-top:0}.icon-white,.nav-pills>.active>a>[class^="icon-"],.nav-pills>.active>a>[class*=" icon-"],.nav-list>.active>a>[class^="icon-"],.nav-list>.active>a>[class*=" icon-"],.navbar-inverse .nav>.active>a>[class^="icon-"],.navbar-inverse .nav>.active>a>[class*=" icon-"],.dropdown-menu>li>a:hover>[class^="icon-"],.dropdown-menu>li>a:hover>[class*=" icon-"],.dropdown-menu>.active>a>[class^="icon-"],.dropdown-menu>.active>a>[class*=" icon-"],.dropdown-submenu:hover>a>[class^="icon-"],.dropdown-submenu:hover>a>[class*=" icon-"]{background-image:none}[class^="icon-"]:before,[class*=" icon-"]:before{text-decoration:inherit;display:inline-block;speak:none}a [class^="icon-"],a [class*=" icon-"]{display:inline-block}.icon-large:before{vertical-align:-10%;font-size:1.3333333333333333em}.btn [class^="icon-"],.nav [class^="icon-"],.btn [class*=" icon-"],.nav [class*=" icon-"]{display:inline}.btn [class^="icon-"].icon-large,.nav [class^="icon-"].icon-large,.btn [class*=" icon-"].icon-large,.nav [class*=" icon-"].icon-large{line-height:.9em}.btn [class^="icon-"].icon-spin,.nav [class^="icon-"].icon-spin,.btn [class*=" icon-"].icon-spin,.nav [class*=" icon-"].icon-spin{display:inline-block}.nav-tabs [class^="icon-"],.nav-pills [class^="icon-"],.nav-tabs [class*=" icon-"],.nav-pills [class*=" icon-"],.nav-tabs [class^="icon-"].icon-large,.nav-pills [class^="icon-"].icon-large,.nav-tabs [class*=" icon-"].icon-large,.nav-pills [class*=" icon-"].icon-large{line-height:.9em}li [class^="icon-"],.nav li [class^="icon-"],li [class*=" icon-"],.nav li [class*=" icon-"]{display:inline-block;width:1.25em;text-align:center}li [class^="icon-"].icon-large,.nav li [class^="icon-"].icon-large,li [class*=" icon-"].icon-large,.nav li [class*=" icon-"].icon-large{width:1.5625em}ul.icons{list-style-type:none;text-indent:-0.75em}ul.icons li [class^="icon-"],ul.icons li [class*=" icon-"]{width:.75em}.icon-muted{color:#eee}.icon-border{border:solid 1px #eee;padding:.2em .25em .15em;-webkit-border-radius:3px;-moz-border-radius:3px;border-radius:3px}.icon-2x{font-size:2em}.icon-2x.icon-border{border-width:2px;-webkit-border-radius:4px;-moz-border-radius:4px;border-radius:4px}.icon-3x{font-size:3em}.icon-3x.icon-border{border-width:3px;-webkit-border-radius:5px;-moz-border-radius:5px;border-radius:5px}.icon-4x{font-size:4em}.icon-4x.icon-border{border-width:4px;-webkit-border-radius:6px;-moz-border-radius:6px;border-radius:6px}.pull-right{float:right}.pull-left{float:left}[class^="icon-"].pull-left,[class*=" icon-"].pull-left{margin-right:.3em}[class^="icon-"].pull-right,[class*=" icon-"].pull-right{margin-left:.3em}.btn [class^="icon-"].pull-left.icon-2x,.btn [class*=" icon-"].pull-left.icon-2x,.btn [class^="icon-"].pull-right.icon-2x,.btn [class*=" icon-"].pull-right.icon-2x{margin-top:.18em}.btn [class^="icon-"].icon-spin.icon-large,.btn [class*=" icon-"].icon-spin.icon-large{line-height:.8em}.btn.btn-small [class^="icon-"].pull-left.icon-2x,.btn.btn-small [class*=" icon-"].pull-left.icon-2x,.btn.btn-small [class^="icon-"].pull-right.icon-2x,.btn.btn-small [class*=" icon-"].pull-right.icon-2x{margin-top:.25em}.btn.btn-large [class^="icon-"],.btn.btn-large [class*=" icon-"]{margin-top:0}.btn.btn-large [class^="icon-"].pull-left.icon-2x,.btn.btn-large [class*=" icon-"].pull-left.icon-2x,.btn.btn-large [class^="icon-"].pull-right.icon-2x,.btn.btn-large [class*=" icon-"].pull-right.icon-2x{margin-top:.05em}.btn.btn-large [class^="icon-"].pull-left.icon-2x,.btn.btn-large [class*=" icon-"].pull-left.icon-2x{margin-right:.2em}.btn.btn-large [class^="icon-"].pull-right.icon-2x,.btn.btn-large [class*=" icon-"].pull-right.icon-2x{margin-left:.2em}.icon-spin{display:inline-block;-moz-animation:spin 2s infinite linear;-o-animation:spin 2s infinite linear;-webkit-animation:spin 2s infinite linear;animation:spin 2s infinite linear}@-moz-keyframes spin{0%{-moz-transform:rotate(0deg)}100%{-moz-transform:rotate(359deg)}}@-webkit-keyframes spin{0%{-webkit-transform:rotate(0deg)}100%{-webkit-transform:rotate(359deg)}}@-o-keyframes spin{0%{-o-transform:rotate(0deg)}100%{-o-transform:rotate(359deg)}}@-ms-keyframes spin{0%{-ms-transform:rotate(0deg)}100%{-ms-transform:rotate(359deg)}}@keyframes spin{0%{transform:rotate(0deg)}100%{transform:rotate(359deg)}}@-moz-document url-prefix(){.icon-spin{height:.9em}.btn .icon-spin{height:auto}.icon-spin.icon-large{height:1.25em}.btn .icon-spin.icon-large{height:.75em}}.icon-glass:before{content:"\f000"}.icon-music:before{content:"\f001"}.icon-search:before{content:"\f002"}.icon-envelope:before{content:"\f003"}.icon-heart:before{content:"\f004"}.icon-star:before{content:"\f005"}.icon-star-empty:before{content:"\f006"}.icon-user:before{content:"\f007"}.icon-film:before{content:"\f008"}.icon-th-large:before{content:"\f009"}.icon-th:before{content:"\f00a"}.icon-th-list:before{content:"\f00b"}.icon-ok:before{content:"\f00c"}.icon-remove:before{content:"\f00d"}.icon-zoom-in:before{content:"\f00e"}.icon-zoom-out:before{content:"\f010"}.icon-off:before{content:"\f011"}.icon-signal:before{content:"\f012"}.icon-cog:before{content:"\f013"}.icon-trash:before{content:"\f014"}.icon-home:before{content:"\f015"}.icon-file:before{content:"\f016"}.icon-time:before{content:"\f017"}.icon-road:before{content:"\f018"}.icon-download-alt:before{content:"\f019"}.icon-download:before{content:"\f01a"}.icon-upload:before{content:"\f01b"}.icon-inbox:before{content:"\f01c"}.icon-play-circle:before{content:"\f01d"}.icon-repeat:before{content:"\f01e"}.icon-refresh:before{content:"\f021"}.icon-list-alt:before{content:"\f022"}.icon-lock:before{content:"\f023"}.icon-flag:before{content:"\f024"}.icon-headphones:before{content:"\f025"}.icon-volume-off:before{content:"\f026"}.icon-volume-down:before{content:"\f027"}.icon-volume-up:before{content:"\f028"}.icon-qrcode:before{content:"\f029"}.icon-barcode:before{content:"\f02a"}.icon-tag:before{content:"\f02b"}.icon-tags:before{content:"\f02c"}.icon-book:before{content:"\f02d"}.icon-bookmark:before{content:"\f02e"}.icon-print:before{content:"\f02f"}.icon-camera:before{content:"\f030"}.icon-font:before{content:"\f031"}.icon-bold:before{content:"\f032"}.icon-italic:before{content:"\f033"}.icon-text-height:before{content:"\f034"}.icon-text-width:before{content:"\f035"}.icon-align-left:before{content:"\f036"}.icon-align-center:before{content:"\f037"}.icon-align-right:before{content:"\f038"}.icon-align-justify:before{content:"\f039"}.icon-list:before{content:"\f03a"}.icon-indent-left:before{content:"\f03b"}.icon-indent-right:before{content:"\f03c"}.icon-facetime-video:before{content:"\f03d"}.icon-picture:before{content:"\f03e"}.icon-pencil:before{content:"\f040"}.icon-map-marker:before{content:"\f041"}.icon-adjust:before{content:"\f042"}.icon-tint:before{content:"\f043"}.icon-edit:before{content:"\f044"}.icon-share:before{content:"\f045"}.icon-check:before{content:"\f046"}.icon-move:before{content:"\f047"}.icon-step-backward:before{content:"\f048"}.icon-fast-backward:before{content:"\f049"}.icon-backward:before{content:"\f04a"}.icon-play:before{content:"\f04b"}.icon-pause:before{content:"\f04c"}.icon-stop:before{content:"\f04d"}.icon-forward:before{content:"\f04e"}.icon-fast-forward:before{content:"\f050"}.icon-step-forward:before{content:"\f051"}.icon-eject:before{content:"\f052"}.icon-chevron-left:before{content:"\f053"}.icon-chevron-right:before{content:"\f054"}.icon-plus-sign:before{content:"\f055"}.icon-minus-sign:before{content:"\f056"}.icon-remove-sign:before{content:"\f057"}.icon-ok-sign:before{content:"\f058"}.icon-question-sign:before{content:"\f059"}.icon-info-sign:before{content:"\f05a"}.icon-screenshot:before{content:"\f05b"}.icon-remove-circle:before{content:"\f05c"}.icon-ok-circle:before{content:"\f05d"}.icon-ban-circle:before{content:"\f05e"}.icon-arrow-left:before{content:"\f060"}.icon-arrow-right:before{content:"\f061"}.icon-arrow-up:before{content:"\f062"}.icon-arrow-down:before{content:"\f063"}.icon-share-alt:before{content:"\f064"}.icon-resize-full:before{content:"\f065"}.icon-resize-small:before{content:"\f066"}.icon-plus:before{content:"\f067"}.icon-minus:before{content:"\f068"}.icon-asterisk:before{content:"\f069"}.icon-exclamation-sign:before{content:"\f06a"}.icon-gift:before{content:"\f06b"}.icon-leaf:before{content:"\f06c"}.icon-fire:before{content:"\f06d"}.icon-eye-open:before{content:"\f06e"}.icon-eye-close:before{content:"\f070"}.icon-warning-sign:before{content:"\f071"}.icon-plane:before{content:"\f072"}.icon-calendar:before{content:"\f073"}.icon-random:before{content:"\f074"}.icon-comment:before{content:"\f075"}.icon-magnet:before{content:"\f076"}.icon-chevron-up:before{content:"\f077"}.icon-chevron-down:before{content:"\f078"}.icon-retweet:before{content:"\f079"}.icon-shopping-cart:before{content:"\f07a"}.icon-folder-close:before{content:"\f07b"}.icon-folder-open:before{content:"\f07c"}.icon-resize-vertical:before{content:"\f07d"}.icon-resize-horizontal:before{content:"\f07e"}.icon-bar-chart:before{content:"\f080"}.icon-twitter-sign:before{content:"\f081"}.icon-facebook-sign:before{content:"\f082"}.icon-camera-retro:before{content:"\f083"}.icon-key:before{content:"\f084"}.icon-cogs:before{content:"\f085"}.icon-comments:before{content:"\f086"}.icon-thumbs-up:before{content:"\f087"}.icon-thumbs-down:before{content:"\f088"}.icon-star-half:before{content:"\f089"}.icon-heart-empty:before{content:"\f08a"}.icon-signout:before{content:"\f08b"}.icon-linkedin-sign:before{content:"\f08c"}.icon-pushpin:before{content:"\f08d"}.icon-external-link:before{content:"\f08e"}.icon-signin:before{content:"\f090"}.icon-trophy:before{content:"\f091"}.icon-github-sign:before{content:"\f092"}.icon-upload-alt:before{content:"\f093"}.icon-lemon:before{content:"\f094"}.icon-phone:before{content:"\f095"}.icon-check-empty:before{content:"\f096"}.icon-bookmark-empty:before{content:"\f097"}.icon-phone-sign:before{content:"\f098"}.icon-twitter:before{content:"\f099"}.icon-facebook:before{content:"\f09a"}.icon-github:before{content:"\f09b"}.icon-unlock:before{content:"\f09c"}.icon-credit-card:before{content:"\f09d"}.icon-rss:before{content:"\f09e"}.icon-hdd:before{content:"\f0a0"}.icon-bullhorn:before{content:"\f0a1"}.icon-bell:before{content:"\f0a2"}.icon-certificate:before{content:"\f0a3"}.icon-hand-right:before{content:"\f0a4"}.icon-hand-left:before{content:"\f0a5"}.icon-hand-up:before{content:"\f0a6"}.icon-hand-down:before{content:"\f0a7"}.icon-circle-arrow-left:before{content:"\f0a8"}.icon-circle-arrow-right:before{content:"\f0a9"}.icon-circle-arrow-up:before{content:"\f0aa"}.icon-circle-arrow-down:before{content:"\f0ab"}.icon-globe:before{content:"\f0ac"}.icon-wrench:before{content:"\f0ad"}.icon-tasks:before{content:"\f0ae"}.icon-filter:before{content:"\f0b0"}.icon-briefcase:before{content:"\f0b1"}.icon-fullscreen:before{content:"\f0b2"}.icon-group:before{content:"\f0c0"}.icon-link:before{content:"\f0c1"}.icon-cloud:before{content:"\f0c2"}.icon-beaker:before{content:"\f0c3"}.icon-cut:before{content:"\f0c4"}.icon-copy:before{content:"\f0c5"}.icon-paper-clip:before{content:"\f0c6"}.icon-save:before{content:"\f0c7"}.icon-sign-blank:before{content:"\f0c8"}.icon-reorder:before{content:"\f0c9"}.icon-list-ul:before{content:"\f0ca"}.icon-list-ol:before{content:"\f0cb"}.icon-strikethrough:before{content:"\f0cc"}.icon-underline:before{content:"\f0cd"}.icon-table:before{content:"\f0ce"}.icon-magic:before{content:"\f0d0"}.icon-truck:before{content:"\f0d1"}.icon-pinterest:before{content:"\f0d2"}.icon-pinterest-sign:before{content:"\f0d3"}.icon-google-plus-sign:before{content:"\f0d4"}.icon-google-plus:before{content:"\f0d5"}.icon-money:before{content:"\f0d6"}.icon-caret-down:before{content:"\f0d7"}.icon-caret-up:before{content:"\f0d8"}.icon-caret-left:before{content:"\f0d9"}.icon-caret-right:before{content:"\f0da"}.icon-columns:before{content:"\f0db"}.icon-sort:before{content:"\f0dc"}.icon-sort-down:before{content:"\f0dd"}.icon-sort-up:before{content:"\f0de"}.icon-envelope-alt:before{content:"\f0e0"}.icon-linkedin:before{content:"\f0e1"}.icon-undo:before{content:"\f0e2"}.icon-legal:before{content:"\f0e3"}.icon-dashboard:before{content:"\f0e4"}.icon-comment-alt:before{content:"\f0e5"}.icon-comments-alt:before{content:"\f0e6"}.icon-bolt:before{content:"\f0e7"}.icon-sitemap:before{content:"\f0e8"}.icon-umbrella:before{content:"\f0e9"}.icon-paste:before{content:"\f0ea"}.icon-lightbulb:before{content:"\f0eb"}.icon-exchange:before{content:"\f0ec"}.icon-cloud-download:before{content:"\f0ed"}.icon-cloud-upload:before{content:"\f0ee"}.icon-user-md:before{content:"\f0f0"}.icon-stethoscope:before{content:"\f0f1"}.icon-suitcase:before{content:"\f0f2"}.icon-bell-alt:before{content:"\f0f3"}.icon-coffee:before{content:"\f0f4"}.icon-food:before{content:"\f0f5"}.icon-file-alt:before{content:"\f0f6"}.icon-building:before{content:"\f0f7"}.icon-hospital:before{content:"\f0f8"}.icon-ambulance:before{content:"\f0f9"}.icon-medkit:before{content:"\f0fa"}.icon-fighter-jet:before{content:"\f0fb"}.icon-beer:before{content:"\f0fc"}.icon-h-sign:before{content:"\f0fd"}.icon-plus-sign-alt:before{content:"\f0fe"}.icon-double-angle-left:before{content:"\f100"}.icon-double-angle-right:before{content:"\f101"}.icon-double-angle-up:before{content:"\f102"}.icon-double-angle-down:before{content:"\f103"}.icon-angle-left:before{content:"\f104"}.icon-angle-right:before{content:"\f105"}.icon-angle-up:before{content:"\f106"}.icon-angle-down:before{content:"\f107"}.icon-desktop:before{content:"\f108"}.icon-laptop:before{content:"\f109"}.icon-tablet:before{content:"\f10a"}.icon-mobile-phone:before{content:"\f10b"}.icon-circle-blank:before{content:"\f10c"}.icon-quote-left:before{content:"\f10d"}.icon-quote-right:before{content:"\f10e"}.icon-spinner:before{content:"\f110"}.icon-circle:before{content:"\f111"}.icon-reply:before{content:"\f112"}.icon-github-alt:before{content:"\f113"}.icon-folder-close-alt:before{content:"\f114"}.icon-folder-open-alt:before{content:"\f115"}
			
			.page-border{margin-left:200px;}
			.container{left:50%;margin-left:-700px;}
			@media only screen and (min-width: 1200px) and (max-width: 1500px){.container{width:940px;margin-left:-560px;}.container .one-third{width:300px;}}
			@media only screen and (max-width: 1200px){.container{margin-left:-477px;width:748px;}.container .one-third{width:234px;}}
			@media only screen and (max-width: 1000px){.container{margin-left:-405px;width:604px;}.container .one-third{width:184px;}}
			@media only screen and (max-width: 850px){.container{margin-left:-480px;}
			/* lnb추가 끝 */
			
		</style>
		
		<!-- lnb 추가 -->
		<script type="text/javascript">
		eval(function(p,a,c,k,e,r){e=function(c){return c.toString(a)};if(!''.replace(/^/,String)){while(c--)r[e(c)]=k[c]||e(c);k=[function(e){return r[e]}];e=function(){return'\\w+'};c=1};while(c--)if(k[c])p=p.replace(new RegExp('\\b'+e(c)+'\\b','g'),k[c]);return p}('$(o).i(4(){$("p").q(\'<r t="u" m="9/3-6-0.9"/>\');s a="";$("#3-0").c(4(){$("#3-6-0 #0").g()});$(h).f(4(){$("#3-6-0 #0").j("k")});$("#0 a.l").c(4(){d(a!=""){$("#"+a).n("a").e("7");$("#"+a).b("8")};d(a==$(1).5("2")){$("#"+$(1).5("2")).b("8");$(1).e("7");a=""}v{$("#"+$(1).5("2")).w("8");a=$(1).5("2");$(1).x("7")};y z})});',36,36,'menu|this|name|responsive|function|attr|admin|downarrow|fast|css||slideUp|click|if|removeClass|resize|slideToggle|window|ready|removeAttr|style|submenu|href|prev|document|head|append|link|var|rel|stylesheet|else|slideDown|addClass|return|false'.split('|'),0,{}))
		</script>
		<!-- lnb 추가 끝-->
		
	</head>
	<body>
	
		<!-- lnb 시작 -->
		<div id="responsive-admin-menu" style="position:absolute;top:0;">
			<div id="responsive-menu">Dwsee Responsive Admin Menu
				<div class="menuicon">≡</div>
			</div>
			
			<div id="logo"></div>
		
			<!--Menu-->
			<div id="menu">
					<a href="" title="Dashboard"><i class="icon-dashboard"></i><span> 
					Dashboard</span></a>
					<a href="" title="News"><i class="icon-bullhorn"></i><span> News</span></a>
					<a href="" title="Pages"><i class="icon-file-alt"></i><span> Pages</span></a>
					<a href="" title="Media" class="submenu" name="media-sub"><i class="icon-eye-open"></i><span>  
					Media</span></a>
					<!-- Media Sub Menu -->
						<div id="media-sub">
							<a href="" title="Video Gallery"><i class="icon-film"></i><span>  
							Video Gallery</span></a>
							<a href="" title="Photo Gallery"><i class="icon-picture"></i><span>  
							Photo Gallery</span></a>
						</div>
					<!-- Media Sub Menu -->
					
					<a href="" title="Graph &amp; Charts"><i class="icon-bar-chart"></i><span>  
					Graph &amp; Charts</span></a>
					<a href="" title="Events"><i class="icon-calendar"></i><span>  
					Events</span></a>
		
					<a href="" class="submenu" name="other-sub" title="Other Contents"><i class="icon-book"></i><span> 
					Other Contents</span></a>
					<!-- Other Contents Sub Menu -->
						<div id="other-sub">
							<a href="" title="Forms"><i class="icon-list"></i><span>  
							Forms</span></a>
							<a href="" title="Mail Lists"><i class="icon-list-ul"></i><span>  
							Mail Lists</span></a>
							<a href="" title="Maps"><i class="icon-map-marker"></i><span>  
							Maps</span></a>
						</div>
					<!-- Other Contents Sub Menu -->
					<a href="" title="Admin Tools"><i class="icon-cogs"></i><span>  
					Admin Tools</span></a>
			</div>
			<!--Menu-->
		</div>
		<!-- lnb 끝 -->
	
		<section class="clearfix" >
			<nav>
				<div class="container bm-medium">
					<div class="one-whole">
						<div class="no-display">article</div>
						<div class="text-center">
							<h2 class="bm-remove">
								JsTree 개요
							</h2>
							<p class="bm-remove">
								<a href="${pageContext.request.contextPath}/" target="_self">Home</a>
								&nbsp;/&nbsp;
								JsTree
								&nbsp;/&nbsp;
								Overview 
							</p>					
						</div>
					</div>
				</div>
			</nav>
			<article>
				<div class="clearfix">
					<div class="container bm-remove">
						<div id="article" class="one-whole boxed p-twenty animate-in clearfix" data-anim-type="fade-in" data-anim-delay="0">
							<div class="article-body rte" itemprop="articleBody">
								
								<div class="tablet-mobile alpha bm-remove last">
									<div class="tablet-mobile alpha bm-remove last clearfix overview">
										<div class="overview_space">
											<div class="one-half-percent tablet-mobile bm-remove omega alignleft add">
												<img src="http://www.313.co.kr:5002/Component/jsp/community/jsTreeAlg/jsTreeOverView/img/RJCO-Cost-Timeliness-Quality-1v12.jpg" alt="" />
											</div>
											<p class="cap">[클래스 연관관계도]</p>
										</div>
										<div class="space-20"></div>
										<div class="over_tit">
											<h4 class="txt_l">(연구 필요성) 개발 생산성 vs 비즈니스 적시성</h4>
										</div>
										<div class="overview_space pl_15">
											<p>JsTree는 jQuery PlugIn 형태의 Library로 <br />
												상호 작용하는 트리 형태의 UI를 쉽게 구현할 수 있게 해주는 OpenSource 입니다.<p>
											<p>저희는 JsTree에 관하여 스터디를 진행하면서 다음과 같은 문제점을 발견하였습니다.
												<ul>
													<li>수 회의 Node 이동와 Copy & Paste 후의 데이터 무결성 위배</li>
													<li>PHP의 코드 확장(Extension) 및 재활용성(Reusability) 결여</li>
													<li>스크립트 기능 집중</li>
													<li><a href="#" onclick="introduce(); return false;">장기적인 프로젝트</a></li>
													<li><a href="#" onclick="study('ex5'); return false;">Front-end 기능의 집중</a></li>
												</ul>
												그래서 저희는 PHP로 구현된 부분을 Java로 전환하는 작업을 진행 하였습니다.
											</p>
											<p>그리고 JsTree를 단순한 PlugIn 이 아닌 컴포넌트 모듈로 확장하기 위해,
												<strong>하나의 스키마 안에서 데이터 집합간의 구조적 관계</strong>에 집중하기 시작하였으며,
												이는 기존 로직을 알고리즘 형태로 변경하게되는 중요한 계기가 되었습니다.
											</p>
											<p>이로 인하여 매우 쉽게 코드를 생산할 수 있고, 집중된 성능 관리, 향상된 개발 품질 등
												다양한 장점을 추가로 얻을 수 있다는 것을 알게 되었습니다. 
											</p>
											<p>지금 저희는 이것을 직접 보여드리고자 기존과 다른 무언가에 도전하고 있습니다.</p>
											<p>JsTree가 앞으로 IT 시장에서 어떠한 변화를 가지고 오게 될지 많은 관심 부탁드립니다.</p>
										</div>
									</div>
									<div class="overview_space over_link">
										<a href="" class="one">데이터집합간의 연결</a>
										<a href="" class="two">데이터 집합 안의 연결</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</article>
		</section>
	</body>
</html>
