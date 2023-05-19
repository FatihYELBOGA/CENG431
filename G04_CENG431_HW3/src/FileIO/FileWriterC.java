package FileIO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import Paper.Paper;

import java.io.FileWriter;   // Import the FileWriter class

public class FileWriterC {
	
	public static void writeBibFilesToCSV(String csvFilePath,ArrayList<Paper> papers) {
		ArrayList<Object> objects=new ArrayList<>();
		for (Paper paper : papers) {
			objects.add(paper);
		}
		writeLines(csvFilePath, objects);
	}
	
	
	private static void writeLines(String fileName,ArrayList<Object> objects) {
    	
    	try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
    		for (Object object : objects) {
    			 writer.write(object.toString());
       		     writer.newLine();
			}
    		}
    		catch(IOException ex){
    			System.out.println(ex.getMessage());

    		}
	}

}
