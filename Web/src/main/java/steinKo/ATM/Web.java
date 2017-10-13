package steinKo.ATM;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import steinKo.ATM.presentaion.web.HomePage;
@SpringBootApplication

public class Web {
	private static ConfigurableApplicationContext applicationContext;
	private final static Logger logger = LoggerFactory.getLogger(Web.class);

	public static void main(String[] args) throws Exception {
		SpringApplication springApplication = new SpringApplication(Web.class);
		applicationContext = springApplication.run(args);
		CountDownLatch countDownLatch = new CountDownLatch(1);
		Runnable bankFactory = new BankFactory(applicationContext,springApplication, countDownLatch);
		logger.info("bank factory created");
		Thread tread = new Thread(bankFactory);
		tread.start();
		logger.info("bank factory tread started ");
		
	}

	public Class<HomePage> getHomePage() {
		return HomePage.class;
	}

	public static ApplicationContext getApplicationContext() {

		return applicationContext;
	}

}
