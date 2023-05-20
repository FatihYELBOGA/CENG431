package Models;

import java.util.ArrayList;
import java.util.Observable;

import ReadingList.ReadingList;

public class ViewReadingListsModel extends Observable{
	
	private ArrayList<ReadingList> readingLists;
	
	private ReadingList readingList;
	
	private String researchName;
	
	public ViewReadingListsModel(ArrayList<ReadingList> readingLists,ReadingList readingList) {
		this.readingList=readingList;
		this.readingLists=readingLists;
		this.researchName="";
	}
	
	public ReadingList getReadingList() {
		return readingList;
	}
	
	public String getResearchName() {
		return researchName;
	}
	
	public void setCurrentReading(int index) {
		this.readingList=this.readingLists.get(index);
		setChanged();
        notifyObservers();
	}
	
	public void setResearchName(String string) {
		this.researchName=string;
		setChanged();
        notifyObservers();
	}
	

}
