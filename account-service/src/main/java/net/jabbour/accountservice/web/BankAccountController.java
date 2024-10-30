package net.jabbour.accountservice.web;

import lombok.RequiredArgsConstructor;
import net.jabbour.accountservice.clients.CustomerRestClient;
import net.jabbour.accountservice.dtos.CreateAccountDto;
import net.jabbour.accountservice.entities.BankAccount;
import net.jabbour.accountservice.exception.AccountNotFoundException;
import net.jabbour.accountservice.model.Customer;
import net.jabbour.accountservice.service.BankAccountService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("/account")
@RestController
public class BankAccountController {
    private final BankAccountService bankAccountService;
    private final CustomerRestClient customerRestClient;

    @GetMapping("/all")
    public List<BankAccount> accountList(){
        return bankAccountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<BankAccount>> getAccountById(@PathVariable String id) {
        Optional<BankAccount> bankAccount =  bankAccountService.getAccountById(id);

            if(bankAccount.isPresent()){
                Customer customer = customerRestClient.findCustomerById(bankAccount.get().getCustomerId());
                bankAccount.get().setCustomer(customer);
                return ResponseEntity.ok(bankAccount);
            }
            else
                throw new AccountNotFoundException("Account not found");

    }

    @PostMapping
    public ResponseEntity<BankAccount> createAccount(@RequestBody CreateAccountDto bankAccount) {
        return ResponseEntity.ok(bankAccountService.createAccount(bankAccount));
    }

    @GetMapping
    public Page<BankAccount> getAccountsByPage(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
    return bankAccountService.getAllAccounts(page, size);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable String id) {
        bankAccountService.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<BankAccount> updateAccount(@PathVariable String id, @RequestBody BankAccount bankAccount) {
        return ResponseEntity.ok(bankAccountService.updateAccount(id, bankAccount));
    }

}
