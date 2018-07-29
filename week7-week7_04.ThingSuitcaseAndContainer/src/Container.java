import java.util.ArrayList;

public class Container
{
    private int limit;
    private ArrayList<Suitcase> suitcases;

    public Container(int limit) {
        this.limit = limit;
        suitcases = new ArrayList<Suitcase>();
    }
    
    private int totalWeight()
    {
        int weight = 0;
        for(Suitcase s : suitcases)
        {
            weight += s.totalWeight();
        }
        return weight;
    }
    
    public void addSuitcase(Suitcase suitcase)
    {
        if(totalWeight() + suitcase.totalWeight() <= limit)
            suitcases.add(suitcase);
    }
    
    public void printThings()
    {
        for(Suitcase s : suitcases)
        {
            s.printThings();
        }
    }
    
    public String toString()
    {
        return suitcases.size() + " suitcases {" + totalWeight() + " kg)";
    }
}