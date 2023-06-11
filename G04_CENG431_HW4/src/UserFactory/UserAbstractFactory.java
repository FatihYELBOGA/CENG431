package UserFactory;

import Composite.AccountComponent;
import User.Client;
import User.IClient;

public abstract class UserAbstractFactory {

	public abstract IClient createUser(AccountComponent accountComponent);
}
