package standard.mvc.component.business.baroboard.user.manage.grade.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import standard.mvc.component.business.baroboard.user.manage.basic.setting.general.service.GeneralSettingService;
import standard.mvc.component.business.baroboard.user.manage.basic.setting.general.service.ProhibitionWordService;
import standard.mvc.component.business.baroboard.user.manage.basic.setting.general.vo.GeneralSetting;
import standard.mvc.component.business.baroboard.user.manage.basic.setting.general.vo.ProhibitionWord;
import standard.mvc.component.business.baroboard.user.manage.grade.service.UserGradeService;
import standard.mvc.component.business.baroboard.user.manage.grade.vo.UserGradeManage;
import standard.mvc.component.business.community.constraint.vo.ForeignComprehensiveTree;
import egovframework.com.ext.jstree.springiBatis.core.util.Util_TitleChecker;
import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;
import egovframework.com.ext.jstree.support.manager.mvc.controller.GenericAbstractController;
import egovframework.com.ext.jstree.support.util.StringUtils;

/**
 * Modification Information
 * 
 * @author 김대근
 * @since 2015. 5. 30.
 * @version 1.0
 * @see <pre>
 * Class Name  : UserGradeManageController.java
 * Description : 회원등급관리 Controller
 * Infomation  : 회원등급관리 Controller
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일                 수정자                     수정내용
 * -------      ------------  -----------------------
 * 2015. 5. 30.      김대근       최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Controller
@RequestMapping("/user/manage/grade/")
public class UserGradeManageController extends GenericAbstractController {

    @Autowired
    private UserGradeService userGradeService;
    
//    @Resource(name = "fileUploadProperties")
//    Properties fileUploadProperties;
    
    @RequestMapping("/index.do")
    public String main(ModelMap model) throws Exception {
        return "/jsp/user/manage/grade/index";
    }

    @ResponseBody
    @RequestMapping("/inquiryUserGradeList.do")
    public List<UserGradeManage> inquiryUserGradeList(UserGradeManage userGradeManage) throws Exception {
        return userGradeService.inquiryUserGradeList(userGradeManage);
    }
    
    @ResponseBody
	@RequestMapping(value="/addNode.do", method=RequestMethod.POST)
	public UserGradeManage addNode(UserGradeManage userGradeManage, MultipartHttpServletRequest request) throws Exception {
    	
    	Map<String, MultipartFile> files = request.getFileMap();
    	//Map<String, MultipartFile> files = request.getFileMap().get("uploadImgFile");

    	String uploadPath = "test";//fileUploadProperties.getProperty("file.upload.path");
    	String defaultImagePath = request.getSession().getServletContext().getRealPath("/") + "images\\userGrade\\upload\\";
    	uploadPath = defaultImagePath + uploadPath;
    	
    	File saveFolder = new File(uploadPath);

    	// 디렉토리 생성
    	if (!saveFolder.exists() || saveFolder.isFile()) {
    		saveFolder.mkdirs();
    	}
    	System.out.println(uploadPath);
    	
    	Iterator<Entry<String, MultipartFile>> itr = files.entrySet().iterator();
    	MultipartFile file = null;
    	String filePath = null;;
    	
    	while (itr.hasNext()) {
    		Entry<String, MultipartFile> entry = itr.next();
    	 
    		file = entry.getValue();
    		if (!"".equals(file.getOriginalFilename())) {
    			filePath = uploadPath + file.getOriginalFilename();
    			userGradeManage.setIconFileNm(file.getOriginalFilename());
    			userGradeManage.setStoreFileNm(file.getOriginalFilename()); //추후 서버에 저장될 파일명으로 변경 해야함.
    			file.transferTo(new File(filePath));
    		}
    	}

    	userGradeService.saveUserGradeDetailInf(userGradeManage);
		return userGradeService.inquiryUserGradeDetailInf(userGradeManage);
	}
    
	@ResponseBody
    @RequestMapping(value="/alterNode.do", method=RequestMethod.POST)
    public UserGradeManage alterNode(UserGradeManage userGradeManage, MultipartHttpServletRequest request) throws Exception {
    	Map<String, MultipartFile> files = request.getFileMap();

    	String uploadPath = "C:\\temp";//fileUploadProperties.getProperty("file.upload.path");
    	File saveFolder = new File(uploadPath);

    	// 디렉토리 생성
    	if (!saveFolder.exists() || saveFolder.isFile()) {
    		saveFolder.mkdirs();
    	}

    	Iterator<Entry<String, MultipartFile>> itr = files.entrySet().iterator();
    	MultipartFile file = null;
    	String filePath = null;;
    	
    	while (itr.hasNext()) {
    		Entry<String, MultipartFile> entry = itr.next();
    	 
    		file = entry.getValue();
    		if (!"".equals(file.getOriginalFilename())) {
    			filePath = uploadPath + "\\" + file.getOriginalFilename();
    			userGradeManage.setIconFileNm(file.getOriginalFilename());
    			userGradeManage.setStoreFileNm(file.getOriginalFilename()); //추후 서버에 저장될 파일명으로 변경 해야함.
    			file.transferTo(new File(filePath));
    		}
    	}
    	
    	userGradeService.updateUserGradeInf(userGradeManage);
    	return userGradeService.inquiryUserGradeDetailInf(userGradeManage);
    }
    
	@ResponseBody 
    @RequestMapping(value="/inquiryUserGradeDetailInf.do", method=RequestMethod.POST)
    public UserGradeManage inquiryUserGradeDetailInf(@RequestBody UserGradeManage userGradeManage, ModelMap model, HttpServletRequest request) throws Exception {
    	return userGradeService.inquiryUserGradeDetailInf(userGradeManage);
    }
    
    @ResponseBody
    @RequestMapping(value="/removeNode.do", method=RequestMethod.POST)
    public String removeNode(@RequestBody UserGradeManage userGradeManage, ModelMap model, HttpServletRequest request) throws Exception {
    	userGradeService.removeUserGradeInf(userGradeManage);
    	userGradeService.inquiryUserGradeList(userGradeManage);
    	return "{}";
    }
    
    private String ddd(){
    	
    	return null;
    }
    
	@Override
	public Map<String, Map<String, Object>> bindTypes() {
		// TODO Auto-generated method stub
		return null;
	}
}