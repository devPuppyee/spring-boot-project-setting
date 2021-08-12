package springboot.snowone.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class AfterApplicationContextListener implements ApplicationListener<ApplicationStartedEvent> {

    @Autowired
    SeolhanProperties seolhanProperties;

    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        System.out.println("===============================");
        System.out.println(" ★ My name is " + seolhanProperties.getFullName()+ " ★");
        System.out.println("PracticeApplication is started!");
        System.out.println("===============================");
    }
}
