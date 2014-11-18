<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="ko" class="no-js">
<!--<![endif]-->
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
									<a href="${result.url }" target="_self" class="nav-item ${cssValue }" data-sub-nav="${fn:replace(result.c_title,' ','') }-nav-links"> ${result.c_title } 
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
								<form action="/search" method="get" class="clearfix" novalidate>
									<input type="hidden" name="type" value="product">
									<input type="text" name="q" class="inline-block w-small bm-remove tip-r-fade" placeholder="SEARCH FOR A PRODUCT" autocomplete="off" value="" data-tooltip="Press Enter To Search" />
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
												<a href="${result.url }" target="_self" class="${cssValue2 }"> ${result.c_title }
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
													<a href="${result.url }" target="_self" class="${subCssValue }">&raquo; &nbsp;${result.c_title }</a>
												</li>
											<c:set var="subCssCount" value="${ subCssCount +1}" />
											<c:set var = "count" value = "${count +1 }" />
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
									<div id="${fn:replace(result.c_title,' ','') }-nav-links" class="sub-nav">
								</c:when>
							<c:otherwise>
							<c:choose>
							<c:when test = "${result.c_position == '0' }" >
									<a href="${result.url }" target="_self" class="sub-nav-item first active">${result.c_title }</a>
							</c:when>
							<c:otherwise>
								<a href="${result.url }" target="_self" class="sub-nav-item">${result.c_title }</a>
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
	</body>
</html>
