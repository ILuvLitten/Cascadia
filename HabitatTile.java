import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class HabitatTile {

    private int terrain0;
    private int terrain1;
    private int terrain2;
    private int terrain3;
    private int terrain4;
    private int terrain5;

    private int totalTerrain1;
    private int totalTerrain2;
    private boolean canHoldHawk;
    private boolean canHoldFox;
    private boolean canHoldBear;
    private boolean canHoldSalmon;
    private boolean canHoldElk;
    private boolean isKeystone;
    private boolean containsAnimal;
    private boolean animalOnTile;
    private BufferedImage image;
    private AnimalToken token;
    private ArrayList<HabitatTile> neighbours;

    public HabitatTile(int terrain1, int terrain2, boolean canHoldHawk, boolean canHoldFox, boolean canHoldBear, boolean canHoldSalmon, boolean canHoldElk, boolean isKeystone, BufferedImage image) {
        this.terrain1 = terrain2;
        this.terrain2 = terrain2;
        this.terrain3 = terrain2;
        this.terrain0 = terrain1;
        this.terrain4 = terrain1;
        this.terrain5 = terrain1;
        totalTerrain1 = terrain1;
        totalTerrain2 = terrain2;
        this.canHoldHawk = canHoldHawk;
        this.canHoldFox = canHoldFox;
        this.canHoldBear = canHoldBear;
        this.canHoldSalmon = canHoldSalmon;
        this.canHoldElk = canHoldElk;
        this.isKeystone = isKeystone;
        this.containsAnimal = false;
        this.animalOnTile = false;
        this.image = image;
        this.token = null;
    }
    public int getTerrain1() {
        return totalTerrain1;
    }

    public int getTerrain2() {
        return totalTerrain2;
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
    public void rotateCW() {
        int temp = terrain0;
        terrain0 = terrain5;
        terrain5 = terrain4;
        terrain4 = terrain3;
        terrain3 = terrain2;
        terrain2 = terrain1;
        terrain1 = temp;
    }

    public void rotateCCW() {
        int temp = terrain0;
        terrain0 = terrain1;
        terrain1 = terrain2;
        terrain2 = terrain3;
        terrain3 = terrain4;
        terrain4 = terrain5;
        terrain5 = temp;
    }
    public ArrayList<HabitatTile> getNeighbours() {
        return neighbours;
    }
    public void setToken(AnimalToken t) {
        token = t;
    }
    public AnimalToken getToken() {
        return token;
    }
    public boolean containsHawk() {
        if (token!=null) {
            if (token.getAnimalType() == 4)
                return true;
        }
        return false;
    }
}



