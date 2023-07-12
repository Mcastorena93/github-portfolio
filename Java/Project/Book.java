
package Project;

import java.util.ArrayList;
import java.util.List;

public class Book extends MyDate {

	private String title;
	private String author;
	private String publisher;
	private MyDate relDate;
	private static boolean available;
	public static String rented;
	private Customer renter;

	// get and set title.
	public String getBook() {
		return title + System.lineSeparator() + author + System.lineSeparator() + publisher + System.lineSeparator()
				+ setRented(available) + System.lineSeparator() + "Currently rented by " + renter.getName();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String sTitle) {
		title = sTitle;
	}

	// get and set last name.
	public String getAuthor() {
		return author;
	}

	// get and set Author.
	public void setAuthor(String Au) {
		author = Au;
	}

	// get and set the Publisher.
	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String pub) {
		publisher = pub;
	}

	// get and set the release Date.
	public MyDate getRelDate() {
		return relDate;
	}

	public void setRelDate(MyDate rd) {
		relDate = rd;
	}

	// get and set renter
	public Customer getRental() {
		return renter;

	}

	// sets person renting
	public void setRenter(Customer re) {
		renter = re;
	}

	// sets if book is available in boolean statment;
	public void setBookRented() {
		available = false;
	}

	public void setBookAvailable() {
		available = true;
	}

	public String getAvailable() {
		if (available) {
			return "YES";
		} else {
			return "NO";
		}

	}

	// set to return whether book is available ot rent
	public String setRented(boolean av) {
		if (available) {
			return rented = "This book is available to rent";
		} else {
			return rented = "This book is not available to rent";
		}

	}

}