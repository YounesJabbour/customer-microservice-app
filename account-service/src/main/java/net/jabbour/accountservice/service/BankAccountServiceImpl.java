package net.jabbour.accountservice.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import net.jabbour.accountservice.dtos.CreateAccountDto;
import net.jabbour.accountservice.entities.BankAccount;
import net.jabbour.accountservice.enums.Status;
import net.jabbour.accountservice.exception.AccountNotFoundException;
import net.jabbour.accountservice.repository.BankAccountRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
@Transactional
public class BankAccountServiceImpl implements BankAccountService {
    private final BankAccountRepository bankAccountRepository;

    @Override
    public Optional<BankAccount> getAccountById(String id) {
        return bankAccountRepository.findById(id);
    }

    @Override
    public BankAccount createAccount(CreateAccountDto accountDto) {
        BankAccount bankAccount = BankAccount.builder()
                .accountId(UUID.randomUUID().toString())
                .balance(accountDto.getBalance())
                .currency(accountDto.getCurrency())
                .type(accountDto.getType())
                .status(Status.CREATED)
                .createdAt(LocalDate.now())
                .updatedAt(LocalDate.now())
                .customerId(accountDto.getCustomerId())
                .build();
        return bankAccountRepository.save(bankAccount);
    }

    @Override
    public BankAccount updateAccount(String id, BankAccount updatedAccount) {
        Optional<BankAccount> existingAccountOpt = bankAccountRepository.findById(id);
        if (existingAccountOpt.isPresent()) {
            BankAccount existingAccount = existingAccountOpt.get();
            existingAccount.setBalance(updatedAccount.getBalance());
            existingAccount.setCurrency(updatedAccount.getCurrency());
            existingAccount.setType(updatedAccount.getType());
            existingAccount.setStatus(updatedAccount.getStatus());
            existingAccount.setUpdatedAt(LocalDate.now());
            existingAccount.setCustomerId(updatedAccount.getCustomerId());
            return bankAccountRepository.save(existingAccount);
        } else {
            throw new AccountNotFoundException("Account not found with id: " + id);
        }
    }
    @Override
    public void deleteAccount(String id) {
        bankAccountRepository.deleteById(id);
    }
    @Override
    public Page<BankAccount> getAllAccounts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return bankAccountRepository.findAll(pageable);
    }
    @Override
    public List<BankAccount> getAllAccounts() {

        return bankAccountRepository.findAll();
    }
}