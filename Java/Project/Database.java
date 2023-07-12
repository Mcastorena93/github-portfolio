package Project;

import java.util.List;

public class Database {
	
	public static void newCusData (String a, String b, String c, String d, List<Customer> e) {
		Customer a1 = new Customer();
		a1.setFirstName(a);
		a1.setLastName(b);
		a1.setAddress(c);
		a1.setPhoneNumber(d);
		
		MyDate aD = new MyDate();
		a1.setRegDate(aD);
		
		e.add(a1);
	}
	
	public static void newBookData (String a, String b, String c, List<Book> e) {
		Book b1 = new Book();
		b1.setTitle(a);
		b1.setAuthor(b);
		b1.setPublisher(c);
		b1.setBookAvailable();
		
		MyDate bD = new MyDate();
		b1.setRelDate(bD);
		e.add(b1);
	}
		
	
	public static void addBooks(String a, String b, String c, String d, String e, String f, String g, String h) {
		String[] books = {b,c,d,e,f,g,h};
		Customer test;
		Book rBook;
		for (Customer customer : FinalProject.getCustList()) {
			//find customer.
			if (customer.getPhoneNumber().equals(a)) {
				test = customer;
			
		
				//find book.
				for(int i = 0; i <= books.length -1 ; i++) {
					for (Book book : FinalProject.getBookList()) {
						if (book.getTitle().equals(books[i])) {
							rBook = book;
							//set book in customer rent list, set book to unavailable, set customer name in book renter. 
							test.setRental(rBook);
							rBook.setRenter(test);
							rBook.setBookRented();
							
								}
							
							}
						}	
					}	
			
				}
		}
	public static void loadData(List<Customer> a, List<Book> b) { 	
		
	//customers
	newCusData(
			"Charles","Xavier",
			"1407 Graymalkin Lane, Salem Center",
			"9145551407",
			a);
			
	
	newCusData(
			"Max","Eisenhardt",
			"1407 Graymalkin Lane, Salem Center",
			"9145551507",
			a);
	
	//Books

	newBookData(
			"The Art of War",
			"Sun Tzu",
			"Ancient History", 
			b);
	
	newBookData(
			"The Art of Peace",
			"Moihei Ueshiba",
			"Ancient History",
			b);
	
	newBookData(
			"To Kill a Mocking Bird",
			"Harper Lee",
			"J. B. Lippincott & Co",
			b);
	
	newBookData(
			"1984",
			"George Orwell",
			"Secker and Warburg",
			b);
	
	newBookData(
			"Lord of the Rings",
			"J.R.R. Tolkein",
			"Allen and Unwin",
			b);
	
	newBookData(
			"The Catcher in the Rye",
			"J.D Salinger",
			"Little, Brown",
			b);
	
	newBookData(
			"The Great Gatsby",
			"F.Scott Fitzgerald",
			"Charles Scribner's Sons",
			b);
	
	newBookData(
			"Lord of the Flies",
			"William Golding",
			"Faber and Faber",
			b);
	
	newBookData(
			"Animal Farm",
			"George Orwell",
			"Secker and Warburg",
			b);
	
	newBookData(
			"Catch-22",
			"Joseph Heller",
			"Simon and Schuster",
			b);
	
	addBooks(
			"9145551407",
			"The Art of War",
			"The Art of Peace",
			"To Kill a Mocking Bird",
			"1984",
			"Lord of the Rings",
			"The Catcher in the Rye",
			"The Great Gatsby"
			);
			
	}
}
