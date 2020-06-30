package org.steinko.atm.service;

import org.junit.jupiter.api.Test;
import org.steinko.atm.service.ATMServiceImpl;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ATMServiceImplTest {
	
	@Test
	public void test() {	
		ATMServiceImpl atmServicImpl;
		atmServicImpl = new ATMServiceImpl();
		assertNotNull(atmServicImpl);
	}
}
