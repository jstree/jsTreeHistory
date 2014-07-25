package egovframework.com.ext.jstree.strutsiBatis.actionController;

import egovframework.com.ext.jstree.strutsiBatis.dto.P_ComprehensiveTree;
import egovframework.com.ext.jstree.strutsiBatis.vo.T_ComprehensiveTree;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import egovframework.com.ext.jstree.strutsiBatis.service.I_S_MoveNode;
import egovframework.com.ext.jstree.strutsiBatis.service.S_MoveNode;
import egovframework.com.ext.jstree.strutsiBatis.service.Util_SwapNode;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

@SuppressWarnings("rawtypes")
public class C_MoveNode extends ActionSupport implements Preparable,
		ModelDriven, ServletRequestAware, SessionAware, RequestAware {

	private static final long serialVersionUID = 4164420298258634557L;

	static Logger logger = Logger.getLogger(C_MoveNode.class);

	P_ComprehensiveTree p_ComprehensiveTree;
	T_ComprehensiveTree t_ComprehensiveTree;

	I_S_MoveNode i_S_MoveNode;

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
		p_ComprehensiveTree = new P_ComprehensiveTree();
		t_ComprehensiveTree = new T_ComprehensiveTree();

		i_S_MoveNode = new S_MoveNode();
	}

	@Override
	public String execute() {

		i_S_MoveNode.setRequest(request);
		Util_SwapNode.copyTtoT(i_S_MoveNode.moveNode(Util_SwapNode
				.swapTtoP(t_ComprehensiveTree)), t_ComprehensiveTree);
		return Action.SUCCESS;
	}

	@Override
	public void validate() {

		if (request.getParameter("c_id") == null
				|| request.getParameter("c_position") == null
				|| request.getParameter("copy") == null
				|| request.getParameter("multiCounter") == null
				|| request.getParameter("ref") == null) {
			throw new RuntimeException("invalid parameters Null");
		} else {
			if (request.getParameter("ref").equals("0")) {
				throw new RuntimeException("moveNode ref value is 0");
			}

			if (request.getParameter("c_id").equals("0")
					|| request.getParameter("c_id").equals("1")) {
				throw new RuntimeException("invalid parameters c_id is 0 or 1");
			}

			if (Integer.parseInt(request.getParameter("c_position")) < 0) {
				throw new RuntimeException("addNode c_postion less 0");
			}

			if (Integer.parseInt(request.getParameter("copy")) < 0) {
				throw new RuntimeException("addNode copy less 0");
			} else {
				if (Integer.parseInt(request.getParameter("copy")) > 1) {
					throw new RuntimeException("addNode copy lager 1");
				}
			}

			if (Integer.parseInt(request.getParameter("multiCounter")) < 0) {
				throw new RuntimeException("addNode multiCounter less 0");
			}
		}

	}

}