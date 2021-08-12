package springboot.snowone.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import springboot.snowone.practice.account.Account;
import springboot.snowone.practice.account.AccountService;

import javax.sql.DataSource;
import java.sql.Connection;

@Component
public class PracticeApplicationRunner implements ApplicationRunner {

    @Autowired
    DataSource dataSource;

    @Autowired
    AccountService accountService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Connection connection = dataSource.getConnection();
        System.out.println("===============================");
        System.out.println("url : " + connection.getMetaData().getURL());
        System.out.println("userName : " +connection.getMetaData().getUserName());
        System.out.println("===============================");

        Account account = accountService.createAccount("sh", "1234");

        System.out.println("===============================");
        System.out.println("id : " + account.getId());
        System.out.println("userName : " + account.getUsername());
        System.out.println("passowrd : " +account.getPassword());
        System.out.println("===============================");

        connection.close();
    }
}
