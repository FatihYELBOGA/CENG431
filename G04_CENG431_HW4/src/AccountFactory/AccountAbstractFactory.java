package AccountFactory;

import Account.Account;
import Composite.AccountComponent;
import Enum.AccountType;

public abstract class AccountAbstractFactory {
	
	public abstract Account createAccount(AccountType accountType,String accountName);

}
