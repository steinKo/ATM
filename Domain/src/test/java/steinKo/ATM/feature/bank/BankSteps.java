package steinKo.ATM.feature.bank;


import cucumber.api.java8.En;
import steinKo.ATM.Config;

import steinKo.ATM.domain.Bank;
import steinKo.ATM.domain.BankAccount;
import steinKo.ATM.domain.Customer;

import steinKo.ATM.repository.BankRepository;


import static org.junit.Assert.assertNull;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;


@ContextConfiguration(classes=Config.class)
@Scope("cucumber-glue")
public class BankSteps implements En{
	
	private String name;
    private Customer customer;
    private static AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Config.class);
	private final static Logger logger = LoggerFactory.getLogger(BankSteps.class);
	private Bank bank;
	
	public BankSteps () {
		setUp();
		try {
			
			   bank = createBank();
		    } catch (Exception e) {
			logger.info("No bank created");
			e.printStackTrace();
		}
		
		

Given("^Person med navn \"([^\"]*)\"$", (String name) -> {  
   assertNull( bank.findCustomerByName(name));
});

Given("^person nummer (\\d+) ikke  er kunde kunde i banken$", (Long personId) -> {
    assertNull(bank.findCustomerByPersonId(personId));
});

When("^oppretter en ny kunde  med \"([^\"]*)\"$", (String name) -> {
     this.name = name;
});

Then("^a customer with customer number (\\d+) exist$", (Long customerNumber) -> {
	customer = bank.findCustomerByCustomerNumber(customerNumber);
	assertEquals(customerNumber, customer.getCustomerNumber());
});

Then("^opprettes en ny kunde med kunde nummer (\\d+)$", (Long customerNumber) -> {
	customer = bank.findCustomerByCustomerNumber(customerNumber);
	assertEquals(customerNumber, customer.getCustomerNumber());
});

Then("^en spare konto$", () -> {
   assertNotNull(customer.savingAccount());
});

Then("^en bruks konto$", () -> {
	 assertNotNull(customer.checkingAccount());
});

When("^person nummer (\\d+) and  pin (\\d+) customer number (\\d+)$", (Integer id, Integer pin, Long number) -> {
	 bank.createCustomer(name,id,number,pin);
	
});



Given("^Customer with customer number (\\d+) exist$", (Long customerNumber) -> {
	
	customer = bank.findCustomerByCustomerNumber(customerNumber);
	assertEquals(customerNumber, customer.getCustomerNumber());
});

When("^find customer with customer number (\\d+)$", (Long customerNumber) -> {
	customer = bank.findCustomerByCustomerNumber(customerNumber);
	assertEquals(customerNumber, customer.getCustomerNumber());
});

Then("^persons name is \"([^\"]*)\"$", (String name) -> {
    assertEquals(customer.getName(),name);
});

Then("^person id is (\\d+)$", (Long id) -> {
	 assertEquals(customer.getPersonId(),id);
});

Then("^customer number is (\\d+)$", (Long number) -> {
	 assertEquals(customer.getCustomerNumber(),number);
});





	}
	
	private Bank createBank() 
	  {
		  BankRepository bankRepository = annotationConfigApplicationContext.getBean(BankRepository.class);
		  logger.info(bankRepository.toString());
		  List<Bank> banks=  bankRepository.findAll();
		  Bank bank = null;
		  if (!banks.isEmpty())
		  {
	          bank = banks.get(0);  
		  } else
			try {
				throw new Exception("No bank found ");
			} catch (Exception e) {
				
				e.printStackTrace();
			}
	       
		     return bank;
	  }
	
	private void setUp()
	{ 
		
		BankRepository bankRepository = annotationConfigApplicationContext.getBean(BankRepository.class);
		Bank bank = Bank.create();
		bank.createCustomer("", 0L, 101L, 4567);
		Customer customer = bank.findCustomerByCustomerNumber(101L);
		BankAccount savingAccount = customer.savingAccount();
		savingAccount.gi(400);
		bank.createCustomer("Anne Korsveien", 26076144575L, 100L, 1234);
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
		bankRepository.save(bank);
		
		
	}
}
