package banking;

import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {

	private final LinkedHashMap<Long, Account> accounts;
	private final AtomicInteger accountNumberGenerator = new AtomicInteger(1000);

	public Bank() {
		accounts = new LinkedHashMap<>();
	}

	private Account getAccount(Long accountNumber) {
		if(accounts.containsKey(accountNumber)) {
			return accounts.get(accountNumber);
		}
        throw new IllegalArgumentException("Account does not exist");
	}

	public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
		long accountNumber = accountNumberGenerator.incrementAndGet();
		Account commercialAccount = new CommercialAccount(company, accountNumber, pin, startingDeposit);
		accounts.put(accountNumber, commercialAccount);
        return commercialAccount.getAccountNumber();
	}

	public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
		long accountNumber = accountNumberGenerator.incrementAndGet();
		Account consumerAccount = new ConsumerAccount(person, accountNumber, pin, startingDeposit);
		accounts.put(accountNumber, consumerAccount);
        return consumerAccount.getAccountNumber();
	}

	public boolean authenticateUser(Long accountNumber, int pin) {
		if(accounts.containsKey(accountNumber)) {
			return accounts.get(accountNumber).validatePin(pin);
		}
        return false;
	}

	public double getBalance(Long accountNumber) {
		if(accounts.containsKey(accountNumber)) {
			return accounts.get(accountNumber).getBalance();
		}
		return -1L;
	}

	public void credit(Long accountNumber, double amount) {
		if(accounts.containsKey(accountNumber)) {
			accounts.get(accountNumber).creditAccount(amount);
		}
	}

	public boolean debit(Long accountNumber, double amount) {
		if(accounts.containsKey(accountNumber)) {
			return accounts.get(accountNumber).debitAccount(amount);
		}
		return false;
	}
}
