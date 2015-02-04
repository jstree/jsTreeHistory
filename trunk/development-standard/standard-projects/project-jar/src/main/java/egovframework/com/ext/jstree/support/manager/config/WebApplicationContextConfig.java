package egovframework.com.ext.jstree.support.manager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource({ "classpath:/META-INF/egovframework/egovProps/globals.properties" })
@ImportResource({ "classpath*:/META-INF/egovframework/spring/com/context-*.xml" })
public class WebApplicationContextConfig
{
    
    public WebApplicationContextConfig()
    {
        super();
    }
    
    @Bean
    public static PropertySourcesPlaceholderConfigurer webMobilePropertySourcesPlaceholderConfigurer()
    {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
