package springboot.snowone.practice.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springboot.snowone.practice.SeolhanProperties;

@Service
@RequiredArgsConstructor
public class BaseService {

    private final SeolhanProperties seolhanProperties;

    public String getFullName(){
        return seolhanProperties.getFullName();
    }

}
