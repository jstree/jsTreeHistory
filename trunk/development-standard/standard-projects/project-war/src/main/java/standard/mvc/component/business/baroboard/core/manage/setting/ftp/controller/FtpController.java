package standard.mvc.component.business.baroboard.core.manage.setting.ftp.controller;

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

import standard.mvc.component.business.baroboard.core.manage.setting.ftp.vo.FtpVO;
import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.springiBatis.core.validation.group.AlterNode;
import egovframework.com.ext.jstree.support.manager.mvc.controller.GenericAbstractController;

/**
 * 
 * Modification Information
 * 
 * @author 손호성
 * @since 2015. 5. 29.
 * @version 1.0
 * @see <pre>
 *  Class Name  : FtpController.java
 *  Description : 바로보드-코어-고급설정-FTP Controller
 *  Infomation  :
 * 
 *  << 개정이력(Modification Information) >>
 * 
 *  수정일              수정자                  수정내용
 *  -------       ------------   -----------------------
 *  2015. 5. 29.        손호성                  최초생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Controller
@RequestMapping(value = "/core/manage/setting/ftp")
public class FtpController extends GenericAbstractController {

    @Resource(name = "FtpService")
    private CoreService ftpService;

    @Override
    public Map<String, Map<String, Object>> bindTypes() {
        return null;
    }

    @RequestMapping(value = "/index.do", method = {RequestMethod.GET})
    public String getNode(ModelMap modelMap, HttpServletRequest request) throws Exception {
        FtpVO ftpVO = new FtpVO();
        ftpVO.setC_id(4);
        modelMap.addAttribute("ftp", ftpService.getNode(ftpVO));
        return "/jsp/baroboard/core/manage/setting/ftp/index";
    }

    @ResponseBody
    @RequestMapping(value = "/save.do", method = {RequestMethod.POST})
    public FtpVO alterNode(@Validated(value = AlterNode.class) FtpVO ftpVO,
            BindingResult bindingResult, ModelMap model) throws Exception {
        if (bindingResult.hasErrors()) {
            throw new RuntimeException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }

        ftpVO.setStatus(ftpService.alterNode(ftpVO));

        return ftpVO;
    }

}
