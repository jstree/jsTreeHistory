package egovframework.com.ext.jstree.springiBatis.core.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;

import egovframework.com.cmm.annotation.IncludedInfo;
import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.springiBatis.core.util.Util_TitleChecker;
import egovframework.com.ext.jstree.springiBatis.core.validation.group.AddNode;
import egovframework.com.ext.jstree.springiBatis.core.validation.group.AlterNode;
import egovframework.com.ext.jstree.springiBatis.core.validation.group.AlterNodeType;
import egovframework.com.ext.jstree.springiBatis.core.validation.group.MoveNode;
import egovframework.com.ext.jstree.springiBatis.core.validation.group.RemoveNode;
import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;
import egovframework.com.ext.jstree.support.manager.mvc.controller.GenericAbstractController;

/**
 * Modification Information
 * 
 * @author taekyung.Lee
 * @since 2014. 7. 30.
 * @version 1.0
 * @see <pre>
 * 	Class Name 	: CoreController.java
 * 	Description : jstree 의 Spring+iBatis 버젼의 컨트롤러 클래스
 * 	Infomation	: jstree Controller 정보. 
 *  
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일         수정자             수정내용
 *  -------      ------------   -----------------------
 *  2014. 7. 30.  taekyung.Lee        최초 생성
 *  2015. 3.  5.  전경훈            @Validated 를 통한 파라미터 빈 검증
 *  
 *  Copyright (C) 2014 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Controller
@RequestMapping(value = { "/egovframework/com/etc/jstree/springiBatis/core" })
public class CoreController extends GenericAbstractController {
	@Resource(name = "CoreService")
	CoreService coreService;

	/**
	 * jstree Spring + iBatis 버전의 첫페이지를 요청한다.
	 * 
	 * @return String jstreeSolutionSpringVersion 페이지를
	 */
	@IncludedInfo(name = "JSTREE", listUrl = "/jstree/getTree.do", order = 7313, gid = 313)
	@RequestMapping("/getTree.do")
	public String jsTreeCoreIndex() {
		return "/jsp/egovframework/com/ext/jstree/jstreeSolutionSpringVersion";
	}

	/**
	 * 자식노드를 요청한다.
	 * 
	 * @param comprehensiveTree
	 * @param model
	 * @param request
	 * @return String
	 * @throws JsonProcessingException
	 */
	@ResponseBody
	@RequestMapping("/getChildNode.do")
	public List<ComprehensiveTree> getChildNode(ComprehensiveTree comprehensiveTree, ModelMap model,
			HttpServletRequest request) throws Exception {
		if (comprehensiveTree.getC_id() <= 0) {
			throw new RuntimeException();
		}

		return coreService.getChildNode(comprehensiveTree);
	}

	/**
	 * 노드를 검색한다.
	 * 
	 * @param comprehensiveTree
	 * @param model
	 * @param request
	 * @return
	 * @throws JsonProcessingException
	 */
	@ResponseBody
	@RequestMapping("/searchNode.do")
	public List<String> searchNode(ComprehensiveTree comprehensiveTree, ModelMap model, HttpServletRequest request)
			throws Exception {
		if (!StringUtils.hasText(request.getParameter("searchString"))) {
			throw new RuntimeException();
		}

		comprehensiveTree.setSearchStr(request.getParameter("searchString"));

		return coreService.searchNode(comprehensiveTree);
	}

	/**
	 * 노드를 추가한다.
	 * 
	 * @param comprehensiveTree
	 * @param model
	 * @param request
	 * @return
	 * @throws JsonProcessingException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	@ResponseBody
	@RequestMapping("/addNode.do")
	public ComprehensiveTree addNode(@Validated(value = AddNode.class) ComprehensiveTree comprehensiveTree,
			BindingResult bindingResult, ModelMap model) throws Exception {
		if (bindingResult.hasErrors())
			throw new RuntimeException();

		comprehensiveTree.setC_title(Util_TitleChecker.StringReplace(comprehensiveTree.getC_title()));

		return coreService.addNode(comprehensiveTree);
	}

	/**
	 * 노드를 삭제한다.
	 * 
	 * @param comprehensiveTree
	 * @param model
	 * @param request
	 * @return
	 * @throws JsonProcessingException
	 */
	@ResponseBody
	@RequestMapping("/removeNode.do")
	public ComprehensiveTree removeNode(@Validated(value = RemoveNode.class) ComprehensiveTree comprehensiveTree,
			BindingResult bindingResult, ModelMap model) throws Exception {
		if (bindingResult.hasErrors())
			throw new RuntimeException();

		comprehensiveTree.setStatus(coreService.removeNode(comprehensiveTree));

		return comprehensiveTree;
	}

	/**
	 * 노드를 변경한다.
	 * 
	 * @param comprehensiveTree
	 * @param model
	 * @param request
	 * @return
	 * @throws JsonProcessingException
	 */
	@ResponseBody
	@RequestMapping("/alterNode.do")
	public ComprehensiveTree alterNode(@Validated(value = AlterNode.class) ComprehensiveTree comprehensiveTree,
			BindingResult bindingResult, ModelMap model) throws Exception {
		if (bindingResult.hasErrors())
			throw new RuntimeException();

		comprehensiveTree.setC_title(Util_TitleChecker.StringReplace(comprehensiveTree.getC_title()));
		comprehensiveTree.setStatus(coreService.alterNode(comprehensiveTree));

		return comprehensiveTree;
	}

	/**
	 * 노드의 타입을 변경한다.
	 * 
	 * @param comprehensiveTree
	 * @param model
	 * @param request
	 * @return
	 * @throws JsonProcessingException
	 */
	@ResponseBody
	@RequestMapping("/alterNodeType.do")
	public ComprehensiveTree alterNodeType(@Validated(value = AlterNodeType.class) ComprehensiveTree comprehensiveTree,
			BindingResult bindingResult, ModelMap model) throws Exception {
		if (bindingResult.hasErrors())
			throw new RuntimeException();

		coreService.alterNodeType(comprehensiveTree);

		return comprehensiveTree;
	}

	/**
	 * 노드를 이동한다.
	 * 
	 * @param comprehensiveTree
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
	public ComprehensiveTree moveNode(@Validated(value = MoveNode.class) ComprehensiveTree comprehensiveTree,
			BindingResult bindingResult, ModelMap model, HttpServletRequest request) throws Exception {
		if (bindingResult.hasErrors())
			throw new RuntimeException();

		coreService.moveNode(comprehensiveTree, request);

		return comprehensiveTree;
	}

	// 뭔지 알 수가 없다.
	@RequestMapping("/analyzeNode.do")
	public String getChildNode(ModelMap model) {
		model.addAttribute("analyzeResult", "");

		return "jsp/community/jsTreeAlg/jsTreeSpringDemo/analyzeResult";
	}

	/**
	 * TODO description methods.
	 * 
	 * @return
	 */
	@RequestMapping("/mainTest.do")
	public String jstreeMain() {
		return "/jsp/egovframework/com/ext/jstree/jstreeSolutionSpringVersion";
	}

	@Override
	public Map<String, Map<String, Object>> bindTypes() {
		// TODO Auto-generated method stub
		return null;
	}

}