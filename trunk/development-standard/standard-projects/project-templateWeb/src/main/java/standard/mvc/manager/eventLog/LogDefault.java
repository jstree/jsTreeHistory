package standard.mvc.manager.eventLog;

/**
 * TM에서 로그를 구현하기 위한 기본 함수. 
 */
public interface LogDefault {
    public String getLogKey();
    public LoggingType getEventLogType();
}
