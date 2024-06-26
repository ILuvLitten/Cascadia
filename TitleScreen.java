import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;


public class TitleScreen{

    private BufferedImage bg;
    private Button newGameButton;
    private Button manualButton;

    private int width = 0;
    private int height = 0;

    public TitleScreen(int w, int h) {

        width = w;
        height = h;

        newGameButton = new ImageButton("NewGameButton",295,403,355);
        newGameButton.setText("New Game");

        manualButton = new ImageButton("ManualButton",625,403,355);
        manualButton.setText("Manual");

        try {
            bg = ImageIO.read(TitleScreen.class.getResource("/FinalFiles/guiImages/TitleScreenBG.png"));
        }
        catch(Exception E) {
            bg = null;
            System.out.println("TITLESCREEN: BG IMAGE NOT FOUND");
        }

    }

    public void paint(Graphics g) {

        g.drawImage(bg, 0, 0, width, height, null);

        newGameButton.paint(g);
        manualButton.paint(g);
    }

    public void mouseMoved(int clickX, int clickY) {
        newGameButton.mouseMoved(clickX, clickY);
        manualButton.mouseMoved(clickX, clickY);
    }

    public int mouseClicked(int clickX, int clickY) {

        switch(newGameButton.mouseClicked(clickX,clickY)) {
            case 0:
                return 0;
            case 1:
                return 1;
        }
        switch(manualButton.mouseClicked(clickX,clickY)) {

            case 0:
                return 0;

            case 1:
                return 2;
        }

        return -1;

    }






}