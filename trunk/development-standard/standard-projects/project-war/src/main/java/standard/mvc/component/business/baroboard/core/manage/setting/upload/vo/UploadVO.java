package standard.mvc.component.business.baroboard.core.manage.setting.upload.vo;

import javax.validation.constraints.Pattern;

import standard.mvc.component.business.baroboard.core.manage.setting.validCondition.ValidFormat;
import standard.mvc.component.business.baroboard.core.manage.setting.validCondition.ValidInput;
import egovframework.com.ext.jstree.springiBatis.core.validation.custom.constraints.Contained;
import egovframework.com.ext.jstree.springiBatis.core.validation.group.AlterNode;
import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

public class UploadVO extends ComprehensiveTree {

    @Pattern(regexp = ValidFormat.NUMBER_ONLY, groups = {AlterNode.class})
    private String fileSizeLimit;

    @Pattern(regexp = ValidFormat.NUMBER_ONLY, groups = {AlterNode.class})
    private String docSizeLimit;

    @Pattern(regexp = ValidFormat.NUMBER_ONLY, groups = {AlterNode.class})
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
        return extnlLnkFl;
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

}
