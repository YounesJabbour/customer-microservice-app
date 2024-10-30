package net.jabbour.accountservice.repository;

import net.jabbour.accountservice.entities.BankAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
    Page<BankAccount> findAll(Pageable pageable);
}
