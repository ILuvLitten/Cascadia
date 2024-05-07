import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


public class ImageButton extends Button{

    private BufferedImage img;
    private BufferedImage hoverImg;
    private BufferedImage disabledImg;
    private BufferedImage selectedImg;

    private BufferedImage currentImg;

    //rectangle
    public ImageButton(String imgHeader,int x, int y, int w, int h) {
        super(x,y,w,h);

        try {
            img = ImageIO.read(ImageButton.class.getResource("/FinalFiles/guiImages/"+imgHeader+"IMG.png"));

        }
        catch(Exception E) {
            img = null;
        }

        try {
            hoverImg = ImageIO.read(ImageButton.class.getResource("/FinalFiles/guiImages/"+imgHeader+"HoverIMG.png"));
        }
        catch(Exception E) {
            hoverImg = img;
        }

        try {
            disabledImg = ImageIO.read(ImageButton.class.getResource("/FinalFiles/guiImages/"+imgHeader+"DisabledIMG.png"));
        }
        catch(Exception E) {
            disabledImg = img;
        }

        try {
            selectedImg = ImageIO.read(ImageButton.class.getResource("/FinalFiles/guiImages/"+imgHeader+"DisabledIMG.png"));
        }
        catch(Exception E) {
            selectedImg = hoverImg;
        }

        currentImg = img;
    }

    //hex
    public ImageButton(String imgHeader,int x, int y, int d) {
        super(x,y,d);

        try {
            img = ImageIO.read(ImageButton.class.getResource("/FinalFiles/guiImages/"+imgHeader+"IMG.png"));
        }
        catch(Exception E) {
            img = null;
            System.out.println(imgHeader+" img not found");
        }

        try {
            hoverImg = ImageIO.read(ImageButton.class.getResource("/FinalFiles/guiImages/"+imgHeader+"HoverIMG.png"));
        }
        catch(Exception E) {
            hoverImg = img;
            System.out.println(imgHeader+" img not found (hover)");
        }

        try {
            disabledImg = ImageIO.read(ImageButton.class.getResource("/FinalFiles/guiImages/"+imgHeader+"DisabledIMG.png"));
        }
        catch(Exception E) {
            disabledImg = img;
            System.out.println(imgHeader+" img not found (disabled)");
        }
        try {
            selectedImg = ImageIO.read(ImageButton.class.getResource("/FinalFiles/guiImages/"+imgHeader+"SelectedIMG.png"));
        }
        catch(Exception E) {
            selectedImg = hoverImg;
        }

        currentImg = img;
    }


    public void paint(Graphics g) {

        //super.paint(g);

        if(!super.getHidden()){
            currentImg = img;
            if(super.getHover()){
                currentImg = hoverImg;
            }
            if(super.getDisabled()){
                currentImg = disabledImg;;
            }
            if(super.getSelected()){
                currentImg = selectedImg;;
            }

            if(currentImg!=null) {
                g.drawImage(currentImg, getXPos(), getYPos(), getWidth(), getHeight(), null);
            }








            //g.setColor(Color.BLACK);
            //g.drawString("0,0", xPos,yPos);
        }

    }






}