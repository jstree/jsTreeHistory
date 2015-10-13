package standard.mvc.component.business.baroboard.user.note.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import standard.mvc.component.business.baroboard.user.note.service.UserNoteService;
import standard.mvc.component.business.baroboard.user.note.vo.UserNoteAttachFile;
import standard.mvc.component.business.baroboard.user.note.vo.UserNoteByUser;
import standard.mvc.component.business.baroboard.user.note.vo.UserNoteDetail;
import standard.mvc.component.business.baroboard.user.service.UserService;
import standard.mvc.component.business.baroboard.user.vo.User;

import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.support.manager.mvc.controller.GenericAbstractController;
import egovframework.com.ext.jstree.support.manager.mvc.tags.ui.pagination.AsyncPaginationTextRenderer;
import egovframework.com.ext.jstree.support.manager.security.login.vo.SecureUserLogin;
import egovframework.com.ext.jstree.support.util.DateUtils;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
@RequestMapping("/user/note")
public class UserNoteController extends GenericAbstractController {

	@Autowired
	private UserNoteService userNoteService;
	
	@Autowired
	private UserService userService;
	
	@Resource(name = "CoreService")
    private CoreService coreService;
	
	@Autowired
    private AsyncPaginationTextRenderer asyncPaginaionTexRenderer;
	
	@Resource(name = "fileUploadProperties")
	private Properties fileUploadProperties;
	
	@RequestMapping("/index.do")
    public String main(ModelMap model) throws Exception {
		Date currentDay      = DateUtils.getCurrentDay();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String receDispDt    = sdf.format(currentDay); //수발신일시
		
		model.addAttribute("inqStartYmd", receDispDt);
		model.addAttribute("inqEndYmd"  , receDispDt);
        return "/jsp/user/note/index";
    }
	
	@RequestMapping(value="/noteSendPopup.do", method={RequestMethod.GET, RequestMethod.POST})
    public String noteSendPopup(@RequestParam(required = false, defaultValue = "0") int userId
    		, ModelMap model) throws Exception {
		
		if(userId != 0){
			User user = new User();
			user.setC_id(userId);
			user = coreService.getNode(user);
			
			model.addAttribute("userInfo", user);
		}
        return "/jsp/user/note/noteSendPopup";
    }
	
	@RequestMapping(value="/noteDetailPopup.do", method=RequestMethod.GET)
    public String noteDetailPopup(HttpServletRequest request, ModelMap model) throws Exception {
		UserNoteByUser userNoteByUser = new UserNoteByUser();
		userNoteByUser.setC_id(Integer.parseInt(request.getParameter("notdDispId")));
		
		model.addAttribute("userNoteByUser", userNoteService.inquiryNoteDetail(userNoteByUser));
		
        return "/jsp/user/note/noteDetailPopup";
    }

