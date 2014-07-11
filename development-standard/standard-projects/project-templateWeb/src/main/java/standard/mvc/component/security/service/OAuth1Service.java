package standard.mvc.component.security.service;



import java.util.List;
/**
 *  Class Name : OAuth1Service.java
 *  Description :  OAuth1서비스 연동
 *  Modification Information
 * 
 *  @author 최대열
 *  @since 2014.07.10
 *  @version 1.0
 *  @see
 *
 *  <pre>
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일         수정자             수정내용
 *  -------      ------------   -----------------------
 *  2014.07.10                 최대열		   최초 생성
 *
 *  Copyright (C) 2007 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
public interface OAuth1Service {
	/**
	 * 이미지 리스트를 리턴한다.
	 * @return List<String> 이미지 리스트 
	 */
	List<String> getLastTenPicasaPictureURLs();
	/**
	 * 트위터 사용자 정보를 추출
	 * @return String 사용자 정보 JSON 스트링 리턴 
	 */
	String getTwiterRestTemplate();
}
