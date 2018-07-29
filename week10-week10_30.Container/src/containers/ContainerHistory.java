package containers;

import java.util.*;

public class ContainerHistory
{
    private List<Double> history;
    
    public ContainerHistory()
    {
        history = new ArrayList<Double>();
    }
    
    public void add(double situation)
    {
        history.add(situation);
    }
    
    public void reset()
    {
        history.clear();
    }
    
    public double maxValue()
    {
        double max = history.get(0);
        if(history.isEmpty())
            return 0;
        for(Double d : history)
        {
            if(d > max)
                max = d;
        }
        return max;
    }
    
    public double minValue()
    {
        double min = history.get(0);
        if(history.isEmpty())
            return 0;
        for(Double d : history)
        {
            if(d < min)
                min = d;
        }
        return min;
    }
    
    public double average()
    {
        if(history.isEmpty())
            return 0;
        double average = 0;
        for(Double d : history)
        {
            average += d;
        }
        average /= history.size();
        return average;
    }
    
    public double greatestFluctuation()
    {
        if(history.isEmpty() || history.size() == 1)
            return 0;
        double diff, max = 0;
        for(int i = 0; i < history.size() - 1; i++)
        {
            diff = Math.abs(history.get(i + 1) - history.get(i));
            if(diff > max)
                max = diff;
        }
        return max;
    }
    
    public double variance()
    {
        if(history.isEmpty() || history.size() == 1)
            return 0;
        double variance = 0;
        double mean = this.average();
        for(Double d : history)
        {
            variance += Math.pow((d - mean),2);
        }
        variance /= history.size() - 1;
        return variance;
    }
    
    @Override
    public String toString()
    {
        return history.toString();
    }
}