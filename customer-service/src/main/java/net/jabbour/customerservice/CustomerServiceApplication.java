package net.jabbour.customerservice;

import net.jabbour.customerservice.config.GlobalConfig;
import net.jabbour.customerservice.entities.Customer;
import net.jabbour.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@EnableConfigurationProperties (GlobalConfig.class)
@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> {

            List<Customer> customers = new ArrayList<>();

            for (int i = 1; i <= 20; i++) {
            customers.add(Customer.builder()
            .firstName("firstName" + i)
            .lastName("lastName" + i)
            .email("email" + i + "@gmail.com")
            .build());
            }
            customerRepository.saveAll(customers);
        };
    }
}
