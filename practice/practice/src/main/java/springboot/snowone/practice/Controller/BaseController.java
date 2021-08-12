package springboot.snowone.practice.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import springboot.snowone.practice.Service.BaseService;
import springboot.snowone.practice.account.Account;
import springboot.snowone.practice.config.SeolhanError;
import springboot.snowone.practice.config.SeolhanException;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:80")
public class BaseController {

    private final BaseService baseService;

    @GetMapping("/fullname")
    public String getFullName() throws SeolhanException{
        throw new SeolhanException(); // exception advice 테스트
    }

    @GetMapping("/seolhan")
    public String seolhan() throws SeolhanException {
        throw new SeolhanException();
    }
}



