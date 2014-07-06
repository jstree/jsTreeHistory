package standard.mvc.component.manager.eventLog;


import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.hibernate.LockMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import standard.mvc.component.base.dao.hibernate.SearchSupport;
import standard.mvc.component.manager.messageSource.MessageSupport;
import standard.mvc.util.StringUtils;


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
        return eventLogDao.find(id, LockMode.NONE);
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
        
        if(StringUtils.isEmpty(content)){
            return;
        }
            longinId = "system";
        
        store(loggingType, content, deviceId, longinId);
    }
    
    public void store(LoggingType loggingType, String content, long deviceId, String longinId) {
        EventLog eventLog = new EventLog();
        
        if(StringUtils.isEmpty(content)){
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
        
        String viewId = null;
            viewId = "system";

        
        StringBuilder stringBuilder = new StringBuilder();
        
        LogDefault logDefault = (LogDefault) object;
        String key = logDefault.getLogKey() + "_" + logSupportActionType.name();
        //stringBuilder.append(getProfileType(object, systemInfo.getLocale())).append(" ").append(messageSupport.getMessage(key, "", systemInfo.getLocale())).append("\n");
        
        switch (logSupportActionType.name()) {
        case "ADD":
            
            break;
        
        case "EDIT":
            if(preObject instanceof LogSupport){
            	LogSupport preLogSupport = (LogSupport) preObject;
                //stringBuilder.append(preLogSupport.getMessage(messageSource, systemInfo.getLocale(), patchStep)).append("\r\n");
            }else{
                LogSupport preLogSupport = (LogSupport) preObject;
                //stringBuilder.append(preLogSupport.getMessage(messageSource, systemInfo.getLocale())).append("\r\n"); 
            }
            break;
        
        case "DEL":
            
            break;
        
        default:
            break;
        }
        
        if(object instanceof LogSupport){
        	LogSupport logSupport = (LogSupport) object;
            //stringBuilder.append(logSupport.getMessage(messageSource, systemInfo.getLocale(), patchStep));            
        }else{
            LogSupport logSupport = (LogSupport) object;
            //stringBuilder.append(logSupport.getMessage(messageSource, systemInfo.getLocale()));
        }
        
        EventLog eventLog = new EventLog(loggingType.getNumString(), viewId, stringBuilder.toString(), new Date(), 0);
        store(eventLog);
    }
    
   
    
    public String eventLogMessage(String key, Object[] array) {
        //SystemInfo systemInfo = systemInfoManager.getSystemInfo();
        String message = messageSupport.getMessage(key, array, "", Locale.KOREA);
        return message;
    }
    
}