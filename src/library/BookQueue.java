/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.util.LinkedList;
/**
 *
 * @author chris
 */
public class BookQueue {
	LinkedList queue;
	
	public BookQueue(){
		queue = new LinkedList();
	}
	
	public void enqueue(BookQueueObject o)
	{
		queue.add(o);
	}
	
	public BookQueueObject dequeue()
	{
		return (BookQueueObject) queue.removeFirst();
	}
	
	public int count()
	{
		return queue.size();
	}
	
	public BookQueueObject peek()
	{
		return (BookQueueObject) queue.peekFirst();
	}
	
	public void removeAll()
	{
		queue.removeAll(queue);
	}
}
