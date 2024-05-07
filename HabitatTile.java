import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.*;


public class HabitatTile {


    private int terrain0;
    private int terrain1;
    private int terrain2;
    private int terrain3;
    private int terrain4;
    private int terrain5;
    private double rotation = 0;
















    private int totalTerrain1;
    private int totalTerrain2;
    private boolean canHoldHawk;
    private boolean canHoldFox;
    private boolean canHoldBear;
    private boolean canHoldSalmon;
    private boolean canHoldElk;
    private boolean isKeystone;
    private boolean containsAnimal;
    private BufferedImage image;
    private AnimalToken token;
    private ArrayList<HabitatTile> neighbours;
    private boolean mountainChecked;
    private boolean forestChecked;
    private boolean prairieChecked;
    private boolean wetlandChecked;
    private boolean riverChecked;


    public HabitatTile(boolean isKeystone, int terrain1, int terrain2, boolean canHoldBear, boolean canHoldElk, boolean canHoldSalmon, boolean canHoldHawk, boolean canHoldFox, BufferedImage image) throws FileNotFoundException {
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
        this.image = image;
        this.token = null;
        mountainChecked = false;
        forestChecked = false;
        prairieChecked = false;
        wetlandChecked = false;
        riverChecked = false;
    }


    public HabitatTile(int terrain1, int terrain2, boolean canHoldBear, boolean canHoldElk, boolean canHoldSalmon, boolean canHoldHawk, boolean canHoldFox, boolean isKeystone) throws FileNotFoundException {
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
        this.image = image;
        this.token = null;
        mountainChecked = false;
        forestChecked = false;
        prairieChecked = false;
        wetlandChecked = false;
        riverChecked = false;
    }


    public int getTotalTerrain1() {
        return totalTerrain1;
    }


    public int getTotalTerrain2() {
        return totalTerrain2;
    }


    public int getTerrain0() {
        return terrain0;
    }


    public int getTerrain1() {
        return terrain1;
    }


    public int getTerrain2() {
        return terrain2;
    }


    public int getTerrain3() {
        return terrain3;
    }


    public int getTerrain4() {
        return terrain4;
    }


    public int getTerrain5() {
        return terrain5;
    }
    public int getTerrain(int type) {
        if (type==0) {
            return terrain0;
        } else if (type==1) {
            return terrain1;
        } else if (type==2) {
            return terrain2;
        } else if (type==3) {
            return terrain3;
        } else if (type==4) {
            return terrain4;
        } else if (type==5) {
            return terrain5;
        } else {
            return -1;
        }
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
    public void setMountainChecked(boolean b) {
        mountainChecked = b;
    }
    public void setForestChecked(boolean b) {
        forestChecked = b;
    }
    public void setPrairieChecked(boolean b) {
        prairieChecked = b;
    }
    public void setWetlandChecked(boolean b) {
        wetlandChecked = b;
    }
    public void setRiverChecked(boolean b) {
        riverChecked = b;
    }
    public boolean getMountainChecked() {
        return mountainChecked;
    }
    public boolean getForestChecked() {
        return forestChecked;
    }
    public boolean getPrairieChecked() {
        return prairieChecked;
    }
    public boolean getWetlandChecked() {
        return wetlandChecked;
    }
    public boolean getRiverChecked() {
        return riverChecked;
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
        rotation+=60;
        if(rotation>=360) {
            rotation = 0;
        }
    }


    public void rotateCCW() {
        int temp = terrain0;
        terrain0 = terrain1;
        terrain1 = terrain2;
        terrain2 = terrain3;
        terrain3 = terrain4;
        terrain4 = terrain5;
        terrain5 = temp;
        rotation-=60;
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
    public boolean containsBear() {
        if (token!=null) {
            if (token.getAnimalType() == 1)
                return true;
        }
        return false;
    }
    public boolean containsElk() {
        if (token!=null) {
            if (token.getAnimalType() == 2)
                return true;
        }
        return false;
    }
    public boolean containsSalmon() {
        if (token!=null) {
            if (token.getAnimalType() == 3){
                return true;
            }


        }
        return false;
    }
    public boolean containsHawk() {
        if (token!=null) {
            if (token.getAnimalType() == 4)
                return true;
        }
        return false;
    }
    public boolean containsFox(){
        if (token!=null) {
            if (token.getAnimalType() == 5)
                return true;
        }
        return false;
    }




    public BufferedImage resize(BufferedImage src, int targetSize) {
        if (targetSize <= 0) {
            return src; //this can't be resized
        }
        int targetWidth = targetSize;
        int targetHeight = targetSize;
        float ratio = ((float) src.getHeight() / (float) src.getWidth());
        if (ratio <= 1) { //square or landscape-oriented image
            targetHeight = (int) Math.ceil((float) targetWidth * ratio);
        } else { //portrait image
            targetWidth = Math.round((float) targetHeight / ratio);
        }
        BufferedImage bi = new BufferedImage(targetWidth, targetHeight, src.getTransparency() == Transparency.OPAQUE ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB);

        //produces a balanced resizing (fast and decent quality)

        return bi;
    }


    public BufferedImage rotate(BufferedImage bimg, Double angle) {
        double sin = Math.abs(Math.sin(Math.toRadians(angle))),
                cos = Math.abs(Math.cos(Math.toRadians(angle)));
        int w = bimg.getWidth();
        int h = bimg.getHeight();
        int neww = (int) Math.floor(w*cos + h*sin),
                newh = (int) Math.floor(h*cos + w*sin);
        BufferedImage rotated = new BufferedImage(neww, newh, bimg.getType());

        return rotated;
    }




    public void paint(Graphics g, Button b){
        if(image!=null) {
            BufferedImage template = null;


            Graphics2D g2d = (Graphics2D)g;


            AffineTransform oldXForm = g2d.getTransform();
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

            g2d.translate(b.getXPos(), b.getYPos());
            g2d.rotate(Math.toRadians(rotation), image.getHeight()/2, image.getWidth()/2);


            double scaleFactor = Double.valueOf(b.getHeight())/Double.valueOf(image.getHeight());


            g2d.scale(scaleFactor,scaleFactor);



            g2d.drawRenderedImage(image, null);
            g2d.setTransform(oldXForm);
        }


        if(getToken()!=null) {
            getToken().paint(g,b.getXPos()+b.getWidth()/4,b.getYPos()+b.getHeight()/4,b.getWidth()/2,b.getHeight()/2);
        }




    }


}