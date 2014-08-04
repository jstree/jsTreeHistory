/*
 * Copyright 2010 MOPAS(Ministry of Public Administration and Security).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package standard.mvc.component.property.controller;



import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.oe1.sms.property.service.EgovOe1SmsPropertyVO;
import standard.mvc.component.property.service.EgovOe1SmsPropertyService;


/**
 * 프로퍼티 서비스 설정관리를 위한 Controller 클래스
 * @author 운영환경개발팀
 * @since 2010.06.29
 * @version 1.0
 * @see <pre>
 * &lt;&lt; 개정이력(Modification Information) &gt;&gt;
 *   
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2010.06.29   운영환경개발팀                최초 생성
 * 
 * </pre>
 */

@Controller
public class EgovOe1SmsPropertyController {

    @Resource(name = "propertyService")
    private EgovOe1SmsPropertyService proService;
    
    /**
     * 프로퍼티 설정 목록 조회
     * @param PropertyVO
     *        ,ModelMap
     * @return String
     * @exception Exception
     */
    @RequestMapping("/ole/sms/select313PropertyList.sms")
    public String select313PropertyList(
            @ModelAttribute("propertyVO") EgovOe1SmsPropertyVO propertyVO,
            ModelMap model) throws Exception {
        
        model.addAttribute("property_list", proService.selectPropertyList());
        return "property/EgovSmsPropertyList";
    }

    /**
     * 프로퍼티 설정 상세
     * @param EgovOe1SmsPropertyVO
     *        ,ModelMap
     * @return String
     * @exception Exception
     */
    @RequestMapping("/ole/sms/select313PropertyService.sms")
    public String select313PropertyService(
            @ModelAttribute("propertyVO") EgovOe1SmsPropertyVO propertyVO,
            ModelMap model) throws Exception {
		
    	EgovOe1SmsPropertyVO returnVO = proService.selectProperty(propertyVO.getPropertyNm());
    	
    	Date d = proService.getRemoteModifiedTime(propertyVO.getPropertyNm());
    	
        model.addAttribute("entry_list", returnVO.getEntries());
        model.addAttribute("propertyVO", returnVO);
        
        return "property/EgovSmsPropertyDetail";
    }

    /**
     * 프로퍼티 설정 수정
     * @param EgovOe1SmsPropertyVO
     *        ,ModelMap
     * @return String
     * @exception Exception
     */
    @RequestMapping("/ole/sms/update313PropertyService.sms")
    public String update313PropertyService(
            @ModelAttribute("propertyVO") EgovOe1SmsPropertyVO propertyVO,
            ModelMap model) throws Exception {
    	 
		proService.updateProperty(propertyVO);
		
        return "forward:/ole/sms/select313PropertyService.sms";
    }

    /**
     * 신규 프러퍼티 생성 
     * @param propertyVO
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/ole/sms/insert313NewProperty.sms")
    public String insert313NewProperty(
    		@ModelAttribute("propertyVO") EgovOe1SmsPropertyVO propertyVO,
    		ModelMap model) throws Exception {

    	proService.insertProperties(propertyVO);
    	
    	propertyVO.setPropertyNm(propertyVO.getBeanNm());
    	model.addAttribute("propertyVO", propertyVO);

    	return "forward:/ole/sms/select313PropertyList.sms";
    }
    
      /**
	   * 프로퍼티 설정 삭제
	   * @param EgovOe1SmsPropertyVO
	   *        ,ModelMap
	   * @return String
	   * @exception Exception
	   */
	  @RequestMapping("/ole/sms/delete313PropertyServiceBean.sms")
	  public String delete313PropertyServiceBean(
	          @ModelAttribute("propertyVO") EgovOe1SmsPropertyVO propertyVO,
	          ModelMap model) throws Exception {
	
		  proService.deleteProperties(propertyVO.getPropertyNm());
		  return "forward:/ole/sms/select313PropertyList.sms";
	  }
	  
	  
	/**
	 * 
	 * @param propertyVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/ole/sms/insert313NewPropertyServiceView.sms")
	public String insertNewPropertyServiceView(@ModelAttribute("propertyVO") EgovOe1SmsPropertyVO propertyVO
			,ModelMap model) throws Exception {
		propertyVO.setBeanClassNm("java.util.Properties");
	
		return "property/EgovSmsPropertyNewRegist";
	}
}
