package Leagues;

import java.util.ArrayList;

import Languages.Language;
import User.User;

public class RubyLeague extends League {

	public RubyLeague(Language language) {
		super(language,LeagueName.Ruby);
	}

	@Override
	public ArrayList<User> rankUpAndRemoveUsers() {
		//final league no need to implement it.
		return null;
	}

}
