package Views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Controllers.ViewReadingListsController;
import Models.DownloadPaperModel;
import Models.LoginModel;
import Models.ViewReadingListsModel;
import ReadingList.ReadingList;

public class ViewReadingListsView implements Observer{
	 private JFrame frame;
	private JComboBox<String> comboBox;
    private JTextArea textArea;
    private JButton button;
    private String researchName;
    private ArrayList<ReadingList> readingLists;

    public ViewReadingListsView(ArrayList<ReadingList> readingLists) {
    	
    	this.researchName="";
    	this.readingLists=readingLists;
    	
    	frame = new JFrame("Readings View");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 500);

        JPanel panel = new JPanel(new GridLayout(3, 1));

        // Combo Box
        comboBox = new JComboBox<>();
        
        panel.add(comboBox);

        // Text Field
        textArea = new JTextArea();
        panel.add(textArea);

        // Button
        button = new JButton("Back");
        
        panel.add(button);

        frame.getContentPane().add(panel);
        frame.setVisible(false);
        
    }
	
	public void show() {
        frame.setVisible(true);
	}
	public void hide() {
        frame.setVisible(false);
	}
	
	public void viewReadingsAction(ViewReadingListsController viewReadingListsController) {
		button.addActionListener(viewReadingListsController);
    	comboBox.addActionListener(viewReadingListsController);

	}
	
	public JComboBox getComboBox() {
		return comboBox;
	}
	
	public void setComboBox(ArrayList<ReadingList> readingLists,String name) {
		for (ReadingList readingList2 : readingLists) {
			if(!readingList2.getResearcher().getName().equals(name)) {
				comboBox.addItem(readingList2.getName());
			}
		}
	}
	
	public void addComboBox(ReadingList readingList) {
		comboBox.addItem(readingList.getName());
	}
	

	@Override
	public void update(Observable o, Object arg) {

		if(o.getClass().toString().equals("class Models.ViewReadingListsModel")) {

			textArea.setText(((ViewReadingListsModel)o).getReadingList().toString());

		}
		if(o.getClass().toString().equals("class Models.LoginModel")) {
			setComboBox(readingLists, ((LoginModel)o).getResearcherName());
		}
		
	}
	

}
