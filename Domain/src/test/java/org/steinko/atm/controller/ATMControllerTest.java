
package org.steinko.atm.controller;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import  static net.logstash.logback.argument.StructuredArguments.keyValue;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;



import static org.springframework.http.HttpStatus.OK;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import org.steinko.atm.service.ATMService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.BDDMockito.given;

import org.junit.jupiter.api.Test;

@ExtendWith(MockitoExtension.class)
public class ATMControllerTest {
	
	@InjectMocks 
	ATMController controller;
	
	@Mock
	ATMService service;
	
	
	@Test
	public void shoudGetMessage()  { 
		
		String message = "Enter customer number" + "\n" + " A=OK";
		given(service.display()).willReturn(message);
		
		given()
		  .standaloneSetup(controller).
		when()
		  .get("/atm").
		then()
		  .statusCode(OK.value())  
	      .body(is(equalTo(message)));
  }	
  
}