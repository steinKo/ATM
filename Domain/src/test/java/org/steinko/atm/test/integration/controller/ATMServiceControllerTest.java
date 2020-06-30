package steinKo.ATM.test.integration;


import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import steinKo.ATM.plumbing.ATMServiceController;

public class  ATMServiceControllerTest {
	
	static ATMServiceController atmServiceController;
	
	@BeforeClass
	 public static void inint()  {
		atmServiceController = new ATMServiceController();
		 
	}
	
	

	@Test
	public void shouldDisplay() {
		
		assertEquals(atmServiceController.display(), "display");
	}
	
	@Test
	public void shouldPushBottnA() {
		atmServiceController.pushBottonA("A");
		
	}

}
