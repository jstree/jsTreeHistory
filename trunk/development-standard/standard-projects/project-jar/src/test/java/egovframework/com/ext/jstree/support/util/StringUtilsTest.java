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
package egovframework.com.ext.jstree.support.util;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Modification Information
 * 
 * @author 류강하
 * @since 2015. 5. 23.
 * @version 1.0
 * @see <pre>
 * Class Name  : StringUtilsTest.java
 * Description : 문자열 유틸리티에 대한 테스트 클래스
 * Infomation  : 문자열 유틸리티에 대한 테스트 클래스
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일                 수정자                     수정내용
 * -------      ------------  -----------------------
 * 2015. 5. 23.      류강하       최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
public class StringUtilsTest {

    @Test
    public void splitStringByNewLineOrTab() {
        
        String str = "가 abc\n나\r다\t라";
        
        String[] strArray = StringUtils.splitStringByNewLineOrTab(str);
        
        assertThat(strArray[0], is(equalTo("가 abc")));
        assertThat(strArray[1], is(equalTo("나")));
        assertThat(strArray[2], is(equalTo("다")));
        assertThat(strArray[3], is(equalTo("라")));
    }
}