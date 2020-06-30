package steinKo.ATM.test.integration.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import steinKo.ATM.controller.BankController;

class BankControllerTest {
	
	

	@Test
	void shouldDeliverBank() {
		BankController bankController;
		bankController  = new BankController();
		assertNotNull(bankController.getBank());
		
	}

	

}
