package steinKo.ATM.test.integration.plumbing;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.MediaType.TEXT_PLAIN;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.reactive.server.WebTestClient;

import steinKo.ATM.plumbing.ATMServiceHander;

class WebServiceTest {
	
	  private static ATMServiceHander atmServiceHander;
	   private static WebTestClient webClient;
	 
	 @BeforeClass
	 public static void init() {
		 atmServiceHander = new ATMServiceHander();
	      webClient = WebTestClient
	     .bindToController( atmServiceHander)
	     .build();
	 }
	
	
		@Test
		public void shouldReturnATMSStartMessage() {
		 
		
		 
		  webClient.get().uri("/display").accept().exchange() 
		 .expectStatus().isOk() 
		 .expectHeader().contentType(TEXT_PLAIN)
		 .expectBody().isEmpty();
		}



}
