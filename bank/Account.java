package bank;

public class Account {
	private int cash;
	private String name;

	public Account(String name) {
		cash = 0;
		this.name = name;
	}

	public int getShekels() {
		return cash;
	}

	public String getName() {
		return name;
	}

	public void add(int amount) {
		cash += amount;
	}

	public String toString() {
		return (name + " has " + cash + " shekels");

	}
}
