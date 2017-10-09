package steinKo.ATM.domain;

import java.io.Serializable;

public abstract class  ATMState implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 10L;
	protected static ATM atm;
	ATMState(ATM anAtm)
	{
		ATMState.atm = anAtm;
	}
	abstract String displaye();

	public abstract  void entered(String text); 
	public abstract  void buttomBPushed(String text) ;
	public abstract  void buttomCPushed(String text) ;
	
	protected void changeState(ATMState state)
	{  
		atm.changeState(state);
	}
	
	
	
	
	

}
