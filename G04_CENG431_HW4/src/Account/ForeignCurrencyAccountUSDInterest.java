package Account;

import Composite.AccountComponent;
import Enum.AccountType;
import Main.BankApplication;

public class ForeignCurrencyAccountUSDInterest extends InterestAccount{

	public ForeignCurrencyAccountUSDInterest( String accountName) {
		super(AccountType.FOREIGN_ACCOUNT_USD_INTEREST,accountName);
	}

	@Override
	public double checkBalance() {
		return getBalance();
	}

	@Override
	public double checkFutureBalance(int day) {
		return BankApplication.calculateInterest(day, BankApplication.usdInterestRate, getBalance());

	}

	@Override
	public boolean transferMoney(double money, AccountComponent targetComponent) {
		if(!isMoneyEnough(money) || !isDayAvailable()) {
			return false;
		}
		switch (targetComponent.getAccountType()) {
		case FOREIGN_ACCOUNT_USD_INTEREST:
			return interestExchangeOperation(money,targetComponent);
		default:
			return false;

		}
	}


}
