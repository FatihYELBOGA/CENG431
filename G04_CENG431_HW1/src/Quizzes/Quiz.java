package Quizzes;

import java.util.ArrayList;

import QuestionTypes.QuestionType;
import Questions.Question;
import Random.RandomGenerator;

public class Quiz {

	private ArrayList<Question> questions;
	
	public Quiz(ArrayList<Question> questions) {
		this.questions=questions;
	}
	
	public Quiz() {
		this.questions=new ArrayList<>();
	}
	
	public ArrayList<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
	}
	
	public void setQuestionFromDB(String questionString) {
		for (String string : questionString.split(":")) {
			
			int numberOfQuestion=Integer.parseInt(string.substring(0,string.length()-1));
			String typeOfQuestion=string.substring(string.length()-1,string.length());
			
			for(int i=0;i<numberOfQuestion;i++) {
				Question question=new Question(typeOfQuestion);
				this.questions.add(question);
			}
			
		}
	}

	public String toString() {
		int numberOfListening=0;
		int numberOfReading=0;
		int numberOfSpeaking=0;
		int numberOfWordMatching=0;
		StringBuilder stringBuilder=new StringBuilder("");

		for (Question question : questions) {
			if(question.toString().equals("L")) {
				numberOfListening+=1;
			}
			else if(question.toString().equals("R")) {
				numberOfReading+=1;
			}
			else if(question.toString().equals("S")) {
				numberOfSpeaking+=1;
			}
			else {
				numberOfWordMatching+=1;
			}
		}
		if(numberOfReading!=0) {
			stringBuilder.append(numberOfReading+"R"+":");
		}
		if(numberOfListening!=0) {
			stringBuilder.append(numberOfListening+"L"+":");
		}
		if(numberOfSpeaking!=0) {
			stringBuilder.append(numberOfSpeaking+"S"+":");
		}
		if(numberOfWordMatching!=0) {
			stringBuilder.append(numberOfWordMatching+"W"+":");
		}
		return stringBuilder.substring(0, stringBuilder.length()-1);

	}
	public ArrayList<Question> generateQuestionsOfQuizz(RandomGenerator randomGenerator){

		int questionCount= randomGenerator.generateRandomInterval(8, 15);

		ArrayList<Question> questions=new ArrayList<>();

		for(int i=0;i<questionCount;i++) {
			QuestionType questionType=randomGenerator.generateRandomQuestionType();
			questions.add(new Question(questionType));
		}
		return questions;
	}
}
