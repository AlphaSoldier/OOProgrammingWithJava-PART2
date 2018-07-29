package reference.domain;

public class Film
{
    private String name;

    public Film(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    @Override
    public String toString()
    {
        return this.name;
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if(obj == null || !(obj instanceof Film))
            return false;
        Film film = (Film) obj;
        if(!film.getName().equals(this.getName()))
            return false;
        return true;
    }
    
    @Override
    public int hashCode()
    {
        return this.name.hashCode();
    }
}