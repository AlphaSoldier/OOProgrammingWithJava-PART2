package reference.comparator;

import java.util.*;
import reference.domain.*;

public class PersonComparator implements Comparator<Person>
{
    private Map<Person, Integer> peopleIdentities;
    
    public PersonComparator(Map<Person, Integer> peopleIdentities)
    {
        this.peopleIdentities = peopleIdentities;
    }

    @Override
    public int compare(Person a, Person b) {
        return peopleIdentities.get(b) - peopleIdentities.get(a);
    }
}