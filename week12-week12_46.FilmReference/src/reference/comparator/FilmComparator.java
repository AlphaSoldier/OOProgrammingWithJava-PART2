package reference.comparator;

import java.util.*;
import reference.domain.*;

public class FilmComparator implements Comparator<Film>
{
    private Map<Film, List<Rating>> ratings;

    public FilmComparator(Map<Film, List<Rating>> ratings) {
        this.ratings = ratings;
    }
    
    public int getAverage(Film film)
    {
        List<Rating> rating = ratings.get(film);
        int average = 0;
        for(Rating r : rating)
        {
            average += r.getValue();
        }
        average /= rating.size();
        return average;
    }

    @Override
    public int compare(Film a, Film b) {
        return getAverage(b) - getAverage(a);
    }
    
}