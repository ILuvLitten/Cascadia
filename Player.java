public class Player {
    private GameBoard board;
    private Score scoreCard;

    public Player() {
        board = new GameBoard();
        scoreCard = new Score(board);
    }

    public GameBoard getBoard() {
        return board;
    }

    public int getNatureTokens() {
        return board.getNatureTokens();
    }
  
    public Score getScoreCard() {
        return scoreCard;

    
}
