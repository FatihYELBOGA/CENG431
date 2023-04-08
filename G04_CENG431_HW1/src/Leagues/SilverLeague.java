package Leagues;

import java.util.ArrayList;

import Languages.Language;
import User.User;

public class SilverLeague extends League {

	public SilverLeague(Language language) {
		super(language,LeagueName.Silver);
	}

	
	@Override
	public ArrayList<User> rankUpAndRemoveUsers() {
		ArrayList<User> users=new ArrayList<>();
		
		for(int i=0;i<10;i++) {
			users.add(this.getLeaderBoard().get(i));
		}
		
		this.removeUsersFromLeague(10);
		
		return users;
	}
}
