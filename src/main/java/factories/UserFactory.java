package factories;

import java.util.ArrayList;

import com.github.javafaker.Faker;

import models.MBook;
import models.MCollectionBorrows;
import models.MUser;

public class UserFactory {

	public static MUser generateUser() {
		Faker faker = FakerUtils.getFaker();
		return new MUser(faker.name().firstName(), faker.name().lastName());
	}

	public static MBook generateBook() {
		Faker faker = FakerUtils.getFaker();
		return new MBook(faker.book().title(), faker.name().lastName(), faker.name().firstName(),
				faker.book().publisher(),
				faker.number().numberBetween(faker.number().randomDigit() % 9 == 0 ? 1493 : 1800, 2018));

	}

	public static ArrayList<MBook> generateBookList(int count) {
		ArrayList<MBook> list = new ArrayList<MBook>();
		for (int i = 0; i < count; i++) {
			list.add(generateBook());
		}
		return list;
	}

	public static ArrayList<MUser> generateUserList(int count) {
		ArrayList<MUser> list = new ArrayList<MUser>();
		for (int i = 0; i < count; i++) {
			list.add(generateUser());
		}
		return list;
	}

	public static void associateRandomBookUser(MCollectionBorrows collection, ArrayList<MUser> users,
			ArrayList<MBook> books) {
		int tries = 0;
		MBook book = books.get(FakerUtils.getFaker().number().numberBetween(0, books.size()));

		// if we picked an already associated book...
		while (book.borrower() != null && tries < 10) {
			book = books.get(FakerUtils.getFaker().number().numberBetween(0, books.size()));
			tries++;
		}

		if (book.borrower() == null) {

			MUser user = users.get(FakerUtils.getFaker().number().numberBetween(0, users.size()));
			collection.assoc(book, user);
		}

	}

}
