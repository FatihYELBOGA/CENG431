package Account;

import Composite.AccountComponent;
import Enum.AccountType;
import Main.BankApplication;

public class ForeignCurrencyAccountEUR extends WithoutInterestAccount{

	public ForeignCurrencyAccountEUR(String accountName) {
		super(AccountType.FOREIGN_ACCOUNT_EUR,accountName);
	}

	@Override
	public double checkBalance() {
		return getBalance()*BankApplication.eurCurrencyRate;
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
			exchangeOperation(money,money*BankApplication.eurCurrencyRate, targetComponent);
		case FOREIGN_ACCOUNT_EUR:
			exchangeOperation(money,money, targetComponent);
		default:
			break;
		}
		return false;
	}

}
