public class Score {
    private int bearScore;
    private int salmonScore;
    private int foxScore;
    private int hawkScore;
    private int elkScore;
    private int totalScore;
    private int mountainScore;
    private int riverScore;
    private int prairieScore;
    private int forestScore;
    private int wetlandScore;

    public Score() {
        bearScore = 0;
        salmonScore = 0;
        foxScore = 0;
        hawkScore = 0;
        elkScore = 0;
        totalScore = 0;
        mountainScore = 0;
        riverScore = 0;
        prairieScore = 0;
        forestScore = 0;
        wetlandScore = 0;
    }
    public void calcBearScore(){

    }
    public void calcSalmonScore(){

    }
    public void calcFoxScore(){

    }
    public void calcHawkScore(){

    }
    public void calcElkScore(){

    }
    public void calcTotalScore(){
        totalScore = bearScore + salmonScore + foxScore + hawkScore + elkScore + mountainScore + riverScore + prairieScore + forestScore + wetlandScore;
    }
    public void calcMountainScore(){

    }
    public void calcRiverScore(){

    }
    public void calcPrairieScore(){

    }
    public void calcForestScore(){

    }
    public void calcWetlandScore(){

    }
    public int getBearScore() {
        return bearScore;
    }
    public int getSalmonScore() {
        return salmonScore;
    }
    public int getFoxScore() {
        return foxScore;
    }
    public int getHawkScore() {
        return hawkScore;
    }
    public int getElkScore() {
        return elkScore;
    }
    public int getTotalScore() {
        return totalScore;
    }
    public int getMountainScore() {
        return mountainScore;
    }
    public int getRiverScore() {
        return riverScore;
    }
    public int getPrairieScore() {
        return prairieScore;
    }
    public int getForestScore() {
        return forestScore;
    }
    public int getWetlandScore() {
        return wetlandScore;
    }


}
