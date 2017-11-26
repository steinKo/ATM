package steinKo.ATM.test.integration;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import steinKo.ATM.distribution.ATMClient;
import steinKo.ATM.service.ATMS;


class ATMClientTest {

	static ATMClient atmClient;

	
	@BeforeAll
	public static void init() {
		atmClient = new ATMClient();
	}

	@Test
	void shouldDeliverDispaly() {
		
		
		String display = atmClient.display();
		assertEquals(display, ATMS.States.startMessage);
	     
	}
	
	@Test 
	void shouldPushBotton()
	{
		atmClient.pushButtonA("1234");
		
	}
	
	

}
