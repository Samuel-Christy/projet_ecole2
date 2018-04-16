package greta.projet_ecole2;

import java.util.Random;

import org.joda.time.LocalDate;

import factories.UserFactory;
import models.MBook;
import models.MCollectionBorrows;
import models.MUser;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		// tests();

		// launch controller
		MCollectionBorrows controller = new MCollectionBorrows();

		// add some stuff :
		seed(controller);

		controller.initView();

	}

	private static void seed(MCollectionBorrows controller) {
		// books
		controller.setAllBooks(UserFactory.generateBookList(10));
		System.out.println("AllBooks collection debug : ");
		for (MBook book : controller.getAllBooks()) {
			System.out.println(book);
		}
		// users
		controller.setAllUsers(UserFactory.generateUserList(5));

		// randomly associate some :
		UserFactory.associateRandomBookUser(controller, controller.getAllUsers(), controller.getAllBooks());
	}

	@SuppressWarnings("unused")
	private static void tests() {

		System.out.println("Testing models :");
		System.out.println(testBook().id());
		System.out.println(testUser());

		System.out.println("Testing book's model date time :");
		testBookTime();
	}

	private static MBook testBook() {

		return new MBook("title", "author's lastname", "author's firstname", "editors's name",
				new Random().nextInt(2018) + 1);
	}

	private static MUser testUser() {
		return new MUser("Killroy", "WasHere");
	}

	private static void testBookTime() {
		MBook book = testBook();
		book.inDate(LocalDate.parse("2018-03-14"));
		System.out.println(book.inDate());
	}

}
