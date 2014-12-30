/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

/**
 *
 * @author chris
 */
public class PersonException extends Exception {

	/**
	 * Creates a new instance of
	 * <code>PersonException</code> without detail message.
	 */
	public PersonException() {
	}

	/**
	 * Constructs an instance of
	 * <code>PersonException</code> with the specified detail message.
	 *
	 * @param msg the detail message.
	 */
	public PersonException(String msg) {
		super(msg);
	}
}
