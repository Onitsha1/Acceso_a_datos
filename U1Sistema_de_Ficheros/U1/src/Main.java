public class Main {
    public static void main (String [] args) throws Exception {
        /*var fileManager = new FileManager();
        fileManager.createFile("FileTest.txt");*/
        try {
            var xmlProcessor = new XMLProcessor();
            var doc = xmlProcessor.parseXML("exercise1.xml");
            if (doc == null){
                System.out.println("Unable to parse XML file");
            } else {
                xmlProcessor.processNodes(doc);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}