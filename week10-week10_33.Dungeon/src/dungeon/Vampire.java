package dungeon;

import java.util.Random;

public class Vampire extends Entity
{
    private String name;
    private int xPos;
    private int yPos;
    
    public Vampire(int boardLength, int boardHeight, String[][] board)
    {
        this.name = "v";
        while(true)
        {
            this.xPos = new Random().nextInt(boardLength);
            this.yPos = new Random().nextInt(boardHeight);
            if(board[this.yPos][this.xPos].equals("."))
                break;
        }
        board[this.yPos][this.xPos] = this.name;
    }
    
    public void moveVampire(int boardLength, int boardHeight, String[][] board)
    {
        board[this.yPos][this.xPos] = ".";
        while(true)
        {
            xPos = new Random().nextInt(boardLength);
            yPos = new Random().nextInt(boardHeight);
            if(board[this.yPos][this.xPos].equals("."))
                break;
        }
        board[this.yPos][this.xPos] = this.name;
    }

    @Override
    public int getxPos() {
        return xPos;
    }

    @Override
    public int getyPos() {
        return yPos;
    }
    
    @Override
    public String toString()
    {
        return name + " " + xPos + " " + yPos;
    }
}