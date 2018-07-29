package moving.domain;

import java.util.*;

public class Box implements Thing 
{
    private List<Thing> things;
    private int maxCapacity;
    
    public Box(int maxCapacity)
    {
        things = new ArrayList<Thing>();
        this.maxCapacity = maxCapacity;
    }
    
    public Box(Box aBox){
        this.things = new ArrayList<Thing>();
        this.maxCapacity = aBox.maxCapacity;
    }
    
    public boolean addThing(Thing thing)
    {
        if(thing.getVolume() + this.getVolume() <= maxCapacity)
        {
            things.add(thing);
            return true;
        }
        return false;
    }
    
    @Override
    public int getVolume()
    {
        int volume = 0;
        for(Thing thing : things)
        {
            volume += thing.getVolume();
        }
        return volume;
    }
}