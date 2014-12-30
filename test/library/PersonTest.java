/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author chris
 */
public class PersonTest {
	
	public PersonTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}

	/**
	 * Test of isName method, of class Person.
	 */
	@Test
	public void testIsNameIsTrue() {
		String i = "Bill";
		Person instance = new Person();
		boolean expResult = true;
		boolean result = instance.isName(i);
		assertEquals(expResult, result);
	}
	
	@Test
	public void testIsNameIsFalse() {
		String i = "Bill9";
		Person instance = new Person();
		boolean expResult = false;
		boolean result = instance.isName(i);
		assertEquals(expResult, result);
	}
	
	@Test
	public void testNameHasSpace() {
		String i = "Bill Dufris";
		Person instance = new Person();
		boolean expResult = true;
		boolean result = instance.isName(i);
		assertEquals(expResult, result);
	}
	
	@Test
	public void testEmail()
	{
		String e = "chris@neitzer.com";
		Person instance = new Person();
		boolean expResult = true;
		boolean result = instance.isEmail(e);
		assertEquals(expResult, result);
	}
}
