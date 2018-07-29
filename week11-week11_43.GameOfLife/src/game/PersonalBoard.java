package game;

import gameoflife.*;
import java.util.Random;

public class PersonalBoard extends GameOfLifeBoard
{
    public PersonalBoard(int width, int height) {
        super(width, height);
    }

    @Override
    public void initiateRandomCells(double d) {
        int width = super.getWidth();
        int height = super.getHeight();
        int totalCells = width * height;
        int dToInt = (int) (d * 100);
        int aliveCells = (totalCells * dToInt) / 100;
        int x = 0;
        for(int i  = 0; i < width; ++i)
        {
            for(int j = 0; j < height; ++j)
            {
                double random = new Random().nextDouble();
                if(d == 0.0)
                    super.getBoard()[i][j] = false;
                else if(d == 1.0)
                    super.getBoard()[i][j] = true;
                else
                {
                    if(x <= aliveCells)
                    {
                        super.getBoard()[i][j] = true;
                        x++;
                    }
                }
            }
        }
    }

    @Override
    public boolean isAlive(int x, int y) {
        if(x < super.getWidth() && y < super.getHeight() && x >= 0 && y >= 0)
            return super.getBoard()[x][y];
        return false;
    }

    @Override
    public void turnToLiving(int x, int y) {
        if(x < super.getWidth() && y < super.getHeight() && x >= 0 && y >= 0)
            super.getBoard()[x][y] = true;
    }

    @Override
    public void turnToDead(int x, int y) {
        if(x < super.getWidth() && y < super.getHeight() && x >= 0 && y >= 0)
            super.getBoard()[x][y] = false;
    }

    @Override
    public int getNumberOfLivingNeighbours(int x, int y) {
        int width = super.getWidth();
        int height = super.getHeight();
        int count = 0;
        
        if(x == 0 && y == 0)
        {
            count += changeCount(super.getBoard(), x + 1, y);
            count += changeCount(super.getBoard(), x + 1, y + 1);
            count += changeCount(super.getBoard(), x, y + 1);
        }
        else if(x == width - 1 && y == 0)
        {
            count += changeCount(super.getBoard(), x - 1, y);
            count += changeCount(super.getBoard(), x - 1, y + 1);
            count += changeCount(super.getBoard(), x, y + 1);
        }
        else if(x == width - 1 && y == height - 1)
        {
            count += changeCount(super.getBoard(), x - 1, y);
            count += changeCount(super.getBoard(), x - 1, y - 1);
            count += changeCount(super.getBoard(), x, y - 1);
        }
        else if(x == 0 && y == height - 1)
        {
            count += changeCount(super.getBoard(), x, y - 1);
            count += changeCount(super.getBoard(), x + 1, y - 1);
            count += changeCount(super.getBoard(), x + 1, y);
        }
        else if(x == 0)
        {
            count += changeCount(super.getBoard(), x, y + 1);
            count += changeCount(super.getBoard(), x, y - 1);
            count += changeCount(super.getBoard(), x + 1, y);
            count += changeCount(super.getBoard(), x + 1, y - 1);
            count += changeCount(super.getBoard(), x + 1, y + 1);
        }
        else if(x == width - 1)
        {
            count += changeCount(super.getBoard(), x, y + 1);
            count += changeCount(super.getBoard(), x, y - 1);
            count += changeCount(super.getBoard(), x - 1, y);
            count += changeCount(super.getBoard(), x - 1, y - 1);
            count += changeCount(super.getBoard(), x - 1, y + 1);
        }
        else if(y == 0)
        {
            count += changeCount(super.getBoard(), x - 1, y);
            count += changeCount(super.getBoard(), x + 1, y);
            count += changeCount(super.getBoard(), x - 1, y + 1);
            count += changeCount(super.getBoard(), x, y + 1);
            count += changeCount(super.getBoard(), x + 1, y + 1);
        }
        else if(y == height - 1)
        {
            count += changeCount(super.getBoard(), x - 1, y);
            count += changeCount(super.getBoard(), x + 1, y);
            count += changeCount(super.getBoard(), x - 1, y - 1);
            count += changeCount(super.getBoard(), x, y - 1);
            count += changeCount(super.getBoard(), x + 1, y - 1);
        }
        else
        {
            count += changeCount(super.getBoard(), x - 1, y);
            count += changeCount(super.getBoard(), x + 1, y);
            count += changeCount(super.getBoard(), x - 1, y - 1);
            count += changeCount(super.getBoard(), x, y - 1);
            count += changeCount(super.getBoard(), x + 1, y - 1);
            count += changeCount(super.getBoard(), x - 1, y + 1);
            count += changeCount(super.getBoard(), x, y + 1);
            count += changeCount(super.getBoard(), x + 1, y + 1);
        }
        return count;
    }
    
    private int changeCount(boolean[][] board, int x, int y)
    {
        if(board[x][y])
            return 1;
        return 0;
    }

    @Override
    public void manageCell(int x, int y, int livingNeighbours) {
        if(livingNeighbours < 2  && super.getBoard()[x][y])
        {
            super.getBoard()[x][y] = false;
        }
        else if( (livingNeighbours == 2 || livingNeighbours == 3) && super.getBoard()[x][y])
        {
            
        }
        else if(livingNeighbours > 3 && super.getBoard()[x][y])
        {
            super.getBoard()[x][y] = false;
        }
        else if(livingNeighbours == 3 && !super.getBoard()[x][y])
        {
            super.getBoard()[x][y] = true;
        }
    }
    
}