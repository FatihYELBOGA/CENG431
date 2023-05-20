package Main;

import java.util.ArrayList;

import Paper.Paper;
import ReadingList.ReadingList;
import Researcher.Researcher;

public class Database {
	
	private ArrayList<Researcher> researchers;
	
	private ArrayList<Paper> papers;
	
	private ArrayList<ReadingList> readingLists;

	public Database(ArrayList<Researcher> researchers, ArrayList<Paper> papers, ArrayList<ReadingList> readingLists) {
		super();
		this.researchers = researchers;
		this.papers = papers;
		this.readingLists = readingLists;
	}

	public ArrayList<Researcher> getResearchers() {
		return researchers;
	}

	public void setResearchers(ArrayList<Researcher> researchers) {
		this.researchers = researchers;
	}

	public ArrayList<Paper> getPapers() {
		return papers;
	}

	public void setPapers(ArrayList<Paper> papers) {
		this.papers = papers;
	}

	public ArrayList<ReadingList> getReadingLists() {
		return readingLists;
	}

	public void setReadingLists(ArrayList<ReadingList> readingLists) {
		this.readingLists = readingLists;
	}
	
	

}
