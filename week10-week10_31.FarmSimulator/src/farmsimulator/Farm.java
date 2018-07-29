package farmsimulator;

import java.util.*;

public class Farm implements Alive
{
    private String name;
    private Barn barn;
    private List<Cow> cows;
    
    public Farm(String name, Barn barn)
    {
        this.name = name;
        this.barn = barn;
        cows = new ArrayList<Cow>();
    }
    
    public String getOwner()
    {
        return this.name;
    }
    
    public void addCow(Cow cow)
    {
        if(cow != null)
            cows.add(cow);
    }
    
    public void installMilkingRobot(MilkingRobot mr)
    {
        barn.installMilkingRobot(mr);
    }
    
    public void manageCows()
    {
        barn.takeCareOf(cows);
    }
    
    @Override
    public String toString()
    {
        String animals = "";
        if(cows.isEmpty())
            animals += "No cows.";
        else
        {
            animals += "Animals:\n";
            for(Cow cow : cows)
            {
                animals += "        " + cow.toString() + "\n";
            }
        }
        return "Farm owner: " + this.name + "\nBarn bulk tank: " + barn.toString() + "\n" + animals;
    }

    @Override
    public void liveHour()
    {
        for(Cow cow : cows)
        {
            cow.liveHour();
        }
    }
}