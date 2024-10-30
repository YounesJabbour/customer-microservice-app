package net.jabbour.accountservice;

import net.jabbour.accountservice.entities.BankAccount;
import net.jabbour.accountservice.enums.AccountType;
import net.jabbour.accountservice.enums.Status;
import net.jabbour.accountservice.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.ArrayList;
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
			List<BankAccount> bankAccounts = new ArrayList<>();
			for (int i = 1; i <= 20; i++) {
				BankAccount bankAccount = BankAccount.builder()
						.accountId(UUID.randomUUID().toString())
						.type(i % 2 == 0 ? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT)
						.balance(Math.random() * 1000)
						.currency(i % 2 == 0 ? "MAD" : "EURO")
						.status(Status.values()[(int) (Math.random() * Status.values().length)])
						.createdAt(LocalDate.now())
						.customerId((long) i)
						.build();
				bankAccounts.add(bankAccount);
			}
			bankAccountRepository.saveAll(bankAccounts);
		};
	};
}
