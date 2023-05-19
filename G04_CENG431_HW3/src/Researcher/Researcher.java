package Researcher;

import java.util.ArrayList;

import ReadingList.ReadingList;

public class Researcher {
	
	private String name;
	
	private String password;
	
	private ArrayList<String> followingResearcherNames;
	
	private ArrayList<String> followerResearcherNames;
	
	private ArrayList<String> readingListNames;

	public Researcher(String name, String password, ArrayList<String> followingResearcherNames,
			ArrayList<String> followerResearcherNames, ArrayList<String> readingListNames) {
		this.name = name;
		this.password = password;
		this.followingResearcherNames = followingResearcherNames;
		this.followerResearcherNames = followerResearcherNames;
		this.readingListNames = readingListNames;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<String> getFollowingResearcherNames() {
		return followingResearcherNames;
	}

	public void setFollowingResearcherNames(ArrayList<String> followingResearcherNames) {
		this.followingResearcherNames = followingResearcherNames;
	}

	public ArrayList<String> getFollowerResearcherNames() {
		return followerResearcherNames;
	}

	public void setFollowerResearcherNames(ArrayList<String> followerResearcherNames) {
		this.followerResearcherNames = followerResearcherNames;
	}

	public ArrayList<String> getReadingListNames() {
		return readingListNames;
	}

	public void setReadingListNames(ArrayList<String> readingListNames) {
		this.readingListNames = readingListNames;
	}
	
	

}
