import com.bank.system.OperatorLogin;
import com.bank.system.account.Account;
import com.bank.system.account.FixedAccount;
import com.bank.system.account.SavingsAccount;
import com.bank.system.user.Admin;
import com.bank.system.user.Customer;
import com.bank.system.user.User;
import javafx.scene.layout.BackgroundImage;

import java.math.BigDecimal;
import java.util.Scanner;

public class BankOperator {

    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        User user = OperatorLogin(sc);
        if (user instanceof Customer) {
            System.out.println("Welcome to customer panel");
        } else if (user instanceof Admin) {
            System.out.println("Welcome to admin panel");
        }
    }

    public static User OperatorLogin(Scanner sc) {
        System.out.println("Enter A for Admin and C Customer");
        String userTypeInput = sc.nextLine();
        if ("c".equalsIgnoreCase(userTypeInput)) {
            return new Customer();
        } else if ("a".equalsIgnoreCase(userTypeInput)) {
            return new Admin();
        } else {
            System.out.println("Wrong user input");
            return OperatorLogin(sc);
        }
    }

    public static void operateAdmin(Scanner sc, Account account, Admin admin) {
        System.out.println("a for create, b for edit, c for delete");
        String adminOperationInput = sc.nextLine();
        if ("a".equalsIgnoreCase(adminOperationInput)) {
            admin.createAccount(account);
        } else if ("b".equalsIgnoreCase(adminOperationInput)) {
            admin.editAccount(account);
        } else if ("c".equalsIgnoreCase(adminOperationInput)) {
            admin.deleteAccount(account);
        } else {
            System.out.println("Wrong user input");
            operateAdmin(sc, account, admin);
        }
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

    public static void depositMoney(BigDecimal depositAmount, Account account, User user){
        //Todo get the account by user id
        FixedAccount userAccount = new FixedAccount();
        userAccount.deposit();


    }

}
