public class AtmRunner {

     public static void main(String[] args) {

          Atm atm = new Atm();

          atm.login();
          while (atm.getLoginFlag()) {
              atm.menu(atm, atm.input, atm.choice);
          }

     }




}