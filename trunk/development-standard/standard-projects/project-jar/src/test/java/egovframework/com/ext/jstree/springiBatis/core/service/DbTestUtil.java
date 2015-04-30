package egovframework.com.ext.jstree.springiBatis.core.service;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class DbTestUtil
{
	public static void resetAutoIncrementColumns(ApplicationContext applicationContext, String sequenceName, int startNumber)
	{
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(applicationContext.getBean("dataSource-oracle",DataSource.class));
		
		String dropSequenceSql = " DROP SEQUENCE %s";
		String createSequenceSql = "CREATE SEQUENCE %s START WITH %d CACHE 20 ";
		
		String dropSql = String.format(dropSequenceSql, sequenceName);
		String createSql = String.format(createSequenceSql, sequenceName, startNumber);
		
		jdbcTemplate.execute(dropSql);
		jdbcTemplate.execute(createSql);

	}
}
