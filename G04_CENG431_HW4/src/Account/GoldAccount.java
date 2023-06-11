package Account;

import Composite.AccountComponent;
import Enum.AccountType;
import Main.BankApplication;

public class GoldAccount extends WithoutInterestAccount{

	public GoldAccount( String accountName) {
		super(AccountType.GOLD_ACCOUNT,accountName);
	}

	@Override
	public double checkBalance() {
		return getBalance()*BankApplication.xauCurrencyRate;
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
			exchangeOperation(money,money*BankApplication.xauCurrencyRate, targetComponent);
		case GOLD_ACCOUNT:
			exchangeOperation(money,money, targetComponent);
		default:
			break;
		}
		return false;
	}

}
