package Views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controllers.CreateReadingListController;
import Controllers.DownloadPaperController;
import Paper.Paper;

public class CreateReadingListView implements Observer{

	private JFrame frame;
    private JTextField textField;
    private List<JCheckBox> checkBoxes;
    
    private JButton createButton;
    private JButton backButton;

    public CreateReadingListView(ArrayList<Paper> papers) {
        frame = new JFrame("My Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 500);

        JPanel panel = new JPanel(new BorderLayout());

        // Text Field
        textField = new JTextField("Enter name of reading list");
        panel.add(textField, BorderLayout.NORTH);

        // Checkbox List
        checkBoxes = new ArrayList<>();
        JPanel checkBoxPanel = new JPanel(new GridLayout(0, 1));

        for (int i = 0; i <papers.size(); i++) {
            JCheckBox checkBox = new JCheckBox(papers.get(i).getTitle());
            checkBoxes.add(checkBox);
            checkBoxPanel.add(checkBox);
        }
     // Buttons
        createButton = new JButton("Create Reading List");
        backButton = new JButton("Back");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(createButton);
        buttonPanel.add(backButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);
        panel.add(checkBoxPanel, BorderLayout.CENTER);

        frame.getContentPane().add(panel);
        frame.setVisible(false);
    }
    
    public void createPageAction(CreateReadingListController createReadingListController) {
    	for (JCheckBox jCheckBox : checkBoxes) {
    		jCheckBox.addActionListener(createReadingListController);

		}
    	createButton.addActionListener(createReadingListController);
    	backButton.addActionListener(createReadingListController);
    }

    public String getTextFieldValue() {
        return textField.getText();
    }
    
    public void makeUncheckAll() {
    	for (JCheckBox jCheckBox : checkBoxes) {
			jCheckBox.setSelected(false);
		}
    }

    public List<String> getSelectedCheckBoxes() {
        List<String> selectedItems = new ArrayList<>();
        for (JCheckBox checkBox : checkBoxes) {
            if (checkBox.isSelected()) {
                selectedItems.add(checkBox.getText());
            }
        }
        return selectedItems;
    }

    public void show() {
        frame.setVisible(true);
    }

    public void hide() {
        frame.setVisible(false);
    }
	
	
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
