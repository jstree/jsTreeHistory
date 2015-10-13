<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="ko" class="no-js">
<!--<![endif]-->
<head></head>
<body>
	<script type="text/javascript">
	//호출
	$(document).ready(function(){


	});

	// 글로벌 함수 객체
	// 수정(2015.03.16 - 팀장 객체 및 기타 함수 포함)
	function jsTreeObject(){


		// 팀장님 작성 : 제이쿼리 타입별 객체를 생성하는 방법
		var callBoolean = function (paramBool){
			var bool = new Boolean(paramBool);
			return bool;
		};

		// 누가 작성하셨는지 주석좀 달아주세요
		var jqueryObj = function () {
			var type1 = new Boolean();
			var type2 = new Boolean(true);
			type2.value = true;

			var para;
			console.log(type1); // Default False
			console.log(type2);

			para = type2.value;
		 	alert(para)
		};

		// 기본 데이터 타입 + 연산 확인
		var checkType = function(){
			var study = ["js", 1, undefined, null, true];
			var result = [];
			var list = ["문자열", "숫자", "undefined", "null", "true"];

			for(var a = 0 ; a<study.length ; a++){
				console.log("결과" + "\n" + "-----------------");
				for(var b = 0 ; b<study.length ; b++){
					var temp = [];
					temp[b] = study[a] + study[b];
					result.push(temp[b]);
					console.log(list[a] + " + " + list[b] + " = " + temp[b] + "\n");
				}
			console.log("-----------------");
			console.log(a + "번째 루프 끝");
			console.log("-----------------" + "\n\n");
			}
		}

		// 에러 객체 확장
		var errorTest = function (obj){
			try{
				throw new Error(typeof(obj));
			}catch(e){
				console.log(e.name + ':' + e.message);
			}
		}
		
		// 2015.03.08 전진홍
		var makeMyInfo = function (name, hobby, job, age){
			var myInfo  = {
				name : name,
				hobby : hobby,
				job : job,
				age : age,
				getInfo : function(){
					return this.name + ', ' + this.hobby + ', ' + this.job + ', ' + this.age;
				}
			}
			return myInfo;
		}
		
		var makeMyInfo2 = function (name, hobby, job, age){
			this.name = name;
			this.hobby = hobby;
			this.job = job;
			this.age = age;
			this.getInfo = function(){
				return this.name + ', ' + this.hobby + ', ' + this.job + ', ' + this.age;
			}
		}
		
		// 2015.03.14 이혜진
		var teamLeader = function (name, age, job){
		   this.name = name;
		   this.age = age;
		   this.job = job;
	
		   this.getName = function(){
		      return this.name;
		   };
	
		   this.setName = function(name){
		      this.name = name;
		   };
	
		   this.getAge = function(){
		      return this.age;
		   };
	
		   this.setAge = function(age){
		      this.age = age;
		   };
	
		   this.getJob = function(job){
		   	  return this.job;
		   };
		   
		   this.setJob = function(job){
		   	  this.job = job;
		   };
		};
	}


    /////////////////////////////////////////////////////////////// 정리 필요  ///////////////////////////////////////////////////////////////


		function studyPlay(){
			var i = 1;
			var j = ++i;
		};
		
		console.log(j);

		function studyPlus(){
			var i = 1;
			var k = i++;
		};
		
		console.log(k);

		function plusStudy(){
			var v = 0;
		};
		
		console.log((++v) +1);
		console.log((v++) +1);

		function decrease(count){
			return count--;
		};
		console.log(decrease(10));

		//HyeJin : 여기서부터??
		function equal(){
			var b = (1=="1");
		};
		console.log(b);

		function typeEqual(){
			var s = "hello";
			var o = new Object("hello");
		};
		console.log(s == o);

		function objectEqual(){
			var o1 = new String("hello");
			var o2 = new Object("hello");
		};
		console.log(o1 == o2);

		function array(){
			var a=["1","2","3"];
			var b=["1","2","3"];
		};
		console.log(a == b);

		function arrayEqual(){
			var a=["1","2","3"];
			var b=[a[0],a[1],a[2]];
		};
		console.log(a == b);

		// HyeJin: 경석씨 확인플리즈
		function arrayEqual(x,y){
			var x = ["1","2","3"];
			var y = ["1","2","3"];
			return x==y;
		};
		console.log(arrayEqual(x,y));

		function arrayTypeEqual(){
		var a = new Array(1,2,3);
		var b = new Array(1,2,3);
		};
		console.log(a == b);

		function studyNaN(){
			var x = NaN;
			var y = NaN;
		};
		console.log(x == y);

		function studyNull(){
			var a = undefined;
			var b = null;
		};
		console.log(a == b);

		function  boolean(){
			var a = (1+2) || {};
		};
		console.log(a);

		function validateFiled(oEvent){
			oEvent = oEvent || window.event;
		}

		function validateFilde(oEvent){
			if(oEvent == null) oEvent = window.event;
		}

		function studyBoolean(){
		var result1 = null && true;
		};
		console.log(result1);

		function booleanStudy(){
		var result2 = false && "양파링";
		};
		console.log(result2);
		// HyeJin: 여기까지??

		var a = 1;
		var c = 1;

		var var1 = !(a==c);
		var var2 = !"양파링";
		console.log(var1);
		console.log(var2);

		var a = 1;
		var r = '';
		if(a > 2){
			r = 'a는 2보다 크다';
		}else{
			r = 'a는 2보다 작거나 같다';
		}
		console.log(r);

		var r = '';
		if(a>2){
			r='a는 2보다 크다';
		}else if(a==2){
			r='a는 2이다';
		}else{
			r='a는 2보다 작다';
		}
		console.log(r);

		var age = 16;
		var sURL = age>18? ( 'OK, 계속 진행할수 있습니다.') : ( '너무 나이가 어립니다!' );
		console.log(sURL);

		var r = '';
		switch(a){
			case a > 2 :
			r = 'a는 2보다 크다';
			break;
			case a == 2 :
			r = 'a는 2이다';
			break;
			default :
			r = 'a는 2보다 작다';
			break;
		}
		console.log(r);

		function f(count){
			console.log(i);
			for(var i=0;i<count;i++){};
			return i;
		}
		console.log(f(100));


		function g(count){
			for(i=0;i<count;i++){};
			return i;
		}
		console.log(g(100));
		console.log(i);

		var myObject = {p1:'a', p2:'b'};
		var result = '\n';
		for (var prop in myObject){
			result += '속성명:' + prop + ',값:' + myObject[prop] + '\n';
		}
		console.log(result);

		var a = ['a', 'b'];
		var result = '\n';
		for (var i in a){
			result += '인덱스:' + i + ',요소값:' + a[i] + '\n';
		}
		console.log(result);

		var o = {p1:1, p2:2};
		var ar = [];
		var i = 0;
		for(ar[i++] in o);
		console.log(ar);

		var i = 0;
		while (i<10){
			console.log(i++);
		}

		var i = 100;
		do{
			console.log(i++);
		}while(i<10);

		var obj = [undefined, null, true, 0, ''];
		var result;

		for(var i in obj){
			result += errorTest(obj[i]) + '\n';
		}
			console.log(obj);

    /////////////////////////////////////////////////////////////// 정리 필요  ///////////////////////////////////////////////////////////////

		</script>

		<section class="clearfix" >
			<nav>
				<div class="container bm-medium">
					<div class="one-whole">
						<div class="no-display">article</div>
						<div class="text-center">
							<h2 class="bm-remove">
								JsTree 결과
							</h2>
							<p class="bm-remove">
								<a href="${pageContext.request.contextPath}/" target="_self">Home</a>
								&nbsp;/&nbsp;
								JsTree
								&nbsp;/&nbsp;
								Result
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
									<div class="one-half-percent tablet-mobile bm-remove omega alignleft">
										<img src="/images/community/jsTreeAlg/jsTreeResult/leader_3_display.jpg" alt="" />
									</div>
									<div class="space-20"></div>

									<div id="link-list">
										<h4 class="title"><span>(연구결과) 개발 vs 일관된 개발</span></h4>

										<div class="content">
											<ul class="unstyled bm-remove">

													<li><a href="#"><span>개발 // Development</span></a></li>
													<li><i class="fa fa-caret-right fw"></i><span> 우리는 혁신을 밖에서 찾고있다. ( 새로운 개발 방법론, 새로운 개발 지원 시스템 등등 )</span></li>
													<li><i class="fa fa-caret-right fw"></i><span> 우리는 여전히 설계부터 다시 시작하고 있다. ( 재 사용은 일부라고 생각한다. )</span></li>
													<li><i class="fa fa-caret-right fw"></i><span> 우리는 여전히 제어는 서비스 코드의 덩어리이고, Controller - Service - Dao 셋트를 기준으로 개발한다.</span></li>
													<li><i class="fa fa-caret-right fw"></i><span> 우리는 여전히 코드의 복잡성은 당연하다고 생각한다.</span></li>
													<li><i class="fa fa-caret-right fw"></i><span> 성능이 느리면 해당 컴포넌트를 뒤지면 뒤에 달려있는 여러 컴포넌트들이 성능 향상의 대상이 된다.</span></li>
													<li><i class="fa fa-caret-right fw"></i><span> 새로운 기능은 새로운 셋트로 등장하게 되고,</span></li>
													<li><i class="fa fa-caret-right fw"></i><span> 코드의 품질은 개발자의 몫이라고 생각한다.</span></li>
													<li><i class="fa fa-caret-right fw"></i><span> 보안 적용은 하나의 거대한 또다른 프로젝트라고 생각한다.</span></li>
													<li><i class="fa fa-caret-right fw"></i><span> 우리는 절대 프로젝트를 성공할 수 없기때문에, 프로젝트 규약의 대 서사시인 PMBOK을 찬양한다.</span></li>

													<a href="#"><span>스크립트 기능 집중</span></a>
													<li><i class="fa fa-caret-right fw"></i>
														<a href="javascript:show();"><span>장기적인 프로젝트</span></a></li>
													<li><i class="fa fa-caret-right fw"></i>
														<a href="javascript:alert('이혜진입니다.')"><span>Front-end기능의 집중</span>
														</a></li>

													<li><a href="#"><span>혁신 개발 // 313 DEV GRP</span></a></li>
													<li><i class="fa fa-caret-right fw"></i><span> 우리는 혁신을 아키텍쳐에서 찾았다. ( 물론 새로운 개발 방법론과, ALM 까지 지원한다. )</span></li>
													<li><i class="fa fa-caret-right fw"></i><span> 우리는 이미 범용 설계 기법과 방안을 가지고 있다. ( 모든 코드는 재사용 된다. )</span></li>
													<li><i class="fa fa-caret-right fw"></i><span> 우리의 제어는 JsTree Engin에 한정되 있으며, 우리는 최소한의 extends Controller - Extends CallBack Service - CallBack Dao를 기준으로 개발한다.</span></li>
													<li><i class="fa fa-caret-right fw"></i><span> 우리의 코드는 복잡성을 띄면 잘못된 코드라고 봐야 한다.</span></li>
													<li><i class="fa fa-caret-right fw"></i><span> 우리의 코드가 성능이 느리면 JsTree Engin 하나만을 집중한다.</span></li>
													<li><i class="fa fa-caret-right fw"></i><span> 우리는 기능이 필요하면 Engin의 기능인지, 아닌지만 구별하면 된다.</span></li>
													<li><i class="fa fa-caret-right fw"></i><span> 우리의 코드 품질은 집중화 되 있기때문에 확실하다.</span></li>
													<li><i class="fa fa-caret-right fw"></i><span> 우리의 보안 적용 대상은 Engin 뿐이다. - 이미 집중화 되 있기때문이다.</span></li>
													<li><i class="fa fa-caret-right fw"></i><span> 우리의 프로젝트는 너무 빨리 끝나기 때문에 사용자의 이야기에 귀를 더 기울여 줄수 있다.</span></li>
											</ul>
										</div>
									</div>
									<br/>

									<p>모든 SI 프로젝트의 품질은 사실상 매우 취약하다!</p>
									<p>모든 SI 프로젝트의 품질은 어쩔수 없는 상황이다. 고객의 Needs 변화, 개발자의 잦은 야근과 컨디션, 회사의 이익을 생각한다면, 그 품질은 이미 끝났다!</p>
									<p>이런 프로젝트를 아무리 훌륭한 기준은 PMBOK등으로 관리해봐야 소용이 없다. ! 일관되지 않은 컴포넌트의 조합이 과연 Unix 처럼 완벽하게 동작하는 모듈의 집합일 리 없다는 것이다!</p>
									<p>우리는 이제 집중화되고 관리되며, 일관된 개발 방법론이 필요한 것이고, 이 알고리즘 모듈 컴포넌트만이 향후 지속적이며, 완전하고, 향상되며, 확장가능성을 열어 줄 것이다.</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</article>
		</section>
	</body>
</html>
