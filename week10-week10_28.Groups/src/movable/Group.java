package movable;

import java.util.*;

public class Group implements Movable
{
    private List<Movable> movables;
    
    public Group()
    {
        movables = new ArrayList<Movable>();
    }
    
    public void addToGroup(Movable movable)
    {
        if(!(movable == null))
            movables.add(movable);
    }
    
    @Override
    public String toString()
    {
        String output = "";
        for(Movable movable : movables)
        {
            output += movable.toString();
            output += "\n";
        }
        return output;
    }
    
    @Override
    public void move(int dx, int dy)
    {
        for(Movable movable : movables)
        {
            movable.move(dx, dy);
        }
    }
}