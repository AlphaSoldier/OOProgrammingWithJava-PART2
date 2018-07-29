public class Change
{
    private char from;
    private char to;
    
    public Change(char from, char to)
    {
        this.from = from;
        this.to = to;
    }
    
    public String change(String s)
    {
        return s.replace(from, to);
    }
}
