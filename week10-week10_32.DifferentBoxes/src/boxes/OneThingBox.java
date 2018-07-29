package boxes;

import java.util.*;

public class OneThingBox extends Box
{
    private List<Thing> things;
    
    public OneThingBox()
    {
        things = new ArrayList<Thing>();
    }

    @Override
    public void add(Thing thing)
    {
        if(things.isEmpty() && thing != null)
            things.add(thing);
    }

    @Override
    public boolean isInTheBox(Thing thing)
    {
        if(things.contains(thing))
            return true;
        return false;
    }
    
}