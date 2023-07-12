package Project;

import java.lang.reflect.Array;

/****************************************
* Student Name: Mauricio Castorena-Alonso
* Date Due: May 03, 2022
* Date Submitted: May 3, 2022
* Program Name: Book Reservation System
* Program Description:
****************************************/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FinalProject {
	// book inventory
	public static List<Book> bookList = new ArrayList<Book>();

	// customers
	private static List<Customer> custList = new ArrayList<Customer>();

	public static void main(String[] arg) {
		boolean quit = false;
		Database.loadData(custList, bookList);

		String[] activity = new String[8];
		// List of options for activities created with an array.
		activity[0] = "Rent a book";
		activity[1] = "Look up customer";
		activity[2] = "Look up book";
		activity[3] = "Add a customer";
		activity[4] = "Add a book";
		activity[5] = "Report Book inventory";
		activity[6] = "Report Customer Data";

		// Greetings, ask for task.
		while (!quit) {
			System.out.println("Hello, what would you like to do?" + System.lineSeparator()
					+ "Choose a number from the options below" + System.lineSeparator() + System.lineSeparator()
					+ "1 - Rent a book" + System.lineSeparator() + "2 - Look up customer" + System.lineSeparator()
					+ "3 - Look up book" + System.lineSeparator() + "4 - Add a customer" + System.lineSeparator()
					+ "5 - Delete a customer" + System.lineSeparator() + "6 - Add a book" + System.lineSeparator()
					+ "7 - Report Book Inventory" + System.lineSeparator() + "8 - Report Customer Data"
					+ System.lineSeparator());

			System.out.println();

			Scanner actInput = new Scanner(System.in);
			// set field for the scanner input and set index.
			int index = (actInput.nextInt() - 1);
			System.out.println(" ");

			// switch statement for the activities.
			Scanner quitting = new Scanner(System.in);
			Scanner input4 = new Scanner(System.in);
			switch (index) {

			case 0:// Rent a book
				System.out.println("What is the books title?");
				String boTitle = input4.nextLine();
				// search if the book exists.
				if (searchBookList(boTitle)) {
					// Look up a customer
					System.out.println("What is the customers phone number?");
					String phoneN = input4.nextLine();
					if (searchCustList(phoneN)) {
						// if customer exists, rent book.
						rental(phoneN, boTitle);
					} else {
						// if the customer does not exist, request to add them.
						System.out.println("the customer does not exist, would you like to add them? Y?N");
						String reply = input4.nextLine();
						if (reply.equalsIgnoreCase("Y")) {
							// if the customer would like to be added, create a new customer.
							newCustomer();
						}
					}
				} else {
					System.out.println("Sorry, that book does not exist.");

				}
				System.out.println();
				System.out.println("Would you like to quit? Y/N");
				String answer5 = quitting.nextLine();
				if (answer5.equalsIgnoreCase("Y")) {
					quit = true;
				}

				break;

			case 1:// Look up a customer
				System.out.println("What is the customers phone number?");
				String phoneN = input4.nextLine();
				// search if the customer exists.
				if (searchCustList(phoneN)) {
					// if the customer exists return the customers information.
					showCustomer(phoneN);
				} else {

					// if the customer does not exist, request to add them.
					System.out.println("the customer does not exist, would you like to add them? Y?N");
					String reply = quitting.nextLine();
					if (reply.equalsIgnoreCase("Y")) {
						// if the customer would like to be added, create a new customer.
						newCustomer();
					}
				}
				System.out.println();
				System.out.println("Would you like to quit? Y/N");
				String answer = quitting.nextLine();
				if (answer.equalsIgnoreCase("Y")) {
					quit = true;
				}
				break;
			case 2:// Look up a book.
				System.out.println("What is the books title?");
				String bTitle = input4.nextLine();
				// search if the book exists.
				if (searchBookList(bTitle)) {
					// if the book exists return the books information.
					showBook(bTitle);
				} else {
					// if the book does not exist, request to add it.
					System.out.println("the book does not exist, would you like to add it? Y?N");
					String reply1 = quitting.nextLine();
					if (reply1.equalsIgnoreCase("Y")) {
						// create a new book object.
						newBook();
					}
				}
				System.out.println();
				System.out.println("Would you like to quit? Y/N");
				String answer1 = quitting.nextLine();
				if (answer1.equalsIgnoreCase("Y")) {
					quit = true;
				}
				break;
			case 3:// Create a customer.
				newCustomer();

				System.out.println();
				System.out.println("Would you like to quit? Y/N");
				String answer2 = quitting.nextLine();
				if (answer2.equalsIgnoreCase("Y")) {
					quit = true;
				}
				break;
			case 4:// Delete a customer.
				System.out.println("What is the customers phone number?");
				String phoneNum = input4.nextLine();
				// Search for the customer
				if (searchCustList(phoneNum)) {
					System.out.println("is this the customer you would like to delete? Y/N");
					showCustomer(phoneNum);
					String delete = input4.nextLine();
					// verify this is the right customer.
					Boolean okToDel = false;
					if (delete.equalsIgnoreCase("Y")) {
						okToDel = delCust(phoneNum);
						while (okToDel) {
							System.out.println("Customer has been deleted");
							okToDel = false;
						}
					}
				}
				System.out.println();
				System.out.println("Would you like to quit? Y/N");
				String answer4 = quitting.nextLine();
				if (answer4.equalsIgnoreCase("Y")) {
					quit = true;
				}
				break;
			case 5:// Add a book.
				newBook();

				System.out.println("Would you like to quit? Y/N");
				String answer3 = quitting.nextLine();
				if (answer3.equalsIgnoreCase("Y")) {
					quit = true;
				}
				break;
			case 6:// Book Inventory
				bookInventory();

				System.out.println("Would you like to quit? Y/N");
				String answer41 = quitting.nextLine();
				if (answer41.equalsIgnoreCase("Y")) {
					quit = true;
				}
				break;
			case 7:// Customer Data
				custInventory();

				System.out.println("Would you like to quit? Y/N");
				String answer51 = quitting.nextLine();
				if (answer51.equalsIgnoreCase("Y")) {
					quit = true;
				}
				break;
			default:
				// code block
			}
		}

	}

	// create customer method
	public static void newCustomer() {
		Customer a = new Customer();

		Scanner input1 = new Scanner(System.in);

		System.out.println("What is the customers first name? ");
		String name = input1.nextLine();
		a.setFirstName(name);

		System.out.println("What is the customers last name? ");
		String lName = input1.nextLine();
		a.setLastName(lName);

		System.out.println("What is the customers address? ");
		String add = input1.nextLine();
		a.setAddress(add);

		System.out.println("What is the customers phone number? ");
		String phone = input1.nextLine();
		a.setPhoneNumber(phone);

		MyDate aD = new MyDate();
		a.setRegDate(aD);

		// make sure the customer you are trying to add does not already exist.
		if (searchCustList(phone)) {
			System.out.println("The customer you are trying to add already exists");

		} else {
			custList.add(a);
		}

	}

	// delete a customer method.
	public static boolean delCust(String a) {
		for (Customer customer : custList) {
			if (customer.getPhoneNumber().equals(a))
				if (customer.getRental().isEmpty()) {
					custList.remove(customer);
					return true;

				} else {
					System.out.println("Please return the following books you have rented" + System.lineSeparator());
				}
		}
		return false;
	}

	// create book method
	public static void newBook() {
		Book b = new Book();

		Scanner input2 = new Scanner(System.in);

		System.out.println("What is the title of the book?");
		String title = input2.nextLine();
		b.setTitle(title);

		System.out.println("Who is the author of the book?");
		String author = input2.nextLine();
		b.setAuthor(author);

		System.out.println("Who published the book?");
		String publisher = input2.nextLine();
		b.setPublisher(publisher);
		b.setBookAvailable();
		MyDate bD = new MyDate();
		b.setRelDate(bD);

		// make sure the book being added does not already exist.
		if (searchBookList(title)) {
			System.out.println("The book you are trying to add already exists");

		} else {
			bookList.add(b);
		}
	}

	// search if customer exists.
	public static Boolean searchCustList(String a) {
		for (Customer customer : custList) {
			if (customer.getPhoneNumber().equals(a)) {
				return true;
			}
		}
		return false;

	}

	// return customer object
	public static void showCustomer(String a) {
		for (Customer customer : custList) {
			if (customer.getPhoneNumber().equals(a))
				System.out.print(customer.getCustomer());
		}
	}

	// rent book method.
	public static void rental(String a, String b) {
		int size;
		for (Customer customer : custList) {
			// find customer.
			if (customer.getPhoneNumber().equals(a)) {
				// set size variable to the size of the rental arraylist.
				size = customer.getRental().size();
				// find the book.
				for (Book book : bookList) {
					if (book.getTitle().equals(b)) {
						// if rental size is less than 7, rent the book.
						if (size == 7) {
							System.out.println("Customer must return a book in order to rent another book");
						} else {
							customer.setRental(book);
							book.setRenter(customer);
							book.setBookRented();

						}
					}

				}
			}
		}
	}

	// search if book exists.
	public static Boolean searchBookList(String a) {
		for (Book book : bookList) {
			if (book.getTitle().equals(a)) {
				return true;
			}
		}
		return false;
	}

	// return book object
	public static void showBook(String a) {
		for (Book book : bookList) {
			if (book.getTitle().equals(a))
				System.out.println(book.getBook());
		}
	}

	public static List<Customer> getCustList() {
		return custList;
	}

	public static List<Book> getBookList() {
		return bookList;
	}

	public static void bookInventory() {
		System.out.println("Title" + "                  " + "Burrowed by" + "           " + "Availability");
		System.out.println("----------------------------------------------------------");
		for (Book book : bookList) {
			if (book.getRental() != null) {
				System.out.println(book.getTitle() + "                   " + book.getRental().getFirstName()
						+ "                    " + book.getAvailable());
			} else {
				System.out.println(book.getTitle() + "                 " + null
						+ "                                          " + book.getAvailable());
			}
		}
		System.out.println();
	}

	public static void custInventory() {
		System.out.println("Customer" + "                  " + "Book Borrowed"
				+ "                                                  " + "Due Date");
		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------------------------");
		for (Customer customer : custList) {
			System.out.println(customer.getFirstName() + "                   " + customer.showList()
					+ "                    " + null);
		}
		System.out.println();
	}
}