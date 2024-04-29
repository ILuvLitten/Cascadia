import java.util.ArrayList;
import static java.lang.System.*;
import java.util.TreeSet;

public class Scoring {
    Player player1, player2, player3;
    GameBoard board1, board2, board3;
    private int bearScore1, bearScore2, bearScore3;
    private int salmonScore1, salmonScore2, salmonScore3;
    private int foxScore1, foxScore2, foxScore3;
    private int hawkScore1, hawkScore2, hawkScore3;
    private int elkScore1, elkScore2, elkScore3;
    private int mountainScore1, mountainScore2, mountainScore3;
    private int riverScore1, riverScore2, riverScore3;
    private int prairieScore1, prairieScore2, prairieScore3;
    private int forestScore1, forestScore2, forestScore3;
    private int wetlandScore1, wetlandScore2, wetlandScore3;
    private int natureTokens1, natureTokens2, natureTokens3;
    private int totalScore1, totalScore2, totalScore3;
    private int mountainExtra1, mountainExtra2, mountainExtra3;
    private int forestExtra1, forestExtra2, forestExtra3;
    private int prairieExtra1, prairieExtra2, prairieExtra3;
    private int wetlandExtra1, wetlandExtra2, wetlandExtra3;
    private int riverExtra1, riverExtra2, riverExtra3;
    private int first, second, third;
    private boolean firstSecondTie, secondThirdTie, threeWayTie;

    public Scoring(Player one, Player two, Player three) {
        player1 = one;
        player2 = two;
        player3 = three;
        board1 = one.getBoard();
        board2 = two.getBoard();
        board3 = three.getBoard();
        bearScore1 = one.getScoreCard().getBearScore();
        bearScore2 = two.getScoreCard().getBearScore();
        bearScore3 = three.getScoreCard().getBearScore();
        elkScore1 = one.getScoreCard().getElkScore();
        elkScore2 = two.getScoreCard().getElkScore();
        elkScore3 = three.getScoreCard().getElkScore();
        salmonScore1 = one.getScoreCard().getSalmonScore();
        salmonScore2 = two.getScoreCard().getSalmonScore();
        salmonScore3 = three.getScoreCard().getSalmonScore();
        hawkScore1 = one.getScoreCard().getHawkScore();
        hawkScore2 = two.getScoreCard().getHawkScore();
        hawkScore3 = three.getScoreCard().getHawkScore();
        foxScore1 = one.getScoreCard().getFoxScore();
        foxScore2 = two.getScoreCard().getFoxScore();
        foxScore3 = three.getScoreCard().getFoxScore();
        mountainScore1 = one.getScoreCard().getMountainScore();
        mountainScore2 = two.getScoreCard().getMountainScore();
        mountainScore3 = three.getScoreCard().getMountainScore();
        forestScore1 = one.getScoreCard().getForestScore();
        forestScore2 = two.getScoreCard().getForestScore();
        forestScore3 = three.getScoreCard().getForestScore();
        prairieScore1 = one.getScoreCard().getPrairieScore();
        prairieScore2 = two.getScoreCard().getPrairieScore();
        prairieScore3 = three.getScoreCard().getPrairieScore();
        wetlandScore1 = one.getScoreCard().getWetlandScore();
        wetlandScore2 = two.getScoreCard().getWetlandScore();
        wetlandScore3 = three.getScoreCard().getWetlandScore();
        riverScore1 = one.getScoreCard().getRiverScore();
        riverScore2 = two.getScoreCard().getRiverScore();
        riverScore3 = three.getScoreCard().getRiverScore();
        natureTokens1 = one.getScoreCard().getNatureTokens();
        natureTokens2 = two.getScoreCard().getNatureTokens();
        natureTokens3 = three.getScoreCard().getNatureTokens();
        mountainExtra1 = 0;
        mountainExtra2 = 0;
        mountainExtra3 = 0;
        forestExtra1 = 0;
        forestExtra2 = 0;
        forestExtra3 = 0;
        prairieExtra1 = 0;
        prairieExtra2 = 0;
        prairieExtra3 = 0;
        wetlandExtra1 = 0;
        wetlandExtra2 = 0;
        wetlandExtra3 = 0;
        riverExtra1 = 0;
        riverExtra2 = 0;
        riverExtra3 = 0;
        totalScore1 = 0;
        totalScore2 = 0;
        totalScore3 = 0;
        calcAll();
        rank();
    }

