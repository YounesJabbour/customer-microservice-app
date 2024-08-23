package net.jabbour.customerservice;

import net.jabbour.customerservice.config.GlobalConfig;
import net.jabbour.customerservice.entities.Customer;
import net.jabbour.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@EnableConfigurationProperties(GlobalConfig.class)
@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> {
            List<Customer> customers = List.of(
                    Customer.builder().firstName("younes").lastName("jabbour").email("jb@gmail.com").build(),
                    Customer.builder().firstName("youssef").lastName("jabar").email("ys@gmail.com").build()
            );
            customerRepository.saveAll(customers);
        };
    }
}
