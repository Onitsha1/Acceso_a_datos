import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * JSONProcessor is a class that provides methods to create, load, and update JSON files.
 */
public class JSONProcessor {

    /**
     * Creates a new JSON file with the specified transaction data.
     *
     * @param transaction The JSONObject representing the transaction data to be written to the file.
     */
    public void createJSONFile (JSONObject transaction) {
        try (FileWriter file = new FileWriter("transactions.json")) {
            file.write(transaction.toString(4));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Writes the JSON file based on the provided transaction object.
     *
     * @param transaction The Transaction object containing records to be processed.
     */
    public void writeJSONFile(Transaction transaction){
        if (transaction.getRecords().isEmpty()){
            System.out.println("No records found.");
            return;
        }
        createJSONFile(transaction.getAsJSON());
        System.out.println("JSON file created successfully.");
    }

    /**
     * Loads the JSON file and returns its content as a JSONObject.
     *
     * @param JSONFile The name of the JSON file to be loaded.
     * @return The JSONObject containing the content of the file.
     */
    public JSONObject loadJSONFile(String JSONFile){
        try (FileReader file = new FileReader(JSONFile)){
            StringBuilder myJSON = new StringBuilder();
            int i;
            while ((i = file.read()) != -1){ //i equals numeric value of the char read. Returns -1 if empty
                myJSON.append((char) i); // Explicit casting i to the corresponding char
            }
            System.out.println("File loaded successfully.");
            return new JSONObject(myJSON.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Updates the JSON file by incrementing the unit_price of each transaction.
     *
     * @param JSONFile The name of the JSON file to be updated.
     */
    public void updateJSONFile (String JSONFile){
        try {
            JSONObject recordsJSON = loadJSONFile(JSONFile);
            // Retrieve the array of transactions from the loaded JSON object
            JSONArray recordsArray = recordsJSON.getJSONArray("transactions");
            for (int i = 0; i < recordsArray.length(); i++) {
                JSONObject record = recordsArray.getJSONObject(i);
                int unit_price = record.getInt("unit_price");
                // Increment the unit price by 1
                record.put("unit_price", unit_price + 1);
            }
            // Create a FileWriter to write the updated JSON data back to the same file
            FileWriter fileWriter = new FileWriter(JSONFile);
            fileWriter.write(recordsJSON.toString(4));
            fileWriter.close();
            System.out.println("JSON file updated successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}