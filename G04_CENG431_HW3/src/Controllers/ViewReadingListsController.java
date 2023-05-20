package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Models.ViewReadingListsModel;
import Views.MainView;
import Views.ViewReadingListsView;

public class ViewReadingListsController implements ActionListener {
	
	private ViewReadingListsModel viewReadingListsModel;
	
	private ViewReadingListsView viewReadingListsView;
	
    private MainView mainView;
	
	public ViewReadingListsController(ViewReadingListsModel viewReadingListsModel,ViewReadingListsView viewReadingListsView,MainView mainView) {
		this.viewReadingListsModel=viewReadingListsModel;
		this.viewReadingListsView=viewReadingListsView;
		this.mainView=mainView;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("comboBoxChanged")) {
			this.viewReadingListsModel.setCurrentReading(viewReadingListsView.getComboBox().getSelectedIndex());
		}	
		else if(e.getActionCommand().equals("Back")) {
			this.viewReadingListsView.hide();
			mainView.show();
		}
	}

}
