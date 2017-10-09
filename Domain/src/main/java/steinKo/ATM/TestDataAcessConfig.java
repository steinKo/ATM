package steinKo.ATM;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration 
@EnableJpaRepositories("steinKo.ATM.repository")
public class TestDataAcessConfig {

}
