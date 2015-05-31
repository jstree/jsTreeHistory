package standard.mvc.component.business.baroboard.core.manage.setting.upload.controller;

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

import standard.mvc.component.business.baroboard.core.manage.setting.upload.vo.UploadVO;
import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.springiBatis.core.validation.group.AlterNode;
import egovframework.com.ext.jstree.support.manager.mvc.controller.GenericAbstractController;

/**
 * 
 * Modification Information
 * 
 * @author 손호성
 * @since 2015. 5. 31.
 * @version 1.0
 * @see <pre>
 * Class Name  : UploadController.java
 * Description : 바로보드-코어-고급설정-파일업로드 Controller
 * Infomation  :
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------       ------------   -----------------------
 * 2015. 5. 31.         손호성                 최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Controller
@RequestMapping(value = "/core/manage/setting/upload")
public class UploadController extends GenericAbstractController {

	@Resource(name = "UploadService")
	private CoreService uploadService;

	@Override
	public Map<String, Map<String, Object>> bindTypes() {
		return null;
	}

	@RequestMapping(value = "/index.do", method = { RequestMethod.GET })
	public String getNode(ModelMap modelMap, HttpServletRequest request)
			throws Exception {
		UploadVO uploadVO = new UploadVO();
		uploadVO.setC_id(4);
		modelMap.addAttribute("upload", uploadService.getNode(uploadVO));
		return "/jsp/baroboard/core/manage/setting/upload/index";
	}

	@ResponseBody
	@RequestMapping(value = "/save.do", method = { RequestMethod.POST })
	public UploadVO alterNode(
			@Validated(value = AlterNode.class) UploadVO uploadVO,
			BindingResult bindingResult, ModelMap model) throws Exception {
		if (bindingResult.hasErrors()) {
			throw new RuntimeException(bindingResult.getAllErrors().get(0)
					.getDefaultMessage());
		}

		uploadVO.setStatus(uploadService.alterNode(uploadVO));

		return uploadVO;
	}

}
