package Views;

import javax.swing.*;

import Controllers.DownloadPaperController;
import Models.DownloadPaperModel;
import Paper.Paper;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class DownloadPaperView implements Observer{
    private JFrame frame;
    private JComboBox<String> comboBox;
    private JTextArea paperTitle;
    private JTextArea paperAuthorName;
    private JTextArea paperOtherInformations;
    private JButton downloadButton;
    private JButton logoutButton;

    private ArrayList<Paper> papers;
    
    public DownloadPaperView(String[] papers,Paper firstPaper,ArrayList<Paper> papersList) {
        frame = new JFrame("Download Paper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 500);
        this.papers=papersList;
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Top Panel
        JPanel topPanel = new JPanel();
        String[] comboBoxItems = papers;
        comboBox = new JComboBox<>(comboBoxItems);
        topPanel.add(comboBox);

        mainPanel.add(topPanel, BorderLayout.NORTH);

        // Center Panel
        JPanel centerPanel = new JPanel(new GridLayout(3, 1));

        paperTitle = new JTextArea(firstPaper.getTitle());
        centerPanel.add(new JScrollPane(paperTitle));

        paperAuthorName = new JTextArea(firstPaper.getAuthorsString());
        centerPanel.add(new JScrollPane(paperAuthorName));

        paperOtherInformations = new JTextArea(firstPaper.getYear()+", "+firstPaper.getDoi()+", "+firstPaper.otherStrings());
        centerPanel.add(new JScrollPane(paperOtherInformations));

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // Bottom Panel
        JPanel bottomPanel = new JPanel();
        downloadButton = new JButton("Download");
        logoutButton = new JButton("Back");

        bottomPanel.add(downloadButton);
        bottomPanel.add(logoutButton);  

        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        frame.getContentPane().add(mainPanel);
        frame.setVisible(false);
    }
    
    public ArrayList<Paper> getPapers(){
    	return this.papers;
    }
    
    public void downloadPageAction(DownloadPaperController downloadPaperController) {
    	comboBox.addActionListener(downloadPaperController);
        downloadButton.addActionListener(downloadPaperController);
        logoutButton.addActionListener(downloadPaperController);
    }

    public String getSelectedItem() {
        return (String) comboBox.getSelectedItem();
    }

    public JComboBox<String> getComboBox(){
    	return this.comboBox;
    }

    public void show() {
        frame.setVisible(true);
    }

    public void hide() {
        frame.setVisible(false);
    }

	@Override
	public void update(Observable o, Object arg) {
		paperTitle.setText(((DownloadPaperModel)o).getCurrentPaper().getTitle());
	
		paperAuthorName.setText(((DownloadPaperModel)o).getCurrentPaper().getAuthorsString());
		
		paperOtherInformations.setText(
				((DownloadPaperModel)o).getCurrentPaper().getYear()+","+((DownloadPaperModel)o).getCurrentPaper().getDoi()+", "+((DownloadPaperModel)o).getCurrentPaper().otherStrings());

		
	}
}

