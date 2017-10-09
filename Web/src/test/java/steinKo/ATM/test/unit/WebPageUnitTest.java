package steinKo.ATM.test.unit;

import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import steinKo.ATM.Web;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Web.class)
@Ignore
public abstract class WebPageUnitTest {

	protected WicketTester tester;
	protected Logger logger = LoggerFactory.getLogger("WebPageUnitTest");
	@Autowired
	protected WebApplication wicketApplication;

}
