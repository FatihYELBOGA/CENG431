package User;

import Composite.AccountComponent;

public interface IClient {
	
	public void getAllAccountsAndAccountGroups();
	
	public AccountComponent getAccountComponentByName(String accountName);
	
	public boolean createAccount(AccountComponent accountComponent,AccountComponent rootComponent,String accountName);
	
	public double checkBalance(AccountComponent accountComponent);
	
	public double checkFutureBalance(int day, AccountComponent accountComponent);
	
	public boolean depositMoney(AccountComponent accountComponent,double money);
	
	public boolean exchangeMoney(AccountComponent sourceComponent,
			AccountComponent receiverComponent,double money);
}
