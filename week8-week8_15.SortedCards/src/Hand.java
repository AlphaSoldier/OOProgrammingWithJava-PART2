import java.util.*;

public class Hand implements Comparable<Hand>
{
    private ArrayList<Card> cards;
    
    public Hand()
    {
        cards = new ArrayList<Card>();
    }
    
    public void add(Card card)
    {
        cards.add(card);
    }
    
    public void print()
    {
        for(Card card : cards)
        {
            System.out.println(card);
        }
    }
    
    public void sort()
    {
        Collections.sort(cards);
    }
    
    @Override
    public int compareTo(Hand hand)
    {
        int thisSum = 0, handSum = 0;
        for(Card c : this.cards)
        {
            thisSum += c.getValue();
        }
        for(Card c : hand.cards)
        {
            handSum += c.getValue();
        }
        return thisSum - handSum;
    }
    
    public void sortAgainstSuit()
    {
        Collections.sort(cards, new SortAgainstSuitAndValue());
    }
}