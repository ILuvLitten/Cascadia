import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class BagOfAnimalTokens {
    private Queue<AnimalToken> tokenList;
    
    public BagOfAnimalTokens()
    {
        tokenList = new LinkedList<AnimalToken>();
    }

    public void addTokens(AnimalToken one, AnimalToken two, AnimalToken three) {
        tokenList.offer(one);
        tokenList.offer(two);
        tokenList.offer(three);
    }

    public void addTokens(AnimalToken one, AnimalToken two, AnimalToken three, AnimalToken four) {
        tokenList.offer(one);
        tokenList.offer(two);
        tokenList.offer(three);
        tokenList.offer(four);
    }

    public ArrayList<AnimalToken> draw(int x) {
        ArrayList<AnimalToken> list = new ArrayList<AnimalToken>();
        for (int i=0; i<x; i++) {
            list.add(tokenList.poll());
        }
        return list;
    }
}
