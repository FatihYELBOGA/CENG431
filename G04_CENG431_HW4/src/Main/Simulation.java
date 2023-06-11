package Main;

import java.util.ArrayList;
import java.util.Scanner;

import Account.RegularAccount;
import AccountFactory.AccountAbstractFactory;
import AccountFactory.AccountFactoryCreator;
import AccountFactory.RegularAccountFactory;
import Composite.AccountComponent;
import Composite.AccountGroup;
import Enum.AccountType;
import Enum.FactoryType;
import User.Bank;
import User.IBank;
import User.IClient;
import UserFactory.UserAbstractFactory;
import UserFactory.UserFactoryCreator;
import Value.Fund;
import Value.Stock;

public class Simulation {
	
	private ArrayList<IClient> clients;
	
	private IClient chosenClient;
	
	private IBank bank;
	
	private UserFactoryCreator userFactoryCreator;
	
	private UserAbstractFactory userAbstractFactory;
	
	private AccountFactoryCreator accountFactoryCreator;

	private AccountAbstractFactory foreignCurrencyAccountFactory;
	
	private AccountAbstractFactory goldAccountFactory;

	private AccountAbstractFactory investmentAccountFactory;
	
	private AccountAbstractFactory regularAccountFactory;
	
	private Scanner scanner;
	
	public void init() {
		 scanner = new Scanner(System.in);

		awake();
		while (true) {
			printMainScreen();
			int mainSelection = scanner.nextInt();
			mainMenu(mainSelection);
		}
	}
	
	private void awake() {
		bank=new Bank();
		userFactoryCreator=new UserFactoryCreator();
		userAbstractFactory=userFactoryCreator.createUserAbstractFactory();
		
		accountFactoryCreator=new AccountFactoryCreator();

		foreignCurrencyAccountFactory = accountFactoryCreator.createAccount(FactoryType.FOREIGN_CURRENCY_ACCOUNT_FACTORY);
		goldAccountFactory = accountFactoryCreator.createAccount(FactoryType.GOLD_ACCOUNT_FACTORY);
		investmentAccountFactory = accountFactoryCreator.createAccount(FactoryType.INVESTMENT_ACCOUNT_FACTORY);
		regularAccountFactory =  accountFactoryCreator.createAccount(FactoryType.REGULAR_ACCOUNT_FACTORY);

		clients=new ArrayList<>();
	}
	
	private void mainMenu(int selection) {
		if(selection==0) {
			 System.exit(0);
		}
		else if(selection==1) {
			clientMenu();
		}
		else if(selection==2) {
			
			
			bankMenu();
		}
		else {
			printInvalidSelection();
		}
	}
	
	private void bankMenu() {
		while (true) {
			printBankScreen();
			int selection = scanner.nextInt();
			if(selection==0) {
				passTimeAction();
			}
			else if(selection==1) {
				createStockFund();
			}
			else if(selection==2) {
				changeValuesOfStockFund();
			}
			else if(selection==3){
				changeCurrencyInterestAction();
			}
			else if(selection==4){
				break;
			}
			else {
				printInvalidSelection();
			}
			
		}
	}
	
	private void createStockFund() {
		System.out.println("(1) Fund\n(2) Stock");
		int selection=scanner.nextInt();
		if(selection==1) {
			System.out.println("Fund List:");
			for (Fund fund : BankApplication.funds) {
				System.out.println(fund.getName());
			}
			System.out.println("Enter name");
			String fundName=scanner.next();
			System.out.println("Enter value");
			Double value=scanner.nextDouble();
			bank.createFundStock(true, fundName, value);
		}
		else if(selection==2) {
			System.out.println("Stock List:");
			for (Stock stock : BankApplication.stocks) {
				System.out.println(stock.getName());
			}
			System.out.println("Enter name");
			String stockName=scanner.next();
			System.out.println("Enter value");
			Double value=scanner.nextDouble();
			bank.createFundStock(false, stockName, value);
		}
		else {
			printInvalidSelection();
		}
	}
	
