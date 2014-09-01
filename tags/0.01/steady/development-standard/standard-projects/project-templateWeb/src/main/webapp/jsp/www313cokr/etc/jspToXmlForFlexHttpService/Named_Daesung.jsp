<%@ page language="java" contentType="text/xml; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.naming.*"%>
<%@ page import="javax.sql.DataSource"%>

<%
	/*cache setting*/
	/**************************************************/
	response.setHeader("Cache-Control","no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
	if(request.getProtocol().equals("HTTP/1.1"))
		response.setHeader("Cache-Control", "no-cache");
	/**************************************************/

	Class.forName("oracle.jdbc.driver.OracleDriver");
	/*database setting*/
	/**************************************************/
	//String jdbcDriver ="jdbc:oracle:thin:@127.0.0.1:1521:xe";
  	//String dbUser = "313";
  	//String dbPass = "love0618";

  	//Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "313", "love0618");
  	/**************************************************/
  	long startTime = System.currentTimeMillis();
	Context initCtx = new InitialContext();
  	Context envCtx = (Context)initCtx.lookup("java:comp/env");
	DataSource ds =  (DataSource)envCtx.lookup("jdbc/ora");
	Connection conn = null;
	conn = ds.getConnection();
	Statement stmt = conn.createStatement();
	/*query building*/
	/**************************************************/
	request.setCharacterEncoding("utf-8");
  	String s_sql  = request.getParameter("sql");
  	/**************************************************/

	/**
	1. 날짜 받으시고
	2. 첫번째 sql = 	통계부분의 구분자를 가져온다.
					select * from daesung_hr_sort where unique_num =
					any(
					select unique_num from daesung_hr_sort where sml_num = 9 and detail_num = 9)
					order by unique_num
	3. 해당 쿼리의 결과 로우를 바탕으로 루프를 돌린다.
	4. 루프를 돌리믄서...합계값을 찾아 도출하고.
	5. 디비에 값을 입력한다.

	6. 여러개의 구분자로 나눠진 합집합은 새로운 로직을 통해서 돌린다. 예를 들어 대구의 경우이다.
	**/




	try{
	out.print("<root>");

	int rs_cnt_1 = 0;
	int rs_cnt_2 = 0;
	int rs_cnt_3 = 0;
	int rs_cnt_5 = 0;
	int rs_cnt_6 = 0;


	String sql_1;
	sql_1 = "select * from daesung_hr where detail_sort_num = any( ";
	sql_1 += "select unique_num from daesung_hr_sort where big_num = 1";
	sql_1 += "minus ";
	sql_1 += "select unique_num from daesung_hr_sort where big_num = 1 and sml_num = 0 and detail_num = 0 ";
	sql_1 += "minus ";
	sql_1 += "select unique_num from daesung_hr_sort where big_num = 1 and sml_num = 9 and detail_num = 9) ";
	sql_1 += "and data_date = '"+s_sql+"'";

	ResultSet rs_1 = stmt.executeQuery(sql_1);
	while(rs_1.next())
	{
			rs_cnt_1++;
	}
	////////////////////////////////////////////////////////////////////////////
	String sql_2;
	sql_2 = "select * from daesung_hr where detail_sort_num = any( ";
	sql_2 += "select unique_num from daesung_hr_sort where big_num = 2";
	sql_2 += "minus ";
	sql_2 += "select unique_num from daesung_hr_sort where big_num = 2 and sml_num = 0 and detail_num = 0 ";
	sql_2 += "minus ";
	sql_2 += "select unique_num from daesung_hr_sort where big_num = 2 and sml_num = 9 and detail_num = 9) ";
	sql_2 += "and data_date = '"+s_sql+"'";

	ResultSet rs_2 = stmt.executeQuery(sql_2);
	while(rs_2.next())
	{
			rs_cnt_2++;
	}
	////////////////////////////////////////////////////////////////////////////
	String sql_3;
	sql_3 = "select * from daesung_hr where detail_sort_num = any( ";
	sql_3 += "select unique_num from daesung_hr_sort where big_num = 3";
	sql_3 += "minus ";
	sql_3 += "select unique_num from daesung_hr_sort where big_num = 3 and sml_num = 0 and detail_num = 0 ";
	sql_3 += "minus ";
	sql_3 += "select unique_num from daesung_hr_sort where big_num = 3 and sml_num = 9 and detail_num = 9) ";
	sql_3 += "and data_date = '"+s_sql+"'";

	ResultSet rs_3 = stmt.executeQuery(sql_3);
	while(rs_3.next())
	{
			rs_cnt_3++;
	}
	////////////////////////////////////////////////////////////////////////////
	String sql_5;
	sql_5 = "select * from daesung_hr where detail_sort_num = any( ";
	sql_5 += "select unique_num from daesung_hr_sort where big_num = 5";
	sql_5 += "minus ";
	sql_5 += "select unique_num from daesung_hr_sort where big_num = 5 and sml_num = 0 and detail_num = 0 ";
	sql_5 += "minus ";
	sql_5 += "select unique_num from daesung_hr_sort where big_num = 5 and sml_num = 9 and detail_num = 9) ";
	sql_5 += "and data_date = '"+s_sql+"'";

	ResultSet rs_5 = stmt.executeQuery(sql_5);
	while(rs_5.next())
	{
			rs_cnt_5++;
	}
	////////////////////////////////////////////////////////////////////////////
	String sql_6;
	sql_6 = "select * from daesung_hr where detail_sort_num = any( ";
	sql_6 += "select unique_num from daesung_hr_sort where big_num = 6";
	sql_6 += "minus ";
	sql_6 += "select unique_num from daesung_hr_sort where big_num = 6 and sml_num = 0 and detail_num = 0 ";
	sql_6 += "minus ";
	sql_6 += "select unique_num from daesung_hr_sort where big_num = 6 and sml_num = 9 and detail_num = 9) ";
	sql_6 += "and data_date = '"+s_sql+"'";

	ResultSet rs_6 = stmt.executeQuery(sql_6);

	while(rs_6.next())
	{
			rs_cnt_6++;
	}



	if(rs_cnt_1 > 0 && rs_cnt_2 > 0 && rs_cnt_3 > 0 && rs_cnt_5 > 0 && rs_cnt_6 > 0)
	{
	out.print("<result>");
  	String base_sql;
	base_sql = "delete from daesung_hr where detail_sort_num = ";
	base_sql += "any( ";
	base_sql += "select unique_num from daesung_hr_sort where sml_num = 9 and detail_num = 9) ";
	base_sql += "and data_date = '" + s_sql + "'";
	stmt.executeUpdate(base_sql);


	String sql;
	sql = "select * from daesung_hr_sort where unique_num = ";
	sql += "any( ";
	sql += "select unique_num from daesung_hr_sort where sml_num = 9 and detail_num = 9) ";
	sql += "order by unique_num";

	ResultSet rs = stmt.executeQuery(sql);
	ResultSetMetaData rsmd = rs.getMetaData();
	int numberOfColumns = rsmd.getColumnCount();

	String v_sql;
	int check_sum_number = 0;


	String [] arr_sql = new String[11];
	String [] adr_num = new String[11];
	String []  big_center_nameing = new String[11];
	String []  mid_center_nameing = new String[11];
	String []  big_center = new String[11];
	String []  mid_center = new String[11];
	String []  center_name = new String[11];
	while(rs.next())
	{

	v_sql = "select ";
	v_sql += "sum(to_num) as to_num, ";
	v_sql += "sum(master_num) as master_num, ";
	v_sql += "sum(sv_num) as sv_num, ";
	v_sql += "sum(qa_num) as qa_num, ";
	v_sql += "sum(etc_num) as etc_num, ";
	v_sql += "sum(client_num) as client_num, ";
	v_sql += "sum(total_num) as total_num, ";
	v_sql += "sum(prvday_vs) as prvday_vs, ";
	v_sql += "sum(today_vs) as today_vs, ";
	if (check_sum_number == 0){v_sql += "round(sum(total_num)/160*100,1) as working_rate ";}
	else if (check_sum_number == 1){v_sql += "round(sum(total_num)/190*100,1) as working_rate ";}
	else if (check_sum_number == 3){v_sql += "round(sum(total_num)/480*100,1) as working_rate ";}
	else {v_sql += "round(sum(total_num)/sum(to_num)*100,1) as working_rate ";}

	v_sql += "from daesung_hr where detail_sort_num = any( ";
	v_sql += "select unique_num from daesung_hr_sort where big_num = "+ rs.getString("BIG_NUM") + " and mid_num = " + rs.getString("MID_NUM") + " ";
	v_sql += "minus ";
	v_sql += "select unique_num from daesung_hr_sort where sml_num = 0 and detail_num = 0 ";
	v_sql += "minus ";
	v_sql += "select unique_num from daesung_hr_sort where sml_num = 9 and detail_num = 9  ";

	v_sql += "minus ";
	v_sql += "select unique_num from daesung_hr_sort where unique_num = any(5206,5204,5105,3201,2203) )";

	v_sql += "and data_date = '"+ s_sql + "'";

	arr_sql[check_sum_number] = v_sql;
	adr_num[check_sum_number] = rs.getString("UNIQUE_NUM");
	big_center[check_sum_number] = rs.getString("BIG_NUM");
	mid_center[check_sum_number] = rs.getString("MID_NUM");
	center_name[check_sum_number] = rs.getString("CENTER_NAME");

	/////////////////////////////////////////////////////////////
			if(rs.getString("UNIQUE_NUM").equals("1199"))
			{
				big_center_nameing[check_sum_number] = "서울";
				mid_center_nameing[check_sum_number] = "가산";
			}
			else if(rs.getString("UNIQUE_NUM").equals("1299"))
			{
				big_center_nameing[check_sum_number] = "서울";
				mid_center_nameing[check_sum_number] = "양평";
			}
			else if(rs.getString("UNIQUE_NUM").equals("1399"))
			{
				big_center_nameing[check_sum_number] = "서울";
				mid_center_nameing[check_sum_number] = "=";
			}
			else if(rs.getString("UNIQUE_NUM").equals("2599"))
			{
				big_center_nameing[check_sum_number] = "대구";
				mid_center_nameing[check_sum_number] = "=";
			}
			else if(rs.getString("UNIQUE_NUM").equals("4199"))
			{
				big_center_nameing[check_sum_number] = "합산";
				mid_center_nameing[check_sum_number] = "=";
			}
			else if(rs.getString("UNIQUE_NUM").equals("5199"))
			{
				big_center_nameing[check_sum_number] = "인하우스";
				mid_center_nameing[check_sum_number] = "서울";
			}
			else if(rs.getString("UNIQUE_NUM").equals("5299"))
			{
				big_center_nameing[check_sum_number] = "인하우스";
				mid_center_nameing[check_sum_number] = "대구";
			}
			else if(rs.getString("UNIQUE_NUM").equals("5399"))
			{
				big_center_nameing[check_sum_number] = "인하우스";
				mid_center_nameing[check_sum_number] = "=";
			}
			else if(rs.getString("UNIQUE_NUM").equals("6099"))
			{
				big_center_nameing[check_sum_number] = "파견";
				mid_center_nameing[check_sum_number] = "=";
			}
			else if(rs.getString("UNIQUE_NUM").equals("8999"))
			{
				big_center_nameing[check_sum_number] = "총합계";
				mid_center_nameing[check_sum_number] = "-";
			}
			else if(rs.getString("UNIQUE_NUM").equals("9999"))
			{
				big_center_nameing[check_sum_number] = "총합계";
				mid_center_nameing[check_sum_number] = "-";
			}
	/////////////////////////////////////////////////////////////

	check_sum_number++;

	}
	/**************************************************

	각 쿼리를 받아와서 합계값을 디비로부터 도출하였음.

	**************************************************/
	for(int p=0; p<11; p++)
	{
		ResultSet arr_rs = stmt.executeQuery(arr_sql[p]);
		ResultSetMetaData arr_rsmd = arr_rs.getMetaData();

		String to_num,master_num,sv_num,qa_num,etc_num,client_num,total_num,prvday_vs,today_vs,working_rate;
		while(arr_rs.next())
		{


			to_num = arr_rs.getString("TO_NUM");
			master_num = arr_rs.getString("MASTER_NUM");
			sv_num = arr_rs.getString("SV_NUM");
			qa_num = arr_rs.getString("QA_NUM");
			etc_num = arr_rs.getString("ETC_NUM");
			client_num = arr_rs.getString("CLIENT_NUM");
			total_num = arr_rs.getString("TOTAL_NUM");
			prvday_vs = arr_rs.getString("PRVDAY_VS");
			today_vs = arr_rs.getString("TODAY_VS");
			working_rate = arr_rs.getString("WORKING_RATE");

			String k_sql;


			k_sql = "insert into daesung_hr values (";
			k_sql += "'" + s_sql + "',";

			k_sql += "'" + big_center_nameing[p] + "',";
			k_sql += "'" + mid_center_nameing[p] + "',";

			k_sql += "'" + center_name[p] + "',";
			k_sql += adr_num[p] + ",";


			if(to_num != "null" && to_num != null){k_sql += "'" + to_num + "',";}else{k_sql += "'',";}
			if(master_num != "null" && master_num != null){k_sql += "'" + master_num + "',";}else{k_sql += "'',";}
			if(sv_num != "null" && sv_num != null){k_sql += "'" + sv_num + "',";}else{k_sql += "'',";}
			if(qa_num != "null" && qa_num != null){k_sql += "'" + qa_num + "',";}else{k_sql += "'',";}
			if(etc_num != "null" && etc_num != null){k_sql += "'" + etc_num + "',";}else{k_sql += "'',";}
			if(client_num != "null" && client_num != null){k_sql += "'" + client_num + "',";}else{k_sql += "'',";}
			if(total_num != "null" && total_num != null){k_sql += "'" + total_num + "',";}else{k_sql += "'',";}
			if(prvday_vs != "null" && prvday_vs != null){k_sql += "'" + prvday_vs + "',";}else{k_sql += "'',";}
			if(today_vs != "null" && today_vs != null){k_sql += "'" + today_vs + "',";}else{k_sql += "'',";}
			if(working_rate != "null" && working_rate != null){k_sql += "'" + working_rate + "',";}else{k_sql += "'',";}
			k_sql += "'',";
			k_sql += "'',";
			k_sql += "'',sysdate)";


			int k_numberOfColumns = stmt.executeUpdate(k_sql);

			if(k_numberOfColumns == 1)
			{
				out.print("s");
			}
			else
			{
				out.print("fail");
			}


		}
	}

	String u_sql;

	u_sql = "select sum(to_num) as to_num,sum(master_num) as master_num,";
	u_sql += "sum(sv_num) as sv_num,sum(qa_num) as qa_num,sum(etc_num) as etc_num,";
	u_sql += "sum(client_num) as client_num,sum(total_num) as total_num,sum(prvday_vs) as prvday_vs,";
	u_sql += "sum(today_vs) as today_vs,round(sum(total_num)/350*100,1) as working_rate ";
	u_sql += "from daesung_hr where detail_sort_num = any( ";
	u_sql += "select unique_num from daesung_hr_sort where big_num = 1 ";
	u_sql += "minus ";
	u_sql += "select unique_num from daesung_hr_sort where big_num = 1 and sml_num = 0 and detail_num = 0 ";
	u_sql += "minus ";
	u_sql += "select unique_num from daesung_hr_sort where big_num = 1 and sml_num = 9 and detail_num = 9) ";
	u_sql += "and data_date = '"+s_sql+"'";

	ResultSet u_rs = stmt.executeQuery(u_sql);

	ResultSetMetaData u_rsmd = u_rs.getMetaData();
	while(u_rs.next())
	{
		 String u_sql_end;
		 u_sql_end = "update daesung_hr set ";
		 //u_sql_end += "TO_NUM = '"+u_rs.getString("TO_NUM")+"',";
		 if(u_rs.getString("TO_NUM") != "null" && u_rs.getString("TO_NUM") != null)
		 {u_sql_end += "TO_NUM = '"+u_rs.getString("TO_NUM")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs.getString("MASTER_NUM") != "null" && u_rs.getString("MASTER_NUM") != null)
		 {u_sql_end += "MASTER_NUM = '"+u_rs.getString("MASTER_NUM")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs.getString("SV_NUM") != "null" && u_rs.getString("SV_NUM") != null)
		 {u_sql_end += "SV_NUM = '"+u_rs.getString("SV_NUM")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs.getString("QA_NUM") != "null" && u_rs.getString("QA_NUM") != null)
		 {u_sql_end += "QA_NUM = '"+u_rs.getString("QA_NUM")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs.getString("ETC_NUM") != "null" && u_rs.getString("ETC_NUM") != null)
		 {u_sql_end += "ETC_NUM = '"+u_rs.getString("ETC_NUM")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs.getString("CLIENT_NUM") != "null" && u_rs.getString("CLIENT_NUM") != null)
		 {u_sql_end += "CLIENT_NUM = '"+u_rs.getString("CLIENT_NUM")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs.getString("TOTAL_NUM") != "null" && u_rs.getString("TOTAL_NUM") != null)
		 {u_sql_end += "TOTAL_NUM = '"+u_rs.getString("TOTAL_NUM")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs.getString("PRVDAY_VS") != "null" && u_rs.getString("PRVDAY_VS") != null)
		 {u_sql_end += "PRVDAY_VS = '"+u_rs.getString("PRVDAY_VS")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs.getString("TODAY_VS") != "null" && u_rs.getString("TODAY_VS") != null)
		 {u_sql_end += "TODAY_VS = '"+u_rs.getString("TODAY_VS")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs.getString("WORKING_RATE") != "null" && u_rs.getString("WORKING_RATE") != null)
		 {u_sql_end += "WORKING_RATE = '"+u_rs.getString("WORKING_RATE")+"' ";}
		 else
		 {u_sql_end += "";}

		 u_sql_end += "where detail_sort_num='1399' and data_date='"+s_sql+"'";

		 int u_numberOfColumns = stmt.executeUpdate(u_sql_end);



			if(u_numberOfColumns == 1)
			{
				out.print("u");
			}
			else
			{
				out.print("fail");
			}
	}

	////////////////////////////////////////////////////////////////////////////////////////2599

	String u_sql_2599;

	u_sql_2599 = "select sum(to_num) as to_num,sum(master_num) as master_num,";
	u_sql_2599 += "sum(sv_num) as sv_num,sum(qa_num) as qa_num,sum(etc_num) as etc_num,";
	u_sql_2599 += "sum(client_num) as client_num,sum(total_num) as total_num,sum(prvday_vs) as prvday_vs,";
	u_sql_2599 += "sum(today_vs) as today_vs,round(sum(total_num)/480*100,1) as working_rate ";
	u_sql_2599 += "from daesung_hr where detail_sort_num = any( ";
	u_sql_2599 += "select unique_num from daesung_hr_sort where big_num = 2 ";
	u_sql_2599 += "minus ";
	u_sql_2599 += "select unique_num from daesung_hr_sort where big_num = 2 and sml_num = 0 and detail_num = 0 ";
	u_sql_2599 += "minus ";
	u_sql_2599 += "select unique_num from daesung_hr_sort where big_num = 2 and sml_num = 9 and detail_num = 9 ";

	u_sql_2599 += "minus ";
	u_sql_2599 += "select unique_num from daesung_hr_sort where unique_num = any(5206,5204,5105,3201,2203,5112) )";


	u_sql_2599 += "and data_date = '"+s_sql+"'";

	ResultSet u_rs_2599 = stmt.executeQuery(u_sql_2599);

	ResultSetMetaData u_rsmd_2599 = u_rs_2599.getMetaData();
	while(u_rs_2599.next())
	{
		 String u_sql_end;
		 u_sql_end = "update daesung_hr set ";

		 if(u_rs_2599.getString("TO_NUM") != "null" && u_rs_2599.getString("TO_NUM") != null)
		 {u_sql_end += "TO_NUM = '"+u_rs_2599.getString("TO_NUM")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs_2599.getString("MASTER_NUM") != "null" && u_rs_2599.getString("MASTER_NUM") != null)
		 {u_sql_end += "MASTER_NUM = '"+u_rs_2599.getString("MASTER_NUM")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs_2599.getString("SV_NUM") != "null" && u_rs_2599.getString("SV_NUM") != null)
		 {u_sql_end += "SV_NUM = '"+u_rs_2599.getString("SV_NUM")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs_2599.getString("QA_NUM") != "null" && u_rs_2599.getString("QA_NUM") != null)
		 {u_sql_end += "QA_NUM = '"+u_rs_2599.getString("QA_NUM")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs_2599.getString("ETC_NUM") != "null" && u_rs_2599.getString("ETC_NUM") != null)
		 {u_sql_end += "ETC_NUM = '"+u_rs_2599.getString("ETC_NUM")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs_2599.getString("CLIENT_NUM") != "null" && u_rs_2599.getString("CLIENT_NUM") != null)
		 {u_sql_end += "CLIENT_NUM = '"+u_rs_2599.getString("CLIENT_NUM")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs_2599.getString("TOTAL_NUM") != "null" && u_rs_2599.getString("TOTAL_NUM") != null)
		 {u_sql_end += "TOTAL_NUM = '"+u_rs_2599.getString("TOTAL_NUM")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs_2599.getString("PRVDAY_VS") != "null" && u_rs_2599.getString("PRVDAY_VS") != null)
		 {u_sql_end += "PRVDAY_VS = '"+u_rs_2599.getString("PRVDAY_VS")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs_2599.getString("TODAY_VS") != "null" && u_rs_2599.getString("TODAY_VS") != null)
		 {u_sql_end += "TODAY_VS = '"+u_rs_2599.getString("TODAY_VS")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs_2599.getString("WORKING_RATE") != "null" && u_rs_2599.getString("WORKING_RATE") != null)
		 {u_sql_end += "WORKING_RATE = '"+u_rs_2599.getString("WORKING_RATE")+"' ";}
		 else
		 {u_sql_end += "";}

		 u_sql_end += "where detail_sort_num='2599' and data_date='"+s_sql+"'";

		 int u_numberOfColumns = stmt.executeUpdate(u_sql_end);



			if(u_numberOfColumns == 1)
			{
				out.print("c");
			}
			else
			{
				out.print("fail");
			}
	}

	////////////////////////////////////////////////////////////////////////////////////////3101

	String u_sql_3101;

	u_sql_3101 = "select sum(to_num) as to_num,sum(master_num) as master_num,";
	u_sql_3101 += "sum(sv_num) as sv_num,sum(qa_num) as qa_num,sum(etc_num) as etc_num,";
	u_sql_3101 += "sum(client_num) as client_num,sum(total_num) as total_num,sum(prvday_vs) as prvday_vs,";
	u_sql_3101 += "sum(today_vs) as today_vs,round(sum(total_num)/150*100,1) as working_rate ";
	u_sql_3101 += "from daesung_hr where detail_sort_num = any( ";
	u_sql_3101 += "select unique_num from daesung_hr_sort where big_num = 3 and mid_num = 1";
	u_sql_3101 += "minus ";
	u_sql_3101 += "select unique_num from daesung_hr_sort where big_num = 3 and sml_num = 0 and detail_num = 0 ";
	u_sql_3101 += "minus ";
	u_sql_3101 += "select unique_num from daesung_hr_sort where big_num = 3 and sml_num = 9 and detail_num = 9) ";
	u_sql_3101 += "and data_date = '"+s_sql+"'";

	ResultSet u_rs_3101 = stmt.executeQuery(u_sql_3101);

	ResultSetMetaData u_rsmd_3101 = u_rs_3101.getMetaData();
	while(u_rs_3101.next())
	{
		 String u_sql_end;
		 u_sql_end = "update daesung_hr set ";

		 if(u_rs_3101.getString("TO_NUM") != "null" && u_rs_3101.getString("TO_NUM") != null)
		 {u_sql_end += "TO_NUM = '"+u_rs_3101.getString("TO_NUM")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs_3101.getString("MASTER_NUM") != "null" && u_rs_3101.getString("MASTER_NUM") != null)
		 {u_sql_end += "MASTER_NUM = '"+u_rs_3101.getString("MASTER_NUM")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs_3101.getString("SV_NUM") != "null" && u_rs_3101.getString("SV_NUM") != null)
		 {u_sql_end += "SV_NUM = '"+u_rs_3101.getString("SV_NUM")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs_3101.getString("QA_NUM") != "null" && u_rs_3101.getString("QA_NUM") != null)
		 {u_sql_end += "QA_NUM = '"+u_rs_3101.getString("QA_NUM")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs_3101.getString("ETC_NUM") != "null" && u_rs_3101.getString("ETC_NUM") != null)
		 {u_sql_end += "ETC_NUM = '"+u_rs_3101.getString("ETC_NUM")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs_3101.getString("CLIENT_NUM") != "null" && u_rs_3101.getString("CLIENT_NUM") != null)
		 {u_sql_end += "CLIENT_NUM = '"+u_rs_3101.getString("CLIENT_NUM")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs_3101.getString("TOTAL_NUM") != "null" && u_rs_3101.getString("TOTAL_NUM") != null)
		 {u_sql_end += "TOTAL_NUM = '"+u_rs_3101.getString("TOTAL_NUM")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs_3101.getString("PRVDAY_VS") != "null" && u_rs_3101.getString("PRVDAY_VS") != null)
		 {u_sql_end += "PRVDAY_VS = '"+u_rs_3101.getString("PRVDAY_VS")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs_3101.getString("TODAY_VS") != "null" && u_rs_3101.getString("TODAY_VS") != null)
		 {u_sql_end += "TODAY_VS = '"+u_rs_3101.getString("TODAY_VS")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs_3101.getString("WORKING_RATE") != "null" && u_rs_3101.getString("WORKING_RATE") != null)
		 {u_sql_end += "WORKING_RATE = '"+u_rs_3101.getString("WORKING_RATE")+"' ";}
		 else
		 {u_sql_end += "";}

		 u_sql_end += "where detail_sort_num='3101' and data_date='"+s_sql+"'";

		 int u_numberOfColumns = stmt.executeUpdate(u_sql_end);



			if(u_numberOfColumns == 1)
			{
				out.print("c");
			}
			else
			{
				out.print("fail");
			}
	}


	////////////////////////////////////////////////////////////////////////////////////////4199

	String u_sql_4199;

	u_sql_4199 = "select sum(to_num) as to_num,sum(master_num) as master_num,";
	u_sql_4199 += "sum(sv_num) as sv_num,sum(qa_num) as qa_num,sum(etc_num) as etc_num,";
	u_sql_4199 += "sum(client_num) as client_num,sum(total_num) as total_num,sum(prvday_vs) as prvday_vs,";
	u_sql_4199 += "sum(today_vs) as today_vs,round(sum(total_num)/980*100,1) as working_rate ";
	u_sql_4199 += "from daesung_hr where detail_sort_num = any( ";
	u_sql_4199 += "select unique_num from daesung_hr_sort where big_num = any(1,2,3,4) ";
	u_sql_4199 += "minus ";
	u_sql_4199 += "select unique_num from daesung_hr_sort where big_num = any(1,2,3,4) and sml_num = 0 and detail_num = 0 ";
	u_sql_4199 += "minus ";
	u_sql_4199 += "select unique_num from daesung_hr_sort where big_num = any(1,2,3,4) and sml_num = 9 and detail_num = 9 ";

	u_sql_4199 += "minus ";
	u_sql_4199 += "select unique_num from daesung_hr_sort where unique_num = any(5206,5204,5105,3201,2203,5112) )";

	u_sql_4199 += "and data_date = '"+s_sql+"'";

	ResultSet u_rs_4199 = stmt.executeQuery(u_sql_4199);

	ResultSetMetaData u_rsmd_4199 = u_rs_4199.getMetaData();
	while(u_rs_4199.next())
	{
		 String u_sql_end;
		 u_sql_end = "update daesung_hr set ";

		 if(u_rs_4199.getString("TO_NUM") != "null" && u_rs_4199.getString("TO_NUM") != null)
		 {u_sql_end += "TO_NUM = '"+u_rs_4199.getString("TO_NUM")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs_4199.getString("MASTER_NUM") != "null" && u_rs_4199.getString("MASTER_NUM") != null)
		 {u_sql_end += "MASTER_NUM = '"+u_rs_4199.getString("MASTER_NUM")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs_4199.getString("SV_NUM") != "null" && u_rs_4199.getString("SV_NUM") != null)
		 {u_sql_end += "SV_NUM = '"+u_rs_4199.getString("SV_NUM")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs_4199.getString("QA_NUM") != "null" && u_rs_4199.getString("QA_NUM") != null)
		 {u_sql_end += "QA_NUM = '"+u_rs_4199.getString("QA_NUM")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs_4199.getString("ETC_NUM") != "null" && u_rs_4199.getString("ETC_NUM") != null)
		 {u_sql_end += "ETC_NUM = '"+u_rs_4199.getString("ETC_NUM")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs_4199.getString("CLIENT_NUM") != "null" && u_rs_4199.getString("CLIENT_NUM") != null)
		 {u_sql_end += "CLIENT_NUM = '"+u_rs_4199.getString("CLIENT_NUM")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs_4199.getString("TOTAL_NUM") != "null" && u_rs_4199.getString("TOTAL_NUM") != null)
		 {u_sql_end += "TOTAL_NUM = '"+u_rs_4199.getString("TOTAL_NUM")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs_4199.getString("PRVDAY_VS") != "null" && u_rs_4199.getString("PRVDAY_VS") != null)
		 {u_sql_end += "PRVDAY_VS = '"+u_rs_4199.getString("PRVDAY_VS")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs_4199.getString("TODAY_VS") != "null" && u_rs_4199.getString("TODAY_VS") != null)
		 {u_sql_end += "TODAY_VS = '"+u_rs_4199.getString("TODAY_VS")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs_4199.getString("WORKING_RATE") != "null" && u_rs_4199.getString("WORKING_RATE") != null)
		 {u_sql_end += "WORKING_RATE = '"+u_rs_4199.getString("WORKING_RATE")+"' ";}
		 else
		 {u_sql_end += "";}

		 u_sql_end += "where detail_sort_num='4199' and data_date='"+s_sql+"'";

		 int u_numberOfColumns = stmt.executeUpdate(u_sql_end);



			if(u_numberOfColumns == 1)
			{
				out.print("e");
			}
			else
			{
				out.print("fail");
			}
	}

	////////////////////////////////////////////////////////////////////////////////////////5399

	String u_sql_5399;

	u_sql_5399 = "select sum(to_num) as to_num,sum(master_num) as master_num,";
	u_sql_5399 += "sum(sv_num) as sv_num,sum(qa_num) as qa_num,sum(etc_num) as etc_num,";
	u_sql_5399 += "sum(client_num) as client_num,sum(total_num) as total_num,sum(prvday_vs) as prvday_vs,";
	u_sql_5399 += "sum(today_vs) as today_vs,round(sum(total_num)/sum(to_num)*100,1) as working_rate ";
	u_sql_5399 += "from daesung_hr where detail_sort_num = any( ";
	u_sql_5399 += "select unique_num from daesung_hr_sort where big_num = 5 ";
	u_sql_5399 += "minus ";
	u_sql_5399 += "select unique_num from daesung_hr_sort where big_num = 5 and sml_num = 0 and detail_num = 0 ";
	u_sql_5399 += "minus ";
	u_sql_5399 += "select unique_num from daesung_hr_sort where big_num = 5 and sml_num = 9 and detail_num = 9 ";

	u_sql_5399 += "minus ";
	u_sql_5399 += "select unique_num from daesung_hr_sort where unique_num = any(5206,5204,5105,3201,2203,5112) )";

	u_sql_5399 += "and data_date = '"+s_sql+"'";

	ResultSet u_rs_5399 = stmt.executeQuery(u_sql_5399);

	ResultSetMetaData u_rsmd_5399 = u_rs_5399.getMetaData();
	while(u_rs_5399.next())
	{
		 String u_sql_end;
		 u_sql_end = "update daesung_hr set ";

		 if(u_rs_5399.getString("TO_NUM") != "null" && u_rs_5399.getString("TO_NUM") != null)
		 {u_sql_end += "TO_NUM = '"+u_rs_5399.getString("TO_NUM")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs_5399.getString("MASTER_NUM") != "null" && u_rs_5399.getString("MASTER_NUM") != null)
		 {u_sql_end += "MASTER_NUM = '"+u_rs_5399.getString("MASTER_NUM")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs_5399.getString("SV_NUM") != "null" && u_rs_5399.getString("SV_NUM") != null)
		 {u_sql_end += "SV_NUM = '"+u_rs_5399.getString("SV_NUM")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs_5399.getString("QA_NUM") != "null" && u_rs_5399.getString("QA_NUM") != null)
		 {u_sql_end += "QA_NUM = '"+u_rs_5399.getString("QA_NUM")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs_5399.getString("ETC_NUM") != "null" && u_rs_5399.getString("ETC_NUM") != null)
		 {u_sql_end += "ETC_NUM = '"+u_rs_5399.getString("ETC_NUM")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs_5399.getString("CLIENT_NUM") != "null" && u_rs_5399.getString("CLIENT_NUM") != null)
		 {u_sql_end += "CLIENT_NUM = '"+u_rs_5399.getString("CLIENT_NUM")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs_5399.getString("TOTAL_NUM") != "null" && u_rs_5399.getString("TOTAL_NUM") != null)
		 {u_sql_end += "TOTAL_NUM = '"+u_rs_5399.getString("TOTAL_NUM")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs_5399.getString("PRVDAY_VS") != "null" && u_rs_5399.getString("PRVDAY_VS") != null)
		 {u_sql_end += "PRVDAY_VS = '"+u_rs_5399.getString("PRVDAY_VS")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs_5399.getString("TODAY_VS") != "null" && u_rs_5399.getString("TODAY_VS") != null)
		 {u_sql_end += "TODAY_VS = '"+u_rs_5399.getString("TODAY_VS")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs_5399.getString("WORKING_RATE") != "null" && u_rs_5399.getString("WORKING_RATE") != null)
		 {u_sql_end += "WORKING_RATE = '"+u_rs_5399.getString("WORKING_RATE")+"' ";}
		 else
		 {u_sql_end += "";}

		 u_sql_end += "where detail_sort_num='5399' and data_date='"+s_sql+"'";

		 int u_numberOfColumns = stmt.executeUpdate(u_sql_end);



			if(u_numberOfColumns == 1)
			{
				out.print("s");
			}
			else
			{
				out.print("fail");
			}
	}
	////////////////////////////////////////////////////////////////////////////////////////8999

	String u_sql_8999;

	u_sql_8999 = "select sum(to_num) as to_num,sum(master_num) as master_num,";
	u_sql_8999 += "sum(sv_num) as sv_num,sum(qa_num) as qa_num,sum(etc_num) as etc_num,";
	u_sql_8999 += "sum(client_num) as client_num,sum(total_num) as total_num,sum(prvday_vs) as prvday_vs,";
	u_sql_8999 += "sum(today_vs) as today_vs,round(sum(total_num)/sum(to_num)*100,1) as working_rate ";
	u_sql_8999 += "from daesung_hr where detail_sort_num = any( ";
	u_sql_8999 += "select unique_num from daesung_hr_sort where big_num = any(1,2,3,4,5,6) ";
	u_sql_8999 += "minus ";
	u_sql_8999 += "select unique_num from daesung_hr_sort where big_num = any(1,2,3,4,5,6) and sml_num = 0 and detail_num = 0 ";
	u_sql_8999 += "minus ";
	u_sql_8999 += "select unique_num from daesung_hr_sort where big_num = any(1,2,3,4,5,6) and sml_num = 9 and detail_num = 9 ";
	u_sql_8999 += "minus ";
	u_sql_8999 += "select unique_num from daesung_hr_sort where unique_num = any(5206,5204,5105,3201,2203,5112) )";

	u_sql_8999 += "and data_date = '"+s_sql+"'";

	ResultSet u_rs_8999 = stmt.executeQuery(u_sql_8999);

	ResultSetMetaData u_rsmd_8999 = u_rs_8999.getMetaData();
	while(u_rs_8999.next())
	{
		 String u_sql_end;
		 u_sql_end = "update daesung_hr set ";

		 if(u_rs_8999.getString("TO_NUM") != "null" && u_rs_8999.getString("TO_NUM") != null)
		 {u_sql_end += "TO_NUM = '"+u_rs_8999.getString("TO_NUM")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs_8999.getString("MASTER_NUM") != "null" && u_rs_8999.getString("MASTER_NUM") != null)
		 {u_sql_end += "MASTER_NUM = '"+u_rs_8999.getString("MASTER_NUM")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs_8999.getString("SV_NUM") != "null" && u_rs_8999.getString("SV_NUM") != null)
		 {u_sql_end += "SV_NUM = '"+u_rs_8999.getString("SV_NUM")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs_8999.getString("QA_NUM") != "null" && u_rs_8999.getString("QA_NUM") != null)
		 {u_sql_end += "QA_NUM = '"+u_rs_8999.getString("QA_NUM")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs_8999.getString("ETC_NUM") != "null" && u_rs_8999.getString("ETC_NUM") != null)
		 {u_sql_end += "ETC_NUM = '"+u_rs_8999.getString("ETC_NUM")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs_8999.getString("CLIENT_NUM") != "null" && u_rs_8999.getString("CLIENT_NUM") != null)
		 {u_sql_end += "CLIENT_NUM = '"+u_rs_8999.getString("CLIENT_NUM")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs_8999.getString("TOTAL_NUM") != "null" && u_rs_8999.getString("TOTAL_NUM") != null)
		 {u_sql_end += "TOTAL_NUM = '"+u_rs_8999.getString("TOTAL_NUM")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs_8999.getString("PRVDAY_VS") != "null" && u_rs_8999.getString("PRVDAY_VS") != null)
		 {u_sql_end += "PRVDAY_VS = '"+u_rs_8999.getString("PRVDAY_VS")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs_8999.getString("TODAY_VS") != "null" && u_rs_8999.getString("TODAY_VS") != null)
		 {u_sql_end += "TODAY_VS = '"+u_rs_8999.getString("TODAY_VS")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs_8999.getString("WORKING_RATE") != "null" && u_rs_8999.getString("WORKING_RATE") != null)
		 {u_sql_end += "WORKING_RATE = '"+u_rs_8999.getString("WORKING_RATE")+"' ";}
		 else
		 {u_sql_end += "";}

		 u_sql_end += "where detail_sort_num='8999' and data_date='"+s_sql+"'";

		 int u_numberOfColumns = stmt.executeUpdate(u_sql_end);



			if(u_numberOfColumns == 1)
			{
				out.print("s");
			}
			else
			{
				out.print("fail");
			}
	}
	////////////////////////////////////////////////////////////////////////////////////////9999

	String u_sql_9999;

	u_sql_9999 = "select sum(to_num) as to_num,sum(master_num) as master_num,";
	u_sql_9999 += "sum(sv_num) as sv_num,sum(qa_num) as qa_num,sum(etc_num) as etc_num,";
	u_sql_9999 += "sum(client_num) as client_num,sum(total_num) as total_num,sum(prvday_vs) as prvday_vs,";
	u_sql_9999 += "sum(today_vs) as today_vs,round(sum(total_num)/sum(to_num)*100,1) as working_rate ";
	u_sql_9999 += "from daesung_hr where detail_sort_num = any( ";
	u_sql_9999 += "select unique_num from daesung_hr_sort where big_num = any(1,2,3,4,5,6) ";
	u_sql_9999 += "minus ";
	u_sql_9999 += "select unique_num from daesung_hr_sort where big_num = any(1,2,3,4,5,6) and sml_num = 0 and detail_num = 0 ";
	u_sql_9999 += "minus ";
	u_sql_9999 += "select unique_num from daesung_hr_sort where big_num = any(1,2,3,4,5,6) and sml_num = 9 and detail_num = 9) ";
	u_sql_9999 += "and data_date = '"+s_sql+"'";

	ResultSet u_rs_9999 = stmt.executeQuery(u_sql_9999);

	ResultSetMetaData u_rsmd_9999 = u_rs_9999.getMetaData();
	while(u_rs_9999.next())
	{
		 String u_sql_end;
		 u_sql_end = "update daesung_hr set ";

		 if(u_rs_9999.getString("TO_NUM") != "null" && u_rs_9999.getString("TO_NUM") != null)
		 {u_sql_end += "TO_NUM = '"+u_rs_9999.getString("TO_NUM")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs_9999.getString("MASTER_NUM") != "null" && u_rs_9999.getString("MASTER_NUM") != null)
		 {u_sql_end += "MASTER_NUM = '"+u_rs_9999.getString("MASTER_NUM")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs_9999.getString("SV_NUM") != "null" && u_rs_9999.getString("SV_NUM") != null)
		 {u_sql_end += "SV_NUM = '"+u_rs_9999.getString("SV_NUM")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs_9999.getString("QA_NUM") != "null" && u_rs_9999.getString("QA_NUM") != null)
		 {u_sql_end += "QA_NUM = '"+u_rs_9999.getString("QA_NUM")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs_9999.getString("ETC_NUM") != "null" && u_rs_9999.getString("ETC_NUM") != null)
		 {u_sql_end += "ETC_NUM = '"+u_rs_9999.getString("ETC_NUM")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs_9999.getString("CLIENT_NUM") != "null" && u_rs_9999.getString("CLIENT_NUM") != null)
		 {u_sql_end += "CLIENT_NUM = '"+u_rs_9999.getString("CLIENT_NUM")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs_9999.getString("TOTAL_NUM") != "null" && u_rs_9999.getString("TOTAL_NUM") != null)
		 {u_sql_end += "TOTAL_NUM = '"+u_rs_9999.getString("TOTAL_NUM")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs_9999.getString("PRVDAY_VS") != "null" && u_rs_9999.getString("PRVDAY_VS") != null)
		 {u_sql_end += "PRVDAY_VS = '"+u_rs_9999.getString("PRVDAY_VS")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs_9999.getString("TODAY_VS") != "null" && u_rs_9999.getString("TODAY_VS") != null)
		 {u_sql_end += "TODAY_VS = '"+u_rs_9999.getString("TODAY_VS")+"',";}
		 else
		 {u_sql_end += "";}

		 if(u_rs_9999.getString("WORKING_RATE") != "null" && u_rs_9999.getString("WORKING_RATE") != null)
		 {u_sql_end += "WORKING_RATE = '"+u_rs_9999.getString("WORKING_RATE")+"' ";}
		 else
		 {u_sql_end += "";}

		 u_sql_end += "where detail_sort_num='9999' and data_date='"+s_sql+"'";

		 int u_numberOfColumns = stmt.executeUpdate(u_sql_end);



			if(u_numberOfColumns == 1)
			{
				out.print("s");
			}
			else
			{
				out.print("fail");
			}
	}

	String tovs_sql_end;
	tovs_sql_end = "update daesung_hr set today_vs = (total_num - to_num) where data_date ='"+s_sql+"'";
	stmt.executeUpdate(tovs_sql_end);
	////////////////////////////////////////////////////////////////////////////////////////end
	out.print("</result>");

	}//if 문의 마지막절
	else
	{
		out.print("<result>fail</result>");
	}
		out.print("</root>");


	} catch(Exception ex){
		System.out.println("Daesung select error");
	} finally {
		if (stmt != null) try { stmt.close(); } catch(SQLException ex) {System.out.println(ex);}
	    if (conn != null) try { conn.close(); } catch(SQLException ex) {System.out.println(ex);}
		System.out.println("Daesung execution time: " + (System.currentTimeMillis() - startTime));
	}

%>