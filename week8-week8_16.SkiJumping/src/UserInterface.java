import java.util.*;

public class UserInterface
{
    private List<Player> players;
    
    public UserInterface()
    {
        players = new ArrayList<Player>();
    }
    
    public void start(Scanner reader)
    {
        System.out.println("Kumpula ski jumping week\n");
        System.out.println("Write the names of the participants one at a time; an empty string brings you to the jumping phase.");
        
        while(true)
        {
            System.out.print("  Participant name: ");
            String name = reader.nextLine();
            if(name.isEmpty())
                break;
            players.add(new Player(name));
        }
        
        System.out.println("\nThe tournament begins!\n");
        
        jumper(reader);
    }
    
    public void jumper(Scanner reader)
    {
        int round = 0;
        while(true)
        {
            System.out.print("Write \"jump\" to jump; otherwise you quit: ");
            String input = reader.nextLine();
            System.out.println("");
            Collections.sort(players);
            if(input.equals("jump"))
            {
                round++;
                System.out.println("Round " + round + "\n");
                System.out.println("Jumping order:");
                printPlayers();
                System.out.println("Results of round " + round);
                printResults();
            }
            else
                break;
        }
        System.out.println("Thanks!\n");
        conclusion();
        
    }
    
    public void conclusion()
    {
        Collections.reverse(players);
        System.out.println("Tournament results:");
        System.out.println("Position    Name");
        int i = 0;
        for(Player p : players)
        {
            i++;
            System.out.println(i + "           " + p.toString());
            System.out.println("            " + p.printLengths());
        }
    }
    
    public void printPlayers()
    {
        int i = 0;
        for(Player p : players)
        {
            i++;
            System.out.println("  " + i + ". " + p.toString());
        }
    }
    
    public void printResults()
    {
        for(Player p : players)
        {
            System.out.println("  " + p.getName());
            int[] judgeScores = randomizeArray();
            int[] clone = Arrays.copyOf(judgeScores, 5);
            System.out.println("    length: " + p.jump(judgeScores));
            System.out.println("    judge votes: " + Arrays.toString(clone));
        }
        System.out.println("");
    }
    
    public int[] randomizeArray()
    {
        Random random = new Random();
        int[] arr = new int[5];
        arr[0] = random.nextInt(11) + 10;
        arr[1] = random.nextInt(11) + 10;
        arr[2] = random.nextInt(11) + 10;
        arr[3] = random.nextInt(11) + 10;
        arr[4] = random.nextInt(11) + 10;
        return arr;
    }
}