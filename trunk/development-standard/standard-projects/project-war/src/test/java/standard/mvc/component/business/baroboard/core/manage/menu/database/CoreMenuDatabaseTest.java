package standard.mvc.component.business.baroboard.core.manage.menu.database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

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
 * @since 2015. 5. 28.
 * @version 1.0
 * @see <pre>
 * Class Name  : CoreMenuDatabaseTest, TriggerVO
 * Description : T_CORE_MENU, T_CORE_MENU_LOG DBUnit Test without Spring
 * Information :
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------       ------------   -----------------------
 * 2015. 6. 20.       손호성                 최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Ignore("dataset 작성이 완료 안되서 정상작동 안함")
public class CoreMenuDatabaseTest {

    private String driver;
    private String dbUrl;
    private String userName;
    private String password;
    private String scheme;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private IDatabaseTester databaseTester;

    @Before
    public void setUp() throws Exception {
        initJdbcProps();

        databaseTester = new JdbcDatabaseTester(driver, dbUrl, userName, password, scheme);

        try {
            String datasetPath =
                    "/standard/mvc/component/business/baroboard/menu/database/T_CORE_MENU.xml";
            URL url = this.getClass().getResource(datasetPath);

            ReplacementDataSet dataSet =
                    new ReplacementDataSet(new FlatXmlDataSetBuilder().build(new File(url.toURI())));
            dataSet.addReplacementObject("[NULL]", null);
            DatabaseOperation.CLEAN_INSERT.execute(databaseTester.getConnection(), dataSet);
        } catch (Exception e) {
            logger.error("setUp 시 예외 발생", e);
            databaseTester.getConnection().close();
        }
    }

    private void initJdbcProps() throws IOException, FileNotFoundException, URISyntaxException {
        Properties props = newPropertiesInstance();

        driver = props.getProperty("jdbc.driver");
        dbUrl = props.getProperty("jdbc.url");
        userName = props.getProperty("jdbc.username");
        password = props.getProperty("jdbc.password");
        scheme = props.getProperty("jdbc.scheme");
    }

    private Properties newPropertiesInstance() throws IOException, FileNotFoundException,
    URISyntaxException {
        Properties props = new Properties();
        String path =
                "/standard/mvc/component/business/baroboard/core/jdbc.properties";
        URL url = this.getClass().getResource(path);
        props.load(new FileInputStream(new File(url.toURI())));
        return props;
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
                    "SELECT C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE, C_METHOD, C_STATE FROM T_CORE_SET_FTP_LOG WHERE C_ID= ? AND C_METHOD = ? AND ROWNUM < 2 ORDER BY C_DATE DESC";
            pstmt = conn.prepareStatement(query);

            for (String cMethod : cMethods) {

                pstmt.setInt(1, 1);
                pstmt.setString(2, cMethod);
                rs = pstmt.executeQuery();

                if (!rs.next()) {
                    throw new SQLException("No Data Found!");
                }

                TriggerVO actual = new TriggerVO();
                actual.setC_id(rs.getInt(1));
                actual.setC_title(rs.getString(7));
                actual.setC_state(rs.getString(9));

                TriggerVO expected = new TriggerVO();
                expected.setC_id(1);
                expected.setC_title("root");
                expected.setC_state(cMethod);

                Assert.assertEquals(expected.getC_id(), actual.getC_id());
                Assert.assertEquals(expected.getC_title(), actual.getC_title());
                Assert.assertEquals(expected.getC_state(), actual.getC_state());

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
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(dbUrl, userName, password);

            String query = "UPDATE T_CORE_SET_FTP SET C_FTP_PASSWORD = ? WHERE C_ID = ?";
            pstmt = conn.prepareStatement(query);

            pstmt.setString(1, "4321");
            pstmt.setInt(2, 4);
            int updateCount = pstmt.executeUpdate();

            Assert.assertEquals(1, updateCount);

            query = "SELECT C_FTP_PASSWORD FROM T_CORE_SET_FTP WHERE C_ID = ?";
            pstmt = conn.prepareStatement(query);

            pstmt.setInt(1, 4);

            rs = pstmt.executeQuery();

            if (!rs.next()) {
                throw new SQLException("No Data Found!");
            }

            Assert.assertEquals("4321", rs.getString(1));

            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            logger.error("test 시  예외 발생", e);
        }
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
