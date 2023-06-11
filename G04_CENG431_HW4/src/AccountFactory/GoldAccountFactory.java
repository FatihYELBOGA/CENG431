package AccountFactory;

import Account.Account;
import Account.GoldAccount;
import Account.GoldAccountInterest;
import Enum.AccountType;

public class GoldAccountFactory extends AccountAbstractFactory{

	@Override
	public Account createAccount(AccountType accountType, String accountName) {
		if(accountType.equals(AccountType.GOLD_ACCOUNT)) {
			return new GoldAccount(accountName);
		}
		else if(accountType.equals(AccountType.GOLD_ACCOUNT_INTEREST)) {
			return new GoldAccountInterest(accountName);
		}
		return null;
	}

	

}
