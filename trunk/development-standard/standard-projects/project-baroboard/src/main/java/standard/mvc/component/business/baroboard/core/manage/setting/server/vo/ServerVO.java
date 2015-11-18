package standard.mvc.component.business.baroboard.core.manage.setting.server.vo;

import static org.apache.commons.lang.StringUtils.isBlank;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.URL;

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
 * @since 2015. 5. 20.
 * @version 1.0
 * @see <pre>
 *  Class Name  : ServerVO.java
 *  Description : 서버 설정 VO
 *  Information : 
 * 
 *  << 개정이력(Modification Information) >>
 * 
 *  수정일              수정자                  수정내용
 *  -------       ------------   -----------------------
 *  2015. 5. 20.        손호성                  최초생성
 * 
 *  Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
public class ServerVO extends ComprehensiveTree {

    /**
     * 기본 URL
     */
    @URL(groups = {AlterNode.class})
    private String url;

    /**
     * SSL 사용여부
     */
    @Contained(values = {ValidInput.TRUE, ValidInput.FALSE}, groups = {AlterNode.class})
    private String sslFl;

    /**
     * HTTP PORT 번호
     */
    @Pattern(regexp = ValidFormat.NUMBER_ONLY, groups = {AlterNode.class})
    private String httpPort;

    /**
     * HTTPS PORT 번호
     */
    @Pattern(regexp = ValidFormat.NUMBER_ONLY, groups = {AlterNode.class})
    private String httpsPort;

    /**
     * 짧은 주소 사용여부
     */
    @Contained(values = {ValidInput.TRUE, ValidInput.FALSE}, groups = {AlterNode.class})
    private String shortUrlFl;

    /**
     * SSO 사용여부
     */
    @Contained(values = {ValidInput.TRUE, ValidInput.FALSE}, groups = {AlterNode.class})
    private String ssoFl;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSslFl() {
        return isBlank(sslFl) ? ValidInput.FALSE : sslFl;
    }

    public void setSslFl(String sslFl) {
        this.sslFl = sslFl;
    }

    public String getHttpPort() {
        return httpPort;
    }

    public void setHttpPort(String httpPort) {
        this.httpPort = httpPort;
    }

    public String getHttpsPort() {
        return httpsPort;
    }

    public void setHttpsPort(String httpsPort) {
        this.httpsPort = httpsPort;
    }

    public String getShortUrlFl() {
        return isBlank(shortUrlFl) ? ValidInput.FALSE : shortUrlFl;
    }

    public void setShortUrlFl(String shortUrlFl) {
        this.shortUrlFl = shortUrlFl;
    }

    public String getSsoFl() {
        return isBlank(ssoFl) ? ValidInput.FALSE : ssoFl;
    }

    public void setSsoFl(String ssoFl) {
        this.ssoFl = ssoFl;
    }

    @Override
    public String getSqlMapSelector() {
        return "server";
    }

    @Override
    public String toString() {
        return "ServerVO [url=" + url + ", sslFl=" + sslFl + ", httpPort=" + httpPort
                + ", httpsPort=" + httpsPort + ", shortUrlFl=" + shortUrlFl + ", ssoFl=" + ssoFl
                + "]";
    }

}