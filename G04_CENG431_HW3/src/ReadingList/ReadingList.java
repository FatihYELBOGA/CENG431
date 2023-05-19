package ReadingList;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import Paper.Paper;
import Researcher.Researcher;

public class ReadingList {
	
	private Researcher researcher;
	
	private ArrayList<Paper> papers;
	
	private String name;
	
	private int id;

	public ReadingList(Researcher researcher,String name,int id,ArrayList<Paper> papers) {
		this.name=name;
		this.researcher = researcher;
		this.id=id;
		this.papers = papers;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject convertJsonObject() {
		JSONObject jo=new JSONObject();
		
		jo.put("readinglist_id",id);
		jo.put("creator_researcher_name",researcher.getName());
		jo.put("readinglist_name",name);
		jo.put("number_of_papers",papers.size());
        Map m = new LinkedHashMap(papers.size());
        
        for (Paper paper : papers) {
			m.put("paper_name", paper.getTitle());
		}
        jo.put("name_of_ papers", m);
		return jo;
	}
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}

	public Researcher getResearcher() {
		return researcher;
	}

	public void setResearcher(Researcher researcher) {
		this.researcher = researcher;
	}

	public ArrayList<Paper> getPapers() {
		return papers;
	}

	public void setPapers(ArrayList<Paper> papers) {
		this.papers = papers;
	}
	
}
