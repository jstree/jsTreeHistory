package standard.mvc.component.business.baroboard.user.scrap.service;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;

public class DbUnitConnectionUtil {
	public String DRIVER ="oracle.jdbc.driver.OracleDriver";
	public String URL = "jdbc:oracle:thin:@db.313.co.kr:1521:family";
	public String USER = "STANDARD_DB";
	public String PWD = "STANDARD_DB_1234";
	
	public String getDRIVER() {
		return DRIVER;
	}

	public String getURL() {
		return URL;
	}

	public String getUSER() {
		return USER;
	}

	public String getPWD() {
		return PWD;
	}


	
	public IDatabaseConnection getConnection() throws ClassNotFoundException, SQLException, DatabaseUnitException {
		Class.forName(this.DRIVER);
		/*
		 org.dbunit.database.AmbiguousTableNameException: COUNTRIES 에러
		 MySQL을 사용할 경우에는 스키마 타입을 지정해줄 필요가 없었는데 
		 
		 오라클을 사용할때에는 스키마명을 지정해주지 않으면 JUnit 테스트시 아래와 같은 에러가 발생했다.
		 
		 --> 이와 같은 에러를 해결하기 위해 커넥션을 생성해줄때 스키마명을 지정해준다.
		 IDatabaseConnection connection = new DatabaseConnection(con);  // MySQL 사용시
		 IDatabaseConnection connection = new DatabaseConnection(con,  "SIKSCO");  // Oracle 사용시 스키마 명을 지정해준다.
		      오라클에서 생성해준 사용자 아이디와 같다.
		*/
		return new DatabaseConnection(DriverManager.getConnection(this.URL, this.USER, this.PWD), "family");
	}
}
