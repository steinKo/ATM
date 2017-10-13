package steinKo.ATM.test.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;



import org.dbunit.DatabaseUnitException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;


import steinKo.ATM.test.integration.AbstactDataBaseTest;
import steinKo.ATM.DomainConfig;
import steinKo.ATM.Category.IntegrationTest;
import steinKo.ATM.domain.Bank;
import steinKo.ATM.repository.BankRepository;



@Category(IntegrationTest.class)
public class BankDataBaseTest extends AbstactDataBaseTest{
	

	
	
	

	BankRepository bankRepository;
	
	@BeforeClass
	public static void  init()
	{
		
		String xmlDataSet;
		xmlDataSet = "<?xml version='1.0' encoding='UTF-8'?>"+
		"<dataset>"+
	    "<bank id ='1'/>"+
	    "<customer/>" +
	    "<bank_account/>" +
	     "</dataset>";
		AbstactDataBaseTest.init(xmlDataSet,DomainConfig.class);
		
	}
	
	
	@Test
	public void shouldBeSameData() throws DatabaseUnitException
	{
		
        // Assert actual database table match expected table
       // Assertion.assertEquals(expectedTable, actualTable);
		
	}
		
		@Test
		public void shouldFindBank() 
		{    
			bankRepository = (BankRepository) applicationContext.getBean("bankRepository");
		     Bank	 bank = bankRepository.findOne(1L);
		     assertNotNull(bank);
		     long id = bank.getId();
		     assertEquals(id,1L);
		}
		
	

}