    public void calcAll() {
        calcPlayer1();
        calcPlayer2();
        calcPlayer3();
    }

    public int getTotal1() {
        return totalScore1;
    }
    public int getTotal2() {
        return totalScore2;
    }
    public int getTotal3() {
        return totalScore3;
    }
    // returns player # of first place (i.e. Player 2 is the winner, returns 2)
    public int getFirst() {
        return first;
    }
    public int getSecond() {
        return second;
    }
    public int getThird() {
        return third;
    }

    //player specific calculation methods
    public int calcPlayer1() {
        int c = 0;
        c += bearScore1 + elkScore1 + salmonScore1 + hawkScore1 + foxScore1;
        c += mountainScore1 + forestScore1 + prairieScore1 + wetlandScore1 + riverScore1;

        // checks for bonus points
        if (mountainScore1 > mountainScore2 && mountainScore1 > mountainScore3) {
            mountainExtra1 = 3;
        } else if ((mountainScore1 < mountainScore2 && mountainScore1 > mountainScore3) || (mountainScore1 < mountainScore3 && mountainScore1 > mountainScore2)) {
            mountainExtra1 = 1;
        } else if ((mountainScore1 > mountainScore2 && mountainScore1 == mountainScore3) || (mountainScore1 > mountainScore3 && mountainScore1 == mountainScore2)) {
            mountainExtra1 = 2;
        } else if (mountainScore1 == mountainScore2 && mountainScore1 == mountainScore3) {
            mountainExtra1 = 1;
        } 

        if (forestScore1 > forestScore2 && forestScore1 > forestScore3) {
            forestExtra1 = 3;
        } else if ((forestScore1 < forestScore2 && forestScore1 > forestScore3) || (forestScore1 < forestScore3 && forestScore1 > forestScore2)) {
            forestExtra1 = 1;
        } else if ((forestScore1 > forestScore2 && forestScore1 == forestScore3) || (forestScore1 > forestScore3 && forestScore1 == forestScore2)) {
            forestExtra1 = 2;
        } else if (forestScore1 == forestScore2 && forestScore1 == forestScore3) {
            forestExtra1 = 1;
        } 

        if (prairieScore1 > prairieScore2 && prairieScore1 > prairieScore3) {
            prairieExtra1 = 3;
        } else if ((prairieScore1 < prairieScore2 && prairieScore1 > prairieScore3) || (prairieScore1 < prairieScore3 && prairieScore1 > prairieScore2)) {
            prairieExtra1 = 1;
        } else if ((prairieScore1 > prairieScore2 && prairieScore1 == prairieScore3) || (prairieScore1 > prairieScore3 && prairieScore1 == prairieScore2)) {
            prairieExtra1 = 2;
        } else if (prairieScore1 == prairieScore2 && prairieScore1 == prairieScore3) {
            prairieExtra1 = 1;
        } 

        if (wetlandScore1 > wetlandScore2 && wetlandScore1 > wetlandScore3) {
            wetlandExtra1 = 3;
        } else if ((wetlandScore1 < wetlandScore2 && wetlandScore1 > wetlandScore3) || (wetlandScore1 < wetlandScore3 && wetlandScore1 > wetlandScore2)) {
            wetlandExtra1 = 1;
        } else if ((wetlandScore1 > wetlandScore2 && wetlandScore1 == wetlandScore3) || (wetlandScore1 > wetlandScore3 && wetlandScore1 == wetlandScore2)) {
            wetlandExtra1 = 2;
        } else if (wetlandScore1 == wetlandScore2 && wetlandScore1 == wetlandScore3) {
            wetlandExtra1 = 1;
        } 

        if (riverScore1 > riverScore2 && riverScore1 > riverScore3) {
            riverExtra1 = 3;
        } else if ((riverScore1 < riverScore2 && riverScore1 > riverScore3) || (riverScore1 < riverScore3 && riverScore1 > riverScore2)) {
            riverExtra1 = 1;
        } else if ((riverScore1 > riverScore2 && riverScore1 == riverScore3) || (riverScore1 > riverScore3 && riverScore1 == riverScore2)) {
            riverExtra1 = 2;
        } else if (riverScore1 == riverScore2 && riverScore1 == riverScore3) {
            riverExtra1 = 1;
        } 
        
        c += mountainExtra1 + forestExtra1 + prairieExtra1 + wetlandExtra1 + riverExtra1;
        c += natureTokens1;
        totalScore1 = c;
        return c;
    }

