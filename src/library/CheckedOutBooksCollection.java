/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author chris
 */
public class CheckedOutBooksCollection implements Serializable {
	private LinkedList checkedOut;
	
	public CheckedOutBooksCollection()
	{
		checkedOut = new LinkedList();
	}
	
	public int count()
	{
		return this.checkedOut.size();
	}
	
	public void checkout(int libraryNumber, String ISBN) throws BookException
	{
		if (this.isCheckedOut(ISBN))
		{
			throw new BookException("This book is already checked out!");
		}
		
		this.checkedOut.add(new CheckedOutBook(libraryNumber, ISBN));
	}
	
	public boolean isCheckedOut(String ISBN)
	{
		ListIterator itr = this.checkedOut.listIterator();
		while (itr.hasNext())
		{
			CheckedOutBook temp = (CheckedOutBook) itr.next();
			if (temp.getISBN().compareTo(ISBN) == 0)
			{
				return true;
			}
		}
		return false;
	}
	
	public void checkIn(String ISBN) throws BookException
	{
		ListIterator itr = this.checkedOut.listIterator();
		while (itr.hasNext())
		{
			CheckedOutBook temp = (CheckedOutBook) itr.next();
			if (temp.getISBN().compareTo(ISBN) == 0)
			{
				this.checkedOut.remove(temp);
			}
		}
		
		throw new BookException("Book not checked out!");
	}
	
	public LinkedList getAll()
	{
		return this.checkedOut;
	}
	
	public CheckedOutBook peek()
	{
		return (CheckedOutBook) this.checkedOut.peek();
	}
	
	public void getBooksByLibraryNumber(int i) throws BookException
	{
		int found = 0;
		ListIterator itr = this.checkedOut.listIterator();
		while(itr.hasNext())
		{
			CheckedOutBook temp = (CheckedOutBook) itr.next();
			if(i == temp.getLibraryNumber())
			{
				System.out.println(BookLookup.getBook(temp.getISBN()).getTitle());
				found++;
			}
		}
		if (found == 0)
		{
			System.out.println("You hav no books checked out!");
		}
	}
}
