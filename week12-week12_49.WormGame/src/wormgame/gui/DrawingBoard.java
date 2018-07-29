package wormgame.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import wormgame.domain.Apple;
import wormgame.domain.Piece;
import wormgame.domain.Worm;
import wormgame.game.WormGame;

public class DrawingBoard extends JPanel implements Updatable {
    
    private WormGame game;
    private int pieceLength;
    
    public DrawingBoard(WormGame game, int pieceLength){
        this.game = game;
        this.pieceLength = pieceLength;
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        for(Piece p : game.getWorm().getPieces()){
            g.fill3DRect(pieceLength*p.getX(), pieceLength* p.getY(), pieceLength, pieceLength, true);
            
        }
        g.setColor(Color.RED);
        g.fillOval(pieceLength*game.getApple().getX(), pieceLength*game.getApple().getY(), pieceLength, pieceLength);
        
    }

    @Override
    public void update() {
        this.repaint();
    }
    
}