<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="ko" class="no-js">
<!--<![endif]-->
	<head>
	<link rel="stylesheet" type="text/css" href="http://cdn.datatables.net/1.10.4/css/jquery.dataTables.css"/>
  
	<!-- DataTables -->
	<script type="text/javascript" charset="utf8" src="http://cdn.datatables.net/1.10.4/js/jquery.dataTables.js"></script>
	<style type="text/css">
		table a span{
			display : inline-block;
			width : 100%;
		}
	</style>
	<script type="text/javascript">
		$(document).ready( function () {
		    $('#serverToolList').DataTable({
		    	paging: false,
		    	searching: false,
		        ordering:  false,
		        info: false,
		        "columnDefs": [ {
		            "targets": 0,
		            "width": "50%"
		          },
		          { "targets": 0,
		            "width": "50%"
		          }]
		    });
		} );
	</script>
	</head>
	<body>
		<section class="clearfix" >
			<nav>
				<div class="container bm-medium">
					<div class="one-whole">
						<div class="no-display">article</div>
						<div class="text-center">
							<h1 class="bm-remove">
								313 Server Tools
							</h1>
							<p class="bm-remove">
								<a href="${pageContext.request.contextPath}/" target="_self">Home</a>
								&nbsp;/&nbsp;
								Dev Tools
								&nbsp;/&nbsp;
								Server TOOL
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
									<div class="one-half-percent tablet-mobile bm-remove omega alignleft center-image">
										<a href="/assets/images/community/delTool/313DevServerTool/9872658.png" data-lightbox="image-1">
											<img src="/assets/images/community/delTool/313DevServerTool/9872658.png" alt="Server Tools" />
										</a>
									</div>
									<div class="space-20"></div>
									<a href="#"><span><h4>www.313.co.kr Server Tools</h4></span></a>
									<p>어플리케이션을 개발하면서, 혹은 어플리케이션 서버를 운용하면서 필요한 다양한 레이어별로 수집할 수 있는 데이터를 근거로한</p>
									<p>필수 적인 유틸리티를 모아서 한꺼번에 제공하고 있습니다.</p>
									
									<p>
										<table id="serverToolList" class="display">
									 	    <thead>
										        <tr>
										            <th>분류</th>
										            <th>이름(링크)</th>
										        </tr>
										    </thead>
										    <tbody>
										        <tr>
										            <td>NAS</td>
										            <td><a target="_blank" href="http://www.313.co.kr/nas"><span>Xpenology</span></a></td>
										        </tr>
										        <tr>
										            <td>Web Server HeartBeat Monitor</td>
										            <td><a target="_blank" href="http://www.313.co.kr/php/phpservermon-2.0.1"><span>phpservermon-2.0.1</span></a></td>
										        </tr>
										        <tr>
										            <td>Was Server Monitor</td>
										            <td><a target="_blank" href="http://www.313.co.kr/probe"><span>Probe</span></a></td>
										        </tr>
										        <tr>
										            <td>Net FTP</td>
										            <td><a target="_blank" href="http://www.313.co.kr/php/net2ftp_v0.98/files_to_upload"><span>net2ftp_v0.98</span></a></td>
										        </tr>
										        <tr>
										            <td>Web Hard</td>
										            <td><a target="_blank" href="http://www.313.co.kr/php/ajaxplorer-core-4.2.3"><span>ajaxplorer-core-4.2.3</span></a></td>
										        </tr>
										        <tr>
										            <td>DDNS</td>
										            <td>
										            	<a target="_blank" href="http://www.313.co.kr:9010"><span>DDNS</span></a>
										            </td>
										        </tr>
										        <tr>
										            <td>Analytics I</td>
										            <td><a target="_blank" href="http://www.google.com/intl/ko/analytics"><span>Google analytics</span></a></td>
										        </tr>
										        <tr>
										            <td>Analytics II</td>
										            <td><a target="_blank" href="http://www.313.co.kr/php/analyzer/deeplog"><span>DeepLog</span></a></td>
										        </tr>
										        <tr>
										            <td>Analytics III</td>
										            <td><a target="_blank" href="http://www.313.co.kr/php/analyzer/alterwind"><span>AlterWind</span></a></td>
										        </tr>
										        <tr>
										            <td>Server Log Viewer</td>
										            <td><a target="_blank" href="http://www.313.co.kr/php/eXtplorer_2.1.0RC3"><span>eXtplorer_2.1.0RC3</span></a></td>
										        </tr>
										        <tr>
										            <td>Switch router</td>
										            <td><a target="_blank" href="http://www.313.co.kr:8808"><span>EFM Networks ipTIME A3004NS</span></a></td>
										        </tr>
										        <tr>
										            <td>Mysql</td>
										            <td><a target="_blank" href="http://www.313.co.kr/php/phpMyAdmin-3.3.9.2-all-languages"><span>phpMyAdmin-3.3.9.2</span></a></td>
										        </tr>
										        <tr>
										            <td>Postgres</td>
										            <td><a target="_blank" href="http://www.313.co.kr:8888/phppgadmin/"><span>phppPgAdmin</span></a></td>
										        </tr>
										        <tr>
										            <td>CAS Server</td>
										            <td><a target="_blank" href="https://www.313.co.kr/cas/login"><span>Jasig Central Authentication Service 3.4.12 Server</span></a></td>
										        </tr>
										        <tr>
										            <td>CAS Client</td>
										            <td><a target="_blank" href="https://www.313.co.kr/casClient"><span>Jasig Central Authentication Service 3.4.12 Client</span></a></td>
										        </tr>
										    </tbody>
										</table>
									</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</article>
		</section>
	</body>
</html>