	private void changeValuesOfStockFund() {
		System.out.println("(1) Fund\n(2) Stock");
		int selection=scanner.nextInt();
		if(selection==1) {
			System.out.println("Fund List:");
			for (Fund fund : BankApplication.funds) {
				System.out.println("name: "+fund.getName()+" value: "+fund.getValue());
			}
			System.out.println("Enter name");
			String fundName=scanner.next();
			System.out.println("Enter value");
			Double value=scanner.nextDouble();
			for (Fund fund : BankApplication.funds) {
				if(fund.getName().equals(fundName)) {
					fund.setValue(value);
				}
			}
			
		}
		else if(selection==2) {
			System.out.println("Stock List:");
			for (Stock stock : BankApplication.stocks) {
				System.out.println(stock.getName());
			}
			System.out.println("Enter name");
			String stockName=scanner.next();
			System.out.println("Enter value");
			Double value=scanner.nextDouble();
			for (Stock stock : BankApplication.stocks) {
				if(stock.getName().equals(stockName)) {
					stock.setValue(value);
				}
			}
		}
		else {
			printInvalidSelection();
		}
	}
	
	private void clientMenu() {
		while(true) {
			printClientScreen();
			int selection = scanner.nextInt();
			if(selection==0) {
				createClientWithRegularAccount("try_account_1");
				System.out.println("Client "+clients.size()+" has been created.");
			}
			else if(selection==1) {
				break;
			}
			else {
				try {
					chosenClient=clients.get(selection-2);	
					System.out.println("Client "+(selection-1)+" has been selected.");
					clientActionsMenu();
				} catch (Exception e) {
					printInvalidSelection();
				}
			}
			
		}
	}
	
	private void clientActionsMenu() {
		while(true) {
			printClientActionsScreen();
			int selection=scanner.nextInt();
			if(selection==0) {
				createAccountClientAction();
			}
			else if(selection==1) {
				checkBalanceAccount();
			}
			else if(selection==2) {
				checkFutureBalanceAccount();
			}
			else if(selection==3) {
				depositMoney();
			}
			else if(selection==4) {
				exchangeMoney();
			}
			else {
				printInvalidSelection();
			}
		}
	}
	
	private void checkBalanceAccount() {
		System.out.println("Your accounts:");
		chosenClient.getAllAccountsAndAccountGroups();
		System.out.println("Enter account/group name that you want to see balance");
		String accountName=scanner.next();
		System.out.println(chosenClient.getAccountComponentByName(accountName).checkBalance());;
	}
	
	private void checkFutureBalanceAccount() {
		System.out.println("Your accounts:");
		chosenClient.getAllAccountsAndAccountGroups();
		System.out.println("Enter account/group name that you want to see balance");
		String accountName=scanner.next();
		System.out.println("Enter day:");
		int day=scanner.nextInt();
		System.out.println(chosenClient.getAccountComponentByName(accountName).checkFutureBalance(day));;
	}
	
	private void depositMoney() {
		System.out.println("Your accounts:");
		chosenClient.getAllAccountsAndAccountGroups();
		System.out.println("Enter account name that you want to deposit money");
		String accountName=scanner.next();
		System.out.println("Enter money:");
		double money=scanner.nextDouble();
		if(chosenClient.depositMoney(chosenClient.getAccountComponentByName(accountName), money)) {
			System.out.println("Money sent to your account");
		}
		else {
			System.out.println("You can only transfer money to regular account");
		}
	}
	
