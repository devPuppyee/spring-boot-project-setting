package springboot.snowone.practice;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("seolhan")
public class SeolhanProperties {
    private String name;
    private int age;
    private String fullName;
}
