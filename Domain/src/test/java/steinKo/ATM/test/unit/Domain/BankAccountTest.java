package steinKo.ATM.test.unit.Domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import steinKo.ATM.Category.UnitTest;
import steinKo.ATM.domain.BankAccount;
@Category(UnitTest.class)
public class BankAccountTest {

	@Test
	public void testgi() {
		BankAccount bankaccount = new BankAccount(0);
		bankaccount.gi(100);
		assertEquals(bankaccount.saldo(),100);
	}
	
	@Test
	public void testta() {
		BankAccount bankaccount = new BankAccount(0);
		bankaccount.gi(100);
		bankaccount.ta(100);
		assertEquals(bankaccount.saldo(),0);
	}

}
