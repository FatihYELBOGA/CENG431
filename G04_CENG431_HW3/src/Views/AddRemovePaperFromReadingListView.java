package Views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Controllers.AddRemovePaperFromReadingListController;
import Main.Database;
import Models.AddRemovePaperFromReadingListModel;
import Models.LoginModel;
import Paper.Paper;
import ReadingList.ReadingList;
import Researcher.Researcher;

public class AddRemovePaperFromReadingListView implements Observer{
	
    private List<JCheckBox> checkBoxes;
	private JFrame frame;
	private JButton updateButton;
	private JButton backButton;
    private JComboBox<String> comboBox;
    private ArrayList<Paper> papers;
    private ArrayList<ReadingList> readingLists;
    private ArrayList<Researcher> researchers;
    private JPanel topPanel;

    public AddRemovePaperFromReadingListView(Database database) {
    	this.papers=database.getPapers();
    	this.readingLists=database.getReadingLists();
    	this.researchers=database.getResearchers();
    	 frame = new JFrame("Add/Remove Reading List Page");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setSize(1000, 500);
         
         JPanel panel = new JPanel(new BorderLayout());
         String[] comboBoxItems= {""};
         JPanel topPanel = new JPanel();
         this.topPanel=topPanel;
         comboBox = new JComboBox<>(comboBoxItems);
         topPanel.add(comboBox);
         panel.add(topPanel, BorderLayout.NORTH);

         checkBoxes = new ArrayList<>();
         JPanel checkBoxPanel = new JPanel(new GridLayout(0, 1));

         for (int i = 0; i <papers.size(); i++) {
             JCheckBox checkBox = new JCheckBox(papers.get(i).getTitle());
             checkBoxes.add(checkBox);
             checkBoxPanel.add(checkBox);
         }
         
         updateButton = new JButton("Update");
         backButton = new JButton("Back");
         
         JPanel buttonPanel = new JPanel();
         buttonPanel.add(updateButton);
         buttonPanel.add(backButton);

         panel.add(buttonPanel, BorderLayout.SOUTH);
         panel.add(checkBoxPanel, BorderLayout.CENTER);
         
         frame.getContentPane().add(panel);
         frame.setVisible(false);
    }
    
    public void addRemoveActions(AddRemovePaperFromReadingListController addRemovePaperFromReadingListController) {
    	this.backButton.addActionListener(addRemovePaperFromReadingListController);
    	this.updateButton.addActionListener(addRemovePaperFromReadingListController);
    	for (JCheckBox jCheckBox : checkBoxes) {
    		jCheckBox.addActionListener(addRemovePaperFromReadingListController);

		}
    	this.comboBox.addActionListener(addRemovePaperFromReadingListController);
    }
    
    public void show() {
        frame.setVisible(true);
    }

    public void hide() {
        frame.setVisible(false);
    }
    
    public JComboBox<String> getComboBox(){
    	return comboBox;
    }
    
	@Override
	public void update(Observable o, Object arg) {
		if(o.getClass().toString().equals("class Models.LoginModel")) {
			String researcherNameString=((LoginModel)o).getResearcherName();
			Researcher researcherM;
			for (Researcher researcher : researchers) {
				if(researcher.getName().equals(researcherNameString)) {
					researcherM=researcher;
				}
			}
			 JComboBox<String> comboBoxNew=new JComboBox<String>();
			
			for (ReadingList readingList : readingLists) {
				comboBoxNew.addItem(readingList.getName());
			}
			topPanel.remove(comboBox);
			topPanel.add(comboBoxNew);
			comboBoxNew.addActionListener(this.comboBox.getActionListeners()[0]);
			
	}
		else if(o.getClass().toString().equals("class Models.AddRemovePaperFromReadingListModel")) {
			for (JCheckBox jCheckBox : checkBoxes) {
				for (Paper paper : ((AddRemovePaperFromReadingListModel)o).getReadingList().getPapers()) {
					if(jCheckBox.getText().equals(paper.getTitle())) {
						jCheckBox.setSelected(true);
					}
				}
				
			}
		}
	
	}

}
