package steinKo.ATM.test.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import steinKo.ATM.Web;
import steinKo.ATM.Category.IntegrationTest;
import steinKo.ATM.presentaion.web.HomePage;

@Category(IntegrationTest.class)
public class WebTest {
	private Web app;
	private final static Logger logger = LoggerFactory.getLogger(WebTest.class);

	@Before
	public void setUp() {
		app = new Web();
	}

	@Test

	public void homePageHasBeenDefined() throws Exception {
		assertEquals(HomePage.class, app.getHomePage());
	}

	@Test
	public void souldContainBean() throws Exception {
		String args[];
		ApplicationContext applicationContext;
		args = new String[1];
		args[0] = "";

		Web.main(args);
		applicationContext = Web.getApplicationContext();
		assertNotNull(applicationContext);
		assertTrue(applicationContext.containsBean("web"));

	}

}
