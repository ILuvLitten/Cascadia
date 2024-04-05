import java.io.IOException;
import java.util.ArrayList;
public class CenterBoard {
    private AnimalToken[] tokenList;
    private HabitatTile[] tileList;
    private boolean overpopulation3, overpopulation4;
    private BagOfAnimalTokens bag;
    private TilePile stack;

    public CenterBoard() throws IOException {
        tokenList = new AnimalToken[4];
        tileList = new HabitatTile[4];
        overpopulation3 = false;
        overpopulation4 = false;
        bag = new BagOfAnimalTokens();
        fillTokens();
        //tileList.add(stack.draw)
    }

    public AnimalToken[] getTokenList() {
        return tokenList;
    }

    public HabitatTile[] getTileList() {
        return tileList;
    }

    public AnimalToken drawToken1() {
        AnimalToken t1 = tokenList[0];
        tokenList[0] = null;
        return t1;
    }

    public AnimalToken drawToken2() {
        AnimalToken t2 = tokenList[1];
        tokenList[1] = null;
        return t2;
    }

    public AnimalToken drawToken3() {
        AnimalToken t3 = tokenList[2];
        tokenList[2] = null;
        return t3;
    }

    public AnimalToken drawToken4() {
        AnimalToken t4 = tokenList[3];
        tokenList[3] = null;
        return t4;
    }

    public HabitatTile drawTile1() {
        HabitatTile t1 = tileList[0];
        tileList[0] = null;
        return t1;
    }

    public HabitatTile drawTile2() {
        HabitatTile t2 = tileList[1];
        tileList[1] = null;
        return t2;
    }

    public HabitatTile drawTile3() {
        HabitatTile t3 = tileList[2];
        tileList[2] = null;
        return t3;
    }

    public HabitatTile drawTile4() {
        HabitatTile t4 = tileList[3];
        tileList[3] = null;
        return t4;
    }

    // replaces any missing tokens
    public void fillTokens() {
        for (int i=0; i<4; i++) {
            if (tokenList[i]==null)
                tokenList[i] = bag.draw();
        }
    }

    public void checkOverpop() {
        int type1 = tokenList[0].getAnimalType();
        int type2 = tokenList[1].getAnimalType();
        int type3 = tokenList[2].getAnimalType();
        int type4 = tokenList[3].getAnimalType();
        
        // checks if all 4 available animal token are of the same type; overpopulation
        if (type1 == type2 && type1 == type3 && type1 == type4)
            overpopulation4 = true;
        else {
            overpopulation4 = false;
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(type1);
        list.add(type2);
        list.add(type3);
        list.add(type4);
        
        // checks for overpop using token 1
        boolean check1 = false;
        int x1 = 0;
        for (int a: list) {
            if (a==type1)
                x1++;
        }
        if (x1==3)
            check1 = true;
        
        // checks for overpop using token 2
        boolean check2 = false;
        int x2 = 0;
        for (int b: list) {
            if (b==type2)
                x2++;
        }
        if (x2==3)
            check2 = true;
        
        // checks for overpop using token 3
        boolean check3 = false;
        int x3 = 0;
        for (int c: list) {
            if (c==type3)
                x3++;
        }
        if (x3==3)
            check3 = true;
        
        // checks for overpop using token 4
        boolean check4 = false;
        int x4 = 0;
        for (int d: list) {
            if (d==type4)
                x4++;
        }
        if (x4==3)
            check4 = true;
        
        if (check1 || check2 || check3 || check4)
            overpopulation3 = true;
        else {
            overpopulation3 = false;
        }
    }
}

