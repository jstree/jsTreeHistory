package egovframework.com.ext.jstree.strutsiBatis.actionController;

import egovframework.com.ext.jstree.strutsiBatis.dto.P_ComprehensiveTree;
import egovframework.com.ext.jstree.strutsiBatis.vo.T_ComprehensiveTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import egovframework.com.ext.jstree.strutsiBatis.service.I_S_GetChildNode;
import egovframework.com.ext.jstree.strutsiBatis.service.S_GetChildNode;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

@SuppressWarnings("rawtypes")
public class C_GetChildNode extends ActionSupport implements Preparable,
		ModelDriven, ServletRequestAware, SessionAware, RequestAware {

	private static final long serialVersionUID = 1135059314438464570L;

	static Logger logger = Logger.getLogger(C_GetChildNode.class);

	P_ComprehensiveTree p_ComprehensiveTree;
	List<T_ComprehensiveTree> t_GetChildNodes;

	@Resource(name="S_GetChildNode")
	I_S_GetChildNode i_S_GetChildNode;

	HttpServletRequest request;
	Map sessionMap;
	Map requestMap;

	@Override
	public Object getModel() {
		return t_GetChildNodes;
	}

	@Override
	public void prepare() throws Exception {
		p_ComprehensiveTree = new P_ComprehensiveTree();
		t_GetChildNodes = new ArrayList<T_ComprehensiveTree>();

		//i_S_GetChildNode = new S_GetChildNode();
	}

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
	public String execute() {
		p_ComprehensiveTree.setC_id(Integer.parseInt(request
				.getParameter("c_id")));

		i_S_GetChildNode.setRequest(request);

		t_GetChildNodes.addAll(i_S_GetChildNode
				.getChildNode(p_ComprehensiveTree));

		return Action.SUCCESS;
	}

	@Override
	public void validate() {

		if (request.getParameter("c_id") == null) {
			throw new RuntimeException();
		} else {
			if (request.getParameter("c_id").equals("0")) {
				throw new RuntimeException();
			}
		}

	}

}
