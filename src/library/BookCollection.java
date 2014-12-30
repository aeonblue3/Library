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
public class BookCollection implements Serializable {
	private LinkedList bookCollection;
	
	public BookCollection()
	{
		this.bookCollection = new LinkedList();
	}
	
	public void addBook(Book b)
	{
		this.bookCollection.add(b);
	}
	
	public Book findBookByTitle(String title) throws BookCollectionException
	{
		ListIterator itr = this.bookCollection.listIterator();
		while (itr.hasNext())
		{
			Book temp = (Book) itr.next();
			if (temp.getTitle().compareToIgnoreCase(title) == 0) {
				return temp;
			}
		}
		throw new BookCollectionException("Sorry, we couldn't find that individual.");
	}
	
	public Book findBookByISBN(String ISBN) throws BookCollectionException
	{
		ListIterator itr = this.bookCollection.listIterator();
		while (itr.hasNext())
		{
			Book temp = (Book) itr.next();
			if (temp.getISBN().compareToIgnoreCase(ISBN) == 0) {
				return temp;
			}
		}
		throw new BookCollectionException("Sorry, we couldn't find that individual.");
	}
	
	public Book findByIndex(int i)
	{
		return (Book) this.bookCollection.get(i);
	}
	
	public void removeBook(String title) throws BookCollectionException
	{
		this.bookCollection.remove(this.findBookByTitle(title));
	}
	
	public int count()
	{
		return this.bookCollection.size();
	}
	
	public void listAllBooks()
	{
		int i = 0;
		ListIterator itr = this.bookCollection.listIterator();
		while (itr.hasNext())
		{
			Book temp = (Book) itr.next();
			System.out.println(i+") ");
			System.out.println("Title: " + temp.getTitle());
			System.out.println("Author: " + temp.getAuthor());
			System.out.println("Description: " + temp.getDescription());
			System.out.println();
			i++;
			
		}
	}
}
