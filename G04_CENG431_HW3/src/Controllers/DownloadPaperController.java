package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import FileIO.FileDownload;
import Models.DownloadPaperModel;
import Views.DownloadPaperView;
import Views.MainView;

public class DownloadPaperController implements ActionListener{

	private DownloadPaperModel downloadPaperModel;
	
	private DownloadPaperView downloadPaperView;
	
	private MainView mainView;
	
	public DownloadPaperController(DownloadPaperModel downloadPaperModel,
			DownloadPaperView downloadPaperView,MainView mainView) {
		this.downloadPaperModel=downloadPaperModel;
		this.downloadPaperView=downloadPaperView;
		this.mainView=mainView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("comboBoxChanged")) {
			this.downloadPaperModel.setCurrentPaper(downloadPaperView.getComboBox().getSelectedIndex());
		}
		else if(e.getActionCommand().equals("Back")) {
			this.downloadPaperView.hide();
			mainView.show();
		}
		else if(e.getActionCommand().equals("Download")) {
			String filePath = new File("").getAbsolutePath();
			System.out.println(downloadPaperView.getComboBox().getSelectedIndex());
			try {
				//FileDownload.initDownload(null, null);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
	
	

}
