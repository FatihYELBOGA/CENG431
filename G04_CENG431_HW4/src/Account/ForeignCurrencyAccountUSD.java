package Account;

import Composite.AccountComponent;
import Enum.AccountType;
import Main.BankApplication;

public class ForeignCurrencyAccountUSD extends WithoutInterestAccount{

	public ForeignCurrencyAccountUSD(String accountName) {
		super(AccountType.FOREIGN_ACCOUNT_USD,accountName);
	}

	@Override
	public double checkBalance() {
		return getBalance()*BankApplication.usdCurrencyRate;
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
			exchangeOperation(money,money*BankApplication.usdCurrencyRate, targetComponent);
		case FOREIGN_ACCOUNT_USD:
			exchangeOperation(money,money, targetComponent);
		default:
			break;
		}
		return false;
	}
}
