package Paper;

public class Article extends Paper{
	
	private int volume;
	
	private String number;
	
	private String journal;

	public Article(String[] author, String title, int year, String doi,
			int volume,String number,String journal,String pathName) {
		super(author, title, year, doi,pathName);
		this.volume=volume;
		this.number=number;
		this.journal=journal;
	}

	//copy constructor
	public Article(String string) {
 		super(string.split(",")[1].split(";"), string.split(",")[2],
 				Integer.parseInt(string.split(",")[3]),string.split(",")[6],string.split(",")[7]);
 		this.volume=Integer.parseInt(string.split(",")[4]);
 		this.number=string.split(",")[5];
 		this.journal=string.split(",")[7];
	}
	
	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getJournal() {
		return journal;
	}

	public void setJournal(String journal) {
		this.journal = journal;
	}
	public String otherStrings() {
		return this.journal+this.number+this.volume;
	}
	public String toString() {
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append("article,");
		
	    for (String author : this.getAuthor()) {
			stringBuilder.append(author+";");
		}
		stringBuilder.delete(stringBuilder.length()-1, stringBuilder.length());
		
		stringBuilder.append(","+this.getTitle()+",");
		stringBuilder.append(this.getYear()+",");
		stringBuilder.append(this.getVolume()+",");
		stringBuilder.append(this.getNumber()+",");
		stringBuilder.append(this.getDoi()+",");
		stringBuilder.append(this.getJournal()+",");
		stringBuilder.append(this.getNumberOfDownloads());
		return stringBuilder.toString();
	}
	
}
