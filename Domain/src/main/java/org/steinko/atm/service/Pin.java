package org.steinko.atm.service;

public class Pin extends ATMState {
    /**
	 * 
	 */
	private static final long serialVersionUID = 3L;
    private static Pin instance = null;

    Pin(ATM atm) {
	    	super(atm);
		
	}

    public static ATMState instance(ATM atm)
    {
	   if (instance == null)
		instance = new Pin(atm);
	    return instance;
     }

     @Override
     String displaye() {
	    return "Enter pin\nA = OK";
     }

    @Override
     public void entered(String text) {
	   atm.settPin(Integer.parseInt(text));
	   Integer customer = 123455;
       if (customer ==null)
    		  changeState(Start.instance(atm));
       else
    	      changeState(Authorised.instance(atm));

	
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
