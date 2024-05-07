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
    private BufferedImage topImg1;
    private BufferedImage leftImg1;
    private BufferedImage rightImg1;




    private BufferedImage topImg2;
    private BufferedImage leftImg2;
    private BufferedImage rightImg2;




    private BufferedImage topImg3;
    private BufferedImage leftImg3;
    private BufferedImage rightImg3;




    private BufferedImage topImg4;
    private BufferedImage leftImg4;
    private BufferedImage rightImg4;




    private BufferedImage topImg5;
    private BufferedImage leftImg5;
    private BufferedImage rightImg5;
    private Scanner kb;




    public TilePile() {
        try {
            File f = new File(TilePile.class.getResource("/FinalFiles/finalTextBruh.txt").getFile());
            kb  = new Scanner(f);
        }catch(Exception E) {
            System.out.println("File Not Found");
        }
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
        BufferedImage tempIMG;
        int terr1=0;
        int terr2 =0;


        while (kb.hasNextLine()) {
            String line = kb.nextLine();      //"0-12345-12345-12345"


            String[] arr = line.split("-");



            try {
                tempIMG = ImageIO.read(TilePile.class.getResource("/FinalFiles/guiImages/" + line + ".png"));
            }catch(Exception E) {
                System.out.println("Tile Image Not Found: "+line);
                tempIMG = null;

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
            try {
                x= new HabitatTile(forKey, terr1, terr2, forBear, forElk, forSalmon, forHawk, forFox, tempIMG);
                pile.add(x);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }//end while



        try{
            topImg1 = ImageIO.read(TilePile.class.getResource("/FinalFiles/guiImages/1-01000-01000-01000.png"));
        }catch(Exception E){
            topImg1 = null;
        }
        try{
            leftImg1 = ImageIO.read(TilePile.class.getResource("/FinalFiles/guiImages/0-10000-00001-11010.png"));
        }catch(Exception E){
            leftImg1 = null;
        }
        try{
            rightImg1 = ImageIO.read(TilePile.class.getResource("/FinalFiles/guiImages/0-00100-00010-00101.png"));
        }catch(Exception E){
            rightImg1 = null;
        }




        try{
            topImg2 = ImageIO.read(TilePile.class.getResource("/FinalFiles/guiImages/1-00100-00100-00001.png"));
        }catch(Exception E){
            topImg2 = null;
        }
        try{
            leftImg2 = ImageIO.read(TilePile.class.getResource("/FinalFiles/guiImages/0-00010-10000-00111.png"));
        }catch(Exception E){
            leftImg2 = null;
        }
        try{
            rightImg2 = ImageIO.read(TilePile.class.getResource("/FinalFiles/guiImages/0-10000-01000-11000.png"));
        }catch(Exception E){
            rightImg2 = null;
        }




        try{
            topImg3 = ImageIO.read(TilePile.class.getResource("/FinalFiles/guiImages/1-00010-00010-00010.png"));
        }catch(Exception E){
            topImg3 = null;
        }
        try{
            leftImg3 = ImageIO.read(TilePile.class.getResource("/FinalFiles/guiImages/0-00001-01000-01110.png"));
        }catch(Exception E){
            leftImg3 = null;
        }
        try{
            rightImg3 = ImageIO.read(TilePile.class.getResource("/FinalFiles/guiImages/0-10000-00100-10001.png"));
        }catch(Exception E){
            rightImg3 = null;
        }




        try{
            topImg4 = ImageIO.read(TilePile.class.getResource("/FinalFiles/guiImages/1-10000-10000-10000.png"));
        }catch(Exception E){
            topImg4 = null;
        }
        try{
            leftImg4 = ImageIO.read(TilePile.class.getResource("/FinalFiles/guiImages/0-01000-00010-01011.png"));
        }catch(Exception E){
            leftImg4 = null;
        }
        try{
            rightImg4 = ImageIO.read(TilePile.class.getResource("/FinalFiles/guiImages/0-00100-00001-10100.png"));
        }catch(Exception E){
            rightImg4 = null;
        }




        try{
            topImg5 = ImageIO.read(TilePile.class.getResource("/FinalFiles/guiImages/1-00001-00001-00100.png"));
        }catch(Exception E){
            topImg5 = null;
        }
        try{
            leftImg5 = ImageIO.read(TilePile.class.getResource("/FinalFiles/guiImages/0-00100-01000-11100.png"));
        }catch(Exception E){
            leftImg5 = null;
        }
        try{
            rightImg5 = ImageIO.read(TilePile.class.getResource("/FinalFiles/guiImages/0-00010-10000-00011.png"));
        }catch(Exception E){
            rightImg5 = null;
        }




        stPile = new ArrayList<StarterTile>();
        // add image in last parameter


        try {
        HabitatTile top1 = new HabitatTile(true, 2, 2, false, true, false, false, false, topImg1);
    HabitatTile left1 = new HabitatTile(false, 1, 5, true, true, false, true, false, leftImg1);
    left1.setTerrain0(1);
    left1.setTerrain1(1);
    left1.setTerrain2(5);
    left1.setTerrain3(5);
    left1.setTerrain4(5);
    left1.setTerrain5(1);
    HabitatTile right1 = new HabitatTile(false, 3, 4, false, false, true, false, true, rightImg1);
    right1.setTerrain0(4);
    right1.setTerrain1(4);
    right1.setTerrain2(4);
    right1.setTerrain3(3);
    right1.setTerrain4(3);
    right1.setTerrain5(3);
    StarterTile starter1 = new StarterTile(top1, left1, right1);
    if(topImg1 != null && leftImg1 != null && rightImg1 != null) {
    stPile.add(starter1);
    }
}catch(Exception E) {
        System.out.println("Starter 1 not loaded");
}


try {
        HabitatTile top2 = new HabitatTile(true, 3, 3, false, false, false, false, true, topImg2);
    HabitatTile left2 = new HabitatTile(false, 4, 5, false, false, true, true, true, leftImg2);
    left2.setTerrain0(4);
    left2.setTerrain1(4);
    left2.setTerrain2(5);
    left2.setTerrain3(5);
    left2.setTerrain4(5);
    left2.setTerrain5(4);
    HabitatTile right2 = new HabitatTile(false, 1, 2, true, true, false, false, false, rightImg2);
    right2.setTerrain0(2);
    right2.setTerrain1(2);
    right2.setTerrain2(2);
    right2.setTerrain3(1);
    right2.setTerrain4(1);
    right2.setTerrain5(1);
    StarterTile starter2 = new StarterTile(top2, left2, right2);
    if(topImg2 != null && leftImg2 != null && rightImg2 != null) {
    stPile.add(starter2);
    }
}catch(Exception E) {
        System.out.println("Starter 2 not loaded");
}


try {
        HabitatTile top3 = new HabitatTile(true, 4, 4, false, false, false, true, false, topImg3);
    HabitatTile left3 = new HabitatTile(false, 5, 2, false, true, true, true, false, leftImg3);
    left3.setTerrain0(5);
    left3.setTerrain1(5);
    left3.setTerrain2(2);
    left3.setTerrain3(2);
    left3.setTerrain4(2);
    left3.setTerrain5(5);
    HabitatTile right3 = new HabitatTile(false, 1, 3, true, false, false, false, true, rightImg3);
    right3.setTerrain0(1);
    right3.setTerrain1(1);
    right3.setTerrain2(1);
    right3.setTerrain3(3);
    right3.setTerrain4(3);
    right3.setTerrain5(3);
    StarterTile starter3 = new StarterTile(top3, left3, right3);
    if(topImg3 != null && leftImg3 != null && rightImg3 != null) {
    stPile.add(starter3);
    }
}catch(Exception E) {
        System.out.println("Starter 3 not loaded");
}


try {
        HabitatTile top4 = new HabitatTile(true, 1, 1, true, false, false, false, false, topImg4);
    HabitatTile left4 = new HabitatTile(false, 2, 4, false, true, false, true, true, leftImg4);
    left4.setTerrain0(2);
    left4.setTerrain1(2);
    left4.setTerrain2(4);
    left4.setTerrain3(4);
    left4.setTerrain4(4);
    left4.setTerrain5(2);
    HabitatTile right4 = new HabitatTile(false, 3, 5, true, false, true, false, false, rightImg4);
    right4.setTerrain0(5);
    right4.setTerrain1(5);
    right4.setTerrain2(5);
    right4.setTerrain3(3);
    right4.setTerrain4(3);
    right4.setTerrain5(3);
    StarterTile starter4 = new StarterTile(top4, left4, right4);
    if(topImg4 != null && leftImg4 != null && rightImg4 != null) {
    stPile.add(starter4);
    }
}catch(Exception E) {
        System.out.println("Starter 4 not loaded");
}


try {
        HabitatTile top5 = new HabitatTile(true, 5, 5, false, false, true, false, false, topImg5);
    HabitatTile left5 = new HabitatTile(false, 3, 2, true, true, true, false, false, leftImg5);
    left5.setTerrain0(3);
    left5.setTerrain1(3);
    left5.setTerrain2(2);
    left5.setTerrain3(2);
    left5.setTerrain4(2);
    left5.setTerrain5(3);
    HabitatTile right5 = new HabitatTile(false, 4, 1, false, false, false, true, true, rightImg5);
    StarterTile starter5 = new StarterTile(top5, left5, right5);
    if(topImg5 != null && leftImg5 != null && rightImg5 != null) {
    stPile.add(starter5);
    }
}catch(Exception E) {
        System.out.println("Starter 5 not loaded");
}

































    } //end constructor


    public void addTile(HabitatTile tile) {
        pile.add(tile);
    }


    public HabitatTile draw() {
        return pile.remove(0);
    }
    public StarterTile createStarterTile(){




        return new StarterTile(draw(), draw(), draw());
    }


    public void shuffle() {
        Collections.shuffle(pile);
        Collections.shuffle(stPile);
    }

    public StarterTile drawStarter(){
        return stPile.remove(0);
    }




    public ArrayList<StarterTile> getStarterTilePile() {
        return stPile;
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
