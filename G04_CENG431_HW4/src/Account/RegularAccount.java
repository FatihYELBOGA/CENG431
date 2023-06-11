package Account;

import Composite.AccountComponent;
import Enum.AccountType;
import Main.BankApplication;

public class RegularAccount extends WithoutInterestAccount{

	
	public RegularAccount(String accountName) {
		super(AccountType.REGULAR_ACCOUNT,accountName);
	}

	@Override
	public double checkBalance() {
		return super.getBalance();
	}

	@Override
	public double checkFutureBalance(int day) {
		return checkBalance();
	}

	@Override
	public boolean transferMoney(double money, AccountComponent targetComponent) {
		if(!isMoneyEnough(money)) {
			return false;
		}
		switch (targetComponent.getAccountType()) {
		case REGULAR_ACCOUNT:
			exchangeOperation(money,money, targetComponent);
		case FOREIGN_ACCOUNT_EUR:
			exchangeOperation(money,money/(BankApplication.eurCurrencyRate), targetComponent);
		case FOREIGN_ACCOUNT_USD:
			exchangeOperation(money,money/(BankApplication.usdCurrencyRate), targetComponent);
		case GOLD_ACCOUNT:
			exchangeOperation(money,money/(BankApplication.xauCurrencyRate), targetComponent);
		case INVESTMENT_ACCOUNT:
			//TODO
			return true;
		default:
			break;
		}
		return false;
	}

}
