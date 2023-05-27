package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Views.AddRemovePaperFromReadingListView;
import Views.CreateReadingListView;
import Views.DownloadPaperView;
import Views.FollowView;
import Views.LoginView;
import Views.MainView;
import Views.ViewReadingListsView;

public class MainController implements ActionListener{
	
	private MainView mainView;
	
	private LoginView loginView;
	
	private DownloadPaperView downloadPaperView;
	
	private CreateReadingListView createReadingListView;
	
	private ViewReadingListsView viewReadingListsView;
	
	private AddRemovePaperFromReadingListView addRemovePaperFromReadingListView;
	
	private FollowView followView;
	
	public MainController(MainView mainView,LoginView loginView,DownloadPaperView downloadPaperView,CreateReadingListView createReadingListView,ViewReadingListsView viewReadingListsView,AddRemovePaperFromReadingListView addRemovePaperFromReadingListView,FollowView followView) {
		this.mainView=mainView;
		this.loginView=loginView;
		this.downloadPaperView=downloadPaperView;
		this.createReadingListView=createReadingListView;
		this.viewReadingListsView=viewReadingListsView;
		this.addRemovePaperFromReadingListView=addRemovePaperFromReadingListView;
		this.followView=followView;
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
			follow();

		}
		else if(eventType.equals("Add/Remove Paper From Reading Lists")) {
			addRemovePapersFromReadingList();
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
	
	private void addRemovePapersFromReadingList() {
		mainView.hide();
		addRemovePaperFromReadingListView.show();
	}
	private void follow() {
		mainView.hide();
		followView.show();
	}
	
}
