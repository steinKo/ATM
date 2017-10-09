package steinKo.ATM;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.context.annotation.Configuration;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@EnableAutoConfiguration 
@EnableJpaRepositories("steinKo.ATM.repository")
public class IntegrationTestConfig {

}
