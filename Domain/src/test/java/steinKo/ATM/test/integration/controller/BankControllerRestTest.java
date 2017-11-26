package steinKo.ATM.test.integration.controller;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Test;

import org.springframework.http.HttpStatus;

import io.restassured.RestAssured;
import io.restassured.config.RedirectConfig;




import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;


public class BankControllerRestTest {
	
	private final String ROOT_URI = "http://localhost:8080";
	
	
	@BeforeAll
	public static void init() {
		
		given()
		       .config(RestAssured.config()
		       .redirect(RedirectConfig.redirectConfig().followRedirects(false)));
		
	}
	
	
   @Test
	public void shouldGetABank() {
		
	   when()
       .get(ROOT_URI + "/bank").
	   then()
	      .body(notNullValue())
	      .statusCode(is(HttpStatus.OK.value()));

	}

}
