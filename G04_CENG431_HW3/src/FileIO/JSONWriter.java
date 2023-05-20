package FileIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import org.json.simple.JSONArray;

import ReadingList.ReadingList;

public class JSONWriter {
	
	public static void writeToJSON(String path,ArrayList<ReadingList> readingLists) throws IOException {
		
		JSONArray jsonArray=new JSONArray();
		
		for (ReadingList readingList : readingLists) {
			jsonArray.add(readingList.convertJsonObject());
		}
		
	    Files.write(Path.of(path), jsonArray.toJSONString().getBytes());

	}

}
