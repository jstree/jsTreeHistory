package standard.mvc.component.business.baroboard.core.manage.setting.compn.vo;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * 
 * Modification Information
 * 
 * @author 손호성
 * @since 2015. 6. 13.
 * @version 1.0
 * @see <pre>
 * Class Name  : CompnVO.java
 * Description : 설치프로그램 관리 VO
 * Information : 
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------       ------------   -----------------------
 * 2015. 6. 13.         손호성                 최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
public class CompnVO extends ComprehensiveTree {

    private String compnTitle;
    private String compnVersion;
    private String compnAuthor;
    private String compnPath;

    public String getCompnTitle() {
        return compnTitle;
    }

    public void setCompnTitle(String compnTitle) {
        this.compnTitle = compnTitle;
    }

    public String getCompnVersion() {
        return compnVersion;
    }

    public void setCompnVersion(String compnVersion) {
        this.compnVersion = compnVersion;
    }

    public String getCompnAuthor() {
        return compnAuthor;
    }

    public void setCompnAuthor(String compnAuthor) {
        this.compnAuthor = compnAuthor;
    }

    public String getCompnPath() {
        return compnPath;
    }

    public void setCompnPath(String compnPath) {
        this.compnPath = compnPath;
    }

    @Override
    public String getSqlMapSelector() {
        return "compn";
    }

}
