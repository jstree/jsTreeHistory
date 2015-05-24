package standard.mvc.component.business.baroboard.core.manage.setting.server.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import standard.mvc.component.business.baroboard.core.manage.setting.server.vo.ServerVO;
import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
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

    @RequestMapping(value = "/index.do")
    public ServerVO getNode(ModelMap modelMap, HttpServletRequest request)
            throws Exception {
        ServerVO serverVO = new ServerVO();
        serverVO.setC_id(4);
        return serverService.getNode(serverVO);
    }

}
