import java.util.ArrayList;
public class CenterBoard {
    private AnimalToken[] tokenList;
    private HabitatTile[] tileList;
    private boolean overpopulation3, overpopulation4;
    private BagOfAnimalTokens bag;
    private TilePile stack;

    public CenterBoard() {
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
        tokenList[0] = null;
        return t1;
    }

    public HabitatTile drawTile2() {
        HabitatTile t2 = tileList[1];
        tokenList[1] = null;
        return t2;
    }

    public HabitatTile drawTile3() {
        HabitatTile t3 = tileList[2];
        tokenList[2] = null;
        return t3;
    }

    public HabitatTile drawTile4() {
        HabitatTile t4 = tileList[3];
        tokenList[3] = null;
        return t4;
    }

    // refills the animal token array with four new animal tokens
    public void fillTokens() {
        for (int i=0; i<4; i++)
            tokenList[i] = bag.draw();
    }

   // public void fillTiles() {
   //     for (int i=0; i<4; i++)
   //         tileList[i] = stack.draw();
   // }

    public void checkOverpop() {
        int type1 = tokenList[0].getAnimalType();
        int type2 = tokenList[1].getAnimalType();
        int type3 = tokenList[2].getAnimalType();
        int type4 = tokenList[3].getAnimalType();
        
        // checks if all 4 available animal token are of the same type; overpopulation
        if (type1 == type2 && type1 == type3 && type1 == type4)
            overpopulation4 = true;
        
        
    }

    

}
