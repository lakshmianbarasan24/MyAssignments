package week2.day3;

public class Library {

	//Method to add book of given title
	public String addBook(String bookTitle)
	{
		System.out.println("Book added successfully");
		return bookTitle;
	}
	
	//Method to issue the book
	public void issueBook()
	{
		System.out.println("Book issued successfully");
	}
	
	
	public static void main(String[] args) {
		// Create library object
		Library libObj = new Library();

		// Add and issue book
		libObj.addBook("Harry Potter");
		libObj.issueBook();
	}

}
