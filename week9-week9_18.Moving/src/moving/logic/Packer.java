package moving.logic;

import moving.domain.*;
import java.util.*;

public class Packer
{
    private int boxesVolume;
    
    public Packer(int boxesVolume)
    {
        this.boxesVolume = boxesVolume;
    }
    
    public List<Box> packThings(List<Thing> things)
    {
        List<Box> boxes = new ArrayList<Box>();
        double thingsTotalVolume = totalVolume(things);
        int numberOfBoxes = (int) Math.ceil(thingsTotalVolume/boxesVolume);
        Box[] boxArray = new Box[numberOfBoxes];
        int start = 0;
        int change = start;
        for (int i = 0; i < numberOfBoxes; i++)
        {
            boxArray[i] = new Box(boxesVolume);
            for(Thing thing : things.subList(change, things.size()))
            {
                boolean adder = boxArray[i].addThing(thing);
                if(!adder)
                {
                    change = start;
                    break;
                }
                start++;
            }
            boxes.add(boxArray[i]);
        }
        return boxes;
    }
    
    public int totalVolume(List<Thing> things)
    {
        int volume = 0;
        for(Thing thing : things)
        {
            volume += thing.getVolume();
        }
        return volume;
    }
}