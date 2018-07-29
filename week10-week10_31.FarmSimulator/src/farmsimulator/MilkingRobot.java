package farmsimulator;

import java.lang.Exception;

public class MilkingRobot
{
    private BulkTank bt;
    
    public MilkingRobot()
    {
        bt = null;
    }
    
    public BulkTank getBulkTank() throws IllegalStateException
    {
        return bt;
    }
    
    public void setBulkTank(BulkTank bt)
    {
        this.bt = bt;
    }
    
    public void milk(Milkable milkable)
    {
        if(bt != null)
        {
            bt.addToTank(milkable.milk());
        }
        else
            throw new IllegalStateException("The bulk tank hasn't been installed");
    }
}