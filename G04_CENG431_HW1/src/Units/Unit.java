package Units;

import java.util.ArrayList;

import QuestionTypes.QuestionType;
import Questions.Question;
import Quizzes.Quiz;
import Random.RandomGenerator;

public class Unit {
	
	private ArrayList<Quiz> quizzes;
	
	public ArrayList<Quiz> getQuizzes(){
		return quizzes;
	}
	
	public void setQuizzes(ArrayList<Quiz> quizzes) {
		this.quizzes=quizzes;
	}
	
	public void setQuizzesByDB(String quizzesString) {
		ArrayList<Quiz> quizzes=new ArrayList<>();
		int initialQuizNumber=1;
		for (String string : quizzesString.split(",")) {
			if(string.equals("Quiz "+initialQuizNumber)) {
				
			}
			else if (string.equals("Quiz "+(initialQuizNumber+1))) {
				initialQuizNumber+=1;
			}
			else {
				Quiz quiz=new Quiz();
				quiz.setQuestionFromDB(string);
				quizzes.add(quiz);
			}
		}
		this.quizzes=quizzes;
	}
	
	public void setQuestionsRandomly(RandomGenerator randomGenerator) {
		for (Quiz quiz : quizzes) {
			ArrayList<Question> questions=quiz.generateQuestionsOfQuizz(randomGenerator);
			
			quiz.setQuestions(questions);
		}
	}
		
	public int getNumberOfQuiz() {
		return quizzes.size();
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder=new StringBuilder("");
		int index=1;
		for (Quiz quiz : quizzes) {
			String appendString="Quiz "+index+","+quiz.toString()+",";
			stringBuilder.append(appendString);
			index+=1;
		}
		return stringBuilder.substring(0, stringBuilder.length());
	}
	


}
