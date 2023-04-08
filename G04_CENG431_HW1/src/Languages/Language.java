package Languages;

import java.util.ArrayList;

import Quizzes.Quiz;
import Random.RandomGenerator;
import Units.Unit;




public  abstract class Language {
	
	private ArrayList<Unit> units;
	
	private LanguageName name;
		
	public Language(ArrayList<Unit> units,LanguageName name) {
		this.units=units;
		this.name=name;
	}
	public Language(LanguageName name) {
		this.name=name;
	}
	
	public LanguageName getName() {
		return name;
	}
	
	public ArrayList<Unit> getUnits(){
		return units;
	}
	
	public int getNumberOfUnits() {
		return units.size();
	}
	
	public int getNumberOfQuiz() {
		int number=0;
		for (Unit unit : units) {
			number+=unit.getNumberOfQuiz();
		}
		return number;
	}
	
	public void setQuizzesRandomly(RandomGenerator randomGenerator) {
		
		for (Unit unit : units) {
			ArrayList<Quiz> quizzes=generateQuizzesOfUnit(randomGenerator);
			unit.setQuizzes(quizzes);
		}
	}
	
	public void setQuestionsRandomly(RandomGenerator randomGenerator) {
		for (Unit unit : units) {
			unit.setQuestionsRandomly(randomGenerator);
		}
	}
	
	public void setUnitsRandomly(RandomGenerator randomGenerator) {
		this.units=generateUnitsOfLanguage(randomGenerator);
	}
	
	public void setUnitsFromDB(ArrayList<String> list) {
		this.units=new ArrayList<>();
		for (String string : list) {
			
			Unit unit=new Unit();
			
			unit.setQuizzesByDB(string);
			units.add(unit);
			
		}
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder=new StringBuilder("");
		stringBuilder.append(this.name+",");
		int index=1;
		for (Unit unit : units) {
			stringBuilder.append("Unit "+index+","+unit.toString());
			index+=1;
		}
		return stringBuilder.toString();
	}
	
	private ArrayList<Quiz> generateQuizzesOfUnit(RandomGenerator randomGenerator) {
		
		int quizCount=randomGenerator.generateRandomInterval(1, 10);
		
		ArrayList<Quiz> quizzes=new ArrayList<>();
		
		for(int i=0;i<quizCount;i++) {
			quizzes.add(new Quiz());
		}
		return quizzes;
	}
	
	private ArrayList<Unit> generateUnitsOfLanguage(RandomGenerator randomGenerator){
		
		int unitCount=randomGenerator.generateRandomInterval(60, 100);
		
		ArrayList<Unit> units=new ArrayList<>();
		
		for(int i=0;i<unitCount;i++) {
			units.add(new Unit());
		}
		return units;
	}
}
