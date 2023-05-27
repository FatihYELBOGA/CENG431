package Paper;

public class ConferencePaper extends Paper{
	
	private String bookTitle;

	public ConferencePaper(String[] author, String title, int year, String doi,String bookTitle,String pathName) {
		super(author, title, year, doi,pathName);
		this.bookTitle=bookTitle;
	}

	//copy constructor
		public ConferencePaper(String string) {
	 		super(string.split(",")[1].split(";"), string.split(",")[2],
	 				Integer.parseInt(string.split(",")[3]),string.split(",")[6],string.split(",")[7]);
	 		this.bookTitle=string.split(",")[5];
		}
	
	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	
	public String otherStrings() {
		return this.bookTitle;
	}
		
	public String toString() {
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append("conference paper,");
		
	    for (String author : this.getAuthor()) {
			stringBuilder.append(author+";");
		}
		stringBuilder.delete(stringBuilder.length()-1, stringBuilder.length());
		
		stringBuilder.append(","+this.getTitle()+",");
		stringBuilder.append(this.getYear()+",");
		stringBuilder.append(this.getDoi()+",");
		stringBuilder.append(this.getBookTitle()+",");
		stringBuilder.append(this.getNumberOfDownloads());
		
		return stringBuilder.toString();
	}

}
