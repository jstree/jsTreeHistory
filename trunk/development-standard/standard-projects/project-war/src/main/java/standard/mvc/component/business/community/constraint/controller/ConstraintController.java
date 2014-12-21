package standard.mvc.component.business.community.constraint.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import standard.mvc.component.base.controller.GenericAbstractController;
import standard.mvc.component.business.community.constraint.vo.ConstraintComprehensiveTree;

import com.fasterxml.jackson.core.JsonProcessingException;

import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.springiBatis.core.util.Util_TitleChecker;
import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

@Controller
@RequestMapping("/constraint")
public class ConstraintController extends GenericAbstractController {

	@Resource(name = "ConstraintService")
	private CoreService constraintService;

	@Override
	public Map<String, Map<String, Object>> bindTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping("/getChildNodeByFk.do")
	public List<ConstraintComprehensiveTree> getChildNodeByFk(
			@ModelAttribute ConstraintComprehensiveTree constraintComprehensiveTree)
			throws Exception {
		constraintComprehensiveTree.setQueryUsingFk(true);
		return constraintService.getChildNode(constraintComprehensiveTree);
	}
	
	/**
	 * 자식노드를 요청한다.
	 * 
	 * @param constraintComprehensiveTree
	 * @param model
	 * @param request
	 * @return String
	 * @throws JsonProcessingException
	 */
	@ResponseBody
	@RequestMapping("/getChildNode.do")
	public List<ConstraintComprehensiveTree> getChildNode(ConstraintComprehensiveTree constraintComprehensiveTree, ModelMap model, HttpServletRequest request)
			 throws Exception {
		
		if (constraintComprehensiveTree.getC_id() == 0) {
			throw new RuntimeException();
		}

		return constraintService.getChildNode(constraintComprehensiveTree);
	}

	/**
	 * 노드를 검색한다.
	 * 
	 * @param constraintComprehensiveTree
	 * @param model
	 * @param request
	 * @return
	 * @throws JsonProcessingException
	 */
	@ResponseBody
	@RequestMapping("/searchNode.do")
	public List<String> searchNode(ConstraintComprehensiveTree constraintComprehensiveTree, ModelMap model, HttpServletRequest request)
			 throws Exception {
		
		if (!StringUtils.hasText(request.getParameter("searchString"))) {
			throw new RuntimeException();
		}
		
		constraintComprehensiveTree.setSearchStr(request.getParameter("searchString"));

		return constraintService.searchNode(constraintComprehensiveTree);
	}

	/**
	 * 노드를 추가한다.
	 * 
	 * @param constraintComprehensiveTree
	 * @param model
	 * @param request
	 * @return
	 * @throws JsonProcessingException
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	@ResponseBody
	@RequestMapping("/addNode.do")
	public ComprehensiveTree addNode(ConstraintComprehensiveTree constraintComprehensiveTree, ModelMap model, HttpServletRequest request)
			 throws Exception {

		if (request.getParameter("ref") == null || request.getParameter("c_position") == null
				|| request.getParameter("c_title") == null || request.getParameter("c_type") == null) {
			throw new RuntimeException("addNode parameter null");
		} else {
			if (request.getParameter("ref").equals("0")) {
				throw new RuntimeException("addNode ref value is 0");
			}

			if (Integer.parseInt(request.getParameter("c_position")) < 0) {
				throw new RuntimeException("addNode c_postion less 0");
			}

			if (request.getParameter("c_type").equals("default") || request.getParameter("c_type").equals("folder")) {
			} else {
				if (request.getParameter("c_type").equals("drive")) {
					throw new RuntimeException("addNode c_position value is drive");
				} else {
					throw new RuntimeException("addNode c_position value is another");
				}
			}
		}
		constraintComprehensiveTree.setC_title(Util_TitleChecker.StringReplace(constraintComprehensiveTree.getC_title()));
		constraintService.addNode(constraintComprehensiveTree);

		return constraintComprehensiveTree;
	}

	/**
	 * 노드를 삭제한다.
	 * 
	 * @param constraintComprehensiveTree
	 * @param model
	 * @param request
	 * @return
	 * @throws JsonProcessingException
	 */
	@ResponseBody
	@RequestMapping("/removeNode.do")
	public ComprehensiveTree removeNode(ConstraintComprehensiveTree constraintComprehensiveTree, ModelMap model, HttpServletRequest request)
			 throws Exception {

		if (request.getParameter("c_id") == null || request.getParameter("c_id").equals("0")
				|| request.getParameter("c_id").equals("1")) {
			throw new RuntimeException();
		}

		constraintComprehensiveTree.setStatus(constraintService.removeNode(constraintComprehensiveTree));

		return constraintComprehensiveTree;
	}