	private void exchangeMoney() {
		System.out.println("Your accounts:");
		chosenClient.getAllAccountsAndAccountGroups();
		System.out.println("Enter account name that you want to withdraw money");
		String accountNameSource=scanner.next();
		System.out.println("Enter account name that you want to send money");
		String accountNameTarget=scanner.next();
		System.out.println("Enter money");
		double money=scanner.nextDouble();
		if(chosenClient.exchangeMoney(chosenClient.getAccountComponentByName(accountNameSource), chosenClient.getAccountComponentByName(accountNameTarget), money)) {
			System.out.println("Money transfer successful");
		}
		else{
			System.out.println("Money transfer failed");
		}
	}
	
	private void createAccountClientAction() {
		System.out.println("Your accounts:");
		chosenClient.getAllAccountsAndAccountGroups();
		
		System.out.println("Enter account/group name , account/group name should be unique");
		String accountName=scanner.next();
		
		System.out.println("Enter root group name");
		String rootName=scanner.next();
		
		System.out.println("Choose the type of Account");
		AccountComponent accountComponent=null;

		printAccountTypes();
		
		int accountType=scanner.nextInt();
		if(accountType==0) {
			accountComponent=foreignCurrencyAccountFactory.createAccount(AccountType.FOREIGN_ACCOUNT_USD, accountName);
		}
		else if(accountType==1) {
			accountComponent=foreignCurrencyAccountFactory.createAccount(AccountType.FOREIGN_ACCOUNT_USD_INTEREST, accountName);
		}
		else if(accountType==2) {
			accountComponent=foreignCurrencyAccountFactory.createAccount(AccountType.FOREIGN_ACCOUNT_EUR, accountName);
		}
		else if(accountType==3) {
			accountComponent=foreignCurrencyAccountFactory.createAccount(AccountType.FOREIGN_ACCOUNT_EUR_INTEREST, accountName);
		}
		else if(accountType==4) {
			accountComponent=goldAccountFactory.createAccount(AccountType.GOLD_ACCOUNT, accountName);
		}
		else if(accountType==5) {
			accountComponent=	goldAccountFactory.createAccount(AccountType.GOLD_ACCOUNT_INTEREST, accountName);
		}
		else if(accountType==6) {
			accountComponent=regularAccountFactory.createAccount(AccountType.REGULAR_ACCOUNT, accountName);
		}
		else if(accountType==7) {
			accountComponent=regularAccountFactory.createAccount(AccountType.REGULAR_ACCOUNT_INTEREST, accountName);
		}
		else if(accountType==8) {
			accountComponent=investmentAccountFactory.createAccount(AccountType.INVESTMENT_ACCOUNT, accountName);
		}
		else if(accountType==9) {
			accountComponent=new AccountGroup(accountName);
		}
		else {
			printInvalidSelection();
		}
		
		if(createAccount(accountName, chosenClient.getAccountComponentByName(rootName), accountComponent)) {
				System.out.println("Account has been created");
		}
		else {
			System.out.println("Error account can not be created");
		}
		
	}
	
	private boolean createAccount(String accountName,AccountComponent rootComponent,AccountComponent accountComponent) {
		if(accountComponent.equals(null)) {

			return false;
		}
		return chosenClient.createAccount(accountComponent, rootComponent, accountName);
	}
	
	private void printAccountTypes() {
		System.out.println("(0) USD Currency");
		System.out.println("(1) USD Interest");
		System.out.println("(2) EUR Currency");
		System.out.println("(3) EUR Interest");
		System.out.println("(4) XAU Currency");
		System.out.println("(5) XAU Interest");
		System.out.println("(6) TRY Interest");
		System.out.println("(7) TRY Currency");
		System.out.println("(8) Investment");
		System.out.println("(9) Account Group");


	}
	
	private void printClientScreen() {
		System.out.println("(0) Create a new client");
		System.out.println("(1) Go Back");

		int i=2;
		for (IClient iClient : clients) {
			System.out.println("("+i+") Client "+(i-1));
			i++;
		}
	}
	
	private void printMainScreen() {
		System.out.println("Welcome to bank simulation");
		System.out.println("(0) Exit");
		System.out.println("(1) Select Client");
		System.out.println("(2) Select Bank");
	}
	
