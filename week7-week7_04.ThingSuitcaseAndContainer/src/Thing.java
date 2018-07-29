public class Thing
{
    private String name;
    private int weight;

    public Thing(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public String toString() {
        return name + " (" + weight + " kg)";
    }
}