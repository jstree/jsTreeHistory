package egovframework.com.ext.jstree.strutsiBatis.core.actionController;
			
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

import egovframework.com.ext.jstree.strutsiBatis.core.dto.P_ComprehensiveTree;
import egovframework.com.ext.jstree.strutsiBatis.core.service.I_S_AddNode;
import egovframework.com.ext.jstree.strutsiBatis.core.service.Util_SwapNode;
import egovframework.com.ext.jstree.strutsiBatis.core.service.Util_TitleChecker;
import egovframework.com.ext.jstree.strutsiBatis.core.vo.T_ComprehensiveTree;

/**
 * Modification Information
 * 
 * @author 이동민
 * @since 2014.07.28
 * @version 1.0
 * @see <pre>
 * 
 * Class Name 	: C_AddNode.java
 * Description 	: JSTree의 node를 추가하는 actionController 클래스
 * Infomation	: 
 *
 * node 추가
 * 
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일         수정자             수정내용
 *  -------      ------------   -----------------------
 *  2014.07.28    Dongmin.Lee      최초 생성 
 * 
 *  Copyright (C) 2007 by 313 DeveloperGroup  All right reserved.
 * </pre>
 * */
@SuppressWarnings("rawtypes")
public class C_AddNode extends ActionSupport implements Preparable,
		ModelDriven, ServletRequestAware, SessionAware, RequestAware {

	private static final long serialVersionUID = 3831129725610221181L;

	static Logger logger = Logger.getLogger(C_AddNode.class);

	P_ComprehensiveTree p_ComprehensiveTree;
	T_ComprehensiveTree t_ComprehensiveTree;

	@Resource(name="S_AddNode")
	I_S_AddNode i_S_AddNode;

	HttpServletRequest request;
	Map sessionMap;
	Map requestMap;

	@Override
	public Object getModel() {
		return t_ComprehensiveTree;
	}

	@Override
	public void prepare() throws Exception {
		p_ComprehensiveTree = new P_ComprehensiveTree();
		t_ComprehensiveTree = new T_ComprehensiveTree();
	}

	@Override
	public String execute() {

		t_ComprehensiveTree.setC_title(Util_TitleChecker
				.StringReplace(t_ComprehensiveTree.getC_title()));
		i_S_AddNode.setRequest(request);

		Util_SwapNode.copyTtoT(i_S_AddNode.addNode(Util_SwapNode
				.swapTtoP(t_ComprehensiveTree)), t_ComprehensiveTree);

		return Action.SUCCESS;
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
	public void validate() {

		if (request.getParameter("ref") == null
				|| request.getParameter("c_position") == null
				|| request.getParameter("c_title") == null
				|| request.getParameter("c_type") == null) {
			throw new RuntimeException("addNode parameter null");
		} else {
			if (request.getParameter("ref").equals("0")) {
				throw new RuntimeException("addNode ref value is 0");
			}

			if (Integer.parseInt(request.getParameter("c_position")) < 0) {
				throw new RuntimeException("addNode c_postion less 0");
			}

			if (request.getParameter("c_type").equals("default")
					|| request.getParameter("c_type").equals("folder")) {
			} else {
				if (request.getParameter("c_type").equals("drive")) {
					throw new RuntimeException(
							"addNode c_position value is drive");
				} else {
					throw new RuntimeException(
							"addNode c_position value is another");
				}
			}

		}

	}
}
