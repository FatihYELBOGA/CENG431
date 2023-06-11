package Account;

import Composite.AccountComponent;
import Enum.AccountType;
import Main.BankApplication;

public class GoldAccountInterest extends InterestAccount{

	public GoldAccountInterest(String accountName) {
		super(AccountType.GOLD_ACCOUNT_INTEREST,accountName);
	}

	@Override
	public double checkBalance() {
		return getBalance();
	}

	@Override
	public double checkFutureBalance(int day) {
		return BankApplication.calculateInterest(day, BankApplication.xauInterestRate, getBalance());

	}

	@Override
	public boolean transferMoney(double money, AccountComponent targetComponent) {
		if(!isMoneyEnough(money) || !isDayAvailable()) {
			return false;
		}
		switch (targetComponent.getAccountType()) {
		case GOLD_ACCOUNT_INTEREST:
			return interestExchangeOperation(money,targetComponent);
		default:
			return false;

		}
	}

}
