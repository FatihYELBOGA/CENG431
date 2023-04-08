package Leagues;

import java.util.ArrayList;

import Languages.Language;
import User.User;

public class BronzeLeague extends League {

	public BronzeLeague(Language language) {
		super(language,LeagueName.Bronze);
	}

	@Override
	public ArrayList<User> rankUpAndRemoveUsers() {
		ArrayList<User> users=new ArrayList<>();
		
		for(int i=0;i<15;i++) {
			users.add(this.getLeaderBoard().get(i));
		}
		
		this.removeUsersFromLeague(15);
		
		return users;
	}



}
