package net.jabbour.customerservice.web;

import lombok.AllArgsConstructor;
import net.jabbour.customerservice.entities.Customer;
import net.jabbour.customerservice.repository.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequestMapping("/customers")
@AllArgsConstructor
@RestController
public class CustomerRestController {
    private final CustomerRepository customerRepository;

    @GetMapping("")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    @GetMapping("/{id}")
        public Optional<Customer> getCustomerById(@PathVariable long id) {
            return customerRepository.findById(id);
    }
}

