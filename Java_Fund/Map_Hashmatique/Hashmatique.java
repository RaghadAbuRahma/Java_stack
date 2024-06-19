import java.util.HashMap;

public class Hashmatique{
    public static void main(String[] args) {
        HashMap<String, String> myMap = new HashMap<String, String>();
        myMap.put("Song1","bla");
        myMap.put("Song2","bla bla");
        myMap.put("Song3","bla bla bla");
        myMap.put("Song4","bla bla bla bla");
        for(String key : myMap.keySet()){
            System.out.println(String.format("Song: %s - Lyrics: %s", key, myMap.get(key)));

    }
}
}