package dungeon;

import java.util.*;

public class Dungeon
{
    private int length;
    private int height;
    private int vampires;
    private int moves;
    private boolean vampiresMove;
    private List<Entity> entities;
    private Scanner reader;

    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove) {
        this.length = length;
        this.height = height;
        this.vampires = vampires;
        this.moves = moves;
        this.vampiresMove = vampiresMove;
        entities = new ArrayList<Entity>();
        reader = new Scanner(System.in);
    }
    
    public void run()
    {
        String[][] board = new String[this.height][this.length];
        this.fillBoard(board);
        fillEntities(board);
        while(moves > 0 || vampires > 0)
        {
            System.out.println(moves + "\n");
            printEntities();
            printBoard(board);
            String move = reader.nextLine();
            movePlayerEntity(move,board);
            if(vampiresMove)
                moveVampireEntity(board);
            this.moves--;
            if(vampires == 0 || (vampires == 0 && moves == 0))
            {
                System.out.println("YOU WIN");
                break;
            }
            if(moves == 0)
            {
                System.out.println("YOU LOSE");
                break;
            }
        }
        
    }
    
    public void fillBoard(String[][] board)
    {
        for(int i = 0; i < this.height; ++i)
        {
            for(int j = 0; j < this.length; ++j)
            {
                board[i][j] = ".";
            }
        }
        board[0][0] = "@";
    }
    
    public void printBoard(String[][] board)
    {
        for(int i = 0; i < this.height; ++i)
        {
            for(int j = 0; j < this.length; ++j)
            {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println("");
    }
    
    public void fillEntities(String[][] board)
    {
        entities.add(new Player());
        int i = 0;
        while(i < vampires)
        {
            entities.add(new Vampire(length,height,board));
            i++;
        }
    }
    
    public void printEntities()
    {
        String result = "";
        for(int i = 0; i < entities.size(); ++i)
        {
            result += entities.get(i).toString();
            result += "\n";
        }
        System.out.println(result);
    }
    
    public void movePlayerEntity(String move, String[][] board)
    {
        Player player = null;
        for(Entity e : entities)
        {
            if(e instanceof Player)
            {
                player = (Player) e;
                break;
            }
        }
        if(player != null)
            player.movePlayer(move, length, height, board);
        removeVampireEntity(player.getxPos(), player.getyPos());
    }
    
    public void removeVampireEntity(int playerX, int playerY)
    {
        List<Vampire> toBeRemoved = new ArrayList<Vampire>();
        for(Entity e : entities)
        {
            if(e instanceof Vampire)
            {
                if(hasToBeRemoved((Vampire) e, playerX, playerY))
                {
                    toBeRemoved.add((Vampire) e);
                    vampires--;
                }
            }
        }
        entities.removeAll(toBeRemoved);
    }
    
    public boolean hasToBeRemoved(Vampire v, int playerX, int playerY)
    {
        return v.getxPos() == playerX && v.getyPos() == playerY;
    }
    
    public void moveVampireEntity(String[][] board)
    {
        for(Entity e : entities)
        {
            if(e instanceof Vampire)
            {
                ((Vampire) e).moveVampire(length, height, board);
            }
        }
    }
}