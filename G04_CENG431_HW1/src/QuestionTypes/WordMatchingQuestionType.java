package QuestionTypes;

public class WordMatchingQuestionType extends QuestionType{
	
	private String keyString;
	
	private String valueString;

	public WordMatchingQuestionType(String keyString,String valueString) {
		super(5,QuestionTypeName.W);
		this.keyString=keyString;
		this.valueString=valueString;
	}
	
	public String getKeyString() {
		return keyString;
	}
	
	public String getValueString() {
		return valueString;
	}

}
