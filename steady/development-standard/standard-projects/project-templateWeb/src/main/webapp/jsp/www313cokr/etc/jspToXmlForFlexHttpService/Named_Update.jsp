<%@ page language="java" contentType="text/xml; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.naming.*"%>
<%@ page import="javax.sql.DataSource"%>

<%


/****************************************************************************
* @FileName  	: update.jsp
* @Project     	: LeeDongMin 데이터소스
* @Date        	: 2010. 02. 08
* @작성자      	: 이동민
* @변경이력 		:
* @프로그램 설명 	: 쿼리스트링에 따라서 xml 자동생성 및 디비 업데이트
* 수정일      		수정자  	수정내용
* 2010.02.08		이동민	최초 개발.
*****************************************************************************/


/*cache setting*/
/***************************************************/
response.setHeader("Cache-Control","no-store");		// 캐쉬저장하지 않음.
response.setHeader("Pragma", "no-cache");			// 캐쉬 셋팅
response.setDateHeader("Expires", 0);				// 캐쉬파이어
if(request.getProtocol().equals("HTTP/1.1"))		//
response.setHeader("Cache-Control", "no-cache");	// 프로토콜 설정
out.print("<root>");								// 첫 root 태그 display
/***************************************************/


/*query building*/
/***************************************************/
long startTime = System.currentTimeMillis();		// 시작시간 셋팅
request.setCharacterEncoding("utf-8");				// 리퀘스트 엔코딩 셋팅
String sql  	= null;								// 쿼리 스트링 선언
Connection conn = null;								// 커넥션 객체 선언
Statement stmt 	= null;								// 스테이트 객체 선언
int iResult = 0;									// 몇개의 업데이트가 이루어졌는지 확인 하는 갯수
/**************************************************/

try{


	/***************************************************/
	sql = request.getParameter("sql").replaceAll("@", "%");		// 리퀘스트 쿼리 스트링 셋팅
	/***************************************************/


	/***************************************************/
	Class.forName("oracle.jdbc.driver.OracleDriver");			// 드라이버 로드
	Context initCtx = new InitialContext();						// 커넥션 풀 로드 및 셋팅
  	Context envCtx = (Context)initCtx.lookup("java:comp/env");
	DataSource ds =  (DataSource)envCtx.lookup("jdbc/ora");
	/***************************************************/


	/***************************************************/
	conn = ds.getConnection();							// 커넥션 conn 객체 생성
  	stmt = conn.createStatement();						// 스테이트 stmt 객체 생성
  	iResult = stmt.executeUpdate(sql);					// 쿼리 실행후 결과값 로우를 인트형으로 리턴하여 iResult 선언
	/***************************************************/


	/***************************************************/
	if(iResult > 0)		// 결과값이 한개 이상이 있으면 성공 송출
	{
		out.print("<result>success</result>");
		out.print("<result_count>"+iResult+"</result_count>");
	}
	else				// 결과값이 한개 미만이면 실패 송출
	{
		out.print("<result>fail</result>");
	}
	/***************************************************/


}
catch(Exception ex)
{
	System.out.println(ex);
	System.out.println("HttpService update error");
}
finally
{
    if (stmt != null) try { stmt.close(); } catch(SQLException ex) {System.out.println(ex);}
    if (conn != null) try { conn.close(); } catch(SQLException ex) {System.out.println(ex);}
    out.print("</root>");
    System.out.println("HttpService update row=" + iResult);
	System.out.println("HttpService update sql=" + sql);
	System.out.println("HttpService update execution time: " + (System.currentTimeMillis() - startTime));
	System.out.println("-----------------------------------------------------------------------");
}
%>