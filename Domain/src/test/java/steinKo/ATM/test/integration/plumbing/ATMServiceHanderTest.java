package steinKo.ATM.test.integration.plumbing;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;
import steinKo.ATM.plumbing.ATMServiceHander;
import steinKo.ATM.test.integration.AbstractIntegrationTest;

class ATMServiceHanderTest extends AbstractIntegrationTest{

	@Test
	void test() {
		ATMServiceHander atmServiceHandler;
		atmServiceHandler = new ATMServiceHander();
		ServerRequest request = null;
		Mono<ServerResponse> respons = atmServiceHandler.display(request);
		assertNotNull(respons.hasElement());
		
	}

}
