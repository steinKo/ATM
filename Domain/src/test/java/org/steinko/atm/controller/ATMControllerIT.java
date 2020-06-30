package org.steinko.atm.controller;


import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.get;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.post;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import static org.springframework.http.HttpStatus.OK;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class ATMControllerIT {
	
	@Autowired
    private WebApplicationContext webApplicationContext;
	
	@Test
	public void shoudGetMessage()  { 
		
		String message = "Enter customer number";
		given()
		.webAppContextSetup(webApplicationContext).
		when()
		  .get("/atm").
		then()
		  .statusCode(OK.value())
		  .body(is(startsWith(message)));;
	     
		
		String pin = "1234";
		
		given()
		  .webAppContextSetup(webApplicationContext)
		  .body(pin).
		when()
		  .post("/atm/pushButtonA").
		then()
		  .statusCode(OK.value()); 
		
		message = "Enter customer number";
		given()
		.webAppContextSetup(webApplicationContext).
		when()
		  .get("/atm").
		then()
		  .statusCode(OK.value())  
	      .body(is(startsWith(message)));	
  }
	
	

}
