package Account;

import Composite.AccountComponent;
import Enum.AccountType;

public abstract class WithoutInterestAccount extends Account{

	public WithoutInterestAccount(AccountType accountType,String accountName) {
		super(accountType,accountName);
	}
	
	public boolean exchangeOperation(double money,double calculatedMoney,AccountComponent targetComponent) {
		setBalance(-money);
		targetComponent.setBalance(calculatedMoney);
		return true;
	}

}
