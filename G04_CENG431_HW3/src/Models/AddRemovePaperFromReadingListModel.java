package Models;

import java.util.ArrayList;
import java.util.Observable;

import ReadingList.ReadingList;

public class AddRemovePaperFromReadingListModel extends Observable{
	
	private ReadingList currentReadingList;
	
	private ArrayList<ReadingList> readingLists;
	
	public AddRemovePaperFromReadingListModel(ArrayList<ReadingList> readingLists) {
		this.readingLists=readingLists;
	}
	
	public ReadingList getReadingList() {
		return currentReadingList;
	}
	
	
	
	public void setCurrentReadingList(int index) {
		this.currentReadingList=this.readingLists.get(index);
		setChanged();
        notifyObservers();
	}

}
