package egovframework.com.ext.jstree.springiBatis.core.dao;

import java.io.InputStream;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.springframework.core.io.Resource;
import com.github.springtestdbunit.dataset.AbstractDataSetLoader;
/**
 * Modification Information
 * 
 * @author HyungChae.Kim
 * @since 2015.4.23
 * @version 1.0
 * @see <pre>
 * 	Class Name 	: ColumnSensingFlatXmlDataSetLoader.java
 * 	Description : Xml 컬럼 일치하는 것만 비교하도록 설정 변경
 *  
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일               	    수정자                         수정내용
 *  -------       ------------   -----------------------
 *  2015.02.27    HyungChae.Kim  최초 생성
 *  Copyright (C) 2014 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
public class ColumnSensingFlatXmlDataSetLoader extends AbstractDataSetLoader
{
	@Override
	protected IDataSet createDataSet(Resource resource) throws Exception
	{
		FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
		builder.setColumnSensing(true);
		InputStream inputStream = resource.getInputStream();
		
		try
		{
			return builder.build(inputStream);

		} 
		finally
		{
			inputStream.close();
		}
	}
}