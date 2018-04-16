package models;

import org.joda.time.LocalDate;

public class MBook extends MDBModelBase {

	private String title;
	private String authorLastName;
	private String authorFirstName;
	private String editor;
	private int publishYear;
	private MUser borrower;
	private LocalDate outDate;
	private LocalDate inDate;

	public MBook(String title, String authorLastName, String authorFirstName, String editor, int publishYear) {
		super();
		this.title = title;
		this.authorLastName = authorLastName;
		this.authorFirstName = authorFirstName;
		this.editor = editor;
		this.publishYear = publishYear;
	}

	public LocalDate outDate(LocalDate outDate) {
		this.outDate = outDate;
		return outDate();
	}

	public LocalDate outDate() {
		return outDate;
	}

	public LocalDate inDate(LocalDate inDate) {
		this.inDate = inDate;
		return inDate();
	}

	public LocalDate inDate() {
		return inDate;
	}

	public int publishYear() {
		return publishYear;
	}

	public int publishYear(int publishYear) {
		this.publishYear = publishYear;
		return this.publishYear();
	}

	public MUser borrower(MUser borrower) {
		this.borrower = borrower;
		return borrower();
	}

	public MUser borrower() {
		return borrower;
	}

	public String editor(String editor) {
		this.editor = editor;
		return editor();
	}

	public String editor() {
		return editor;
	}

	public String authorFirstName(String authorFirstName) {
		this.authorFirstName = authorFirstName;
		return authorFirstName();
	}

	public String authorFirstName() {
		return authorFirstName;
	}

	public String authorLastName(String authorLastName) {
		this.authorLastName = authorLastName;
		return authorLastName();
	}

	public String authorLastName() {
		return authorLastName;
	}

	public String title(String title) {
		this.title = title;
		return title();
	}

	public String title() {
		return title;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return (borrower == null ? "" : "* ") + "[ " + publishYear() + " ] { " + editor() + " } " + title() + " ("
				+ authorFirstName() + ", " + authorLastName() + ")";
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub

	}

	@Override
	public void load(int id) {
		// TODO Auto-generated method stub

	}

}
