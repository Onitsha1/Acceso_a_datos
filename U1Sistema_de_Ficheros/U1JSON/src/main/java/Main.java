public class Main {
    public static void main (String [] args) throws Exception {
        Record record1 = new Record("Bloodword", "36 CrazyFist", "Nu metal", "14","2024-03-12");
        Record record2 = new Record("Destroy the Map", "36 CrazyFist", "Nu metal", "15","2023-03-12");
        Transaction transaction = new Transaction();
        WriteJSONFile wjf = new WriteJSONFile();
        Ficheros\U1JSON\src\main\java
        transaction.addRecord(record1);
        transaction.addRecord(record2);

        wjf.writeJSONFile(transaction);
    }
}