package reader.criteria;

import java.util.List;
import java.util.ArrayList;

public class AtLeastOne implements Criterion
{
    private List<Criterion> criteria;
    
    public AtLeastOne(Criterion... manyCriterion)
    {
        criteria = new ArrayList<Criterion>();
        for(Criterion c : manyCriterion)
        {
            criteria.add(c);
        }
    }
    
    @Override
    public boolean complies(String line)
    {
        for(Criterion c : criteria)
        {
            if(c.complies(line))
                return true;
        }
        return false;
    }
}