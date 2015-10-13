package standard.mvc.component.business.baroboard.core.manage.setting.upload.vo;

import static org.apache.commons.lang.StringUtils.isBlank;

import javax.validation.constraints.Pattern;

import standard.mvc.component.business.baroboard.validCondition.ValidFormat;
import standard.mvc.component.business.baroboard.validCondition.ValidInput;
import egovframework.com.ext.jstree.springiBatis.core.validation.custom.constraints.Contained;
import egovframework.com.ext.jstree.springiBatis.core.validation.group.AlterNode;
import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * 
 * Modification Information
 * 
 * @author 손호성
 * @since 2015. 5. 31.
 * @version 1.0
 * @see <pre>
 *  Class Name  : UploadVO.java
 *  Description : 파일업로드 설정 VO
 *  Information :
 * 
 *  << 개정이력(Modification Information) >>
 * 
 *  수정일              수정자                  수정내용
 *  -------       ------------   -----------------------
 *  2015. 5. 31.        손호성                  최초생성
 * 
 *  Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
public class UploadVO extends ComprehensiveTree {

    @Pattern(regexp = ValidFormat.NUMBER_ONLY, groups = {AlterNode.class})
    private String fileSizeLimit;

    @Pattern(regexp = ValidFormat.NUMBER_ONLY, groups = {AlterNode.class})
    private String docSizeLimit;

    private String fileExtLimit;

    @Contained(values = {ValidInput.TRUE, ValidInput.FALSE}, groups = {AlterNode.class})
    private String extnlLnkFl;

    private String extnlLnkAllowedExt;

    private String extnlLnkAllowedSite;

    public String getFileSizeLimit() {
        return fileSizeLimit;
    }

    public void setFileSizeLimit(String fileSizeLimit) {
        this.fileSizeLimit = fileSizeLimit;
    }

    public String getDocSizeLimit() {
        return docSizeLimit;
    }

    public void setDocSizeLimit(String docSizeLimit) {
        this.docSizeLimit = docSizeLimit;
    }

    public String getFileExtLimit() {
        return fileExtLimit;
    }

    public void setFileExtLimit(String fileExtLimit) {
        this.fileExtLimit = fileExtLimit;
    }

    public String getExtnlLnkFl() {
        return isBlank(extnlLnkFl) ? ValidInput.FALSE : extnlLnkFl;
    }

    public void setExtnlLnkFl(String extnlLnkFl) {
        this.extnlLnkFl = extnlLnkFl;
    }

    public String getExtnlLnkAllowedExt() {
        return extnlLnkAllowedExt;
    }

    public void setExtnlLnkAllowedExt(String extnlLnkAllowedExt) {
        this.extnlLnkAllowedExt = extnlLnkAllowedExt;
    }

    public String getExtnlLnkAllowedSite() {
        return extnlLnkAllowedSite;
    }

    public void setExtnlLnkAllowedSite(String extnlLnkAllowedSite) {
        this.extnlLnkAllowedSite = extnlLnkAllowedSite;
    }

    @Override
    public String getSqlMapSelector() {
        return "upload";
    }

    @Override
    public String toString() {
        return "UploadVO [fileSizeLimit=" + fileSizeLimit + ", docSizeLimit=" + docSizeLimit
                + ", fileExtLimit=" + fileExtLimit + ", extnlLnkFl=" + extnlLnkFl
                + ", extnlLnkAllowedExt=" + extnlLnkAllowedExt + ", extnlLnkAllowedSite="
                + extnlLnkAllowedSite + "]";
    }

}
