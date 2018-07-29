package farmsimulator;

import java.util.Random;

public class Cow implements Alive, Milkable
{
    private static final String[] NAMES = new String[]{
        "Anu", "Arpa", "Essi", "Heluna", "Hely",
        "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
        "Jaana", "Jami", "Jatta", "Laku", "Liekki",
        "Mainikki", "Mella", "Mimmi", "Naatti",
        "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
        "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};
    
    private String name;
    private double capacity;
    private double amount;
    
    public Cow()
    {
        this(NAMES[new Random().nextInt(NAMES.length)]);
    }
    
    public Cow(String name)
    {
        this.name = name;
        this.capacity = 15 + new Random().nextInt(26);
        this.amount = 0;
    }

    public String getName() {
        return name;
    }

    public double getCapacity() {
        return capacity;
    }

    public double getAmount() {
        return amount;
    }
    
    @Override
    public String toString()
    {
        return name + " " + Math.ceil(amount) + "/" + Math.ceil(capacity);
    }

    @Override
    public void liveHour()
    {
        amount += (new Random().nextInt(131) + 70) / 100.0;
        if(amount > capacity)
            amount = capacity;
    }

    @Override
    public double milk()
    {
        double everything = amount;
        amount = 0;
        return everything;
    }
}