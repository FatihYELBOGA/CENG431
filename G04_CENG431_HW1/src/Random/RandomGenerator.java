package Random;

import java.util.Random;

import Languages.GermanLanguage;
import Languages.ItalianLanguage;
import Languages.Language;
import Languages.LanguageName;
import Languages.SpanishLanguage;
import Languages.TurkishLanguage;
import QuestionTypes.ListeningQuestionType;
import QuestionTypes.QuestionType;
import QuestionTypes.ReadingQuestionType;
import QuestionTypes.SpeakingQuestionType;
import QuestionTypes.WordMatchingQuestionType;

public class RandomGenerator {
    Random random;
    
    public RandomGenerator(Random random) {
    	this.random=random;
    }

	public LanguageName generateRandomLanguage() {
        int randomInt = random.nextInt(4);
        
        if(randomInt==0) {
        	return LanguageName.Turkish;
        }
        else if(randomInt==1) {
        	return LanguageName.German;
        }
        else if(randomInt==2) {
        	return LanguageName.Italian;
        }
        else {
        	return LanguageName.Spanish;
        }
	}
	
	public QuestionType generateRandomQuestionType() {
        int randomInt = random.nextInt(4);
        if(randomInt==0) {
        	String englishString=generateRandomString(10);
        	String translatedString=generateRandomString(10);
        	return new ReadingQuestionType(englishString,translatedString);
        }
        else if(randomInt==1) {
        	int length=random.nextInt(0,10);
        	String string=generateRandomString(10);
        	return new ListeningQuestionType(length,string);
        }
        else if(randomInt==2) {
        	int length1=random.nextInt(0,10);
        	int length2=random.nextInt(0,10);
        	return new SpeakingQuestionType(length1,length2);
        }
        else {
        	String keyString=generateRandomString(10);
        	String valueString=generateRandomString(10);
        	
        	return new WordMatchingQuestionType(keyString,valueString);
        }
	}
	
	public String generateRandomString(int size) {
	       String letters = "abcdefghijklmnopqrstuvwxyz";
	       StringBuilder stringBuilder=new StringBuilder();
	       for(int i=0;i<size;i++) {
	    	   int index=generateRandomInterval(0, letters.length()-1);
	    	   char c=letters.toCharArray()[index];
	    	   stringBuilder.append(c);
	       }
	       return stringBuilder.toString();
	}
	
	public int generateRandomInterval(int lower,int upper) {
		int randomInt = random.nextInt(upper-lower+1);
		return randomInt+lower;
	}

}
