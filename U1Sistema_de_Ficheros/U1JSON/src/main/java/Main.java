public class Main {
    public static void main (String [] args) throws Exception {
        Record record1 = new Record("Bloodword", "36 CrazyFist", "Nu metal", "14","2024-03-12");
        Record record2 = new Record("Destroy the Map", "36 CrazyFist", "Nu metal", "15","2023-03-12");
        Transaction transaction = new Transaction();
        JSONProcessor jsonProcessor = new JSONProcessor();
        transaction.addRecord(record1);
        transaction.addRecord(record2);

        jsonProcessor.writeJSONFile(transaction);
        jsonProcessor.updateJSONFile("transactions.json");
    }
}