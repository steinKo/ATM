package steinKo.ATM.domain;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.util.Assert;


public class ATM  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  ATMState state;
	private Long customerNumber;
	private int pin;
	private Customer customer;
	private BankAccount account;
	private Bank bank;
	private boolean isCheckingAccount;
	private final static Logger logger = LoggerFactory.getLogger(ATM.class);

	
	
	
	
	

	 public ATM(Bank bank) {
		Assert.notNull(bank, "bank must not be null!");
		this.bank = bank;
		isCheckingAccount = false;
        state = new Start(this);
		}

	public boolean isCheckingAccount()
	{
		return isCheckingAccount;
	}
	public String display() {
		
		return state.displaye();
	}

	public void buttomAPushed(String text) {
		state.entered(text);
	}

	public Long customerNumber() {
		return customerNumber;
	}

	public void customerNumber(Long custmerNumber) {
		this.customerNumber = custmerNumber;
		
	}

	public void changeState(ATMState state) {
		this.state= state;
		
	}

	public void settPin(int pin) {
		this.pin= pin;
		
	}
	
	public int hentPin() {
		return pin;
		
	}

	

	public Customer finnCustomer() {
		
		customer = bank.findCustomerByCustomerNumber(customerNumber());
		if((customer != null))
		   if (pin==customer.getPin())
		      return customer;
		   else
		      return null;
		 else
		   return null;
	}

	public void setSavingAccount() {
		account  = customer.savingAccount();
		isCheckingAccount = false;
	
		
	}
	public void setCheckingAccount() {
		account  = customer.checkingAccount();
		isCheckingAccount = true;
		
	}
	
	public void buttomBPushed(String text)
	{
		state.buttomBPushed(text);
	}
	
	public void buttomCPushed(String text)
	{
		state.buttomCPushed(text);
	}

	public void reset() {
		customerNumber(0l);
		settPin(0);
		customer= null;
		account = null;
		
		
	}

	public int getBalance() {
	   return	account.saldo();
	
		
	}

	public void deposit(int amount) {
		account.gi(amount);
		
	}

	public void withdraw(int amount) {
		account.ta(amount);
		
	}
		

}
