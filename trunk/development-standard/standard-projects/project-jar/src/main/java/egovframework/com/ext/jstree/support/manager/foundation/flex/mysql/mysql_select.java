/**
 *
 */
package egovframework.com.ext.jstree.support.manager.foundation.flex.mysql;

/**
 * @author Administrator
 *
 */
import java.util.*;
import java.sql.*;

public class mysql_select {

	public Vector<Hashtable<String, String>> getElements(String v_sql) throws SQLException
	{
		long startTime = System.currentTimeMillis();

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e)
		{
		}

		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection con = null;
		Vector<Hashtable<String, String>> vc = new Vector<Hashtable<String, String>>();
		Hashtable<String, String> ht = null;
		String sql = v_sql;

		try
		{
			String url = "jdbc:mysql://127.0.0.1:3306/www313cokr";
			con = DriverManager.getConnection(url, "root", "apmsetup");
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int numberOfColumns = rsmd.getColumnCount();

			while (rs.next())
			{
				ht = new Hashtable<String, String>();
				for(int i=1; i<= numberOfColumns;i++)
				{

					if(rs.getString(rsmd.getColumnName(i)) != "null" && rs.getString(rsmd.getColumnName(i)) != null)
					{
						ht.put(rsmd.getColumnName(i), rs.getString(rsmd.getColumnName(i)));
					}

				}
				vc.add(ht);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			rs.close();
			stmt.close();
			con.close();
		}

		System.out.println("Service execution time: "+ (System.currentTimeMillis() - startTime));
		return vc;
	}
}
