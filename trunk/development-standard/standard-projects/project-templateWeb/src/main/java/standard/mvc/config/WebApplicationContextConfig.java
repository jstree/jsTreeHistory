package standard.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource({
		"classpath:standard/properties/${profile.active.mode}-spring-viewResolver.properties",
		"classpath:egovframework/egovProps/globals.properties" })
@ImportResource({ "classpath*:egovframework/spring/context-*.xml",
		"classpath*:egovframework/spring/com/context-*.xml",
		"classpath*:standard/configurations/com/context-*.xml",
		"classpath*:standard/configurations/context-*.xml" })
public class WebApplicationContextConfig {

	public WebApplicationContextConfig() {
		super();
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer webMobilePropertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
