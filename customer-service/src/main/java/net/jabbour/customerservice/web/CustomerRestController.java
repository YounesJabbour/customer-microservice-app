package net.jabbour.customerservice.web;

import lombok.AllArgsConstructor;
import net.jabbour.customerservice.entities.Customer;
import net.jabbour.customerservice.repository.CustomerRepository;
import net.jabbour.customerservice.service.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/customers")
@AllArgsConstructor
@RestController
public class CustomerRestController {

    private final CustomerRepository customerRepository;
    private final CustomerService customerService;

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @GetMapping
    public Page<Customer> getAllCustomers(@RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "10") int size) {
        return customerService.getAllCustomers(page, size);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable long id, @RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.updateCustomer(id, customer));
    }

    @GetMapping("/{id}")
        public ResponseEntity<Optional<Customer>> getCustomerById(@PathVariable long id) {
            return ResponseEntity.ok(customerService.getCustomerById(id));
    }
}

