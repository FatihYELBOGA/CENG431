package QuestionTypes;

public class ListeningQuestionType extends QuestionType{
	
	private String string;
	
	private Audio audio;

	public ListeningQuestionType(int length,String string) {
		super(7,QuestionTypeName.L);
		this.audio=new Audio(length);
		this.string=string;
	}
	
	public Audio getAudio() {
		return audio;
	}
	
	public String getString() {
		return string;
	}

}
