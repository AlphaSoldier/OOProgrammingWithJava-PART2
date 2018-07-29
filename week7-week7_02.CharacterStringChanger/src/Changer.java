import java.util.ArrayList;

public class Changer
{
    private ArrayList<Change> changer;
    
    public Changer()
    {
        changer = new ArrayList<Change>();
    }
    
    public void addChange(Change change)
    {
        changer.add(change);
    }
    
    public String change(String s)
    {
        for(Change c : changer)
        {
            s = c.change(s);
        }
        return s;
    }
}