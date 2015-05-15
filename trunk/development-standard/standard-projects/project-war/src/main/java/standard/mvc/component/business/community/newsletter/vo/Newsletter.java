package standard.mvc.component.business.community.newsletter.vo;

import java.util.HashMap;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * Modification Information
 * 
 * @author 류강하
 * @since 2014. 12. 09.
 * @version 1.0
 * @see <pre>
 *  Class Name  : Newsletter.java
 *  Description : Newsletter VO 클래스
 *  Infomation  : Newsletter VO 클래스
 *  
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일                 수정자                 수정내용
 *  -------        ------------   -----------------------
 *  2014. 12. 09.  류강하                 최초 생성
 *  Copyright (C) 2014 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
//@JsonInclude(Include.NON_EMPTY)
public class Newsletter extends ComprehensiveTree {

    @Override
    public HashMap<String, String> getAttr() {
        
        HashMap<String, String> attrs = super.getAttr();
//        attrs.put("left", String.valueOf(super.getC_left()));
//        attrs.put("right", String.valueOf(super.getC_right()));
//        attrs.put("position", String.valueOf(super.getC_position()));
        return attrs;
    }
    
    @Override
    public String getSqlMapSelector() {
        return "newsletter";
    }
}
