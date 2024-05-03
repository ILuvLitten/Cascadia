public class Player {
    private GameBoard board;
    private Score scoreCard;
    private int natureTokens;

    public Player() {
        board = new GameBoard();
        scoreCard = new Score(board);
        natureTokens = 0;
    }

    public GameBoard getBoard() {
        return board;
    }

    public int getNatureTokens() {
        return natureTokens;
    }
  
    public Score getScoreCard() {
        return scoreCard;
    }

    public void setNatureTokens(int n) {
        natureTokens = n;
    }
    
}
