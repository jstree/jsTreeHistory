package egovframework.com.ext.jstree.support.manager.eventLog;


import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.StringEscapeUtils;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.context.ApplicationContext;

import egovframework.com.ext.jstree.support.util.Text;
import standard.mvc.component.manager.viewResolver.specialPurposeView.CsvViewForLog;



//@Entity
//@Table(name = "event_log", schema = "config")
//@org.hibernate.annotations.Entity(selectBeforeUpdate = true, dynamicUpdate = true)
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class EventLog implements CsvViewForLog{
    private long id;
    private String eventLogType;    // @see LogginType.java
    private String loginId;
    private String logContents;
    private Date regDate;
    
    public EventLog() {
    }
    
    public EventLog(String eventLogType, String loginId, String logContents, Date regDate) {
        this.eventLogType = eventLogType;
        this.loginId = loginId;
        this.logContents = logContents;
        this.regDate = regDate;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    @Column(name = "login_id")
    public String getLoginId() {
        return loginId;
    }
    
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }
        
    @Column(name = "log_contents")
    public String getLogContents() {
        return logContents;
    }
    
    public void setLogContents(String logContents) {
        this.logContents = logContents;
    }
    
    @Column(name = "reg_date")
    public Date getRegDate() {
        return regDate;
    }
    
    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
    
    @Override
    @Transient
    public String getHeader(ApplicationContext context, Locale locale) {
        StringBuilder builder = new StringBuilder();
        
        builder.append(context.getMessage("MNU_TOOL_LOG_LIST_TIME", null, locale)).append(","); // 시간
        builder.append(context.getMessage("MNU_TOOL_LOG_LIST_TYPE", null, locale)).append(","); // 종류
        builder.append(context.getMessage("MNU_TOOL_LOG_LIST_USER", null, locale)).append(","); // 관리자
        builder.append(context.getMessage("MNU_TOOL_LOG_LIST_DESC", null, locale)); // 내용
        return builder.toString();
    }
    
    @Override
    @Transient
    public String getCsvData(ApplicationContext context, Locale locale) {
        //Map<String, Map<String, Object>> bindTypes = ToolSystemLogController.getBindTypes();
        
        StringBuilder builder = new StringBuilder();
        builder.append(this.regDate).append(",");
        //builder.append(context.getMessage(Text.getBindType(bindTypes, "eventLogTypes", this.eventLogType.toString()), null, locale)).append(",");
        builder.append(this.loginId).append(",");
        builder.append(StringEscapeUtils.escapeCsv(this.logContents));
        return builder.toString();
    }

    @Column(name = "event_log_type")
    public String getEventLogType() {
        return eventLogType;
    }

    public void setEventLogType(String eventLogType) {
        this.eventLogType = eventLogType;
    }

    @Override
    public String toString() {
        return "EventLog [id=" + id + ", eventLogType=" + eventLogType + ", loginId=" + loginId + ", logContents=" + logContents + ", regDate=" + regDate + "]";
    }
    
}
