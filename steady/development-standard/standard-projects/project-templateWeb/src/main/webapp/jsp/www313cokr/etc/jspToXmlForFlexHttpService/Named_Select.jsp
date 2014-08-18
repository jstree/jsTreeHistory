<%@ page language="java" contentType="text/xml; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.naming.*"%>
<%@ page import="javax.sql.DataSource"%>

<%


/****************************************************************************
* @FileName  	: select.jsp
* @Project     	: LeeDongMin 데이터소스
* @Date        	: 2010. 02. 08
* @작성자      	: 이동민
* @변경이력 		:
* @프로그램 설명 	: 쿼리스트링에 따라서 xml 자동생성
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
ResultSet rs 	= null;								// 결과셋 객체 선언
Connection conn = null;								// 커넥션 객체 선언
Statement stmt 	= null;								// 스테이트 객체 선언
/**************************************************/


try{


	/***************************************************/
	sql = request.getParameter("sql");					// 리퀘스트 쿼리 스트링 셋팅
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
	rs = stmt.executeQuery(sql);						// 쿼리 실행후 결과셋 rs 객체 생성
	ResultSetMetaData rsmd = rs.getMetaData();			// 결과셋으로 부터 메타데이터 rsmd 객체 생성
	/***************************************************/


	/***************************************************/
	int numberOfColumns = rsmd.getColumnCount();		// 결과셋 메터데이터 rsmd 의 getColumnCount메소드 실행
	int numberOfRows = 0;								// 이 ResultSet 오브젝트의 열수를 돌려줍니다.
	/***************************************************/


	/***************************************************/
	if ( numberOfColumns < 1 )					// 오브젝트의 로우가 1개 이하이면 결과 fail 송출
	{
		out.print("<result>fail</result>");
	}
	else										// 오브젝트의 로우가 1개 이상이면 결과 셋 송출
	{
		out.print("<result>success</result>");	// 기본 결과에 대한 엘리먼트 송출
		while(rs.next())						// 결과셋 makeing
		{
			out.print("<post>");				// 결과셋 포스트 엘리먼트 선언
			for(int i=1; i<= numberOfColumns;i++)
			{
				out.print("<"+rsmd.getColumnName(i)+">");				// 결과셋의 컬럼네임 셋팅 ( 엘리먼트 )

				if(rs.getString(rsmd.getColumnName(i)) != "null" && rs.getString(rsmd.getColumnName(i)) != null)
				{	// 결과값이 널이거나, null 인경우 배제
					out.print(rs.getString(rsmd.getColumnName(i))); 	// 결과값이 있는 경우만 value를 print
				}

				out.print("</"+rsmd.getColumnName(i)+">"); 				// 결과셋의 컬럼네임 셋팅 ( 엘리먼트 ) end
			}
			out.print("</post>");
			numberOfRows++;
		}
	}
	out.print("<rowcount>"+numberOfRows+"</rowcount>");					// 결과값 갯수 셋팅
	/***************************************************/


}
catch(Exception ex)
{
	System.out.println(ex);												//익셉션 처리
	System.out.println("HttpService select error");
}
finally
{
	// 파이널리 처리
	if (rs != null) try { rs.close(); } catch(SQLException ex) {System.out.println(ex);}
    if (stmt != null) try { stmt.close(); } catch(SQLException ex) {System.out.println(ex);}
    if (conn != null) try { conn.close(); } catch(SQLException ex) {System.out.println(ex);}
    out.print("</root>");
	System.out.println("HttpService sql=" + sql);
	System.out.println("HttpService execution time: " + (System.currentTimeMillis() - startTime));
	System.out.println("-----------------------------------------------------------------------");
}
%>