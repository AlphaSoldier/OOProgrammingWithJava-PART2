package farmsimulator;

import java.util.*;

public class Barn
{
    private BulkTank bt;
    private MilkingRobot mr;
    
    public Barn(BulkTank bt)
    {
        this.bt = bt;
        this.mr = null;
    }
    
    public BulkTank getBulkTank()
    {
        return this.bt;
    }
    
    public void installMilkingRobot(MilkingRobot mr)
    {
        this.mr = mr;
        this.mr.setBulkTank(this.bt);
    }
    
    public void takeCareOf(Cow cow)
    {
        if(mr != null)
        {
            mr.milk(cow);
        }
        else
        {
            throw new IllegalStateException();
        }
    }
    
    public void takeCareOf(Collection<Cow> cows)
    {
        if(mr != null)
        {
            for(Cow cow : cows)
            {
                mr.milk(cow);
            }
        }
        else
        {
            throw new IllegalStateException();
        }
    }
    
    @Override
    public String toString()
    {
        return bt.toString();
    }
}