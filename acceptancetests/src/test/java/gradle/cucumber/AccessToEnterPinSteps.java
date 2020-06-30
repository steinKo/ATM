package gradle.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

public class AccessToEnterPinSteps {
	
	Integer cardNumber;
	
	@Given("ATM in start state")
	public void atm_in_start_state() {
	    
	}

	@When("Card is enterd")
	public void card_is_enterd() {
	   cardNumber = 123456;
	}

	@When("Card is valid")
	public void card_is_valid() {
	   
	}

}
