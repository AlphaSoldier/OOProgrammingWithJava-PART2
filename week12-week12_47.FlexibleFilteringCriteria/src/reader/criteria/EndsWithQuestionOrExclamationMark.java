package reader.criteria;

public class EndsWithQuestionOrExclamationMark implements Criterion
{
    @Override
    public boolean complies(String line)
    {
        if(line.length() > 0)
            return line.charAt(line.length() - 1) == '?' || line.charAt(line.length() - 1) == '!';
        return false;
    }
}