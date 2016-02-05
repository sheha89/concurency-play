package com.bank.system;

import com.bank.system.model.account.SavingsAccount;
import com.bank.system.model.user.Admin;
import com.bank.system.model.user.Customer;
import com.bank.system.model.user.User;
import com.bank.system.service.SavingsAccountService;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by shehan on 2/4/16.
 */
public class BankOperatorService {


    private SavingsAccountService savingsAccountService = new SavingsAccountService();

    public User authenticateUser(Scanner sc) {

        // enter username verify if he is an customer by usertype field

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

    public void operateUser(Scanner sc, Customer customer) {
        System.out.println("Please enter the account number to proceed: ");
        String accountNumberInput = sc.nextLine();
        // verify the account number
        // get the account object by given account number
        System.out.println("acccount type");
        SavingsAccount test = savingsAccountService.getAccountByID(1);

        System.out.println("Please enter what a to withdraw, b to deposit");
        String userInput = sc.nextLine();
        if ("a".equalsIgnoreCase(userInput)) {
            System.out.println("Please enter amount to withdraw: ");
            String withdrawalAmount = sc.nextLine();
            test.debit(BigDecimal.valueOf(Integer.parseInt(withdrawalAmount)));
        } else if ("b".equalsIgnoreCase(userInput)) {
            System.out.println("Please enter amount to withdraw: ");
            String withdrawalAmount = sc.nextLine();
            test.credit(BigDecimal.valueOf(Integer.parseInt(withdrawalAmount)));
        } else {

            //check balance
            operateUser(sc, customer);
        }
    }

    public void operateAdmin(Scanner sc, Admin admin) {
        System.out.println("a for create, b for edit, c for delete");
        String adminOperationInput = sc.nextLine();
        if ("a".equalsIgnoreCase(adminOperationInput)) {
            //get values and create the accounts
            savingsAccountService.createSavingsAccount(new SavingsAccount(0));
        } else if ("b".equalsIgnoreCase(adminOperationInput)) {
            //get the account by user and change
            System.out.println("select account type");
            System.out.println("select account number");

            //fetch the account

            SavingsAccount account1 = (SavingsAccount) savingsAccountService.getAccountByID(1);
            //Modify

            savingsAccountService.updateSavingsAccount(account1);
        } else if ("c".equalsIgnoreCase(adminOperationInput)) {
            //get the account by user and change
            //get the account by user and change
            System.out.println("select account type");
            System.out.println("select account number");

            //fetch the account

            SavingsAccount account1 = (SavingsAccount) savingsAccountService.getAccountByID(1);
            admin.deleteAccount(account1);
        } else {
            System.out.println("Wrong user input");
            operateAdmin(sc,  admin);
        }
    }



}
