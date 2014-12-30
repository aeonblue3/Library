/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author chris
 */
public class BookTest {
	Book instance;
	public BookTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}
	
	@Before
	public void initialize()
	{
		try {
			instance = BookLookup.getBook("9780596158101");
		} catch (BookException ex) {
			Logger.getLogger(BookTest.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	@Test
	public void testIsBook() {
		System.out.println("Is Book");
		assertTrue(instance instanceof Book);
	}

	/**
	 * Test of getTitle method, of class Book.
	 */
	@Test
	public void testGetTitle() {
		System.out.println("getTitle");
		String expResult = "";
		String result = instance.getTitle();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getAuthor method, of class Book.
	 */
	@Test
	public void testGetAuthor() {
		System.out.println("getAuthor");
		Book instance = new Book();
		String expResult = "";
		String result = instance.getAuthor();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getPageCount method, of class Book.
	 */
	@Test
	public void testGetPageCount() {
		System.out.println("getPageCount");
		Book instance = new Book();
		int expResult = 0;
		int result = instance.getPageCount();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}


	/**
	 * Test of getPublishedDate method, of class Book.
	 */
	@Test
	public void testGetPublishedDate() {
		System.out.println("getPublishedDate");
		Book instance = new Book();
		Date expResult = null;
		Date result = instance.getPublishedDate();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}


	/**
	 * Test of getISBN method, of class Book.
	 */
	@Test
	public void testGetISBN() {
		System.out.println("getISBN");
		Book instance = new Book();
		String expResult = "";
		String result = instance.getISBN();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setISBN method, of class Book.
	 */
	@Test
	public void testSetISBN() {
		System.out.println("setISBN");
		String iSBN = "";
		Book instance = new Book();
		instance.setISBN(iSBN);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
}
