import org.w3c.dom.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

public class UpdateXML {
    /**
     * Modifies the given XML Document by adding a new <record> element under the <transactions> node.
     * The <record> contains child elements such as <title>, <artist_band>, <genre>, <unit_price>, and <date>.
     *
     * @param doc The XML DOM Document to be modified.
     */
    public void modifyXML (Document doc){
        try (FileOutputStream output = new FileOutputStream("exercise1.xml")){
            // Retrieve the first "transactions" element to append the new child element
            NodeList transacList = doc.getElementsByTagName("transactions");
            if (transacList.getLength() > 0){
                //Creates a new child element
                Element record = doc.createElement("record");

                Element title = doc.createElement("title"); //Creates the specified tag
                title.appendChild(doc.createTextNode("Disasterpiece"));//Gives a value to it
                record.appendChild(title); //Adds it to the new child element

                Element artist_band = doc.createElement("artist_band");
                artist_band.appendChild(doc.createTextNode("Slipknot"));
                record.appendChild(artist_band);

                Element genre = doc.createElement("genre");
                genre.appendChild(doc.createTextNode("Nu"));
                record.appendChild(genre);

                Element unit_price = doc.createElement("unit_price");
                unit_price.appendChild(doc.createTextNode("12"));
                record.appendChild(unit_price);

                Element date = doc.createElement("date");
                date.appendChild(doc.createTextNode("2023-12-08"));
                record.appendChild(date);
                //Appends the new child element to the root node (the first one on the list)
                Element transactions = (Element) transacList.item(0);
                transactions.appendChild(record);
                //Creates a Transformer object to output the modified DOM to the specified XML
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                /*As the Transformer class requires an input object that implements
                the Source interface, the DOM Document must be wrapped into a Source*/
                DOMSource source = new DOMSource(doc);
                /*The output file must be wrapped into a Result to be transformed */
                StreamResult result = new StreamResult(output);
                transformer.transform(source, result);
                System.out.println("XML file successfully updated");
            }
       } catch (TransformerException | IOException e) {
            e.printStackTrace();
        }
    }
}