package egovframework.com.ext.jstree.support.util.test;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;

public abstract class DatabaseOperations {
    
    public abstract void execute(IDatabaseConnection connection, IDataSet dataSet, int initSequence) 
            throws DatabaseUnitException, SQLException;
    
    public static final DatabaseOperations INIT_SEQ = new DatabaseOperations() {
        
        @Override
        public void execute(IDatabaseConnection connection, IDataSet dataSet, int initSequence)
                throws DatabaseUnitException, SQLException {
            
            Connection realConnection = connection.getConnection();
            
            String databaseProductName = realConnection.getMetaData().getDatabaseProductName();
            
            if ("Oracle".equals(databaseProductName)) {
                
                final String dropSequenceStatementTemplate = "DROP SEQUENCE %S";
                final String createSequenceStatementTemplate = "CREATE SEQUENCE S_COMPREHENSIVETREE_SPRING START WITH %d MAXVALUE 999999999999999999999999999 MINVALUE 0 NOCYCLE CACHE 20 NOORDER";
                
                String[] tableNames = dataSet.getTableNames();
                for (String tableName : tableNames) {
                    
                    String tableNamePrefix = tableName.substring(0, 2);
                    String semanticTableName = tableName.substring(2);
                    
                    if (! "T_".equals(tableNamePrefix)) {
                        fail("테이블 명명규칙(T_로 시작)에 맞지 않는 테이블입니다.");
                    } 
                    else {
                        Statement statement = realConnection.createStatement();
                        
                        statement.execute( String.format(dropSequenceStatementTemplate, "S_" + semanticTableName) );
                        
                        statement.execute( String.format(createSequenceStatementTemplate, initSequence) );
                    }
                }
                
            } else {
                fail("오라클이 아닌 DBMS의 시퀀스 초기화를 구현하세요.");
            }
        }
    };
}