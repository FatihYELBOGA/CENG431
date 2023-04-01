package User;

import Languages.Language;

public class User implements IUser{

	private Language choosenLanguage;
	
	private String username;
	
	private String password;
	
	private int point;
	
	private int numberOfDaysStreak;
	
	private int numberOfQuizzesTake;
	
	private int currentUnitNumber;
	
	public User(Language choosenLanguage,String username,
			String password,int numberOfDaysStreak,int numberOfQuizzesTake) {
		this.choosenLanguage=choosenLanguage;
		this.username=username;
		this.password=password;
		this.numberOfDaysStreak=numberOfDaysStreak;
		this.numberOfQuizzesTake=numberOfQuizzesTake;
		this.point=0;
	}

	public Language getChoosenLanguage() {
		return choosenLanguage;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public int getPoint() {
		return point;
	}
	
	public int getNumberOfDaysStreak() {
		return numberOfDaysStreak;
	}
	
	public int getNumberOfQuizzesTake() {
		return numberOfQuizzesTake;
	}
}

