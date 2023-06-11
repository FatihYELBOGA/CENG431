package User;

import java.util.ArrayList;

import Composite.AccountComponent;
import Composite.AccountGroup;
import Main.BankApplication;

public class Client extends User implements IClient{

	
	private AccountComponent accountComponent;
	
	private ArrayList<String> accountNames;
	
	public Client(AccountComponent accountComponent) {
		this.accountComponent=accountComponent;
		this.accountNames=new ArrayList<>();
	}

	public AccountComponent getAccountComponent() {
		return accountComponent;
	}
	
	@Override
	public double checkBalance(AccountComponent accountComponent) {
		return accountComponent.checkBalance();
	}

	@Override
	public double checkFutureBalance(int day, AccountComponent accountComponent) {
		return accountComponent.checkFutureBalance(day);
	}

	@Override
	public boolean depositMoney(AccountComponent accountComponent, double money) {
		return accountComponent.depositMoney(money);
	}

	@Override
	public boolean exchangeMoney(AccountComponent sourceComponent, AccountComponent receiverComponent, double money) {
		return sourceComponent.transferMoney(money, receiverComponent);
	}

	private boolean isAccountNameExist(String accountName) {
		if(this.accountComponent.getAccountName().equals(accountName)) {
			return true;
		}
		for (AccountComponent accountComponent : ((AccountGroup)this.accountComponent).getComponents()) {
			if(accountComponent.getAccountName().equals(accountName)){
				return true;
			}
		}

		return false;
	}

	@Override
	public boolean createAccount(AccountComponent accountComponent, AccountComponent rootComponent, String accountName) {

		if(!rootComponent.getClass().getSimpleName().equals("AccountGroup")) {

			return false;
		}
		if(!isAccountNameExist(accountName)) {

			((AccountGroup)rootComponent).addComponent(accountComponent);
			accountNames.add(accountName);
			return true;
		}

		return false;
		
	}

	@Override
	public void getAllAccountsAndAccountGroups() {
		this.accountComponent.toString();
	}

	@Override
	public AccountComponent getAccountComponentByName(String accountName) {
		if(this.accountComponent.getAccountName().equals(accountName)) {
			return this.accountComponent;
		}
		for (AccountComponent accountComponent :((AccountGroup)accountComponent).getComponents() ) {
			if(accountComponent.getAccountName().equals(accountName)) {
				return accountComponent;
			}
		}
		return null;
	}
	
	
	
	
	
	


	
	
	
}
