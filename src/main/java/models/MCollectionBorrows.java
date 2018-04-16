package models;

import java.util.ArrayList;

import views.VMainView;

public class MCollectionBorrows {

	private ArrayList<MBook> allBooks;
	private ArrayList<MBook> borrowedBooks;
	private ArrayList<MBook> freeBooks;
	private ArrayList<MUser> allUsers;

	private MBook addBookToArrayList(MBook book, ArrayList<MBook> books) {
		if (books.contains(book)) {
			books.add(book);

		}
		return books.lastIndexOf(book) == -1 ? null : books.get(books.lastIndexOf(book));
	}

	private boolean removeBookFromArrayList(MBook book, ArrayList<MBook> books) {
		if (books.contains(book) && book.borrower() == null) {
			books.remove(book);
			return !books.contains(book);
		}
		return false;

	}

	public MBook addBook(MBook book) {
		if (book.borrower() == null) {
			addBookToArrayList(book, freeBooks);
		} else {
			addBookToArrayList(book, borrowedBooks);
		}
		return addBookToArrayList(book, allBooks);
	}

	public boolean removeBook(MBook book) {
		if (book.borrower() == null)
			return false;
		else
			return removeBookFromArrayList(book, freeBooks) && removeBookFromArrayList(book, allBooks);
	}

	public MCollectionBorrows() {
		init();
	}

	private void init() {
		allBooks = new ArrayList<MBook>();
		borrowedBooks = new ArrayList<MBook>();
		freeBooks = new ArrayList<MBook>();
		allUsers = new ArrayList<MUser>();
		// init view :
	}

	public void initView() {
		VMainView.main(null, this);
	}

	public void assoc(MBook book, MUser user) {
		book.borrower(user);
		addBookToArrayList(book, user.books());
	}

	public void dissoc(MBook book) {
		if (book.borrower() != null) {
			removeBookFromArrayList(book, book.borrower().books());
		}
		book.borrower(null);
	}

	/**
	 * @return the allBooks
	 */
	public ArrayList<MBook> getAllBooks() {
		return allBooks;
	}

	/**
	 * @return the borrowedBooks
	 */
	public ArrayList<MBook> getBorrowedBooks() {
		return borrowedBooks;
	}

	/**
	 * @return the freeBooks
	 */
	public ArrayList<MBook> getFreeBooks() {
		return freeBooks;
	}

	/**
	 * @return the allUsers
	 */
	public ArrayList<MUser> getAllUsers() {
		return allUsers;
	}

	/**
	 * @param allBooks
	 *            the allBooks to set
	 */
	public void setAllBooks(ArrayList<MBook> allBooks) {
		this.allBooks = allBooks;

	}

	/**
	 * @param borrowedBooks
	 *            the borrowedBooks to set
	 */
	public void setBorrowedBooks(ArrayList<MBook> borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
	}

	/**
	 * @param freeBooks
	 *            the freeBooks to set
	 */
	public void setFreeBooks(ArrayList<MBook> freeBooks) {
		this.freeBooks = freeBooks;
	}

	/**
	 * @param allUsers
	 *            the allUsers to set
	 */
	public void setAllUsers(ArrayList<MUser> allUsers) {
		this.allUsers = allUsers;
	}

	public void syncBooksLists() {
		borrowedBooks.clear();
		freeBooks.clear();

		for (MBook book : allBooks) {
			ArrayList<MBook> usedList = book.borrower() == null ? freeBooks : borrowedBooks;
			usedList.add(book);
		}

		// debug :
		// System.out.println("Available books :");
		// for (MBook book : freeBooks) {
		// System.out.println(book);
		// }
		//
		// System.out.println("Borrowed books :");
		// for (MBook book : borrowedBooks) {
		// System.out.println(book);
		// }
	}

}
