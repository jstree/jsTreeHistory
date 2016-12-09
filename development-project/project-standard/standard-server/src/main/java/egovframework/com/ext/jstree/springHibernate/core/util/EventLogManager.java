package egovframework.com.ext.jstree.springHibernate.core.util;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.hibernate.LockMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import egovframework.com.ext.jstree.support.util.SearchSupport;
import egovframework.com.ext.jstree.support.util.StringUtils;

@Component
public class EventLogManager {
    @Autowired
    private EventLogDao eventLogDao;
    @Autowired
    private MessageSource messageSource;
    @Autowired
    private MessageSupport messageSupport;
    
    private static final Logger logger = Logger.getLogger("save");
    
    public EventLog getEventLog(long id) {
        return null;
    }
    
    public List<EventLog> getList(SearchSupport searchSupport) {
        return eventLogDao.getList(searchSupport);
    }
    
    public int getCount(SearchSupport searchSupport) {
        return eventLogDao.getCount(searchSupport);
    }
    
    public void store(LoggingType loggingType, String content) {
        store(loggingType, content, 0);
    }
    
    public void store(LoggingType loggingType, String content, long deviceId) {
        String longinId = null;
        
        if (StringUtils.isEmpty(content)) {
            return;
        }
        
            longinId = "system";
        
        store(loggingType, content, deviceId, longinId);
    }
    
    public void store(LoggingType loggingType, String content, long deviceId, String longinId) {
        EventLog eventLog = new EventLog();
        
        if (StringUtils.isEmpty(content)) {
            return;
        }
        
        eventLog.setLoginId(longinId);
        eventLog.setEventLogType(loggingType.getNumString());
        eventLog.setLogContents(content);
        eventLog.setRegDate(new Date());
        eventLog.setDeviceId(deviceId);
        
        logger.info("evetLog : " + eventLog.toString());
        
        eventLogDao.store(eventLog);
    }
    
    public void store(EventLog eventLog) {
        eventLogDao.store(eventLog);
    }
    
    public void modify(EventLog eventLog) {
        eventLogDao.modify(eventLog);
    }
    
    @Transactional
    public void delete(List<Long> ids) {
        for (Long id : ids) {
            EventLog eventLog = getEventLog(id);
            eventLogDao.delete(eventLog);
        }
    }
    
    /*
     * 로그 작성
     */
    @Transactional
    public void writeLog(LogSupportActionType logSupportActionType, LoggingType loggingType, Object object, Object preObject) {
        // 시스템 설정 정보를 읽어 온다.
        long deviceId = getDeviceId(object);
        
        String viewId = null;
            viewId = "system";
        
        
        StringBuilder stringBuilder = new StringBuilder();
        
        LogDefault logDefault = (LogDefault) object;
        String key = logDefault.getLogKey() + "_" + logSupportActionType.name();
        
        switch (logSupportActionType.name()) {
        case "ADD":
            
            break;
        
        case "EDIT":
            break;
        
        case "DEL":
            
            break;
        
        default:
            break;
        }
        
        
        EventLog eventLog = new EventLog(loggingType.getNumString(), viewId, stringBuilder.toString(), new Date(), deviceId);
        store(eventLog);
    }
    
    private String getProfileType(Object object, Locale locale) {
            return "";
        
    }
    
    public String eventLogMessage(String key, Object[] array) {
        String message = messageSupport.getMessage(key, array, "", Locale.KOREA);
        return message;
    }
    
    private long getDeviceId(Object object) {
            return new Long(0);
        
    }
    
}
