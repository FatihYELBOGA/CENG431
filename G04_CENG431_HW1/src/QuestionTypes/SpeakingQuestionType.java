package QuestionTypes;

public class SpeakingQuestionType extends QuestionType{

	private Audio audio1;
	
	private Audio audio2;
	
	public SpeakingQuestionType(int length1,int length2) {
		super(8,QuestionTypeName.S);
		this.audio1=new Audio(length1);
		this.audio2=new Audio(length2);
	}
	
	 public Audio getAudio1() {
		 return audio1;
	 }
	 
	 public Audio getAudio2() {
		 return audio2;
	 }

}
