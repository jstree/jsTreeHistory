package egovframework.com.ext.jstree.springHibernate.core.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import egovframework.com.ext.jstree.springHibernate.core.service.I_S_GetChildNode;
import egovframework.com.ext.jstree.springHibernate.core.vo.P_JsTree;
import egovframework.com.ext.jstree.support.manager.mvc.controller.GenericAbstractController;
import egovframework.com.ext.jstree.support.manager.mvc.controller.GenericInterfaceController;
import egovframework.com.ext.jstree.support.manager.mvc.dao.hibernate.SearchSupport;

@Controller
public class C_GetChildNode extends GenericAbstractController implements
        GenericInterfaceController<P_JsTree>
{
    
    Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Resource(name = "Hibernate_S_GetChildNode")
    I_S_GetChildNode i_S_GetChildNode;
    
    @Override
    @ResponseBody
    @RequestMapping("/egovframework/com/ext/jstree/springHibernate/getChildNode.do")
    public String invokeSelect(SearchSupport searchSupport, ModelMap modelMap,
            HttpServletRequest request, HttpServletResponse response,
            BindingResult bindingResult, P_JsTree parameterBean)
    {
        try
        {
            return new ObjectMapper().writeValueAsString(i_S_GetChildNode
                    .getChildNode(parameterBean));
        }
        catch (JsonProcessingException e)
        {
            logger.error(this.getClass() + " : invokeSelect = " + e.toString());
        }
        return getView(searchSupport, modelMap, request, response,
                       bindingResult, parameterBean);
    }
    
    @Override
    public String invokeInsert(SearchSupport searchSupport, ModelMap modelMap,
            HttpServletRequest request, HttpServletResponse response,
            BindingResult bindingResult, P_JsTree parameterBean)
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public String invokeUpdate(SearchSupport searchSupport, ModelMap modelMap,
            HttpServletRequest request, HttpServletResponse response,
            BindingResult bindingResult, P_JsTree parameterBean)
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public String invokeDelete(SearchSupport searchSupport, ModelMap modelMap,
            HttpServletRequest request, HttpServletResponse response,
            BindingResult bindingResult, P_JsTree parameterBean)
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public Map<String, Map<String, Object>> bindTypes()
    {
        // TODO Auto-generated method stub
        return null;
    }
    
}
