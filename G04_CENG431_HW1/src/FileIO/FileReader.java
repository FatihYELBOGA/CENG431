package FileIO;

import java.io.File;  
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner; 

public class FileReader {
	
	public static ArrayList<String> readLines(String text) {
		try {
			  ArrayList<String> arrayList=new ArrayList<>();
		      File myObj = new File(text);
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        arrayList.add(data);
		      }
		      myReader.close();
		      return arrayList;
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      return null;
		    }
	}
}
