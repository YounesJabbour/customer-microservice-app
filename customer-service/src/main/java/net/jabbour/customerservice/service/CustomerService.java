package net.jabbour.customerservice.service;

import net.jabbour.customerservice.dtos.CreateCustomerDto;
import net.jabbour.customerservice.entities.Customer;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Optional<Customer> getCustomerById(Long id);
    Customer createCustomer(CreateCustomerDto customer);
    Customer updateCustomer(long id, Customer customer);
    void deleteCustomer(Long id);
    Page<Customer> getAllCustomers(int page, int size);
    List<Customer> getAllCustomers();
}
