import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ScoreRules {

    private BufferedImage bearRuleImg;
    private BufferedImage salmonRuleImg;
    private BufferedImage hawkRuleImg;
    private BufferedImage foxRuleImg;
    private BufferedImage elkRuleImg;

    private BufferedImage bearRuleImgHalf;
    private BufferedImage salmonRuleImgHalf;
    private BufferedImage hawkRuleImgHalf;
    private BufferedImage foxRuleImgHalf;
    private BufferedImage elkRuleImgHalf;

    private int bearRule;
    private int salmonRule;
    private int hawkRule;
    private int foxRule;
    private int elkRule;




    public ScoreRules(int bear, int salmon, int hawk, int fox, int elk)
    {
        try
        {
            bearRuleImg = ImageIO.read(ScoreRules.class.getResource("/images/bearA.png"));
            bearRuleImgHalf = ImageIO.read(ScoreRules.class.getResource("/images/bearAHalf.png"));
            foxRuleImg = ImageIO.read(ScoreRules.class.getResource("/images/foxA.png"));
            foxRuleImgHalf = ImageIO.read(ScoreRules.class.getResource("/images/foxAHalf.png"));
            hawkRuleImg = ImageIO.read(ScoreRules.class.getResource("/images/hawkA.png"));
            hawkRuleImgHalf = ImageIO.read(ScoreRules.class.getResource("/images/hawkAHalf.png"));
            elkRuleImg = ImageIO.read(ScoreRules.class.getResource("/images/elkC.png"));
            elkRuleImgHalf = ImageIO.read(ScoreRules.class.getResource("/images/elkCHalf.png"));
            salmonRuleImg = ImageIO.read(ScoreRules.class.getResource("/images/salmonA.png"));
            salmonRuleImgHalf = ImageIO.read(ScoreRules.class.getResource("/images/salmonAHalf.png"));


        }
        catch( Exception E)
        {
            System.out.println("Exception Error");
            return;
        }
        bearRule = bear; //1 for default
        salmonRule = salmon; //1 for default
        hawkRule = hawk; //1 for default
        foxRule = fox; //1 for default
        elkRule = elk; //3 for default


    }

    public getBearRule()
    {

    }

    public void paint(Graphics g)
    {
        g.drawImage(bearRuleImg, 0, 0, bearRule, bearRule, null);
    }






}
