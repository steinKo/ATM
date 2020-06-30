package gradle.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.Before;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

public class TautSteps {
	
	String info = "";
	
	@Before 
	public void beforeActions() {	
			RestAssured.baseURI = "http://localhost:4001";
			RestAssured.sessionId = "1234";
	}
	

	@Given("Jeg har {int} kr på konto")
	public void jeg_har_kr_på_konto(int balance) {
	    
	}

	
	@Then("vises meldingen")
	public void vises_meldingen(String docString) {
		given().
	    when().
	      get("/atm").
	    then().
	       statusCode(200).
	       body(is(equalTo(docString)));
	}
	
	
	@When("jeg taster inn {string} for kudenummer")
	public void jeg_taster_inn_for_kudenummer(String kundenummer) {
	   this.info = kundenummer;
	}

	@When("trykker på knapp A")
	public void trykker_på_knapp_A() {
		given()
		  .body(info).
		when()
		  .post("/atm/pushButtonA").
		then()
		  .statusCode(200); 
	}

	@When("jeg taster inn {string} for pin")
	public void jeg_taster_inn_for_pin(String pin) {
		
	    this.info = pin;
	}

	@When("trykker på knapp B")
	public void trykker_på_knapp_B() {
		given()
		  .body(info).
		when()
		  .post("/atm/pushButtonB").
		then()
		  .statusCode(200); 
	}

	

	@When("jeg tar ut {int} kr")
	public void jeg_tar_ut_kr(int int1) {
	    
	}

	@Then("kontoen skal ha en saldo på {int} kr")
	public void kontoen_skal_ha_en_saldo_på_kr(int int1) {
	    
	}

	@When("jeg kanelere interaksjonen mmed konto")
	public void jeg_kanelere_interaksjonen_mmed_konto() {
	    
	}


	@When("jeg avslutter intteraksjonen med ATM")
	public void jeg_avslutter_intteraksjonen_med_ATM() {
	    
	}

	@When("trykker på knapp C")
	public void trykker_på_knapp_C() {
	    
	}


}