	@RequestMapping(value="/inquiryNoteList.do", method={RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody Map<String, Object> inquiryNoteList(UserNoteByUser userNoteByUser
			, @RequestParam(required = false, defaultValue = "1") int currentPageNo
            , @RequestParam(required = false, defaultValue = "10") int recordCountPerPage
            , @RequestParam(required = false, defaultValue = "10") int pageSize
            , @RequestParam(required = false, defaultValue = "fnGetList") String jsFunction) throws Exception {
		
		PaginationInfo paginationInfo = new PaginationInfo();
        paginationInfo.setCurrentPageNo(currentPageNo);
        paginationInfo.setRecordCountPerPage(recordCountPerPage);
        paginationInfo.setPageSize(pageSize);
		
		userNoteByUser.setUserId(this.getLoginedUserID()); // 로그인자의 ID를 셋팅해야 한다. 현재 미구현 상태(2015.06.19)
		userNoteByUser.setNoteTypeCode(3); //3:수신, 4:발신, 5:보관
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("firstRecordIndex", paginationInfo.getFirstRecordIndex());
        paramMap.put("lastRecordIndex", paginationInfo.getLastRecordIndex());
        paramMap.put("user", userNoteByUser);
		
        paginationInfo.setTotalRecordCount( userNoteService.getCountOfUser(paramMap) );
        List<UserNoteByUser> userNoteByUserList = userNoteService.getUserListPaginated(paramMap);        
		
        Map<String, Object> returnMap = new HashMap<String, Object>();
        returnMap.put("noteList", userNoteByUserList);
        returnMap.put("pageList", asyncPaginaionTexRenderer.renderPagination(paginationInfo, jsFunction));
        
		return returnMap;
	}
	
	@RequestMapping(value="/inquiryUserNickname.do", method=RequestMethod.POST)
	@ResponseBody
	public User inquiryUserNickname(@RequestBody UserNoteByUser userNoteByUser) throws Exception {
		User user = new User();
		user.setC_title(userNoteByUser.getUserNm());
		user = userService.findUserByNickname(user);
		
		if(user == null){
			user = new User();
		}
		return user;
	}

	@RequestMapping(value="/uploadNoteFile.do", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<List<UserNoteAttachFile>> uploadNoteFile(HttpServletRequest request) throws Exception {
    	
		List<UserNoteAttachFile> userNoteAttachFileList = new ArrayList<UserNoteAttachFile>();
		
		if(request instanceof MultipartHttpServletRequest){
			String defaultPath = request.getSession().getServletContext().getRealPath("/");
			String uploadPath = fileUploadProperties.getProperty("note.upload.dir");
			uploadPath = defaultPath + uploadPath;
			
			File saveFolder = new File(uploadPath);
			
			// 디렉토리 생성
			if (!saveFolder.exists() || saveFolder.isFile()) {
				saveFolder.mkdirs();
			}
    		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
			Map<String, MultipartFile> files = multipartRequest.getFileMap();
			
			Iterator<Entry<String, MultipartFile>> itr = files.entrySet().iterator();
			MultipartFile file = null;
			String filePath = null;;
			
			UserNoteAttachFile addUserNoteAttachFile = null;
			
			String storeFileNm = null;
			while (itr.hasNext()) {
				Entry<String, MultipartFile> entry = itr.next();
				
				file = entry.getValue();
				if (!"".equals(file.getOriginalFilename())) {
					addUserNoteAttachFile = new UserNoteAttachFile();
					
					storeFileNm = "USER_NOTE" + this.getLoginedUserID() + System.currentTimeMillis(); //c_id 추후 로그인자 ID 셋팅
					
					filePath = uploadPath + storeFileNm;
					addUserNoteAttachFile.setC_title(file.getOriginalFilename());
					addUserNoteAttachFile.setStoreFileNm(storeFileNm); 
					file.transferTo(new File(filePath));
					
					userNoteAttachFileList.add(addUserNoteAttachFile);
				}
			}
		}
    	
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.TEXT_PLAIN);
		return new ResponseEntity<List<UserNoteAttachFile>>(userNoteAttachFileList, headers, HttpStatus.OK);
	}
	
	@RequestMapping(value="/downloadNoteFile.do", method=RequestMethod.GET)
	public ModelAndView downloadNoteFile(@RequestParam(value="fileName", required=true)String fileId, HttpServletRequest request) throws Exception {
    	
		UserNoteAttachFile userNoteAttachFile = new UserNoteAttachFile();
		userNoteAttachFile.setC_id(Integer.parseInt(fileId));
		userNoteAttachFile = userNoteService.inquiryNoteFileInf(userNoteAttachFile);
		
		String defaultPath = request.getSession().getServletContext().getRealPath("/");
    	String uploadPath = fileUploadProperties.getProperty("note.upload.dir");
    	uploadPath = defaultPath + uploadPath;
    	
    	File downFile = new File(uploadPath + userNoteAttachFile.getStoreFileNm());
    	
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName(":download");
    	mav.addObject("file", downFile);
    	mav.addObject("fileName", userNoteAttachFile.getC_title());
    	
    	return mav;
	}
	
	@RequestMapping(value="/sendNote.do", method=RequestMethod.POST)
	@ResponseBody
	public String sendNote(@RequestBody UserNoteDetail userNoteDetail) throws Exception {
		userNoteService.sendNote(userNoteDetail);		
		return "{}";
	}
	
	@RequestMapping(value="/deleteNoteList.do", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String deleteNoteList(@RequestBody UserNoteDetail userNoteDetail) throws Exception {
		userNoteService.deleteNoteList(userNoteDetail.getUserNoteByUserList());		
		return "{}";
	}
	
	private int getLoginedUserID() throws Exception {
		int loginedUserID;
		
		Object user = (Object)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(user instanceof String) { // 익명 사용자
			return 3;//throw new Exception("로그인후 사용");
			
		} else {	// 로그인 사용자
			SecureUserLogin loginedUser = (SecureUserLogin) user;
			loginedUserID = loginedUser.getId();
		}
		
		return loginedUserID;
	}
	
	@Override
	public Map<String, Map<String, Object>> bindTypes() {
		// TODO Auto-generated method stub
		return null;
	}
}