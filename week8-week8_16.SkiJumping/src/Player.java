import java.util.*;

public class Player implements Comparable<Player>
{
    private String name;
    private List<Integer> jumps;
    private List<Integer> points;

    public Player(String name) {
        this.name = name;
        jumps = new ArrayList<Integer>();
        points = new ArrayList<Integer>();
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        int total = 0;
        for(int i : points)
        {
            total += i;
        }
        return total;
    }
    
    public String printLengths()
    {
        String result = "";
        result += "jump lengths: ";
        int x = 0;
        for(int i : jumps)
        {
            x++;
            String comma = ",";
            if(x == jumps.size())
                comma = "";
            result += i + " m" + comma;
        }
        return result;
    }
    
    public int jump(int[] randoms)
    {
        Random random = new Random();
        int length = random.nextInt(61) + 60;
        jumps.add(length);
        Arrays.sort(randoms);
        int total = length + randoms[1] + randoms[2] + randoms[3];
        points.add(total);
        return length;
    }

    @Override
    public String toString() {
        return name + " (" + getPoints() + " points)";
    }
    
    @Override
    public int compareTo(Player p)
    {
        return this.getPoints() - p.getPoints();
    }
}