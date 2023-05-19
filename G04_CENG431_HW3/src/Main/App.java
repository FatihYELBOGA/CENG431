package Main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.jbibtex.ParseException;
import org.jbibtex.TokenMgrException;
import org.xml.sax.SAXException;

import Bib.BibHelper;
import Controllers.DownloadPaperController;
import Controllers.LoginController;
import Controllers.MainController;
import FileIO.FileWriterC;
import FileIO.XMLReader;
import Models.DownloadPaperModel;
import Models.LoginModel;
import Models.ResearcherModel;
import Paper.Paper;
import Researcher.Researcher;
import Views.DownloadPaperView;
import Views.LoginView;
import Views.MainView;
public class App {
	
	public static void init() throws TokenMgrException, ParseException, ParserConfigurationException, SAXException, IOException {
		String filePath = new File("").getAbsolutePath();

		BibHelper bibHelper=new BibHelper(filePath.concat("/src/Homework3"));
		ArrayList<Paper> papers=bibHelper.readBibFiles();
		String[] paperStrings=new String[papers.size()];
		for(int i=0;i<papers.size();i++) {
			
			paperStrings[i]=papers.get(i).getTitle();
		}
 		String csvString=filePath.concat("/src/papers.csv");
		
		FileWriterC.writeBibFilesToCSV(csvString,bibHelper.readBibFiles());
		
		ArrayList<Researcher> researchers=XMLReader.readXMLFile(filePath.concat("/src/researchers.xml"));
		
		ResearcherModel researcherModel=new ResearcherModel(researchers);
		
		
		LoginModel loginModel = new LoginModel(researchers);
        LoginView loginView = new LoginView();
        MainView mainView=new MainView();
        
        DownloadPaperView downloadPaperView=new DownloadPaperView(paperStrings,papers.get(0));
        DownloadPaperModel downloadPaperModel=new DownloadPaperModel(papers);
        DownloadPaperController downloadPaperController=new DownloadPaperController(downloadPaperModel,downloadPaperView);
        MainController mainController=new MainController(mainView,loginView,downloadPaperView);

        LoginController controller = new LoginController(loginModel,loginView,mainView);	

        loginModel.addObserver(loginView);
        
        loginView.loginAction(controller);
        mainView.mainAction(mainController);
        downloadPaperView.downloadPageAction(downloadPaperController);
        }
	

}
