package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Main.Database;
import Models.AddRemovePaperFromReadingListModel;
import Views.AddRemovePaperFromReadingListView;
import Views.MainView;

public class AddRemovePaperFromReadingListController implements ActionListener {

	private MainView mainView;
	
	private AddRemovePaperFromReadingListModel addRemovePaperFromReadingListModel;
	
	private AddRemovePaperFromReadingListView addRemovePaperFromReadingListView;
	
	
	public AddRemovePaperFromReadingListController(MainView mainView,
			AddRemovePaperFromReadingListModel addRemovePaperFromReadingListModel,
			AddRemovePaperFromReadingListView addRemovePaperFromReadingListView) {
		this.addRemovePaperFromReadingListModel=addRemovePaperFromReadingListModel;
		this.addRemovePaperFromReadingListView=addRemovePaperFromReadingListView;
		this.mainView=mainView;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		if(e.getActionCommand().equals("Back")) {
			mainView.show();
			addRemovePaperFromReadingListView.hide();
		}
		else if(e.getActionCommand().equals("Update")) {
			
		}
		else if(e.getActionCommand().equals("comboBoxChanged")) {
			this.addRemovePaperFromReadingListModel.setCurrentReadingList(addRemovePaperFromReadingListView.getComboBox().getSelectedIndex());
		}
		else {
			
		}
	}

}
