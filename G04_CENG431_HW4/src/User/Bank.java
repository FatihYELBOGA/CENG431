package User;

import Main.BankApplication;
import Value.Fund;
import Value.Stock;

public class Bank extends User implements IBank {
	
	private BankApplication bankApplication;

	@Override
	public void setEurCurrencyRate(double eurCurrencyRate) {
		BankApplication.eurCurrencyRate=eurCurrencyRate;
		
	}

	@Override
	public void setEurInterestRate(double eurInterestRate) {
		BankApplication.eurInterestRate=eurInterestRate;
		
	}

	@Override
	public void setUsdCurrencyRate(double usdCurrencyRate) {
		BankApplication.usdCurrencyRate=usdCurrencyRate;
		
	}

	@Override
	public void setUsdInterestRate(double usdInterestRate) {
		BankApplication.usdInterestRate=usdInterestRate;
		
	}

	@Override
	public void passTime(int day) {
		BankApplication.day=day;
	}

	@Override
	public void setXauInterestRate(double xauInterestRate) {
		BankApplication.xauInterestRate=xauInterestRate;
		
	}

	@Override
	public void setXauCurrencyRate(double xauCurrencyRate) {
		BankApplication.xauCurrencyRate=xauCurrencyRate;

		
	}

	@Override
	public void setTryInterestRate(double tryInterestRate) {
		BankApplication.tryInterestRate=tryInterestRate;
		
	}

	@Override
	public void createFundStock(boolean isFund, String name, double value) {
		if(isFund) {
			BankApplication.funds.add(new Fund(name, value));
		}
		else {
			BankApplication.stocks.add(new Stock(name, value));
		}
		
	}

	@Override
	public void changeValueOfFundStockByName(boolean isFund, String name, double value) {
		if(isFund) {
			for (Fund fund : BankApplication.funds) {
				if(fund.getName().equals(name)) {
					fund.setValue(value);
				}
			}
		}
		else {
			for (Stock stock : BankApplication.stocks) {
				if(stock.getName().equals(name)) {
					stock.setValue(value);
				}
			}
		}
		
	}

}