    public int calcPlayer2() {
        int c = 0;
        c += bearScore2 + elkScore2 + salmonScore2 + hawkScore2 + foxScore2;
        c += mountainScore2 + forestScore2 + prairieScore2 + wetlandScore2 + riverScore2;

        // checks for bonus points
        if (mountainScore2 > mountainScore1 && mountainScore2 > mountainScore3) {
            mountainExtra2 = 3;
        } else if ((mountainScore2 < mountainScore1 && mountainScore2 > mountainScore3) || (mountainScore2 < mountainScore3 && mountainScore2 > mountainScore1)) {
            mountainExtra2 = 1;
        } else if ((mountainScore2 > mountainScore1 && mountainScore2 == mountainScore3) || (mountainScore2 > mountainScore3 && mountainScore2 == mountainScore1)) {
            mountainExtra2 = 2;
        } else if (mountainScore2 == mountainScore1 && mountainScore2 == mountainScore3) {
            mountainExtra2 = 1;
        } 

        if (forestScore2 > forestScore1 && forestScore2 > forestScore3) {
            forestExtra2 = 3;
        } else if ((forestScore2 < forestScore1 && forestScore2 > forestScore3) || (forestScore2 < forestScore3 && forestScore2 > forestScore1)) {
            forestExtra2 = 1;
        } else if ((forestScore2 > forestScore1 && forestScore2 == forestScore3) || (forestScore2 > forestScore3 && forestScore2 == forestScore1)) {
            forestExtra2 = 2;
        } else if (forestScore2 == forestScore1 && forestScore2 == forestScore3) {
            forestExtra2 = 1;
        } 

        if (prairieScore2 > prairieScore1 && prairieScore2 > prairieScore3) {
            prairieExtra2 = 3;
        } else if ((prairieScore2 < prairieScore1 && prairieScore2 > prairieScore3) || (prairieScore2 < prairieScore3 && prairieScore2 > prairieScore1)) {
            prairieExtra2 = 1;
        } else if ((prairieScore2 > prairieScore1 && prairieScore2 == prairieScore3) || (prairieScore2 > prairieScore3 && prairieScore2 == prairieScore1)) {
            prairieExtra2 = 2;
        } else if (prairieScore2 == prairieScore1 && prairieScore2 == prairieScore3) {
            prairieExtra2 = 1;
        } 

        if (wetlandScore2 > wetlandScore1 && wetlandScore2 > wetlandScore3) {
            wetlandExtra2 = 3;
        } else if ((wetlandScore2 < wetlandScore1 && wetlandScore2 > wetlandScore3) || (wetlandScore2 < wetlandScore3 && wetlandScore2 > wetlandScore1)) {
            wetlandExtra2 = 1;
        } else if ((wetlandScore2 > wetlandScore1 && wetlandScore2 == wetlandScore3) || (wetlandScore2 > wetlandScore3 && wetlandScore2 == wetlandScore1)) {
            wetlandExtra2 = 2;
        } else if (wetlandScore2 == wetlandScore1 && wetlandScore2 == wetlandScore3) {
            wetlandExtra2 = 1;
        } 

        if (riverScore2 > riverScore1 && riverScore2 > riverScore3) {
            riverExtra2 = 3;
        } else if ((riverScore2 < riverScore1 && riverScore2 > riverScore3) || (riverScore2 < riverScore3 && riverScore2 > riverScore1)) {
            riverExtra2 = 1;
        } else if ((riverScore2 > riverScore1 && riverScore2 == riverScore3) || (riverScore2 > riverScore3 && riverScore2 == riverScore1)) {
            riverExtra2 = 2;
        } else if (riverScore2 == riverScore1 && riverScore2 == riverScore1) {
            riverExtra2 = 1;
        } 
        
        c += mountainExtra2 + forestExtra2 + prairieExtra2 + wetlandExtra2 + riverExtra2;
        c += natureTokens2;
        totalScore2 = c;
        return c;
    }

