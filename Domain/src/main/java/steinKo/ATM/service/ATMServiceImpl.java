package steinKo.ATM.service;





import java.util.List;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import steinKo.ATM.domain.ATM;
import steinKo.ATM.domain.Bank;
import steinKo.ATM.repository.BankRepository;






@Service
@Transactional

public class ATMServiceImpl implements ATMService {
	
	
	private ATM atm = null;
	private BankRepository bankRepository;
	
	

	private final static Logger logger = LoggerFactory.getLogger(ATMServiceImpl.class);
	
	
	
	@Autowired
	  public ATMServiceImpl( BankRepository anBankRepository) 
	  {
		 
	     logger.info("Start ATM Service impl");
	     bankRepository = anBankRepository;
	     logger.info( bankRepository.toString());
		 logger.info("end ATM Service impl");
	  }
	
	  
	
	private void init() 
	  {
		  List<Bank> banks=  bankRepository.findAll();
		  Bank bank;
		  if (!banks.isEmpty())
		  {
	          bank = banks.get(0);
		      atm = new ATM(bank);
		      logger.info("Bank found");
		  } else
			try {
				throw new Exception("No bank found ");
			} catch (Exception e) {
	
				e.printStackTrace();
			}
		
	  }
	

	@Override
	public String display()  {
		String display;
		
		   if (atm == null)
			 init();
		   display = atm.display();
		 
		  return display;
		
	}
	
	
	@Override
	public void buttomAPushed(String text) {
		
		  if (atm == null)
			init();
		  atm.buttomAPushed(text);
		
		
	}

	@Override
	public void buttomBPushed(String text) {
		if (atm == null)
			init();
		atm.buttomBPushed(text);
		
	}

	@Override
	public void buttomCPushed(String text) {
		
		atm.buttomCPushed(text);
		
	}



	@Override
	public void withdraw(Integer amount) {
		atm.withdraw(amount);
		
	}



	@Override
	public Integer getBalance() {
		return atm.getBalance();
		
	}



	@Override
	public boolean isCheckingAccount() {
		return atm.isCheckingAccount();
		
	}



	@Override
	public void deposit(int paKonto) {
		atm.deposit(paKonto);
		
	}


}
