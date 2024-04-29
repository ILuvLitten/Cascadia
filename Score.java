import java.util.ArrayList;
import static java.lang.System.*;

public class Score {
    private int bearScore;
    private int salmonScore;
    private int foxScore;
    private int hawkScore;
    private int elkScore;
    private int mountainScore;
    private int riverScore;
    private int prairieScore;
    private int forestScore;
    private int wetlandScore;
    private int natureTokens;
    private GameBoard b;

    public Score(GameBoard b) {
        this.b = b;
        bearScore = 0;
        salmonScore = 0;
        foxScore = 0;
        hawkScore = 0;
        elkScore = 0;
        mountainScore = 0;
        riverScore = 0;
        prairieScore = 0;
        forestScore = 0;
        wetlandScore = 0;
    }
    public void calcBearScore(){
        Hex[][] board = b.getBoard();
        int numPairs = 0;
        int num = 0;
        for (int r=0; r<42; r++) {
            for (int c=0; c<42; c++) {
                Hex h = board[r][c];
                if (!h.getEmpty() && h.getTile().containsBear() && !h.getTile().getToken().getScored()) {
                    boolean pair = b.pairBear(r, c);
                    if (pair) {
                        board[r][c].getTile().getToken().setScored(true);
                        numPairs++;
                    }
                }
            }
        }
        if (numPairs < 1) {
            num = 0;
        } else if (numPairs < 2) {
            num = 4;
        } else if (numPairs < 3) {
            num = 11;
        } else if (numPairs < 4) {
            num = 19;
        } else if (numPairs < 5){
            num = 27;
        } else {
            num = 0;
        }
        bearScore = num;
    }
    public void calcSalmonScore(){
        Hex[][] board = b.getBoard();
        int num = 0;
        for (int r=0; r<42; r++) {
            for (int c=0; c<42; c++) {
                Hex h = board[r][c];
                if (!h.getEmpty()) {
                    //out.println(r + " " + c + " not empty");
                    if (h.getTile().containsSalmon()) {
                        //out.println(r + " " + c + " contains salmon");
                        if (!h.getTile().getToken().getScored()) {
                            //out.println(r + " " + c + " not scored");
                        }
                    }
                }
                if (!h.getEmpty() && h.getTile().containsSalmon() && !h.getTile().getToken().getScored()) {
                    int numAdjSalmon = 0;
                    int side = 0;
                    ArrayList<Hex> adjacentSalmons = new ArrayList<Hex>();
                    //out.println(r + " " + c);
                    for (int i=0; i<6; i++) {
                        Hex spot = b.getAdjHex(r, c, i);
                        if (spot!=null && !spot.getEmpty()) {
                            if (spot.getTile().containsSalmon() && !spot.getTile().getToken().getScored()) {
                                numAdjSalmon++;
                                side = i;
                                adjacentSalmons.add(spot);
                            }
                        }
                    }
                    if (adjacentSalmons.isEmpty()) {
                        num += 2;
                        board[r][c].getTile().getToken().setScored(true);
                    }
                    if (numAdjSalmon==1) {
                        boolean bool = b.adjacentRun(r, c, side);
                        if (bool) {
                            int size = b.runSize(r, c) + 1;
                            out.println("size " + size);
                            if (size < 3) {
                                num += 5;
                            } else if (size < 4) {
                                num += 8;
                            } else if (size < 5) {
                                num += 12;
                            } else if (size < 6) {
                                num += 16;
                            } else if (size < 7) {
                                num += 20;
                            } else {
                                num += 25;
                            }
                        }
                    }
                    if (numAdjSalmon == 2) {
                        Hex firstSalmon = adjacentSalmons.get(0);
                        //out.println("adjacentone " + r + " " + c + " row and column: " + firstSalmon.getRow() + " " + firstSalmon.getColumn());
                        Hex secondSalmon = adjacentSalmons.get(1);
                        //out.println("adjacenttwo " + r + " " + c + " row and column: " + secondSalmon.getRow() + " " + secondSalmon.getColumn());
                        if (b.findTypeAdjacent(firstSalmon)<=2 && b.findTypeAdjacent(secondSalmon)<=2) {
                            num += 8;
                            board[r][c].getTile().getToken().setScored(true);
                            firstSalmon.getTile().getToken().setScored(true);
                            secondSalmon.getTile().getToken().setScored(true);
                        }
                    }
                }
            }
        }
        salmonScore = num;
    }
    public void calcFoxScore(){
        int num = 0;
        Hex[][] board = b.getBoard();
        for (int r=0; r<42; r++) {
            for (int c=0; c<42; c++) {
                if (!board[r][c].getEmpty() && board[r][c].getTile().containsFox()) {
                    num += b.uniqueFox(r, c);
                }
            }
        }
        foxScore = num;
    }
    public void calcHawkScore(){
        Hex[][] board = b.getBoard();
        int numHawk = 0;
        for (int r=0; r<42; r++) {
            for (int c=0; c<42; c++) {
                if (!board[r][c].getEmpty()) {
                    if (board[r][c].getTile().containsHawk()==true)
                        numHawk += b.soloHawk(r, c);
                }
            }
        }
        if (numHawk < 1) {
            hawkScore = 0;
        } else if (numHawk < 2) {
            hawkScore = 2;
        } else if (numHawk < 3) {
            hawkScore = 5;
        } else if (numHawk < 4) {
            hawkScore = 8;
        } else if (numHawk < 5) {
            hawkScore = 11;
        } else if (numHawk < 6) {
            hawkScore = 14;
        } else if (numHawk < 7) {
            hawkScore = 18;
        } else if (numHawk < 8) {
            hawkScore = 22;
        } else {
            hawkScore = 28;
        }
    }
    public void calcElkScore(){
        elkScore = b.calculateElk();
    }
    public void calcMountainScore(){
        mountainScore = b.calculateMountain();
    }
    public void calcRiverScore(){
        riverScore = b.calculateRiver();
    }
    public void calcPrairieScore(){
        prairieScore = b.calculatePrairie();
    }
    public void calcForestScore(){
        forestScore = b.calculateForest();
    }
    public void calcWetlandScore(){
        wetlandScore = b.calculateWetland();
    }
    public void calcNatureTokens() {
        natureTokens = b.getNatureTokens();
    }
    public int getBearScore() {
        calcBearScore();
        return bearScore;
    }
    public int getSalmonScore() {
        calcSalmonScore();
        return salmonScore;
    }
    public int getFoxScore() {
        calcFoxScore();
        return foxScore;
    }
    public int getHawkScore() {
        calcHawkScore();
        return hawkScore;
    }
    public int getElkScore() {
        calcElkScore();
        return elkScore;
    }
    public int getMountainScore() {
        calcMountainScore();
        return mountainScore;
    }
    public int getRiverScore() {
        calcRiverScore();
        return riverScore;
    }
    public int getPrairieScore() {
        calcPrairieScore();
        return prairieScore;
    }
    public int getForestScore() {
        calcForestScore();
        return forestScore;
    }
    public int getWetlandScore() {
        calcWetlandScore();
        return wetlandScore;
    }
    public int getNatureTokens() {
        calcNatureTokens();
        return natureTokens;
    }

}
