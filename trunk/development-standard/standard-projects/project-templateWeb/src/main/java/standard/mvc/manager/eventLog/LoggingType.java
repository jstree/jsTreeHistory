package standard.mvc.manager.eventLog;


/**
 * 로그 전송할때 사용되는 타입
 * 
 * @author kimseokwon 2011. 11. 16.
 * 추가 수정시에는 항상 서버쪽과 상태값을 맞추어야 하므로 서버프로그램 담당자에게 통보해야함.
 * ToolSystemLogContoller.java  getBindTypes 함께 변경해야함.
 * BT:186769에서 정리된 내용에 따라 변경
 */
public enum LoggingType {
    AUDIT_SYSTEM("1"), AUDIT_PROCESS("2"), AUDIT_BNR("3"), AUDIT_SETUP("4"), AUDIT_INTEGRITY("5"), 
    AUDIT_ALARM("6"), AUDIT_DISKMGMT("7"), AUDIT_LOGCOLLECT("8"), 
    AUDIT_AGENT_MANAGER("9"),
    AUDIT_POLICY("10");
    
    private String num;
    
    LoggingType(String num) {
        this.num = num;
    }
    
    public String getNumString() {
        return this.num;
    }
}
