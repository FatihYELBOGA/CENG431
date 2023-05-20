package Paper;

import java.util.ArrayList;
import java.util.Random;

public abstract class Paper {
	
	private String[] author;
	
	private String title;
	
	private int year;
	
	private String doi;
	
	private int numberOfDownloads;
	
	private Random random;

	public Paper(String[] author, String title, int year, String doi) {
		this.random=new Random();
		this.author = author;
		this.title = title;
		this.year = year;
		this.doi = doi;
		numberOfDownloads=random.nextInt(1500);
	}
	
	public static Paper findPaperByTitle(String name,ArrayList<Paper> papers) {
		for (Paper paper : papers) {
			if(paper.getTitle().equals(name)) {
				return paper;
			}
		}
		return null;
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
	
	public int getNumberOfDownloads() {
		return numberOfDownloads;
	}
	
	public String otherStrings() {
		return this.title;
	}


}
