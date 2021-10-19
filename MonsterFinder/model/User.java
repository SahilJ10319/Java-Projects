package model;
import java.util.ArrayList;

/**
 * User Class:
 * Used for movement on the board
 * deals with positioning of the "character"
 */
public class User {
    public ArrayList<int[]> visited = new ArrayList<>();
    public static final char userSymbol = '@';
    private int positionX;
    private int positionY;
    private int[] position = {0, 0};

    public void setPosition(int[] pair) {
        positionX = (pair[1] - 1);
        positionY = (pair[0] * 2) - 2;
        position[0] = positionX;
        position[1] = positionY;
        int[] pos = {getUserPositionY(), getUserPositionX()};
        visited.add(pos);
    }

    public void moveRight() {
        positionY += 2;
    }

    public void moveLeft() {
        positionY -= 2;
    }

    public void moveUp() {
        positionX--;
    }

    public void moveDown() {
        positionX++;
    }

    public int getUserPositionX() {
        return positionX;
    }

    public int getUserPositionY() {
        return positionY;
    }

    public void updateVisited() {
        int[] position = {getUserPositionY(), getUserPositionX()};
        visited.add(position);
    }


}
