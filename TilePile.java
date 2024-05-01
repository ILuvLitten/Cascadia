import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class TilePile {
    private ArrayList<HabitatTile> pile;
    private ArrayList<StarterTile> stPile;
    Scanner kb = new Scanner(new File("Text File for Images Cascadia.txt"));
    BufferedImage topImg1 = ImageIO.read(TilePile.class.getResource("/images/1-01000-01000-01000.png"));
    BufferedImage leftImg1 = ImageIO.read(TilePile.class.getResource("/images/0-10000-00001-11010.png"));
    BufferedImage rightImg1 = ImageIO.read(TilePile.class.getResource("/images/0-00100-00010-00101.png"));

    BufferedImage topImg2 = ImageIO.read(TilePile.class.getResource("/images/1-00100-00100-00001.png"));
    BufferedImage leftImg2 = ImageIO.read(TilePile.class.getResource("/images/0-00010-10000-00111.png"));
    BufferedImage rightImg2 = ImageIO.read(TilePile.class.getResource("/images/0-10000-01000-11000.png"));

    BufferedImage topImg3 = ImageIO.read(TilePile.class.getResource("/images/1-00010-00010-00010.png"));
    BufferedImage leftImg3 = ImageIO.read(TilePile.class.getResource("/images/0-00001-01000-01110.png"));
    BufferedImage rightImg3 = ImageIO.read(TilePile.class.getResource("/images/0-10000-00100-10001.png"));

    BufferedImage topImg4 = ImageIO.read(TilePile.class.getResource("/images/1-10000-10000-10000.png"));
    BufferedImage leftImg4 = ImageIO.read(TilePile.class.getResource("/images/0-01000-00010-01011.png"));
    BufferedImage rightImg4 = ImageIO.read(TilePile.class.getResource("/images/0-00100-00001-10100.png"));

    BufferedImage topImg5 = ImageIO.read(TilePile.class.getResource("/images/1-00001-00001-00100.png"));
    BufferedImage leftImg5 = ImageIO.read(TilePile.class.getResource("/images/0-00100-01000-11100.png"));
    BufferedImage rightImg5 = ImageIO.read(TilePile.class.getResource("/images/0-00010-10000-00011.png"));

    public TilePile() throws IOException {
        pile = new ArrayList<HabitatTile>();
        stPile = new ArrayList<StarterTile>();
        // add image in last parameter
        HabitatTile top1 = new HabitatTile(true, 2, 2, false, true, false, false, false, topImg1);
        HabitatTile left1 = new HabitatTile(false, 1, 5, true, true, false, true, false, leftImg1);
        HabitatTile right1 = new HabitatTile(false, 3, 4, false, false, true, false, true, rightImg1);
        StarterTile starter1 = new StarterTile(top1, left1, right1);
        stPile.add(starter1);

        HabitatTile top2 = new HabitatTile(true, 3, 3, false, false, false, false, true, topImg2);
        HabitatTile left2 = new HabitatTile(false, 4, 5, false, false, true, true, true, leftImg2);
        HabitatTile right2 = new HabitatTile(false, 1, 2, true, true, false, false, false, rightImg2);
        StarterTile starter2 = new StarterTile(top2, left2, right2);
        stPile.add(starter2);

        HabitatTile top3 = new HabitatTile(true, 4, 4, false, false, false, true, false, topImg3);
        HabitatTile left3 = new HabitatTile(false, 5, 2, false, true, true, true, false, leftImg3);
        HabitatTile right3 = new HabitatTile(false, 1, 3, true, false, false, false, true, rightImg3);
        StarterTile starter3 = new StarterTile(top3, left3, right3);
        stPile.add(starter3);

        HabitatTile top4 = new HabitatTile(true, 1, 1, true, false, false, false, false, topImg4);
        HabitatTile left4 = new HabitatTile(false, 2, 4, false, true, false, true, true, leftImg4);
        HabitatTile right4 = new HabitatTile(false, 3, 5, true, false, true, false, false, rightImg4);
        StarterTile starter4 = new StarterTile(top4, left4, right4);
        stPile.add(starter4);

        HabitatTile top5 = new HabitatTile(true, 5, 5, false, false, true, false, false, topImg5);
        HabitatTile left5 = new HabitatTile(false, 3, 2, true, true, true, false, false, leftImg5);
        HabitatTile right5 = new HabitatTile(false, 4, 1, false, false, false, true, true, rightImg5);
        StarterTile starter5 = new StarterTile(top5, left5, right5);
        stPile.add(starter5);




        HabitatTile x;
        int numSet2 =0;
        int numSet1 =0;
        int numSet3 =0;
        String numSet4;
        boolean forKey;
        boolean forBear;
        boolean forHawk;
        boolean forSalmon;
        boolean forElk;
        boolean forFox;
        int numSet4Dig1;
        int numSet4Dig2;
        int numSet4Dig3;
        int numSet4Dig4;
        int numSet4Dig5;
        String temp1;
        String temp2;
        String temp3;
        String temp4;
        String temp5;
        BufferedImage tempIMG = null;
        int terr1=0;
        int terr2 =0;

        while (kb.hasNextLine()) {
            String line = kb.nextLine();      //"0-12345-12345-12345"

            String[] arr = line.split("-");

           
            try {
                tempIMG = ImageIO.read(TilePile.class.getResource("/images/" + line + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            numSet1 = Integer.parseInt(arr[0]);
            numSet2 = Integer.parseInt(arr[1]);
            numSet3 = Integer.parseInt(arr[2]);
            numSet4 = arr[3];


            temp1 = numSet4.substring(0, 1);
            temp2 = numSet4.substring(1, 2);
            temp3 = numSet4.substring(2, 3);
            temp4 = numSet4.substring(3, 4);
            temp5 = numSet4.substring(4, 5);

            numSet4Dig1 = Integer.parseInt(temp1);
            numSet4Dig2 = Integer.parseInt(temp2);
            numSet4Dig3 = Integer.parseInt(temp3);
            numSet4Dig4 = Integer.parseInt(temp4);
            numSet4Dig5 = Integer.parseInt(temp5);


            if (numSet1 == 0) {
                forKey = false;
            } else {
                forKey = true;
            }


            if (numSet2 == 10000) {
                terr1 = 1;  //mount
            } else if (numSet2 == 01000) {
                terr1 = 2;  //forest
            } else if (numSet2 == 00100) {
                terr1 = 3;    //praire
            } else if (numSet2 == 00010) {
                terr1 = 4;     //wetland
            } else if (numSet2 == 00001) {
                terr1 = 5;      //river
            }


            if (numSet3 == 10000) {
                terr2 = 1;
            } else if (numSet3 == 01000) {
                terr2 = 2;
            } else if (numSet3 == 00100) {
                terr2 = 3;
            } else if (numSet3 == 00010) {
                terr2 = 4;
            } else if (numSet3 == 00001) {
                terr2 = 5;
            }

            if (numSet4Dig1 == 1) {
                forBear = true;
            } else {
                forBear = false;
            }

            if (numSet4Dig2 == 1) {
                forElk = true;
            } else {
                forElk = false;
            }

            if (numSet4Dig3 == 1) {
                forSalmon = true;
            } else {
                forSalmon = false;
            }

            if (numSet4Dig4 == 1) {
                forHawk = true;
            } else {
                forHawk = false;
            }

            if (numSet4Dig5 == 1) {
                forFox = true;
            } else {
                forFox = false;
            }

//line =
            x= new HabitatTile(forKey, terr1, terr2, forBear, forElk, forSalmon, forHawk, forFox, tempIMG);
            pile.add(x);
        }//end while



    } //end constructor

    public void addTile(HabitatTile tile) {
        pile.add(tile);
    }

    public HabitatTile draw() {
        return pile.remove(0);
    }

    public void shuffle() {
        Collections.shuffle(pile);
    }

    public int size() {
        return pile.size();
    }
    public BufferedImage drawImage() {
        return pile.get(0).getImage();
    }
    public ArrayList<HabitatTile> getPile() {
        return pile;
    }
    public ArrayList<StarterTile> getStarterTilePile() {
        return stPile;
    }



}
