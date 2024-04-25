import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.util.Collections;


public class BagOfAnimalTokens {
    private ArrayList<AnimalToken> tokenList;

    
    public BagOfAnimalTokens()
    {
        tokenList = new ArrayList<AnimalToken>();
        // add 20 bears
        for (int i=0; i<20; i++) {
            tokenList.add(new AnimalToken(1));
        }
        // add 20 elk
        for (int i=0; i<20; i++) {
            tokenList.add(new AnimalToken(2));
        }
        // add 20 salmon
        for (int i=0; i<20; i++) {
            tokenList.add(new AnimalToken(3));
        }
        // add 20 hawks
        for (int i=0; i<20; i++) {
            tokenList.add(new AnimalToken(4));
        }
        // add 20 foxes
        for (int i=0; i<20; i++) {
            tokenList.add(new AnimalToken(5));
        }
        Collections.shuffle(tokenList);

    }

    public void addTokens(AnimalToken one, AnimalToken two, AnimalToken three) {
        tokenList.add(one);
        tokenList.add(two);
        tokenList.add(three);
        Collections.shuffle(tokenList);
    }

    public ArrayList<AnimalToken> getTokenList() {
        return tokenList;
    }

    public void addTokens(AnimalToken one, AnimalToken two, AnimalToken three, AnimalToken four) {
        tokenList.add(one);
        tokenList.add(two);
        tokenList.add(three);
        tokenList.add(four);
        Collections.shuffle(tokenList);
    }

    // returns x amount of Animal tokens if list is not empty
    public ArrayList<AnimalToken> draw(int x) {
        if (!tokenList.isEmpty()) {
            ArrayList<AnimalToken> list = new ArrayList<AnimalToken>();
            for (int i=0; i<x; i++) {
                list.add(draw());
            }
            Collections.shuffle(tokenList);
            return list;
        }
        return null;
    }

    public AnimalToken draw() {
        if (!tokenList.isEmpty()) {
            AnimalToken t = tokenList.remove(0);
            Collections.shuffle(tokenList);
            return t;
        }
        return null;
    }

    public int numBearLeft() {
        int cnt = 0;
        for (AnimalToken t: tokenList) {
            if (t.getAnimalType()==1) {
                cnt ++;
            }
        }
        return cnt;
    }

    public int numElkLeft() {
        int cnt = 0;
        for (AnimalToken t: tokenList) {
            if (t.getAnimalType()==2) {
                cnt ++;
            }
        }
        return cnt;
    }

    public int numSalmonLeft() {
        int cnt = 0;
        for (AnimalToken t: tokenList) {
            if (t.getAnimalType()==3) {
                cnt ++;
            }
        }
        return cnt;
    }

    public int numHawkLeft() {
        int cnt = 0;
        for (AnimalToken t: tokenList) {
            if (t.getAnimalType()==4) {
                cnt ++;
            }
        }
        return cnt;
    }

    public int numFoxLeft() {
        int cnt = 0;
        for (AnimalToken t: tokenList) {
            if (t.getAnimalType()==5) {
                cnt ++;
            }
        }
        return cnt;
    }
}




