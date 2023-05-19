package Controllers;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import Models.LoginModel;
import Researcher.Researcher;
import Views.LoginView;
import Views.MainView;

public class LoginController implements ActionListener {
    private LoginModel loginModel;
    private MainView mainView;
    private LoginView loginView;

    public LoginController(LoginModel loginModel,LoginView loginView,MainView mainView) {
        this.loginModel = loginModel;
        this.mainView=mainView;
        this.loginView = loginView;
    }
    
    private boolean loginHandle(String researcherName,String password) {
    	for (Researcher researcher : loginModel.getResearchers()) {
			if(researcher.getName().equals(researcherName)) {
				if(researcher.getPassword().equals(password)) {
					return true;
				}
			}
		}
    	return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String researcherName = loginView.getUsername();
        String password = loginView.getPassword();
        
        boolean isCorrect=loginHandle(researcherName, password);
        if(!isCorrect) {
            JOptionPane.showMessageDialog(null, "Researcher Name or Password are wrong", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
            loginModel.setCredentials(researcherName,password);
            this.loginView.hide();
            this.mainView.show();
            this.loginView.clearInputs();
            
        }

    }


}
