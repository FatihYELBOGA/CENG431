package Bib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;

import org.jbibtex.BibTeXDatabase;
import org.jbibtex.BibTeXEntry;
import org.jbibtex.BibTeXParser;
import org.jbibtex.ParseException;
import org.jbibtex.TokenMgrException;
import org.jbibtex.Value;

import Paper.Article;
import Paper.ConferencePaper;
import Paper.Paper;

public class BibHelper {
	
   private String folderPath;
   
   
   public BibHelper(String folderPath) {
	   this.folderPath=folderPath;
   }
   
   public ArrayList<Paper> readBibFiles() throws FileNotFoundException, TokenMgrException, ParseException{
	   File folder = new File(folderPath);
       File[] files = folder.listFiles();
       ArrayList<Paper> papers=new ArrayList<>();
       for (File file : files) {
		if(file.getName().endsWith(".bib")) {
			papers.add(readBibFile(file));
		}
	}

       return papers;
   }

   private Paper readBibFile(File file) 
		   throws FileNotFoundException, TokenMgrException, ParseException {
	   Reader inputStream = new FileReader(file);
	   BibTeXParser parser = new BibTeXParser();
	   Paper paper = null;
       BibTeXDatabase database = parser.parse(inputStream);
       
       for (BibTeXEntry entry : database.getEntries().values()) {
          
    	   Value authorValues = entry.getField(BibTeXEntry.KEY_AUTHOR);
           String[] author=authorValues.toUserString().split(",");

           Value titleValue = entry.getField(BibTeXEntry.KEY_TITLE);
           Value yearValue = entry.getField(BibTeXEntry.KEY_YEAR);
           Value doiValue = entry.getField(BibTeXEntry.KEY_DOI);

           if(file.getName().startsWith("IP")) {
        	   paper= readConferencePaper(entry,author,titleValue,yearValue,doiValue);
           }
           else {
        	   paper= readArticlePaper(entry,author,titleValue,yearValue,doiValue);
           }
           
           
   }
       return paper;   
       }
   
   private ConferencePaper readConferencePaper(BibTeXEntry bibTeXEntry,
		   String[] author, Value titleValue,Value yearValue,Value doiValue) {
       
       Value bookTitleValue = bibTeXEntry.getField(BibTeXEntry.KEY_BOOKTITLE);
       
       return new ConferencePaper(author, titleValue.toUserString(), 
    		   Integer.parseInt(yearValue.toUserString()),
    		   doiValue.toUserString(), bookTitleValue.toUserString());


   }
   
   private Article readArticlePaper(BibTeXEntry bibTeXEntry,
		   String[] author,Value titleValue,Value yearValue,Value doiValue) {
       
	   Value volumeValue = bibTeXEntry.getField(BibTeXEntry.KEY_VOLUME);
	   Value numberValue = bibTeXEntry.getField(BibTeXEntry.KEY_NUMBER);
	   Value journalValue = bibTeXEntry.getField(BibTeXEntry.KEY_JOURNAL);
	   
	   String doiString;
	   try {
		    doiString=doiValue.toUserString();
	} catch (Exception e) {
			doiString="null";
	}
	  
       return new Article(author, titleValue.toUserString(),
    		   Integer.parseInt( yearValue.toUserString()), 
    		   doiString, Integer.parseInt(volumeValue.toUserString()), 
    		   numberValue.toUserString(), journalValue.toUserString());
   }
}
