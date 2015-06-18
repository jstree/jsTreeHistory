<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="ko" class="no-js">
	<head></head>
	<body>
		<nav class="clearfix">
			<div class="container bm-larger">
				<div id="navigation" class="clearfix">
				
					<!-- For PC Menu -->
					<div id="click-nav" class="clearfix">
						<c:forEach items="${menuList }" var = "result" varStatus="status">
								<c:if test="${result.c_level == '2' }">
									<c:choose>
										<c:when test="${result.c_type == 'default' }">
											<c:set var="cssValue" value="first active" />
										</c:when>
										<c:otherwise>
											<c:set var="cssValue" value="has-dropdown" />
										</c:otherwise>
									</c:choose>
									<a href="${pageContext.request.contextPath}${result.url }" target="_self" class="nav-item ${cssValue }" data-sub-nav="nav-links-${result.c_id}"> ${result.c_title } 
										<c:if test="${result.c_type == 'folder' }">
											<span class="has-dropdown-icon">+</span>
										</c:if>
									</a>
								</c:if>
							</c:forEach>
					</div>
					
					<!-- For Mobile Menu -->
					<div id="touch-nav">
						<a href="#" target="_self" class="toggle-icon text-center"><i
							class="fa fa-bars fa-fw"></i></a>
						<div class="slide-menu">
							<hr class="bm-small" />
							<div id="touch-nav-search">
								<form action="${pageContext.request.contextPath}/search" method="get" class="clearfix" novalidate>
									<input type="hidden" name="type" value="product">
									<input type="text" name="q" class="inline-block w-small bm-remove tip-r-fade" placeholder="KEYWORD SEARCH" autocomplete="off" value="" data-tooltip="Press Enter To Search" />
									<button type="submit" class="tablet-mobile bm-remove tip-r-fade" data-tooltip="Search">
									<i class="fa fa-search"></i>
									</button>
								</form>
							</div>
							<hr class="bm-smaller tm-small" />
							<ul class="nav unstyled bm-remove clearfix">
								<c:set var = "count" value = "1" />
									<c:forEach items = "${menuList }" var = "result" varStatus="status">
										<c:choose>
										<c:when test="${status.first}">
											<c:set var="cssValue" value="first active" />
											<c:set var="cssValue2" value="parent-link" />
										</c:when>
										<c:otherwise>
											<c:set var="cssValue" value="has-dropdown" />
											<c:set var="cssValue2" value="parent-link" />
										</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${result.c_level == '2' }">
												<c:if test = "${count ne '1' }" >
													<c:if test = "${count ne '0' }">
													</ul>
													</c:if>
													</li>
												</c:if>
												<c:set var="subCssCount" value="0" />
												<c:if test = "${cssValue == 'has-dropdown'}">
												<hr class="bm-smaller" />
												</c:if>
												<li class="nav-item  ${cssValue }">
													<a href="${pageContext.request.contextPath}${result.url }" target="_self" class="${cssValue2 }"> ${result.c_title }
														<c:if test="${result.c_type == 'folder' }">
															<span class="has-dropdown-icon float-right">+</span>
														</c:if>
													</a>
													<c:if test="${result.c_type == 'folder' }">
													<ul class="sub-nav unstyled bm-remove">
													</c:if>
													<c:set var="subCssCount" value="0" />
													<c:set var = "count" value = "0" />
											</c:when>
											<c:otherwise>
												<c:choose>
												<c:when test = "${subCssCount == 0}">
													<c:set var = "subCssValue" value = " first active" />
												</c:when>
												<c:otherwise>
													<c:set var = "subCssValue" value = "" />
												</c:otherwise>
												</c:choose>
													<li class="sub-nav-item${subCssValue }">
														<a href="${pageContext.request.contextPath}${result.url }" target="_self" class="${subCssValue }">&raquo; &nbsp;${result.c_title }</a>
													</li>
												<c:set var="subCssCount" value="${ subCssCount +1}" />
												<c:set var = "count" value = "${count +2 }" />
											</c:otherwise>
										</c:choose>
									</c:forEach>
									</ul>
									</li>
							</ul>
						</div>
					</div>
				</div>
				
				<!-- PC Version Submenus -->
				<div id="secondary-navigation" class="clearfix">
					<c:set var="count" value="1" />
						<c:forEach items="${menuList }" var = "result" varStatus="status">
							<c:choose>
								<c:when test = "${result.c_level == 2 }">
									<c:if test = "${count ne '1' }" >
									</div>
									</c:if>
									<c:set var="count" value="0" />
									<div id="nav-links-${result.c_id}" class="sub-nav">
								</c:when>
							<c:otherwise>
							<c:choose>
							<c:when test = "${result.c_position == '0' }" >
									<a href="${pageContext.request.contextPath}${result.url }" target="_self" class="sub-nav-item first active">${result.c_title }</a>
							</c:when>
							<c:otherwise>
								<a href="${pageContext.request.contextPath}${result.url }" target="_self" class="sub-nav-item">${result.c_title }</a>
							</c:otherwise>
							</c:choose>
							<c:set var="count" value="${count } +1" />
							</c:otherwise>
							</c:choose>
						</c:forEach>
				</div>
			</div>
		</nav>
		<noscript>
			<div class="container bm-larger tm-larger text-center">
				<div id="no-script">
					<p class="bm-smaller">
						<strong>JavaScript Disabled</strong>
					</p>
					<p class="bm-smaller">Certain features of this site may not function correctly without JavaScript enabled</p>
					<p class="bm-remove">
						<a href="http://enable-javascript.com/" target="_blank">Find
						out how to enable JavaScript in your browser</a>
					</p>
				</div>
			</div>
		</noscript>	
		
		
		<!-- 우선급한대로 붙였음 차후 별도 파일로 관리 혹은 처리예정  -->
		<div id="responsive-lnb">
			<!--responsive-admin-menu-->
			<div id="responsive-admin-menu" class="responsiveLnb">
				<div id="responsive-menu">Dwsee Responsive Admin Menu
					<div class="menuicon">≡</div>
				</div>
				
				<div id="logo"></div>
			
				<!--Menu-->
				<div id="menu">
						<a href="" title="313 Dev Gro"><i class="icon-dashboard"></i><span> 
						313 Dev Grp</span></a>
						<a title="NAS" class="submenu" name="nas-sub"><i class="icon-eye-open"></i><span>  
						NAS</span></a>
						<!-- NAS Sub Menu -->
							<div id="nas-sub">
								<a href="http://www.313.co.kr/nas" target="_blank" title="Xpenology"><i class="icon-film"></i><span>  
								Xpenology</span></a>
							</div>
						<!-- NAS Sub Menu -->
						
						<a title="Web Server HeartBeat Monitor" class="submenu" name="HeartBeat-sub"><i class="icon-eye-open"></i><span>  
						Web Server HeartBeat Monitor</span></a>
						<!-- Web Server HeartBeat Monitor Sub Menu -->
							<div id="HeartBeat-sub">
								<a href="http://www.313.co.kr/php/phpservermon-2.0.1" target="_blank" title="phpservermon-2.0.1"><i class="icon-film"></i><span>  
								phpservermon-2.0.1</span></a>
							</div>
						<!-- Web Server HeartBeat Monitor Sub Menu -->
						
						<a title="Was Server Monitor" class="submenu" name="Monitor-sub"><i class="icon-eye-open"></i><span>  
						Was Server Monitor</span></a>
						<!-- Was Server Monitor Sub Menu -->
							<div id="Monitor-sub">
								<a href="http://www.313.co.kr/probe" target="_blank" title="Probe"><i class="icon-film"></i><span>  
								Probe</span></a>
							</div>
						<!-- Was Server Monitor Sub Menu -->
						
						<a title="Net FTP" class="submenu" name="FTP-sub"><i class="icon-eye-open"></i><span>  
						Net FTP</span></a>
						<!-- Net FTP Sub Menu -->
							<div id="FTP-sub">
								<a href="http://www.313.co.kr/php/net2ftp_v0.98/files_to_upload" target="_blank" title="net2ftp_v0.98"><i class="icon-film"></i><span>  
								net2ftp_v0.98</span></a>
							</div>
						<!-- Net FTP Sub Menu -->
						
						<a title="Web Hard" class="submenu" name="FTP-sub"><i class="icon-eye-open"></i><span>  
						Web Hard</span></a>
						<!-- Net FTP Sub Menu -->
							<div id="FTP-sub">
								<a href="http://www.313.co.kr/php/ajaxplorer-core-4.2.3" target="_blank" title="ajaxplorer-core-4.2.3"><i class="icon-film"></i><span>  
								ajaxplorer-core-4.2.3</span></a>
							</div>
						<!-- Net FTP Sub Menu -->
						
						<a class="submenu" name="Analytics-sub" title="Analytics"><i class="icon-book"></i><span> 
						Analytics</span></a>
						<!-- Analytics Sub Menu -->
							<div id="Analytics-sub">
								<a href="http://www.google.com/intl/ko/analytics" target="_blank" title="Google analytics"><i class="icon-list"></i><span>  
								Google analytics</span></a>
								<a href="http://www.313.co.kr/php/analyzer/deeplog" target="_blank" title="DeepLog"><i class="icon-list-ul"></i><span>  
								DeepLog</span></a>
								<a href="http://www.313.co.kr/php/analyzer/alterwind" target="_blank" title="AlterWind"><i class="icon-map-marker"></i><span>  
								AlterWind</span></a>
							</div>
						<!-- Analytics Sub Menu -->
						
						<a title="Server Log Viewer" class="submenu" name="Viewer-sub"><i class="icon-eye-open"></i><span>  
						Server Log Viewer</span></a>
						<!-- Server Log Viewer Sub Menu -->
							<div id="Viewer-sub">
								<a href="http://www.313.co.kr/php/eXtplorer_2.1.0RC3" target="_blank" title="eXtplorer_2.1.0RC3"><i class="icon-film"></i><span>  
								eXtplorer_2.1.0RC3</span></a>
							</div>
						<!-- Server Log Viewer Sub Menu -->
						
						<a title="Switch router" class="submenu" name="router-sub"><i class="icon-eye-open"></i><span>  
						Switch router</span></a>
						<!-- Switch router Sub Menu -->
							<div id="router-sub">
								<a href="http://www.313.co.kr:8808" target="_blank" title="EFM Networks ipTIME A3004NS"><i class="icon-film"></i><span>  
								EFM Networks ipTIME A3004NS</span></a>
							</div>
						<!-- Switch router Sub Menu -->
						
						<a title="Mysql" class="submenu" name="Mysql-sub"><i class="icon-eye-open"></i><span>  
						Mysql</span></a>
						<!-- Mysql Sub Menu -->
							<div id="Mysql-sub">
								<a href="http://www.313.co.kr/php/phpMyAdmin-3.3.9.2-all-languages" target="_blank" title="phpMyAdmin-3.3.9.2"><i class="icon-film"></i><span>  
								phpMyAdmin-3.3.9.2</span></a>
							</div>
						<!-- Mysql Sub Menu -->
						
						<a title="Postgres" class="submenu" name="Postgres-sub"><i class="icon-eye-open"></i><span>  
						Postgres</span></a>
						<!-- Postgres Sub Menu -->
							<div id="Postgres-sub">
								<a href="http://www.313.co.kr:8888/phppgadmin/" target="_blank" title="phppPgAdmin"><i class="icon-film"></i><span>  
								phppPgAdmin</span></a>
							</div>
						<!-- Postgres Sub Menu -->
						
						<a title="산출물 관리 및 위키" class="submenu" name="wiki-sub"><i class="icon-eye-open"></i><span>  
						산출물 관리 및 위키</span></a>
						<!-- 산출물 관리 및 위키 Sub Menu -->
							<div id="wiki-sub">
								<a href="http://www.313.co.kr/confluence" target="_blank" title="Confluence"><i class="icon-film"></i><span>  
								Confluence</span></a>
							</div>
						<!-- 산출물 관리 및 위키 Sub Menu -->
						
						<a title="이슈 관리" class="submenu" name="issue-sub"><i class="icon-eye-open"></i><span>  
						이슈 관리</span></a>
						<!-- Jira Sub Menu -->
							<div id="issue-sub">
								<a href="http://www.313.co.kr/jira" target="_blank" title="Jira"><i class="icon-film"></i><span>  
								Jira</span></a>
							</div>
						<!-- Jira Sub Menu -->
						
						<a title="리뷰" class="submenu" name="fecru-sub"><i class="icon-eye-open"></i><span>  
						리뷰</span></a>
						<!-- fecru Sub Menu -->
							<div id="fecru-sub">
								<a href="http://www.313.co.kr/fecru" target="_blank" title="Fisheye & Cruclible"><i class="icon-film"></i><span>  
								Fisheye & Cruclible</span></a>
							</div>
						<!-- fecru Sub Menu -->
						
						<a title="소스코드 일관성 유지" class="submenu" name="svn-sub"><i class="icon-eye-open"></i><span>  
						소스코드 일관성 유지</span></a>
						<!-- SvnWebClient Sub Menu -->
							<div id="svn-sub">
								<a href="http://www.313.co.kr/svnwebclient/" target="_blank" title="SvnWebClient"><i class="icon-film"></i><span>  
								SvnWebClient</span></a>
							</div>
						<!-- SvnWebClient Sub Menu -->
						
						<a title="자동 빌드" class="submenu" name="maven-sub"><i class="icon-eye-open"></i><span>  
						자동 빌드</span></a>
						<!-- maven Sub Menu -->
							<div id="maven-sub">
								<a href="http://www.313.co.kr/php/www313cokr-maven-site/standard-supports/" target="_blank" title="Maven"><i class="icon-film"></i><span>  
								Maven</span></a>
							</div>
						<!-- maven Sub Menu -->
						
						<a title="빌드" class="submenu" name="build-sub"><i class="icon-eye-open"></i><span>  
						빌드</span></a>
						<!-- build Sub Menu -->
							<div id="build-sub">
								<a href="http://www.313.co.kr/hudson" target="_blank" title="Hudson"><i class="icon-film"></i><span>  
								Maven</span></a>
								<a href="http://www.313.co.kr/jenkins" target="_blank" title="Jenkins"><i class="icon-film"></i><span>  
								Jenkins</span></a>
							</div>
						<!-- build Sub Menu -->
						
						<a title="라이브러리 관리" class="submenu" name="nexus-sub"><i class="icon-eye-open"></i><span>  
						라이브러리 관리</span></a>
						<!-- SvnWebClient Sub Menu -->
							<div id="nexus-sub">
								<a href="http://www.313.co.kr/nexus" target="_blank" title="Nexus"><i class="icon-film"></i><span>  
								Nexus</span></a>
							</div>
						<!-- Nexus Sub Menu -->
						
						<a title="빌드 통합 관리" class="submenu" name="bamboo-sub"><i class="icon-eye-open"></i><span>  
						빌드 통합 관리</span></a>
						<!-- bamboo Sub Menu -->
							<div id="bamboo-sub">
								<a href="http://www.313.co.kr/bamboo" target="_blank" title="Bamboo"><i class="icon-film"></i><span>  
								Bamboo</span></a>
							</div>
						<!-- bamboo Sub Menu -->
						
						<a title="자동 테스팅" class="submenu" name="sonar-sub"><i class="icon-eye-open"></i><span>  
						자동 테스팅</span></a>
						<!-- sonar Sub Menu -->
							<div id="sonar-sub">
								<a href="http://www.313.co.kr/sonar/" target="_blank" title="Sonar"><i class="icon-film"></i><span>  
								Sonar</span></a>
							</div>
						<!-- sonar Sub Menu -->
						
				</div>
				<!--//Menu-->
			</div>
			<!--//responsive-admin-menu-->
		</div>
		<!-- //responsive-lnb -->
	</body>
</html>
