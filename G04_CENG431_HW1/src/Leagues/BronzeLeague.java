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
		
		int index=15;
		if(getLeaderBoard().size()<index) {
			index=getLeaderBoard().size();
		}
		
		for(int i=0;i<index;i++) {
			users.add(this.getLeaderBoard().get(i));
		}
		
		this.removeUsersFromLeague(index);
		
		return users;
	}



}
