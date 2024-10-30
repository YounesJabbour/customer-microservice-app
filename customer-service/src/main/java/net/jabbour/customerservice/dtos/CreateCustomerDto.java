package net.jabbour.customerservice.dtos;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Setter
@Getter
public class CreateCustomerDto {
    private String firstName;
    private String lastName;
    private String email;
}
