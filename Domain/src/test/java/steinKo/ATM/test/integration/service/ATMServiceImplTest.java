package steinKo.ATM.test.integration.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import steinKo.ATM.Category.IntegrationTest;
import steinKo.ATM.repository.BankRepository;
import steinKo.ATM.service.ATMServiceImpl;

@Category(IntegrationTest.class)
public class ATMServiceImplTest {
	
	
	BankRepository bankRepository;

	@Test
	public void test() {
		
		ATMServiceImpl atmServicImpl;
		atmServicImpl = new ATMServiceImpl(bankRepository);
		assertNotNull(atmServicImpl);
		
		
	}

}
