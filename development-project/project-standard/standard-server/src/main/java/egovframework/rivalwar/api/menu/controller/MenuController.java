package egovframework.rivalwar.api.menu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;

import egovframework.com.cmm.annotation.IncludedInfo;
import egovframework.com.ext.jstree.springHibernate.core.service.JsTreeHibernateSerive;
import egovframework.com.ext.jstree.support.mvc.GenericAbstractController;
import egovframework.com.ext.jstree.support.util.ParameterParser;
import egovframework.rivalwar.api.menu.service.MenuService;
import egovframework.rivalwar.api.menu.vo.MenuDTO;

@Controller
@RequestMapping(value = { "/rivalWar/api/menu" })
public class MenuController extends GenericAbstractController {

	@Autowired
	private MenuService menuService;
	
	@Autowired
	private JsTreeHibernateSerive jsTreeHibernateSerive;
	
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
}
