package Models;

import java.util.ArrayList;
import java.util.Observable;

import Paper.Paper;

public class DownloadPaperModel extends Observable{
	
	private ArrayList<Paper> papers;
	
	private Paper currentPaper;
	
	public DownloadPaperModel(ArrayList<Paper> papers) {
		this.papers=papers;
		this.currentPaper=papers.get(0);
	}
	
	public ArrayList<Paper> getPapers(){
		return papers;
	}
	
	public Paper getCurrentPaper() {
		return currentPaper;
	}
	
	public void setCurrentPaper(int index) {
		this.currentPaper=this.papers.get(index);
		setChanged();
        notifyObservers();
	}
	
	

}
