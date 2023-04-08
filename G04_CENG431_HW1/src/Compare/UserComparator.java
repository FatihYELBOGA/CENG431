package Compare;

import java.util.Comparator;

import User.User;

public class UserComparator implements Comparator<User>{

	@Override
	public int compare(User user1, User user2) {
		if(user1.getPoint()>user2.getPoint()) {
			return 1;
		}
		else if(user1.getPoint()<user2.getPoint()) {
			return -1;
		}
		else {
			if(user1.getNumberOfDaysStreak()>user2.getNumberOfDaysStreak()) {
				return 1;
			}
			else {
				return -1;
			}
		}
	}

}
