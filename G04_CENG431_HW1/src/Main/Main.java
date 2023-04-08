package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

import App.App;
import FileIO.FileReader;
import FileIO.FileWriterC;
import Languages.Language;
import ObjectInitializer.ObjectInitializer;
import Quizzes.Quiz;
import Random.RandomGenerator;
import Units.Unit;
import User.User;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
    	
    	String filePath = new File("").getAbsolutePath();
    	
    	ArrayList<String> usersList=FileReader.readLines(filePath.concat("/src/users.csv"));
    	
    	RandomGenerator randomGenerator=new RandomGenerator(new Random());
    	
    	ObjectInitializer objectInitializer=new ObjectInitializer(usersList,randomGenerator,
    			FileWriterC.isFileExist(filePath.concat("/src/languages.csv")));
    	
    	App app=new App();
    	
    	app.startApp(objectInitializer.getUsers(), objectInitializer.getLanguages(),
    			objectInitializer.getLeagues(), randomGenerator);
    	
    	app.printAll(objectInitializer.getUsers(), objectInitializer.getLanguages(),objectInitializer.getLeagues());
    	
    	FileWriterC.writeFiles(filePath.concat("/src/users.csv"),filePath.concat("/src/languages.csv"),
    			objectInitializer.getLanguages(),objectInitializer.getUsers());
    	
    }
}