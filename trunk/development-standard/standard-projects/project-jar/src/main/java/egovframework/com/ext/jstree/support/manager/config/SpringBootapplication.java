package egovframework.com.ext.jstree.support.manager.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;

//1. spring.pom 파일 spring-boot 활성화
//2. 본 자바 파일 확장자 변경.
//@SpringBootApplication
//@EnableScheduling
//@EnableWebMvcSecurity
public class SpringBootapplication{

    private static Log logger = LogFactory.getLog(SpringBootapplication.class);
    
    @Bean
    protected ServletContextListener listener() {
            return new ServletContextListener() {

                    @Override
                    public void contextInitialized(ServletContextEvent sce) {
                            logger.info("ServletContext initialized");
                    }

                    @Override
                    public void contextDestroyed(ServletContextEvent sce) {
                            logger.info("ServletContext destroyed");
                    }

            };
    }

    public static void main(String[] args) throws Exception { 
            //SpringApplication.run(SpringBootapplication.class, args);
    }
    
}
