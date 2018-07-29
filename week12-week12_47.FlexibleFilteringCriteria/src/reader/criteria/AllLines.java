package reader.criteria;

public class AllLines implements Criterion
{
    @Override
    public boolean complies(String line)
    {
        return true;
    }
}