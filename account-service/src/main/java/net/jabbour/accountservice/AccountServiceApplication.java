package net.jabbour.accountservice;

import net.jabbour.accountservice.entities.BankAccount;
import net.jabbour.accountservice.enums.AccountType;
import net.jabbour.accountservice.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@EnableFeignClients
@SpringBootApplication
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository) {
		return args -> {
				List<BankAccount> bankAccounts = List.of(
						BankAccount.builder().accountId(UUID.randomUUID().toString()).type(AccountType.CURRENT_ACCOUNT)
								.balance(100.0)
								.currency("MAD")
								.createdAt(LocalDate.now())
								.customerId(1L).build(),
						// second account
						BankAccount.builder().accountId(UUID.randomUUID().toString()).type(AccountType.SAVING_ACCOUNT)
								.balance(200.0)
								.currency("EURO")
								.createdAt(LocalDate.now())
								.customerId(2L).build()
				);
				bankAccountRepository.saveAll(bankAccounts);
		};
	}
}
