import java.util.*;

public class RingingCentre
{
    private Map<Bird, List<String>> birds;
    
    public RingingCentre()
    {
        birds = new HashMap<Bird, List<String>>();
    }
    
    public void observe(Bird bird, String place)
    {
        if(birds.containsKey(bird))
        {
            List<String> places = birds.get(bird);
            places.add(place);
            birds.replace(bird, places);
        }
        else
        {
            List<String> places = new ArrayList<String>();
            places.add(place);
            birds.put(bird, places);
        }
    }
    
    public void observations(Bird bird)
    {
        int observations;
        if(!birds.containsKey(bird))
            System.out.println(bird.toString() + " observations: 0");
        else
        {
            observations = birds.get(bird).size();
            System.out.println(bird.toString() + " observations: " + observations);
            for(String place : birds.get(bird))
            {
                System.out.println(place);
            }
        }
    }
}