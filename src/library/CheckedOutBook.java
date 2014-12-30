/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author chris
 */
public class CheckedOutBook implements Serializable {
	private int libraryNumber;
	private String ISBN;
	Calendar c = new GregorianCalendar();
	private Date checkoutDate;
	private Date dueDate;
	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	
	public CheckedOutBook(){}
	
	public CheckedOutBook(int ln, String i){
		this.libraryNumber = ln;
		this.ISBN = i;
		this.checkoutDate = new Date();
		this.setDueDate();
	}
	
	public int getLibraryNumber()
	{
		return this.libraryNumber;
	}
	
	public String getISBN()
	{
		return this.ISBN;
	}
	
	private void setCheckoutDate()
	{
		this.checkoutDate = new Date();
	}
	
	private void setDueDate()
	{
		c.add(Calendar.DATE, 10);
		this.dueDate = c.getTime();
	}
	
	public String getCheckOutDate()
	{
		return dateFormat.format(this.checkoutDate);
	}
	
	public String getDueDate()
	{
		return dateFormat.format(this.dueDate);
	}
}