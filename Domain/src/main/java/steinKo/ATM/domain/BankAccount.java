package steinKo.ATM.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity

public class BankAccount implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5979549426057649442L;
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private int  balance;
	
	public    BankAccount( int amount) {
	  
		this.balance = amount;
	}
	
	protected BankAccount() {}
	
	public long getId() {
		return id;
	}
 

	public void gi(int amount) {
		this.balance +=amount;
		
	}

	public int saldo() {

		return balance;
	}

	public void ta(Integer amount) {
		
		this.balance -=amount;
	}

	

}
