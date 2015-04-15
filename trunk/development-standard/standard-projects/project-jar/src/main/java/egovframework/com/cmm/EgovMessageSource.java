package egovframework.com.cmm;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.MessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.util.WebUtils;

/**
 * 메시지 리소스 사용을 위한 MessageSource 인터페이스 및 ReloadableResourceBundleMessageSource
 * 클래스의 구현체
 * 
 * @author 공통서비스 개발팀 이문준
 * @since 2009.06.01
 * @version 1.0
 * @see
 * 
 *      <pre>
 * << 개정이력(Modification Information) >>
 *   
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2009.03.11  이문준          최초 생성
 * 
 * </pre>
 */

public class EgovMessageSource extends ReloadableResourceBundleMessageSource implements MessageSource
{
    
    private ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource;
    
    /**
     * getReloadableResourceBundleMessageSource()
     * 
     * @param reloadableResourceBundleMessageSource
     *            - resource MessageSource
     * @return ReloadableResourceBundleMessageSource
     */
    public void setReloadableResourceBundleMessageSource(
            ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource)
    {
        this.reloadableResourceBundleMessageSource = reloadableResourceBundleMessageSource;
    }
    
    /**
     * getReloadableResourceBundleMessageSource()
     * 
     * @return ReloadableResourceBundleMessageSource
     */
    public ReloadableResourceBundleMessageSource getReloadableResourceBundleMessageSource()
    {
        return reloadableResourceBundleMessageSource;
    }
    
    /**
     * 정의된 메세지 조회
     * 
     * @param code
     *            - 메세지 코드
     * @return String
     */
    public String getMessage(String code)
    {
        return getReloadableResourceBundleMessageSource().getMessage(code, null, Locale.getDefault());
    }
    
    public String getMessage(String code, Object[] args, String defaultMessage, HttpServletRequest request)
    {
        Locale locale = (Locale) WebUtils.getSessionAttribute(request,
                                                              SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
        return getMessage(code, args, defaultMessage, locale);
    }
    
    public String getMessage(String code, String defaultMessage, Locale locale)
    {
        return getMessage(code, null, defaultMessage, locale);
    }
    
    public String getMessage(String code, String defaultMessage, HttpServletRequest request)
    {
        Locale locale = (Locale) WebUtils.getSessionAttribute(request,
                                                              SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
        return getMessage(code, null, defaultMessage, locale);
    }
    
    public MessageSource getMessageSource()
    {
        return this.getReloadableResourceBundleMessageSource();
    }
    
}
