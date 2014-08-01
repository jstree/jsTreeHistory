package egovframework.com.ext.jstree.strutsiBatis.actionController;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * Jstree의 이벤트를 보여주는 분석 화면
 * 
 * @author 이동민
 * @since 2014.07.28
 * @version 1.0.0
 * 
 * */
@SuppressWarnings("rawtypes")
public class C_AnalyzeNodeOfJstreeSolution extends ActionSupport implements
		Preparable, ModelDriven, ServletRequestAware, SessionAware,
		RequestAware {

	private static final long serialVersionUID = -3617970050236026092L;

	static Logger logger = Logger
			.getLogger(C_AnalyzeNodeOfJstreeSolution.class);

	StringBuilder alayzeResult;

	HttpServletRequest request;
	Map sessionMap;
	Map requestMap;

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void setSession(Map session) {
		this.sessionMap = session;
	}

	@Override
	public void setRequest(Map requestMap) {
		this.requestMap = requestMap;
	}

	@Override
	public Object getModel() {
		return alayzeResult.toString();
	}

	@Override
	public void prepare() throws Exception {
		alayzeResult = new StringBuilder();
	}

	@Override
	public String execute() {

		// T_ComprehensiveTree rootNode = crud_JstreeSolutionStrutsVersion
		// .analyzeRootNode();
		//
		// if (rootNode == null) {
		// alayzeResult.append("[FAIL]\tNo root node.").append("</br>");
		// } else {
		// alayzeResult.append("[OK]\tJust one root node.").append("</br>");
		// }
		return Action.SUCCESS;
	}

	@Override
	public void validate() {

	}

}
