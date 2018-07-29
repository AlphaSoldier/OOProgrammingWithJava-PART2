package reader.criteria;

public class Both implements Criterion
{
    private Criterion first;
    private Criterion second;

    public Both(Criterion first, Criterion second) {
        this.first = first;
        this.second = second;
    }
    
    @Override
    public boolean complies(String line)
    {
        return first.complies(line) && second.complies(line);
    }
}