public class Main {
    public static void main (String [] args) throws Exception {
        /*var fileManager = new FileManager();
        fileManager.createFile("FileTest.txt");*/
        try {
            var xmlProcessor = new XMLProcessor();
            var updateXML = new UpdateXML();
            var doc = xmlProcessor.parseXML("exercise1.xml");
            if (doc == null){
                System.out.println("Unable to parse XML file");
            } else {
                updateXML.modifyXMLXPath(doc);
                //xmlProcessor.processNodes(doc);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}