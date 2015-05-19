/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package standard.mvc.component.business.baroboard.user.manage.basic.setting.general.service;

import java.util.List;

import standard.mvc.component.business.baroboard.user.manage.basic.setting.general.vo.ProhibitionWord;

/**
 * Modification Information
 * 
 * @author 류강하
 * @since 2015. 5. 3.
 * @version 1.0
 * @see <pre>
 * Class Name  : ProhibitionWordService.java
 * Description : 바로보드-회원관리-금지단어 Service 인터페이스
 * Infomation  : 바로보드-회원관리-금지단어 Service 인터페이스
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------       ------------   -----------------------
 * 2015. 5.  3.  류강하                 최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
public interface ProhibitionWordService {

    /**
     * 이메일 금지 단어들을 조회한다.
     * 
     * @return 금지단어 DTO List
     * @throws Exception
     */
    List<ProhibitionWord> getEmailProhibitionWords() 
            throws Exception;
    
    /**
     * 닉네임 금지 단어들을 조회한다.
     * 
     * @return 금지단어 DTO List
     * @throws Exception
     */
    List<ProhibitionWord> getNicknameProhibitionWords() 
            throws Exception;
    
    /**
     * 이메일 금지단어를 추가한다.
     * 
     * @param 금지단어 DTO
     * @return 금지단어 DTO
     * @throws Exception
     */
    ProhibitionWord addEmailProhibitionWord(ProhibitionWord prohibitionWord)
            throws Exception;
    
    /**
     * 닉네임 금지단어를 추가한다.
     * 
     * @param prohibitionWord 금지단어 DTO
     * @return 금지단어 DTO
     * @throws Exception
     */
    ProhibitionWord addNicknameProhibitionWord(ProhibitionWord prohibitionWord)
            throws Exception;

    /**
     * 이메일 금지단어들을 삭제한다.
     * 
     * @return affectedRowCount
     * @throws Exception
     */
    int deleteEmailProhibitionWords() throws Exception;
    
    /**
     * 닉네임 금지단어들을 삭제한다.
     * 
     * @return affectedRowCount
     * @throws Exception
     */
    int deleteNicknameProhibitionWords() throws Exception;

    /**
     * 이메일 금지단어들을 추가한다.
     * 
     * @param emailProhibitionWords 추가할 이메일 금지단어들
     * @return affectedRowCount
     * @throws Exception
     */
    int saveEmailProhibitionWords(List<ProhibitionWord> emailProhibitionWords) 
            throws Exception;

    /**
     * 닉네임 금지단어들을 추가한다.
     * 
     * @param nicknameProhibitionWords 추가할 닉네임 금지단어들
     * @return affectedRowCount
     * @throws Exception
     */
    int saveNicknameProhibitionWords(List<ProhibitionWord> nicknameProhibitionWords)
            throws Exception;
}