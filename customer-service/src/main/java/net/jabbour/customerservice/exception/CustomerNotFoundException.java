package net.jabbour.customerservice.exception;
import org.springframework.http.HttpStatus;

public class CustomerNotFoundException  extends  GlobalApiException{
    public CustomerNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
