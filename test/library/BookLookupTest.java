/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author chris
 */
public class BookLookupTest {
	
	public BookLookupTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}
	
	@Test
	public void testGetBook() throws BookException
	{
		Book i = BookLookup.getBook("9780596158101");
		//System.out.println(i.getAuthor());
		assertTrue(i instanceof Book);
	}

	@Test
	public void testGetUrl() throws MalformedURLException
	{
		String query = "Book Title";
		
		URL url = new URL("https://www.googleapis.com/books/v1/volumes?key=AIzaSyDwHDUn_WRshMvnG2jUT7h7b8Mcr-mbYP4&q=Book+Title");
		
		assertEquals(url, BookLookup.getUrl(query));
	}
}
