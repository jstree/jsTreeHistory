package egovframework.com.ext.jstree.support.manager.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Class Name : WebMvcConfig.java Description : 스프링 서블릿 웹 애플리케이션 컨텍스트 설정을 위한 자바
 * 클래스
 * 
 * @author Dongmin.Lee
 * @since 2014.07.02
 * @version 1.0
 * @see
 *
 *      <pre>
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일         수정자             수정내용
 *  -------      ------------   -----------------------
 *  2014.07.02    Dongmin.Lee      최초 생성
 *  2014.07.29    류강하              표준 프레임워크 내 urlfilename-servlet.xml 파일 변경에 따른 백업 파일 생성 및 바로보드 프로젝트 패키지로 이동에 따른 수정
 * 
 *  Copyright (C) 2007 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ImportResource({ "classpath:/META-INF/egovframework/spring/config/test-context-*.xml" })
@Transactional("testTransactionManager")
@TransactionConfiguration(defaultRollback = true) 
public class TestWebMvcConfig extends WebMvcConfigurerAdapter
{
    
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer)
    {
        configurer.enable();
    }
}
