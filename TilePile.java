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
    Scanner kb = new Scanner(new File("Text File for Images Cascadia.txt"));


    public TilePile() throws IOException {
        pile = new ArrayList<HabitatTile>();
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
                terr1 = 1;
            } else if (numSet2 == 01000) {
                terr1 = 2;
            } else if (numSet2 == 00100) {
                terr1 = 3;
            } else if (numSet2 == 00010) {
                terr1 = 4;
            } else if (numSet2 == 00001) {
                terr1 = 5;
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



}
