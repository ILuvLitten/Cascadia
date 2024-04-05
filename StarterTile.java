import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class StarterTile {
    private BufferedImage image;
    private ArrayList<HabitatTile> listOfTiles;

    public StarterTile(BufferedImage image, ArrayList<HabitatTile> listOfTiles) {
        this.image = image;
        this.listOfTiles = listOfTiles;
    }
    public ArrayList<HabitatTile> getListOfTiles() {
        return listOfTiles;
    }
}
