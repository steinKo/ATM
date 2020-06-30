package org.steinko.atm.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.steinko.atm.service.ATM;
import org.junit.jupiter.api.extension.ExtendWith;
@ExtendWith(SpringExtension.class)

public  class ATMTest  {
	
	@InjectMocks
	private ATM atm ;
	
	@Test
	public void shouldBeDisplaydAtStart()
	{
		atm = new ATM();
		assertEquals(atm.display(),"Enter customer number\nA = OK");	
	}
	
	@Test
	public void sholdStoreCustumberNumber()
	{
		
		atm = new ATM();
		//when(getCustomerNumber()).thenReturn(123L);
		atm.buttomAPushed("123");
		Long custumberNumber = atm.customerNumber();
		Long result = 123L;
		assertEquals(custumberNumber,result);
	}
	
	@Test
	public void sholdCangeStateToPin()
	{
		
		atm = new ATM();
		atm.buttomAPushed("123");
		assertEquals(atm.display(),"Enter pin\nA = OK");
	}
	
	@Test
	public void sholdStorePin()
	{   
		//createCustomer("",1L,123L, 234);
		atm = new ATM();
		atm.buttomAPushed("123");
		atm.buttomAPushed("234");
		assertEquals(atm.hentPin(),234);
	}
	@Disabled
	@Test
	public void wrongCustomerNumbersholdNotFindCustomerReturtoStart()
	{
		//createCustomer("",1L,100L, 1234);
		atm = new ATM();
		atm.buttomAPushed("123");
		atm.buttomAPushed("1234");
		assertEquals(atm.display(),"Enter customer number\nA = OK");	
	}
	@Test
	public void sholdFindCustomerChangestateToAccount() 
	{  
		//createCustomer("",1L,100L, 1234);
		atm = new ATM();
		atm.buttomAPushed("100");
		atm.buttomAPushed("1234");
		assertEquals(atm.display(),"Select Account\nA = Checking\nB = Savings\nC = Exit");	
	}
	
	@Disabled
	@Test
	public void wrongPinsholdNotFindCustomerChangestateToStart() 
	{   
	    //createCustomer("",1L,100L, 1234);
	    atm = new ATM();
		atm.buttomAPushed("100");
		atm.buttomAPushed("2234");
		assertEquals(atm.display(),"Enter customer number\nA = OK");	
	}
	
	@Test
	public void sholdFindChekcingAccount() 
	{   
		
		//createCustomer("",1L,100L, 1234);
		atm = new ATM();
		atm.buttomAPushed("100");
		atm.buttomAPushed("1234");
		atm.buttomAPushed("100");
		assertTrue(atm.isCheckingAccount());
		
		
	}
	
	@Test
	public void sholdfindCustomerwithExistingCustomerNumber() throws FileNotFoundException
	{ 
	   //createCustomer("",1L,100L, 1234);
	   atm = new ATM();
	   atm.customerNumber(100l);
	   atm.settPin(1234);
	   Long testcustomer = atm.finnCustomer();
	   Long customerNumber;
	   customerNumber=100l;
	   assertEquals(testcustomer,customerNumber);	
	}
	
	@Test
	public void shouldDiplayMessage()
	{
		//createCustomer("",1L,100L, 1234);
		atm = new ATM();
	    assertEquals("Enter customer number\nA = OK", atm.display());
	}
}