    public int calcPlayer3() {
        int c = 0;
        c += bearScore3 + elkScore3 + salmonScore3 + hawkScore3 + foxScore3;
        c += mountainScore3 + forestScore3 + prairieScore3 + wetlandScore3 + riverScore3;

        // checks for bonus points
        if (mountainScore3 > mountainScore1 && mountainScore3 > mountainScore2) {
            mountainExtra3 = 3;
        } else if ((mountainScore3 < mountainScore1 && mountainScore3 > mountainScore2) || (mountainScore3 < mountainScore2 && mountainScore3 > mountainScore1)) {
            mountainExtra3 = 1;
        } else if ((mountainScore3 > mountainScore1 && mountainScore3 == mountainScore2) || (mountainScore3 > mountainScore2 && mountainScore3 == mountainScore1)) {
            mountainExtra3 = 2;
        } else if (mountainScore3 == mountainScore1 && mountainScore3 == mountainScore2) {
            mountainExtra3 = 1;
        } 

        if (forestScore3 > forestScore1 && forestScore3 > forestScore2) {
            forestExtra3 = 3;
        } else if ((forestScore3 < forestScore1 && forestScore3 > forestScore2) || (forestScore3 < forestScore2 && forestScore3 > forestScore1)) {
            forestExtra3 = 1;
        } else if ((forestScore3 > forestScore1 && forestScore3 == forestScore2) || (forestScore3 > forestScore2 && forestScore3 == forestScore1)) {
            forestExtra3 = 2;
        } else if (forestScore3 == forestScore1 && forestScore3 == forestScore2) {
            forestExtra3 = 1;
        } 

        if (prairieScore3 > prairieScore1 && prairieScore3 > prairieScore2) {
            prairieExtra3 = 3;
        } else if ((prairieScore3 < prairieScore1 && prairieScore3 > prairieScore2) || (prairieScore3 < prairieScore2 && prairieScore3 > prairieScore1)) {
            prairieExtra3 = 1;
        } else if ((prairieScore3 > prairieScore1 && prairieScore3 == prairieScore2) || (prairieScore3 > prairieScore2 && prairieScore3 == prairieScore1)) {
            prairieExtra3 = 2;
        } else if (prairieScore3 == prairieScore1 && prairieScore3 == prairieScore2) {
            prairieExtra3 = 1;
        } 

        if (wetlandScore3 > wetlandScore1 && wetlandScore3 > wetlandScore2) {
            wetlandExtra3 = 3;
        } else if ((wetlandScore3 < wetlandScore1 && wetlandScore3 > wetlandScore2) || (wetlandScore3 < wetlandScore2 && wetlandScore3 > wetlandScore1)) {
            wetlandExtra3 = 1;
        } else if ((wetlandScore3 > wetlandScore2 && wetlandScore3 == wetlandScore1) || (wetlandScore3 > wetlandScore1 && wetlandScore3 == wetlandScore2)) {
            wetlandExtra3 = 2;
        } else if (wetlandScore3 == wetlandScore1 && wetlandScore3 == wetlandScore2) {
            wetlandExtra3 = 1;
        } 

        if (riverScore3 > riverScore1 && riverScore3 > riverScore2) {
            riverExtra3 = 3;
        } else if ((riverScore3 < riverScore1 && riverScore3 > riverScore2) || (riverScore3 < riverScore2 && riverScore3 > riverScore1)) {
            riverExtra3 = 1;
        } else if ((riverScore3 > riverScore1 && riverScore3 == riverScore2) || (riverScore3 > riverScore2 && riverScore3 == riverScore1)) {
            riverExtra3 = 2;
        } else if (riverScore3 == riverScore1 && riverScore3 == riverScore2) {
            riverExtra3 = 1;
        } 
        c += mountainExtra3 + forestExtra3 + prairieExtra3 + wetlandExtra3 + riverExtra3;
        c += natureTokens3;
        totalScore3 = c;
        return c;
    }

