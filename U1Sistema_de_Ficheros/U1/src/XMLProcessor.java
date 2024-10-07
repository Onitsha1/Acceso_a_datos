import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;

public class XMLProcessor {
    //Get DOM from an XML file
    public Document parseXML(String fileNameXML) throws IOException, SAXException, ParserConfigurationException,
            FileNotFoundException {
        /*Create an instance of DocumentsBuilderFactory (an abstract class with a protected constructor that
         * is instantiated by creating an instance of its subclass)
         */
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            //Create an instance of DocumentBuilder from the dbFactory instance
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            // Parse the XML file with DocumentBuilder
            return dBuilder.parse(new File(fileNameXML));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void processNodes(Document root) {
        try {
            //Get a list of child elements from parent element
            NodeList childElements = root.getElementsByTagName("record");
            //Iterate over every element in the list
            for (int i = 0; i < childElements.getLength(); i++) {
                Element childElement = (Element) childElements.item(i);
                // Print the current child element number
                System.out.println(" ");
                System.out.println("Record " + (i + 1));
                //Print tag values
                String title = getTagValue(childElement,"title");
                double unit_price = Double.parseDouble(getTagValue(childElement,"unit_price"));
                String date = getTagValue(childElement, "date");
                System.out.println("Title: " + title);
                System.out.println("Unit price: " + unit_price);
                System.out.println("Date: " + date);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getTagValue(Element element, String tag) {
        /*Fetches the text content of the first element with the specified tag name (assuming no duplicate tags
         within the same element)*/
        return element.getElementsByTagName(tag).item(0).
                getTextContent();
    }
}