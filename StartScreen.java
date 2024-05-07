import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;


public class StartScreen {


    private BufferedImage bg;
    private Button titleScreenButton;
    private Button manualButton;
    private Button startGameButton;

    private boolean confirmQuit = false;
    private BufferedImage confirmQuitbg;
    private Button yesButton;
    private Button noButton;

    private int width = 0;
    private int height = 0;

    private ScoreRules bearRules;
    private ScoreRules salmonRules;
    private ScoreRules hawkRules;
    private ScoreRules foxRules;
    private ScoreRules elkRules;


    private TilePile tilePile;
    private Player player1;

    private HabitatTile testTile;

    private Player[] players;




    public StartScreen(int w, int h) {

        width = w;
        height = h;

        bearRules = new ScoreRules("bearA");
        salmonRules = new ScoreRules("salmonA");
        hawkRules = new ScoreRules("hawkA");
        foxRules = new ScoreRules("foxA");
        elkRules = new ScoreRules("elkC");


        tilePile = new TilePile();
        //testTile = tilePile.draw();
        //testTile.rotateCCW();

        //player1 = new Player("player one", tilePile.createStarterTile(),0,0,500);
        players = new Player[3];
        players[0] = new Player("Player One", tilePile.drawStarter(),120,100,500);
        players[1] = new Player("Player Two", tilePile.drawStarter(),470,100,500);
        players[2] = new Player("Player Three", tilePile.drawStarter(),820,100,500);


        titleScreenButton = new ImageButton("IconTitleScreenButton",1078,6,52,52);
        manualButton = new ImageButton("IconManualButton",1139,8,48,48);

        startGameButton = new ImageButton("StartGameButton",391,381,427,128);

        yesButton = new ImageButton("YesButton",417,461,363,109);
        noButton = new ImageButton("NoButton",417,576,363,109);




        try {
            bg = ImageIO.read(StartScreen.class.getResource("/FinalFiles/guiImages/StartScreenFinalBG.png"));
        }
        catch(Exception E) {
            bg = null;
            System.out.println("STARTSCREEN: BG IMAGE NOT FOUND");
        }

        try {
            confirmQuitbg = ImageIO.read(StartScreen.class.getResource("/FinalFiles/guiImages/StartScreenFinalConfirmBG.png"));
        }
        catch(Exception E) {
            confirmQuitbg = null;
            System.out.println("STARTSCREEN: BG IMAGE NOT FOUND");
        }

    }

    public GameScreen getGameScreen() {

        return new GameScreen(width,height,bearRules,salmonRules,hawkRules,foxRules,elkRules,players,tilePile);

    }

    public void paint(Graphics g) {

        if(confirmQuit) {
            g.drawImage(confirmQuitbg, 0, 0, width, height, null);
            yesButton.paint(g);
            noButton.paint(g);
        }else {
            g.drawImage(bg, 0, 0, width, height, null);

            titleScreenButton.paint(g);
            manualButton.paint(g);

            //startGameButton.paint(g);
            //testTile.paint(g,new Button(100,100,100));

            //player1.getBoard().paint(g);
            //testTile.paint(g,100,100,100);

            for(Player p:players) {
                p.getBoard().paint(g);

            }


        }


    }

    public void mouseMoved(int clickX, int clickY) {

        if(confirmQuit) {
            yesButton.mouseMoved(clickX, clickY);
            noButton.mouseMoved(clickX, clickY);
        }else {

            titleScreenButton.mouseMoved(clickX, clickY);
            manualButton.mouseMoved(clickX, clickY);

            startGameButton.mouseMoved(clickX, clickY);
        }

    }

    public int mouseClicked(int clickX, int clickY) {

        if(!confirmQuit) {

            switch(startGameButton.mouseClicked(clickX,clickY)) {
                case 0:
                    return 0;
                case 1:
                    return 4;

            }
            switch(titleScreenButton.mouseClicked(clickX,clickY)) {

                case 0:
                    return 0;

                case 1:
                    confirmQuit = true;
                    return 1;
            }
            switch(manualButton.mouseClicked(clickX,clickY)) {

                case 0:
                    return 0;

                case 1:
                    return 3;
            }
        }else {
            switch(yesButton.mouseClicked(clickX,clickY)) {
                case 0:
                    return 0;
                case 1:
                    confirmQuit = false;
                    return 2;

            }

            switch(noButton.mouseClicked(clickX,clickY)) {
                case 0:
                    return 0;
                case 1:
                    confirmQuit = false;
                    return 1;

            }
        }

        return -1;


    }


}