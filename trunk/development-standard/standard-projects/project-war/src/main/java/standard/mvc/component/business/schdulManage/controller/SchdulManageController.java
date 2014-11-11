package standard.mvc.component.business.schdulManage.controller;

import java.util.Calendar;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import standard.mvc.component.base.controller.GenericAbstractController;


import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.let.cop.smt.sim.service.EgovIndvdlSchdulManageService;
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
	public String getCommitterSchedule(ModelMap model) throws Exception {
		//공통코드 일정종류
		ComDefaultCodeVO voComCode = new ComDefaultCodeVO();
	   	voComCode = new ComDefaultCodeVO();
    	voComCode.setCodeId("COM030");
    	model.addAttribute("schdulSe", cmmUseService.selectCmmCodeDetail(voComCode));
		
    	Calendar cal = Calendar.getInstance();
		
    	//화면에서 조회 기준 년과 월
        model.addAttribute("nYear" , cal.get(Calendar.YEAR));
        model.addAttribute("nMonth", cal.get(Calendar.MONTH));
        model.addAttribute("nDate" , cal.get(Calendar.DATE));
        
		return "/jsp/cop/smt/sim/committerSchedule";
	}
	
	@RequestMapping("/committerScheduleMonthList.do")
	public String getBaroIndvdlSchdulManageMonthList(
			 Map<String, Object> commandMap
    		,@RequestParam(value="year", required=false) String sYear
    		,@RequestParam(value="month", required=false) String sMonth
    		,@RequestParam(value="searchKeyword", required=false) String searchKeyword
    		,@RequestParam(value="searchCondition", required=false) String searchCondition
    		,ModelMap model)
			 throws Exception {

		if (!checkAuthority(model)) return "cmm/uat/uia/EgovLoginUsr";	// server-side 권한 확인
    	
		//일정구분 검색 유지
//        model.addAttribute("searchKeyword", commandMap.get("searchKeyword") == null ? "" : (String)commandMap.get("searchKeyword"));
//        model.addAttribute("searchCondition", commandMap.get("searchCondition") == null ? "" : (String)commandMap.get("searchCondition"));
        model.addAttribute("searchKeyword", StringUtils.isEmpty(searchKeyword) ? "" : searchKeyword);
        model.addAttribute("searchCondition", StringUtils.isEmpty(searchCondition) ? "" : searchCondition);
        
		Calendar cal = Calendar.getInstance();
		
//		String sYear = (String)commandMap.get("year");
//		String sMonth = (String)commandMap.get("month");
        
		int iYear = cal.get(Calendar.YEAR);
		int iMonth = cal.get(Calendar.MONTH);
		
        //검색 설정
        String sSearchDate = "";
        if(sYear == null || sMonth == null){
                sSearchDate += Integer.toString(iYear);
                sSearchDate += Integer.toString(iMonth+1).length() == 1 ? "0" + Integer.toString(iMonth+1) : Integer.toString(iMonth+1); 
        }else{
                iYear = Integer.parseInt(sYear); 
                iMonth = Integer.parseInt(sMonth)-1;
                sSearchDate += sYear;
                sSearchDate += Integer.toString(iMonth+1).length() == 1 ? "0" + Integer.toString(iMonth+1) :Integer.toString(iMonth+1); 
        }
		
    	commandMap.put("searchMonth", sSearchDate);
    	commandMap.put("searchMode", "MONTH");
        model.addAttribute("resultList", egovIndvdlSchdulManageService.selectIndvdlSchdulManageRetrieve(commandMap));
		
        //년도/월 셋팅
        cal.set(iYear, iMonth, 1);
        
        int startDay = cal.getMinimum(Calendar.DATE);
        int endDay   = cal.getActualMaximum(Calendar.DATE);
        int start    = cal.get(Calendar.DAY_OF_WEEK);
        
        //화면에서 조회 기준 년과 월
        model.addAttribute("startDay", startDay);
        model.addAttribute("endDay"  , endDay);
        model.addAttribute("start"   , start);
        
        //말일자가 해당월의 몇 주차인지 구하기
        cal.set(Calendar.DATE, endDay);
        model.addAttribute("lastWeek", cal.get(Calendar.WEEK_OF_MONTH));
        
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