	/**
	 * 노드를 변경한다.
	 * 
	 * @param constraintComprehensiveTree
	 * @param model
	 * @param request
	 * @return
	 * @throws JsonProcessingException
	 */
	@ResponseBody
	@RequestMapping("/alterNode.do")
	public ComprehensiveTree alterNode(ConstraintComprehensiveTree constraintComprehensiveTree, ModelMap model, HttpServletRequest request)
			 throws Exception {

		if (request.getParameter("c_id") == null || request.getParameter("c_title") == null
				|| request.getParameter("c_type") == null) {
			throw new RuntimeException("alterNode parameter null");
		} else {
			if (request.getParameter("c_id").equals("0")) {
				throw new RuntimeException("alterNode ref value is 0");
			}
			if (request.getParameter("c_id").equals("1")) {
				throw new RuntimeException("alterNode ref value is 1");
			}

			if (request.getParameter("c_type").equals("default") || request.getParameter("c_type").equals("folder")) {
			} else {
				if (request.getParameter("c_type").equals("drive")) {
					throw new RuntimeException("alterNode c_position value is drive");
				} else {
					throw new RuntimeException("alterNode c_position value is another");
				}
			}
		}

		constraintComprehensiveTree.setC_title(Util_TitleChecker.StringReplace(constraintComprehensiveTree.getC_title()));
		constraintComprehensiveTree.setStatus(constraintService.alterNode(constraintComprehensiveTree));

		return constraintComprehensiveTree;
	}

	/**
	 * 노드의 타입을 변경한다.
	 * 
	 * @param constraintComprehensiveTree
	 * @param model
	 * @param request
	 * @return
	 * @throws JsonProcessingException
	 */
	@ResponseBody
	@RequestMapping("/alterNodeType.do")
	public ComprehensiveTree alterNodeType(ConstraintComprehensiveTree constraintComprehensiveTree, ModelMap model, HttpServletRequest request)
			 throws Exception {

		if (request.getParameter("c_id") == null || request.getParameter("c_type") == null) {
			throw new RuntimeException();
		} else {
			if (request.getParameter("c_id").equals("0")) {
				throw new RuntimeException("alterNodeType c_id value is 0");
			}
			if (request.getParameter("c_id").equals("1")) {
				throw new RuntimeException("alterNodeType c_id value is 1");
			}

			if (request.getParameter("c_type").equals("default") || request.getParameter("c_type").equals("folder")) {
			} else {
				if (request.getParameter("c_type").equals("drive")) {
					throw new RuntimeException("alterNodeType c_position value is drive");
				} else {
					throw new RuntimeException("alterNodeType c_position value is another");
				}
			}
		}

		constraintService.alterNodeType(constraintComprehensiveTree);

		return constraintComprehensiveTree;
	}

	/**
	 * 노드를 이동한다.
	 * 
	 * @param constraintComprehensiveTree
	 * @param model
	 * @param request
	 * @return
	 * @throws JsonProcessingException
	 * @throws ReflectiveOperationException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	@ResponseBody
	@RequestMapping("/moveNode.do")
	public ComprehensiveTree moveNode( ComprehensiveTree  constraintComprehensiveTree
			                         , ModelMap           model
			                         , HttpServletRequest request )
			 throws Exception {

		if (request.getParameter("c_id") == null || request.getParameter("c_position") == null
				|| request.getParameter("copy") == null || request.getParameter("multiCounter") == null
				|| request.getParameter("ref") == null) {
			throw new RuntimeException("invalid parameters Null");
		} else {
			if (request.getParameter("ref").equals("0")) {
				throw new RuntimeException("moveNode ref value is 0");
			}

			if (request.getParameter("c_id").equals("0") || request.getParameter("c_id").equals("1")) {
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
		constraintService.moveNode(constraintComprehensiveTree, request);

		return constraintComprehensiveTree;
	}	

}
