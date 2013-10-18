public class Account {

	// State
	private String name;
	private String pin;
	private double balance;

	// Constructor
	public Account(String name, String pin, double balance) {
		setName(name);
		setPin(pin);
		setBalance(balance);
	}

	// name getter
	public String getName() {
		return name;
	}

	// name setter
	public void setName(String name) {
                this.name = name;
            
	}

	// pin getter
	public String getPin() {
		return pin;
	}

	// pin setter
	public void setPin(String pin) {
         	this.pin = pin;

	}

	// balance getter
	public double getBalance() {
		return balance;
	}

	// balance setter
	public void setBalance(double balance) {
		this.balance = balance;
	}



}