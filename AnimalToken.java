import java.awt.image.BufferedImage;
public class AnimalToken {
    private int animalType;
    private BufferedImage image;
    private boolean scored;

    public AnimalToken(int type, BufferedImage img) {
        animalType = type;
        image = img;
        scored = false;
    }

    public AnimalToken(int type) {
        animalType = type;
        image = null;
        scored = false;
    }

    public int getAnimalType() {
        return animalType;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage x) {
        image = x;
    }

    public void setScored(Boolean c) {
        scored = c;
    }

    public boolean getScored() {
        return scored;
    }
}
