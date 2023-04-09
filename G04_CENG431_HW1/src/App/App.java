package App;

import java.util.ArrayList;

import Languages.Language;
import Languages.LanguageName;
import Leagues.League;
import Leagues.LeagueName;
import Quizzes.Quiz;
import Random.RandomGenerator;
import Units.Unit;
import User.User;

public class App {
	
	
	public void startApp(ArrayList<User> users, ArrayList<Language> languages,ArrayList<League> leagues,RandomGenerator randomGenerator) {
		solveQuizzes(users,languages,randomGenerator);
		arrangeLeagues(leagues);
	}
	
	private void solveQuizzes(ArrayList<User> users, ArrayList<Language> languages,RandomGenerator randomGenerator) {
		for (User user : users) {
			Language chosenLanguage=user.getChoosenLanguage();
			
			int currentUnit=1;
			
			for(Unit unit : chosenLanguage.getUnits()) {
				
				for(Quiz quiz : unit.getQuizzes()) {
					
					if(user.solveQuiz(quiz, randomGenerator)) {
						user.setCurrentUnitNumber(currentUnit);
					}
					else {
						break;
					}
				}
				currentUnit+=1;
			}
		}
	}
	
	private void arrangeLeagues(ArrayList<League> leagues) {
		for (League league : leagues) {
			league.sortLeaderBoard();
		}
		rankUpLeague(leagues,LeagueName.Bronze,LeagueName.Silver);
		rankUpLeague(leagues,LeagueName.Silver,LeagueName.Gold);
		rankUpLeague(leagues,LeagueName.Gold,LeagueName.Sapphire);
		rankUpLeague(leagues,LeagueName.Sapphire,LeagueName.Ruby);
	}
	
	private void rankUpLeague(ArrayList<League> leagues,LeagueName leagueLow,LeagueName leagueHigh) {
		for (League league : leagues) {
			if(league.getName().equals(leagueLow)) {
				ArrayList<User> users=league.rankUpAndRemoveUsers();
				League silverLeague=findLeagueByNameAndLanguage(leagues, league.getLanguageName(), leagueHigh);
				for (User user : users) {
					silverLeague.addUserToLeague(user);
				}
				silverLeague.sortLeaderBoard();
			}
		}
	}

	private League findLeagueByNameAndLanguage(ArrayList<League> leagues,LanguageName languageName,LeagueName leagueName) {
		for (League league : leagues) {
			if(league.getLanguageName().equals(languageName) && league.getName().equals(leagueName)) {
				return league;
			}
		}
		return null;
	}
	
	public void printAll(ArrayList<User> users,ArrayList<Language> languages,ArrayList<League> leagues) {
		printUserMaximumPoint(users);
		printUserMostAdvancedUnitGerman(users);
		printMaxUnitLanguage(languages);
		printMaxQuizLanguage(languages);
		printTopThreeUserSilverItalian(leagues);
	}
	
	private void printUserMaximumPoint(ArrayList<User> users) {
		User userMax=new User(null,null, null, null, 0, 0);
		for (User user : users) {
			if(user.getPoint()>userMax.getPoint()) {
				userMax=user;
			}
		}
		System.out.println("1- "+userMax.getUsername()+" "+userMax.getPoint()+" points");
	}
	
	private void printUserMostAdvancedUnitGerman(ArrayList<User> users) {
		User userMax=new User(null, null,null, null, 0, 0);
		for (User user : users) {
			if(user.getChoosenLanguage().getName().equals(LanguageName.German)) {
				if(user.getCurrentUnitNumber()>userMax.getCurrentUnitNumber()) {
					userMax=user;
				}
			}
		}
		System.out.println("2- "+userMax.getUsername()+" "+userMax.getCurrentUnitNumber()+" Unit");

	}
	
	private void printMaxUnitLanguage(ArrayList<Language> languages) {
		Language maxLanguage=languages.get(0);
		for (Language language : languages) {
			if(language.getNumberOfUnits()>maxLanguage.getNumberOfUnits()) {
				maxLanguage=language;
			}
		}
		System.out.println("3- "+maxLanguage.getName()+" Unit "+maxLanguage.getNumberOfUnits()+"");
	}
	
	private void printMaxQuizLanguage(ArrayList<Language> languages) {
		Language maxLanguage=languages.get(0);
		for (Language language : languages) {
			if(language.getNumberOfQuiz()>maxLanguage.getNumberOfQuiz()) {
				maxLanguage=language;
			}
		}
		System.out.println("4- "+maxLanguage.getName()+" "+maxLanguage.getNumberOfQuiz()+" Quizzes");

	}
	
	private void printTopThreeUserSilverItalian(ArrayList<League> leagues) {
		League league=findLeagueByNameAndLanguage(leagues, LanguageName.Italian, LeagueName.Silver);
		System.out.println("5- Italian Silver League Top 3: 1."+league.getLeaderBoard().get(0).getUsername()+" 2."+league.getLeaderBoard().get(1).getUsername()+" 3."+league.getLeaderBoard().get(2).getUsername());
	}
}
