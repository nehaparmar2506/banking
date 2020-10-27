package banking;

import java.util.LinkedHashMap;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {
	private LinkedHashMap<Long, Account> accounts;
	private long id =0;
	public Bank() {
		// complete the function
		accounts = new LinkedHashMap<>();
	}

	private Account getAccount(Long accountNumber) {
		// complete the function
        return accounts.get(accountNumber);
	}

	public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
		long accNo = generateAccount();
		CommercialAccount consumerAccount = new CommercialAccount(company,accNo, pin , startingDeposit);
		accounts.put(accNo,consumerAccount);
		return accNo;
	}

	public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
		long accNo = generateAccount();
		ConsumerAccount consumerAccount = new ConsumerAccount(person,accNo, pin , startingDeposit);
		accounts.put(accNo,consumerAccount);
        return accNo;
	}

	public boolean authenticateUser(Long accountNumber, int pin) {
		// complete the function
		Account acc = accounts.get(accountNumber);
		return  acc.validatePin(pin);
	}

	public double getBalance(Long accountNumber) {
		// complete the function
		Account acc = accounts.get(accountNumber);
        return acc.getBalance();
	}

	public void credit(Long accountNumber, double amount) {
		// complete the function
		Account acc = accounts.get(accountNumber);
		synchronized(Account.class) {

			acc.creditAccount(amount);
		}
	}

	public boolean debit(Long accountNumber, double amount) {
		// complete the function
		Account acc = accounts.get(accountNumber);

		synchronized(Account.class) {

			return acc.debitAccount(amount);
		}
	}

	private long generateAccount(){
		return  id ++;
	}
}
