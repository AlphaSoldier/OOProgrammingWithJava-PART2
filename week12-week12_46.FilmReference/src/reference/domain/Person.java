package reference.domain;

public class Person
{
    private String name;

    public Person(String name) {
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
        if(obj == null || !(obj instanceof Person))
            return false;
        Person person = (Person) obj;
        if(!person.getName().equals(this.getName()))
            return false;
        return true;
    }
    
    @Override
    public int hashCode()
    {
        return this.name.hashCode();
    }
}