package steinKo.ATM.test.integration;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.util.ReflectionUtils;

import steinKo.ATM.BankFactory;
import steinKo.ATM.DomainConfig;
import steinKo.ATM.Web;
import steinKo.ATM.WebConfig;
import steinKo.ATM.Category.IntegrationTest;

@RunWith(SpringRunner.class)
@Category(IntegrationTest.class)
public class BankFactoryTest {
	final Logger logger = LoggerFactory.getLogger(BankFactoryTest.class);

	static private SpringApplication springApplication;
	static private ApplicationContext applicationContext;
	static private Runnable bankFactory;
	static private CountDownLatch countDownLatch;
	static private ApplicationContext toBeLoaded;
	
	@BeforeClass
	public static void setUp()
	{
		springApplication =new SpringApplication(Web.class);
		String[] args;
		args = new String[1];
		args[0] = "";
		
		applicationContext = springApplication.run(args);
		countDownLatch = new CountDownLatch(1);
		bankFactory = new BankFactory(applicationContext, springApplication, countDownLatch);
		toBeLoaded = new AnnotationConfigApplicationContext(DomainConfig.class);
		
	}
	
	
	
	public void test() {
		
	
		
		Thread tread = new Thread(bankFactory);
		tread.run();
		tread.start();
		try {
			countDownLatch.await();
			logger.info("countdown finished");
		} catch (InterruptedException e) {
			logger.info("bank factory interuptedexception");
			e.printStackTrace();
		}
		assertNotNull(bankFactory);

	}
	
	@Test
	public void shouldReturnBeanInApplicationContext() throws NoSuchMethodException, SecurityException {
		
		
		Object[] beans = ReflectionTestUtils.invokeMethod(bankFactory,"getBeans", toBeLoaded);
		assertNotNull(beans);
		
	}
	
	@Test
	public void sholdReturnBeansLoadedToApplicationContext() {
		String[] toBeLoadedBeans = toBeLoaded.getBeanDefinitionNames();
		for (String toBeLoadedBean: toBeLoadedBeans)
			logger.info(toBeLoadedBean);
		Object[] beans = ReflectionTestUtils.invokeMethod(bankFactory,"getBeans", toBeLoaded);
		for (Object bean: beans)
			logger.info(bean.getClass().toString());
	    //ReflectionTestUtils.invokeMethod(bankFactory,"loadBeans", beans);
	    
	  
	}
	

}
