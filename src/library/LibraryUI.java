/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;



/**
 *
 * @author chris
 */
public class LibraryUI {
	Scanner sc = new Scanner(System.in);
	String errorMsg = null;
	String input = null;
	
	BookCollection books = new BookCollection();
	PersonCollection people = new PersonCollection();
	CheckedOutBooksCollection checkedOut = new CheckedOutBooksCollection();
	
	private String bookfile = "books.dat";
	private String peoplefile = "people.dat";
	private String inventoryfile = "inventory.dat";

	public void LibraryUI(){

	}

	public void mainMenu()
	{
		// Init the files
		this.books = Serializer.deserialzeBook(this.bookfile);
		this.people = Serializer.deserialzePerson(this.peoplefile);
		this.checkedOut = Serializer.deserialzeInventory(this.inventoryfile);
		//5479
		Calendar c = new GregorianCalendar();
		c.add(Calendar.DATE, 30);
		Date d = c.getTime();

		do {
			System.out.println("=== Welcome to the Library ===");
			if(errorMsg != null) {System.out.println(errorMsg); this.errorMsg = null;}
			System.out.println("\tPlease make a selection:");
			System.out.println("\t1) Books menu");
			System.out.println("\t2) People menu");
			System.out.println("\t3) Inventory");
			System.out.println("\tx) Exit the program");
			this.input = sc.nextLine();

			switch(input.toCharArray()[0])
			{
				case '1':
					this.bookMenu();
					break;
				case '2':
					this.personMenu();
					break;
				case '3':
					this.inventoryMenu();
					break;
				case 'x':
					System.exit(0);
					break;
				default:
					this.errorMsg = "You made an illegal choice! Try again!";
			}
		} while(true);
	}

	public void bookMenu() {
		int exitFlag = 1;
		do
		{
			System.out.println("=== Welcome to the Library: Books ===");
			if(errorMsg != null) {System.out.println(errorMsg); this.errorMsg = null;}
			System.out.println("\tPlease make a selection:");
			System.out.println("\t1) Add Book");
			System.out.println("\t2) Find Book");
			System.out.println("\t3) List All Books");
			System.out.println("\t4) Checkout Book");
			System.out.println("\t5) << Back");
			input = sc.nextLine();
			
			switch(input.toCharArray()[0])
			{
				case '1':
					this.addBookMenu();
					break;
				case '2':
					this.FindBooksMenu();
					break;
				case '3':
					this.listAllBooks();
					break;
				case '4':
					this.bookCheckoutMenu();
					break;
				case '5':
					exitFlag = 0;
					break;
				default:
					this.errorMsg = "You made an illegal choice! Try again!";
			}
		} while(exitFlag == 1);
	}
	
	public void personMenu() {
		int exitFlag = 1;
		do
		{
			System.out.println("=== Welcome to the Library: Card Carrying Members ===");
			if(errorMsg != null) {System.out.println(errorMsg); this.errorMsg = null;}
			System.out.println("\tPlease make a selection:");
			System.out.println("\t1) Add Person");
			System.out.println("\t2) Find Person");
			System.out.println("\t3) Delete Person");
			System.out.println("\t4) << Back");
			input = sc.nextLine();
			
			switch(input.toCharArray()[0])
			{
				case '1':
					this.createPerson();
					break;
				case '2':
					this.listPeopleMenu();
					break;
				case '4':
					exitFlag = 0;
					break;
				default:
					this.errorMsg = "You made an illegal choice! Try again!";
			}
		} while(exitFlag == 1);
	}
	
	

	public static void main(String[] args)
	{
		LibraryUI lib = new LibraryUI();
		lib.mainMenu();
	}

	public void addBookMenu() {
		int exitFlag = 1;
		do
		{
			System.out.println("=== Welcome to the Library: Add a Book ===");
			if(errorMsg != null) {System.out.println(errorMsg); this.errorMsg = null;}
			System.out.println("\tPlease enter an ISBN number or type 'back':\n");
			input = sc.nextLine();
			
			if (input.compareTo("back") == 0) {
				exitFlag = 0;
			} else {
				try {
					Book b = BookLookup.getBook(input);
					books.addBook(b);
					try {
						this.save(books);
					} catch (Exception ex) {
						errorMsg = ex.getMessage();
					}
					b.printBook();
					exitFlag = 0;
				} catch (BookException ex) {
					errorMsg = ex.getMessage();
				}
			}
		} while(exitFlag == 1);
	}

	private void createPerson() {
		int exitFlag = 1;
		do
		{
			System.out.println("=== Welcome to the Library: Add a Human ===");
			if(errorMsg != null) {System.out.println(errorMsg); this.errorMsg = null;}
			System.out.println("Enter First Name:");
			String fname = sc.nextLine();
			System.out.println("Enter Last Name:");
			String lname = sc.nextLine();
			System.out.println("Enter Email Address:");
			String email = sc.nextLine();

			try {
				Person p = new Person(fname, lname, email);
				exitFlag = 0;
				people.addPerson(p);
				p.printPerson();
				try {
					this.save(people);
				} catch (Exception ex) {
					errorMsg = ex.getMessage();
				}
			} catch (PersonException ex) {
				this.errorMsg = ex.getMessage();
			}
		} while(exitFlag == 1);
	}
	
	private void save(BookCollection b) throws Exception
	{
		String bookStorage = "books.dat";
		Serializer.serializeIt(b, bookStorage);
	}
	
	private void save(PersonCollection p) throws Exception
	{
		String peopleStorage = "people.dat";
		Serializer.serializeIt(p, peopleStorage);
	}
		