	private void printInvalidSelection() {
		System.out.println("Invalid input");
	}
	
	private void printBankScreen() {
		System.out.println("(0) Change Day");
		System.out.println("(1) Create Stock/Fund");
		System.out.println("(2) Change values of Stock/Fund");
		System.out.println("(3) Change currency/interest rate");
		System.out.println("(4) Go back");
	}
	
	private void printClientActionsScreen() {
		System.out.println("(0) Create an Account/Account Group");
		System.out.println("(1) Check Balance of Account/Account Group");
		System.out.println("(2) Check Future Balance of Account/Account Group");
		System.out.println("(3) Deposit Money");
		System.out.println("(4) Exchange Money Between Accounts");
	}
	
	private void passTimeAction() {
		System.out.println("Current day is "+BankApplication.day);
		System.out.println("Enter the number of days you want to pass");
		int day=scanner.nextInt();
		bank.passTime(day);
	}
	
	private void changeCurrencyInterestAction() {
		printBankInterestCurrenyScreen();
		int currencySelection=scanner.nextInt();
		if(currencySelection==0) {
			System.out.println("Current USD currency is "+BankApplication.usdCurrencyRate);
			System.out.println("Enter new value");
			double usdCurrency=scanner.nextDouble();
			bank.setUsdCurrencyRate(usdCurrency);
		}
		else if(currencySelection==1) {
			System.out.println("Current USD Interest is "+BankApplication.usdInterestRate);
			System.out.println("Enter new value");
			double usdInterest=scanner.nextDouble();
			bank.setUsdInterestRate(usdInterest);
		}
		else if(currencySelection==2) {
			System.out.println("Current EUR currency is "+BankApplication.eurCurrencyRate);
			System.out.println("Enter new value");
			double eurCurrency=scanner.nextDouble();
			bank.setEurCurrencyRate(eurCurrency);
		}
		else if(currencySelection==3) {
			System.out.println("Current EUR Interest is "+BankApplication.eurInterestRate);
			System.out.println("Enter new value");
			double eurInterest=scanner.nextDouble();
			bank.setEurInterestRate(eurInterest);
		}
		else if(currencySelection==4) {
			System.out.println("Current XAU currency is "+BankApplication.xauCurrencyRate);
			System.out.println("Enter new value");
			double xauCurrency=scanner.nextDouble();
			bank.setXauCurrencyRate(xauCurrency);
		}
		else if(currencySelection==5) {
			System.out.println("Current XAU Interest is "+BankApplication.xauInterestRate);
			System.out.println("Enter new value");
			double xauInterest=scanner.nextDouble();
			bank.setXauInterestRate(xauInterest);
		}
		else if(currencySelection==6) {
			System.out.println("Current TRY Interest is "+BankApplication.tryInterestRate);
			System.out.println("Enter new value");
			double tryInterest=scanner.nextDouble();
			bank.setTryInterestRate(tryInterest);
		}
		else {
			printInvalidSelection();
		}
	}
	
	private void printBankInterestCurrenyScreen() {
		System.out.println("(0) USD Currency");
		System.out.println("(1) USD Interest");
		System.out.println("(2) EUR Currency");
		System.out.println("(3) EUR Interest");
		System.out.println("(4) XAU Currency");
		System.out.println("(5) XAU Interest");
		System.out.println("(6) TRY Interest");
	}
	
	
	
	private IClient createClientWithRegularAccount( String accountName) {
		AccountComponent accountGroup=new AccountGroup("main");
		
		AccountComponent regularAccountTRY=regularAccountFactory.createAccount(AccountType.REGULAR_ACCOUNT, accountName);
		((AccountGroup)accountGroup).addComponent(regularAccountTRY);
		IClient client=userAbstractFactory.createUser(accountGroup);
		clients.add(client);
		return client;
	}
	
	

}
