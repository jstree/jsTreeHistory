package standard.mvc.component.business.baroboard.core.manage.setting.ftp.vo;

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
 * @since 2015. 5. 29.
 * @version 1.0
 * @see <pre>
 *  Class Name  : FtpVO.java
 *  Description : FTP 설정 VO
 *  Information : 
 * 
 *  << 개정이력(Modification Information) >>
 * 
 *  수정일              수정자                  수정내용
 *  -------       ------------   -----------------------
 *  2015. 5. 29.        손호성                  최초생성
 * 
 *  Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
public class FtpVO extends ComprehensiveTree {

    /**
     * FTP 아이디
     */
    private String ftpId;

    /**
     * FTP 패스워드
     */
    private String ftpPassword;

    /**
     * FTP URL
     */
    @Pattern(regexp = ValidFormat.IP_ONLY, groups = {AlterNode.class})
    private String ftpUrl;

    /**
     * FTP PORT 번호
     */
    @Pattern(regexp = ValidFormat.NUMBER_ONLY, groups = {AlterNode.class})
    private String ftpPort;

    /**
     * Passive 모드 사용여부
     */
    @Contained(values = {ValidInput.TRUE, ValidInput.FALSE}, groups = {AlterNode.class})
    private String passiveFl;

    /**
     * SFTP 모드 사용여부
     */
    @Contained(values = {ValidInput.TRUE, ValidInput.FALSE}, groups = {AlterNode.class})
    private String sftpFl;

    public String getFtpId() {
        return ftpId;
    }

    public void setFtpId(String ftpId) {
        this.ftpId = ftpId;
    }

    public String getFtpPassword() {
        return ftpPassword;
    }

    public void setFtpPassword(String ftpPassword) {
        this.ftpPassword = ftpPassword;
    }

    public String getFtpUrl() {
        return ftpUrl;
    }

    public void setFtpUrl(String ftpUrl) {
        this.ftpUrl = ftpUrl;
    }

    public String getFtpPort() {
        return ftpPort;
    }

    public void setFtpPort(String ftpPort) {
        this.ftpPort = ftpPort;
    }

    public String getPassiveFl() {
        return isBlank(passiveFl) ? ValidInput.FALSE : passiveFl;
    }

    public void setPassiveFl(String passiveFl) {
        this.passiveFl = passiveFl;
    }

    public String getSftpFl() {
        return isBlank(sftpFl) ? ValidInput.FALSE : sftpFl;
    }

    public void setSftpFl(String sftpFl) {
        this.sftpFl = sftpFl;
    }

    @Override
    public String getSqlMapSelector() {
        return "ftp";
    }

    @Override
    public String toString() {
        return "FtpVO [ftpId=" + ftpId + ", ftpPassword=" + ftpPassword + ", ftpUrl=" + ftpUrl
                + ", ftpPort=" + ftpPort + ", ftpPassiveFl=" + passiveFl + ", sftpFl=" + sftpFl
                + "]";
    }

}
