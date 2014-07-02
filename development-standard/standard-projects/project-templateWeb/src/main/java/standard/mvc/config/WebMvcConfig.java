package standard.mvc.config;

import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nz.net.ultraq.thymeleaf.LayoutDialect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.accept.PathExtensionContentNegotiationStrategy;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.util.ArrayUtils;

import standard.mvc.manager.interceptor.RequestHandlerInterceptor;
import standard.mvc.manager.viewResolver.CustomFreemarkerViewResolver;
import standard.mvc.manager.viewResolver.CustomInternalResourceViewResolver;
import standard.mvc.manager.viewResolver.CustomThymeleafViewResolver;
import standard.mvc.manager.viewResolver.SpecialPurposeViewResolver;

/*
@Configuration : 현재 @Configuration 선언된 클래스 현재 소스상 
WebMvcConfig.java 클래스는 spring의 환경설정과 관련된 파일이라고 
스프링에게 알려준다
*/
@Configuration

/*
@EnableWebMvc : web mvc을 이용하는데 있어서 spring container가 
가져야할 기본적인 bean component을 등록해서 빠르게 편하게 mvc을 구축할수 있는 
configuration 환경을 제공한다 예를 들면 spring3 에서 새롭게 제시하고 있는 
@MVC(@RequestMapping, @Requestbody, @ResponseBody) 등의 
스타일을 위해서 등록되어야 하는 RequestMappingHandler,
RequestMappingHandlerAdapter,
ExceptionHandlerExceptionResolver 등의 등록을 자동으로 해준다
XML base였다면 <mvc:annotation-driven/>과 같다
*/
@EnableWebMvc

/*
@ComponentScan : XML에서 <context:component-scan)을 사용한 것처럼 스테레오 타입 애노테이션이 붙은 빈을 자동으로 스캔해서 등록
- basePackages 엘리먼트 값은 빈을 스캔할 기반-base 패키지다
   현재 소스상 보면 com.javaboard.app.web 패키지와 하위 클래스 중에서
  @Component 같은 스테레오 타입 애노테이션이 붙은 클래스를 모두 찾아서 빈으로 등록한다 스캔할 패키지를 여러개 지정해도 된다
- excludeFilters=@Filter(Configuration.class) : 애노테이션에 
   스캔에서 제외할 클래스에서 이름을 넣어준다
*/
@ComponentScan( basePackages="egovframework, standard.mvc", excludeFilters=@Filter(Configuration.class))

/*
@EnableAspectJAutoProxy : @Aspect 로 애스팩트를 정의할 수 있게 해주는
@AspectJ AOP 컨테이너 인프라 빈을 등록해준다.XML에서 사용했던 
<aop:aspectjautoproxy>의 자바 코드 버전이다
*/
@EnableAspectJAutoProxy(proxyTargetClass = true)

/*
@ImportResource : XML에서 사용되던 주요한 전용 태그를 자바 클래스에서 
애노테이션과 코드로 대체할 수 있게 해준다. 자주 사용되지 않는 일부 전용 태그는 
아직 자바 코드와 애노테이션을 이용하는 방식이 지원되지 않는다. 
또한 스프링 시큐리티와 같은 서브프로젝트나 스프링 외의 오픈 소스라이브러리와 상용제품에서 
제공하는 스프링용 전용 태그는 XML 전용 태그만 지원될 수도 있다 자바 코드 중심의 설정 전
략을 선택했더라도 XML 전용 태그가 필요한 경우에는 어쩔 수 없이 XML을 같이 사용해야 한다
이때는 XML이 쪽 필요한 빈 설정만 별도의 파일로 작성한 뒤에 @Configuration
클래스에서 @ImportResource를 이용해 XML 파일의 빈 설정을 가져올 수 있다
*/
@ImportResource({	"/WEB-INF/config/standard/springmvc/dispatcher-servlet.xml",
						"/WEB-INF/config/standard/springmvc/egov-com-*.xml",
						"/WEB-INF/config/egovframework/springmvc/urlfilename-servlet.xml",
						"/WEB-INF/config/egovframework/springmvc/egov-com-*.xml"})
public class WebMvcConfig extends WebMvcConfigurerAdapter {
//WebMvcConfig 클래스는 Application Root Context를 설정하는 클래스 
	
	/*
	@Value : 자바 코드 외부의 리소스나 환경 정보에 담긴 값을 사용하도록 지정해준다
	         Ex) systemPropertie의 spring.profiles.active 값을 가져와 springProfilesActive에 넣어준다
	         web.xml : <param-name>spring.profiles.active</param-name>
					   <param-value>dev</param-value> 값을 가져 온다
	*/
	@Value("#{systemProperties['spring.profiles.active']}")
	private String springProfilesActive;
	
