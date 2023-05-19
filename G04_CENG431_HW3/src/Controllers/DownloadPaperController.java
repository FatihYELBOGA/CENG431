package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Models.DownloadPaperModel;
import Views.DownloadPaperView;

public class DownloadPaperController implements ActionListener{

	private DownloadPaperModel downloadPaperModel;
	
	private DownloadPaperView downloadPaperView;
	
	public DownloadPaperController(DownloadPaperModel downloadPaperModel,DownloadPaperView downloadPaperView) {
		this.downloadPaperModel=downloadPaperModel;
		this.downloadPaperView=downloadPaperView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		

		System.out.println(downloadPaperView.getComboBox().getSelectedIndex());

	}
	
	

}
