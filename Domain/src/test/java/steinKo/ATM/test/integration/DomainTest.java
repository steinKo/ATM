package steinKo.ATM;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

class DomainTest {
	
	private final static Logger logger = LoggerFactory.getLogger(DomainTest.class);

	@Test
	void test() {
		Domain domain = new Domain();
		String args[];
		ApplicationContext applicationContext;
		args = new String[1];
		args[0] = "";
		domain.main(args);
		applicationContext = Domain.getApplicationContext();
		String[] beansName = applicationContext.getBeanDefinitionNames();
		assertNotNull(applicationContext);
		for (String beanName : beansName)
			logger.info(beanName);
		assertTrue(applicationContext.containsBean("ATMServiceImpl"));
		assertTrue(applicationContext.containsBean("bankRepository"));
		
	}

}
