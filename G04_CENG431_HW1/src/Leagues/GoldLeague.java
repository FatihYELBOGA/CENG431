package Leagues;

import java.util.ArrayList;

import Languages.Language;
import User.User;

public class GoldLeague extends League {

	public GoldLeague(Language language) {
		super(language,LeagueName.Gold);
	}
	
	@Override
	public ArrayList<User> rankUpAndRemoveUsers() {
		ArrayList<User> users=new ArrayList<>();
		
		int count=0;
		
		int index=5;
		if(getLeaderBoard().size()<index) {
			index=getLeaderBoard().size();
		}
		
		for(int i=0;i<index;i++) {
			User user=this.getLeaderBoard().get(i);
			if(user.getNumberOfDaysStreak()>=7) {
				count+=1;
				users.add(user);
			}
		}
		
		this.removeUsersFromLeague(count);
		
		return users;
	}

}
