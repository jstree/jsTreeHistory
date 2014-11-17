package standard.mvc.component.business.community.schedule.controller;

import java.util.Calendar;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import standard.mvc.component.base.controller.GenericAbstractController;
import standard.mvc.component.base.controller.GenericInterfaceController;
import standard.mvc.component.base.dao.hibernate.SearchSupport;


import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
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
public class ScheduleManageController extends GenericAbstractController implements GenericInterfaceController<Object>{
	
	/** EgovMessageSource */
    @Resource(name="egovMessageSource")
    EgovMessageSource egovMessageSource;
    
	@Resource(name="EgovCmmUseService")
	private EgovCmmUseService cmmUseService;
	
	@Resource(name = "egovIndvdlSchdulManageService")
	private EgovIndvdlSchdulManageService egovIndvdlSchdulManageService;



	@Override
	public String invokeSelect(SearchSupport searchSupport, ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response,
			BindingResult bindingResult, Object parameterBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String invokeInsert(SearchSupport searchSupport, ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response,
			BindingResult bindingResult, Object parameterBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String invokeUpdate(SearchSupport searchSupport, ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response,
			BindingResult bindingResult, Object parameterBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String invokeDelete(SearchSupport searchSupport, ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response,
			BindingResult bindingResult, Object parameterBean) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Map<String, Map<String, Object>> bindTypes() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@RequestMapping("/committerSchedule.do")
	public String getCommitterSchedule(ModelMap model) throws Exception {
        
		return "/jsp/community/aboutUs/schedule/committerSchedule";
	}
	
	/**
	 * 일정(월별) 목록을 조회한다. 
	 * @param searchVO
	 * @param commandMap
	 * @param indvdlSchdulManageVO
	 * @param model
	 * @return "/jsp/cop/smt/sim/EgovIndvdlSchdulManageMonthList"
	 * @throws Exception
	 */
	@RequestMapping("/committerScheduleMonthList.do")
	public String getBaroIndvdlSchdulManageMonthList(ModelMap model,@RequestParam Map<String, Object> commandMap)
			 throws Exception {

		//일정구분 검색 유지
        model.addAttribute("searchKeyword", StringUtils.isEmpty(commandMap.get("searchKeyword")) ? "" : (String)commandMap.get("searchKeyword"));
        model.addAttribute("searchCondition", StringUtils.isEmpty(commandMap.get("searchCondition")) ? "" : (String)commandMap.get("searchCondition"));
        
		Calendar cal = Calendar.getInstance();
		
		String sYear = (String)commandMap.get("year");
		String sMonth = (String)commandMap.get("month");
        
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
        //공통코드 일정종류
		ComDefaultCodeVO voComCode = new ComDefaultCodeVO();
		voComCode = new ComDefaultCodeVO();
		voComCode.setCodeId("COM030");
		model.addAttribute("schdulSe", cmmUseService.selectCmmCodeDetail(voComCode));
      		
		//화면에서 조회 기준 년과 월
		model.addAttribute("nYear" , iYear);
		model.addAttribute("nMonth", iMonth);
//		model.addAttribute("nDate" , cal.get(Calendar.DATE));
              
    	commandMap.put("searchMonth", sSearchDate);
    	commandMap.put("searchMode", "MONTH");
        model.addAttribute("resultList", egovIndvdlSchdulManageService.selectIndvdlSchdulManageRetrieve(commandMap));
        model.addAttribute("searchMonth", sSearchDate);
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
        
		return "/jsp/community/aboutUs/schedule/committerScheduleMonthList";
	}
	
	/**
	 * 일정 목록을 상세조회 조회한다. 
	 * @param searchVO
	 * @param indvdlSchdulManageVO
	 * @param commandMap
	 * @param model
	 * @return "/jsp/cop/smt/sim/EgovIndvdlSchdulManageDetail"
	 * @throws Exception
	 */
	@RequestMapping(value="/baroSchdulManageDetail.do")
	public String baroSchdulManageDetail(
			@RequestParam Map<String, String> commandMap
    		,ModelMap model)
    throws Exception {
		
		//공통코드  중요도 조회
    	ComDefaultCodeVO voComCode = new ComDefaultCodeVO();
    	voComCode.setCodeId("COM019");
    	model.addAttribute("schdulIpcrCode", cmmUseService.selectCmmCodeDetail(voComCode));
    	//공통코드  일정구분 조회
    	voComCode = new ComDefaultCodeVO();
    	voComCode.setCodeId("COM030");
    	model.addAttribute("schdulSe", cmmUseService.selectCmmCodeDetail(voComCode));
    	//공통코드  반복구분 조회
    	voComCode = new ComDefaultCodeVO();
    	voComCode.setCodeId("COM031");
    	model.addAttribute("reptitSeCode", cmmUseService.selectCmmCodeDetail(voComCode));
    	
    	IndvdlSchdulManageVO indvdlSchdulManageVO = new IndvdlSchdulManageVO();
    	indvdlSchdulManageVO.setSchdulId(commandMap.get("schdulId"));
    	model.addAttribute("resultList", egovIndvdlSchdulManageService.selectIndvdlSchdulManageDetail(indvdlSchdulManageVO));
    	
    	model.addAllAttributes(commandMap);
    	
		return "/jsp/community/aboutUs/schedule/committerScheduleManageDetail"; 	
	}
}
