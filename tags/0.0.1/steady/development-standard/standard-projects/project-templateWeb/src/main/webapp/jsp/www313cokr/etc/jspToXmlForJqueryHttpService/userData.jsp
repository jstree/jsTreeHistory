<?xml version="1.0" encoding="utf-8"?>
<%@ page language="java" contentType="text/xml; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import = "java.sql.*" %>
<%@ page import = "javax.naming.*" %>
<%@ page import = "javax.sql.DataSource" %>
<%@ page import = "java.net.*"%>
<%


/*cache setting*/
/**************************************************/
response.setHeader("Cache-Control","no-store");		// 캐쉬저장하지 않음.
response.setHeader("Pragma", "no-cache");			// 캐쉬 셋팅
response.setDateHeader("Expires", 0);					// 캐쉬파이어
if(request.getProtocol().equals("HTTP/1.1"))			//
response.setHeader("Cache-Control", "no-cache");	// 프로토콜 설정
/**************************************************/


/*query building*/
/***************************************************/
long startTime 	= System.currentTimeMillis();		// 시작시간 선언
request.setCharacterEncoding("utf-8");				// 리퀘스트 엔코딩 셋팅
Connection conn = null;								// 커넥션 객체 선언
Statement stmt 	= null;								// 스테이트 객체 선언
String sql 		= null;									// 쿼리 스트링 선언
/**************************************************/


