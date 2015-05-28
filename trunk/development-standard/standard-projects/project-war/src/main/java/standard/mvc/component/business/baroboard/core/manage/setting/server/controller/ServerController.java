package standard.mvc.component.business.baroboard.core.manage.setting.server.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import standard.mvc.component.business.baroboard.core.manage.setting.server.vo.ServerVO;
import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.springiBatis.core.validation.group.AlterNode;
import egovframework.com.ext.jstree.support.manager.mvc.controller.GenericAbstractController;

/**
 * 
 * Modification Information
 * 
 * @author 손호성
 * @since 2015. 5. 24.
 * @version 1.0
 * @see <pre>
 * Class Name  : ServerController.java
 * Description : 바로보드-코어-고급설정-서버 Controller
 * Infomation  :
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------       ------------   -----------------------
 * 2015. 5. 24.       손호성                 최초 생성
 * 2015. 5. 25.       손호성                 alterNode validator 적용
 * 2015. 5. 26.       손호성                 jsp 경로 변경
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Controller
@RequestMapping(value = "/core/manage/setting/server")
public class ServerController extends GenericAbstractController {

    @Resource(name = "ServerService")
    private CoreService serverService;


    @Override
    public Map<String, Map<String, Object>> bindTypes() {
        // TODO Auto-generated method stub
        return null;
    }

    @RequestMapping(value = "/index.do", method = {RequestMethod.GET})
    public String getNode(ModelMap modelMap, HttpServletRequest request) throws Exception {
        ServerVO serverVO = new ServerVO();
        serverVO.setC_id(4);
        modelMap.addAttribute("server", serverService.getNode(serverVO));
        return "/jsp/baroboard/core/manage/setting/server/index";
    }

    @ResponseBody
    @RequestMapping(value = "/save.do", method = {RequestMethod.POST})
    public ServerVO alterNode(@Validated(value = AlterNode.class) ServerVO serverVO,
            BindingResult bindingResult, ModelMap model) throws Exception {
        if (bindingResult.hasErrors()) {
            throw new RuntimeException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }

        serverVO.setStatus(serverService.alterNode(serverVO));

        return serverVO;
    }

}
