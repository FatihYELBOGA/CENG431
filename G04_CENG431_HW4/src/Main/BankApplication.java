package Main;

import java.util.ArrayList;

import Value.Fund;
import Value.Stock;

public class BankApplication {
	
   public static double tryInterestRate=40;
	
   public  static double eurCurrencyRate=25;
	
   public static double eurInterestRate=2;
	
   public static double usdCurrencyRate=23;

   public static double usdInterestRate=1.5;
	
   public static double xauCurrencyRate=1450;
   
   public static double xauInterestRate=3;

   public static int day=0;
   
   public static ArrayList<Stock> stocks=new ArrayList<>();
   
   public static ArrayList<Fund> funds=new ArrayList<>();
   
   public static double calculateInterest(int day,double interestRate,double balance) {
	  return balance+(balance*((BankApplication.eurInterestRate/100)/365)*day);
   }
}
