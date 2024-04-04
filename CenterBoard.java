import java.util.ArrayList;
public class CenterBoard {
    private ArrayList<AnimalToken> tokenList;
    private ArrayList<HabitatTile> tileList;
    private boolean overpopulation3, overpopulation4;
    private BagOfAnimalTokens bag;

    public CenterBoard() {
        tokenList = new ArrayList<AnimalToken>();
        tileList = new ArrayList<HabitatTile>();
        overpopulation3 = false;
        overpopulation4 = false;
        bag = new BagOfAnimalTokens();
    }

    public ArrayList<AnimalToken> getTokenList() {
        return tokenList;
    }

    public ArrayList<HabitatTile> getTileList() {
        return tileList;
    }

}
