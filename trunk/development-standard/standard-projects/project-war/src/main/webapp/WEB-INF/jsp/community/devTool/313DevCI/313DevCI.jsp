<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="ko" class="no-js">
<!--<![endif]-->
	<head>
		<style type="text/css">
			table {width:40%; border-top:3px solid #ccc; border-collapse:collapse}
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
								Continuous Integration
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
								<h4>CI(Continuous Integration) 란?</h4>
								<p>개발자가 각각 개발한 소스코드를 모아서 한꺼번에 빌드하는 통합 빌드의 과정을 특정 시점이 아니라 매일이나 매주와 같이 아주 잦은 주기로 수행함으로써 통합에서 발생하는 오류와 시간을 줄이기 위한 기법이다.</p>
								<p>과거에 사람이 소스 통합과 빌드를 하던 작업을 313에서는 오픈소스를 기반으로 한 자동화 툴을 사용하여 사람이 작업하는 도중의 실수를  최소화 한다.</p>
								<div class="div_center">
									<a href="http://nas.313.co.kr:5002/Component/thymeleaf/community/introduce/dev/img/continuous-integration-img.jpg" data-lightbox="image-1">
										<img src="http://nas.313.co.kr:5002/Component/thymeleaf/community/introduce/dev/img/continuous-integration-img.jpg" alt="Continuous Integration" align="left"/>
									</a>
									
									<table summary="313 CI Toll 목록 표입니다.">
									<caption>『  313 CI Toll 목록  』</caption>
									<colgroup>
										<col style="width:10%"/>
										<col style="width:50%"/>
										<col style="width:40%"/>
									</colgroup>
									<thead>
										<tr>
											<th>목록</th>
											<th>설명</th>
											<th>Tool</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>1</td>
											<td>Source Code</td>
											<td>Eclipse</td>
										</tr>
										<tr>
											<td>2</td>
											<td>Version Control System</td>
											<td>SVN (Subversion)</td>
										</tr>
										<tr>
											<td>3</td>
											<td>Source Code Build</td>
											<td>JDK</td>
										</tr>
										<tr>
											<td>4</td>
											<td>Static Code Analysis</td>
											<td></td>
										</tr>
										<tr>
											<td>5</td>
											<td>Run Automated Unit Tests</td>
											<td>JUnit</td>
										</tr>
										<tr>
											<td>6</td>
											<td>Code Coverage Analysis</td>
											<td>PMD, CPD, Checkstyle, Findbugs</td>
										</tr>
										<tr>
											<td>7</td>
											<td>Built Artifact</td>
											<td>Maven</td>
										</tr>
										<tr>
											<td>8</td>
											<td>Set-Up Test Fixtures</td>
											<td>Hudson</td>
										</tr>
										<tr>
											<td>9</td>
											<td>Provision and Deploy to <br>
											     Test Environment</td>
											<td>Hudson</td>
										</tr>
										<tr>
											<td>10</td>
											<td>Run Automates <br>
											     Functional Tests</td>
											<td></td>
										</tr>
										<tr>
											<td>11</td>
											<td>Publish Reports</td>
											<td>Hudson</td>
										</tr>
										<tr>
											<td>12</td>
											<td>Development Team</td>
											<td>313 Dev Group</td>
										</tr>
									</tbody>	
								</table>
								</div>
								<br></br><br></br>
								
								<h4>(1) 소스코드 일관성 유지</h4>
								<p>313은 Subversion사용한다. </p>
								<ol>
								    <li>CI툴을 설정하기 위해서는 기본적으로 소스 관리 시스템이 필요하다.</li>
								    <li>대표적인 소스 관리 시스템은 Subversion,CVS,Perforce등이 있다.</li>
								    <li>CI툴은 이 소스 관리 시스템으로부터 프로젝트 소스의 메인 브랜치(trunk 라고도 한다.) 코드를 Check out 받아서 빌드를 수행한다.</li>
								</ol>
								<h4>(2) 자동 빌드</h4>
								<p>소스 코드에 대한 빌드는 CI툴에 의해서 자동적으로 이루어 져야 한다.  </p>
								<p>빌드가 이루어지는 시점을 정하는 방법이 두가지가 있는데 다음과 같다. </p>
								<p>1) 커밋에 따른 자동 빌드 </p>
								<ol>
								    <li>다른 방법으로는 소스코드가 소스 관리 시스템에 커밋이 되었을 때 마다 CI툴이 이를 감지 하고 자동으로 빌드를 수행하도록 설정할 수 있다.</li>
								    <li>이렇게 설정할 경우 소스 코드의 변경이 있을 때 마다 빌드 작업을 수행하기 때문에 소스 관리 시스템에 저장된 소스 코드에 대한 무결성을 보장하기는 매우 좋지만, 빌드 시간이 길 경우 빌드가 적체 되는 현상이 발생할 수 있다.</li>
								    <li>(일반적으로 대규모 애플리케이션의 FULL 빌드는 길게는 2~3시간 까지 소요될 수 있다.) 그래서 이 방법은 빌드 시간이 오래 걸리는 경우나 커밋이 자주 발생하는 경우에는 적절하지 않다.</li>
								</ol>
								<p>2) 시간 간격에 의한 빌드 </p>
								<ol>
									<li>일정 시간 간격을 정해서 빌드를 하는 방법이다. 매일 5시에 빌드를 한다. 또는 매주 금요일 저녁 5시에 빌드를 한다는 것과 같이 주기를 정할 수 있다. </li>
									<li>빌드 스케쥴이 미리 정해져있기 때문에 개발자들이 커밋에 대한 스케쥴을 관리할 수 있고 빌드 시간이 오래걸리는 대규모 빌드에도 적정하다.</li>
									<li>빌드가 깨진 경우는 컴파일이 실패하였거나 테스트가 통과하지 못하였을 경우인데 이때 소스 관리 시스템에 저장된 코드는 문제가 있는 코드이다.</li>
									<li>CI툴에서는 소스 관리 시스템으로부터 소스를 체크아웃 또는 업데이트 받을 때 Silent Period라는 옵션을 제공한다.</li>
									<li>개발자가 소스를 커밋하고 있을 때 커밋이 완료되지 않은 상태에서 CI툴이 소스를 체크아웃하게 되면 불완전한 코드가 내려와서 빌드가 망가질 수 있다.</li>
									<li>이를 방지하는 옵션이 Silent Period인데, 커밋이 있은후 일정 시간동안 소스 관리 시스템에 변화가 없을 때 CI툴이 체크아웃을 받아서 불완전한 코드를 내려 받을 수 있는 가능성을 최소화 하는 것이다.</li>
									<li>이렇게 자동 빌드를 하면서 얻을 수 있는 이점은, 주기적인 빌드를 통해서 소스코드의 무결성 관리와 빅뱅방식의 통합에서 올 수 있는 리스크를 개발과정 전반으로 분산할 수 있다.</li>
								</ol>									
								<h4>(3) 자동 테스팅</h4>
								<p>빌드 과정에서 테스트를 포함할 수 있는데, 주기적인 빌드 과정에 테스트를 포함해서 자동 빌드를 통한 Syntax에 대한 검증과 더불어 테스팅을 통한 기능과 비기능적(성능등)에 대한 요건을 매번 검증함으로써 코드의 품질에 대한 무결성을 함께 유지한다.</p>
							</div>
						</div>
					</div>
				</div>
			</article>
		</section>
	</body>
</html>