	/*
	@Autowired : Spring Framework에서 지원하는 Dependency 정의 용도의 Annotation으로, 
	             Spring Framework에 종속적이긴 하지만 정밀한 Dependency Injection이 필요한 경우에 유용
	             1. 필드, 생성자, 입력파라미터가 여러개인 메소드(@Qualifier는 메소드의 파라미터)에 적용 가능
				 2.	필드에 직접 정의하는 경우 별도 setter 메소드는 정의하지 않아도 된다
				 3. 기본적으로 type-driven injection 이다. 타입으로 참조할 빈을 찾았을 때 같은 타입의 빈이 여러 개 검색되었을 경우,
				    @Qualifier annotation을 사용하여 구분할 수 있도록 해준다
	*/
	@Autowired
	private ApplicationContext applicationContext;
	@Autowired
	private CustomFreemarkerViewResolver freemarkerViewResolver;
	@Autowired
	private ExceptionHandlerExceptionResolver exceptionHandlerExceptionResolver;
	@Autowired
	private SpecialPurposeViewResolver specialPurpose;
	@Autowired
	private UrlBasedViewResolver urlBasedViewResolver;
	
	/*
	addResourceHandlers : 스프링 3.0 .4에서 추가된 <mvc:resources>의 기능을 담당히는 메소드다 
						  addResourceLocations 설정된 경로에 파일들을 리소스로 등록한다
						  XML 형식으로 설정하면 <mvc:resources mapping="/resources/**" location="/public-resources/" />
	*/	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//registry.addResourceHandler("/resources/**").addResourceLocations("/public-resources/");
		//registry.addResourceHandler("/css/**").addResourceLocations("/public-resources/css/");
		//registry.addResourceHandler("/img/**").addResourceLocations("/public-resources/img/");
		//registry.addResourceHandler("/js/**").addResourceLocations("/public-resources/js/");
		//registry.addResourceHandler("/html/**").addResourceLocations("/public-resources/html/");
		super.addResourceHandlers(registry);
	}
	
	/*
	addInterceptors : 인터셉터를 등록해주는 <mvc:interceptors) 의 자바 코드 버전이다. 파라미터로 제공되는 InterceptorRegistry를 이용해 
	                           인터셉터 오브젝트 또는 빈을 추가
	*/	
	//@Override
	//public void addInterceptors(InterceptorRegistry registry) {
		
	//}
	
	/*
	ContentNegotiatingViewResolver : 뷰 리졸버처럼 직접 뷰 이름으로부터 뷰 오브젝트를 찾아주지 않는다. 대신 미디어 타입 정보를 활용해서 
									  다른 뷰 리졸벼에게 뷰를 찾도록 위입한 후에 가장 적절한 뷰를 선정해서 돌려준다. 뷰 리졸버를 결정해주는 리졸버
	Spring 3.2 이후 부터 contentNegotiatingViewResolver는 contentNegotiationManager를 프로퍼티로 주입 받는다
	Ex Spring 3.2 이전 버젼에서 설정 방법)
	<bean class="org.springframework.web.servlet.view.ContentNegotiatingViewResolver">
	    <property name="mediaTypes">
	        <map>
	            <entry key="html" value="text/html">
	            <entry key="xml" value="application/xml">
	        </entry></entry></map>
	    </property>
	    <property name="order" value="0">
		</property>
	</bean>								  
	*/
	@Bean
	public ContentNegotiatingViewResolver contentNegotiatingViewResolver() {
		ContentNegotiatingViewResolver viewResolver = new ContentNegotiatingViewResolver();
		//기존에 3.2 이하 버젼에서 XML로 주입했던 방법을 3.2 이후 버전에는 contentNegotiationManager 메소드를 통해서 주입 받는다
		viewResolver.setContentNegotiationManager(contentNegotiationManager());
		
		List<ViewResolver> viewResolvers = new ArrayList<>();
		
		viewResolvers.add(specialPurpose);
		viewResolvers.add(urlBasedViewResolver);
		viewResolvers.add(freemarkerViewResolver);
		viewResolvers.add(thymeleafViewResolver());
		viewResolvers.add(internalResourceViewResolver());
		viewResolvers.add(tilesViewResolver());
		//viewResolver를 List 타입으로 받아 값을 주입한다
		viewResolver.setViewResolvers(viewResolvers);
		List<View> defaultViews = new ArrayList<>();
		
		//Spring3 이상, jackson 라이브러리 2 이상일 때는 MappingJackson2JsonView 로 설정해야 한다
		MappingJackson2JsonView mappingJackson2JsonView = new MappingJackson2JsonView();
		//하나의 속성을 포함하는 모델을 직렬화 할 수 있는지 여부를 설정 true 값이면 모델에서 단일 값을 추출하고 직접 직렬화
		mappingJackson2JsonView.setExtractValueFromSingleKeyModel(true);
		//뷰에서 렌더링되는 모델의 특성을 설정, 설정하면 다른 모든 모델의 특성은 무시(이 부분은 정확히 어떤 뜻인지 모르겠음)
		mappingJackson2JsonView.setModelKey("result");
		defaultViews.add(mappingJackson2JsonView);
		viewResolver.setDefaultViews(defaultViews);
		return viewResolver;
	}
	/*
	ContentNegotiationManager : 기존에 Spring 3.2 이전 버전에서 ContentNegotiatingViewResolver에서 XML로 설정했던 작업이
                                3.2 이후에는 ContentNegotiationManager 메소드에서 처리한다	
	*/
	@Bean
	public ContentNegotiationManager contentNegotiationManager() {
		Map<String, MediaType> mediaTypes = new HashMap<>();
		mediaTypes.put("html", MediaType.TEXT_HTML);
		mediaTypes.put("json", MediaType.APPLICATION_JSON);
		//ContentNegotiationStrategy : 확장자 기준, 헤더값 기준 결정이나 고정된 mediaType리턴과 같은 전략적인 설정이 가능해졌다 
		//PathExtensionContentNegotiationStrategy를 이용해서 url의 확장명이 json인 경우 json 형식으로 view resolver를 사용
		//현재는 TEXT_HTML, APPLICATION_JSON 타입이면 json 형식으로 view resolver를 사용
		ContentNegotiationStrategy contentNegotiationStrategy = new PathExtensionContentNegotiationStrategy(mediaTypes);
		return new ContentNegotiationManager(contentNegotiationStrategy);
	}

	/*
	InternalResourceViewResolver : 뷰 리졸벼를 지정하지 않았을 때 자동등록 되는 디폴트 뷰 리졸버다 주로 JSP를 뷰로 사용하고자 할 때 쓰인다 
	                                              테스트 용으로 단순한 예제를 만드는 경우가 아니라면 디폴트로 등록된 기본 상태의 InternalResourceViewResolver를 그대로 사용하는 일은 피해야 한다.
                                                    왜냐하면 해당 jsp 파일을 뷰로 이용하려면 전체 경로를 다 적어줘야 한다 이와 같은 문제를 해결하기 위해 
                                   setPrefix와 setSuffix 메소드를 이용한다 
    */
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
    	InternalResourceViewResolver internalResourceViewResolver = new CustomInternalResourceViewResolver();
        internalResourceViewResolver.setViewClass(JstlView.class);
        internalResourceViewResolver.setPrefix("/WEB-INF");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }
    
    //thymeleaf에 주입 하기 위해 선언된 메소드
	@Bean
	public ServletContextTemplateResolver templateResolver() {
		ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
		templateResolver.setPrefix("/WEB-INF");
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode("HTML5");
		templateResolver.setCharacterEncoding(StandardCharsets.UTF_8.name());
		if (!ArrayUtils.contains(applicationContext.getEnvironment().getActiveProfiles(), "live")) {
			templateResolver.setCacheable(false);
		}
		return templateResolver;
	}
	
	//thymeleaf에 주입 하기 위해 선언된 메소드
	@Bean
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine engine = new SpringTemplateEngine();
		engine.setTemplateResolver(templateResolver());
		engine.setMessageSource(messageSource());
		// thymeleaf-layout-dialect 사용 설정
		engine.addDialect(new LayoutDialect());
		return engine;
	}
    
	//ThymeleafViewResolver Resolver
	@Bean
	public ThymeleafViewResolver thymeleafViewResolver() {
		CustomThymeleafViewResolver thymeleafViewResolver = new CustomThymeleafViewResolver();
		thymeleafViewResolver.setTemplateEngine(templateEngine());
		thymeleafViewResolver.setCharacterEncoding(StandardCharsets.UTF_8.name());
		thymeleafViewResolver.setOrder(7);
		if (!ArrayUtils.contains(applicationContext.getEnvironment().getActiveProfiles(), "live")) {
			thymeleafViewResolver.setCache(false);
		}
		return thymeleafViewResolver;
	}
    
	//TilesViewResolver Resolver
	@Bean
	public TilesViewResolver tilesViewResolver(){
		TilesViewResolver tilesViewResolver = new TilesViewResolver();
		tilesViewResolver.setViewClass(TilesView.class);
		tilesViewResolver.setOrder(10);
		return tilesViewResolver;
	}
	
	/*
	TilesConfigurer : 컴포지트 뷰(Composite View) 패턴을 구현한 라이브러리인 아파치 tiles 관련 메소드 
	                           타일즈는 레이아웃을 이용하여 쉽게 웹페이지를 구성할 수 있도록 도와주는 템플릿 프레임워크
	- 컴포지트 뷰(composite view)란 다른 뷰들을 포함하지만 레이아웃이 아닌 뷰, 컴포지트 뷰는 하나 이상의 뷰들로 구성된 복합적인 뷰임을 의미한다 
	*/
	@Bean
	public TilesConfigurer tilesConfigurer(){
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions(new String[]{"/WEB-INF/tiles/tiles.xml"});
		return tilesConfigurer;
	}
	
	/*
	MessageSource : 메세지 프로퍼티 메소드, 다국어 메세지 설정 할 때 사용 
	*/
	@Bean
	public MessageSource messageSource() {
		//ReloadableResourceBundleMessageSource는 해당 Properties 파일이 변경되었을 경우에도 애플리케이션을 다시 시작할 필요가 없다는 장점이 있다
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		//setBasenames(Properties 파일의 위치, MessageFormat.format(해당 상황에 호출할 Properties 패턴명, 패턴에 대입할 변수값))
		messageSource.setBasenames("public-resources/message/message", MessageFormat.format("public-resources/message/clientenv-{0}", springProfilesActive));
		//Encoding 설정
		messageSource.setDefaultEncoding(StandardCharsets.UTF_8.name());
		/*
		getEnvironment() 메소드로 런타임 환경 오브젝트를 가져와서 getActiveProfiles()메소드를 실행하면 활성 프로파일 목록을 가져올 수 있다.
		application Context 활성 프로파일에 live 없으면 변화에 대한 체크를 하지 않는다
		*/
		if (!Arrays.asList(applicationContext.getEnvironment().getActiveProfiles()).contains("live")) {
			messageSource.setCacheSeconds(0);
		}
		return messageSource;
	}	
	
	/*
	configureDefaultServletHandling : <mvc:default-servlet-handler/>를 등록한 것과 같은 설정 결과를 가져오려면 다
									   음과 같이 configureDefaultServletHandling() 메소드를 작성하기만 하면 된다.
									   지금까지 설명했던 WebMvcConfigurer의 메소드를 이용해 클래스를 만들고 빈으로 등록해주면 
									   자동으로 @MVC 전략에 적용된다.
									   사용되는 이유로는 보통은 정적인 자원들은 public하게 사용되는 것이기 때문에 default servlet이 
									   처리하도록 두는 것이 좋다. 그런데 "/"를 사용해야 할 때가 있을 수도 있는데. 그렇게 되면 container의
									  default servlet을 사용할 수 없게 되어 정적인 자원들을 전송하는 하는 기능을 직접 구현해 줘야 한다 
									  Spring에서는 "/"에 대한 매핑과 함께 <mvc:default-servlet-handler>라는 태그를 사용하여 
									   정적인 자원들을 container의 default servlet을 활용할 수 있게 해준다. 
									  <mvc:default-servlet-handler>를 사용하면, 매치되지 않는 요청에 대해서 Spring에서 
									  container의 default serviet으로 forwarding 처리한다
	*/
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    
    //addViewControllers : URL 패턴을 그대로 뷰 이름으로 돌려주는 간단한 컨트롤러를 등록하는 메소드
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
    	// TODO Auto-generated method stub
