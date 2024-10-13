import org.json.JSONObject;

/**
 * Record class represents a single transaction record containing details
 * such as title, artist/band, genre, unit price, and date.
 */
public class Record {
    private String title;
    private String artist_band;
    private String genre;
    private String unit_price;
    private String date;

    /**
     * Constructor to initialize a Record object with specified values.
     *
     * @param title       The title of the record.
     * @param artist_band The artist or band associated with the record.
     * @param genre       The genre of the music.
     * @param unit_price  The price of the record.
     * @param date        The date associated with the record.
     */
    public Record (String title, String artist_band, String genre, String unit_price, String date){
        this.title = title;
        this.artist_band = artist_band;
        this.genre = genre;
        this.unit_price = unit_price;
        this.date = date;
    }

    /**
     * Converts the record details into a JSONObject.
     *
     * @return A JSONObject representing the record.
     */
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