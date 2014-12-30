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
public class BookValidatorTest {
	
	public BookValidatorTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}

	/**
	 * Test of isValidBook method, of class BookLookup.
	 */
	@Test
	public void testIsValidBook()
	{
		String ISBN = "9780596159818";
		
		assertEquals(true, BookValidator.isValidBook(ISBN));
	}
	
	/**
	 * Test of isValidISBN10 method, of class BookLookup.
	 */
	@Test
	public void testIsValidISBN10()
	{
		String ISBN = "0723205868";

		assertEquals(true, BookValidator.isValidISBN10(ISBN));
	}

	/**
	 * Test of isValidISBN13 method, of class BookLookup.
	 */
	@Test
	public void testIsValidISBN13()
	{
		String ISBN = "9780596158101";

		assertEquals(true, BookValidator.isValidISBN13(ISBN));
	}
	
	@Test
	public void test9DigitISBNIsValid()
	{
		String ISBN = "723205868";

		assertEquals(true, BookValidator.isValidBook(ISBN));
	}
}
