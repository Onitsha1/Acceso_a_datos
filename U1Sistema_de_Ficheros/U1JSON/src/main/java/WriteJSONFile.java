import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;

public class WriteJSONFile {

    public JSONObject rootToJSON(Transaction transaction){
        JSONObject jsonTransaction = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        for (Record it : transaction.getRecords()){
            JSONObject recordJson = it.getAsJSON();
            jsonArray.put(recordJson);
            jsonTransaction.put("transaction", jsonArray);
        }
        return jsonTransaction;
    }

    public void createJSONFile (JSONObject transaction) {
        try (FileWriter file = new FileWriter("transactions.json")) {
            file.write(transaction.toString(4));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeJSONFile(Transaction transaction){
        if (transaction.getRecords().isEmpty()){
            System.out.println("No records found.");
            return;
        }
        createJSONFile(rootToJSON(transaction));
        System.out.println("JSON file created successfully.");
    }
}
