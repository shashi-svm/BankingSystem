package banking;

import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {
	private LinkedHashMap<Long, Account> accounts=new LinkedHashMap<Long, Account>();
	private AtomicLong accountNumber=new AtomicLong();

	public Bank() {
	}

	private Account getAccount(Long accountNumber){
		// complete the function
        return accounts.get(accountNumber);
	}

	public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
		// complete the function
		CommercialAccount com=new CommercialAccount(company, accountNumber.addAndGet(1), pin, startingDeposit) ;
		accounts.put(com.getAccountNumber(), com);
        return com.getAccountNumber();
	}

	public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
		ConsumerAccount con=new ConsumerAccount(person, accountNumber.addAndGet(1), pin, startingDeposit);
		accounts.put(con.getAccountNumber(), con);
        return con.getAccountNumber();
	}

	public boolean authenticateUser(Long accountNumber, int pin) {
        return this.getAccount(accountNumber).validatePin(pin);
	}

	public double getBalance(Long accountNumber) {
        return this.getAccount(accountNumber).getBalance();
	}

	public void credit(Long accountNumber, double amount) {
		// complete the function
		this.getAccount(accountNumber).creditAccount(amount);
	}

	public boolean debit(Long accountNumber, double amount) {
		// complete the function
        return this.getAccount(accountNumber).debitAccount(amount);
	}
}
