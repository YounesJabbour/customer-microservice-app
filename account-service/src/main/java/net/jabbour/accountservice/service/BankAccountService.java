package net.jabbour.accountservice.service;

import net.jabbour.accountservice.dtos.CreateAccountDto;
import net.jabbour.accountservice.entities.BankAccount;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface BankAccountService {
    Optional<BankAccount> getAccountById(String id);
    BankAccount createAccount(CreateAccountDto customer);
    BankAccount updateAccount(String id, BankAccount customer);
    void deleteAccount(String id);
    Page<BankAccount> getAllAccounts(int page, int size);
    List<BankAccount> getAllAccounts();
}
