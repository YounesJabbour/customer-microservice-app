package net.jabbour.customerservice.mappers;
import net.jabbour.customerservice.dtos.CreateCustomerDto;
import net.jabbour.customerservice.entities.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public class CustomerMapper {
    public static Customer mapToCustomer(CreateCustomerDto customerDto) {
    return Customer.builder().email(customerDto.getEmail()).firstName(customerDto.getFirstName()).lastName(customerDto.getLastName()).build();
    }
}
