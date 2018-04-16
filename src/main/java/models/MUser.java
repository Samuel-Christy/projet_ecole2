package models;

import java.util.ArrayList;

public class MUser extends MDBModelBase {

	private String firstName;
	private String lastName;
	private ArrayList<MBook> books;

	public MUser(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public ArrayList<MBook> delBook(MBook book) {
		if (books().contains(book)) {
			books().remove(book);
		}
		return books();
	}

	public ArrayList<MBook> addBook(MBook book) {
		if (books().contains(book)) {
			books().add(book);
		}
		return books();
	}

	public ArrayList<MBook> books(ArrayList<MBook> books) {
		this.books = books;
		return books();
	}

	public ArrayList<MBook> books() {
		return books;
	}

	public String lastName(String lastName) {
		this.lastName = lastName;
		return lastName();
	}

	public String lastName() {
		return lastName;
	}

	public String firstName(String firstName) {
		this.firstName = firstName;
		return firstName();
	}

	public String firstName() {
		return firstName;
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub

	}

	@Override
	public void load(int id) {
		// TODO Auto-generated method stub
	}

	@Override
	protected void init() {
		books = new ArrayList<MBook>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return (books().size() > 0 ? "* " : "") + firstName() + ", " + lastName();
	}

}
