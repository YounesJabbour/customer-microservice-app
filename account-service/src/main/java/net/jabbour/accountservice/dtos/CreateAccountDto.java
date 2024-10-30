package net.jabbour.accountservice.dtos;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import net.jabbour.accountservice.enums.AccountType;

@Builder
@Getter
@Setter
public class CreateAccountDto {
    private Double balance;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    private Long customerId;
}
