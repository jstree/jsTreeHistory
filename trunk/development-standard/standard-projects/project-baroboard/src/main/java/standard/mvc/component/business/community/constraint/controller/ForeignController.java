package standard.mvc.component.business.community.constraint.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import standard.mvc.component.business.community.constraint.vo.ForeignComprehensiveTree;

import com.fasterxml.jackson.core.JsonProcessingException;

import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.springiBatis.core.util.Util_TitleChecker;
import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;
import egovframework.com.ext.jstree.support.manager.mvc.controller.GenericAbstractController;

/**
 * Modification Information
 * 
 * @author Hoseong.Son
 * @since 2014.12.25
 * @version 1.0
 * @see <pre>
 * 	Class Name 	: ForeignController.java
 * 	Description : 제약조건 예제 중 외래키 트리 컨트롤러
 * 
 *  << 개정이력(Modification Information) >>
 * 
 *  수정일               수정자                 수정내용
 *  -------       ------------   -----------------------
 *  2014.12.25    Hoseong.Son           최초 생성
 * 
 *  Copyright (C) 2014 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Controller
@RequestMapping("/constraint/foreign")
public class ForeignController extends GenericAbstractController {

    @Resource(name = "ForeignService")
    private CoreService foreignService;

    @Override
    public Map<String, Map<String, Object>> bindTypes() {
        // TODO Auto-generated method stub
        return null;
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
    public List<ForeignComprehensiveTree> getChildNode(ForeignComprehensiveTree constraintComprehensiveTree, ModelMap model, HttpServletRequest request)
            throws Exception {

        if (constraintComprehensiveTree.getC_id() == 0) {
            throw new RuntimeException();
        }

        return foreignService.getChildNode(constraintComprehensiveTree);
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
    public List<String> searchNode(ForeignComprehensiveTree constraintComprehensiveTree, ModelMap model, HttpServletRequest request)
            throws Exception {

        if (!StringUtils.hasText(request.getParameter("searchString"))) {
            throw new RuntimeException();
        }

        constraintComprehensiveTree.setSearchStr(request.getParameter("searchString"));

        return foreignService.searchNode(constraintComprehensiveTree);
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
    public ComprehensiveTree addNode(ForeignComprehensiveTree constraintComprehensiveTree, ModelMap model, HttpServletRequest request)
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
        foreignService.addNode(constraintComprehensiveTree);

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
    public ComprehensiveTree removeNode(ForeignComprehensiveTree constraintComprehensiveTree, ModelMap model, HttpServletRequest request)
            throws Exception {

        if (request.getParameter("c_id") == null || request.getParameter("c_id").equals("0")
                || request.getParameter("c_id").equals("1")
                || request.getParameter("c_id").equals("2")
                || request.getParameter("c_id").equals("3")) {
            throw new RuntimeException();
        }

        constraintComprehensiveTree.setStatus(foreignService.removeNode(constraintComprehensiveTree));

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
    public ComprehensiveTree alterNode(ForeignComprehensiveTree constraintComprehensiveTree, ModelMap model, HttpServletRequest request)
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
        constraintComprehensiveTree.setStatus(foreignService.alterNode(constraintComprehensiveTree));

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
    public ComprehensiveTree alterNodeType(ForeignComprehensiveTree constraintComprehensiveTree, ModelMap model, HttpServletRequest request)
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

        foreignService.alterNodeType(constraintComprehensiveTree);

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
    public ComprehensiveTree moveNode( ForeignComprehensiveTree  constraintComprehensiveTree
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
        foreignService.moveNode(constraintComprehensiveTree, request);

        return constraintComprehensiveTree;
    }

}