	private void save(CheckedOutBooksCollection i) throws Exception
	{
		String inventoryStorage = "inventory.dat";
		Serializer.serializeIt(i, inventoryStorage);
	}

	private void FindBooksMenu() {
		int exitFlag = 1;
		do
		{
			System.out.println("=== Welcome to the Library: Find A Book ===");
			if(errorMsg != null) {System.out.println(errorMsg); this.errorMsg = null;}
			System.out.println("\tPlease make a selection:");
			System.out.println("\t1) Find by title");
			System.out.println("\t2) << Back");
			input = sc.nextLine();
			
			switch(input.toCharArray()[0])
			{
				case '1':
					this.findByTitleMenu();
					break;
				case '2':
					exitFlag = 0;
					break;
				default:
					this.errorMsg = "You made an illegal choice! Try again!";
			}
		} while(exitFlag == 1);
	}

	private void findByTitleMenu() {
		int exitFlag = 1;
		do
		{
			System.out.println("=== Welcome to the Library: Find A Book By Title ===");
			if(errorMsg != null) {System.out.println(errorMsg); this.errorMsg = null;}
			System.out.println("\tEnter the name of the book or type back:");
			input = sc.nextLine();
			
			if (input.compareTo("back") == 0) {
				exitFlag = 0;
			} else {
				try {
					this.books.findBookByTitle(input).printBook();
				} catch (BookCollectionException ex) {
					errorMsg = ex.getMessage();
				}
			}
		} while(exitFlag == 1);
	}

	private void listAllBooks() {
		this.books.listAllBooks();
	}

	private void inventoryMenu() {
		int exitFlag = 1;
		do {
			System.out.println("=== Welcome to the Library: Inventory Manager ===");
			if(errorMsg != null) {System.out.println(errorMsg); this.errorMsg = null;}
			System.out.println("\tPlease make a selection:");
			System.out.println("\t1) List All Checked Out Books");
			System.out.println("\t2) Check In a Book");
			System.out.println("\t3) << Back");
			this.input = sc.nextLine();

			switch(input.toCharArray()[0])
			{
				case '1':
					this.listAllCheckedOutBooks();
					break;
				case '2':
					this.checkIn();
					break;
				case '3':
					exitFlag = 0;
					break;
				default:
					this.errorMsg = "You made an illegal choice! Try again!";
			}
		} while(exitFlag == 1);
	}

	private void bookCheckoutMenu() {
		int exitFlag = 1;
		Book tempBook;
		Person tempPerson;
		do
		{
			System.out.println("=== Welcome to the Library: Checkout a Book ===");
			if(errorMsg != null) {System.out.println(errorMsg); this.errorMsg = null;}
			System.out.println("\tEnter the name of the book or type 'listall' to get a complete list of books:");
			System.out.println("\tType 'back' to exit this menu.");
			input = sc.nextLine();
			
			if (input.compareTo("back") == 0) {
				exitFlag = 0;
			} else if(input.compareTo("listall") == 0) {
				this.books.listAllBooks();
			} else {
				try {
					tempBook = this.books.findBookByTitle(input);
					System.out.println("Enter your 4 digit Library Number.");
					input = sc.nextLine();
					try {
						tempPerson = this.people.findById(input);
						try {
							checkedOut.checkout(tempPerson.getId(), tempBook.getISBN());
							try {
								this.save(checkedOut);
							} catch (Exception ex) {
								errorMsg = ex.getMessage();
							}
							System.out.println(tempPerson.getFullname() + " has checked out " + tempBook.getTitle() + " and is due back " + checkedOut.peek().getDueDate());
							exitFlag = 0;
						} catch (BookException ex) {
							errorMsg = ex.getMessage();
						}
					} catch (PersonCollectionException ex) {
						errorMsg = ex.getMessage();
					}
				} catch (BookCollectionException ex) {
					errorMsg = ex.getMessage();
				}
				
			}
		} while(exitFlag == 1);
	}

	private void checkIn() {
		int exitFlag = 1;
		Book temp;
		do {
			System.out.println("=== Welcome to the Library: Check In ===");
			if(errorMsg != null) {System.out.println(errorMsg); this.errorMsg = null;}
			System.out.println("\tEnter your library number:");
			this.input = sc.nextLine();
			try {
				checkedOut.getBooksByLibraryNumber(Integer.parseInt(input));
				System.out.println("Enter the title of the book to check in:");
				this.input = sc.nextLine();
				try {
					temp = books.findBookByTitle(input);
					checkedOut.checkIn(temp.getISBN());
					try {
						this.save(checkedOut);
					} catch (Exception ex) {
						errorMsg = ex.getMessage();
					}
					System.out.println(temp.getTitle() + " checked in!");
					exitFlag = 0;
				} catch (BookCollectionException ex) {
					errorMsg = ex.getMessage();
				}
			} catch (BookException ex) {
				errorMsg = ex.getMessage();
			}
		} while(exitFlag == 1);
	}

	private void listAllCheckedOutBooks() {
		LinkedList co = checkedOut.getAll();
		ListIterator itr = co.listIterator();
		while(itr.hasNext())
		{
			CheckedOutBook temp = (CheckedOutBook) itr.next();
			try {
				try {
					System.out.println(books.findBookByISBN(temp.getISBN()).getTitle() + " checked out to " + people.findById(temp.getLibraryNumber()).getFullname() + " and is due back " + temp.getDueDate() + ".");
				} catch (PersonCollectionException ex) {
					errorMsg = ex.getMessage();
				}
			} catch (BookCollectionException ex) {
				errorMsg = ex.getMessage();
			}
		}
		System.out.println();
	}

	private void listPeopleMenu() {
		this.people.listAllPeople();
	}
}