package User;

public interface IBank {
	
	public void setTryInterestRate(double tryInterestRate);

	public void setEurCurrencyRate(double eurCurrencyRate);
	
	public void setEurInterestRate(double eurInterestRate);
	
	public void setUsdCurrencyRate(double usdCurrencyRate);
	
	public void setUsdInterestRate(double usdInterestRate);
	
	public void setXauInterestRate(double xauInterestRate);
	
	public void setXauCurrencyRate(double xauCurrencyRate);

	public void passTime(int day);
	
	public void createFundStock(boolean isFund,String name,double value);
	
	public void changeValueOfFundStockByName(boolean isFund,String name,double value);
}
