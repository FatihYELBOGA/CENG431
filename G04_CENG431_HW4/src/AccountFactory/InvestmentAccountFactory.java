package AccountFactory;

import Account.Account;
import Account.RegularAccount;
import Account.RegularAccountInterest;
import Enum.AccountType;

public class InvestmentAccountFactory extends AccountAbstractFactory{

	@Override
	public Account createAccount(AccountType accountType, String accountName) {
		if(accountType.equals(AccountType.INVESTMENT_ACCOUNT)) {
			return new RegularAccount(accountName);
		}
		return null;
	}

	
}
