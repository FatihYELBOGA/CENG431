package FileIO;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import Researcher.Researcher;

public class XMLReader {
	
	public static ArrayList<Researcher> readXMLFile(String path) throws ParserConfigurationException, SAXException, IOException {
		
		ArrayList<Researcher> researchers=new ArrayList<>();
		
	    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		DocumentBuilder db = dbf.newDocumentBuilder();

        Document doc = db.parse(new File(path));
        
        Element researchersElement = doc.getDocumentElement();
        
        NodeList researcherNodes = researchersElement.getElementsByTagName("researcher");

        
        for(int i=0;i<researcherNodes.getLength();i++) {
        	
            Node node = researcherNodes.item(i);
            
            if (node.getNodeType() == Node.ELEMENT_NODE) {
            	
                Element element = (Element) node;

                String researcherName = element.getElementsByTagName("name")
                        .item(0).getTextContent();
                
                String password = element.getElementsByTagName("password").item(0).getTextContent();
                ArrayList<String> followingResearcherName=new ArrayList<>();
                
                NodeList followingResearcherNodes = element.getElementsByTagName("following_researcher_names");
                Element followingResearcherElement = (Element) followingResearcherNodes.item(0);
                NodeList followingResearcherNameNodes = followingResearcherElement.getElementsByTagName("researcher_name");

                for(int j=0;j<followingResearcherNameNodes.getLength();j++) {
                    Element followingResearcherNameElement = (Element) followingResearcherNameNodes.item(j);
                	String followingString;
                	try {
                		followingString = followingResearcherNameElement.getTextContent();
					} catch (NullPointerException e) {
						followingString="";
					}
                	followingResearcherName.add(followingString);

                }
                ArrayList<String> followerResearcherName=new ArrayList<>();
                
                NodeList followerResearcherNodes = element.getElementsByTagName("follower_researcher_names");
                Element followerResearcherElement = (Element) followerResearcherNodes.item(0);
                NodeList followerResearcherNameNodes = followerResearcherElement.getElementsByTagName("researcher_name");

                for(int k=0;k<followerResearcherNameNodes.getLength();k++) {
                    Element followingResearcherNameElement = (Element) followerResearcherNameNodes.item(k);
                	String followerString;
                	try {
                    	followerString=followingResearcherNameElement.getTextContent();

					} catch (NullPointerException e) {
						followerString="";
					}
                	
                	followerResearcherName.add(followerString);

                }
                ArrayList<String> readinListNames=new ArrayList<>();
                NodeList readingListsNodes = element.getElementsByTagName("reading_lists");
                if(readingListsNodes.getLength()>0) {
                    Element readingListsElement = (Element) readingListsNodes.item(0);
                    NodeList readingListNodes = readingListsElement.getElementsByTagName("reading_list");
                    
                    for(int m=0;m<readingListNodes.getLength();m++) {
                        Element readingListElement = (Element) readingListNodes.item(m);
                        String readingListName = readingListElement.getTextContent();

                    	
                    	readinListNames.add(readingListName);

                    }
                }
                
                Researcher researcher=new Researcher(researcherName, password, 
                		followingResearcherName, followerResearcherName, readinListNames);

                researchers.add(researcher);
            }
        }
        return researchers;

	}

}
