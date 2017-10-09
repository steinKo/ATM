package steinKo.ATM.domain;



public class Start extends ATMState {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private static Start instance = null;

	Start(ATM atm) {
		super(atm);
	}
	
	public static ATMState instance(ATM atm)
    {
	    if (instance  == null)
		    instance = new Start(atm);
	    return instance;
     }

	@Override
	String displaye() {
		return "Enter customer number\nA = OK";
	}

	@Override
	public void entered(String text) {
		atm.customerNumber(Long.parseLong(text));
		changeState(Pin.instance(atm));
		
		
	}


	@Override
	public void buttomBPushed(String text) {
		 throw new UnsupportedOperationException();
		
	}

	@Override
	public void buttomCPushed(String text) {
		throw new UnsupportedOperationException();
		
	}
	
	
	

}
