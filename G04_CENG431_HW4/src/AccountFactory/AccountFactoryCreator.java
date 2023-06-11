package AccountFactory;


import Enum.FactoryType;

public class AccountFactoryCreator {
	
	public AccountAbstractFactory createAccount(FactoryType factoryType) {
		if(factoryType.equals(FactoryType.REGULAR_ACCOUNT_FACTORY)) {
			return new RegularAccountFactory();
		}
		else if(factoryType.equals(FactoryType.FOREIGN_CURRENCY_ACCOUNT_FACTORY)) {
			return new ForeignCurrencyAccountFactory();
		}
		else if(factoryType.equals(FactoryType.GOLD_ACCOUNT_FACTORY)) {
			return new GoldAccountFactory();
		}
		else if(factoryType.equals(FactoryType.INVESTMENT_ACCOUNT_FACTORY)) {
			return new InvestmentAccountFactory();
		}
		return null;
	}
}
