package egovframework.com.ext.jstree.springiBatis.core.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.collect.Maps;

import egovframework.com.cmm.annotation.IncludedInfo;
import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.springiBatis.core.util.Util_TitleChecker;
import egovframework.com.ext.jstree.springiBatis.core.validation.group.AddNode;
import egovframework.com.ext.jstree.springiBatis.core.validation.group.AlterNode;
import egovframework.com.ext.jstree.springiBatis.core.validation.group.AlterNodeType;
import egovframework.com.ext.jstree.springiBatis.core.validation.group.MoveNode;
import egovframework.com.ext.jstree.springiBatis.core.validation.group.RemoveNode;
import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;
import egovframework.com.ext.jstree.springiBatis.core.vo.PaginatedComprehensiveTree;
import egovframework.com.ext.jstree.support.mvc.GenericAbstractController;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

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
@RequestMapping(value = { "/com/ext/jstree/springmyBatis/core" })
public class CoreController extends GenericAbstractController{
	@Resource(name = "CoreService")
	CoreService coreService;

	/**
	 * jstree Struts + iBatis 버전의 첫페이지를 요청한다.
	 * 
	 * @return String jstreeSolutionStrutsVersion 페이지를
	 */
	@IncludedInfo(name = "jsTree Struts-iBatis", listUrl = "/com/ext/jstree/strutsiBatis/core/getJsTreeView.action", order = 3300, gid = 313)
	@RequestMapping("/strutsiBatis.do")
	public String jsTreeStrutsiBatis() {
		return "for struts iBatis annotation instead of controller";
	}
	
	/**
	 * jstree Spring + myBatis 버전의 첫페이지를 요청한다.
	 * 
	 * @return String jstreeSolutionSpringVersion 페이지를
	 */
	@IncludedInfo(name = "jsTree Spring-myBatis", listUrl = "/com/ext/jstree/springmyBatis/core/getJsTreeView.do", order = 3310, gid = 313)
	@RequestMapping("/getJsTreeView.do")
	public String jsTreeSpringmyBatis() {
		return "egovframework/com/ext/jstree/springmyBatisVersion";
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
	public ModelAndView getChildNode(ComprehensiveTree comprehensiveTree, ModelMap model,
			HttpServletRequest request) throws Exception {
		if (comprehensiveTree.getC_id() <= 0) {
			throw new RuntimeException();
		}
		ModelAndView modelAndView =  new ModelAndView("jsonView");
		modelAndView.addObject("result", coreService.getChildNode(comprehensiveTree));
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping("/getPaginatedChildNode.do")
	public ModelAndView getPaginatedChildNode(PaginatedComprehensiveTree paginatedComprehensiveTree, ModelMap model,
			HttpServletRequest request) throws Exception {
		if (paginatedComprehensiveTree.getC_id() <= 0) {
			throw new RuntimeException();
		}
		/** paging */
    	PaginationInfo paginationInfo = new PaginationInfo();
	    paginationInfo.setCurrentPageNo(paginatedComprehensiveTree.getPageIndex());
	    paginationInfo.setRecordCountPerPage(paginatedComprehensiveTree.getPageUnit());
	    paginationInfo.setPageSize(paginatedComprehensiveTree.getPageSize());
	    
	    paginatedComprehensiveTree.setFirstIndex(paginationInfo.getFirstRecordIndex());
	    paginatedComprehensiveTree.setLastIndex(paginationInfo.getLastRecordIndex());
	    paginatedComprehensiveTree.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
	    
	    List<PaginatedComprehensiveTree> resultChildNodes = coreService.getChildNode(paginatedComprehensiveTree);
	    paginationInfo.setTotalRecordCount(resultChildNodes.size());
	    
		ModelAndView modelAndView =  new ModelAndView("jsonView");
		HashMap<String, Object> resultMap = Maps.newHashMap();
		resultMap.put("paginationInfo", paginationInfo);
		resultMap.put("result", resultChildNodes);
		modelAndView.addObject("result", resultMap);
		return modelAndView;
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
	public ModelAndView searchNode(ComprehensiveTree comprehensiveTree, ModelMap model, HttpServletRequest request)
			throws Exception {
		if (!StringUtils.hasText(request.getParameter("searchString"))) {
			throw new RuntimeException();
		}

		comprehensiveTree.setSearchStr(request.getParameter("searchString"));

		ModelAndView modelAndView =  new ModelAndView("jsonView");
		modelAndView.addObject("result", coreService.searchNode(comprehensiveTree));
		return modelAndView;
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
	public ModelAndView addNode(@Validated(value = AddNode.class) ComprehensiveTree comprehensiveTree,
			BindingResult bindingResult, ModelMap model) throws Exception {
		if (bindingResult.hasErrors())
			throw new RuntimeException();

		comprehensiveTree.setC_title(Util_TitleChecker.StringReplace(comprehensiveTree.getC_title()));

		ModelAndView modelAndView =  new ModelAndView("jsonView");
		modelAndView.addObject("result", coreService.addNode(comprehensiveTree));
		return modelAndView;
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
	public ModelAndView removeNode(@Validated(value = RemoveNode.class) ComprehensiveTree comprehensiveTree,
			BindingResult bindingResult, ModelMap model) throws Exception {
		if (bindingResult.hasErrors())
			throw new RuntimeException();

		comprehensiveTree.setStatus(coreService.removeNode(comprehensiveTree));

		ModelAndView modelAndView =  new ModelAndView("jsonView");
		modelAndView.addObject("result", comprehensiveTree);
		return modelAndView;
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
	public ModelAndView alterNode(@Validated(value = AlterNode.class) ComprehensiveTree comprehensiveTree,
			BindingResult bindingResult, ModelMap model) throws Exception {
		if (bindingResult.hasErrors())
			throw new RuntimeException();

		comprehensiveTree.setC_title(Util_TitleChecker.StringReplace(comprehensiveTree.getC_title()));
		
		comprehensiveTree.setStatus(coreService.alterNode(comprehensiveTree));

		ModelAndView modelAndView =  new ModelAndView("jsonView");
		modelAndView.addObject("result", comprehensiveTree);
		return modelAndView;
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
	public ModelAndView alterNodeType(@Validated(value = AlterNodeType.class) ComprehensiveTree comprehensiveTree,
			BindingResult bindingResult, ModelMap model) throws Exception {
		if (bindingResult.hasErrors())
			throw new RuntimeException();

		coreService.alterNodeType(comprehensiveTree);

		ModelAndView modelAndView =  new ModelAndView("jsonView");
		modelAndView.addObject("result", comprehensiveTree);
		return modelAndView;
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
	public ModelAndView moveNode(@Validated(value = MoveNode.class) ComprehensiveTree comprehensiveTree,
			BindingResult bindingResult, ModelMap model, HttpServletRequest request) throws Exception {
		if (bindingResult.hasErrors())
			throw new RuntimeException();

		coreService.moveNode(comprehensiveTree, request);

		ModelAndView modelAndView =  new ModelAndView("jsonView");
		modelAndView.addObject("result", comprehensiveTree);
		return modelAndView;
	}

	@RequestMapping("/analyzeNode.do")
	public String getChildNode(ModelMap model) {
		model.addAttribute("analyzeResult", "");

		return "jsp/community/jsTreeAlg/jsTreeSpringDemo/analyzeResult";
	}

}