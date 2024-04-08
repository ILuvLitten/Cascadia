public class Hex {
    private HabitatTile ht;
    private boolean empty;
    // matrix coordinates of the hexagon 
    private int r, c;

    public int getRow() {
        return r;
    }

    public void setRow(int row) {
        r = row;
    }

    public void setColumn(int column) {
        c = column;
    }

    public int getColumn() {
        return c;
    }

    public boolean getEmpty() { 
        return empty;
    }

    public void setEmpty(boolean b) {
        empty = b;
    }

    public Hex(int row, int column, HabitatTile t, boolean b) {
        r = row;
        c = column;
        ht = t;
        empty = b;
    }

    public Hex(int row, int column) {
        r = row;
        c = column;
        empty = true;
    }

    public void setTile(HabitatTile t) {
        ht = t;
    }

    public HabitatTile getTile(){
        return ht;
    }


}
