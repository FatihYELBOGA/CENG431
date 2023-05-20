package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Views.CreateReadingListView;
import Views.DownloadPaperView;
import Views.LoginView;
import Views.MainView;
import Views.ViewReadingListsView;

public class MainController implements ActionListener{
	
	private MainView mainView;
	
	private LoginView loginView;
	
	private DownloadPaperView downloadPaperView;
	
	private CreateReadingListView createReadingListView;
	
	private ViewReadingListsView viewReadingListsView;
	
	public MainController(MainView mainView,LoginView loginView,DownloadPaperView downloadPaperView,CreateReadingListView createReadingListView,ViewReadingListsView viewReadingListsView) {
		this.mainView=mainView;
		this.loginView=loginView;
		this.downloadPaperView=downloadPaperView;
		this.createReadingListView=createReadingListView;
		this.viewReadingListsView=viewReadingListsView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String eventType=e.getActionCommand();
		if(eventType.equals("View Reading Lists")) {
			viewReading();
		}
		else if(eventType.equals("Create Reading List")) {
			createReadingListAction();
		}
		else if(eventType.equals("Download Paper")) {
			downloadAction();
		}
		else if(eventType.equals("Follow/Unfollow Researchers")){
			
		}
		else if(eventType.equals("Logout")) {
			logoutAction();
		}
	}
	
	private void viewReading() {
		mainView.hide();
		viewReadingListsView.show();
	}
	
	private void logoutAction() {
		mainView.hide();
		loginView.show();
	}
	
	private void downloadAction() {
		mainView.hide();
		downloadPaperView.show();
	}
	
	private void createReadingListAction() {
		mainView.hide();
		createReadingListView.show();
	}
}
