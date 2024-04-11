import java.util.ArrayList;
public class GameBoard {
    private Hex[][] board;
    private int natureTokens;

    public GameBoard() {
        board = new Hex[42][42];
        for (int r=0; r<42; r++) {
            for (int c=0; c<42; c++) {
                board[r][c] = new Hex(r, c);
            }
        }
        natureTokens = 0;
    }

    public boolean placeTile(int r, int c, HabitatTile tile) {
        if (board[r][c].getEmpty()) {
            board[r][c].setTile(tile);
            //board[r][c].setEmpty(false);
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
        int[] evenRow = {-1, -1, 0, 1, 1, 0};
        int[] oddCol = {0, 1, 1, 1, 0, -1};
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
        if (c == 41) {
            if(even) {
                if (s==2)
                    return null;
            }
            if (!even) {
                if (s==1 || s==2 || s==3)
                    return null;
            }
        }
        if (r == 41) {
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
        for (int r=0; r<42; r++) {
            for (int c=0; c<42; c++) {
                if (!board[r][c].getEmpty()) {
                    if (board[r][c].getTile().containsHawk()==true)
                        numHawk += soloHawk(r, c);
                    }
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

    public int calculateFox() {
        int scoreFox =0;
        for (int r=0; r<42; r++) {
            for (int c=0; c<42; c++) {
                if (board[r][c].getTile().containsFox()) {
                    scoreFox += uniqueFox(r, c);
                }
            }
        }
        return scoreFox;
    }

    public int uniqueFox(int row, int col) {
        ArrayList<Hex> list = getAdjacents(row, col);
        boolean adjacentBear = false;
        boolean adjacentElk = false;
        boolean adjacentSalmon = false;
        boolean adjacentHawk = false;
        boolean adjacentFox = false;
        int total = 0;
        for (Hex h: list) {
            if (h.getTile()!=null) {
                if (h.getTile().containsBear()) {
                    adjacentBear = true;
                }
                if (h.getTile().containsElk()) {
                    adjacentElk = true;
                }
                if (h.getTile().containsSalmon()) {
                    adjacentSalmon = true;
                }
                if (h.getTile().containsHawk()) {
                    adjacentHawk = true;
                }
                if (h.getTile().containsFox()) {
                    adjacentFox = true;
                }
            }
        }
        if (adjacentBear)
            total++;
        if (adjacentElk)
            total++;
        if (adjacentSalmon)
            total++;
        if (adjacentHawk)
            total++;
        if (adjacentFox)
            total++;
        return total;
    }

    public int calculateBear() {
        int numPairs = 0;
        for (int r=0; r<42; r++) {
            for (int c=0; c<42; c++) {
                Hex h = board[r][c];
                if (!h.getEmpty() && h.getTile().containsBear() && !h.getTile().getToken().getScored()) {
                    boolean pair = pairBear(r, c);
                    if (pair) {
                        board[r][c].getTile().getToken().setScored(true);
                        numPairs = numPairs + 1;
                    }
                }
            }
        }
        if (numPairs < 1) {
            return 0;
        } else if (numPairs < 2) {
            return 4;
        } else if (numPairs < 3) {
            return 11;
        } else if (numPairs < 4) {
            return 19;
        } else {
            return 27;
        }
    }

    public boolean pairBear(int row, int col) {
        ArrayList<Hex> adjacents = getAdjacents(row, col);
        int numAdjacentBears = 0;
        ArrayList<Hex> matches = new ArrayList<Hex>();
        for (Hex h: adjacents) {
            if (!h.getEmpty()) {
                if (h.getTile().containsBear()) {
                    if (!h.getTile().getToken().getScored()) {
                        numAdjacentBears++;
                        matches.add(h);
                    }
                }
            }
        }
        if (numAdjacentBears==1) {
            Hex match = matches.get(0);
            ArrayList<Hex> matchAdjacents = getAdjacents(match.getRow(), match.getColumn());
            int numAdjacentToMatch = 0;
            for (Hex h: matchAdjacents) {
                if (!h.getEmpty()) {
                    if (h.getTile().containsBear()) {
                        numAdjacentToMatch = numAdjacentToMatch + 1;
                    }
                }
            }
            if (numAdjacentToMatch==1) {

                return true;
            }

        }
        return false;
    }

    //public int calculateElk(int row, int col) {
    //    int scoreElk = 0;
    //    Hex h = board[row][col];
    //    ArrayList<Hex> adjacents = getAdjacents(row, col);
//
    //    for (int s=2; s<6; s++) {
    //        Hex adj = adjacents.get(s);
    //        if( adj.getTile().containsElk()){
    //            return 1 + calculateElk(adj.getRow(), adj.getColumn());
    //       }
     //   }



    //} 

    

    public int returnNatureTokens() {
        return natureTokens;
    }
    

}
