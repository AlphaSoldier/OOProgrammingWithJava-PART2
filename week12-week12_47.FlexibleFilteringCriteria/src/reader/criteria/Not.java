package reader.criteria;

public class Not implements Criterion
{
    private Criterion criteria;

    public Not(Criterion criteria) {
        this.criteria = criteria;
    }
    
    @Override
    public boolean complies(String line)
    {
        return !criteria.complies(line);
    }
}