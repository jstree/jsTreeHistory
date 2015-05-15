/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package egovframework.com.ext.jstree.support.util.test;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;

/**
 * Modification Information
 * 
 * @author 류강하
 * @since 2015. 5. 1.
 * @version 1.0
 * @see <pre>
 * Class Name  : DatabaseOperations.java
 * Description : DBUnit의 DatabaseOperation을 흉내내어 만든 클래스로 내부적으로는 다르게 동작한다.
 * Infomation  : DBUnit의 DatabaseOperation을 확장하기 어려워 별도로 만듦.
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------       ------------   -----------------------
 * 2015. 5.  1.  류강하                 시퀀스 초기화 기능 추가
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
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
                
                final String dropSequenceStatementTemplate = "DROP SEQUENCE S_%S";
                final String createSequenceStatementTemplate = "CREATE SEQUENCE S_%S START WITH %d MAXVALUE 999999999999999999999999999 MINVALUE 0 NOCYCLE CACHE 20 NOORDER";
                
                String[] tableNames = dataSet.getTableNames();
                for (String tableName : tableNames) {
                    
                    String tableNamePrefix = tableName.substring(0, 2);
                    String semanticTableName = tableName.substring(2);
                    
                    if (! "T_".equals(tableNamePrefix)) {
                        fail("테이블 명명규칙(T_로 시작)에 맞지 않는 테이블입니다.");
                    } 
                    
                    Statement statement = realConnection.createStatement();
                    
                    statement.execute( String.format(dropSequenceStatementTemplate, semanticTableName) );
                    
                    statement.execute( String.format(createSequenceStatementTemplate, semanticTableName, initSequence) );
                }
                
            } else {
                fail("오라클이 아닌 DBMS의 시퀀스 초기화를 구현하세요.");
            }
        }
    };
}