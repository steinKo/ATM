package org.steinko.atm.service;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope 
public class ATM implements ATMService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  ATMState state;
	private Long customerNumber;
	private int pin;
	private Integer customer;
	private Integer account;
	private boolean isCheckingAccount;
	private final static Logger logger = LoggerFactory.getLogger(ATM.class);

	
	 public ATM() {
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

	public Long finnCustomer() {
		return customerNumber;
	}

	public void setSavingAccount() {
		account  = 123345;
		isCheckingAccount = false;
	}
	public void setCheckingAccount() {
		account  = 12345;
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
		customerNumber = 0L;
		settPin(0);
		customer= null;
		account = null;	
	}

	public Integer getBalance() {
	   return	1200 ;
	 //account.saldo();	
	}

	public void deposit(Integer amount) {
		//account.gi(amount);	
	}

	public void withdraw(Integer amount) {
		//account.ta(amount);
		
	}

}
