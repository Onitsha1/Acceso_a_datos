import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;

/**
 * XMLProcessor is a class responsible for parsing XML files and processing their content.
 * It utilizes the Document Object Model (DOM) to represent and manipulate XML data.
 */
public class XMLProcessor {
    /**
     * Parses the specified XML file and returns its DOM representation as a Document object.
     *
     * @param fileNameXML The name of the XML file to be parsed.
     * @return The Document object representing the XML structure.
     * @throws IOException If there is an error reading the file.
     * @throws SAXException If there is an error parsing the XML.
     * @throws ParserConfigurationException If there is a configuration error with the parser.
     * @throws FileNotFoundException If the specified file does not exist.
     */
    public Document parseXML(String fileNameXML) throws IOException, SAXException, ParserConfigurationException,
            FileNotFoundException {
        /*Create an instance of DocumentsBuilderFactory (an abstract class with a protected constructor that
         * is instantiated by creating an instance of its subclass)
         */
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            //Create an instance of DocumentBuilder from the dbFactory instance
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            // Parse the XML file with DocumentBuilder to a DOM Document object
            System.out.println("XML file parsed successfully");
            return dBuilder.parse(new File(fileNameXML));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Processes the nodes of the given XML Document, specifically looking for <record> elements,
     * and prints their details to the console.
     *
     * @param root The root Document object representing the parsed XML.
     */
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

    /**
     * Retrieves the text content of the first child element with the specified tag name within the given element.
     *
     * @param element The parent element containing the desired tag.
     * @param tag The name of the tag to retrieve the value from.
     * @return The text content of the specified tag, or null if the tag does not exist.
     */
    private String getTagValue(Element element, String tag) {
        /*Fetches the text content of the first element with the specified tag name (assuming no duplicate tags
         within the same element)*/
        return element.getElementsByTagName(tag).item(0).
                getTextContent();
    }
}