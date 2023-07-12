package Project;

import java.util.ArrayList;
import java.util.List;

public class Customer extends MyDate {

	private String firstName;
	private String lastName;
	private String address;
	private String phoneNumber;
	private MyDate regDate;
	private List<Book> rentals = new ArrayList<Book>();

	public String getCustomer() {
		return firstName + " " + lastName + System.lineSeparator() + address + System.lineSeparator() + phoneNumber
				+ System.lineSeparator() + System.lineSeparator() + "books rented : " + showList()
				+ System.lineSeparator();

	}

	public String showList() {
		String element = "";
		for (Book book : rentals) {
			element += book.getTitle() + ", ";

		}
		return element;
	}

	// get and set first name.
	public String getFirstName() {
		return firstName;
	}

	public String getName() {
		return firstName + " " + lastName;
	}

	public void setFirstName(String fn) {
		firstName = fn;
	}

	// get and set last name.
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String ln) {
		lastName = ln;
	}

	// get and set the persons address.
	public String getAddress() {
		return address;
	}

	public void setAddress(String ad) {
		address = ad;
	}

	// get and set the persons phone number.
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String ph) {
		phoneNumber = ph;
	}

	public MyDate getRegDate() {
		return regDate;
	}

	public void setRegDate(MyDate md) {
		regDate = md;
	}

	// get and set book
	public List<Book> getRental() {
		return rentals;
	}

	public void setRental(Object b) {
		rentals.add((Book) b);
	}

}
