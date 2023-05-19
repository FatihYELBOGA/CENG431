package Models;

import java.util.ArrayList;

import Researcher.Researcher;

public class ResearcherModel {
	
	private ArrayList<Researcher> researchers;
	
	public ResearcherModel(ArrayList<Researcher> researchers) {
		this.researchers=researchers;
	}

	public ArrayList<Researcher> getResearchers() {
		return researchers;
	}

	public void setResearchers(ArrayList<Researcher> researchers) {
		this.researchers = researchers;
	}
	
	

}
