import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
public class ManualScreen {

    private BufferedImage bg;
    private ImageButton prevButton;
    private Button nextButton;
    private Button backButton;

    private int width = 0;
    private int height = 0;

    private int currentPage = 1;
    private int totalPages = 16;

    public ManualScreen(int w, int h) {
        width = w;
        height = h;
        prevButton = new ImageButton("PrevButton",840,104,199);
        nextButton = new ImageButton("NextButton",936,257,199);

        backButton = new ImageButton("BackButton",828,488,308);

        try {
            bg = ImageIO.read(ManualScreen.class.getResource("/FinalFiles/guiImages/ManualScreenBG.png"));
        }
        catch(Exception E) {
            bg = null;
            System.out.println("MANUALSCREEN: BG IMAGE NOT FOUND");
        }

    }

    public int getCurrentPage() {return currentPage;}
    public void setCurrentPage(int p) {currentPage = p;}

    public void nextPage() {
        currentPage++;
        if(currentPage>totalPages) {
            currentPage = totalPages;
        }
    }

    public void prevPage() {
        currentPage--;
        if(currentPage<1) {
            currentPage = 1;
        }
    }


    public void paint(Graphics g) {

        g.drawImage(bg, 0, 0, width, height, null);
        if(currentPage <= 1) {
            prevButton.setDisabled(true);
        }else {
            prevButton.setDisabled(false);
        }

        if(currentPage >= totalPages) {
            nextButton.setDisabled(true);
        }else {
            nextButton.setDisabled(false);
        }
        prevButton.paint(g);
        nextButton.paint(g);

        backButton.paint(g);

        String pageImgName = "Cascadia-Rules-" + currentPage + ".png";
        BufferedImage pageImg;
        try {
            pageImg = ImageIO.read(ManualScreen.class.getResource("/FinalFiles/guiImages/"+pageImgName));
        }
        catch(Exception E) {
            pageImg = null;
        }

        if(pageImg!=null) {
            g.drawImage(pageImg, 62, 70, 750, 750, null);
        }else {
            g.setColor(Color.WHITE);
            g.fillRect(150, 150, 600, 600);
        }


    }

    public void mouseMoved(int clickX, int clickY) {

        prevButton.mouseMoved(clickX, clickY);
        nextButton.mouseMoved(clickX, clickY);

        backButton.mouseMoved(clickX, clickY);
    }

    public int mouseClicked(int clickX, int clickY) {

        switch(nextButton.mouseClicked(clickX,clickY)) {
            case 0:
                return 0;
            case 1:
                nextPage();
                return 1;
        }
        switch(prevButton.mouseClicked(clickX,clickY)) {

            case 0:
                return 0;

            case 1:
                prevPage();
                return 1;
        }
        switch(backButton.mouseClicked(clickX,clickY)) {

            case 0:
                return 0;

            case 1:
                return 2;
        }

        return -1;


    }
}