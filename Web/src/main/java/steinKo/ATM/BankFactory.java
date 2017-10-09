package steinKo.ATM;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import steinKo.ATM.domain.Bank;
import steinKo.ATM.domain.BankAccount;
import steinKo.ATM.domain.Customer;
import steinKo.ATM.repository.BankRepository;

public class BankFactory implements Runnable {

	private ApplicationContext applicationContext;
	private CountDownLatch countDownLatch;
	private final Logger logger = LoggerFactory.getLogger(BankFactory.class);

	public BankFactory(ApplicationContext applicationContext, CountDownLatch countDownLatch) {
		this.applicationContext = applicationContext;
		this.countDownLatch = countDownLatch;
	}

	private void createBank() {

		Bank bank = Bank.create();

		bank.createCustomer("", 0L, 101L, 4567);
		Customer customer = bank.findCustomerByCustomerNumber(101L);
		BankAccount savingAccount = customer.savingAccount();
		savingAccount.gi(400);
		bank.createCustomer("", 0L, 100L, 1234);
		customer = bank.findCustomerByCustomerNumber(100L);
		BankAccount checkingAccount = customer.checkingAccount();
		checkingAccount.gi(600);
		bank.createCustomer("", 0L, 102L, 1234);
		customer = bank.findCustomerByCustomerNumber(102L);
		savingAccount = customer.savingAccount();
		savingAccount.gi(400);
		bank.createCustomer("", 0L, 103L, 1234);
		customer = bank.findCustomerByCustomerNumber(103L);
		savingAccount = customer.savingAccount();
		savingAccount.gi(600);

		BankRepository bankRepository;
		bankRepository = applicationContext.getBean(BankRepository.class);
		logger.info(bankRepository.toString());
		bankRepository.save(bank);

	}

	@Override
	public void run() {

		createBank();
		countDownLatch.countDown();
	}

}
