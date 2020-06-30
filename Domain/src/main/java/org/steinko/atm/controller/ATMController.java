package org.steinko.atm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.steinko.atm.service.ATM;
import org.steinko.atm.service.ATMService;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/atm")
public class ATMController {
	
	private final static Logger logger = LoggerFactory.getLogger(ATMController.class);
	
	@Autowired
	private ATMService service;
	
	
	//@GetMapping
	//public void connectionAccounts(@RequestParam String cardNumber) {
//		logger.info("connectAccounts");
		 //atmService.display();
//	}

	@PostMapping("/pushButtonA")
	public void pushBottonA(@RequestBody String parameter ) {
		service.buttomAPushed(parameter);
	}
	
	@GetMapping
	public String getMessage() {
		return service.display() ;
		
	}
	
	

}
