/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author chris
 */
public final class Serializer {
	public Serializer(){}
	public static void serializeIt(Object o, String filename) throws Exception
	{
		try {
			FileOutputStream fout = new FileOutputStream(filename);
			ObjectOutputStream oos = new ObjectOutputStream(fout);   
			oos.writeObject(o);
			oos.close();
		} catch(Exception ex) {
			throw new Exception("We could not do that!");
		}
	}
	public static BookCollection deserialzeBook(String filename)
	{

		BookCollection b;

		try {

			FileInputStream fin = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(fin);
			b = (BookCollection) ois.readObject();
			ois.close();

			return b;

		}	catch(Exception ex) {
			ex.printStackTrace();
			return null;
		} 
	}
	public static PersonCollection deserialzePerson(String filename)
	{

		PersonCollection p;

		try {

			FileInputStream fin = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(fin);
			p = (PersonCollection) ois.readObject();
			ois.close();

			return p;

		}	catch(Exception ex) {
			ex.printStackTrace();
			return null;
		} 
	}
	
	public static CheckedOutBooksCollection deserialzeInventory(String filename)
	{

		CheckedOutBooksCollection c;

		try {

			FileInputStream fin = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(fin);
			c = (CheckedOutBooksCollection) ois.readObject();
			ois.close();

			return c;

		}	catch(Exception ex) {
			ex.printStackTrace();
			return null;
		} 
	}
}
