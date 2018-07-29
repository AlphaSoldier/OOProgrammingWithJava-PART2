import java.util.ArrayList;

public class Suitcase
{
    private ArrayList<Thing> things;
    private int limit;

    public Suitcase(int limit) {
        things = new ArrayList<Thing>();
        this.limit = limit;
    }
    
    public void addThing(Thing thing)
    {
        if(totalWeight() + thing.getWeight() <= limit)
            things.add(thing);
    }
    
    public void printThings()
    {
        for(Thing t : things)
        {
            System.out.println(t);
        }
    }
    
    public int totalWeight()
    {
        int weight = 0;
        for(Thing t : things)
        {
            weight += t.getWeight();
        }
        return weight;
    }
    
    public Thing heaviestThing()
    {
        Thing heaviest = null;
        int weight = 0;
        for(Thing t : things)
        {
            if(t.getWeight() > weight)
            {
                weight = t.getWeight();
                heaviest = t;
            }
        }
        return heaviest;
    }
    
    public String toString()
    {
        String thing = "";
        if(things.size() == 0)
            thing = "empty (";
        else if(things.size() == 1)
            thing = "1 thing (";
        else
            thing = things.size() + " things (";
        
        return thing + totalWeight() + " kg)";
    }
}