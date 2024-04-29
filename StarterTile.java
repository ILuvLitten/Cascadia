import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class StarterTile {

    // top = top part of starter tile
    // left = left part of starter tile
    // right = right part of starter tile

    private HabitatTile top, left, right;

    public StarterTile(HabitatTile top, HabitatTile left, HabitatTile right) {
        this.top = top;
        this.left = left;
        this.right = right;

    }
    public HabitatTile getTop() {
        return top;
    }
    public HabitatTile getLeft() {
        return left;
    }
    public HabitatTile getRight() {
        return right;
    }
}
