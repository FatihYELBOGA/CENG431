package Views;

import javax.swing.*;

import Controllers.MainController;
import Models.LoginModel;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class MainView implements Observer {
    private JFrame frame;
    
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;

    private JTextField textArea;

    public MainView() {
    	JFrame frame = new JFrame("Main Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 500);

        JPanel panel = new JPanel(new GridLayout(1, 6));
         textArea = new JTextField();
         textArea.disable();
        panel.add(textArea);
         button1 = new JButton("Download Paper");
         button2 = new JButton("Create Reading List");
         button3 = new JButton("View Reading Lists");
         button4 = new JButton("Follow/Unfollow Researchers");
         button6 = new JButton("Add/Remove Paper From Reading Lists");

         button5 = new JButton("Logout");

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button6);
        panel.add(button5);

        frame.getContentPane().add(panel);
        frame.setVisible(false);
        this.frame=frame;
    }
    
    public void mainAction(MainController mainController) {
    	this.button1.addActionListener(mainController);
    	this.button2.addActionListener(mainController);
    	this.button3.addActionListener(mainController);
    	this.button4.addActionListener(mainController);
    	this.button5.addActionListener(mainController);
    	this.button6.addActionListener(mainController);
    }

    public void show() {
        frame.setVisible(true);
    }

    public void hide() {
        frame.setVisible(false);
    }

	@Override
	public void update(Observable o, Object arg) {
		this.textArea.setText("Your name:"+((LoginModel)o).getResearcherName());
		
	}
}

