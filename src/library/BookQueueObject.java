/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

/**
 *
 * @author chris
 */
class BookQueueObject {
	Book book;
	Person person;

	public BookQueueObject(Person p, Book b)
	{
		this.book = b;
		this.person = p;
	}
}
