package boxes;

import java.util.*;

public class BlackHoleBox extends Box
{
    private List<Thing> things;
    
    public BlackHoleBox()
    {
        things = new ArrayList<Thing>();
    }

    @Override
    public void add(Thing thing)
    {
        if(thing != null)
            things.add(thing);
    }

    @Override
    public boolean isInTheBox(Thing thing)
    {
        return false;
    }
    
}