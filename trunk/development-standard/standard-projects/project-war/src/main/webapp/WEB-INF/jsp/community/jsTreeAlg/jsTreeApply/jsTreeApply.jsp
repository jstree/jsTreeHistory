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
								JsTree 적용
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
										<h4 class="title"><span>(연구범위) 데이터집합간의 연결 vs 데이터집합안의 연결</span></h4>
							
										<div class="content">
											<ul class="unstyled bm-remove">
												
													<li><a href="#"><span>데이터 집한 간의 연결</span></a></li>
													<li><i class="fa fa-caret-right fw"></i><span> 정규식 표현의 설계 ( 견고함 - 정규화 )</span></li>
													<li><i class="fa fa-caret-right fw"></i><span> 고정된 Model Bean 생성</span></li>
													<li><i class="fa fa-caret-right fw"></i><span> 정규화후 Model Bean에 의한 구조화 ( 이때부터 변경에 취약한 구조로 변화 )</span></li>
													<li><i class="fa fa-caret-right fw"></i><span> Model 구조화 후 스키마 연계에 의거한 서비스 코드 작성.</span></li>
													<li><i class="fa fa-caret-right fw"></i><span> 서비스 코드 작성 이후로 고객의 변경 사항에 취약함.</span></li>
													<li><i class="fa fa-caret-right fw"></i><span> 메타 데이터의 데이터 집한간 연결을 고려했을 시 역시 서비스 코드의 고착화는 피할 수 없음 ( 서비스 코드의 태생적 한계이기 때문에 )</span></li>
													<li><i class="fa fa-caret-right fw"></i><span> 서비스 코드를 제외한 코드는 서비스 코드와 분리되어야 하고,</span></li>
													<li><i class="fa fa-caret-right fw"></i><span> 그 자체로 독립적인 메타 데이터간의 연결이 이루어진다면. </span></li>
													<li><i class="fa fa-caret-right fw"></i><span> 유연한 인터페이스를 가진 형태를 가지게 됩니다. </span></li>
												
													<li><a href="#"><span>데이터 집합 안의 연결</span></a></li>
													<li><i class="fa fa-caret-right fw"></i><span> 메타 데이터와 model 의 결합으로 인하여 어플리케이션간의 인터페이스 역할은 여러가지 장점을 가지게 하지만 명확한 장점은 아니다.</span></li>
													<li><i class="fa fa-caret-right fw"></i><span> 메타 데이터의 model 결합으로 인하여 기본적인 데이터 집합 내 구조적 특성을 제공한다.</span></li>
													<li><i class="fa fa-caret-right fw"></i><span> 이 특성은 Model에 바인딩 되는 모든 데이터를 스키마 내의 집합 데이터안에서 고객의 Needs에 의한 구조적 특성을 가지게 되며, 메타 데이터 간의 스키마 연계는 일관된 형태를 유지하기 때문에, 변경에 유리하다. ( 모델의 특성에 얽메이지 않기 때문에 )</span></li>
											</ul>
										</div>
									</div>
									
									<p>고객의 Needs는 항상 변화하게 되어 있고, 프로젝트는 항상 그 변화에 일정과 비용을 감당하지 못하는게 사실 입니다. 이 변화는 모든 프로젝트에서 항상 발생하고 있고, 모든 프로젝트는 이 변화에 순응하다 비용을 감당하지 못하고 프로젝트가 실패하거나, 고객의 요구를 컨트롤 하지 못했다는 이유로 프로젝트가 제어되지 못한체 마감되었다고 평가되고는 합니다. 혹은 개발자를 혹사하여, 프로젝트의 마감 기한을 맞추는 악순환의 기로에 서게 됩니다.</p>
									<p>이유가 뭘까? 를 생각해 봤습니다. 어떻게 해야 프로젝트를 성공적으로 이끌어 갈수 있을까? 를 생각해 봤습니다. 어떻게 프로젝트의 비용을 줄일 수 있을까?를 생각해 봤습니다.</p>
									<p>고객의 Needs가 변화하더라도 설계를 유연하게 할 수 있는 방법은 없을까?를 고민한 끝에 jkwTree 만이 이 문제를 해결할 수 있을것이라고 생각했습니다. 단일한 알고리즘과 데이터 모델의 메타 데이터를 고객의 Needs에 맞춰 변경및 변형을 통하여, 설계를 유연하게 변경하며,  단일 집합 내에서의 변경이 외부의 영향을 받는 서비스 코드만을 변경하면 되는 방법을 구현하였습니다.</p>
									<p>상호 유기적인 데이터 병합의 의미 도출 개발도 유지하며, 우리는 새롭게 단일 데이터 집합에서 또 다른 새로운 의미를 도출 할 수 있는, 어플리케이션의 은탄환을 구현하였습니다.</p> 
									<p>상호관계의 표현을 위하여 수많은 연구가 수행되어, 정규화 및 데이터 모델에 관한 많은 연구가 수행되어 왔습니다. 하지만, 그 모든 기준의 새로운 시작은 단일 데이터 집합내의 구조적 관계 구성에 대하여 연구가 수행된다면, 새로운 페러다임을 찾을 수 있다는 것을 알았습니다. 즉, 이미 증명되었듯이, 데이터 스키마간의 상호 관계성은 변화에 취약 할 수 밖에 없는 필연적인 문제를 만듭니다.</p>
									<p>또한 고객은 내부 단일 데이터의 데이터 모델의 메타 데이터 제공을 통하여, 이런 변화에 혁신적인 알고리즘 모듈을 소개합니다.</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</article>
		</section>
	</body>
</html>