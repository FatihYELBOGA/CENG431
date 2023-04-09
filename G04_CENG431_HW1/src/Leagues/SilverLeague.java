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
		
		int index=10;
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
