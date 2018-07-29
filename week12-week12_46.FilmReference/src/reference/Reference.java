package reference;

import java.util.*;
import reference.domain.*;
import reference.comparator.*;

public class Reference
{
    private RatingRegister ratingRegister;

    public Reference(RatingRegister ratingRegister) {
        this.ratingRegister = ratingRegister;
    }
    
    public Film recommendFilm(Person person)
    {
        if(ratingRegister.getPersonalRatings(person).isEmpty())
            return filmForNewPerson();
        
        List<Person> people = ratingRegister.reviewers();
        people = removePersonFromTheList(people, person);
        int similarityFirst, similaritySecond;
        Person mostSimilarPerson = null;
        for(int i = 1; i < people.size(); ++i)
        {
            similarityFirst = similarity(person, people.get(i - 1));
            similaritySecond = similarity(person, people.get(i));
            if(similarityFirst > similaritySecond)
                mostSimilarPerson = people.get(i - 1);
            else
                mostSimilarPerson = people.get(i);
        }
        return getMovie(person, mostSimilarPerson);
    }
    
    private int similarity(Person a, Person b)
    {
        int similarity = 0;
        List<Film> films = new ArrayList<Film>();
        for(Film f : ratingRegister.filmRatings().keySet())
            if(!films.contains(f))
                films.add(f);
        for(Film f : films)
            similarity += ratingRegister.getRating(a, f).getValue() * ratingRegister.getRating(b, f).getValue();
        return similarity;
    }
    
    private Film filmForNewPerson()
    {
        List<Film> films = new ArrayList<Film>();
        for(Film f : ratingRegister.filmRatings().keySet())
            if(!films.contains(f))
                films.add(f);
        Collections.sort(films, new FilmComparator(ratingRegister.filmRatings()));
        return films.get(0);
    }
    
    private List<Person> removePersonFromTheList(List<Person> people, Person person)
    {
        Iterator<Person> iterator = people.iterator();
        while(iterator.hasNext())
            if(iterator.next() == person)
                iterator.remove();
        return people;
    }
    
    private Film getMovie(Person person, Person mostSimilarPerson)
    {
        List<Film> canBeRecommended = new ArrayList<Film>();
        Set<Rating> avoid = new HashSet<Rating>();
        avoid.add(Rating.BAD);
        avoid.add(Rating.MEDIOCRE);
        avoid.add(Rating.NEUTRAL);
        for(Film f : ratingRegister.getPersonalRatings(mostSimilarPerson).keySet())
            if(!ratingRegister.getPersonalRatings(person).containsKey(f) && !avoid.contains(ratingRegister.getRating(mostSimilarPerson,f)))
                canBeRecommended.add(f);
        if(!canBeRecommended.isEmpty())
        {
            Collections.sort(canBeRecommended, new FilmComparator(ratingRegister.filmRatings()));
            return canBeRecommended.get(0);
        }
        return null;
    }
}