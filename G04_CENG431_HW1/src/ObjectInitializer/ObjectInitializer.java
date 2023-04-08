package ObjectInitializer;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import FileIO.FileReader;
import Languages.GermanLanguage;
import Languages.ItalianLanguage;
import Languages.Language;
import Languages.LanguageName;
import Languages.SpanishLanguage;
import Languages.TurkishLanguage;
import Leagues.BronzeLeague;
import Leagues.GoldLeague;
import Leagues.League;
import Leagues.LeagueName;
import Leagues.RubyLeague;
import Leagues.SapphireLeague;
import Leagues.SilverLeague;
import Random.RandomGenerator;
import User.User;

public class ObjectInitializer {
	
	private ArrayList<User> users;
	
	private ArrayList<Language> languages;
	
	private ArrayList<League> leagues;
	
	private RandomGenerator randomGenerator;
	
	public ObjectInitializer(ArrayList<String> userList,RandomGenerator randomGenerator,boolean isLanguagesFileExist) {
		this.randomGenerator=randomGenerator;
		this.languages=generateLanguages();
		
		if(!isLanguagesFileExist) {
			generateLanguageContentsRandomly(languages);
		}
		else {
	    	String filePath = new File("").getAbsolutePath();
	    	
	    	generateLanguageContentsFromFile(FileReader.readLines(filePath.concat("/src/languages.csv")),languages);
		}
		
		this.leagues=generateLeagues(languages);
		this.users=generateUsersRandomly(userList);
	}
	
	
	
	public ArrayList<User> getUsers(){
		return users;
	}
	
	public ArrayList<Language> getLanguages(){
		return languages;
	}
	
	public ArrayList<League> getLeagues(){
		return leagues;
	}
	
	private ArrayList<League> generateLeagues(ArrayList<Language> languages){
		ArrayList<League> leagues=new ArrayList<>();
		for (Language language : languages) {
			League bronzeLeague=new BronzeLeague(language);
			League goldLeague=new GoldLeague(language);
			League rubyLeague=new RubyLeague(language);
			League sapphireLeague=new SapphireLeague(language);
			League silverLeague=new SilverLeague(language);
			leagues.add(silverLeague);
			leagues.add(sapphireLeague);
			leagues.add(rubyLeague);
			leagues.add(goldLeague);
			leagues.add(bronzeLeague);
		}
		return leagues;
	}
	
	private  ArrayList<User> generateUsersRandomly(ArrayList<String> userList){
		
		ArrayList<User> list=new ArrayList<>();
		
		for (String string : userList) {
			
			LanguageName randomLanguageString=randomGenerator.generateRandomLanguage();
			
			Language randomLanguage=findLanguageByName(randomLanguageString);
						
			League currentUserLeague=findLeagueByLanguage(randomLanguage);
			
			int randomStreak=randomGenerator.generateRandomInterval(0, 365);
			
			int randomQuizNumber=randomGenerator.generateRandomInterval(6,randomLanguage.getNumberOfQuiz());
			
			User user=generateUser(string,randomLanguage ,currentUserLeague, randomStreak, randomQuizNumber);
			
			currentUserLeague.addUserToLeague(user);
			list.add(user);
		}
		return list;
	}
	
	private  User generateUser(String text,Language randomLanguage,League league,int randomStreak,int randomQuizNumber) {
		
		String username=text.split(";")[0];
		String password=text.split(";")[1];
		
		return new User(randomLanguage,league, username, password, randomStreak, randomQuizNumber);

	}
	
	private Language findLanguageByName(LanguageName name) {
		for (Language language : languages) {
			if(language.getName().equals(name)) {
				return language;
			}
		}
		return null;
	}
	
	private League findLeagueByLanguage(Language language) {
		for (League league : leagues) {
			if(league.getLanguageName().equals(language.getName()) && league.getName().equals(LeagueName.Bronze)) {
				return league;
			}
		}
		return null;
	}
	
	private ArrayList<Language> generateLanguages() {
		
		Language germanLanguage=new GermanLanguage();
		Language italianLanguage=new ItalianLanguage();
		Language spanishLanguage=new SpanishLanguage();
		Language turkishLanguage=new TurkishLanguage();
		
		ArrayList<Language> languages=new ArrayList<>();
		
		languages.add(turkishLanguage);
		languages.add(germanLanguage);
		languages.add(italianLanguage);
		languages.add(spanishLanguage);
		
		return languages;

	}	
	
	private void generateLanguageContentsRandomly(ArrayList<Language> languages) {
		for (Language language : languages) {
			language.setUnitsRandomly(randomGenerator);
			language.setQuizzesRandomly(randomGenerator);
			language.setQuestionsRandomly(randomGenerator);
		}
	}
	
	private void generateLanguageContentsFromFile(ArrayList<String> lines,ArrayList<Language> languages) {
		for (Language language : languages) {
			for (String line : lines) {
				
				//language state
				if(language.getName().toString().equals(line.split(",")[0])) {
					int initialUnitNumber=1;
					boolean addToList=false;
					ArrayList<String> unitList=new ArrayList<>();
					StringBuilder stringBuilder=new StringBuilder();
					int index=1;
					for (String string : line.split(",")) {
						//start unit
						
						if(string.equals("Unit "+(initialUnitNumber+1))) {

							addToList=false;
							initialUnitNumber+=1;
							unitList.add(stringBuilder.substring(0,stringBuilder.length()-1));
							stringBuilder.delete(0, stringBuilder.length());
						}
						if(addToList) {
							stringBuilder.append(string+",");
							//end of the list
							if(line.split(",").length==index) {
								unitList.add(stringBuilder.substring(0,stringBuilder.length()-1));

							}
						}
						if(string.equals("Unit "+initialUnitNumber)) {

							addToList=true;		
						}
						index+=1;
					}
					
					language.setUnitsFromDB(unitList);
				}
				
			}
		}
	}

}
