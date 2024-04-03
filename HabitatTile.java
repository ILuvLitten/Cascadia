import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class HabitatTile {
    private int terrain1;
    private int terrain2;
    private boolean canHoldHawk;
    private boolean canHoldFox;
    private boolean canHoldBear;
    private boolean canHoldSalmon;
    private boolean canHoldElk;
    private boolean isKeystone;
    private boolean containsAnimal;
    private boolean animalOnTile;
    private BufferedImage image;
    private ArrayList<HabitatTile> neighbours;

    public HabitatTile(int terrain1, int terrain2, boolean canHoldHawk, boolean canHoldFox, boolean canHoldBear, boolean canHoldSalmon, boolean canHoldElk, boolean isKeystone, boolean containsAnimal, boolean animalOnTile, BufferedImage image) {
        this.terrain1 = terrain1;
        this.terrain2 = terrain2;
        this.canHoldHawk = canHoldHawk;
        this.canHoldFox = canHoldFox;
        this.canHoldBear = canHoldBear;
        this.canHoldSalmon = canHoldSalmon;
        this.canHoldElk = canHoldElk;
        this.isKeystone = isKeystone;
        this.containsAnimal = containsAnimal;
        this.animalOnTile = animalOnTile;
        this.image = image;

    }
    public int getTerrain1() {
        return terrain1;
    }
    public  void setTerrain1(int terrain1) {
        this.terrain1 = terrain1;
    }
    public int getTerrain2() {
        return terrain2;
    }
    public void setTerrain2(int terrain2) {
        this.terrain2 = terrain2;
    }
    public boolean getCanHoldHawk() {
        return canHoldHawk;
    }
    public boolean getCanHoldFox() {
        return canHoldFox;
    }
    public boolean getCanHoldBear() {
        return canHoldBear;
    }
    public boolean getCanHoldSalmon() {
        return canHoldSalmon;
    }
    public boolean getCanHoldElk() {
        return canHoldElk;
    }
    public boolean getIsKeystone() {
        return isKeystone;
    }
    public boolean getContainsAnimal() {
        return containsAnimal;
    }
    public void setContainsAnimal(boolean containsAnimal) {
        this.containsAnimal = containsAnimal;
    }
    public boolean getAnimalOnTile() {
        return animalOnTile;
    }
    public BufferedImage getImage() {
        return image;
    }
    public void setImage(BufferedImage image) {
        this.image = image;
    }
    public void rotate() {
    }
    public ArrayList<HabitatTile> getNeighbours() {
        return neighbours;
    }
}

