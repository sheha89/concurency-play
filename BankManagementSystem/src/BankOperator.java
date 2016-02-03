import com.bank.system.model.account.Account;
import com.bank.system.model.account.FixedAccount;
import com.bank.system.model.account.SavingsAccount;
import com.bank.system.model.user.Admin;
import com.bank.system.model.user.Customer;
import com.bank.system.model.user.User;

import java.math.BigDecimal;
import java.util.Scanner;

public class BankOperator {

    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        User user = authenticateUser(sc);
        if (user instanceof Customer) {
            System.out.println("Welcome to customer panel");
        } else if (user instanceof Admin) {
            System.out.println("Welcome to admin panel");
        }
    }

    public static User authenticateUser(Scanner sc) {
        System.out.println("Enter A for Admin and C Customer");
        String userTypeInput = sc.nextLine();
        if ("c".equalsIgnoreCase(userTypeInput)) {
            //To-do Fetch user by user name and password
            return new Customer();
        } else if ("a".equalsIgnoreCase(userTypeInput)) {
            //To-do Fetch user by user name and password
            return new Admin();
        } else {
            System.out.println("Wrong user input");
            return authenticateUser(sc);
        }
    }

    public static void operateAdmin(Scanner sc, Account account, Admin admin) {
        System.out.println("a for create, b for edit, c for delete");
        String adminOperationInput = sc.nextLine();
        if ("a".equalsIgnoreCase(adminOperationInput)) {
            //get values and create the account
            admin.createAccount(account);
        } else if ("b".equalsIgnoreCase(adminOperationInput)) {
            //get the account by user and change
            admin.editAccount(account);
        } else if ("c".equalsIgnoreCase(adminOperationInput)) {
            //get the account by user and change
            admin.deleteAccount(account);
        } else {
            System.out.println("Wrong user input");
            operateAdmin(sc, account, admin);
        }
    }

    public static void operateUser(Scanner sc, Customer customer) {
        System.out.println("Please enter the account number to proceed: ");
        String accountNumberInput = sc.nextLine();
        // verify the account number
        // get the account object by given account number
        Account account = new FixedAccount();

        System.out.println("Please enter what a to withdraw, b to deposit");
        String userInput = sc.nextLine();
        if ("a".equalsIgnoreCase(userInput)) {
            System.out.println("Please enter amount to withdraw: ");
            String withdrawalAmount = sc.nextLine();
            account.withdraw(BigDecimal.valueOf(Integer.parseInt(withdrawalAmount)));
        } else if ("b".equalsIgnoreCase(userInput)) {
            System.out.println("Please enter amount to withdraw: ");
            String withdrawalAmount = sc.nextLine();
            account.deposit(BigDecimal.valueOf(Integer.parseInt(withdrawalAmount)));
        } else {
            operateUser(sc, customer);
        }
    }

    public static void depositMoney(BigDecimal depositAmount, Account account, User user) {
        //Todo get the account by user id
        FixedAccount userAccount = new FixedAccount();
        userAccount.deposit(BigDecimal.valueOf(3));
    }

    public static void witdrawMoney(BigDecimal amount, Account account, User user){
        //Todo get the account by user id
        FixedAccount userAccount = new FixedAccount();
        userAccount.deposit(BigDecimal.valueOf(3));
    }

    public static Account buildAccount(Scanner sc) {
        System.out.println("dsd");
        System.out.println("a for savings, b for fixed");
        String accountTypeUserInput = sc.nextLine();
        if ("a".equalsIgnoreCase(accountTypeUserInput)) {
            return new SavingsAccount();
        } else if ("b".equalsIgnoreCase(accountTypeUserInput)) {
            return new FixedAccount();
        } else {
            return buildAccount(sc);
        }
    }

}
