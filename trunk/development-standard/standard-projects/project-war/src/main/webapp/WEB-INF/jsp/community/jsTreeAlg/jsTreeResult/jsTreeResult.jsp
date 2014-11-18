<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="ko" class="no-js">
<!--<![endif]-->
	<head></head>
	<body>
		<section class="clearfix" >
			<nav>
				<div class="container bm-medium">
					<div class="one-whole">
						<div class="no-display">article</div>
						<div class="text-center">
							<h2 class="bm-remove">
								JsTree 결과
							</h2>
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
										<img src="http://placehold.it/599x599" alt="" />
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
									<p>이런 프로젝트를 아무리 훌륭한 기준은 PMBOK등으로 관리해봐야 소용이 없다. ! 일관되지 않은 컴포넌트의 조합이 과연 Unix 처럼 완벽하게 동작하는 모듈의 집합일 리 없다는 것이다.!</p>
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
