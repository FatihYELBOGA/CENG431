package QuestionTypes;

public class ReadingQuestionType extends QuestionType {

	private String englishString;
	
	private String translatedString;
	
	public ReadingQuestionType(String englishString,String translatedString) {
		super(10,QuestionTypeName.R);
		this.englishString=englishString;
		this.translatedString=translatedString;
	}
	
	public String getEnglishString() {
		return englishString;
	}
	
	public String getTranslatedString() {
		return translatedString;
	}
	
	

}
