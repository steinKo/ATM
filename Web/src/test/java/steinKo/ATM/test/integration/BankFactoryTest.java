package steinKo.ATM.test.integration;

import static org.junit.Assert.assertNotNull;

import java.util.concurrent.CountDownLatch;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import steinKo.ATM.BankFactory;
import steinKo.ATM.Web;
import steinKo.ATM.Category.IntegrationTest;

@RunWith(SpringRunner.class)
@Category(IntegrationTest.class)
public class BankFactoryTest {
	final Logger logger = LoggerFactory.getLogger(BankFactoryTest.class);

	@Test
	public void test() {
		
		SpringApplicationBuilder springApplicationBuilder =new SpringApplicationBuilder();
		String[] args;
		args = new String[1];
		args[0] = "";
		
		ApplicationContext applicationContext = springApplicationBuilder.sources(Web.class).run(args);
		CountDownLatch countDownLatch = new CountDownLatch(1);
		Runnable bankFactory;
		bankFactory = new BankFactory(applicationContext, springApplicationBuilder, countDownLatch);
		Thread tread = new Thread(bankFactory);
		tread.run();
		tread.start();
		try {
			countDownLatch.await();
			logger.info("countdown finished");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(bankFactory);

	}

}
