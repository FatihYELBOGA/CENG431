package Composite;

import java.util.ArrayList;

import Enum.AccountType;

public class AccountGroup implements AccountComponent{

	private ArrayList<AccountComponent> components;

	private String accountName;
	
	public AccountGroup(String accountName) {
		components=new ArrayList<>();
		this.accountName=accountName;
	}
	
	@Override
	public String getAccountName() {
		return accountName;
	}
	
	@Override
	public boolean isAccount() {
		return false;
	}

	@Override
	public double checkBalance() {
		double total=0;
		for (AccountComponent accountComponent : components) {
			total+=accountComponent.checkBalance();
		}
		return total;
	}
	

	@Override
	public double checkFutureBalance(int day) {
		double total=0;
		for (AccountComponent accountComponent : components) {
			total+=accountComponent.checkFutureBalance(day);
		}
		return total;
	}
	
	public void addComponent(AccountComponent accountComponent) {
		components.add(accountComponent);
	}
	
	public ArrayList<AccountComponent> getComponents() {
		return this.components;
	}

	@Override
	public boolean depositMoney(double money) {
		return false;
	}

	@Override
	public AccountType getAccountType() {
		return null;
	}

	@Override
	public boolean transferMoney(double money, AccountComponent targetComponent) {
		return false;
	}

	@Override
	public void setBalance(double money) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AccountComponent findAccountByName(String accountName) {
		for (AccountComponent accountComponent : components) {
			if(accountComponent.getAccountName().equals(accountName)) {
				return accountComponent;
			}
		}
		return null;
	}
	
	public String toString() {
		for (AccountComponent accountComponent : components) {
			accountComponent.toString();
		}
		System.out.println("Account group: "+this.accountName);
		return "Account group: "+this.accountName;
	}

	
}
