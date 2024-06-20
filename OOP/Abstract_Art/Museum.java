import java.util.ArrayList;
import java.util.Collections;


public class Museum {
    public static void main(String[] args) {
        Painting painting1 = new Painting("monaliza", "Divinchi" , "monaliza");
        painting1.setPaintType("oil") ;
        Painting painting2 = new Painting("theLastSupper", "Divinchi", "theLastSupper");
        painting2.setPaintType("oil") ;
        Painting painting3 = new Painting("starryNight", "Van gogh", "starryNight");
        painting3.setPaintType("oil") ;
        Sculpture sculpture1 = new Sculpture("scul1", "author1", "desc1");
        sculpture1.setMaterial("mud");
        Sculpture sculpture2 = new Sculpture("scul2", "author2", "desc2");
        sculpture2.setMaterial("mud");

    

        ArrayList<Art> museum = new ArrayList<Art> ();
        museum.add(painting1);
        museum.add(painting2);
        museum.add(painting3);
        museum.add(sculpture1);
        museum.add(sculpture2);

        Collections.shuffle(museum);
        for (Art x : museum){
                x.viewArt();
        }






    }
}