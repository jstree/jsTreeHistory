package standard.mvc.component.business.resources.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import standard.mvc.component.base.controller.GenericAbstractController;
import standard.mvc.component.base.dao.hibernate.SearchSupport;

/**
 * Class Name : TemplateMethodResolveViewSupporter.java Description : WEBDAV를
 * 활용하여 뷰 리졸버와의 결합을 통한 디자인과 개발을 완전하게 분리하는 목적의 클래스 Modification Information
 * 
 * @author Dongmin.Lee
 * @since 2014.06.18
 * @version 1.0
 * @see
 * 
 *      <pre>
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일         수정자             수정내용
 *  -------      ------------   -----------------------
 *  2014.06.18    Dongmin.Lee      최초 생성
 * 
 *  Copyright (C) 2007 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */

@Controller
@RequestMapping(value = { "/static" })
public class StaticResourceController extends GenericAbstractController
{
    
    @Override
    public Map<String, Map<String, Object>> bindTypes()
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    public String test()
    {
        this.getClass().getAnnotations();
        
        return "";
    }
    
    @RequestMapping(
            value = { "/{templateEngine}/{viewResolver}/{siteCode}/{largeMenu}/{middleMenu}/{smallMenu}/{componentCode}/{action}.do" },
            method = { RequestMethod.GET, RequestMethod.POST })
    public String invokeSelect(SearchSupport searchSupport, ModelMap modelMap,
            HttpServletRequest request, HttpServletResponse response,
            BindingResult bindingResult, Object parameterBean)
    {
        return getView(searchSupport, modelMap, request, response, bindingResult, parameterBean);
    }
    
}