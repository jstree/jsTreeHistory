package egovframework.com.ext.jstree.springiBatis.core.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import egovframework.com.cmm.annotation.IncludedInfo;
import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.springiBatis.core.util.Util_TitleChecker;
import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

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
 * 
 *  Copyright (C) 2014 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Controller
public class CoreController
{
    
    @Resource(name = "CoreService")
    CoreService coreService;
    
    /**
     * jstree Spring + iBatis 버전의 첫페이지를 요청한다.
     * 
     * @return String jstreeSolutionSpringVersion 페이지를
     */
    @IncludedInfo(
            name = "JSTREE",
            listUrl = "/jstree/getTree.do",
            order = 7313,
            gid = 313)
    @RequestMapping("/jstree/getTree.do")
    public String jsTreeCoreIndex()
    {
        return "/jsp/egovframework/example/egovframework/com/ext/jstree/jstreeSolutionSpringVersion";
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
    @RequestMapping("/egovframework/com/etc/jstree/springiBatis/core/getChildNode.do")
    public String getChildNode(ComprehensiveTree comprehensiveTree,
            ModelMap model, HttpServletRequest request)
            throws JsonProcessingException
    {
        
        if (comprehensiveTree.getC_id() == 0) { throw new RuntimeException(); }
        
        return new ObjectMapper().writeValueAsString(coreService
                .getChildNode(comprehensiveTree));
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
    @RequestMapping("/egovframework/com/etc/jstree/springiBatis/core/searchNode.do")
    public String searchNode(ComprehensiveTree comprehensiveTree,
            ModelMap model, HttpServletRequest request)
            throws JsonProcessingException
    {
        
        if (!StringUtils.hasText(comprehensiveTree.getSearchStr())) { throw new RuntimeException(); }
        
        return new ObjectMapper().writeValueAsString(coreService
                .searchNode(comprehensiveTree));
    }
    
    /**
     * 노드를 추가한다.
     * 
     * @param comprehensiveTree
     * @param model
     * @param request
     * @return
     * @throws JsonProcessingException
     */
    @ResponseBody
    @RequestMapping("/egovframework/com/etc/jstree/springiBatis/core/addNode.do")
    public String addNode(ComprehensiveTree comprehensiveTree, ModelMap model,
            HttpServletRequest request) throws JsonProcessingException
    {
        
        if (request.getParameter("ref") == null
                || request.getParameter("c_position") == null
                || request.getParameter("c_title") == null
                || request.getParameter("c_type") == null)
        {
            throw new RuntimeException("addNode parameter null");
        }
        else
        {
            if (request.getParameter("ref").equals("0")) { throw new RuntimeException(
                    "addNode ref value is 0"); }
            
            if (Integer.parseInt(request.getParameter("c_position")) < 0) { throw new RuntimeException(
                    "addNode c_postion less 0"); }
            
            if (request.getParameter("c_type").equals("default")
                    || request.getParameter("c_type").equals("folder"))
            {
            }
            else
            {
                if (request.getParameter("c_type").equals("drive"))
                {
                    throw new RuntimeException(
                            "addNode c_position value is drive");
                }
                else
                {
                    throw new RuntimeException(
                            "addNode c_position value is another");
                }
            }
        }
        comprehensiveTree.setC_title(Util_TitleChecker
                .StringReplace(comprehensiveTree.getC_title()));
        coreService.addNode(comprehensiveTree);
        
        return new ObjectMapper().writeValueAsString(comprehensiveTree);
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
    @RequestMapping("/egovframework/com/etc/jstree/springiBatis/core/removeNode.do")
    public String removeNode(ComprehensiveTree comprehensiveTree,
            ModelMap model, HttpServletRequest request)
            throws JsonProcessingException
    {
        
        if (request.getParameter("c_id") == null
                || request.getParameter("c_id").equals("0")
                || request.getParameter("c_id").equals("1")) { throw new RuntimeException(); }
        
        comprehensiveTree.setStatus(coreService
                .executeRemoveNode(comprehensiveTree));
        
        return new ObjectMapper().writeValueAsString(comprehensiveTree);
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
    @RequestMapping("/egovframework/com/etc/jstree/springiBatis/core/alterNode.do")
    public String alterNode(ComprehensiveTree comprehensiveTree,
            ModelMap model, HttpServletRequest request)
            throws JsonProcessingException
    {
        
        if (request.getParameter("c_id") == null
                || request.getParameter("c_title") == null
                || request.getParameter("c_type") == null)
        {
            throw new RuntimeException("alterNode parameter null");
        }
        else
        {
            if (request.getParameter("c_id").equals("0")) { throw new RuntimeException(
                    "alterNode ref value is 0"); }
            if (request.getParameter("c_id").equals("1")) { throw new RuntimeException(
                    "alterNode ref value is 1"); }
            
            if (request.getParameter("c_type").equals("default")
                    || request.getParameter("c_type").equals("folder"))
            {
            }
            else
            {
                if (request.getParameter("c_type").equals("drive"))
                {
                    throw new RuntimeException(
                            "alterNode c_position value is drive");
                }
                else
                {
                    throw new RuntimeException(
                            "alterNode c_position value is another");
                }
            }
        }
        
        comprehensiveTree.setC_title(Util_TitleChecker
                .StringReplace(comprehensiveTree.getC_title()));
        comprehensiveTree.setStatus(coreService.alterNode(comprehensiveTree));
        
        return new ObjectMapper().writeValueAsString(comprehensiveTree);
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
    @RequestMapping("/egovframework/com/etc/jstree/springiBatis/core/alterNodeType.do")
    public String alterNodeType(ComprehensiveTree comprehensiveTree,
            ModelMap model, HttpServletRequest request)
            throws JsonProcessingException
    {
        
        if (request.getParameter("c_id") == null
                || request.getParameter("c_type") == null)
        {
            throw new RuntimeException();
        }
        else
        {
            if (request.getParameter("c_id").equals("0")) { throw new RuntimeException(
                    "alterNodeType c_id value is 0"); }
            if (request.getParameter("c_id").equals("1")) { throw new RuntimeException(
                    "alterNodeType c_id value is 1"); }
            
            if (request.getParameter("c_type").equals("default")
                    || request.getParameter("c_type").equals("folder"))
            {
            }
            else
            {
                if (request.getParameter("c_type").equals("drive"))
                {
                    throw new RuntimeException(
                            "alterNodeType c_position value is drive");
                }
                else
                {
                    throw new RuntimeException(
                            "alterNodeType c_position value is another");
                }
            }
        }
        
        coreService.alterNodeType(comprehensiveTree);
        
        return new ObjectMapper().writeValueAsString(comprehensiveTree);
    }
    
    /**
     * 노드를 이동한다.
     * 
     * @param comprehensiveTree
     * @param model
     * @param request
     * @return
     * @throws JsonProcessingException
     */
    @ResponseBody
    @RequestMapping("/egovframework/com/etc/jstree/springiBatis/core/moveNode.do")
    public String moveNode(ComprehensiveTree comprehensiveTree, ModelMap model,
            HttpServletRequest request) throws JsonProcessingException
    {
        
        if (request.getParameter("c_id") == null
                || request.getParameter("c_position") == null
                || request.getParameter("copy") == null
                || request.getParameter("multiCounter") == null
                || request.getParameter("ref") == null)
        {
            throw new RuntimeException("invalid parameters Null");
        }
        else
        {
            if (request.getParameter("ref").equals("0")) { throw new RuntimeException(
                    "moveNode ref value is 0"); }
            
            if (request.getParameter("c_id").equals("0")
                    || request.getParameter("c_id").equals("1")) { throw new RuntimeException(
                    "invalid parameters c_id is 0 or 1"); }
            
            if (Integer.parseInt(request.getParameter("c_position")) < 0) { throw new RuntimeException(
                    "addNode c_postion less 0"); }
            
            if (Integer.parseInt(request.getParameter("copy")) < 0)
            {
                throw new RuntimeException("addNode copy less 0");
            }
            else
            {
                if (Integer.parseInt(request.getParameter("copy")) > 1) { throw new RuntimeException(
                        "addNode copy lager 1"); }
            }
            
            if (Integer.parseInt(request.getParameter("multiCounter")) < 0) { throw new RuntimeException(
                    "addNode multiCounter less 0"); }
        }
        
        coreService.moveNode(comprehensiveTree);
        
        return new ObjectMapper().writeValueAsString(comprehensiveTree);
    }
    
    // 뭔지 알 수가 없다.
    @RequestMapping("/egovframework/com/etc/jstree/springiBatis/core/analyzeNode.do")
    public String getChildNode(ModelMap model)
    {
        
        model.addAttribute("analyzeResult", "");
        
        return "/jsp/egovframework/example/egovframework/com/ext/jstree/analyzeResult";
    }
    
    /**
     * TODO description methods.
     * 
     * @return
     */
    @RequestMapping("/egovframework/com/etc/jstree/springiBatis/main.do")
    public String jstreeMain()
    {
        
        return "/jsp/egovframework/example/egovframework/com/ext/jstree/jstreeSolutionSpringVersion";
    }
}