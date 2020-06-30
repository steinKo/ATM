package org.steinko.atm.service;

public class Authorised extends ATMState{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5L;
	private static Authorised instance = null;

	Authorised(ATM atm) {
			super(atm);
			
		}

	public static ATMState instance(ATM atm)
	{
		if (instance == null)
			instance = new Authorised(atm);
		    return instance;
	}

	@Override
	String displaye() {
		return "Select Account\nA = Checking\nB = Savings\nC = Exit";
	}

	@Override
	public void entered(String text) {
		atm.setCheckingAccount();
		changeState(Transact.instance(atm));
		
	}

	@Override
	public void buttomBPushed(String text) {
		atm.setSavingAccount();
		changeState(Transact.instance(atm));
		
	}

	@Override
	public void buttomCPushed(String text) {
		atm.reset();
		changeState(Start.instance(atm));
		
	}

}
