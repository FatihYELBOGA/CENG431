package Models;

import java.util.ArrayList;
import java.util.Observable;

import Researcher.Researcher;

public class LoginModel extends Observable {
    private String researcherName;
    private String password;
    private ArrayList<Researcher> researchers;
    
    public LoginModel(ArrayList<Researcher> researchers) {
    	this.researchers=researchers;
    }

    public void setCredentials(String researcherName,String password) {
        this.researcherName = researcherName;
        this.password=password;
        this.researchers=researchers;
        setChanged();
        notifyObservers();
    }

    public String getResearcherName() {
        return researcherName;
    }

    public String getPassword() {
        return password;
    }
    
    public ArrayList<Researcher> getResearchers(){
    	return researchers;
    }
}
