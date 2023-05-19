package Paper;

public abstract class Paper {
	
	private String[] author;
	
	private String title;
	
	private int year;
	
	private String doi;

	public Paper(String[] author, String title, int year, String doi) {
		super();
		this.author = author;
		this.title = title;
		this.year = year;
		this.doi = doi;
	}

	public String[] getAuthor() {
		return author;
	}
	
	public String getAuthorsString(){
		StringBuilder stringBuilder=new StringBuilder();
		for (String author : author) {
			stringBuilder.append(author);
		}
		return stringBuilder.toString();
	}

	public void setAuthor(String[] author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getDoi() {
		return doi;
	}

	public void setDoi(String doi) {
		this.doi = doi;
	}
	
	


}
