package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import FileIO.JSONWriter;
import Main.Database;
import Models.LoginModel;
import Paper.Paper;
import ReadingList.ReadingList;
import Researcher.Researcher;
import Views.CreateReadingListView;
import Views.LoginView;
import Views.MainView;
import Views.ViewReadingListsView;

public class CreateReadingListController implements ActionListener{

	private MainView mainView;
		
	private ArrayList<Paper> chosenPapers;
	
	private CreateReadingListView createReadingListView;
	
	private LoginModel loginModel;
	
	private Database database;
	
	private ViewReadingListsView viewReadingListsView;
			
	public CreateReadingListController(MainView mainView,CreateReadingListView createReadingListView,
			LoginModel loginModel,Database database,ViewReadingListsView viewReadingListsView) {
		this.createReadingListView=createReadingListView;
		this.mainView=mainView;
		this.loginModel=loginModel;
		this.database=database;
		this.viewReadingListsView=viewReadingListsView;
		chosenPapers=new ArrayList<>();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Create Reading List")) {
			
			try {
				createReadingList(createReadingListView.getTextFieldValue());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(e.getActionCommand().equals("Back")) {
			createReadingListView.makeUncheckAll();
			chosenPapers.clear();
			this.createReadingListView.hide();
			mainView.show();
		}
		
		else {
			addOrRemovePaper(Paper.findPaperByTitle(e.getActionCommand(), this.database.getPapers()));
		}

	}
	
	private void createReadingList(String name) throws IOException {
		if(name.length()==0  ) {
            JOptionPane.showMessageDialog(null, "Reading List Name can not be null", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else if(chosenPapers.size()==0) {
            JOptionPane.showMessageDialog(null, "You have to choose paper", "Error", JOptionPane.ERROR_MESSAGE);

		}
		else {
			Researcher researcher=Researcher.findResearcherByName(loginModel.getResearcherName(),  this.database.getResearchers());
			int id;
			try {
				id=this.database.getReadingLists().size();
			} catch (Exception e) {
				id=0;
			}
			
			ReadingList readingList=new ReadingList(researcher, name, id+1, chosenPapers);
			ArrayList<ReadingList> newReadingLists=new ArrayList<>();
		    try {

		    	if(!database.getReadingLists().equals(null)) {
		    		newReadingLists=database.getReadingLists();
		    	}

			} catch (Exception e) {
				newReadingLists=new ArrayList<>();
			}
			newReadingLists.add(readingList);
			database.setReadingLists(newReadingLists);
			String filePath = new File("").getAbsolutePath();
			JSONWriter.writeToJSON(filePath.concat("/src/reading_lists.JSON"), newReadingLists);
			chosenPapers.clear();
			viewReadingListsView.addComboBox(newReadingLists.get(newReadingLists.size()-1));
			
		}
	}

	private void addOrRemovePaper(Paper paper) {
		if(chosenPapers.contains(paper)) {
			chosenPapers.remove(paper);
		}
		else {
			chosenPapers.add(paper);
		}
	}
}
