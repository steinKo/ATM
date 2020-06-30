package org.steinko.atm.service;


public interface ATMService {

	String display();
	void buttomAPushed(String text);
	void buttomBPushed(String text);
	void buttomCPushed(String text);
	void withdraw(Integer amount);
	Integer getBalance();
	boolean isCheckingAccount();
	void deposit(Integer paKonto);

}
