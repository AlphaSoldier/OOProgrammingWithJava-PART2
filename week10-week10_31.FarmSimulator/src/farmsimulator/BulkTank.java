package farmsimulator;

public class BulkTank
{
    private double capacity;
    private double volume;
    
    public BulkTank()
    {
        this(2000);
    }
    
    public BulkTank(double capacity)
    {
        this.capacity = capacity;
        this.volume = 0;
    }
    
    public double getCapacity()
    {
        return this.capacity;
    }
    
    public double getVolume()
    {
        return this.volume;
    }
    
    public double howMuchFreeSpace()
    {
        return this.capacity - this.volume;
    }
    
    public void addToTank(double amount)
    {
        double freeSpace = this.howMuchFreeSpace();
        if(amount >= freeSpace)
        {
            this.volume = this.capacity;
        }
        else
        {
            this.volume += amount;
        }
    }
    
    public double getFromTank(double amount)
    {
        if(amount >= this.volume)
        {
            double vol = this.volume;
            this.volume = 0;
            return vol;
        }
        else
        {
            this.volume -= amount;
            return amount;
        }
    }
    
    @Override
    public String toString()
    {
        return Math.ceil(this.volume) + "/" + Math.ceil(this.capacity);
    }
}