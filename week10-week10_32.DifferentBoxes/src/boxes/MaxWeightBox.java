package boxes;

import java.util.*;

public class MaxWeightBox extends Box
{
    private int maxWeight;
    private List<Thing> things;
    
    public MaxWeightBox(int maxWeight)
    {
        this.maxWeight = maxWeight;
        things = new ArrayList<Thing>();
    }

    @Override
    public void add(Thing thing)
    {
        if(thing.getWeight() + this.boxWeight() <= this.maxWeight)
            things.add(thing);
    }

    @Override
    public boolean isInTheBox(Thing thing)
    {
        if(things.contains(thing))
            return true;
        return false;
    }
    
    private int boxWeight()
    {
        if(things.isEmpty())
            return 0;
        int weight = 0;
        for(Thing thing : things)
        {
            weight += thing.getWeight();
        }
        return weight;
    }
}