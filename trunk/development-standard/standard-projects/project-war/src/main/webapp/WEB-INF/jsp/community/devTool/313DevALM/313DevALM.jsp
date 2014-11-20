<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="ko" class="no-js">
<!--<![endif]-->
	<head>
		<style type="text/css">
			table {width:35%; border-top:3px solid #ccc; border-collapse:collapse}
            caption {margin:1% 0 0.5%}
            th, td {border:1px solid #ccc}
            th {padding:1% 0.5%; background:#fafafa; font-weight:bold}
            td {padding:0.5% 2%;}
		</style>
	</head>
	<body>
		<section class="clearfix" >
			<nav>
				<div class="container bm-medium">
					<div class="one-whole">
						<div class="no-display">article</div>
						<div class="text-center">
							<h1 class="bm-remove">
								Application Lifecycle Management 
							</h1>
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
										<a href="http://nas.313.co.kr:5002/Component/thymeleaf/community/introduce/dev/img/Diagram_JPP.jpg" data-lightbox="image-1">
											<img src="http://nas.313.co.kr:5002/Component/thymeleaf/community/introduce/dev/img/Diagram_JPP.jpg" alt="Application Lifecycle Management" />
										</a>
									</div>
									<div class="space-20"></div>
									<a href="#"><span>ALM(Application Lifecycle Management ) 이란?</span></a>
									<p>애플리케이션 소프트웨어를 개발 운용하는데 있어서, 라이프사이클 전체를 종합적으로 관리하는 것으로 소프트웨어의 품질, 개발생산성, 변화의 대응력 등을 향상시키기 위한 것이며, 혹은 그를 위한 소프트웨어 플랫폼 툴을 의미합니다.</p>
									<p>기존의 애플리케이션 개발은 기술적인 관점에서 많이 접근이 되어 왔으나, 비즈니스 요건 관리 부분과 실제 소프트웨어 개발 프로세스를 융합하고 이에 대한 관리를 자동화된 툴을 이용하도록 하는 것이 ALM의 개념이며, 이 부분에는 요구 사항 관리, 아키텍쳐, 코딩, 테스팅, 그리고 이슈 추적과 릴리즈 관리등 프로젝트의 모든 활동을 포함하게 됩니다.</p>
									<a href="#"><span>ALM 도입 배경</span></a>
									<p>기존에 소프트웨어 개발 프로세스는 요구 사항 관리에 대한 문서나 시스템, 아키텍쳐나 디자인에 대한 Case tool과 산출물, 코드 관리, 일정 관리 등등이 각기 다른 제품과 다른 프로세스 다른 템플릿으로 구현이 되어 왔고 이로 인해서 소프트웨어 개발 과정에 대한 개념이 실제로 구현되었을때는 단계별로 추적성과 실용성이 떨어졌다.</p>
									<p>ALM의 의미는 이런 현실과 괴리된 부분을 좀더 통합되고 현실적으로 전문화된 도구를 이용하여 현실화 시키고 궁극적으로 소프트웨어 개발 프로세스를 개선하는데 목적을 두고 있다고 말할 수 있다.</p>
									<p>ALM이 실제 커버하는 범위를 보면 아래 그림과 같이 요구사항 관리에서부터 프로젝트 관리, 릴리즈 관리까지 소프트웨어 개발의 거의 전 영역을 커버하는 것을 볼 수 있다.</p>
									
									<div class="div_center">
									<a href="http://nas.313.co.kr:5002/Component/thymeleaf/community/introduce/dev/img/Diagram_JPP.jpg" data-lightbox="image-1">
										<img src="http://nas.313.co.kr:5002/Component/thymeleaf/community/introduce/dev/img/Diagram_JPP.jpg" alt="Application Lifecycle Management" align="left"/>
									</a>
									<br><br><br><br><br>
									<table summary="313 ALM Toll 목록 표입니다.">
									<caption>『  313 ALM Tolls 목록  』</caption>
									<colgroup>
										<col style="width:10%"/>
										<col style="width:50%"/>
										<col style="width:40%"/>
									</colgroup>
									<thead>
										<tr>
											<th>목록</th>
											<th>기능</th>
											<th>Tool</th>
										</tr>
									</thead>
									<tbody>
										<tr style="cursor:pointer;" onmouseover="this.bgColor='#f45b4f'" onMouseOut="this.bgColor='#FFFFFF'" onclick="location.href='http://www.313.co.kr/svnwebclient'">
											<td>1</td>
											<td>Source Control</td>
											<td>Subversion</td>
										</tr>
										<tr style="cursor:pointer;" onmouseover="this.bgColor='#f45b4f'" onMouseOut="this.bgColor='#FFFFFF'" onclick="location.href='http://www.eclipse.org/'">
											<td>2</td>
											<td>Integrated IDE</td>
											<td>Eclipse</td>
										</tr>
										<tr style="cursor:pointer;" onmouseover="this.bgColor='#f45b4f'" onMouseOut="this.bgColor='#FFFFFF'" onclick="location.href='http://www.313.co.kr/hudson'">
											<td>3</td>
											<td>Build</td>
											<td>Maven & Hudson</td>
										</tr>
										<tr style="cursor:pointer;" onmouseover="this.bgColor='#f45b4f'" onMouseOut="this.bgColor='#FFFFFF'" onclick="location.href='http://www.313.co.kr/nexus'">
											<td>4</td>
											<td>artifact&<br>Dependency Mng</td>
											<td>Nexus</td>
										</tr>
										<tr style="cursor:pointer;" onmouseover="this.bgColor='#f45b4f'" onMouseOut="this.bgColor='#FFFFFF'" onclick="location.href='http://www.313.co.kr/bamboo'">
											<td>5</td>
											<td>Continuous Integration</td>
											<td>BAMBOO</td>
										</tr>
										<tr style="cursor:pointer;" onmouseover="this.bgColor='#f45b4f'" onMouseOut="this.bgColor='#FFFFFF'" onclick="location.href='http://www.313.co.kr/sonar'">
											<td>6</td>
											<td>Code Quality Reviews</td>
											<td>Sonar</td>
										</tr>
										<tr style="cursor:pointer;" onmouseover="this.bgColor='#f45b4f'" onMouseOut="this.bgColor='#FFFFFF'" onclick="location.href='http://www.313.co.kr/confluence'">
											<td>7</td>
											<td>Wiki</td>
											<td>Confluence</td>
										</tr>
										<tr style="cursor:pointer;" onmouseover="this.bgColor='#f45b4f'" onMouseOut="this.bgColor='#FFFFFF'" onclick="location.href='http://www.313.co.kr/jira'">
											<td>8</td>
											<td>Issue Tracking</td>
											<td>JIRA</td>
										</tr>
									</tbody>	
								</table>
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
