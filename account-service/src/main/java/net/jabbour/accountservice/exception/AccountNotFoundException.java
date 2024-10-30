package net.jabbour.accountservice.exception;
import org.springframework.http.HttpStatus;

public class AccountNotFoundException  extends  GlobalApiException{
    public AccountNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
