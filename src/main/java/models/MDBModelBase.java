package models;

import java.util.Date;

public abstract class MDBModelBase {

	protected final boolean testing = true;

	protected int id = -1; // default is -1 as it is an invalid SQL index

	protected void log(String s) {

		if (testing && this.getClass().getSuperclass() == MDBModelBase.class) {
			System.out
					.println("---------------------------------------------------------------------------------------");
			System.out.println("[" + new Date() + "]" + " -> " + this.getClass() + " : " + s);
			System.out
					.println("---------------------------------------------------------------------------------------");
		}
	}

	public MDBModelBase() {
		init();
	}

	public MDBModelBase(int id) {
		this.id = id;
		init();
	}

	public int id() {
		return id;
	}

	public int id(int id) {
		this.id = id;
		return this.id();
	}

	protected void init() {
		log("nothing to init");
	};

	public abstract void save();

	public abstract void load(int id);

}
