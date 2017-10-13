package steinKo.ATM;

import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.ReflectionUtils;


import steinKo.ATM.domain.Bank;
import steinKo.ATM.domain.BankAccount;
import steinKo.ATM.domain.Customer;
import steinKo.ATM.repository.BankRepository;

public class BankFactory implements Runnable {

	
	private SpringApplication springApplication;
	private ApplicationContext applicationContext;
	
	
	private CountDownLatch countDownLatch;
	private final Logger logger = LoggerFactory.getLogger(BankFactory.class);

	public BankFactory(ApplicationContext applicationContext,SpringApplication springApplication, CountDownLatch countDownLatch) {
		
		this.springApplication = springApplication;
		this.applicationContext = applicationContext;
		this.countDownLatch = countDownLatch;
	}
	
	
	private  void loadApplicationContext()
	{     ApplicationContext beansToLoad = new AnnotationConfigApplicationContext(WebConfig.class);
	      
	      Object[] beans = getBeans(beansToLoad);
	      

		  loadBeans(beans);
	      
	      refresApplicationContext();
		 
	    
		  
	  
	}


	private void refresApplicationContext() {
		Method refresh = null;
		  try {
			    refresh = SpringApplication.class.getMethod("refresh", (new Class[] { ApplicationContext.class}));
		      } catch (NoSuchMethodException e) {
		    	    logger.info("NoSuchMetodException refresh method");
			    e.printStackTrace();
		      } catch (SecurityException e) {
			
			   e.printStackTrace();
			   logger.info("SecurityException refresh method");
		    }
		  ReflectionUtils.makeAccessible(refresh);

		  logger.info("get methode refresh");
	      ReflectionUtils.invokeMethod(refresh, springApplication, new Object[] {applicationContext}  );
	      logger.info("invoke methode refresh");
	}


	private void loadBeans(Object[] beans) {
		Method load = null;
		  try {
			    Class[] loadParameterTypes = new Class[] { ApplicationContext.class, Object[].class };
			    for (Class loadParameterType:loadParameterTypes   )
			    { 
			    	   logger.info(loadParameterType.toString());
			    }
			    
			    load = SpringApplication.class.getMethod("load", loadParameterTypes);
		      } catch (NoSuchMethodException e) {
			     logger.info("NoSuchMetodException load method");
			     e.printStackTrace();
		      }  catch (SecurityException e) {
			      logger.info("SecurityException load method");
		          e.printStackTrace();
	          }
		  
		  ReflectionUtils.makeAccessible(load);

		  logger.info("get methode load");
		  Object[] loadParameters = new Object[] {applicationContext,beans  };
		  
	      ReflectionUtils.invokeMethod(load, springApplication, loadParameters );
	      logger.info("invoke methode load");
		
	}


	private Object[] getBeans(ApplicationContext beansToLoad) {
		Object[] beans = new  Object[beansToLoad.getBeanDefinitionCount()]; 
	      String[] beanNames = beansToLoad.getBeanDefinitionNames();
	      for (int i =0;i<beansToLoad.getBeanDefinitionCount();i++)
	  	  { 
	    	     beans[i]= beansToLoad.getBean(beanNames[i]);
	    	  
	  	  }
		return beans;
	}

	private void createBank() {

		Bank bank = Bank.create();

		bank.createCustomer("", 0L, 101L, 4567);
		Customer customer = bank.findCustomerByCustomerNumber(101L);
		BankAccount savingAccount = customer.savingAccount();
		savingAccount.gi(400);
		bank.createCustomer("", 0L, 100L, 1234);
		customer = bank.findCustomerByCustomerNumber(100L);
		BankAccount checkingAccount = customer.checkingAccount();
		checkingAccount.gi(600);
		bank.createCustomer("", 0L, 102L, 1234);
		customer = bank.findCustomerByCustomerNumber(102L);
		savingAccount = customer.savingAccount();
		savingAccount.gi(400);
		bank.createCustomer("", 0L, 103L, 1234);
		customer = bank.findCustomerByCustomerNumber(103L);
		savingAccount = customer.savingAccount();
		savingAccount.gi(600);

		BankRepository bankRepository;
		bankRepository = applicationContext.getBean(BankRepository.class);
		logger.info(bankRepository.toString());
		bankRepository.save(bank);

	}

	@Override
	public void run() {
		logger.info("Before load application context");
		//loadApplicationContext();
		logger.info("before create bank");
		createBank();
		
		countDownLatch.countDown();
		logger.info("End run");
	}

}
