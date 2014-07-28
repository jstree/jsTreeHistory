package egovframework.com.ext.jstree.strutsiBatis.actionController;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import egovframework.com.ext.jstree.strutsiBatis.dto.P_ComprehensiveTree;
import egovframework.com.ext.jstree.strutsiBatis.service.I_S_AlterNodeType;
import egovframework.com.ext.jstree.strutsiBatis.service.Util_SwapNode;
import egovframework.com.ext.jstree.strutsiBatis.vo.T_ComprehensiveTree;

@SuppressWarnings("rawtypes")
public class C_AlterNodeType extends ActionSupport implements Preparable,
		ModelDriven, ServletRequestAware, SessionAware, RequestAware {

	private static final long serialVersionUID = 432763084094442313L;

	static Logger logger = Logger.getLogger(C_AlterNodeType.class);

	P_ComprehensiveTree p_ComprehensiveTree;
	T_ComprehensiveTree t_ComprehensiveTree;

	@Resource(name="S_AlterNodeType")
	I_S_AlterNodeType i_S_AlterNodeType;

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

		//i_S_AlterNodeType = new S_AlterNodeType();
	}

	@Override
	public String execute() {
		i_S_AlterNodeType.setRequest(request);
		i_S_AlterNodeType.alterNodeType(Util_SwapNode
				.swapTtoP(t_ComprehensiveTree));

		return Action.SUCCESS;
	}

	@Override
	public void validate() {

		if (request.getParameter("c_id") == null
				|| request.getParameter("c_type") == null) {
			throw new RuntimeException();
		} else {
			if (request.getParameter("c_id").equals("0")) {
				throw new RuntimeException("alterNodeType c_id value is 0");
			}
			if (request.getParameter("c_id").equals("1")) {
				throw new RuntimeException("alterNodeType c_id value is 1");
			}

			if (request.getParameter("c_type").equals("default")
					|| request.getParameter("c_type").equals("folder")) {
			} else {
				if (request.getParameter("c_type").equals("drive")) {
					throw new RuntimeException(
							"alterNodeType c_position value is drive");
				} else {
					throw new RuntimeException(
							"alterNodeType c_position value is another");
				}
			}
		}

	}
}
