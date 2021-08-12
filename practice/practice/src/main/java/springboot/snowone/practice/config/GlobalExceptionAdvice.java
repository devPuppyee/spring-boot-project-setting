package springboot.snowone.practice.config;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(SeolhanException.class)
    public SeolhanError seolhanError(SeolhanException e){
        SeolhanError seolhanError = new SeolhanError();
        seolhanError.setMessage("seolhan.error");
        seolhanError.setReason("I don't know");
        return seolhanError;
    }
}
