
public class Bird {

    private String name;
    private String latinName;
    private int ringingYear;

    public Bird(String name, String latinName, int ringingYear) {
        this.name = name;
        this.latinName = latinName;
        this.ringingYear = ringingYear;
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if(obj == null || this.getClass() != obj.getClass())
            return false;
        Bird bird = (Bird) obj;
        if(!bird.latinName.equals(this.latinName) || bird.ringingYear != this.ringingYear)
            return false;
        return true;
    }
    
    @Override
    public int hashCode()
    {
        return latinName.hashCode();
    }

    @Override
    public String toString() {
        return this.latinName + " (" + this.ringingYear + ")";
    }
}


