package steinKo.ATM.test.integration;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import steinKo.ATM.DomainConfig;
import steinKo.ATM.Category.IntegrationTest;

@Category(IntegrationTest.class)
public class ApplicationContextTest {
	private AnnotationConfigApplicationContext annotationConfigApplicationContext;
	private final static Logger logger = LoggerFactory.getLogger(ApplicationContextTest.class);
	@Test
	public void shouldDisplayeBeans()
	{
		annotationConfigApplicationContext = new AnnotationConfigApplicationContext(DomainConfig.class);
		
		 String[] beans =annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String bean : beans)
		 {
			 logger.info(bean.toString());
			 
		 }
		 
		 Object bean =annotationConfigApplicationContext.getBean("dataSource" );
		 logger.info(bean.toString());
	}
}
