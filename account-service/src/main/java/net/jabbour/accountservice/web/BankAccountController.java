package net.jabbour.accountservice.web;

import lombok.AllArgsConstructor;
import net.jabbour.accountservice.clients.CustomerRestClient;
import net.jabbour.accountservice.entities.BankAccount;
import net.jabbour.accountservice.model.Customer;
import net.jabbour.accountservice.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RequestMapping("/account")
@RestController
public class BankAccountController {
    private BankAccountRepository bankAccountRepository;
    private CustomerRestClient customerRestClient;

//    public List<BankAccount> getAllAccounts() {
//            return bankAccountRepository.findAll();
//    }

    @GetMapping("")
    public List<BankAccount> accountList(){
        List<BankAccount> accountList = bankAccountRepository.findAll();
        accountList.forEach(acc->{
            acc.setCustomer(customerRestClient.findCustomerById(acc.getCustomerId()));
        });
        return accountList;
    }

    @GetMapping("/{id}")
    public Optional<BankAccount> getAccountById(@PathVariable String id) {
            BankAccount bankAccount =  bankAccountRepository.findById(id).orElse(null);
            Customer customer = customerRestClient.findCustomerById(bankAccount.getCustomerId());
            if (customer != null) {
                    bankAccount.setCustomer(customer);
            }
            return Optional.of(bankAccount);
    }
}
