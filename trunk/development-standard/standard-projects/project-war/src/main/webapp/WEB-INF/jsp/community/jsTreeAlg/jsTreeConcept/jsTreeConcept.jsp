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
								JsTree 컨셉
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
										<img src="/images/community/jsTreeAlg/jsTreeConcept/iStock_000017765581Small.jpg" alt="" />
									</div>
									<div class="space-20"></div>
									
									<div id="link-list">
										<h4 class="title"><span>(연구종류) 지속적인 변화 vs 상호관계의 표현 한계성</span></h4>
							
										<div class="content">
											<ul class="unstyled bm-remove">
												
													<li><a href="#"><span>지속적인 변화</span></a></li>
													<li><i class="fa fa-caret-right fw"></i><span> 고객의 Needs의 변화</span></li>
													<li><i class="fa fa-caret-right fw"></i><span> 변화에 순응하지 못하는 설계</span></li>
													<li><i class="fa fa-caret-right fw"></i><span> 변화에 대응 할 수 없는 개발</span></li>
													<li><i class="fa fa-caret-right fw"></i><span> 문제는 프로젝트 비용!</span></li>
													<li><i class="fa fa-caret-right fw"></i><span> 단일 알고리즘을 확보하여, 프로젝트 비용을 단순화 및 단축!</span></li>
													<li><i class="fa fa-caret-right fw"></i><span> 상호 유기적인 데이터 병합으로 새로운 의미를 도출 할 수 있으며,</span></li>
													<li><i class="fa fa-caret-right fw"></i><span> 단일 데이터 집합에서 또 다른 새로운 의미를 도출 할 수 있는,</span></li>
													<li><i class="fa fa-caret-right fw"></i><span> 어플리케이션의 은탄환. jsTree</span></li>
												
													<li><a href="#"><span>상호관계의 표현 한계성</span></a></li>
													<li><i class="fa fa-caret-right fw"></i><span> 데이터 스키마의 딱딱한 상호 관계성이 변화를 무디게 한다.</span></li>
													<li><i class="fa fa-caret-right fw"></i><span> 하지만 대다수의 고객은 스키마 내부의 데이터 관계에 집중하며,</span></li>
													<li><i class="fa fa-caret-right fw"></i><span> 내부 데이터 관계의 변화가 외부 연관 스키마 변화에 영향을 줄것이라</span></li>
													<li><i class="fa fa-caret-right fw"></i><span> 생각한다. 이게 바로 변화다!</span></li>
													<li><i class="fa fa-caret-right fw"></i><span> 즉 ! 데이터 내부 관계의 변화에 외부 연관 스키마의 의미는 변화하게 된다.</span></li>
													<li><i class="fa fa-caret-right fw"></i><span> enable, disable, order 순</span></li>
													<li><i class="fa fa-caret-right fw"></i><span> 데이터 모델의 meta 데이터를 제공하는 어플리케이션</span></li>
											</ul>
										</div>
									</div>
									
									<p>고객의 Needs는 항상 변화하게 되어 있고, 프로젝트는 항상 그 변화에 일정과 비용을 감당하지 못하는게 사실 입니다. 이 변화는 모든 프로젝트에서 항상 발생하고 있고, 모든 프로젝트는 이 변화에 순응하다 비용을 감당하지 못하고 프로젝트가 실패하거나, 고객의 요구를 컨트롤 하지 못했다는 이유로 프로젝트가 제어되지 못한체 마감되었다고 평가되고는 합니다. 혹은 개발자를 혹사하여, 프로젝트의 마감 기한을 맞추는 악순환의 기로에 서게 됩니다.</p>
									<p>이유가 뭘까? 를 생각해 봤습니다. 어떻게 해야 프로젝트를 성공적으로 이끌어 갈수 있을까? 를 생각해 봤습니다. 어떻게 프로젝트의 비용을 줄일 수 있을까?를 생각해 봤습니다.</p>
									<p>고객의 Needs가 변화하더라도 설계를 유연하게 할 수 있는 방법은 없을까?를 고민한 끝에 jkwTree 만이 이 문제를 해결할 수 있을것이라고 생각했습니다. 단일한 알고리즘과 데이터 모델의 메타 데이터를 고객의 Needs에 맞춰 변경및 변형을 통하여, 설계를 유연하게 변경하며, 단일 집합 내에서의 변경이 외부의 영향을 받는 서비스 코드만을 변경하면 되는 방법을 구현하였습니다.</p>
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
