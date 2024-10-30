package net.jabbour.customerservice.service.Impl;

import lombok.RequiredArgsConstructor;
import net.jabbour.customerservice.dtos.CreateCustomerDto;
import net.jabbour.customerservice.entities.Customer;
import net.jabbour.customerservice.exception.CustomerNotFoundException;
import net.jabbour.customerservice.mappers.CustomerMapper;
import net.jabbour.customerservice.repository.CustomerRepository;
import net.jabbour.customerservice.service.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer createCustomer(CreateCustomerDto customer) {
        return customerRepository.save(CustomerMapper.mapToCustomer(customer));
    }

    @Override
    public Customer updateCustomer(long id, Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
    Customer customer = customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
    customerRepository.delete(customer);
    }

    @Override
    public Page<Customer> getAllCustomers(int page, int size) {
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        return customerRepository.findAll(pageable);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
