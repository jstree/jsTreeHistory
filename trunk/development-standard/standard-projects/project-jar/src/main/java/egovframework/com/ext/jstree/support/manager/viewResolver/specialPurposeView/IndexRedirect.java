package egovframework.com.ext.jstree.support.manager.viewResolver.specialPurposeView;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

public class IndexRedirect extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.sendRedirect("/assets/app/index.html");
		return;
	}

}
