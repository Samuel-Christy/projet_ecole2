package views;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import org.joda.time.LocalDate;

import models.MBook;
import models.MCollectionBorrows;
import models.MUser;

public class VMainView {
	public enum editMode {
		BOOK, USER, BORROWS;
	}

	private MCollectionBorrows controller;

	private JFrame frmBibliotheque;
	private JMenuBar menuBar = new JMenuBar();
	private JMenu mnNewMenu = new JMenu("New menu");
	private JMenuItem menuIytemBooks = new JMenuItem("Livres");
	private JMenuItem menuItemUsers = new JMenuItem("Utilisateurs");
	private JTextField user_txt_firstname;
	private JTextField usr_txt_lastname;
	private editMode currentMode = editMode.BOOK;
	private JTextField txt_book_title;
	private JTextField book_txt_authorFirstname;
	private JTextField book_txt_authorLastname;
	private JTextField book_txt_editor;
	private JSpinner borrow_spinner_outDate = new JSpinner();
	private JMenuItem menuItemsBorrows = new JMenuItem("Emprunts");
	private JPanel user_panel = new JPanel();
	private JLabel lbl_user_userFirstname = new JLabel("New label");
	private JLabel lbl_user_userLastname = new JLabel("New label");
	private JLabel lbl_user_bookList = new JLabel("New label");
	private List user_list = new List();
	private JPanel book_panel = new JPanel();
	private JLabel book_lbl_title = new JLabel("New label");
	private JLabel book_lbl_authorFirstname = new JLabel("New label");
	private JLabel book_lbl_authorLastname = new JLabel("New label");
	private JLabel book_lbl_editor = new JLabel("New label");
	private JLabel book_lbl_published = new JLabel("New label");
	private JSpinner book_spin_published = new JSpinner();
	private JComboBox<MUser> book_combo_user = new JComboBox<MUser>();
	private JLabel book_lbl_user = new JLabel("New label");
	private List book_list = new List();
	private JButton book_btn_del = new JButton("New button");
	private JButton book_btn_add = new JButton("New button");
	private JButton book_btn_save = new JButton("New button");
	private JLabel borrow_lbl_available = new JLabel("New label");
	private JLabel borrow_lbl_borrowed = new JLabel("New label");
	private JPanel borrow_panel = new JPanel();
	private List borrow_list_available = new List();
	private List borrow_list_borrowed = new List();
	private JSpinner borrow_spinner_returnDate = new JSpinner();
	private final JLabel global_label_mode = new JLabel("New label");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, final MCollectionBorrows controller) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VMainView window = new VMainView();
					window.frmBibliotheque.setVisible(true);
					window.controller = controller;
					window.init();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VMainView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBibliotheque = new JFrame();
		frmBibliotheque.setResizable(false);
		frmBibliotheque.setTitle("Bibliotheque");
		frmBibliotheque.setBounds(100, 100, 476, 399);
		frmBibliotheque.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frmBibliotheque.setJMenuBar(menuBar);

		menuBar.add(mnNewMenu);
		menuIytemBooks.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				toogleMode(editMode.BOOK);
			}
		});

		mnNewMenu.add(menuIytemBooks);
		menuItemUsers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				toogleMode(editMode.USER);
			}
		});

		mnNewMenu.add(menuItemUsers);
		menuItemsBorrows.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				toogleMode(editMode.BORROWS);
			}
		});

		mnNewMenu.add(menuItemsBorrows);
		frmBibliotheque.getContentPane().setLayout(null);

		borrow_panel.setBounds(23, 36, 419, 259);
		frmBibliotheque.getContentPane().add(borrow_panel);
		borrow_panel.setLayout(null);
		borrow_spinner_outDate.setBounds(1, 174, 119, 20);
		borrow_panel.add(borrow_spinner_outDate);

		borrow_spinner_outDate
				.setModel(new SpinnerDateModel(new Date(1523743200000L), null, null, Calendar.DAY_OF_YEAR));

		borrow_list_available.setBounds(1, 22, 120, 60);
		borrow_panel.add(borrow_list_available);
		borrow_list_borrowed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});

		borrow_list_borrowed.setBounds(0, 100, 120, 60);
		borrow_panel.add(borrow_list_borrowed);

		borrow_spinner_returnDate.setBounds(1, 205, 119, 20);
		borrow_panel.add(borrow_spinner_returnDate);
		borrow_spinner_returnDate
				.setModel(new SpinnerDateModel(new Date(1523743200000L), null, null, Calendar.DAY_OF_YEAR));
		borrow_lbl_available.setBounds(1, 11, 46, 14);
		borrow_panel.add(borrow_lbl_available);
		borrow_lbl_borrowed.setBounds(1, 88, 46, 14);
		borrow_panel.add(borrow_lbl_borrowed);
		global_label_mode.setFont(new Font("Tahoma", Font.BOLD, 11));
		global_label_mode.setHorizontalAlignment(SwingConstants.CENTER);
		global_label_mode.setBounds(23, 11, 419, 14);

		frmBibliotheque.getContentPane().add(global_label_mode);

		user_panel.setBounds(23, 36, 419, 259);
		frmBibliotheque.getContentPane().add(user_panel);
		user_panel.setLayout(null);

		user_txt_firstname = new JTextField();
		user_txt_firstname.setBounds(0, 12, 180, 20);
		user_panel.add(user_txt_firstname);
		user_txt_firstname.setColumns(10);

		usr_txt_lastname = new JTextField();
		usr_txt_lastname.setBounds(0, 56, 180, 20);
		user_panel.add(usr_txt_lastname);
		usr_txt_lastname.setColumns(10);

		lbl_user_userFirstname.setBounds(0, 0, 46, 14);
		user_panel.add(lbl_user_userFirstname);

		lbl_user_userLastname.setBounds(0, 43, 46, 14);
		user_panel.add(lbl_user_userLastname);

		lbl_user_bookList.setBounds(0, 87, 46, 14);
		user_panel.add(lbl_user_bookList);

		user_list.setBounds(0, 101, 180, 60);
		user_panel.add(user_list);

		book_panel.setBounds(23, 36, 419, 259);
		frmBibliotheque.getContentPane().add(book_panel);
		book_panel.setLayout(null);

		txt_book_title = new JTextField();
		txt_book_title.setBounds(0, 13, 180, 20);
		book_panel.add(txt_book_title);
		txt_book_title.setColumns(10);

		book_lbl_title.setBounds(0, 0, 46, 14);
		book_panel.add(book_lbl_title);

		book_lbl_authorFirstname.setBounds(0, 44, 46, 14);
		book_panel.add(book_lbl_authorFirstname);

		book_txt_authorFirstname = new JTextField();
		book_txt_authorFirstname.setBounds(0, 57, 180, 20);
		book_panel.add(book_txt_authorFirstname);
		book_txt_authorFirstname.setColumns(10);

		book_lbl_authorLastname.setBounds(0, 85, 46, 14);
		book_panel.add(book_lbl_authorLastname);

		book_txt_authorLastname = new JTextField();
		book_txt_authorLastname.setBounds(0, 98, 180, 20);
		book_panel.add(book_txt_authorLastname);
		book_txt_authorLastname.setColumns(10);

		book_lbl_editor.setBounds(0, 123, 46, 14);
		book_panel.add(book_lbl_editor);

		book_txt_editor = new JTextField();
		book_txt_editor.setBounds(0, 136, 180, 20);
		book_panel.add(book_txt_editor);
		book_txt_editor.setColumns(10);

		book_lbl_published.setBounds(0, 167, 46, 14);
		book_panel.add(book_lbl_published);

		book_spin_published.setBounds(0, 179, 180, 20);
		book_panel.add(book_spin_published);
		// set it from Gutemberg to now
		book_spin_published
				.setModel(new SpinnerNumberModel(LocalDate.now().getYear(), 1493, LocalDate.now().getYear(), 1));

		book_combo_user.setBounds(0, 226, 180, 20);
		book_panel.add(book_combo_user);

		book_lbl_user.setBounds(0, 210, 46, 14);
		book_panel.add(book_lbl_user);

		book_list.setBounds(206, 13, 207, 186);
		book_panel.add(book_list);

		book_btn_del.setBounds(383, 223, 30, 23);
		book_panel.add(book_btn_del);

		book_btn_add.setBounds(343, 223, 30, 23);
		book_panel.add(book_btn_add);

		book_btn_save.setBounds(206, 223, 127, 23);
		book_panel.add(book_btn_save);

	}

	private void init() {
		booksAllBooksFillList();
		controller.syncBooksLists();
		borrowsAvailableBooksFillLists();
		borrowsBorrowedBooksFillLists();
		usersFillList();
		toogleMode(editMode.BOOK);
	}

	private void listOnClicCallback_borrowsPermuteList(List clickedList) {
		if (clickedList == borrow_list_available) {
			borrow_list_borrowed.select(-1);
		} else {
			borrow_list_available.select(-1);
		}
	}

	private LocalDate spinToDate(JSpinner spinner) {
		LocalDate o = null;
		try {
			o = LocalDate.fromDateFields((Date) spinner.getValue());

		} catch (Exception e2) {
			System.err.println("unable to parse : " + spinner.getValue());
		}
		return o;
	}

	private LocalDate nextReturnDate(LocalDate outDate) {
		return LocalDate.parse(outDate.plusWeeks(2).toString());
	}

	private void setPanelVisibility() {
		borrow_panel.setVisible(currentMode == editMode.BORROWS);
		book_panel.setVisible(currentMode == editMode.BOOK);
		user_panel.setVisible(currentMode == editMode.USER);
		global_label_mode.setText(currentMode == editMode.BORROWS ? "Emprunts"
				: currentMode == editMode.BOOK ? "Livres" : "Utilisateurs");

	}

	private void toogleMode(editMode mode) {
		currentMode = mode;
		System.out.println(mode);
		menuItemsBorrows.setEnabled(!(currentMode == editMode.BORROWS));
		menuItemUsers.setEnabled(!(currentMode == editMode.USER));
		menuIytemBooks.setEnabled(!(currentMode == editMode.BOOK));

		setPanelVisibility();
	}

	private void booksAllBooksFillList() {
		genericFillBookList(controller.getAllBooks(), book_list);

	}

	private void borrowsBorrowedBooksFillLists() {
		genericFillBookList(controller.getBorrowedBooks(), borrow_list_borrowed);
	}

	private void borrowsAvailableBooksFillLists() {
		genericFillBookList(controller.getFreeBooks(), borrow_list_available);
	}

	private void genericFillBookList(ArrayList<MBook> books, List list) {
		list.removeAll();
		for (MBook book : books) {
			list.add(book.toString());
		}
	}

	private void usersFillList() {
		user_list.removeAll();
		for (MUser user : controller.getAllUsers()) {
			user_list.add(user.toString());
		}
	}

}
