<%@ page language="java" contentType="text/xml; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.naming.*"%>
<%@ page import="javax.sql.DataSource"%>

<%
/****************************************************************************
* @FileName  	: user_info.jsp
* @Project     	: LeeDongMin 데이터소스
* @Date        	: 2010. 02. 08
* @작성자      	: 이동민
* @변경이력 		:
* @프로그램 설명 	: 쿼리스트링에 따라서 xml 자동생성
* 수정일      		수정자  	수정내용
* 2010.02.08		이동민	최초 개발.
*****************************************************************************/

/*cache setting*/
/**************************************************/
response.setHeader("Cache-Control","no-store");		// 캐쉬저장하지 않음.
response.setHeader("Pragma", "no-cache");			// 캐쉬 셋팅
response.setDateHeader("Expires", 0);				// 캐쉬파이어
if(request.getProtocol().equals("HTTP/1.1"))		//
response.setHeader("Cache-Control", "no-cache");	// 프로토콜 설정
out.print("<root>");								// 첫 root 태그 display
/**************************************************/


/*query building*/
/***************************************************/
long startTime 	= System.currentTimeMillis();		// 시작시간 선언
request.setCharacterEncoding("utf-8");				// 리퀘스트 엔코딩 셋팅
Connection conn = null;								// 커넥션 객체 선언
Statement stmt 	= null;								// 스테이트 객체 선언
String sql 		= null;								// 쿼리 스트링 선언
/**************************************************/


try{

	/**************************************************/
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Context initCtx = new InitialContext();
  	Context envCtx = (Context)initCtx.lookup("java:comp/env");
	DataSource ds =  (DataSource)envCtx.lookup("jdbc/ora");
	/**************************************************/


	/**************************************************/
  	StringBuffer requestURL = request.getRequestURL();		//
  	String requestURI = request.getRequestURI();			//
  	String Remote_User = request.getLocale().toString();	//사용자국가
  	String Protocol = request.getProtocol();				//프로토콜
  	String Remote_IP = request.getRemoteAddr();				//사용자 아이피
  	String Remote_Host = request.getRemoteHost();			//사용자 호스트
  	String Server_Name = request.getServerName();			//서버이름
  	String method = request.getMethod(); 					//넘기는 방식
  	String Scheme = request.getScheme();					//요청스키마
  	/**************************************************/

  	/*time*/
	/**************************************************/
  	java.text.SimpleDateFormat formatter1=new java.text.SimpleDateFormat("yyyy");
  	java.text.SimpleDateFormat formatter2=new java.text.SimpleDateFormat("MM");
  	java.text.SimpleDateFormat formatter3=new java.text.SimpleDateFormat("dd");
  	java.text.SimpleDateFormat formatter4=new java.text.SimpleDateFormat("HH");
  	java.text.SimpleDateFormat formatter5=new java.text.SimpleDateFormat("mm");
  	java.text.SimpleDateFormat formatter6=new java.text.SimpleDateFormat("ss");
  	java.text.SimpleDateFormat formatter7=new java.text.SimpleDateFormat("SS");

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
  	sql = "INSERT INTO LOG VALUES(log_count.nextval,'',''," ;
  	sql = sql + "'" + Remote_IP + "','" + Remote_Host + "','" + Server_Name + "','" + method + "','" + Remote_User + "','" + requestURL + "','" + requestURI +"',";
  	sql = sql + "'" + time +"','" +Protocol+ "','" +Scheme+ "',";
  	sql = sql + "sysdate,'','','','',";
  	sql = sql + "'','','','','', '','','','','')";
  	conn = ds.getConnection();
  	stmt = conn.createStatement();
  	int iResult = stmt.executeUpdate(sql);
  	/**************************************************/

  	if(iResult == 1)
	{

			out.print("<result>success</result>");

			out.print("<post>");

				out.print("<ip>");
				out.print(Remote_IP);
				out.print("</ip>");

				out.print("<host>");
				out.print(Remote_Host);
				out.print("</host>");

				out.print("<name>");
				out.print(Server_Name);
				out.print("</name>");

				out.print("<method>");
				out.println(method);
				out.print("</method>");

				out.print("<user>");
				out.println(Remote_User);
				out.print("</user>");

				out.print("<url>");
				out.println(requestURL);
				out.print("</url>");

				out.print("<uri>");
				out.println(requestURI);
				out.print("</uri>");

				out.print("<time>");
				out.println(time);
				out.print("</time>");

				out.print("<Protocol>");
				out.println(Protocol);
				out.print("</Protocol>");

				out.print("<Scheme>");
				out.println(Scheme);
				out.print("</Scheme>");

			out.print("</post>");

	}
  	else
  	{
  		out.print("<result>fail</result>");
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
	out.print("</root>");
}

%>