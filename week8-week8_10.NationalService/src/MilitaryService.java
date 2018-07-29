public class MilitaryService implements NationalService
{
    private int daysLeft;
    
    public MilitaryService(int daysLeft)
    {
        this.daysLeft = daysLeft;
    }
    
    public int getDaysLeft()
    {
        return daysLeft;
    }
    
    public void work()
    {
        daysLeft--;
        if(daysLeft < 0)
            daysLeft = 0;
    }
}