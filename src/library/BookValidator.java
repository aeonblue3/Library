/*
 * Based on the ISBN numbering scheme as outlined at
 * http://en.wikipedia.org/wiki/International_Standard_Book_Number
 */
package library;

/**
 *
 * @author chris
 */
public final class BookValidator {
	private BookValidator()
	{}

	
	/**
	 *
	 * @param ISBN
	 * @return
	 */
	public static boolean isValidBook(String ISBN)
	{
		if (ISBN.length() == 9)
		{
			ISBN = "0".concat(ISBN);
			return BookValidator.isValidISBN10(ISBN);
		} else if (ISBN.length() == 13)
		{
			return BookValidator.isValidISBN13(ISBN);
		}
		return false;
	}

	/**
	 *
	 * @param ISBN
	 * @return
	 */
	public static boolean isValidISBN10(String ISBN) {
		int check = 0;
		if (ISBN.length() != 10)
		{
			return false;
		}
		
		for (int i = 0; i < 10; i++) {
			if ("X".equals(ISBN.substring(i, i + 1))) {
				check += 10*(10 - i);
			} else {
				check += Integer.valueOf(ISBN.substring(i, i + 1)) * (10 - i);
			}
		}
		
		return (check % 11 == 0);
	}

	/**
	 *
	 * @param ISBN
	 * @return
	 */
	public static boolean isValidISBN13(String ISBN) {
		int check = 0;
		
		if (ISBN.length() != 13)
		{
			return false;
		}
		
		for (int i = 0; i < 12; i += 2)
		{
			check += Integer.valueOf(ISBN.substring(i, i + 1));
		}
		for (int i = 1; i < 12; i += 2)
		{
			check += Integer.valueOf(ISBN.substring(i, i + 1)) * 3;
		}
		
		check += Integer.valueOf(ISBN.substring(12));
		
		return (check % 10 == 0);
	}
}
