package egovframework.com.ext.jstree.strutsiBatis.actionController;

import egovframework.com.ext.jstree.strutsiBatis.vo.T_ComprehensiveTree;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import egovframework.com.ext.jstree.strutsiBatis.service.I_S_RemoveNode;
import egovframework.com.ext.jstree.strutsiBatis.service.S_RemoveNode;
import egovframework.com.ext.jstree.strutsiBatis.service.Util_SwapNode;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

@SuppressWarnings("rawtypes")
public class C_RemoveNode extends ActionSupport implements Preparable,
		ModelDriven, ServletRequestAware, SessionAware, RequestAware {

	private static final long serialVersionUID = 7795427982040661127L;

	static Logger logger = Logger.getLogger(C_RemoveNode.class);

	T_ComprehensiveTree t_ComprehensiveTree;

	I_S_RemoveNode i_S_RemoveNode;

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
		return t_ComprehensiveTree;
	}

	@Override
	public void prepare() throws Exception {
		t_ComprehensiveTree = new T_ComprehensiveTree();

		i_S_RemoveNode = new S_RemoveNode();
	}

	@Override
	public String execute() {

		i_S_RemoveNode.setRequest(request);

		t_ComprehensiveTree
				.setStatus(i_S_RemoveNode.executeRemoveNode(Util_SwapNode
						.swapTtoP(t_ComprehensiveTree)));

		return Action.SUCCESS;
	}

	@Override
	public void validate() {

		if (request.getParameter("c_id") == null) {
			throw new RuntimeException();
		} else {
			if (request.getParameter("c_id").equals("0")
					|| request.getParameter("c_id").equals("1")) {
				throw new RuntimeException();
			}
		}

	}
}
