import java.util.Scanner;

public class Atm {

	// State
	Scanner input = new Scanner(System.in);  //scanner for String
        Scanner choice = new Scanner(System.in); //scanner for double and integer
	private Account[] array = new Account[3];
        private Account loginAccount = null;
        private boolean loginFlag = false;   //checks if user is logged in or not

        // Constructor
        public Atm() {
                this.array[0] = new Account("Bob", "1234", 100);
	        this.array[1] = new Account("Alice", "3333", 250);
	        this.array[2] = new Account("JT", "0001", 999999999);
        }

        public boolean getLoginFlag() {
                return loginFlag;
        }

	public void login() {
		String thisName = "";
		String thisPin = "";
		
                do {
		     System.out.print("Name: ");
		     thisName = input.nextLine();
                } while (!checkName(thisName));

                do {
		     System.out.print("PIN: ");
		     thisPin = input.nextLine();
                } while (!checkPin(thisPin));
	
	}

       public static void menu(Atm atm, Scanner input, Scanner choice) {

                System.out.println();
                System.out.println("<1> Check balance");
                System.out.println("<2> Withdraw Funds");
                System.out.println("<3> Change Account Name");
                System.out.println("<4> Change Account PIN");
                System.out.println("<5> Logout");
          
                int selection = choice.nextInt();
                if (selection == 1) {
                     atm.checkBalance();
                } else if (selection == 2) {
                     System.out.print("Please input withdrawal amount: " );
                     double amount = choice.nextDouble();
                     atm.withdrawFunds(amount);
                } else if (selection == 3) {
                     System.out.print("Please input new account name: " );
                     String newName = input.nextLine();
                     atm.changeName(newName);
                } else if (selection == 4) {
                     System.out.print("Please input new account PIN: " );
                     String newPin = input.nextLine();
                     atm.changePin(newPin);
                } else if (selection == 5) {
                     atm.logout();
                } else {
                      System.out.println("Selection not avaliable. Please try again.");
                }
        }


        //checks if name exists
        public boolean checkName(String thisName) {
                for (int i = 0; i < array.length; i++) {
                     Account account = array[i];
                     if (account.getName().equals(thisName)) {
                        loginAccount = account;
                        return true;
                     }
                 }
                 System.out.println("Account " + thisName + " does not exist.");
                 return false;
        }

        //checks if pin corresponds to account name
        public boolean checkPin(String thisPin) {
                if (loginAccount != null) {
                     if (loginAccount.getPin().equals(thisPin)) {
                         loginFlag = true;
                         return true;
                     }
                } 
              System.out.println("PIN is incorrect.");
              return false;  
        }


	public void checkBalance() {
                if (loginFlag) {
		     System.out.println("Balance is: " + loginAccount.getBalance());
                }
	}

	public void withdrawFunds(double amount) {
		if (amount > 0.0 && loginFlag) {
                      loginAccount.setBalance(loginAccount.getBalance() - amount);
                      System.out.println("New balance is: " + loginAccount.getBalance());
                }
	}
	public void changeName(String newName) {
		if (loginFlag) {
                     loginAccount.setName(newName);
                     System.out.println("New account name is: " + loginAccount.getName());
                }
	}
        public void changePin(String newPin){
		if (loginFlag) {
                     loginAccount.setPin(newPin);
                     System.out.println("New PIN is: " + loginAccount.getPin());
                }
	}
	public void logout() {
                loginFlag = false;
                loginAccount = null;
                login();
	}


}
