package FileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Paper.Paper;
import ReadingList.ReadingList;
import Researcher.Researcher;

public class JSONReader {
	
	ArrayList<Paper> papers;
	
	ArrayList<Researcher> researchers;
	
	public JSONReader(ArrayList<Paper> papers,ArrayList<Researcher> researchers) {
		this.papers=papers;
		this.researchers=researchers;
	}
	
	public  boolean isFileExist(String fileName) {
		File file=new File(fileName);
		return file.exists();
	}
	
	public ArrayList<ReadingList> readJSON(String path) throws FileNotFoundException, IOException, ParseException {
	    
		if(!isFileExist(path)) {
			return null;
		}
		
		ArrayList<ReadingList> readingLists=new ArrayList<>();
		
		JSONParser parser = new JSONParser();

        Object obj = parser.parse(new FileReader(path));
        JSONArray jsonObject = (JSONArray)obj;

        for (Object object : jsonObject) {
        	readingLists.add(parseJSON((JSONObject) object));
		}
        
        return readingLists;
	}
	
	private ReadingList parseJSON(JSONObject obj) {
		String id=obj.get("readinglist_id").toString();
		String researcherName=obj.get("creator_researcher_name").toString();
		String readingListName=obj.get("readinglist_name").toString();
		JSONArray jsonObject =(JSONArray)obj.get("name_of_papers");
		ArrayList<String> paperNames=new ArrayList<>();
		for (Object object : jsonObject) {
			paperNames.add((String) object);
		}
		ArrayList<Paper> papers=new ArrayList<>();
		for (String string : paperNames) {
			papers.add(Paper.findPaperByTitle(string, this.papers));
		}

		Researcher researcher=Researcher.findResearcherByName(researcherName, researchers);
		
		return new ReadingList(researcher, readingListName, Integer.parseInt(id), papers);

	}

}
