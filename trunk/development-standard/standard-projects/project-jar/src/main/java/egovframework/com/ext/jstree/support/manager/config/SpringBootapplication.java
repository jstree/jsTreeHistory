package egovframework.com.ext.jstree.support.manager.config;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

//1. spring.pom 파일 spring-boot 활성화
//2. 본 자바 파일 확장자 변경.
//@SpringBootApplication
//@EnableScheduling
//@EnableWebMvcSecurity
//@Configuration
public class SpringBootapplication implements SchedulingConfigurer {

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
    
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskExecutor());
    }

    @Bean(destroyMethod="shutdown")
    public Executor taskExecutor() {
        return Executors.newScheduledThreadPool(100);
    }

    public static void main(String[] args) throws Exception { 
    	System.out.println("=== www.313.co.kr spring boot started ===");    
    	//SpringApplication.run(SpringBootapplication.class, args);
    }
    
}
