package steinKo.ATM.test.integration;

import static org.junit.Assert.assertNotNull;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import steinKo.ATM.Web;
import steinKo.ATM.web.HomePage;


public class ApplicationContextTest {
	
	private static AnnotationConfigApplicationContext applicationContext;
	private static Logger logger = LoggerFactory.getLogger(ApplicationContextTest.class);
	
	@BeforeAll
	public static void init () {
		applicationContext = new AnnotationConfigApplicationContext(Web.class);
		
	}
	
	
	
	@Test
	public void shouldLoadApplicationContext() {
		
		assertNotNull(applicationContext);
	}
	
	@Test
	public void shoulContainBeanWeb() {
		Web web = applicationContext.getBean(Web.class);
		assertNotNull(web);
		Class<HomePage> homePage = web.getHomePage();
		assertNotNull(homePage);
	}
	
	@Test
	public void shoulContainBeanWebApplication() {
		WebApplication web = applicationContext.getBean(WebApplication.class);
		assertNotNull(web);
		Class<? extends Page> homePage = web.getHomePage();
		assertNotNull(homePage);
	}
	
	

	
	@Test
	public void shouldDisplayBeans()  {
	
	String[] beansName = applicationContext.getBeanDefinitionNames();
	assertNotNull(applicationContext);
	for (String beanName : beansName)
		logger.info(beanName);
	
	}
	
	

}
