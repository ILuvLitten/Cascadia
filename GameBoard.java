import java.util.ArrayList;
public class GameBoard {
    private Hex[][] board;
    private int natureTokens;

    public GameBoard() {
        board = new Hex[20][20];
        for (int r=0; r<20; r++) {
            for (int c=0; c<20; c++) {
                board[r][c] = new Hex(r, c);
            }
        }
        natureTokens = 0;
    }

    public boolean placeTile(int r, int c, HabitatTile tile) {
        if (board[r][c].getEmpty()) {
            board[r][c].setTile(tile);
            return true;
        }
        return false;
    }

    public boolean placeAnimal(int r, int c, AnimalToken t) {
        int type = t.getAnimalType();
        HabitatTile tile = board[r][c].getTile();

        if (type == 1) {
            if (tile.getCanHoldBear()) {
                tile.setToken(t);
                tile.setContainsAnimal(true);
                if (tile.getIsKeystone())
                    natureTokens++;
                return true;
            }
        }

        if (type == 2) {

            if (tile.getCanHoldElk()) {
                tile.setToken(t);
                tile.setContainsAnimal(true);
                if (tile.getIsKeystone())
                    natureTokens++;
                return true;
            }
        }

        if (type == 3) {
            if (tile.getCanHoldSalmon()) {
                tile.setToken(t);
                tile.setContainsAnimal(true);
                if (tile.getIsKeystone())
                    natureTokens++;
                return true;
            }
        }

        if (type == 4) {
            if (tile.getCanHoldHawk()) {
                tile.setToken(t);
                tile.setContainsAnimal(true);
                if (tile.getIsKeystone())
                    natureTokens++;
                return true;
            }
        }

        if (type == 5) {
            if (tile.getCanHoldFox()) {
                tile.setToken(t);
                tile.setContainsAnimal(true);
                if (tile.getIsKeystone())
                    natureTokens++;
                return true;
            }
        }
        return false;
    }

    public Hex getAdjHex(int r, int c, int s) {
        int[] evenCol = {-1, -1, 0, 1, 1, 0};
        int[] oddCol = {0, 1, 1, 1, 0, -1};
        int[] evenRow = {-1, -1, 0, 1, 1, 0};
        int[] oddRow = {-1, -1, 0, 1, 1, 0};
        Hex h = board[r][c];
        boolean even = (r%2 == 0);
        if (r==0) {
            if (s==0 || s==1) {
                return null;
            }
        }
        if (c==0) {
            if (!even) {
                if (s==5)
                    return null;
            }
            if (even) {
                if (s==0 || s==4 || s==5) {
                    return null;
                }
            }
        }
        if (c == 19) {
            if(even) {
                if (s==2)
                    return null;
            }
            if (!even) {
                if (s==1 || s==2 || s==3)
                    return null;
            }
        }
        if (r == 19) {
            if (s==3 || s==4)
                return null;
        }

        if (!even) {
            return board[r+oddRow[s]][c+oddCol[s]];
        }
        else {
            return board[r+evenRow[s]][c+evenCol[s]];
        }

    }
    
    public ArrayList<Hex> getAdjacents(int r, int c) {
        ArrayList<Hex> list = new ArrayList<Hex>();
        for (int i=0; i<6; i++) {
            list.add(getAdjHex(r, c, i));
        }
        return list;
    }

    public int calculateElk(int row, int col) {
        int max = 0;
        return max;
    }

    // determines if the hawk at the given coordinate does not have any adjacent hawks
    public int soloHawk(int row, int col) {
        ArrayList<Hex> list = getAdjacents(row, col);

        for (Hex h: list) {
            if (h.getTile() != null) {
                if (h.getTile().containsHawk())
                    return 0;
            }
        }
        return 1;
    }
    
    public int calculateHawk() {
        int numHawk = 0;
        for (int r=0; r<20; r++) {
            for (int c=0; c<20; c++) {
                numHawk += soloHawk(r, c);
            }
        }
        if (numHawk < 1) {
            return 0;
        } else if (numHawk < 2) {
            return 2;
        } else if (numHawk < 3) {
            return 5;
        } else if (numHawk < 4) {
            return 8;
        } else if (numHawk < 5) {
            return 11;
        } else if (numHawk < 6) {
            return 14;
        } else if (numHawk < 7) {
            return 18;
        } else if (numHawk < 8) {
            return 22;
        } else {
            return 28;
        }
    }

    public int calculateElk() {
        int scoreElk =0;
        for (int r=0; r<20; r++) {
            for (int c=0; c<20; c++) {
                
            }
        }
        return scoreElk;
    }


}
