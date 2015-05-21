package standard.mvc.component.business.baroboard.core.manage.setting.messages;

/**
 * 
 * Modification Information
 * 
 * @author 손호성
 * @since 2015. 5. 20.
 * @version 1.0
 * @see <pre>
 *  Class Name  : ExceptionMessage.java
 *  Description : 설정메뉴의 예외 메세지 통합 관리 목적
 *  Infomation  :
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
public enum ExceptionMessage {
    UN_SUPPORTED("현재 메뉴에서 지원되지 않는 기능입니다."), NOT_AVAILABLE("해당없음");

    private String value;

    private ExceptionMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
