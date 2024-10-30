package net.jabbour.accountservice.mappers;
import net.jabbour.accountservice.dtos.CreateAccountDto;
import net.jabbour.accountservice.entities.BankAccount;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public class BankAccountMapper {
    public BankAccount mapToBankAccount(CreateAccountDto accountDto) {
        return BankAccount.builder()
                .customerId(accountDto.getCustomerId())
                .balance(accountDto.getBalance())
                .build();
    }
}
