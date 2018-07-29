package application;

import java.util.*;

public class AverageSensor implements Sensor
{
    private List<Sensor> sensors;
    private List<Integer> readings;
    
    public AverageSensor()
    {
        sensors = new ArrayList<Sensor>();
        readings = new ArrayList<Integer>();
    }
    
    public void addSensor(Sensor sensor)
    {
        sensors.add(sensor);
    }
    
    public List<Integer> readings()
    {
        return readings;
    }
    
    @Override
    public boolean isOn()
    {
        boolean allSensorsOn = false;
        for(Sensor sensor : sensors)
        {
            allSensorsOn = sensor.isOn();
        }
        return allSensorsOn;
    }
    
    @Override
    public void on()
    {
        for(Sensor sensor : sensors)
            sensor.on();
    }
    
    @Override
    public void off()
    {
        for(Sensor sensor : sensors)
            sensor.off();
    }
    
    @Override
    public int measure()
    {
        if(!this.isOn() || sensors.isEmpty())
            throw new IllegalStateException();
        int average = 0;
        for(Sensor sensor : sensors)
        {
            average += sensor.measure();
        }
        average /= sensors.size();
        readings.add(average);
        return average;
    }
}