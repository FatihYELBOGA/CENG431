package FileIO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import Languages.Language;
import User.User;

import java.io.FileWriter;   // Import the FileWriter class

public class FileWriterC {
	
	public static void writeFiles(String userFile,String languageFile,ArrayList<Language> languages,ArrayList<User> users) throws FileNotFoundException {
		writeLanguages(languageFile, languages);
		writeUsers(userFile, users);
	}
	
	private static void writeLanguages(String fileName,ArrayList<Language> languages) {
    	if(createFile(fileName)) {
    		ArrayList<Object> list=new ArrayList<>();
    		for (Language language : languages) {
				list.add(language);
			}
        	writeLines(fileName,list);
    	}
	}
	
	private static void writeUsers(String fileName,ArrayList<User> users) throws FileNotFoundException {
		clearFile(fileName);
		ArrayList<Object> list=new ArrayList<>();
		for (Object user : users) {
			list.add(user);
		}
		writeLines(fileName,list);
		
	}
	
	private static void clearFile(String fileName) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(fileName);
		writer.print("");
		writer.close();
	}
	
	private static void writeLines(String fileName,ArrayList<Object> objects) {
    	
    	try (BufferedWriter writer = 
    			new BufferedWriter(new FileWriter(fileName))){
    		for (Object object : objects) {
    			 writer.write(object.toString());
       		     writer.newLine();
			}
    		}
    		catch(IOException ex){
    			System.out.println(ex.getMessage());

    		}
	}
	
	private static boolean createFile(String filenName) {
		try {
		      File myObj = new File(filenName);
		      if (myObj.createNewFile()) {
		    	  
		    	  return true;
		      } else {
		    	  return false;
		      }
		    } catch (IOException e) {
		    	return false;
		    }
	}
	
	public static boolean isFileExist(String fileName) {
		File file=new File(fileName);
		return file.exists();
	}

}
