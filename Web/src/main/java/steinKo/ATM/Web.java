package steinKo.ATM;





import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import steinKo.ATM.web.HomePage;
@SpringBootApplication

public class Web {
	private static ConfigurableApplicationContext applicationContext;
	private final static Logger logger = LoggerFactory.getLogger(Web.class);

	public static void main(String[] args) {
		applicationContext = SpringApplication.run(Web.class,args);
		logger.info("after run");
	}

	public Class<HomePage> getHomePage() {
		return HomePage.class;
	}

	public static ConfigurableApplicationContext getApplicationContext() {

		return applicationContext;
	}
	
	
}
