/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

/**
 *
 * @author chris
 */
public class BookCollectionException extends Exception {

	/**
	 * Creates a new instance of
	 * <code>BookCollectionException</code> without detail message.
	 */
	public BookCollectionException() {
	}

	/**
	 * Constructs an instance of
	 * <code>BookCollectionException</code> with the specified detail message.
	 *
	 * @param msg the detail message.
	 */
	public BookCollectionException(String msg) {
		super(msg);
	}
}