//    	registry.addViewController("/introduce/02release-note.do"   ).setViewName("page/02release-note");
//    	registry.addViewController("/introduce/03compose-detail.do" ).setViewName("page/03compose-detail");
//    	registry.addViewController("/introduce/04version-compose.do").setViewName("page/04version-compose");
//    	registry.addViewController("/introduce/05open_sw.do"        ).setViewName("page/05open_sw");
//    	registry.addViewController("/introduce/06runtime.do"        ).setViewName("page/06runtime");
//    	registry.addViewController("/introduce/07dev.do"            ).setViewName("page/07dev");
//    	registry.addViewController("/introduce/08operation.do"      ).setViewName("page/08operation");
//    	registry.addViewController("/introduce/09manage.do"         ).setViewName("page/09manage");
//    	registry.addViewController("/introduce/10component.do"      ).setViewName("page/10component");
//    	registry.addViewController("/introduce/11mobile-api.do"     ).setViewName("page/11mobile-api");
//    	registry.addViewController("/introduce/12hardware.do"       ).setViewName("page/12hardware");
//    	registry.addViewController("/introduce/13software.do"       ).setViewName("page/13software");
//    	registry.addViewController("/introduce/14network.do"        ).setViewName("page/14network");
//    	registry.addViewController("/introduce/15commitor.do"       ).setViewName("page/15commitor");
//    	registry.addViewController("/introduce/16license.do"        ).setViewName("page/16license");
    }
}
