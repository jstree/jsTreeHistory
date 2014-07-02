package standard.mvc.manager.viewResolver;

import java.io.File;
import java.util.Locale;

import org.apache.commons.lang.SystemUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

public class CustomEgovUrlBasedViewResolver extends UrlBasedViewResolver {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public View resolveViewName(String viewName, Locale locale)
			throws Exception {
		
		String contextRealPath = getServletContext().getRealPath("/");
		viewName = viewName.replace("/", SystemUtils.FILE_SEPARATOR);
		String localViewFullPath = contextRealPath + "WEB-INF/jsp/egovframework/example/" + viewName + ".jsp";
		File localViewFile = new File(localViewFullPath);
		//파일이 존재한다면
		if(localViewFile.isFile()){
			return super.resolveViewName(viewName, locale);
		}else{
			return null;
		}
	}

}