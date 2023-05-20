package ReadingList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
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
     
        JSONArray jsArray = new JSONArray();
        for (Paper paper : papers) {
        	jsArray.add(paper.getTitle());
        }
     
        jo.put("name_of_papers", jsArray);
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

	public String toString() {
		StringBuilder stringBuilder=new StringBuilder();
		StringBuilder stringBuilder2=new StringBuilder();
		for (Paper paper : papers) {
			stringBuilder2.append(paper.getTitle()+"\n");
		}
		stringBuilder.append("id:"+id+"\n");
		stringBuilder.append("name: "+name+"\n");
		stringBuilder.append("Researcher: "+researcher.getName()+"\n");
		stringBuilder.append("Papers: "+stringBuilder2+"\n");
		return stringBuilder.toString();
	}
}
