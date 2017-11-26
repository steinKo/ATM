package steinKo.ATM;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.apache.catalina.LifecycleException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import steinKo.ATM.Service.ATMServiceImpl;
import steinKo.ATM.plumbing.WebService;
import steinKo.ATM.repository.BankRepository;
import steinKo.ATM.service.ATMService;


@SpringBootApplication
@EnableTransactionManagement
public class Domain {
	private final static Logger logger = LoggerFactory.getLogger(Domain.class);
	private static ConfigurableApplicationContext applicationContext;
	@Autowired
	BankRepository bankRepository;
	
		public static void main(String[] args) {
			logger.info("Start domain main");
			applicationContext = SpringApplication.run(Domain.class, args);
			
			logger.info("After SpringApplication run");
			createWebService();
			
			cretaBankFactory();
			logger.info("After createBankFactory");
			
			
			logger.info("End domain main");
			
			
		}
		private static void cretaBankFactory() {
			CountDownLatch countDownLatch = new CountDownLatch(1);
			
			Runnable bankFactory = new BankFactory(applicationContext,countDownLatch);
			logger.info("bank factory created");
			Thread tread = new Thread(bankFactory);
			tread.start();
			logger.info("bank factory tread started ");
			try {
				countDownLatch.await();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					}
		private static void createWebService() {
			WebService webService = new WebService();
			logger.info("After create WebService");
			try {
				webService.startServer();
				logger.info("After start WebService");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (LifecycleException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			logger.info("Ater creating WebService");
		}
		public static ApplicationContext getApplicationContext() {
			return applicationContext;
		}
		
		@Bean
		ATMService atmService()
		{
			return new ATMServiceImpl(bankRepository);
		}
	}

