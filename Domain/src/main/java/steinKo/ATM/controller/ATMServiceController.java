package steinKo.ATM.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import steinKo.ATM.service.ATMService;
import steinKo.ATM.service.ATMServiceImpl;


@RestController
@RequestMapping("/ATMController")
public class ATMServiceController {
	
	private final static Logger logger = LoggerFactory.getLogger(ATMServiceController.class);
	
	@Autowired
	//private ATMService atmService;
	
	
	
	@GetMapping("display")
	public String display() {
		logger.info("display");
		return null; //atmService.display();
	}

	@PostMapping("pushButtonA")
	public void pushBottonA(@RequestBody String parameter) {
		logger.info("pushButtonA");
		//atmService.buttomAPushed(parameter);
	}
	
	

}
