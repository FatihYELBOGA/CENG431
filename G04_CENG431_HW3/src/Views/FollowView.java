package Views;

import java.awt.GridLayout;
import java.awt.TextArea;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Controllers.FollowController;
import Models.LoginModel;
import Researcher.Researcher;

public class FollowView implements Observer{

	
	   
	    private JTextArea textArea1;
	    private JTextArea textArea2;
	    private ArrayList<Researcher> researchers;
	    
	    private JFrame frame;

	    public FollowView(ArrayList<Researcher> researchers) {
	    	
	        JFrame frame = new JFrame("Follow Page");
	        this.researchers=researchers;
	        this.frame=frame;
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(1000, 600);

	        JPanel panel = new JPanel();
	        panel.setLayout(new GridLayout(3, 2));

	      

	        frame.getContentPane().add(panel);
	        frame.setVisible(false);

	       textArea1=new JTextArea();
	       textArea2=new JTextArea();
	       
	        panel.add(textArea1);
	        panel.add(textArea2);
	    }
	    
	    public void show() {
	        frame.setVisible(true);
	    }

	    public void hide() {
	        frame.setVisible(false);
	    }

	    public void addActions(FollowController followController) {
	    	
	    }
	    
	
	@Override
	public void update(Observable o, Object arg) {
		if(o.getClass().toString().equals("class Models.LoginModel")) {
			for (Researcher researcher : researchers) {
				String rName=((LoginModel)o).getResearcherName();
				if(researcher.getName().equals(rName)) {
					
					StringBuilder stringBuilder=new StringBuilder("Followers:\n");
					for (String researcher2 : researcher.getFollowerResearcherNames()) {
						stringBuilder.append(researcher2+"\n");
					}
					StringBuilder stringBuilder1=new StringBuilder("Followings:\n");
					for (String researcher2 : researcher.getFollowingResearcherNames()) {
						stringBuilder1.append(researcher2+"\n");
					}
					this.textArea1.setText(stringBuilder1.toString());
					this.textArea2.setText(stringBuilder.toString());
				}
			}
		}
		
	}

}
