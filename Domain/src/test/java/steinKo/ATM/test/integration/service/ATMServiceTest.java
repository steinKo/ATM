package steinKo.ATM.test.integration.service;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import steinKo.ATM.Config;
import steinKo.ATM.Category.IntegrationTest;
import steinKo.ATM.service.ATMService;

import steinKo.ATM.test.integration.AbstactDataBaseTest;


@Category(IntegrationTest.class)
public class ATMServiceTest extends AbstactDataBaseTest{
	
	private final static Logger logger = LoggerFactory.getLogger(ATMServiceTest.class);
   
    
	
	private ATMService atmService;
	
	
	@BeforeClass
	public static void  init()
	{
		
		String xmlDataSet;
		xmlDataSet = "<?xml version='1.0' encoding='UTF-8'?>"+
		"<dataset>"+
	    "<bank id ='1'/>"+
	    "<bank_account id = '1' balance = '600'/>" +
	    "<bank_account id = '2' balance = '1000'/>" +
	    "<customer id = '1' name ='stein korsveien' person_Id = '23412334'  customer_number = '100' pin ='1234' bank_id = '1' bankaccout_id = '1' savings_account_id = '2'/>" +
	     "</dataset>";
		AbstactDataBaseTest.init(xmlDataSet,Config.class);
		
	}
  
	@Test
	public void souldWitdrawMonyFromSavingAccount() {
		logger.info("Start MonyFromSavingAccount");
		atmService = applicationContext.getBean(ATMService.class);
		logger.info("Start MonyFromSavingAccount");
		assertEquals(atmService.display(),ATMS.States.startMessage);
		atmService.buttomAPushed("100");
		assertEquals(atmService.display(),ATMS.States.pinMessage);
		atmService.buttomAPushed("1234");
		assertEquals(atmService.display(),ATMS.States.autorizedMessag);
		atmService.buttomAPushed(ATMS.States.savingAccount);
		assertEquals(atmService.display(),"Balance= 600 kr\nA=Deposit\nB=Withdrawal\nC=Cancel");
		atmService.buttomBPushed("200");
		assertEquals(atmService.display(),ATMS.States.autorizedMessag);
		
		
		
		
	}

}
