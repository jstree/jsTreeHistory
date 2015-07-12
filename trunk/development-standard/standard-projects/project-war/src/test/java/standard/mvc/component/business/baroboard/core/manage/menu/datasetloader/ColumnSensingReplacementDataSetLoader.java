package standard.mvc.component.business.baroboard.core.manage.menu.datasetloader;

import java.io.InputStream;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ReplacementDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.springframework.core.io.Resource;

import com.github.springtestdbunit.dataset.AbstractDataSetLoader;

public class ColumnSensingReplacementDataSetLoader extends
		AbstractDataSetLoader {

	@Override
	protected IDataSet createDataSet(Resource paramResource) throws Exception {
		FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
		builder.setColumnSensing(true);
		try (InputStream inputStream = paramResource.getInputStream()) {
			return createReplacementDataSet(builder.build(inputStream));
		}
	}

	private ReplacementDataSet createReplacementDataSet(FlatXmlDataSet dataSet) {
		ReplacementDataSet replacementDataSet = new ReplacementDataSet(dataSet);

		// Configure the replacement dataset to replace '[null]' strings with
		// null.
		replacementDataSet.addReplacementObject("[null]", null);

		return replacementDataSet;
	}

}
