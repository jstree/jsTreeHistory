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
					<a href="" title="OpenSource Tools"><i class="icon-dashboard"></i>
						<span>OpenSource Grp</span>
					</a>
					<a title="Document" class="submenu" name="Document-sub"><i class="icon-eye-open"></i>
						<span>Document</span>
					</a>
						<div id="Document-sub">
							<a href="http://www.313.co.kr/confluence" target="_blank" title="Confluence"><i class="icon-film"></i><span>  
							Confluence</span></a>
						</div>
						
					<a title="IssueTracker" class="submenu" name="IssueTracker-sub"><i class="icon-eye-open"></i>
						<span>IssueTracker</span>
					</a>
						<div id="IssueTracker-sub">
							<a href="http://www.313.co.kr/jira" target="_blank" title="Jira"><i class="icon-film"></i><span>  
							Jira</span></a>
						</div>
						
					<a title="Repository" class="submenu" name="Repository-sub"><i class="icon-eye-open"></i>
						<span>Repository</span>
					</a>
						<div id="Repository-sub">
							<a href="http://www.313.co.kr/fecru" target="_blank" title="Fisheye & Cruclible"><i class="icon-film"></i><span>  
							Fisheye<br/>Cruclible</span></a>
							<a href="http://www.313.co.kr/nas" target="_blank" title="Xpenology"><i class="icon-film"></i><span>  
							Xpenology</span></a>
						</div>
						
					<a title="Build" class="submenu" name="Build-sub"><i class="icon-eye-open"></i>
						<span>Build</span>
					</a>
						<div id="Build-sub">
							<a href="http://www.313.co.kr/nexus" target="_blank" title="Nexus"><i class="icon-film"></i><span>  
							Nexus</span></a>
							<a href="http://www.313.co.kr/jenkins" target="_blank" title="Jenkins"><i class="icon-film"></i><span>  
							Jenkins</span></a>
							<a href="http://www.313.co.kr/bamboo" target="_blank" title="Bamboo"><i class="icon-film"></i><span>  
							Bamboo</span></a>
						</div>
					
					<a title="Analysis" class="submenu" name="Analysis-sub"><i class="icon-eye-open"></i>
						<span>Analysis</span>
					</a>
						<div id="Analysis-sub">
							<a href="http://www.313.co.kr/php/www313cokr-maven-site/standard-supports/" target="_blank" title="Maven"><i class="icon-film"></i><span>  
							Maven</span></a>
							<a href="http://www.313.co.kr/sonar/" target="_blank" title="Sonar"><i class="icon-film"></i><span>  
							Sonar</span></a>
						</div>
					
					<a title="Database" class="submenu" name="Database-sub"><i class="icon-eye-open"></i>
						<span>Database</span>
					</a>
						<div id="Database-sub">
							<a href="http://www.313.co.kr/oracle" target="_blank" title="Oracle EM"><i class="icon-film"></i><span>  
							Oracle EM</span></a>
							<a href="http://www.313.co.kr/php/phpMyAdmin-3.3.9.2-all-languages" target="_blank" title="phpMyAdmin-3.3.9.2"><i class="icon-film"></i><span>  
							phpMyAdmin-3.3.9.2</span></a>
							<a href="http://www.313.co.kr:8888/phppgadmin/" target="_blank" title="phppPgAdmin"><i class="icon-film"></i><span>  
							phppPgAdmin</span></a>
							<a href="http://www.313.co.kr:8808" target="_blank" title="EFM Networks ipTIME A3004NS"><i class="icon-film"></i><span>  
							EFM Networks ipTIME A3004NS</span></a>
						</div>
						
					<a title="Monitoring" class="submenu" name="Monitoring-sub"><i class="icon-eye-open"></i>
						<span>Monitoring</span>
					</a>
						<div id="Monitoring-sub">
							<a href="http://www.313.co.kr/piwik" target="_blank" title="Piwik"><i class="icon-list"></i><span>  
							Piwik</span></a>
							<a href="analytics.naver.com/" target="_blank" title="Naver analytics"><i class="icon-list"></i><span>  
							Naver analytics</span></a>
							<a href="http://www.google.com/intl/ko/analytics" target="_blank" title="Google analytics"><i class="icon-list"></i><span>  
							Google analytics</span></a>
							<a href="http://www.313.co.kr/php/phpservermon-2.0.1" target="_blank" title="phpservermon-2.0.1"><i class="icon-film"></i><span>  
							phpservermon-2.0.1</span></a>
							<a href="http://www.313.co.kr/probe" target="_blank" title="Probe"><i class="icon-film"></i><span>  
							Probe</span></a>
							<a href="http://www.313.co.kr/php/eXtplorer_2.1.0RC3" target="_blank" title="eXtplorer_2.1.0RC3"><i class="icon-film"></i><span>  
							eXtplorer_2.1.0RC3</span></a>
						</div>
					
						
				</div>
				<!--//Menu-->
			</div>
			<!--//responsive-admin-menu-->
		</div>
		<!-- //responsive-lnb -->
	</body>
</html>
