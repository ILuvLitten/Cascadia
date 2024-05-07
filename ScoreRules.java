import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class ScoreRules {


    private BufferedImage currImg;
    private BufferedImage currImgHalf;


    private int bearRule;
    private int salmonRule;
    private int hawkRule;
    private int foxRule;
    private int elkRule;





    /*
     * Bear A
     * Salmon A
     * Hawk A
     * Fox A
     * Elk C
     */




    public ScoreRules(String imgHeader) //1=bear, 2=salmon, 3= hawk, 4=fox, 5=elk
    {
        try {
            currImg = ImageIO.read(ScoreRules.class.getResource("/FinalFiles/guiImages/"+imgHeader+".png"));

        }catch(Exception E) {

            currImg = null;
        }

        try {
            currImgHalf = ImageIO.read(ScoreRules.class.getResource("/FinalFiles/guiImages/"+imgHeader+"Half.png"));

        }catch(Exception E) {

            currImgHalf = null;
        }




    }


    public BufferedImage getCurrImg()
    {
        return currImg;
    }


    public BufferedImage getCurrImgHalf()
    {
        return currImgHalf;
    }




    public void paint(Graphics g, int x, int y, int width, int height, boolean half)
    {
        if (half)
        {
            g.drawImage(this.currImgHalf, x, y, width, height, null);
        }
        else {
            g.drawImage(this.currImg, x, y, width, height, null);
        }


    }












}