import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;


public class EndScreen{

    private BufferedImage bg;
    private Button newGameButton;
    private Button mainMenuButton;

    private int width = 0;
    private int height = 0;

    private int[] playerScores;

    private BufferedImage[] placeImgs;
    private Player[] players;
    private Scoring scoreHandler;



    private BufferedImage scoreCardImage;




    public EndScreen(Player[] p, int w, int h) {

        width = w;
        height = h;
        players = p;

        newGameButton = new ImageButton("NewGameButton",83,433,255);



        mainMenuButton = new ImageButton("MainMenuButton",905,433,255);


        scoreHandler = new Scoring(players[0],players[1],players[2]);
        players[0].setScore(scoreHandler.getTotal1());
        players[1].setScore(scoreHandler.getTotal2());
        players[2].setScore(scoreHandler.getTotal3());





        try {
            bg = ImageIO.read(EndScreen.class.getResource("/guiImages/EndScreenBG.png"));
        }
        catch(Exception E) {
            bg = null;
            System.out.println("TITLESCREEN: BG IMAGE NOT FOUND");
        }

        try {
            scoreCardImage = ImageIO.read(EndScreen.class.getResource("/guiImages/PlayerScoreCardFinalIMG.png"));
        }
        catch(Exception E) {
            scoreCardImage = null;
            System.out.println("SCORECARD: BG IMAGE NOT FOUND");
        }

        placeImgs = new BufferedImage[3];
        try {
            placeImgs[0] = ImageIO.read(EndScreen.class.getResource("/guiImages/FirstIMG.png"));
        }
        catch(Exception E) {
            System.out.println("TITLESCREEN: IMAGE NOT FOUND");
        }
        try {
            placeImgs[1] = ImageIO.read(EndScreen.class.getResource("/guiImages/SecondIMG.png"));
        }
        catch(Exception E) {
            System.out.println("TITLESCREEN: IMAGE NOT FOUND");
        }
        try {
            placeImgs[2] = ImageIO.read(EndScreen.class.getResource("/guiImages/ThirdIMG.png"));
        }
        catch(Exception E) {
            System.out.println("TITLESCREEN: IMAGE NOT FOUND");
        }




    }

    public void paint(Graphics g, Graphics2D g2d) {

        g.drawImage(bg, 0, 0, width, height, null);

        newGameButton.paint(g);
        mainMenuButton.paint(g);

        g.drawImage(scoreCardImage, 200,300,100,400,null);
        g.drawImage(placeImgs[players[0].getPlace(players)],200,100,100,200,null);

        players[0].getBoard().setDisplay(200,800,100);
        players[0].getBoard().paint(g);


        g.drawImage(scoreCardImage, 400,300,100,400,null);
        g.drawImage(placeImgs[players[1].getPlace(players)],400,100,100,200,null);

        players[1].getBoard().setDisplay(400,800,100);
        players[1].getBoard().paint(g);




        g.drawImage(scoreCardImage, 600,300,100,400,null);
        g.drawImage(placeImgs[players[2].getPlace(players)],600,100,100,200,null);

        players[2].getBoard().setDisplay(600,800,100);
        players[2].getBoard().paint(g);




        scoreHandler.paint(g,200,300,400,300,600,300,10,10,10);




    }

    public void mouseMoved(int clickX, int clickY) {
        newGameButton.mouseMoved(clickX, clickY);
        mainMenuButton.mouseMoved(clickX, clickY);


    }

    public int mouseClicked(int clickX, int clickY) {

        switch(newGameButton.mouseClicked(clickX,clickY)) {
            case 0:
                return 0;
            case 1:
                return 2;
        }
        switch(mainMenuButton.mouseClicked(clickX,clickY)) {
            case 0:
                return 0;
            case 1:
                return 3;
        }



        return -1;

    }






}