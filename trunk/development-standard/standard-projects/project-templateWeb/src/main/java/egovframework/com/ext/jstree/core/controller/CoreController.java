package egovframework.com.ext.jstree.core.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import egovframework.com.ext.jstree.core.service.CoreService;
import egovframework.com.ext.jstree.core.util.Util_SwapNode;
import egovframework.com.ext.jstree.core.util.Util_TitleChecker;
import egovframework.com.ext.jstree.core.vo.P_ComprehensiveTree;
import egovframework.com.ext.jstree.core.vo.T_ComprehensiveTree;

@Controller
public class CoreController {

	@Resource(name = "CoreService")
	CoreService coreService;
	
	
	@ResponseBody
	@RequestMapping("/egovframework/com/etc/jstree/core/getChildNode.do")
	public String getChildNode( P_ComprehensiveTree p_ComprehensiveTree
			                  , ModelMap            model
			                  , HttpServletRequest  request) throws JsonProcessingException {
		
		if( p_ComprehensiveTree.getC_id() == 0 ) {
			throw new RuntimeException();
		}
		
		List<T_ComprehensiveTree> t_GetChildNodes = new ArrayList<T_ComprehensiveTree>();
		t_GetChildNodes.addAll( coreService.getChildNode(p_ComprehensiveTree) );
		
		return new ObjectMapper().writeValueAsString(t_GetChildNodes);
	}
	
	
	@ResponseBody
	@RequestMapping("/egovframework/com/etc/jstree/core/searchNode.do")
	public String searchNode( P_ComprehensiveTree p_ComprehensiveTree
			                , ModelMap            model
			                , HttpServletRequest  request) throws JsonProcessingException {
		
		if( !StringUtils.hasText(p_ComprehensiveTree.getSearchStr()) ) {
			throw new RuntimeException();
		}
		
		List<String> searchNodeResults = new ArrayList<String>();
		searchNodeResults.addAll( coreService.searchNode(p_ComprehensiveTree) );
		
		return new ObjectMapper().writeValueAsString(searchNodeResults);
	}
	
	
	@ResponseBody
	@RequestMapping("/egovframework/com/etc/jstree/core/addNode.do")
	public String addNode( T_ComprehensiveTree t_ComprehensiveTree
			             , ModelMap            model
			             , HttpServletRequest  request) throws JsonProcessingException {
		
		if( request.getParameter("ref") == null
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
					throw new RuntimeException("addNode c_position value is drive");
				} else {
					throw new RuntimeException("addNode c_position value is another");
				}
			}
		}
		t_ComprehensiveTree.setC_title(Util_TitleChecker.StringReplace(t_ComprehensiveTree.getC_title()));
		Util_SwapNode.copyTtoT(coreService.addNode(Util_SwapNode.swapTtoP(t_ComprehensiveTree)), t_ComprehensiveTree);
		
		return new ObjectMapper().writeValueAsString(t_ComprehensiveTree);
	}
	
	
	@ResponseBody
	@RequestMapping("/egovframework/com/etc/jstree/core/removeNode.do")
	public String removeNode( T_ComprehensiveTree t_ComprehensiveTree
			                , ModelMap            model
			                , HttpServletRequest  request) throws JsonProcessingException {
		
		if(request.getParameter("c_id") == null || request.getParameter("c_id").equals("0")	|| request.getParameter("c_id").equals("1")) {
			throw new RuntimeException();
		}
		
		t_ComprehensiveTree.setStatus(coreService.executeRemoveNode(Util_SwapNode.swapTtoP(t_ComprehensiveTree)));
		
		return new ObjectMapper().writeValueAsString(t_ComprehensiveTree);
	}
	
	
	@ResponseBody
	@RequestMapping("/egovframework/com/etc/jstree/core/alterNode.do")
	public String alterNode( T_ComprehensiveTree t_ComprehensiveTree
			               , ModelMap            model
			               , HttpServletRequest  request) throws JsonProcessingException {
		
		if (request.getParameter("c_id") == null
				|| request.getParameter("c_title") == null
				|| request.getParameter("c_type") == null) {
			throw new RuntimeException("alterNode parameter null");
		} else {
			if (request.getParameter("c_id").equals("0")) {
				throw new RuntimeException("alterNode ref value is 0");
			}
			if (request.getParameter("c_id").equals("1")) {
				throw new RuntimeException("alterNode ref value is 1");
			}

			if (request.getParameter("c_type").equals("default")
					|| request.getParameter("c_type").equals("folder")) {
			} else {
				if (request.getParameter("c_type").equals("drive")) {
					throw new RuntimeException(
							"alterNode c_position value is drive");
				} else {
					throw new RuntimeException(
							"alterNode c_position value is another");
				}
			}
		}
		
		t_ComprehensiveTree.setC_title(Util_TitleChecker.StringReplace(t_ComprehensiveTree.getC_title()));
		t_ComprehensiveTree.setStatus( coreService.alterNode(Util_SwapNode.swapTtoP(t_ComprehensiveTree)) );
		
		return new ObjectMapper().writeValueAsString(t_ComprehensiveTree);
	}
	
	
	@ResponseBody
	@RequestMapping("/egovframework/com/etc/jstree/core/alterNodeType.do")
	public String alterNodeType( T_ComprehensiveTree t_ComprehensiveTree
			                   , ModelMap            model
			                   , HttpServletRequest  request) throws JsonProcessingException {
		
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
		
		coreService.alterNodeType(Util_SwapNode.swapTtoP(t_ComprehensiveTree));
		
		return new ObjectMapper().writeValueAsString(t_ComprehensiveTree);
	}
	
	
	@ResponseBody
	@RequestMapping("/egovframework/com/etc/jstree/core/moveNode.do")
	public String moveNode( T_ComprehensiveTree t_ComprehensiveTree
			              , ModelMap            model
			              , HttpServletRequest  request) throws JsonProcessingException {
		
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
		
		Util_SwapNode.copyTtoT(coreService.moveNode(Util_SwapNode.swapTtoP(t_ComprehensiveTree)), t_ComprehensiveTree);
		
		return new ObjectMapper().writeValueAsString(t_ComprehensiveTree);
	}
	
	
	// 뭔지 알 수가 없다.
	@RequestMapping("/egovframework/com/etc/jstree/core/analyzeNode.do")
	public String getChildNode(ModelMap model) {
		
		model.addAttribute("alayzeResult", "");
		
		return "/jsp/egovframework/com/ext/jstree/analyzeResult";
	}
	
	
	@RequestMapping("/egovframework/com/etc/jstree/main.do")
	public String jstreeMain() {
		
		return "/jsp/egovframework/com/ext/jstree/jstreeSolutionStrutsVersion";
	}
}