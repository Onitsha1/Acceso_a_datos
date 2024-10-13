import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;

/**
 * Transaction class represents a collection of transaction records.
 * It provides methods to add records and convert them into JSON format.
 */
public class Transaction {
    ArrayList<Record> records = new ArrayList<>();

    /**
     * Adds a new record to the transaction.
     *
     * @param record The Record object to be added to the transaction.
     */
    public void addRecord(Record record){
        records.add(record);
    }

    /**
     * Converts the transaction records into a JSONObject.
     *
     * @return A JSONObject representing the transactions.
     */
    public JSONObject getAsJSON(){
        JSONObject jsonTransaction = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        for (Record it : records){
            JSONObject recordJson = it.getAsJSON();
            jsonArray.put(recordJson);
            jsonTransaction.put("transactions", jsonArray);
        }
        return jsonTransaction;
    }

    /**
     * Getter for the list of records in the transaction.
     *
     * @return An ArrayList of Record objects.
     */
    public ArrayList<Record> getRecords (){
        return records;
    }
}