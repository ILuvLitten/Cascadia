import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ScoreRules {

    private BufferedImage currImg;
    private BufferedImage currImgHalf;


    private final BufferedImage bearRuleImg = ImageIO.read(ScoreRules.class.getResource("/images/bearA.png"));;
    private final BufferedImage salmonRuleImg = ImageIO.read(ScoreRules.class.getResource("/images/salmonA.png"));;
    private final BufferedImage hawkRuleImg= ImageIO.read(ScoreRules.class.getResource("/images/hawkA.png"));;
    private final BufferedImage foxRuleImg = ImageIO.read(ScoreRules.class.getResource("/images/foxA.png"));;
    private final BufferedImage elkRuleImg  = ImageIO.read(ScoreRules.class.getResource("/images/elkC.png"));;

    private final BufferedImage bearRuleImgHalf = ImageIO.read(ScoreRules.class.getResource("/images/bearAHalf.png"));;
    private final BufferedImage salmonRuleImgHalf = ImageIO.read(ScoreRules.class.getResource("/images/salmonAHalf.png"));;
    private final BufferedImage hawkRuleImgHalf = ImageIO.read(ScoreRules.class.getResource("/images/hawkAHalf.png"));;
    private final BufferedImage foxRuleImgHalf = ImageIO.read(ScoreRules.class.getResource("/images/foxAHalf.png"));;
    private final BufferedImage elkRuleImgHalf = ImageIO.read(ScoreRules.class.getResource("/images/elkCHalf.png"));;

    private int bearRule;
    private int salmonRule;
    private int hawkRule;
    private int foxRule;
    private int elkRule;




    public ScoreRules(int animalType) throws IOException //1=bear, 2=salmon, 3= hawk, 4=fox, 5=elk
    {
        if (animalType == 1){
            currImg = bearRuleImg;
            currImgHalf = bearRuleImgHalf;
        }
        else if (animalType == 2){
            currImg = salmonRuleImg;
            currImgHalf = salmonRuleImgHalf;
        }
        else if (animalType == 3){
            currImg = hawkRuleImg;
            currImgHalf = hawkRuleImgHalf;
        }
        else if (animalType == 4){
            currImg = foxRuleImg;
            currImgHalf = foxRuleImgHalf;
        }
        else if (animalType == 5){
            currImg = elkRuleImg;
            currImgHalf = elkRuleImgHalf;
        }


    }

    public BufferedImage getCurrImg()
    {
        return currImg;
    }

    public BufferedImage getCurrImgHalf
    {
        return currImgHalf
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
