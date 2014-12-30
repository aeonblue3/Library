/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author chris
 */
public class Person implements Serializable {
	private String firstname	= null;
	private String lastname		= null;
	private String email		= null;
	private LinkedList books	= new LinkedList();
	
	private int libraryNumber;
	
	public Person(){}
	
	public Person(String f, String l, String e) throws PersonException
	{
		if (this.isName(f)) {
			this.firstname = f;
		} else {
			throw new PersonException("PersonException: Your name has some illegal characters!");
		}
		
		if (this.isName(l)) {
			this.lastname = l;
		} else {
			throw new PersonException("PersonException: Your name has some illegal characters!");
		}
		
		if (this.isEmail(e)) {
			this.email = e;
		} else {
			throw new PersonException("PersonException: Invalid email address!");
		}
		
		double tempId = Math.random() * 10000;
		this.libraryNumber = (int) tempId;
	}
	
	private boolean isName(String i)
	{
		return i.matches("[a-zA-Z\\s\\.-]+");
	}
	
	private boolean isEmail(String e)
	{
		return e.matches("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
	}
	
	public String getFirstname()
	{
		return this.firstname;
	}
	
	public String getLastname()
	{
		return this.lastname;
	}
	
	public String getFullname()
	{
		return this.firstname + " " + this.lastname;
	}
	
	public String getEmail()
	{
		return this.email;		
	}
	
	public int getId()
	{
		return this.libraryNumber;
	}
	
	public void printPerson()
	{
		System.out.println("Name: " + this.getFullname() + "\nEmail: " + this.getEmail());
	}
}