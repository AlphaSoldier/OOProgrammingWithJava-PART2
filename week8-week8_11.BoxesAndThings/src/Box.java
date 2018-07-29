import java.util.*;

public class Box implements ToBeStored
{
    private double maxWeight;
    private ArrayList<ToBeStored> things;

    public Box(double maxWeight) {
        this.maxWeight = maxWeight;
        things = new ArrayList<ToBeStored>();
    }
    
    public void add(ToBeStored thing)
    {
        if(thing.weight() + this.weight() <= this.maxWeight)
            things.add(thing);
    }
    
    @Override
    public String toString()
    {
        return "Box: " + things.size() + " things, total weight " + this.weight() + " kg";
    }
    
    @Override
    public double weight()
    {
        double weight = 0.0;
        for(ToBeStored thing : things)
            weight += thing.weight();
        return weight;
    }
}