package Account;

import Composite.AccountComponent;
import Enum.AccountType;
import Main.BankApplication;

public class ForeignCurrencyAccountEURInterest extends InterestAccount{

	public ForeignCurrencyAccountEURInterest(String accountName) {
		super(AccountType.FOREIGN_ACCOUNT_EUR_INTEREST,accountName);
	}

	@Override
	public double checkBalance() {
		return getBalance()*BankApplication.eurCurrencyRate;
	}

	@Override
	public double checkFutureBalance(int day) {
		return BankApplication.calculateInterest(day, BankApplication.eurInterestRate, getBalance());
	}

	@Override
	public boolean transferMoney(double money, AccountComponent targetComponent) {
		if(!isMoneyEnough(money) || !isDayAvailable()) {
			return false;
		}
		switch (targetComponent.getAccountType()) {
		case FOREIGN_ACCOUNT_EUR_INTEREST:
			return interestExchangeOperation(money,targetComponent);
		default:
			return false;
		}
		
	}

}
