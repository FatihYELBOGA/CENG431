package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Views.DownloadPaperView;
import Views.LoginView;
import Views.MainView;

public class MainController implements ActionListener{
	
	private MainView mainView;
	
	private LoginView loginView;
	
	private DownloadPaperView downloadPaperView;
	
	public MainController(MainView mainView,LoginView loginView,DownloadPaperView downloadPaperView) {
		this.mainView=mainView;
		this.loginView=loginView;
		this.downloadPaperView=downloadPaperView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String eventType=e.getActionCommand();
		if(eventType.equals("View Reading Lists")) {
			
		}
		else if(eventType.equals("Create Reading List")) {
			
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
	
	private void logoutAction() {
		mainView.hide();
		loginView.show();
	}
	
	private void downloadAction() {
		mainView.hide();
		downloadPaperView.show();
	}
}
