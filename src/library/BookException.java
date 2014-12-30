/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

/**
 *
 * @author chris
 */
public class BookException extends Exception {

	/**
	 * Creates a new instance of
	 * <code>BookException</code> without detail message.
	 */
	public BookException() {
	}

	/**
	 * Constructs an instance of
	 * <code>BookException</code> with the specified detail message.
	 *
	 * @param msg the detail message.
	 */
	public BookException(String msg) {
		super(msg);
	}
}
