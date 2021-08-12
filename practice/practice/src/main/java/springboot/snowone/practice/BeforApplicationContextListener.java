package springboot.snowone.practice;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

public class BeforApplicationContextListener implements ApplicationListener<ApplicationStartingEvent> {


    @Override
    public void onApplicationEvent(ApplicationStartingEvent applicationStartingEvent) {
        System.out.println("===============================");
        System.out.println("PracticeApplication is starting!");
        System.out.println("===============================");
    }
}

