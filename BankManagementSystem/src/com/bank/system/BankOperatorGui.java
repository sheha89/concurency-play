package com.bank.system;

import com.bank.system.model.user.Admin;
import com.bank.system.model.user.Customer;
import com.bank.system.model.user.User;

import java.util.Scanner;

public class BankOperatorGui implements Runnable{


    @Override
    public void run() {

        BankOperatorService bankOperatorGui = new BankOperatorService();
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        User user = bankOperatorGui.authenticateUser(sc);
        if (user instanceof Customer) {
            System.out.println("Welcome to admin panel");
            bankOperatorGui.operateUser(sc, (Customer) user);
        } else if (user instanceof Admin) {
            System.out.println("Welcome to customer panel");
            bankOperatorGui.operateAdmin(sc, (Admin) user);
        }
    }
}
