package steinKo.ATM.domain;

public class Transact extends ATMState{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;
	private static Transact instance = null;

	Transact(ATM atm) {
		super(atm);
	}
	
	public static ATMState instance(ATM atm)
{
	if (instance  == null)
		instance = new Transact(atm);
	    return instance;
}

	@Override
	String displaye() {
		return "Balance= " + atm.getBalance() + " kr"
		+ "\nA=Deposit\nB=Withdrawal\nC=Cancel";
	}

	@Override
	public void entered(String text) {
		
		atm.deposit(Integer.parseInt(text));
		changeState(Authorised.instance(atm));
		
		
	}


	@Override
	public void buttomBPushed(String text) {
		atm.withdraw(Integer.parseInt(text));
		changeState(Authorised.instance(atm));
		
	}

	@Override
	public void buttomCPushed(String text) {
		changeState(Authorised.instance(atm));
		
	}

}
