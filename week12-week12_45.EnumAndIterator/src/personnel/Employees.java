package personnel;

import java.util.*;

public class Employees
{
    private List<Person> persons;
    
    public Employees()
    {
        persons = new ArrayList<Person>();
    }
    
    public void add(Person person)
    {
        if(person != null)
            persons.add(person);
    }
    
    public void add(List<Person> people)
    {
        if(!people.isEmpty())
            persons.addAll(people);
    }
    
    public void print()
    {
        Iterator<Person> iterator = persons.iterator();
        
        while(iterator.hasNext())
            System.out.println(iterator.next().toString());
    }
    
    public void print(Education education)
    {
        Iterator<Person> iterator = persons.iterator();
        
        while(iterator.hasNext())
        {
            Person person = iterator.next();
            if(person.getEducation().equals(education))
                System.out.println(person.toString());
        }
    }
    
    public void fire(Education education)
    {
        Iterator<Person> iterator = persons.iterator();
        
        while(iterator.hasNext())
            if(iterator.next().getEducation().equals(education))
                iterator.remove();
    }
}