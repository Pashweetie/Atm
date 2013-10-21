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
                if (name.length() > 1 && name.length() < 20) {
                     this.name = name;
                } else {
                     System.out.println("Account name must be between  1 and 20 characters.");
                }            
	}

	// pin getter
	public String getPin() {
		return pin;
	}

	// pin setter
	public void setPin(String pin) {
                if (pin.length() == 4) {
         	     this.pin = pin;
                } else {
                     System.out.println("PIN must be 4 characters long.");
                }
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