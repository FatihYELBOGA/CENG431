package UserFactory;

import Composite.AccountComponent;
import User.Client;
import User.IClient;

public class UserFactory extends UserAbstractFactory{

	@Override
	public IClient createUser(AccountComponent accountComponent) {
		return new Client(accountComponent);
	}

}
