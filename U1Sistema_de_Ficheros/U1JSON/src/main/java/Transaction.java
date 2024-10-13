import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileWriter;
import java.util.ArrayList;

public class Transaction {
    ArrayList<Record> records = new ArrayList<>();

    public void addRecord(Record record){
        records.add(record);
    }

    public ArrayList<Record> getRecords (){
        return records;
    }
}
