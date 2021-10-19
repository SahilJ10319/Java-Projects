package model;

/**
 * Fokimon Class:
 * Keep Track of Tokimon on Board
 */

public class Tokimon {
    private int positionX;
    private int positionY;
    public int[] position = {0, 0};
    private boolean found = false;

    public void setPosition(int[] pair) {
        positionX = (pair[1]);
        positionY = (pair[0]);
        position[0] = positionX;
        position[1] = positionY;
    }

    public int[] getPosition() {
        int[] pos = {positionX, positionY};
        return pos;
    }

    public void found() {
        found = true;
    }

    public boolean checkFound() {
        return found;
    }
}
