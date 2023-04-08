package User;

import Languages.Language;
import Leagues.BronzeLeague;
import Leagues.League;
import Questions.Question;
import Quizzes.Quiz;
import Random.RandomGenerator;

public class User implements IUser{
	
	private League currentLeague;

	private Language choosenLanguage;
	
	private String username;
	
	private String password;
	
	private int point;
	
	private int numberOfDaysStreak;
	
	private int numberOfQuizzesTake;
	
	private int currentUnitNumber;
	
	private int quizLimit;
	
	public User(Language choosenLanguage,League league,String username,
			String password,int numberOfDaysStreak,int numberOfQuizzesTake) {
		this.choosenLanguage=choosenLanguage;
		this.username=username;
		this.password=password;
		this.numberOfDaysStreak=numberOfDaysStreak;
		this.numberOfQuizzesTake=numberOfQuizzesTake;
		this.quizLimit=numberOfQuizzesTake;
		this.currentUnitNumber=0;
		this.point=0;
		this.currentLeague=league;
	}
	
	public League getCurrentLeague() {
		return currentLeague;
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
	
	public int getQuizLimit() {
		return quizLimit;
	}
	
	public int getNumberOfDaysStreak() {
		return numberOfDaysStreak;
	}
	
	public int getNumberOfQuizzesTake() {
		return numberOfQuizzesTake;
	}
	
	public int getCurrentUnitNumber() {
		return currentUnitNumber;
	}

	public void setCurrentUnitNumber(int currentUnitNumber) {
		this.currentUnitNumber = currentUnitNumber;
	}
	
	@Override
	public boolean isValidQuizLimit(int limit) {
		if(limit>0) {
			return true;
		}
		return false;
	}


	@Override
	public boolean solveQuiz(Quiz quiz,RandomGenerator randomGenerator) {
		if(!isValidQuizLimit(quizLimit)) {
			return false;
		}
		for (Question question : quiz.getQuestions()) {
			int isWin=randomGenerator.generateRandomInterval(0, 1);
			if(isWin==0) {
			}
			else {
				point+=question.getPoint();
			}
		}
		this.quizLimit-=1;
		return true;
	}
	
	@Override
	public String toString() {
		String string=username+";"+password+";"+choosenLanguage.getName()+";"+currentUnitNumber+";"+numberOfQuizzesTake+";"+point;

		return string;
	}
}

