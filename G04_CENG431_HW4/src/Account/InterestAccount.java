package Account;

import Composite.AccountComponent;
import Enum.AccountType;
import Main.BankApplication;

public abstract class InterestAccount extends Account{
	
	private int lastExchangeDay=0;
	
	public InterestAccount(AccountType accountType,String accountName) {
		super(accountType,accountName);
	}
	
	public void setLastExchangeDay(int day) {
		this.lastExchangeDay=day;
	}
	
	public int getLastExchangeDay() {
		return lastExchangeDay;
	}
	
	public boolean isDayAvailable() {
		return !(BankApplication.day==lastExchangeDay);
	}
	
	public boolean interestExchangeOperation(double money,AccountComponent targetComponent) {
		setBalance(-money);
		targetComponent.setBalance(money);
		setLastExchangeDay(BankApplication.day);
		return true;
	}

	

}
