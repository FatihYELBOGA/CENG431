package QuestionTypes;

public abstract class QuestionType {
	
	private int point;
	
	private QuestionTypeName symbol;
	
	public QuestionType(int point,QuestionTypeName symbol) {
		this.point=point;
		this.symbol=symbol;
	}
	
	public int getPoint() {
		return point;
	}

	@Override()
	public String toString() {
		return this.symbol.toString();
	}
}
