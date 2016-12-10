package egovframework.com.ext.jstree.springHibernate.core.controller;

import java.math.BigDecimal;
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
import egovframework.com.ext.jstree.springHibernate.core.dao.JsTreeHibernateDaoImpl;
import egovframework.com.ext.jstree.springHibernate.core.vo.JsTreeHibernateDTO;
import egovframework.com.ext.jstree.support.mvc.GenericAbstractController;
import egovframework.com.ext.jstree.support.util.ParameterParser;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
@RequestMapping(value = { "/com/ext/jstree/springHibernate/core" })
public class JsTreeHibernateController extends GenericAbstractController {

	@SuppressWarnings("rawtypes")
	@Autowired
	private JsTreeHibernateDaoImpl jsTreeHibernateDao;

	/**
	 * jstree Spring + myBatis 버전의 첫페이지를 요청한다.
	 * 
	 * @return String jstreeSolutionSpringVersion 페이지를
	 */
	@IncludedInfo(name = "jsTree Spring-Hibernate",
			listUrl = "/com/ext/jstree/springHibernate/core/getJsTreeView.do",
			order = 3360,
			gid = 313)
	@RequestMapping("/getJsTreeView.do")
	public String jsTreeSpringHibernate() {
		return "egovframework/com/ext/jstree/springHibernateVersion";
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
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/getChildNode.do", method = RequestMethod.GET)
	public ModelAndView getChildNode(JsTreeHibernateDTO jsTreeHibernateDTO, ModelMap model, HttpServletRequest request)
			throws Exception {

		ParameterParser parser = new ParameterParser(request);

		if (parser.getInt("c_id") <= 0) {
			throw new RuntimeException();
		}
	    
		jsTreeHibernateDTO.setWhere("c_parentid", new BigDecimal(parser.get("c_id")));
		Class<?> clazz = JsTreeHibernateDTO.class;
		jsTreeHibernateDao.setClazz(clazz);
		List<JsTreeHibernateDTO> list = jsTreeHibernateDao.getList(jsTreeHibernateDTO);

		ModelAndView modelAndView = new ModelAndView("jsonView");
		modelAndView.addObject("result", list);
		return modelAndView;
	}

}
