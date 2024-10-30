package net.jabbour.customerservice.exception;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Setter
@Getter
@ToString
public class GlobalApiException extends RuntimeException {
    private HttpStatus httpStatus;
    public GlobalApiException(String message, HttpStatus httpStatus ) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
