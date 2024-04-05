import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;

public class TilePile {
    private ArrayList<HabitatTile> pile;

    public TilePile() {
        pile = new ArrayList<HabitatTile>();
    }

    public void addTile(HabitatTile tile) {
        pile.add(tile);
    }

    public HabitatTile draw() {
        return pile.remove(0);
    }

    public void shuffle() {
        Collections.shuffle(pile);
    }

    public int size() {
        return pile.size();
    }
    public BufferedImage drawImage() {
        return pile.get(0).getImage();
    }
    public ArrayList<HabitatTile> getPile() {
        return pile;
    }

}
