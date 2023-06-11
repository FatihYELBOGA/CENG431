package UserFactory;

public class UserFactoryCreator {
	
	public UserAbstractFactory createUserAbstractFactory() {
		return new UserFactory();
	}

}
