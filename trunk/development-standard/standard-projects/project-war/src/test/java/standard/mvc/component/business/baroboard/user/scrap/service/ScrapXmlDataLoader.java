package standard.mvc.component.business.baroboard.user.scrap.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLException;

import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.XmlDataSet;
import org.dbunit.operation.DatabaseOperation;

public class ScrapXmlDataLoader {
	public static void loadIntegrationTestXmlLoad() {
        loadData("src/test/resources/standard/mvc/component/business/baroboard/user/scrap/User_Scrap.xml");
    }
	
	public static void loadData(String loadXmlFile) {
		IDatabaseConnection conn = null;
		try{
			DbUnitConnectionUtil DbUnitCnUtil = new DbUnitConnectionUtil();
			conn = DbUnitCnUtil.getConnection();
			IDataSet data = createDataSet(loadXmlFile);
			DatabaseOperation.CLEAN_INSERT.execute(conn, data);
		}catch(Throwable e) {
			throw new RuntimeException(e);
		}finally{
			close(conn);
		}
	}

	public static void close(IDatabaseConnection conn) {
		if(conn != null){
            try{
                conn.close();
            }catch (SQLException e) {
            }
        }
    }
		
	public static IDataSet createDataSet(String loadXmlFile) throws DataSetException, FileNotFoundException {
	        return new XmlDataSet(new FileReader(loadXmlFile));
	}
}
