package steinKo.ATM.test.unit.Domain;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.io.FileNotFoundException;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import steinKo.ATM.Category.UnitTest;
import steinKo.ATM.domain.ATM;
import steinKo.ATM.domain.Bank;

import steinKo.ATM.domain.Customer;



import org.springframework.test.context.junit4.SpringRunner;

@Category(UnitTest.class)
@RunWith(SpringRunner.class)

public  class ATMTest  {
	
   
	
	@Mock
	private Customer customer;
	@InjectMocks
	private ATM atm ;
	
	@Mock
    private Bank bank;
	 
	
	
	@Test
	public void shouldBeDisplaydAtStart()
	{
		bank = Bank.create();
		atm = new ATM(bank);
		assertEquals(atm.display(),"Enter customer number\nA = OK");
		
	}
	@Test
	public void sholdStoreCustumberNumber()
	{
		bank = Bank.create();
		atm = new ATM(bank);
		when(customer.getCustomerNumber()).thenReturn(123L);
		atm.buttomAPushed("123");
		Long custumberNumber = atm.customerNumber();
		Long result = 123L;
		assertEquals(custumberNumber,result);
	}
	
	@Test
	public void sholdCangeStateToPin()
	{
		bank = Bank.create();
		atm = new ATM(bank);
		atm.buttomAPushed("123");
		assertEquals(atm.display(),"Enter pin\nA = OK");
	}
	
	@Test
	public void sholdStorePin()
	{   
		
		bank = Bank.create();
		bank.createCustomer("",1L,123L, 234);
		atm = new ATM(bank);
		atm.buttomAPushed("123");
		atm.buttomAPushed("234");
		assertEquals(atm.hentPin(),234);
	}
	@Test
	public void wrongCustomerNumbersholdNotFindCustomerReturtoStart()
	{
		bank = Bank.create();
		bank.createCustomer("",1L,100L, 1234);
		atm = new ATM(bank);
		atm.buttomAPushed("123");
		atm.buttomAPushed("1234");
		assertEquals(atm.display(),"Enter customer number\nA = OK");
		
	}
	@Test
	public void sholdFindCustomerChangestateToAccount() 
	{  
	    
        bank = Bank.create();
		bank.createCustomer("",1L,100L, 1234);
		atm = new ATM(bank);
		atm.buttomAPushed("100");
		atm.buttomAPushed("1234");
		assertEquals(atm.display(),"Select Account\nA = Checking\nB = Savings\nC = Exit");
		
	}
	
	@Test
	public void wrongPinsholdNotFindCustomerChangestateToStart() 
	{   bank = Bank.create();
	    bank.createCustomer("",1L,100L, 1234);
	    atm = new ATM(bank);
		atm.buttomAPushed("100");
		atm.buttomAPushed("2234");
		assertEquals(atm.display(),"Enter customer number\nA = OK");
		
	}
	
	@Test
	public void sholdFindChekcingAccount() 
	{   
		bank = Bank.create();
		bank.createCustomer("",1L,100L, 1234);
		atm = new ATM(bank);
		atm.buttomAPushed("100");
		atm.buttomAPushed("1234");
		atm.buttomAPushed("100");
		assertTrue(atm.isCheckingAccount());
		
		
	}
	
	@Test
	public void sholdfindCustomerwithExistingCustomerNumber() throws FileNotFoundException
	{ 
	   bank = Bank.create();
	   bank.createCustomer("",1L,100L, 1234);
	   atm = new ATM(bank);
	   atm.customerNumber(100l);
	   atm.settPin(1234);
	   Customer testcustomer = atm.finnCustomer();
	   Long customerNumber;
	   customerNumber=100l;
	   assertEquals(testcustomer.getCustomerNumber(),customerNumber);
	
		
	}
	
	@Test
	public void shouldDiplayMessage()
	{
		bank = Bank.create();
		bank.createCustomer("",1L,100L, 1234);
		atm = new ATM(bank);
	    assertEquals("Enter customer number\nA = OK", atm.display());
		
	}
	
	


}
