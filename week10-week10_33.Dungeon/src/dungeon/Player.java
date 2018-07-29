package dungeon;

public class Player extends Entity
{
    private String name;
    private int xPos;
    private int yPos;
    
    
    public Player()
    {
        this.xPos = 0;
        this.yPos = 0;
        this.name = "@";
    }

    @Override
    public int getxPos() {
        return xPos;
    }

    @Override
    public int getyPos() {
        return yPos;
    }
    
    public void movePlayer(String move, int boardLength, int boardHeight, String[][] board)
    {
        board[yPos][xPos] = ".";
        for(int i = 0; i < move.length(); ++i)
        {
            switch(move.charAt(i))
            {
                case 'w':
                case 'W': yPos -= 1;
                          if(yPos < 0)
                              yPos = 0;
                          break;
                case 's':
                case 'S': yPos += 1;
                          if(yPos == boardHeight)
                              yPos = boardHeight - 1;
                          break;
                case 'a':
                case 'A': xPos -= 1;
                          if(xPos < 0)
                              xPos = 0;
                          break;
                case 'd':
                case 'D': xPos += 1;
                          if(xPos == boardLength)
                              xPos -= 1;
                          break;
            }
        }
        board[yPos][xPos] = this.name;
    }
    
    @Override
    public String toString()
    {
        return name + " " + xPos + " " + yPos;
    }
}