/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.io.Serializable;


/**
 *
 * @author chris
 */
public class Book implements Serializable {
	private String title;
	private String author;
	private String description;
	private String ISBN;
	
	public Book()
	{}
	
	public Book(String title, String author, String description, String ISBN) throws BookException
	{
		this.title = title;
		this.author = author;
		this.description = description;
		this.ISBN = ISBN;
	
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @return the iSBN
	 */
	public String getISBN() {
		return ISBN;
	}

	/**
	 * @param iSBN the iSBN to set
	 */
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getDescription() {
		return description;
	}
	
	public void printBook()
	{
		System.out.println("Title: "			+ this.getTitle());
		System.out.println("Author: "			+ this.getAuthor());
		System.out.println("ISBN: "				+ this.getISBN());
		System.out.println("Description: "		+ this.getDescription());
	}

	public int getPageCount() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}