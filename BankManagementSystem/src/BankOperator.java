import com.bank.system.BankOperatorGui;
import com.bank.system.BankOperatorService;
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

        BankOperatorGui bankOperatorGui = new BankOperatorGui();

        Thread t1 = new Thread(bankOperatorGui);
        Thread t2 = new Thread(bankOperatorGui);

        t1.start();
        t2.start();

    }
}
