# [인프런] 스프링 부트 개념과 활용 (실습 프로젝트)

## _1. 원리_ ##

A. **스프링 부트**
  
	[1] 개념  
	- 제품 수준의 Spring기반 application을 빠르고 쉽게(독립적으로) 만들 수 있게 해주는 tool.  
	- 스프링 부트 자체로 가장 널리 쓰이며, 최선이라 판단되는 스프링 설정들과 third-party 라이브러리들을 제공해준다.

	[2] 목적  
	- 모든 Spring 개발을 할 때, 더 빠르고 폭 넓은 사용성을 제공해 준다.  
	- 일일이 설정하지 않아도 되는 컨벤션을 제공하며, 원한다면 변경도 쉽고 빠르게 할 수 있게해 준다.  
	- 비즈니스 로직에 필요한 기능 뿐 아닌, non-functional 기능들도 제공해준다. (내장서버, security, 외부설정 등)  
	- Xml 설정, code generation을 더 이상 사용하지 않는다. (쉬운 커스터마이징과 명확한 사용성을 위해)  
	- Java8 이상, servlet 3.1 버전 이상 부터 사용 가능하다.  
    
		
B. **의존성 관리**  
  
	- pom.xml에 parent로 등록한 spring-boot-starter-parent덕에 가능하다. (parent는 해당 pom.xml의 부모 역할)
	- spring-boot-starter-parent의 pom.xml을 살펴보면spring-boot-starter-parent을 또 한번 parent로 갖는데,
	  해당 dependency가 의존성을 관리해준다.
  
	  
C. **자동 설정**
  
	- @SpringBootApplication 내에 @SpringBootConfiguration과 @EnableAutoConfigurations, @ComponentScan에 의해서 가능하다.  
	- @ComponentScan을 통해 @Component가 붙은 class들을 bean으로 등록하고  
	- @EnableAutoconfiguration을 통해 jar파일에 정의된 auto configuration들을 bean으로 등록한다.  
	  이 때, auto configuration의 condition을 @ComponentScan으로 등록한 bean을 기준으로 확인한다.

  
## _2. 활용_ ##

A. **기본 기능**
  
	[1] SpringApplication
	- Spring 기반 application의 부트스트랩을 편리하게 제공해주는 class. 
	- 커스터마이징을 위해 인스턴스를 생성해 실행하는 것이 좋다. 
	  (SpringApplication app = new SpringApplication(Application.class); app.run();)
	- 시점에 따른 ApplicationEvent를 제공해주며, AppliationListener를 implements해 이벤트 처리가 가능하다.
	- 보통 리스너를 bean으로 등록하면 컨테이너가 이벤트 시점에 찾아 알아서 실행시켜주지만,
	  컨텍스트 생성 이전에 발생하는 이벤트는 SpringApplication의 addListeners로 직접 등록해줘야 한다.
	

	[2] application.properties & Profile 
	- appliation.properties : 스프링 부트가 구동될 때 자동 로딩하는 파일  
	- 스프링부트는 @ConfigurationProperties 로 설정값들을 type-safety하게 사용할 수 있게 해준다.
	- @Profile : 특정 profile에 대해 특정 빈/동작 설정을 다르게 하는 기능이다.  
	- application-{profie}.properties 형식으로 파일을 profile별로 관리 가능하다.
	- 활성 profile은 외부 설정을 통해 spring.profiles.active값을 지정하거나, @ActiveProfile로 지정한다.
    
		
B. **기술 연동 **  
  
	[1] 스프링 웹 MVC
	- spring-boot-starter-web을 dependecy에 추가하면 별도 설정없이 사용할 수 있다.
	- 기본 설정을 확장하고 싶다면 @Configuration + implements WebMvcConfigurer로 추가 파일 생성이 가능하다.
	- @ReuqestBody, @ResponseBody와 함께 사용되는 HttpMessageConverters를 제공한다.
	  HTTP 요청 본문을 객체로 변경하거나, 객체를 HTTP 응답 본문으로 변경할 때 사용된다.
	- ExceptionHandler를 제공해 사용자 정의 exception처리를 가능하게한다.
	  @ExceptionHandler를 사용해 처리하고, @ControllerAdvice를 사용하면 전역 처리가 가능하다.
	- @CrossOrigin : 다른 오리진끼리 리소스를 공유할 수 있는 방법을 제공하는 표준인,
	  Cross-Origin Resource Sharing 이하 CORS를 제공해준다. CORS설정을 하지않으면 SOP가 기본 적용된다.
		

	[2] 스프링 데이터 
	- 스프링 데이터는 SQL DB/NoSQL을 지원한다.  
	- 각각 dependency를 추가해 사용할 수 있다.
	
	[3] 스프링 Security
	- 보안 관련 인증, 권한 부여 기능을 제공한다.
	- 스프링 security를 기본 적용하면 basic Authentication이 적용되 전체 페이지의
	  인증이 없으면 로그인 폼으로 redirect된다.
	- WebSecurityConfigurerAdapter : 해당 클래스를 extends해 configure 메서드를 오버라이드하면,
	  페이지 별 권한 처리를 커스터마이징 할 수 있다.
	- UserDetailsService : 로그인 폼에 입력된 username을 통해 DB에서 계정 정보를 가져온다. 해당 인터페이스를 implements하면, 
	  각 애플리케이션 계정 DB를 통한 인증이 가능해진다. loadUserByUsername 메서드를 오버라이드 하면 여기서 return된 
	  UserDetails정보로 AuthenticationProvider가 로그인 폼 입력 값을 검증해 인증 여부를 판단한다.
	- PasswordEncoder : 비밀번호를 암호화하는 인터페이스 객체이다.
	  구현체를 대입해주고, 이를 스프링 빈으로 등록해두면 서비스에서 주입받아 사용 가능하다.
	
