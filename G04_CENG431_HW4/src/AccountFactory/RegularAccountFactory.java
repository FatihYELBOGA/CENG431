package AccountFactory;

import Account.Account;
import Account.RegularAccount;
import Account.RegularAccountInterest;
import Enum.AccountType;

public class RegularAccountFactory extends AccountAbstractFactory{

	@Override
	public Account createAccount(AccountType accountType, String accountName) {
		if(accountType.equals(AccountType.REGULAR_ACCOUNT)) {
			return new RegularAccount(accountName);
		}
		else if(accountType.equals(AccountType.REGULAR_ACCOUNT_INTEREST)) {
			return new RegularAccountInterest(accountName);
		}
		return null;
	}

}
