public class Flight
{
    private Plane plane;
    private String from;
    private String to;
    
    public Flight(Plane plane, String from, String to)
    {
        this.plane = plane;
        this.from = from;
        this.to = to;
    }

    public Plane getPlane() {
        return plane;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }
    
    public String toString()
    {
        return plane.toString() + " (" + from + "-" + to + ")";
    }
}