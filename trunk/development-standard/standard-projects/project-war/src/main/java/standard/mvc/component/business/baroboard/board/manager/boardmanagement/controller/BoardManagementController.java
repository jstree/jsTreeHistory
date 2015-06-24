package standard.mvc.component.business.baroboard.board.manager.boardmanagement.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import standard.mvc.component.business.baroboard.board.manager.boardmanagement.vo.BoardManagementVO;
import standard.mvc.component.business.baroboard.board.manager.defaultsetting.vo.DefaultSettingVO;
import standard.mvc.component.business.baroboard.user.manage.grade.service.UserGradeService;
import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.springiBatis.core.validation.group.AlterNode;
import egovframework.com.ext.jstree.support.manager.mvc.controller.GenericAbstractController;

/**
 * 
 * Modification Information
 * 
 * @author 정원기
 * @since 2015. 6. 24.
 * @version 1.0
 * @see <pre>
 * Class Name  : BoardManagementController.java
 * Description : 바로보드-게시판-admin-게시판설정 Controller
 * Information :
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------       ------------   -----------------------
 * 2015. 6. 24.      정원기                 최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Controller
@RequestMapping(value = "/board/manager/boardmanagement")
public class BoardManagementController extends GenericAbstractController {

    @Resource(name = "BoardManagementService")
    private CoreService boardManagementService;
    
    @Autowired
    private UserGradeService userGradeService;

    @Override
    public Map<String, Map<String, Object>> bindTypes() {
        // TODO Auto-generated method stub
        return null;
    }

    @RequestMapping(value = "/list.do", method = {RequestMethod.GET})
    public String getChildNode( BoardManagementVO  boardManagementVO
    		                  , ModelMap           modelMap
    		                  , HttpServletRequest request) throws Exception {
    	boardManagementVO.setC_parentid(2);
        modelMap.addAttribute("list", boardManagementService.getChildNode(boardManagementVO));
        return "/jsp/baroboard/board/manager/boardmanagement/edit";
    }
    
    @RequestMapping(value = "/edit.do", method = {RequestMethod.GET})
    public String getNode(ModelMap modelMap, HttpServletRequest request) throws Exception {
    	DefaultSettingVO generalVO = new DefaultSettingVO();
    	generalVO.setC_id(3);
    	modelMap.addAttribute("defaultSetting", boardManagementService.getNode(generalVO));
    	return "/jsp/baroboard/board/manager/boardmanagement/edit";
    }

    @ResponseBody
    @RequestMapping(value = "/save.do", method = {RequestMethod.POST})
    public DefaultSettingVO alterNode( @Validated(value = AlterNode.class) DefaultSettingVO defaultSettingVO
    		                         , BindingResult bindingResult
    		                         , ModelMap model ) throws Exception {
        if (bindingResult.hasErrors()) {
            throw new RuntimeException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        defaultSettingVO.setStatus(boardManagementService.alterNode(defaultSettingVO));
        return defaultSettingVO;
    }

}