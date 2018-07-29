package boxes;

public class Thing {

    private String name;
    private int weight;

    public Thing(String name, int weight) {

        this.name = name;
        if(weight >= 0)
            this.weight = weight;
        else
            throw new IllegalArgumentException("Weight cannot be negative");
    }

    public Thing(String name) {
        this(name, 0);
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj == null || !(obj instanceof Thing))
        {
            return false;
        }
        Thing thing = (Thing) obj;
        if(!thing.getName().equals(this.getName()))
            return false;
        return true;
    }
    
    @Override
    public int hashCode()
    {
        return this.getName().hashCode();
    }
}
