package Questions;

import QuestionTypes.ListeningQuestionType;
import QuestionTypes.QuestionType;
import QuestionTypes.ReadingQuestionType;
import QuestionTypes.SpeakingQuestionType;
import QuestionTypes.WordMatchingQuestionType;

public class Question {
	
	private QuestionType questionType;
	
	
	public Question(QuestionType questionType) {
		this.questionType=questionType;
	}
	
	public Question(String questionTypeString) {
		//TODO
		if(questionTypeString.equals("R")) {
			this.questionType=new ReadingQuestionType(questionTypeString, questionTypeString);
		}
		else if(questionTypeString.equals("L")) {
			this.questionType=new ListeningQuestionType(1, questionTypeString);
		}
		else if(questionTypeString.equals("S")){
			this.questionType=new SpeakingQuestionType(1, 1);
		}
		else if(questionTypeString.equals("W")) {
			this.questionType=new WordMatchingQuestionType(questionTypeString, questionTypeString);
		}
	}
	
	public int getPoint() {
		return questionType.getPoint();
	}

	@Override()
	public String toString() {
		return this.questionType.toString();
	}
}
