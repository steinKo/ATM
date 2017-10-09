package steinKo.ATM.test.unit.Domain;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import steinKo.ATM.Category.UnitTest;
import steinKo.ATM.domain.Customer;


@Category(UnitTest.class)
public class CustomerTest {

	@Test
	public void customerShouldBecreated() {
		Long personId;
		personId = 2367987665l;
		Customer customer = new Customer("Martin Luther",personId ,1l,123);
		assertEquals(customer.getName(),"Martin Luther");
		
		assertEquals(customer.getPersonId(),personId );
		 Long customberNuber;
		customberNuber = 1l;	
		assertEquals(customer.getCustomerNumber(),customberNuber);
		assertEquals(123,customer.getPin());
		

		
	}

}
