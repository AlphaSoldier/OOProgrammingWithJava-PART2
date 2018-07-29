package application;

import java.util.Random;

public class Thermometer implements Sensor
{
    private boolean on;
    
    public Thermometer()
    {
        this.on = false;
    }
    
    @Override
    public void on()
    {
        on = true;
    }
    
    @Override
    public void off()
    {
        on = false;
    }
    
    @Override
    public int measure()
    {
        if(!isOn())
            throw new IllegalStateException();
        return new Random().nextInt(61) - 30;
    }
    
    @Override
    public boolean isOn()
    {
        return this.on;
    }
}