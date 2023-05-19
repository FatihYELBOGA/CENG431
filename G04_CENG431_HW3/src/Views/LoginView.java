package Views;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controllers.LoginController;
import Models.LoginModel;

public class LoginView implements Observer {
    private JTextField researcherNameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JFrame frame;

    public LoginView() {
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel researcherNameLabel = new JLabel("Researcher Name:");
        panel.add(researcherNameLabel);

        researcherNameField = new JTextField();
        panel.add(researcherNameField);

        JLabel passwordLabel = new JLabel("Password:");
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        panel.add(passwordField);

        loginButton = new JButton("Login");
        panel.add(loginButton);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
        this.frame=frame;
    }
    
    public void loginAction(LoginController loginController) {
    	this.loginButton.addActionListener(loginController);
    }
    
    public void hide() {
    	frame.setVisible(false);
    }
    
    public void show() {
    	frame.setVisible(true);
    }

    public String getUsername() {
        return researcherNameField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }
    
    public void clearInputs() {
    	researcherNameField.setText("");
    	passwordField.setText("");
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    @Override
    public void update(Observable o, Object arg) {
    	researcherNameField.setText(((LoginModel) o).getResearcherName());
        passwordField.setText(((LoginModel) o).getPassword());
    }


}

