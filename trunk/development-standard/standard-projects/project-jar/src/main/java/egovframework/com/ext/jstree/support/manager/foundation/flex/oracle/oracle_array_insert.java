package egovframework.com.ext.jstree.support.manager.foundation.flex.oracle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class oracle_array_insert
{
	/**
	 * @return
	 * @Class Name 	: oracle_insert
	 * @작성일   	: 2010. 01. 22
	 * @작성자   	: 이동민
	 * @변경이력     :
	 * @Class 설명  	: BlazeDS Select 클래스 프레임워크
	 * @특이사항		:
	 */

	public int getElements(String[] arr)
	{


		/***************************************************/
		long startTime 	= System.currentTimeMillis();		// 어플리케이션 시작 시간
		ResultSet rs 	= null;								// 결과셋 객체 rs 선언
		Connection con 	= null;								// 커넥션 객체 con 선언
		Statement stmt 	= null;								// 스테이트 객체 stmt 선언
		int iResult = 0;									// 몇개의 업데이트가 이루어졌는지 확인 하는 갯수
		/***************************************************/


		try
		{

			/***************************************************/
			Class.forName("oracle.jdbc.driver.OracleDriver");						// 드라이버 로드
			Context initCtx = new InitialContext();									// 커넥션 풀 설정
			DataSource ds =  (DataSource)initCtx.lookup("java:comp/env/jdbc/ora");
			/***************************************************/


			/***************************************************/
			con = ds.getConnection();							// 커넥션 셋팅
			stmt = con.createStatement();						// 스테이트 셋팅

			for (int i = 0;i<arr.length;i++)
			{
				int iResult_ =0;
				iResult_ = stmt.executeUpdate(arr[i]);
				iResult = iResult + iResult_;
			}


		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if (rs != null) try { rs.close(); } catch(SQLException ex) {System.out.println(ex);}
		    if (stmt != null) try { stmt.close(); } catch(SQLException ex) {System.out.println(ex);}
		    if (con != null) try { con.close(); } catch(SQLException ex) {System.out.println(ex);}
		    //System.out.println("BlazeDSService sql: "+ v_sql);
		    System.out.println("BlazeDSService execution time: "+ (System.currentTimeMillis() - startTime));
		    System.out.println("-----------------------------------------------------------------------");

		}

		return iResult;
	}
}
