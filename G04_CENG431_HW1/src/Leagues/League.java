package Leagues;

import java.util.ArrayList;
import Compare.UserComparator;
import Languages.Language;
import Languages.LanguageName;
import User.User;

public abstract class League{
	
	private Language language;
	
	private LeagueName name;
	
	private ArrayList<User> leaderBoard;
	
	public League(Language language,LeagueName name) {
		this.language=language;
		this.name=name;
		this.leaderBoard=new ArrayList<>();
	}
	
	public ArrayList<User> getLeaderBoard(){
		return leaderBoard;
	}
	
	public Language getLanguage() {
		return language;
	}
	
	public LeagueName getName() {
		return name;
	}
	
	public LanguageName getLanguageName() {
		return language.getName();
	}
	
	public void addUserToLeague(User user) {
		leaderBoard.add(user);		
	}
	
	public void sortLeaderBoard() {
		leaderBoard.sort(new UserComparator());
	}
	
	public abstract ArrayList<User> rankUpAndRemoveUsers();
	
	public void removeUsersFromLeague(int limit) {
		for(int i=0;i<limit;i++) {
			leaderBoard.remove(0);
		}
	}
	
}



