/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

/**
 *
 * @author chris
 */
public final class BookLookup implements BookLookupInterface {
	
	/*
	 * API key for googleapis.com
	 * http://googleapis.com/
	 */
	private static String apiKey = "AIzaSyDwHDUn_WRshMvnG2jUT7h7b8Mcr-mbYP4";
	private static String booksUrl = "https://www.googleapis.com/books/v1/volumes";
	private static JSONObject json;

	private BookLookup()
	{}
	
	/**
	 * 
	 * @param ISBN
	 * @throws BookException
	 */
	public static Book getBook(String ISBN) throws BookException
	{
		if (!BookValidator.isValidBook(ISBN))
		{
			throw new BookException();
		}
		
		String query = "isbn:".concat(ISBN);
		try {
			BookLookup.json = BookLookup.getBookObject(query);
		} catch (IOException ex) {
			throw new BookException("BookException: " + ex.getMessage());
		}
				
		JSONArray info = json.getJSONArray("items");
		JSONObject jsonElement = info.getJSONObject(0);
		
		// Information about the book
		JSONObject volInfo = jsonElement.getJSONObject("volumeInfo");
		
		// Authors
		JSONArray authors = volInfo.getJSONArray("authors");

		System.out.println(authors.getString(0));
		//String title, String subtitle, String author, String publisher, String date, String description, String category, String thumbnail, String ISBN
		Book book;
		book = new Book(volInfo.getString("title"), authors.getString(0), volInfo.getString("description"), ISBN);
		return book;
	}
	
	/**
	 *
	 * @param query
	 * @return
	 * @throws IOException
	 */
	public static JSONObject getBookObject(String query) throws IOException
	{
		String jsonText = null;
		try {
			jsonText = BookLookup.httpGet(BookLookup.getUrl(query));
		} catch (MalformedURLException ex) {
			Logger.getLogger(BookLookup.class.getName()).log(Level.SEVERE, null, ex);
		}
		JSONObject j = (JSONObject) JSONSerializer.toJSON(jsonText);
		
		return j;
	}
	
	/**
	 *
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public static String httpGet(URL url) throws IOException
	{
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		if (conn.getResponseCode() != 200) {
			throw new IOException(conn.getResponseMessage());
		}

		// Buffer the result into a string
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();

		conn.disconnect();
		return sb.toString();
	}
	
	/**
	 *
	 * @param query
	 * @return
	 * @throws MalformedURLException
	 */
	public static URL getUrl(String query) throws MalformedURLException
	{
		return new URL(BookLookup.booksUrl + "?key=" + BookLookup.apiKey + "&q=" + URLEncoder.encode(query));
	}
}