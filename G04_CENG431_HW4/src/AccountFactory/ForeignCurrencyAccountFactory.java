package AccountFactory;

import Account.Account;
import Account.ForeignCurrencyAccountEUR;
import Account.ForeignCurrencyAccountEURInterest;
import Account.ForeignCurrencyAccountUSD;
import Account.ForeignCurrencyAccountUSDInterest;
import Enum.AccountType;

public class ForeignCurrencyAccountFactory extends AccountAbstractFactory{

	@Override
	public Account createAccount(AccountType accountType,String accountName) {
		if(accountType.equals(AccountType.FOREIGN_ACCOUNT_EUR)) {
			return new ForeignCurrencyAccountEUR(accountName);
		}
		else if(accountType.equals(AccountType.FOREIGN_ACCOUNT_EUR_INTEREST)) {
			return new ForeignCurrencyAccountEURInterest(accountName);
		}
		else if(accountType.equals(AccountType.FOREIGN_ACCOUNT_USD)) {
			return new ForeignCurrencyAccountUSD(accountName);
		}
		else if(accountType.equals(AccountType.FOREIGN_ACCOUNT_USD_INTEREST)) {
			return new ForeignCurrencyAccountUSDInterest(accountName);
		}
		return null;
	}

}
