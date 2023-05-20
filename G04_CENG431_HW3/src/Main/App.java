package Main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.jbibtex.ParseException;
import org.jbibtex.TokenMgrException;
import org.xml.sax.SAXException;

import Bib.BibHelper;
import Controllers.CreateReadingListController;
import Controllers.DownloadPaperController;
import Controllers.LoginController;
import Controllers.MainController;
import Controllers.ViewReadingListsController;
import FileIO.FileWriterC;
import FileIO.JSONReader;
import FileIO.JSONWriter;
import FileIO.XMLReader;
import Models.CreateReadingListModel;
import Models.DownloadPaperModel;
import Models.LoginModel;
import Models.ViewReadingListsModel;
import Paper.Paper;
import ReadingList.ReadingList;
import Researcher.Researcher;
import Views.CreateReadingListView;
import Views.DownloadPaperView;
import Views.LoginView;
import Views.MainView;
import Views.ViewReadingListsView;
public class App {
	
	public static void init() throws TokenMgrException, ParseException, ParserConfigurationException, SAXException, IOException, org.json.simple.parser.ParseException {
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
		
		JSONReader jsonReader=new JSONReader(papers, researchers);

		ArrayList<ReadingList> readingLists=jsonReader.readJSON(filePath.concat("/src/reading_lists.JSON"));
		Database database=new Database(researchers, papers, readingLists);
		
		LoginModel loginModel = new LoginModel(researchers);
        LoginView loginView = new LoginView();
        MainView mainView=new MainView();
        LoginController controller = new LoginController(loginModel,loginView,mainView);	


        ViewReadingListsView viewReadingListsView= new ViewReadingListsView(database.getReadingLists());
        ViewReadingListsModel viewReadingListsModel=new ViewReadingListsModel(database.getReadingLists(),database.getReadingLists().get(0));
        ViewReadingListsController viewReadingListsController=new ViewReadingListsController(viewReadingListsModel,viewReadingListsView,mainView);

        
        CreateReadingListView createReadingListView=new CreateReadingListView(papers);
        CreateReadingListController createReadingListController=new CreateReadingListController(mainView,createReadingListView,loginModel,database,viewReadingListsView);
        CreateReadingListModel createReadingListModel=new CreateReadingListModel();
        
       
        DownloadPaperView downloadPaperView=new DownloadPaperView(paperStrings,papers.get(0));
        DownloadPaperModel downloadPaperModel=new DownloadPaperModel(papers);
        DownloadPaperController downloadPaperController=new DownloadPaperController(downloadPaperModel,downloadPaperView,mainView);
        MainController mainController=new MainController(mainView,loginView,downloadPaperView,createReadingListView,viewReadingListsView);


        
        loginModel.addObserver(loginView);
        downloadPaperModel.addObserver(downloadPaperView);
        createReadingListModel.addObserver(createReadingListView);
        viewReadingListsModel.addObserver(viewReadingListsView);
        loginModel.addObserver(viewReadingListsView);
        
        loginView.loginAction(controller);
        mainView.mainAction(mainController);
        downloadPaperView.downloadPageAction(downloadPaperController);
        createReadingListView.createPageAction(createReadingListController);
        viewReadingListsView.viewReadingsAction(viewReadingListsController);
        }
	

}
