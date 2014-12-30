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
public class PersonCollection implements Serializable {
	private LinkedList personCollection;
	
	public PersonCollection()
	{
		personCollection = new LinkedList();
	}
	
	public void addPerson(Person p)
	{
		this.personCollection.add(p);
	}
	
	public Person findPerson(String name) throws PersonCollectionException
	{
		ListIterator itr = this.personCollection.listIterator();
		while (itr.hasNext())
		{
			Person temp = (Person) itr.next();
			if (temp.getFirstname().compareToIgnoreCase(name) == 0 || temp.getLastname().compareToIgnoreCase(name) == 0 || temp.getFullname().compareToIgnoreCase(name) == 0) {
				return temp;
			}
		}
		throw new PersonCollectionException("Sorry, we couldn't find that individual.");
	}
	
	public Person findByIndex(int i)
	{
		return (Person) this.personCollection.get(i);
	}
	
	public Person findById(String i) throws PersonCollectionException
	{
		int id = Integer.parseInt(i);
		ListIterator itr = this.personCollection.listIterator();
		while (itr.hasNext())
		{
			Person temp = (Person) itr.next();
			if (temp.getId() == id) {
				return temp;
			}
		}
		throw new PersonCollectionException("Sorry, we couldn't find that individual.");
	}
	
	public Person findById(int id) throws PersonCollectionException
	{
		ListIterator itr = this.personCollection.listIterator();
		while (itr.hasNext())
		{
			Person temp = (Person) itr.next();
			if (temp.getId() == id) {
				return temp;
			}
		}
		throw new PersonCollectionException("Sorry, we couldn't find that individual.");
	}
	
	public void removePerson(String name) throws PersonCollectionException
	{
		this.personCollection.remove(this.findPerson(name));
	}
	
	public void listAllPeople()
	{
		ListIterator itr = this.personCollection.listIterator();
		while (itr.hasNext())
		{
			Person temp = (Person) itr.next();
			System.out.println("Name: " + temp.getFullname());
			System.out.println("Email: " + temp.getEmail());
			System.out.println("ID: " + temp.getId() + "\n");
		}
	}
}
