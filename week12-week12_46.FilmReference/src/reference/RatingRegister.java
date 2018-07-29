package reference;

import java.util.*;
import reference.domain.*;

public class RatingRegister
{
    private Map<Film, List<Rating>> register;
    private Map<Person, Map<Film, Rating>> personalRatings;
    
    public RatingRegister()
    {
        register = new HashMap<Film, List<Rating>>();
        personalRatings = new HashMap<Person, Map<Film, Rating>>();
    }
    
    public void addRating(Film film, Rating rating)
    {
        if(register.containsKey(film))
            register.get(film).add(rating);
        else
        {
            List<Rating> ratings = new ArrayList<Rating>();
            ratings.add(rating);
            register.put(film, ratings);
        }
    }
    
    public List<Rating> getRatings(Film film)
    {
        if(register.containsKey(film))
            return register.get(film);
        return null;
    }
    
    public Map<Film, List<Rating>> filmRatings()
    {
        return register;
    }
    
    public void addRating(Person person, Film film, Rating rating)
    {
        this.addRating(film,rating);
        if(personalRatings.containsKey(person))
        {
            if(!personalRatings.get(person).containsKey(film))
            {    
                personalRatings.get(person).put(film, rating);
            }
        }
        else
        {
            Map<Film, Rating> map = new HashMap<Film, Rating>();
            map.put(film, rating);
            personalRatings.put(person, map);
        }
    }
    
    public Rating getRating(Person person, Film film)
    {
        if(personalRatings.containsKey(person))
            if(personalRatings.get(person).containsKey(film))
                return personalRatings.get(person).get(film);
        return Rating.NOT_WATCHED;
    }
    
    public Map<Film, Rating> getPersonalRatings(Person person)
    {
        Map<Film, Rating> ratings = new HashMap<Film, Rating>();
        if(personalRatings.containsKey(person))
            ratings = personalRatings.get(person);
        return ratings;
        
    }
    
    public List<Person> reviewers()
    {
        List<Person> people = new ArrayList<Person>();
        
        for(Person person : personalRatings.keySet())
        {
            people.add(person);
        }
        
        return people;
    }
}