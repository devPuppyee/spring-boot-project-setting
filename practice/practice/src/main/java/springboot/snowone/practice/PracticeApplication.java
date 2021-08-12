package springboot.snowone.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(SeolhanProperties.class)
public class PracticeApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(PracticeApplication.class);
		app.addListeners(new BeforApplicationContextListener());
		app.run();
	}
}
