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
package egovframework.com.ext.jstree.support.manager.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Modification Information
 * 
 * @author 류강하
 * @since 2015. 4. 16.
 * @version 1.0
 * @see <pre>
 * Class Name  : TestWebApplicationContextConfig.java
 * Description : JsTree Spring+iBATIS 버젼의 JUnit4 + DbUnit 테스트를 위해 WebApplicationContextConfig를 확장한 클래스
 * Infomation  : JsTree 코어 서비스 로직을 검증하는 테스트
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일                수정자                 수정내용
 * -------       ------------   -----------------------
 * 2015. 4. 16.  류강하                 최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Configuration
@PropertySource({ "classpath:/META-INF/egovframework/egovProps/globals.properties"
                , "classpath:/META-INF/egovframework/egovProps/test-globals.properties" })
public class TestWebApplicationContextConfig extends WebApplicationContextConfig {}