package steinKo.ATM.feature.atm;

 

import static org.junit.Assert.assertEquals;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import org.springframework.test.context.ContextConfiguration;


import cucumber.api.java8.En;

import steinKo.ATM.domain.Bank;
import steinKo.ATM.domain.BankAccount;
import steinKo.ATM.domain.Customer;
import steinKo.ATM.repository.BankRepository;
import steinKo.ATM.service.ATMService;
import steinKo.ATM.Config;




@ContextConfiguration(classes=Config.class)
@Scope("cucumber-glue")
public class ATMSteps  implements En {
	private String inntasted;
	private int paKonto ;
	private static AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Config.class);
	
	private  ATMService atm;
	
	
	private final static Logger logger = LoggerFactory.getLogger(ATMSteps.class);
	
	public ATMSteps ()
	
	
	
	{  
		logger.info("Start ATMSteps");
		 
		  setUp();
	   
	      inntasted = new String();
	      
	      Given("^Jeg har (\\d+) kr på konto$", (Integer belop) -> { paKonto = belop;atm = annotationConfigApplicationContext.getBean(ATMService.class);});
	    
	      Then("^vises melding$", (String arg1) -> {assertEquals(atm.display(),arg1);});

	      Then("^vises medling$", (String arg1) -> {assertEquals(atm.display(),arg1);});
	
	      When("^jeg tar ut (\\d+) kr$", (Integer arg1) -> { atm.withdraw(arg1);});

	      Then("^kontoen skal ha en saldo på (\\d+) kr$", (Integer arg1) -> {assertEquals((Integer)atm.getBalance(),arg1);});
	
	      When("^jeg taster inn \"([^\"]*)\" for kudenummer$", (String arg1) -> {inntasted = arg1;});

	      When("^jeg taster inn \"([^\"]*)\" for pin$", (String arg1) -> {inntasted = arg1;});
	   
	      When("^trykker på knapp A$", () -> {atm.buttomAPushed(inntasted);});

	      When("^trykker på knapp B$", () -> {  atm.buttomBPushed(inntasted);});

	      When("^trykker på knapp C$", () -> {  atm.buttomCPushed("");});

	      When("^jeg kanelere interaksjonen mmed konto$", () -> { atm.buttomCPushed("");});

	      Then("^vises meldingen$", (String arg1) -> {assertEquals(atm.display(),arg1);});
	
	      When("^jeg avslutter intteraksjonen med ATM$", () -> { atm.buttomCPushed("");});
    }
	
	private void setUp()
	{ 
		
		logger.info("Set up");
		annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Config.class);
		logger.info(annotationConfigApplicationContext.toString());
		
		
		Bank bank = Bank.create();
		logger.info(bank.toString());
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
		
		BankRepository bankRepository =  annotationConfigApplicationContext.getBean(BankRepository.class);
		logger.info(bankRepository.toString());
		bankRepository.save(bank);
		
		
	}
	
	
	
}
