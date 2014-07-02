package standard.mvc.manager.eventLog;

import java.util.Locale;

import org.springframework.context.MessageSource;

/**
 * TM에서 로그를 구현하기 위한 함수.(장비 버전에 무관한 경우)
 * 장비 버전별 로그 처리가 필요한 경우 LogSupportForVersion 사용
 */
public interface LogSupport extends LogDefault{
    public String getMessage(MessageSource messageSource, Locale locale);
}
