import org.json.JSONObject;

public class Record {
    private String title;
    private String artist_band;
    private String genre;
    private String unit_price;
    private String date;

    public Record (String title, String artist_band, String genre, String unit_price, String date){
        this.title = title;
        this.artist_band = artist_band;
        this.genre = genre;
        this.unit_price = unit_price;
        this.date = date;
    }
    public JSONObject getAsJSON (){
        JSONObject record = new JSONObject();
        record.put("title", this.title);
        record.put("artist_band", this.artist_band);
        record.put("genre", this.genre);
        record.put("unit_price", this.unit_price);
        record.put("date", this.date);
        return record;
    }
}
