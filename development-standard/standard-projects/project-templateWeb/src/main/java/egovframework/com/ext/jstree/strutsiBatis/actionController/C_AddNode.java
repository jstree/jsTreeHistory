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
import egovframework.com.ext.jstree.strutsiBatis.service.I_S_AddNode;
import egovframework.com.ext.jstree.strutsiBatis.service.Util_SwapNode;
import egovframework.com.ext.jstree.strutsiBatis.service.Util_TitleChecker;
import egovframework.com.ext.jstree.strutsiBatis.vo.T_ComprehensiveTree;


/**
 * node를 추가한다
 * 
 *  @author 이동민
 *  @since 2014.07.28
 *  @version 1.0.0
 *  
 * P_ComprehensiveTree 와 T_ComprehensiveTree는 거의 동일한 형태의 dto(Data transfer object), vo (Value Object) 이다
 * 비슷하지만 따로 나눈것은 parameter 와 signature 의 차이를 명확히 하기 위해 선언하였다.
 * parameter는 dto로서 데이터가 포함된 객체를  한 시스템에서 다른 시스템으로 전달하는 작업을 처리하는 객체로 레이어간의 통신용도로 사용된다.
 * signature는 vo로서 특정한 비지니스 값이 담겨있는 객체이다.
 * 즉 메소드 입장에서 넘겨주는값은 parameter 넘겨받은 값은 signature라고 할수있다.
 * vo 와 dto 의 차이점은 vo는 read only이다.
 * 
 * 
 * Util_TitleChecker.
 * 
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

		//i_S_AddNode = new S_AddNode();
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
