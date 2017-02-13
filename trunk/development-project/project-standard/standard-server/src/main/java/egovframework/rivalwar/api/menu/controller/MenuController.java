package egovframework.rivalwar.api.menu.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.collect.Maps;

import egovframework.com.cmm.annotation.IncludedInfo;
import egovframework.com.ext.jstree.springmyBatis.core.util.Util_TitleChecker;
import egovframework.com.ext.jstree.springmyBatis.core.validation.group.AddNode;
import egovframework.com.ext.jstree.springmyBatis.core.validation.group.AlterNode;
import egovframework.com.ext.jstree.springmyBatis.core.validation.group.AlterNodeType;
import egovframework.com.ext.jstree.springmyBatis.core.validation.group.MoveNode;
import egovframework.com.ext.jstree.springmyBatis.core.validation.group.RemoveNode;
import egovframework.com.ext.jstree.support.mvc.GenericAbstractController;
import egovframework.com.ext.jstree.support.util.ParameterParser;
import egovframework.rivalwar.api.menu.service.MenuService;
import egovframework.rivalwar.api.menu.vo.MenuDTO;

@Controller
@RequestMapping(value = { "/rivalWar/api/menu" })
public class MenuController extends GenericAbstractController {

	@Autowired
	private MenuService menuService;

	@IncludedInfo(name = "RivalWar Admin Menu",
			listUrl = "/rivalWar/api/menu/admin/getJsTreeView.do",
			order = 7000,
			gid = 3131)
	@RequestMapping("/admin/getJsTreeView.do")
	public String jsTreeSpringHibernate() {
		return "egovframework/rivalWar/api/menu/admin/JsTreeView";
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
	@RequestMapping(value = "/getChildMenu.do", method = RequestMethod.GET)
	public ModelAndView getChildMenu(MenuDTO jsTreeHibernateDTO, ModelMap model, HttpServletRequest request)
			throws Exception {

		ParameterParser parser = new ParameterParser(request);

		if (parser.getInt("c_id") <= 0) {
			throw new RuntimeException();
		}

		jsTreeHibernateDTO.setWhere("c_parentid", new Long(parser.get("c_id")));
		List<MenuDTO> list = menuService.getChildMenu(jsTreeHibernateDTO);

		ModelAndView modelAndView = new ModelAndView("jsonView");
		modelAndView.addObject("result", list);
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping(value = "/getPaginatedChildMenu.do", method = RequestMethod.GET)
	public ModelAndView getPaginatedChildMenu(MenuDTO jsTreeHibernateDTO, ModelMap model, HttpServletRequest request)
			throws Exception {

		if (jsTreeHibernateDTO.getC_id() <= 0 || jsTreeHibernateDTO.getPageIndex() <= 0
				|| jsTreeHibernateDTO.getPageUnit() <= 0 || jsTreeHibernateDTO.getPageSize() <= 0) {
			throw new RuntimeException();
		}
		
		jsTreeHibernateDTO.setWhere("c_parentid", jsTreeHibernateDTO.getC_id());
		List<MenuDTO> list = menuService.getPaginatedChildMenu(jsTreeHibernateDTO);
		jsTreeHibernateDTO.getPaginationInfo().setTotalRecordCount(list.size());

		ModelAndView modelAndView = new ModelAndView("jsonView");
		HashMap<String, Object> resultMap = Maps.newHashMap();
		resultMap.put("paginationInfo", jsTreeHibernateDTO.getPaginationInfo());
		resultMap.put("result", list);
		modelAndView.addObject("result", resultMap);
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping(value = "/getMenu.do", method = RequestMethod.GET)
	public ModelAndView getMenu(MenuDTO jsTreeHibernateDTO, ModelMap model, HttpServletRequest request)
			throws Exception {

		ParameterParser parser = new ParameterParser(request);

		if (parser.getInt("c_id") <= 0) {
			throw new RuntimeException();
		}

		MenuDTO menuDTO = menuService.getMenu(jsTreeHibernateDTO);

		ModelAndView modelAndView = new ModelAndView("jsonView");
		modelAndView.addObject("result", menuDTO);
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
	@RequestMapping(value = "/searchMenu.do", method = RequestMethod.GET)
	public ModelAndView searchNode(MenuDTO jsTreeHibernateDTO, ModelMap model, HttpServletRequest request)
			throws Exception {

		ParameterParser parser = new ParameterParser(request);

		if (!StringUtils.hasText(request.getParameter("searchString"))) {
			throw new RuntimeException();
		}

		jsTreeHibernateDTO.setWhereLike("c_title", parser.get("parser"));
		ModelAndView modelAndView = new ModelAndView("jsonView");
		modelAndView.addObject("result", menuService.searchMenu(jsTreeHibernateDTO));
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
	@RequestMapping(value = "/addMenu.do", method = RequestMethod.POST)
	public ModelAndView addMenu(@Validated(value = AddNode.class) MenuDTO jsTreeHibernateDTO,
			BindingResult bindingResult, ModelMap model) throws Exception {
		if (bindingResult.hasErrors())
			throw new RuntimeException();

		jsTreeHibernateDTO.setC_title(Util_TitleChecker.StringReplace(jsTreeHibernateDTO.getC_title()));

		ModelAndView modelAndView = new ModelAndView("jsonView");
		modelAndView.addObject("result", menuService.addMenu(jsTreeHibernateDTO));
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
	@RequestMapping(value = "/removeMenu.do", method = RequestMethod.POST)
	public ModelAndView removeNode(@Validated(value = RemoveNode.class) MenuDTO jsTreeHibernateDTO,
			BindingResult bindingResult, ModelMap model) throws Exception {
		if (bindingResult.hasErrors())
			throw new RuntimeException();

		jsTreeHibernateDTO.setStatus(menuService.removeMenu(jsTreeHibernateDTO));
		setJsonDefaultSetting(jsTreeHibernateDTO);

		ModelAndView modelAndView = new ModelAndView("jsonView");
		modelAndView.addObject("result", jsTreeHibernateDTO);
		return modelAndView;
	}

	private void setJsonDefaultSetting(MenuDTO jsTreeHibernateDTO) {
		long defaultSettingValue = 0;
		jsTreeHibernateDTO.setC_parentid(defaultSettingValue);
		jsTreeHibernateDTO.setC_position(defaultSettingValue);
		jsTreeHibernateDTO.setC_left(defaultSettingValue);
		jsTreeHibernateDTO.setC_right(defaultSettingValue);
		jsTreeHibernateDTO.setC_level(defaultSettingValue);
		jsTreeHibernateDTO.setRef(defaultSettingValue);
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
	@RequestMapping(value = "/alterMenu.do", method = RequestMethod.POST)
	public ModelAndView alterNode(@Validated(value = AlterNode.class) MenuDTO jsTreeHibernateDTO,
			BindingResult bindingResult, ModelMap model) throws Exception {
		if (bindingResult.hasErrors())
			throw new RuntimeException();

		jsTreeHibernateDTO.setC_title(Util_TitleChecker.StringReplace(jsTreeHibernateDTO.getC_title()));

		jsTreeHibernateDTO.setStatus(menuService.alterMenu(jsTreeHibernateDTO));
		setJsonDefaultSetting(jsTreeHibernateDTO);

		ModelAndView modelAndView = new ModelAndView("jsonView");
		modelAndView.addObject("result", jsTreeHibernateDTO);
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
	@RequestMapping(value = "/alterNodeMenu.do", method = RequestMethod.POST)
	public ModelAndView alterNodeType(@Validated(value = AlterNodeType.class) MenuDTO jsTreeHibernateDTO,
			BindingResult bindingResult, ModelMap model) throws Exception {
		if (bindingResult.hasErrors())
			throw new RuntimeException();

		menuService.alterMenuType(jsTreeHibernateDTO);
		setJsonDefaultSetting(jsTreeHibernateDTO);
		ModelAndView modelAndView = new ModelAndView("jsonView");
		modelAndView.addObject("result", jsTreeHibernateDTO);
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
	@RequestMapping(value = "/moveMenu.do", method = RequestMethod.POST)
	public ModelAndView moveNode(@Validated(value = MoveNode.class) MenuDTO jsTreeHibernateDTO,
			BindingResult bindingResult, ModelMap model, HttpServletRequest request) throws Exception {
		if (bindingResult.hasErrors())
			throw new RuntimeException();

		menuService.moveMenu(jsTreeHibernateDTO, request);
		setJsonDefaultSetting(jsTreeHibernateDTO);

		ModelAndView modelAndView = new ModelAndView("jsonView");
		modelAndView.addObject("result", jsTreeHibernateDTO);
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping(value = "/analyzeMenu.do", method = RequestMethod.GET)
	public ModelAndView getChildNode(ModelMap model) {
		model.addAttribute("analyzeResult", "");

		ModelAndView modelAndView = new ModelAndView("jsonView");
		modelAndView.addObject("result", "ture");
		return modelAndView;
	}
}
