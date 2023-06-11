package Composite;

import Enum.AccountType;

public interface AccountComponent {
	
	public boolean isAccount();
	
	public AccountType getAccountType();
	
	public double checkBalance();
	
	public double checkFutureBalance(int day);
	
	public boolean transferMoney(double money,AccountComponent targetComponent);

	public boolean depositMoney(double money);
	
	public void setBalance(double money);

	public String getAccountName();
	
	public AccountComponent findAccountByName(String accountName);
}
