package steinKo.ATM.test.integration;






import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;


import steinKo.ATM.Web;
import steinKo.ATM.category.IntegrationTest;
import steinKo.ATM.web.HomePage;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Category(IntegrationTest.class)

public class WebTest {
	
	private final static Logger logger = LoggerFactory.getLogger(WebTest.class);
	private static ConfigurableApplicationContext applicationContext;
  
	
	@BeforeClass
    public static  void  init() {
	   String args[];
		args = new String[1];
		args[0] = "";
	   
       logger.info("Before main");
		Web.main(args);
		logger.info("After main");
		applicationContext = Web.getApplicationContext();
		logger.info("After get application context");
	   
	   
   }
	

	
	
	@Test
	public void shoulContainBeanWeb() {
		Web web = applicationContext.getBean(Web.class);
		assertNotNull(web);
		Class<HomePage> homePage = web.getHomePage();
		assertNotNull(homePage);
	}
	
	
	@Test
	public void shouldDisplayBeans()  {
	
	String[] beansName = applicationContext.getBeanDefinitionNames();
	assertNotNull(applicationContext);
	for (String beanName : beansName)
		logger.info(beanName);
	
	}
	
	@Test
	public void shouldLoadApplicationContext() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Web.class);
		assertNotNull(applicationContext);
	}
	
	
	
	
	
	

}
