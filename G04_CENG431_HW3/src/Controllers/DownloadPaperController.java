package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

import FileIO.FileDownload;
import FileIO.FileWriterC;
import Models.DownloadPaperModel;
import Paper.Paper;
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
			String fileNameString=this.downloadPaperView.getPapers().get(downloadPaperView.getComboBox().getSelectedIndex()).getPathName();
			try {
				FileDownload.initDownload(filePath.concat("/src/Homework3/"+fileNameString),filePath.concat("/src/DownloadedFiles/"));
	            JOptionPane.showMessageDialog(null, "File downloaded successfully", "Error", JOptionPane.INFORMATION_MESSAGE);
	            for (Paper paper : this.downloadPaperView.getPapers()) {
					if(paper.getPathName().equals(filePath)) {
						paper.incrementNumberOfDownloads();
					}
				}
	            
	            FileWriterC.writeBibFilesToCSV(filePath.concat("/src/papers.csv"), this.downloadPaperView.getPapers());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
	
	

}
