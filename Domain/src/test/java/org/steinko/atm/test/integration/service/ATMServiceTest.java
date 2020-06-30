package org.steinko.atm.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.steinko.atm.service.ATMService;
//import org.springframework.beans.factory.annotation.AutoWired;
public class ATMServiceTest {
	
	private final static Logger logger = LoggerFactory.getLogger(ATMServiceTest.class);	
	//@AutoWired
	private ATMService atmService;
	
	
    @Disabled
	@Test
	public void souldWitdrawMonyFromSavingAccount() {
		
		logger.info("Start MonyFromSavingAccount");
		assertEquals(atmService.display(),"Enter customer number\nA = OK");
		atmService.buttomAPushed("100");
		assertEquals(atmService.display(),"Enter pin\nA = OK");
		atmService.buttomAPushed("1234");
		assertEquals(atmService.display(),"Select Account\nA = Checking\nB = Savings\nC = Exit");
		atmService.buttomAPushed("");
		assertEquals(atmService.display(),"Balance= 600 kr\nA=Deposit\nB=Withdrawal\nC=Cancel");
		atmService.buttomBPushed("200");
		assertEquals(atmService.display(),"200");
	}

}
