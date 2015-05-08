package egovframework.com.ext.jstree.support.util.test;

import static org.junit.Assert.fail;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Modification Information
 * 
 * @author 김형채
 * @since 2015. 5. 3.
 * @version 1.0
 * @see <pre>
 * Class Name  : DbTestUtil.java
 * Description : 시퀀스를 초기화한다.
 * Infomation  : 오라클 DB 버젼 쿼리만 구현, 다른 DB는 구현필요
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                       수정내용
 * --------  ------------   -----------------------
 * 2015.5.3   김형채                      최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
public class DbTestUtil
{
	public static void resetAutoIncrementColumns(ApplicationContext applicationContext, String sequenceName, int startSeqNumber) throws Exception
	{
		JdbcTemplate jdbcTemplate = new JdbcTemplate(applicationContext.getBean("dataSource-oracle", DataSource.class));

		String databaseProductName = jdbcTemplate.getDataSource().getConnection().getMetaData().getDatabaseProductName();

		if ("Oracle".equals(databaseProductName) == true)
		{
			String sequenceNamePrefix = sequenceName.substring(0, 2);
			
			if("T_".equals(sequenceNamePrefix) == false)
			{
				final String dropSequenceSql = " DROP SEQUENCE %S";
				final String createSequenceSql = "CREATE SEQUENCE %s START WITH %d MAXVALUE 999999999999999999999999999 MINVALUE 0 NOCYCLE CACHE 20 NOORDER ";
				
				jdbcTemplate.execute(String.format(dropSequenceSql, sequenceName));
				jdbcTemplate.execute(String.format(createSequenceSql, sequenceName, startSeqNumber));
			}
			else
			{
				fail("테이블 명명규칙(T_로 시작)에 맞지 않는 테이블입니다.");
			}
		}
		else
		{
			fail("오라클이 아닌 DBMS의 시퀀스 초기화를 구현하세요.");
		}
	}
}
