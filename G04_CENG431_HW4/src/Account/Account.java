package Account;

import Composite.AccountComponent;
import Enum.AccountType;

public abstract class Account implements AccountComponent{

	private AccountType accountType;

	private String accountName;
	
	private double balance;
	
	public Account(AccountType accountType,String accountName) {
		this.accountType=accountType;
		this.accountName=accountName;
	}
	
	@Override
	public String getAccountName() {
		return accountName;
	}
	
	public boolean isMoneyEnough(double money) {
		if(money<=balance) {
			return true;
		}
		return false;
	}
	
	@Override
	public AccountType getAccountType() {
		return accountType;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double money) {
		this.balance+=money;
	}
	
	@Override
	public boolean isAccount() {
		return true;
	}



	@Override
	public boolean depositMoney(double money) {
		if(accountType.equals(AccountType.REGULAR_ACCOUNT)) {
			this.balance+=money;
			return true;
		}
		return false;
	}

	@Override
	public double checkBalance() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double checkFutureBalance(int day) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean transferMoney(double money, AccountComponent targetComponent) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public AccountComponent findAccountByName(String accountName) {
		if(this.accountName.equals(accountName)) {
			return this;
		}
		return null;
	}

	public String toString() {
		System.out.println("Account named: "+this.accountName);
		return "Account named: "+this.accountName;
	}
}
