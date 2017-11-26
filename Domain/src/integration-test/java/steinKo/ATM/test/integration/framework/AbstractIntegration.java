package steinKo.ATM.test.integration;


import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import steinKo.ATM.DomainConfig;


@ContextConfiguration(classes=DomainConfig.class)
@RunWith(SpringRunner.class)

@DataJpaTest

public abstract class AbstractTest {

}
