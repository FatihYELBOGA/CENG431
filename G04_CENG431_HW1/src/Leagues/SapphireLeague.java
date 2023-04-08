package Leagues;

import java.util.ArrayList;

import Languages.Language;
import User.User;

public class SapphireLeague extends League {

	public SapphireLeague(Language language) {
		super(language,LeagueName.Sapphire);
	}

	@Override
	public ArrayList<User> rankUpAndRemoveUsers() {
		ArrayList<User> users=new ArrayList<>();

		int count=0;
		
		for (User user : this.getLeaderBoard()) {
			if((user.getNumberOfDaysStreak()>30&& user.getPoint()>5000)|| user.getCurrentUnitNumber()>10) {
				count+=1;
				users.add(user);
			}
		}
		
		this.removeUsersFromLeague(count);
		
		return users;
	}

}