    public void rank() {
        if (totalScore1 > totalScore2 && totalScore1 > totalScore3) {
            first = 1;
            if (totalScore2 > totalScore3) {
                second = 2;
                third = 3;
            } else if (totalScore3 > totalScore2) {
                second = 3;
                third = 2;
            } else if (totalScore2 == totalScore3) {
                if (natureTokens2 > natureTokens3) {
                    second = 2;
                    third = 3;
                } else if (natureTokens3 > natureTokens2) {
                    second = 3;
                    third = 2;
                } else {
                    secondThirdTie = true;
                    second = 2;
                    third = 3;
                }
            }
        } else if (totalScore2 > totalScore1 && totalScore2 > totalScore3) {
            first = 2;
            if (totalScore1 > totalScore3) {
                second = 1;
                third = 3;
            } else if (totalScore3 > totalScore1) {
                second = 3;
                third = 1;
            } else if (totalScore1 == totalScore3) {
                if (natureTokens1 > natureTokens3) {
                    second = 1;
                    third = 3;
                } else if (natureTokens3 > natureTokens1) {
                    second = 3;
                    third = 1;
                } else {
                    secondThirdTie = true;
                    second = 1;
                    third = 3;
                }
            }
        } else if (totalScore3 > totalScore1 && totalScore3 > totalScore2) {
            first = 3;
            if (totalScore1 > totalScore2) {
                second = 1;
                third = 2;
            } else if (totalScore2 > totalScore1) {
                second = 2;
                third = 1;
            } else if (totalScore1 == totalScore2) {
                if (natureTokens1 > natureTokens2) {
                    second = 1;
                    third = 2;
                } else if (natureTokens2 > natureTokens1) {
                    second = 2;
                    third = 1;
                } else {
                    secondThirdTie = true;
                    second = 1;
                    third = 2;
                }
            }
        } else if (totalScore1 == totalScore2) {
            if (totalScore1 > totalScore3) {
                if (natureTokens1 > natureTokens2) {
                    first = 1;
                    second = 2;
                } else if (natureTokens2 > natureTokens1) {
                    first = 2;
                    second = 1;
                } else {
                    first = 1;
                    second = 2;
                    firstSecondTie = true;
                }
                third = 3;
            } else if (totalScore1 == totalScore3) {
                if (natureTokens1 > natureTokens2 && natureTokens1 > natureTokens3) {
                    first = 1;
                    if (natureTokens2 > natureTokens3) {
                        second = 2;
                        third = 2;
                    } else if (natureTokens3 > natureTokens2) {
                        second = 3;
                        third = 2;
                    } else {
                        second = 2;
                        third = 3;
                        secondThirdTie = true;
                    }
                } else if (natureTokens2 > natureTokens1 && natureTokens2 > natureTokens3) {
                    first = 2;
                    if (natureTokens1 > natureTokens3) {
                        second = 1;
                        third = 3;
                    } else if (natureTokens3 > natureTokens1) {
                        second = 3;
                        third = 1;
                    } else {
                        second = 1;
                        third = 3;
                        secondThirdTie = true;
                    }
                } else if (natureTokens3 > natureTokens1 && natureTokens3 > natureTokens2) {
                    first = 3;
                    if (natureTokens1 > natureTokens2) {
                        second = 1;
                        third = 2;
                    } else if (natureTokens2 > natureTokens1) {
                        second = 2;
                        third = 1;
                    } else {
                        second = 1;
                        third = 2;
                        secondThirdTie = true;
                    }
                } else if (natureTokens1 == natureTokens2 && natureTokens1 > natureTokens3) {
                    firstSecondTie = true;
                    first = 1;
                    second = 2;
                    third = 3;
                } else if (natureTokens1 == natureTokens3 && natureTokens1 > natureTokens2) {
                    firstSecondTie = true;
                    first = 1;
                    second = 3;
                    third = 2;
                } else if (natureTokens2 == natureTokens3 && natureTokens2 > natureTokens1) {
                    firstSecondTie = true;
                    first = 2;
                    second = 3;
                    third = 1;
                } else if (natureTokens1 == natureTokens2 && natureTokens1 == natureTokens3) {
                    first = 1;
                    second = 2;
                    third = 3;
                    threeWayTie = true;
                }
            }
        } else if (totalScore1 == totalScore3) {
            if (totalScore1 > totalScore2) {
                if (natureTokens1 > natureTokens3) {
                    first = 1;
                    second = 3;
                } else if (natureTokens3 > natureTokens1) {
                    first = 3;
                    second = 1;
                } else {
                    first = 1;
                    second = 3;
                    firstSecondTie = true;
                }
                third = 2;
            } else if (totalScore1 == totalScore2) {
                if (natureTokens1 > natureTokens2 && natureTokens1 > natureTokens3) {
                    first = 1;
                    if (natureTokens2 > natureTokens3) {
                        second = 2;
                        third = 2;
                    } else if (natureTokens3 > natureTokens2) {
                        second = 3;
                        third = 2;
                    } else {
                        second = 2;
                        third = 3;
                        secondThirdTie = true;
                    }
                } else if (natureTokens2 > natureTokens1 && natureTokens2 > natureTokens3) {
                    first = 2;
                    if (natureTokens1 > natureTokens3) {
                        second = 1;
                        third = 3;
                    } else if (natureTokens3 > natureTokens1) {
                        second = 3;
                        third = 1;
                    } else {
                        second = 1;
                        third = 3;
                        secondThirdTie = true;
                    }
                } else if (natureTokens3 > natureTokens1 && natureTokens3 > natureTokens2) {
                    first = 3;
                    if (natureTokens1 > natureTokens2) {
                        second = 1;
                        third = 2;
                    } else if (natureTokens2 > natureTokens1) {
                        second = 2;
                        third = 1;
                    } else {
                        second = 1;
                        third = 2;
                        secondThirdTie = true;
                    }
                } else if (natureTokens1 == natureTokens2 && natureTokens1 > natureTokens3) {
                    firstSecondTie = true;
                    first = 1;
                    second = 2;
                    third = 3;
                } else if (natureTokens1 == natureTokens3 && natureTokens1 > natureTokens2) {
                    firstSecondTie = true;
                    first = 1;
                    second = 3;
                    third = 2;
                } else if (natureTokens2 == natureTokens3 && natureTokens2 > natureTokens1) {
                    firstSecondTie = true;
                    first = 2;
                    second = 3;
                    third = 1;
                } else if (natureTokens1 == natureTokens2 && natureTokens1 == natureTokens3) {
                    first = 1;
                    second = 2;
                    third = 3;
                    threeWayTie = true;
                }
            }
        //
        } else if (totalScore2 == totalScore3) {
            if (totalScore2 > totalScore1) {
                if (natureTokens2 > natureTokens3) {
                    first = 2;
                    second = 3;
                } else if (natureTokens3 > natureTokens2) {
                    first = 3;
                    second = 2;
                } else {
                    first = 2;
                    second = 3;
                    firstSecondTie = true;
                }
                third = 1;
            } else if (totalScore2 == totalScore1) {
                if (natureTokens1 > natureTokens2 && natureTokens1 > natureTokens3) {
                    first = 1;
                    if (natureTokens2 > natureTokens3) {
                        second = 2;
                        third = 2;
                    } else if (natureTokens3 > natureTokens2) {
                        second = 3;
                        third = 2;
                    } else {
                        second = 2;
                        third = 3;
                        secondThirdTie = true;
                    }
                } else if (natureTokens2 > natureTokens1 && natureTokens2 > natureTokens3) {
                    first = 2;
                    if (natureTokens1 > natureTokens3) {
                        second = 1;
                        third = 3;
                    } else if (natureTokens3 > natureTokens1) {
                        second = 3;
                        third = 1;
                    } else {
                        second = 1;
                        third = 3;
                        secondThirdTie = true;
                    }
                } else if (natureTokens3 > natureTokens1 && natureTokens3 > natureTokens2) {
                    first = 3;
                    if (natureTokens1 > natureTokens2) {
                        second = 1;
                        third = 2;
                    } else if (natureTokens2 > natureTokens1) {
                        second = 2;
                        third = 1;
                    } else {
                        second = 1;
                        third = 2;
                        secondThirdTie = true;
                    }
                } else if (natureTokens1 == natureTokens2 && natureTokens1 > natureTokens3) {
                    firstSecondTie = true;
                    first = 1;
                    second = 2;
                    third = 3;
                } else if (natureTokens1 == natureTokens3 && natureTokens1 > natureTokens2) {
                    firstSecondTie = true;
                    first = 1;
                    second = 3;
                    third = 2;
                } else if (natureTokens2 == natureTokens3 && natureTokens2 > natureTokens1) {
                    firstSecondTie = true;
                    first = 2;
                    second = 3;
                    third = 1;
                } else if (natureTokens1 == natureTokens2 && natureTokens1 == natureTokens3) {
                    first = 1;
                    second = 2;
                    third = 3;
                    threeWayTie = true;
                }
            }
        }
    }
    // returns true if there is a tie between first and second
    public boolean getFirstSecondTie() {
        return firstSecondTie;
    }

    // returns true if there is a tie between second and third
    public boolean getSecondThirdTie() {
        return secondThirdTie;
    }

    // returns true if there is a tie between first, second, and third
    public boolean getThreeWayTie() {
        return threeWayTie;
    }
}
