package standard.mvc.component.business.baroboard.core.setting.server.database;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.ReplacementDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * 
 * Modification Information
 * 
 * @author pennori
 * @since 2015. 5. 16.
 * @version 1.0
 * @see <pre>
 * Class Name  : CoreSettingServerDatabaseTest.java
 * Description : 
 * Infomation  : 
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------       ------------   -----------------------
 * 2015. 5. 16.       손호성                 최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
public class CoreSettingServerDatabaseTest {

    private final String driver = "oracle.jdbc.OracleDriver";
    private final String dbUrl = "jdbc:oracle:thin:@db.313.co.kr:1521:family";
    private final String userName = "STANDARD_DB";
    private final String password = "STANDARD_DB_1234";

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private IDatabaseTester databaseTester;

    @Before
    public void setUp() throws Exception {
        databaseTester = new JdbcDatabaseTester(driver, dbUrl, userName, password, "STANDARD_DB");

        try {
            String datasetClasspath =
                    "/standard/mvc/component/business/baroboard/core/setting/server/database/T_CORE_SETTING_SERVER.xml";
            URL url = this.getClass().getResource(datasetClasspath);

            ReplacementDataSet dataSet =
                    new ReplacementDataSet(new FlatXmlDataSetBuilder().build(new File(url.toURI())));
            dataSet.addReplacementObject("[NULL]", null);
            DatabaseOperation.CLEAN_INSERT.execute(databaseTester.getConnection(), dataSet);
        } catch (Exception e) {
            logger.error("setUp 시 예외 발생", e);
            databaseTester.getConnection().close();
        }
    }

    @After
    public void tearDown() throws Exception {}

    @Test
    public void testCleanInsertRootNodeTrigger() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(dbUrl, userName, password);

            String[] cMethods = {"delete", "insert"};

            String query =
                    "SELECT C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE, C_METHOD, C_STATE FROM T_CORE_SETTING_SERVER_LOG WHERE C_ID= ? AND C_METHOD = ? AND ROWNUM < 2 ORDER BY C_DATE DESC";
            pstmt = conn.prepareStatement(query);
            
            for (int i = 0; i < cMethods.length; i++) {

                pstmt.setInt(1, 1);
                pstmt.setString(2, cMethods[i]);
                rs = pstmt.executeQuery();

                if (!rs.next()) {
                    throw new SQLException("No Data Found!");
                }

                TriggerVO actual = new TriggerVO();
                actual.setC_id(rs.getInt(1));
                actual.setC_title(rs.getString(7));
                actual.setC_state(rs.getString(9));

                TriggerVO actualDelete = actual;

                TriggerVO expectedDelete = new TriggerVO();
                expectedDelete.setC_id(1);
                expectedDelete.setC_title("root");
                expectedDelete.setC_state(cMethods[i]);

                Assert.assertEquals(expectedDelete.getC_id(), actualDelete.getC_id());
                Assert.assertEquals(expectedDelete.getC_title(), actualDelete.getC_title());
                Assert.assertEquals(expectedDelete.getC_state(), actualDelete.getC_state());

            }

            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            logger.error("test 시  예외 발생", e);
        }
    }

    @Test
    public void testUpdate() throws Exception {

    }

    class TriggerVO extends ComprehensiveTree {
        private String c_method;
        private String c_state;

        public String getC_method() {
            return c_method;
        }

        public void setC_method(String c_method) {
            this.c_method = c_method;
        }

        public String getC_state() {
            return c_state;
        }

        public void setC_state(String c_state) {
            this.c_state = c_state;
        }


    }

}
