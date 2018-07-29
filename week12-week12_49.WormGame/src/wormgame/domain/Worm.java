package wormgame.domain;

import java.util.List;
import java.util.ArrayList;
import wormgame.Direction;

public class Worm {
    private int x;
    private int y;
    private Direction direction;
    private List<Piece> pieces;
    private int length;
    private boolean growth = false;

    public Worm(int originalX, int originalY, Direction originalDirection) {
        this.x = originalX;
        this.y = originalY;
        this.direction = originalDirection;
        this.pieces = new ArrayList<Piece>();
        this.pieces.add(new Piece(x, y));
        this.length = 1;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public List<Piece> getPieces() {
        return this.pieces;
    }

    public int getLength() {
        length = pieces.size();
        return length;
    }

    public void move() {
        if (direction == Direction.UP) {
            y--;
            pieces.add(new Piece(x, y));
            removeOldPiece();
        } else if (direction == Direction.DOWN) {
            y++;
            pieces.add(new Piece(x, y));
            removeOldPiece();
        } else if (direction == Direction.LEFT) {
            x--;
            pieces.add(new Piece(x, y));
            removeOldPiece();
        } else if (direction == Direction.RIGHT) {
            x++;
            pieces.add(new Piece(x, y));
            removeOldPiece();
        }
        growth = false;
    }

    public void grow() {
        growth = true;
    }

    private void removeOldPiece() {
        length = pieces.size();
        if (length > 3 && !growth) {
            pieces.remove(0);
        }
    }

    public boolean runsInto(Piece piece) {
        for (Piece p : pieces) {
            if (p != piece) {
                if (p.runsInto(piece)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean runsIntoItself() {
        for (Piece p : pieces) {
            if (this.runsInto(p)) {
                return true;
            }
        }
        return false;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
}