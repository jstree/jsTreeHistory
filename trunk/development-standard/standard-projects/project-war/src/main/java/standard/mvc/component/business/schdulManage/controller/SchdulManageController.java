package standard.mvc.component.business.schdulManage.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import standard.mvc.component.base.controller.GenericAbstractController;
import standard.mvc.component.business.menu.vo.MenuComprehensiveTree;

import com.fasterxml.jackson.core.JsonProcessingException;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.ComDefaultVO;
import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.springiBatis.core.util.Util_TitleChecker;
import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;
import egovframework.let.cop.smt.sim.service.EgovIndvdlSchdulManageService;
import egovframework.let.cop.smt.sim.service.IndvdlSchdulManageVO;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;

/**
 * Modification Information
 * 
 * @author DaeGun.Kim
 * @since 2014.11.06
 * @version 1.0
 * @see <pre>
 * 	Class Name 	: 
 * 	Description : 
 * 	Infomation	:  
 *  
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일               수정자                 수정내용
 *  -------       ------------   -----------------------
 *  2014.11.06    김대근           최초 생성
 * 
 *  Copyright (C) 2014 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Controller
public class SchdulManageController extends GenericAbstractController {
	
	/** EgovMessageSource */
    @Resource(name="egovMessageSource")
    EgovMessageSource egovMessageSource;
    
	@Resource(name="EgovCmmUseService")
	private EgovCmmUseService cmmUseService;
	
	@Resource(name = "egovIndvdlSchdulManageService")
	private EgovIndvdlSchdulManageService egovIndvdlSchdulManageService;
	
    @Override
    public Map<String, Map<String, Object>> bindTypes() {
        // TODO Auto-generated method stub
        return null;
    }


	@RequestMapping("/committerSchedule.do")
	public String getChildNode() throws Exception {
		return "/jsp/cop/smt/sim/committerSchedule";
	}
	
	@RequestMapping("/committerScheduleMonthList.do")
	public String getBaroIndvdlSchdulManageMonthList(@ModelAttribute("searchVO") ComDefaultVO searchVO, 
			Map<String, String> commandMap, 
			IndvdlSchdulManageVO indvdlSchdulManageVO,
    		ModelMap model)
			 throws Exception {

		if (!checkAuthority(model)) return "cmm/uat/uia/EgovLoginUsr";	// server-side 권한 확인
    	
		//일정구분 검색 유지
        model.addAttribute("searchKeyword", commandMap.get("searchKeyword") == null ? "" : (String)commandMap.get("searchKeyword"));
        model.addAttribute("searchCondition", commandMap.get("searchCondition") == null ? "" : (String)commandMap.get("searchCondition"));

		java.util.Calendar cal = java.util.Calendar.getInstance();
		
		String sYear = (String)commandMap.get("year");
		String sMonth = (String)commandMap.get("month");

		int iYear = cal.get(java.util.Calendar.YEAR);
		int iMonth = cal.get(java.util.Calendar.MONTH);
		int iDate = cal.get(java.util.Calendar.DATE);
		
        //검색 설정
        String sSearchDate = "";
        if(sYear == null || sMonth == null){
                sSearchDate += Integer.toString(iYear);
                sSearchDate += Integer.toString(iMonth+1).length() == 1 ? "0" + Integer.toString(iMonth+1) : Integer.toString(iMonth+1); 
        }else{
                iYear = Integer.parseInt(sYear); 
                iMonth = Integer.parseInt(sMonth);
                sSearchDate += sYear;
                sSearchDate += Integer.toString(iMonth+1).length() == 1 ? "0" + Integer.toString(iMonth+1) :Integer.toString(iMonth+1); 
        }
		
		//공통코드 일정종류
		ComDefaultCodeVO voComCode = new ComDefaultCodeVO();
	   	voComCode = new ComDefaultCodeVO();
    	voComCode.setCodeId("COM030");
    	model.addAttribute("schdulSe", cmmUseService.selectCmmCodeDetail(voComCode));

    	commandMap.put("searchMonth", sSearchDate);
    	commandMap.put("searchMode", "MONTH");
    	List a = egovIndvdlSchdulManageService.selectIndvdlSchdulManageRetrieve(commandMap);
        model.addAttribute("resultList", a);
		
		
        //기존 eGov에서 Jsp에서 하던 로직을 가져왔다 추후 더 분석후 좀더 이쁘게 만들자
        model.addAttribute("nYear" , iYear);
        model.addAttribute("nMonth", iMonth);
        model.addAttribute("nDate" , iDate);
        
        //년도/월 셋팅
        cal.set(iYear, iMonth, 1);
        
        int startDay = cal.getMinimum(java.util.Calendar.DATE);
        int endDay = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
        int start = cal.get(java.util.Calendar.DAY_OF_WEEK);
        int newLine = 0;
        
        model.addAttribute("startDay", startDay);
        model.addAttribute("endDay"  , endDay);
        model.addAttribute("start"   , start);
        
        
		return "/jsp/cop/smt/sim/committerScheduleMonthList";
	}
	
	/**
     * 운영자 권한을 확인한다.(로그인 여부를 확인한다.)
     * 
     * @param boardMaster
     * @throws EgovBizException
     */
    protected boolean checkAuthority(ModelMap model) throws Exception {
    	// 사용자권한 처리
    	if(!EgovUserDetailsHelper.isAuthenticated()) {
    		model.addAttribute("message", egovMessageSource.getMessage("fail.common.login"));
        	return false; 
    	}else{
    		return true;
    	}
    }
}