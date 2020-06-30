package org.steinko.atm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.steinko.atm.service.ATMService;


public class ATMSteps  {
	private String inntasted;
	private int paKonto ;
	private  ATMService atm;
	
	
	private final static Logger logger = LoggerFactory.getLogger(ATMSteps.class);
	
	public ATMSteps ()
	
	
	
	{  
		logger.info("Start ATMSteps");
		 
	   
	      inntasted = new String();
	      
	      //Given("^Jeg har (\\d+) kr på konto$", (Integer belop) -> { paKonto = belop;atm = annotationConfigApplicationContext.getBean(ATMService.class);});
	    
	      //Then("^vises melding$", (String arg1) -> {assertEquals(atm.display(),arg1);});

	      //Then("^vises medling$", (String arg1) -> {assertEquals(atm.display(),arg1);});
	
	      //When("^jeg tar ut (\\d+) kr$", (Integer arg1) -> { atm.withdraw(arg1);});

	      //Then("^kontoen skal ha en saldo på (\\d+) kr$", (Integer arg1) -> {assertEquals((Integer)atm.getBalance(),arg1);});
	
	      //When("^jeg taster inn \"([^\"]*)\" for kudenummer$", (String arg1) -> {inntasted = arg1;});

	      //When("^jeg taster inn \"([^\"]*)\" for pin$", (String arg1) -> {inntasted = arg1;});
	   
	      //When("^trykker på knapp A$", () -> {atm.buttomAPushed(inntasted);});

	      //When("^trykker på knapp B$", () -> {  atm.buttomBPushed(inntasted);});

	      //When("^trykker på knapp C$", () -> {  atm.buttomCPushed("");});

	      //When("^jeg kanelere interaksjonen mmed konto$", () -> { atm.buttomCPushed("");});

	      //Then("^vises meldingen$", (String arg1) -> {assertEquals(atm.display(),arg1);});
	
	      //When("^jeg avslutter intteraksjonen med ATM$", () -> { atm.buttomCPushed("");});
    }
		
}
