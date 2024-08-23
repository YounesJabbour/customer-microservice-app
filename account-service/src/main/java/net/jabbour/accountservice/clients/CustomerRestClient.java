package net.jabbour.accountservice.clients;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import net.jabbour.accountservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping("/customers/{id}")
    @CircuitBreaker(name="customerService", fallbackMethod = "getDefaultCustomer")
    Customer findCustomerById(@PathVariable Long id);

    @GetMapping("/customers")
    @CircuitBreaker(name="customerService", fallbackMethod = "getDefaultCustomers")
    List<Customer> findAllCustomers();

    default Customer getDefaultCustomer(Long id, Exception exception) {
        return Customer.builder()
                .id(id)
                .firstName("N/A")
                .lastName("N/A")
                .email("N/A")
                .build();
    }

    default List<Customer> getDefaultCustomers() {
        return List.of();
    }
}

