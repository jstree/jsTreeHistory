package egovframework.com.ext.jstree.support.manager.mvc.dao.mybatis;

import java.util.List;

import org.springframework.dao.DataAccessException;

import egovframework.com.ext.jstree.support.manager.mvc.dao.GenericInterfaceDao;

public class MybatisSample implements GenericInterfaceDao<Object, Object, Object, Object> {

	@Override
	public Object invokeSelectOne(String statementName, Object parameterBean)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List invokeSelect(String statementName, Object parameterBean)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object invokeInsert(String statementName, Object parameterBean)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object invokeInsert(String statementName, Object parameterBean,
			Object sequenceKey) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object invokeUpdate(String statementName, Object parameterBean)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object invokeDelete(String statementName, Object parameterBean)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}
