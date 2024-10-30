package net.jabbour.accountservice.entities;

import jakarta.persistence.*;
import lombok.*;
import net.jabbour.accountservice.enums.AccountType;
import net.jabbour.accountservice.enums.Status;
import net.jabbour.accountservice.model.Customer;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity

public class BankAccount {
    @Id
    private String accountId;
    private Double balance;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    @Transient
    private Customer customer;
    // foreing key of customer
    private Long customerId;
}
