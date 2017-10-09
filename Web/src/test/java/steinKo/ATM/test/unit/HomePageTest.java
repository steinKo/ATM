package steinKo.ATM.test.unit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.util.tester.FormTester;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import steinKo.ATM.Web;
import steinKo.ATM.Category.UnitTest;
import steinKo.ATM.presentaion.web.HomePage;
import steinKo.ATM.service.ATMService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Web.class)
@Category(UnitTest.class)
public class HomePageTest {

	private static Logger logger = LoggerFactory.getLogger("HomePageTest");

	@Autowired
	private WebApplication wicketApplication;

	private WicketTester tester;

	@MockBean
	private ATMService atmServiceMock;
	private FormTester contentFormTester;
	private FormTester menuFormTester;

	@Before
	public void setUp() {
		logger.info("start mock");
		tester = new WicketTester(wicketApplication);
		logger.info("init wiket tester");
		when(atmServiceMock.display()).thenReturn("Enter customer number\nA = OK");
		logger.info("start page home");
		tester.startPage(HomePage.class);
		contentFormTester = tester.newFormTester("content");
		menuFormTester = tester.newFormTester("menu");

	}

	@Test
	public void shouldRender() {

		tester.assertRenderedPage(HomePage.class);
	}

	@Test
	public void shouldExistAButton() {
		tester.assertComponent("menu:A", Button.class);
	}

	@Test
	public void sholdStoreValue() {
		contentFormTester.setValue("pinAndAmount", "1234");
		contentFormTester.submit();
		assertEquals(contentFormTester.getTextComponentValue("pinAndAmount"), "1234");
	}

	@Test
	public void shouldStoreMessage() {

		contentFormTester.setValue("message", "1234");
		contentFormTester.submit();
		assertEquals(contentFormTester.getTextComponentValue("message"), "1234");

	}

	@Test
	public void shoulClearePinAndAmount() {
		contentFormTester.setValue("pinAndAmount", "1234");
		contentFormTester.submit();
		menuFormTester.submit("A");
		assertEquals(contentFormTester.getTextComponentValue("pinAndAmount"), "");
	}

	@Test
	public void shouldReciveMessag() {
		contentFormTester.setValue("message", "1234");
		menuFormTester.submit("A");
		assertEquals(contentFormTester.getTextComponentValue("message"), "Enter customer number\nA = OK");

	}

	public void shouldReciveMessag2() {
		Component button1 = tester.getComponentFromLastRenderedPage("content:1");

		contentFormTester.submit(button1);
		assertEquals(contentFormTester.getTextComponentValue("pinAndAmount"), "1");
		menuFormTester.submit("A");
		assertEquals(contentFormTester.getTextComponentValue("message"), "Enter customer number\nA = OK");

	}

	public void shouldStoreButtonSubmitt(String number) {
		String buttonNumber;
		buttonNumber = "content:" + number;
		Component button = tester.getComponentFromLastRenderedPage(buttonNumber);
		contentFormTester.submit(button);
		assertEquals(contentFormTester.getTextComponentValue("pinAndAmount"), number);

	}

	@Test
	public void shouldStoreButtonSubmit1() {
		String number = "1";
		shouldStoreButtonSubmitt(number);
	}

	@Test
	public void shouldStoreButtonSubmit2() {
		String number = "2";
		shouldStoreButtonSubmitt(number);
	}

	@Test
	public void shouldStoreButtonSubmit3() {
		String number = "3";
		shouldStoreButtonSubmitt(number);
	}

	@Test
	public void shouldStoreButtonSubmit4() {
		String number = "4";
		shouldStoreButtonSubmitt(number);
	}

	@Test
	public void shouldStoreButtonSubmit5() {
		String number = "5";
		shouldStoreButtonSubmitt(number);
	}

	@Test
	public void shouldStoreButtonSubmit6() {
		String number = "6";
		shouldStoreButtonSubmitt(number);
	}

	@Test
	public void shouldStoreButtonSubmit7() {

		String number = "7";
		shouldStoreButtonSubmitt(number);
	}

	@Test
	public void shouldStoreButtonSubmit8() {

		String number = "8";
		shouldStoreButtonSubmitt(number);
	}

	@Test
	public void shouldStoreButtonSubmit9() {

		String number = "9";
		shouldStoreButtonSubmitt(number);
	}

	@Test
	public void shouldStoreButtonSubmit0() {

		String number = "0";
		shouldStoreButtonSubmitt(number);
	}

	@Test
	public void shouldStoreButtonSubmitComma() {

		String number = ",";
		shouldStoreButtonSubmitt(number);
	}

	@Test
	public void shouldStoreButtonSubmitCE() {

		String number = "CE";
		shouldStoreButtonSubmitt(number);
	}

}
