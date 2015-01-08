/**
 * @FileName  	: oracle_select.java
 * @Project     : LeeDongMin
 * @Date        : 2010. 01. 22
 * @작성자      	: Administrator
 * @변경이력 	:
 * @프로그램 설명 :
 * ----------------------------------------------
 * 수정일      수정자  수정내용
 * ----------------------------------------------
 */
package egovframework.com.ext.jstree.support.manager.foundation.flex.oracle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class oracle_select {
	/**
	 * @Class Name : oracle_select
	 * @작성일 : 2010. 01. 22
	 * @작성자 : 이동민
	 * @변경이력 :
	 * @Class 설명 : BlazeDS Select 클래스 프레임워크
	 * @특이사항 :
	 */

	public Vector<Hashtable<String, String>> getElements(String v_sql) {

		/***************************************************/
		long startTime = System.currentTimeMillis(); // 어플리케이션 시작 시간
		ResultSet rs = null; // 결과셋 객체 rs 선언
		Connection con = null; // 커넥션 객체 con 선언
		Vector<Hashtable<String, String>> vc = new Vector<Hashtable<String, String>>(); // 벡터
																						// 객체
																						// vc
																						// 선언
		Hashtable<String, String> ht = null; // 헤쉬테이블 row_data 선언
		Statement stmt = null; // 스테이트 객체 stmt 선언
		/***************************************************/

		try {

			/***************************************************/
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 드라이버 로드
			Context initCtx = new InitialContext(); // 커넥션 풀 설정
			DataSource ds = (DataSource) initCtx
					.lookup("java:comp/env/jdbc/family");
			/***************************************************/

			/***************************************************/
			con = ds.getConnection(); // 커넥션 셋팅
			stmt = con.createStatement(); // 스테이트 셋팅
			rs = stmt.executeQuery(v_sql); // 파라미터로 넘겨받은 v_sql 쿼리 빌링
			ResultSetMetaData rsmd = rs.getMetaData(); // 결과셋 메타데이터 메소드 수행
			int numberOfColumns = rsmd.getColumnCount(); // 결과셋 로우갯수 확인
			/***************************************************/

			/***************************************************/
			while (rs.next()) {
				ht = new Hashtable<String, String>(); // 해쉬테이블 초기화
				for (int i = 1; i <= numberOfColumns; i++) {
					if (rs.getString(rsmd.getColumnName(i)) != "null"
							&& rs.getString(rsmd.getColumnName(i)) != null) { // value
																				// 가
																				// null
																				// 이
																				// 아닌경우의
																				// 설정
						ht.put(rsmd.getColumnName(i),
								rs.getString(rsmd.getColumnName(i))); // 헤쉬
																		// 데이터셋팅
					}
				}
				vc.add(ht); // 벡터에 헤쉬데이터 add
			}
			/***************************************************/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
					System.out.println(ex);
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException ex) {
					System.out.println(ex);
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException ex) {
					System.out.println(ex);
				}
			System.out.println("BlazeDSService sql: " + v_sql);
			System.out.println("BlazeDSService execution time: "
					+ (System.currentTimeMillis() - startTime));
			System.out
					.println("-----------------------------------------------------------------------");
		}

		return vc;
	}
}