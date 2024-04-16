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

    public ArrayList<AnimalToken> draw(int x) {
        ArrayList<AnimalToken> list = new ArrayList<AnimalToken>();
        for (int i=0; i<x; i++) {
            list.add(tokenList.remove(0));
        }
        Collections.shuffle(tokenList);
        return list;
    }

    public AnimalToken draw() {
        AnimalToken t = tokenList.remove(0);
        Collections.shuffle(tokenList);
        return t;
    }
}




