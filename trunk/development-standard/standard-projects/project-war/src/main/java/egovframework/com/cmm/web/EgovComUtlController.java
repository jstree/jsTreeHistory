package egovframework.com.cmm.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import standard.mvc.component.business.menu.service.MenuMngSerivce;
import standard.mvc.component.business.menu.vo.MenuComprehensiveTree;
import egovframework.rte.fdl.property.EgovPropertyService;

/**
 * @Class Name : EgovComUtlController.java
 * @Description : 공통유틸리티성 작업을 위한 Controller
 * @Modification Information
 * @
 * @  수정일         수정자                   수정내용
 * @ -------    --------    ---------------------------
 * @ 2009.03.02    조재영          최초 생성
 * @ 2011.10.07    이기하          .action -> .do로 변경하면서 동일 매핑이 되어 삭제처리
 *
 *  @author 공통서비스 개발팀 조재영
 *  @since 2009.03.02
 *  @version 1.0
 *  @see
 *
 */
@Controller
public class EgovComUtlController {

    //@Resource(name = "egovUserManageService")
    //private EgovUserManageService egovUserManageService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
    
    @Resource(name = "menuMngService")
    private MenuMngSerivce menuMngService;
    /**
	 * JSP 호출작업만 처리하는 공통 함수
	 */
	@RequestMapping(value="/EgovPageLink.do")
	public String moveToPage(@RequestParam("link") String linkPage, 
            HttpSession session, 
            @RequestParam(value="menuNo", required=false) String menuNo,
            ModelMap model){
		String link = linkPage;
		
		if (menuNo == null || menuNo.equals("")){
            menuNo = (String) session.getAttribute("menuNo");
        }
		// service 사용하여 리턴할 결과값 처리하는 부분은 생략하고 단순 페이지 링크만 처리함
		if (linkPage==null || linkPage.equals("")){
		    link="/jsp/egovframework/com/cmm/egovError";
        }else{
            if(link.indexOf(",")>-1){
                link=link.substring(0,link.indexOf(","));
            }
            
            if(linkPage.indexOf("/jsp/main/inc/EgovIncTopnav") > -1){
            	model.addAttribute("menuList",menuMngService.getEgovUpperMenu());
            }else if(linkPage.indexOf("/jsp/main/inc/EgovIncLeftmenu") > -1){
            	MenuComprehensiveTree menuComprehensiveTree = new MenuComprehensiveTree();
            	menuComprehensiveTree.setC_parentid(Integer.parseInt(menuNo));
            	model.addAttribute("leftMenuList", menuMngService.getEgovLeftMenu(menuComprehensiveTree));
            }
        }
		// 선택된 메뉴정보를 세션으로 등록한다.
        if (menuNo!=null && !menuNo.equals("")){
            session.setAttribute("menuNo",menuNo);
        }
		return link;
	}

    /**
	 * validato rule dynamic Javascript
	 */
	@RequestMapping("/validator.do")
	public String validate(){
		return "/jsp/egovframework/com/cmm/validator";
	}

}