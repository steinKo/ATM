package steinKo.ATM.SystemTest.Web;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import steinKo.ATM.Category.IntegrationTest;
import steinKo.ATM.SystemTest.Web.FramWork.AbstractSystemTest;
import steinKo.ATM.Web;
import steinKo.ATM.domain.Bank;
import steinKo.ATM.domain.BankAccount;
import steinKo.ATM.domain.Customer;
import steinKo.ATM.repository.BankRepository;

@Category(IntegrationTest.class)
public class WithdrawMonyeFromUserAccountTest extends AbstractSystemTest {
	String url;
	private final static Logger logger = LoggerFactory.getLogger(WithdrawMonyeFromUserAccountTest.class);

	private void init() {
		logger.info("start init");

		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(
				Web.class);
		BankRepository bankRepository = annotationConfigApplicationContext.getBean(BankRepository.class);
		Bank bank = Bank.create();
		bank.createCustomer("", 0L, 4251L, 1234);
		Customer customer = bank.findCustomerByCustomerNumber(4251L);
		BankAccount checkingAccount = customer.checkingAccount();
		checkingAccount.gi(600);
		bankRepository.save(bank);
		logger.info("end init");
		annotationConfigApplicationContext.close();

	}

	@Before
	public void setUp() throws Exception {
		logger.info("start setup");
		String sPort = String.valueOf(port);
		logger.info(sPort);
		url = "localhost:" + sPort;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		logger.info("end setup");
	}

	@Test
	public void shouldWithdraw() {
		try {
			logger.info("start shold withdraw");
			init();
			driver.get(url);
			WebElement message = driver.findElement(By.name("message"));
			logger.info(message.getAttribute("value"));
			assertEquals(message.getAttribute("value"), "Enter customer number\nA = OK");
			driver.findElement(By.name("4")).click();
			driver.findElement(By.name("2")).click();
			driver.findElement(By.name("5")).click();
			driver.findElement(By.name("1")).click();
			WebElement pinAndAmount = driver.findElement(By.name("pinAndAmount"));
			logger.info(pinAndAmount.getAttribute("value"));
			assertEquals(pinAndAmount.getAttribute("value"), "4251");
			driver.findElement(By.name("A")).click();
			logger.info("after button A");
			message = driver.findElement(By.name("message"));
			logger.info(message.getAttribute("value"));
			assertEquals(message.getAttribute("value"), "Enter pin\nA = OK");

			driver.findElement(By.name("1")).click();
			driver.findElement(By.name("2")).click();
			driver.findElement(By.name("3")).click();
			driver.findElement(By.name("4")).click();
			pinAndAmount = driver.findElement(By.name("pinAndAmount"));
			logger.info(pinAndAmount.getAttribute("value"));
			assertEquals(pinAndAmount.getAttribute("value"), "1234");

			driver.findElement(By.name("A")).click();
			message = driver.findElement(By.name("message"));
			assertEquals(message.getText(), "Select Account\nA = Checking\nB = Savings\nC = Exit");
			logger.info(message.getText());
			driver.findElement(By.name("A")).click();
			message = driver.findElement(By.name("message"));
			assertEquals(message.getText(), "Balance= 600 kr\nA=Deposit\nB=Withdrawal\nC=Cancel");
			logger.info(message.getText());
			driver.findElement(By.name("2")).click();
			driver.findElement(By.name("0")).click();
			driver.findElement(By.name("0")).click();
			pinAndAmount = driver.findElement(By.name("pinAndAmount"));
			logger.info(pinAndAmount.getAttribute("value"));
			assertEquals(pinAndAmount.getAttribute("value"), "200");
			driver.findElement(By.name("A")).click();
			message = driver.findElement(By.name("message"));
			assertEquals(message.getText(), "Select Account\nA = Checking\nB = Savings\nC = Exit");
			logger.info(message.getText());
			logger.debug("end withdraw mony");
		} catch (NoSuchElementException noShuchElement) {

			logger.info(noShuchElement.toString());
		} catch (StaleElementReferenceException staleElementReference) {
			logger.info(staleElementReference.toString());
			throw new StaleElementReferenceException(staleElementReference.toString());
		}
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
