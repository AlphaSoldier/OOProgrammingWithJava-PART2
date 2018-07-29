package wormgame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import wormgame.Direction;
import wormgame.domain.Apple;
import wormgame.domain.Worm;
import wormgame.gui.Updatable;

public class WormGame extends Timer implements ActionListener {

    private int width;
    private int height;
    private boolean continues;
    private Updatable updatable;
    private Worm worm;
    private Apple apple;
    private Random random;

    public WormGame(int width, int height) {
        super(1000, null);
        random = new Random();
        this.width = width;
        this.height = height;
        this.continues = true;
        this.worm = new Worm(width/2, height/2, Direction.DOWN);
        while(true){
            this.apple = new Apple(random.nextInt(width), random.nextInt(height));
            if(!worm.runsInto(apple)){
                break;
            }
        }
        
        
        addActionListener(this);
        setInitialDelay(2000);

    }
    
    public Worm getWorm(){
        return this.worm;
    }
    
    public void setWorm(Worm worm){
        this.worm = worm;
    }
    
    public Apple getApple(){
        return this.apple;
    }
    
    public void setApple(Apple apple){
        this.apple = apple;
    }

    public boolean continues() {
        return continues;
    }

    public void setUpdatable(Updatable updatable) {
        this.updatable = updatable;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (!continues) {
            return;
        }
        this.worm.move();
        if(this.worm.runsInto(apple)){
            this.worm.grow();
            eatApple();  
            }
        else if(this.worm.runsIntoItself()){
            continues = false;
        }
        
        else if(this.runsIntoBoard()){
            continues = false;
            
        }
        this.updatable.update();
        setDelay(1000/worm.getLength());    

    }
    private void eatApple(){
        while(true){
            apple = new Apple(random.nextInt(width), random.nextInt(height));
            if(!worm.runsInto(apple)){
                break;
            }
        }
    }
    
    private boolean runsIntoBoard(){
        int x = worm.getX();
        int y = worm.getY();
        if(x<0 || y < 0 || x >= width || y >= height){
            return true;
        }
        return false;
    }

}