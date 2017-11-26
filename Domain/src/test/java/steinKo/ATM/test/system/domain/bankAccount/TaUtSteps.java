package steinKo.ATM.feature.bankAccount;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;


import cucumber.api.java8.En;
import steinKo.ATM.domain.BankAccount;
public class TaUtSteps implements En {
	BankAccount bankkonto;
	public TaUtSteps () {
	       bankkonto= new BankAccount(0);
	       
	       Given("^jeg har (\\d+) kr på konto$", (Integer belop1) -> { bankkonto.gi(belop1);});
	       When("^jeg tar ut (\\d+) kr$", 
	    	   (Integer belop2) -> {bankkonto.ta(belop2);
	    	});
	  
           Then("^kontoen skal ha en saldo på (\\d+)kr$", (Integer saldo) -> {assertThat(bankkonto.saldo(),equalTo(saldo));});
	
           
           
           Given("^Jeg har (\\d+) kr på konto$", (Integer belop3) -> {bankkonto.gi(belop3);
        	});

        	When("^jeg setter inn (\\d+) kr$", (Integer belop4) -> {bankkonto.gi(belop4);
        	});

        	Then("^kontoen skal ha en saldo på (\\d+) kr$", (Integer saldo) -> {
        		assertThat(bankkonto.saldo(),equalTo(saldo));
        	});

	}
	
	


}