try{

	/**************************************************/
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Context initCtx = new InitialContext();
  	Context envCtx = (Context)initCtx.lookup("java:comp/env");
	DataSource ds =  (DataSource)envCtx.lookup("jdbc/family");
	/**************************************************/

  	/*time*/
	/**************************************************/
	java.text.SimpleDateFormat formatter=new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
  	java.text.SimpleDateFormat formatter1=new java.text.SimpleDateFormat("yyyy");
  	java.text.SimpleDateFormat formatter2=new java.text.SimpleDateFormat("MM");
  	java.text.SimpleDateFormat formatter3=new java.text.SimpleDateFormat("dd");
  	java.text.SimpleDateFormat formatter4=new java.text.SimpleDateFormat("HH");
  	java.text.SimpleDateFormat formatter5=new java.text.SimpleDateFormat("mm");
  	java.text.SimpleDateFormat formatter6=new java.text.SimpleDateFormat("ss");
  	java.text.SimpleDateFormat formatter7=new java.text.SimpleDateFormat("SS");

  	String fullTime=formatter.format(new java.util.Date());
  	String year=formatter1.format(new java.util.Date());
  	String month=formatter2.format(new java.util.Date());
  	String day=formatter3.format(new java.util.Date());
  	String hour=formatter4.format(new java.util.Date());
  	String min=formatter5.format(new java.util.Date());
  	String sec=formatter6.format(new java.util.Date());
  	String mil=formatter7.format(new java.util.Date());

  	String time=year+"/"+month+"/"+day+"/"+hour+"/"+min+"/"+sec+"/"+mil;
  	/**************************************************/

  	/**************************************************/
  	sql = "INSERT INTO T_LOGTREE VALUES(S_LOGTREE.nextval,0,0,0," ;
  	sql = sql + "0,0,'" + request.getLocalName() + "','default','success','" + request.getRemoteHost() +"','";
  	sql = sql + request.getRequestURI() +"','" + fullTime + "','"+ request.getCharacterEncoding() + "','"+ request.getContentLength() + "','";
  	sql = sql + request.getContentType() +"','" + request.getContextPath() + "','"+ request.getMethod() + "','"+ request.getProtocol() + "','";
  	sql = sql + request.getRemoteAddr() +"','" + request.getRequestURL() + "','"+ request.getServerName() + "','"+ request.getServerPort() + "','";
  	
  	sql = sql + request.getLocalAddr() +"','" + request.getLocale() + "','"+ request.getLocales() + "','"+ request.getLocalName() + "','";
  	
  	sql = sql + request.getLocalPort() +"','" + request.isSecure() + "','"+ request.getScheme() + "','"+ request.getQueryString() + "','";
  	sql = sql + request.getHeader("accept") +"','" + request.getHeader("accept-language") + "','"+ request.getHeader("user-agent") + "','"+ request.getHeader("accept-encoding") + "','";
  	sql = sql + request.getHeader("host") +"','" + request.getHeader("connection") + "','"+ request.getHeader("cookie") + "')";
  	conn = ds.getConnection();
  	stmt = conn.createStatement();
  	int iResult = stmt.executeUpdate(sql);
  	/**************************************************/
    
  	if(iResult == 1)
	{
		if(request.getParameter("type")!=null){
			out.print("<rows>");
			out.print("<page>1</page>");
			out.print("<total>1</total>");
				
				out.print("<row>");
				out.println("<cell><![CDATA[RemoteHost]]></cell>");
				out.println("<cell><![CDATA[" + request.getRemoteHost() + "]]></cell>");
				out.print("</row>");
				
				out.print("<row>");
				out.println("<cell><![CDATA[RequestURI]]></cell>");
				out.println("<cell><![CDATA[" + request.getRequestURI() + "]]></cell>");
				out.print("</row>");
				
				out.print("<row>");
				out.println("<cell><![CDATA[fullTime]]></cell>");
				out.println("<cell><![CDATA[" + fullTime + "]]></cell>");
				out.print("</row>");
				
				out.print("<row>");
				out.println("<cell><![CDATA[CharacterEncoding]]></cell>");
				out.println("<cell><![CDATA[" + request.getCharacterEncoding() + "]]></cell>");
				out.print("</row>");
				
				out.print("<row>");
				out.println("<cell><![CDATA[ContentLength]]></cell>");
				out.println("<cell><![CDATA[" + request.getContentLength() + "]]></cell>");
				out.print("</row>");
				
				out.print("<row>");
				out.println("<cell><![CDATA[ContentType]]></cell>");
				out.println("<cell><![CDATA[" + request.getContentType() + "]]></cell>");
				out.print("</row>");
				
				out.print("<row>");
				out.println("<cell><![CDATA[ContextPath]]></cell>");
				out.println("<cell><![CDATA[" + request.getContextPath() + "]]></cell>");
				out.print("</row>");
				
				out.print("<row>");
				out.println("<cell><![CDATA[Method]]></cell>");
				out.println("<cell><![CDATA[" + request.getMethod() + "]]></cell>");
				out.print("</row>");
				
				out.print("<row>");
				out.println("<cell><![CDATA[Protocol]]></cell>");
				out.println("<cell><![CDATA[" + request.getProtocol() + "]]></cell>");
				out.print("</row>");
				
				out.print("<row>");
				out.println("<cell><![CDATA[RemoteAddr]]></cell>");
				out.println("<cell><![CDATA[" + request.getRemoteAddr() + "]]></cell>");
				out.print("</row>");

				out.print("<row>");
				out.println("<cell><![CDATA[RequestURL]]></cell>");
				out.println("<cell><![CDATA[" + request.getRequestURL() + "]]></cell>");
				out.print("</row>");
				
				out.print("<row>");
				out.println("<cell><![CDATA[ServerName]]></cell>");
				out.println("<cell><![CDATA[" + request.getServerName() + "]]></cell>");
				out.print("</row>");
				
				out.print("<row>");
				out.println("<cell><![CDATA[ServerPort]]></cell>");
				out.println("<cell><![CDATA[" + request.getServerPort() + "]]></cell>");
				out.print("</row>");
			    
				out.print("<row>");
				out.println("<cell><![CDATA[LocalAddr]]></cell>");
				out.println("<cell><![CDATA[" + request.getLocalAddr() + "]]></cell>");
				out.print("</row>");
			    
				out.print("<row>");
				out.println("<cell><![CDATA[Locale]]></cell>");
				out.println("<cell><![CDATA[" + request.getLocale() + "]]></cell>");
				out.print("</row>");

				out.print("<row>");
				out.println("<cell><![CDATA[Locales]]></cell>");
				out.println("<cell><![CDATA[" + request.getLocales() + "]]></cell>");
				out.print("</row>");
				
				out.print("<row>");
				out.println("<cell><![CDATA[LocalName]]></cell>");
				out.println("<cell><![CDATA[" + request.getLocalName() + "]]></cell>");
				out.print("</row>");
			    
				out.print("<row>");
				out.println("<cell><![CDATA[LocalPort]]></cell>");
				out.println("<cell><![CDATA[" + request.getLocalPort() + "]]></cell>");
				out.print("</row>");
				
				out.print("<row>");
				out.println("<cell><![CDATA[isSecure]]></cell>");
				out.println("<cell><![CDATA[" + request.isSecure() + "]]></cell>");
				out.print("</row>");
				
				out.print("<row>");
				out.println("<cell><![CDATA[Scheme]]></cell>");
				out.println("<cell><![CDATA[" + request.getScheme() + "]]></cell>");
				out.print("</row>");

				out.print("<row>");
				out.println("<cell><![CDATA[QueryString]]></cell>");
				out.println("<cell><![CDATA[" + request.getQueryString() + "]]></cell>");
				out.print("</row>");
			    
				out.print("<row>");
				out.println("<cell><![CDATA[accept]]></cell>");
				out.println("<cell><![CDATA[" + request.getHeader("accept") + "]]></cell>");
				out.print("</row>");
			    
				out.print("<row>");
				out.println("<cell><![CDATA[language]]></cell>");
				out.println("<cell><![CDATA[" + request.getHeader("accept-language") + "]]></cell>");
				out.print("</row>");

				out.print("<row>");
				out.println("<cell><![CDATA[user-agent]]></cell>");
				out.println("<cell><![CDATA[" + request.getHeader("user-agent") + "]]></cell>");
				out.print("</row>");
				
				out.print("<row>");
				out.println("<cell><![CDATA[accept-encoding]]></cell>");
				out.println("<cell><![CDATA[" + request.getHeader("accept-encoding") + "]]></cell>");
				out.print("</row>");
			    
				out.print("<row>");
				out.println("<cell><![CDATA[host]]></cell>");
				out.println("<cell><![CDATA[" + request.getHeader("host") + "]]></cell>");
				out.print("</row>");
			    
				out.print("<row>");
				out.println("<cell><![CDATA[connection]]></cell>");
				out.println("<cell><![CDATA[" + request.getHeader("connection") + "]]></cell>");
				out.print("</row>");
			    
				out.print("<row>");
				out.println("<cell><![CDATA[cookie]]></cell>");
				out.println("<cell><![CDATA[" + request.getHeader("cookie") + "]]></cell>");
				out.print("</row>");
			    
	  		out.print("</rows>");
		}else{
			out.print("<root>");
			out.print("<result>success</result>");
			out.print("<post>");

				out.println("<RemoteHost><![CDATA[" + request.getRemoteHost() + "]]></RemoteHost>");
				out.println("<RequestURI><![CDATA[" + request.getRequestURI() + "]]></RequestURI>");
				out.println("<Time><![CDATA[" + fullTime + "]]></Time>");
				out.println("<CharacterEncoding><![CDATA[" + request.getCharacterEncoding() + "]]></CharacterEncoding>");
			    out.println("<ContentLength><![CDATA[" + request.getContentLength() + "]]></ContentLength>");

			    out.println("<ContentType><![CDATA[" + request.getContentType() + "]]></ContentType>");
			    out.println("<ContextPath><![CDATA[" + request.getContextPath() + "]]></ContextPath>");
			    out.println("<Method><![CDATA[" + request.getMethod() + "]]></Method>");
			    out.println("<Protocol><![CDATA[" + request.getProtocol() + "]]></Protocol>");
			    out.println("<RemoteAddr><![CDATA[" + request.getRemoteAddr() + "]]></RemoteAddr>");

			    out.println("<RequestURL><![CDATA[" + request.getRequestURL() + "]]></RequestURL>");
			    out.println("<ServerName><![CDATA[" + request.getServerName() + "]]></ServerName>");
			    out.println("<ServerPort><![CDATA[" + request.getServerPort() + "]]></ServerPort>");
			    
			    out.println("<LocalAddr><![CDATA[" +  request.getLocalAddr() + "]]></LocalAddr>");
			    out.println("<Locale><![CDATA[" +  request.getLocale() + "]]></Locale>");
			    out.println("<Locales><![CDATA[" +  request.getLocales() + "]]></Locales>");
			    out.println("<LocalName><![CDATA[" +  request.getLocalName() + "]]></LocalName>");
			    out.println("<LocalPort><![CDATA[" +  request.getLocalPort() + "]]></LocalPort>");

			    out.println("<isSecure><![CDATA[" +  request.isSecure() + "]]></isSecure>");
			    out.println("<Scheme><![CDATA[" +  request.getScheme() + "]]></Scheme>");
			    out.println("<QueryString><![CDATA[" +  request.getQueryString() + "]]></QueryString>");
			    out.println("<accept><![CDATA[" +  request.getHeader("accept") + "]]></accept>");
			    out.println("<accept-language><![CDATA[" +  request.getHeader("accept-language") + "]]></accept-language>");
			    
			    out.println("<user-agent><![CDATA[" +  request.getHeader("user-agent") + "]]></user-agent>");
			    out.println("<accept-encoding><![CDATA[" +  request.getHeader("accept-encoding") + "]]></accept-encoding>");
			    out.println("<host><![CDATA[" +  request.getHeader("host") + "]]></host>");
			    out.println("<connection><![CDATA[" +  request.getHeader("connection") + "]]></connection>");
			    out.println("<cookie><![CDATA[" +  request.getHeader("cookie") + "]]></cookie>");
			    
			out.print("</post>");
	  		out.print("</root>");
		}
	}
  	else
  	{
  		out.print("<root>");
  		out.print("<result>fail</result>");
  		out.print("</root>");
  	}
  	 
}
catch(Exception ex)
{
	System.out.println(ex);
	System.out.println("HttpService user_info error");
}
finally
{
	if (stmt != null) try { stmt.close(); } catch(SQLException ex) {System.out.println(ex);}
    if (conn != null) try { conn.close(); } catch(SQLException ex) {System.out.println(ex);}
	System.out.println("HttpService user_info sql=" + sql);
	System.out.println("HttpService user_info execution time: " + (System.currentTimeMillis() - startTime));
	System.out.println("-----------------------------------------------------------------------");
}

%>