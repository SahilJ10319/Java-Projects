package ca.cmpt213.asn4.tictactoe.game;

import javafx.scene.image.ImageView;

/**
 * This Class manages the basic logic of the game
 * and helps establish game rules that the game will follow
 * Note: I found variations of the isWinner class on StackOverflow and utilized it
 */

public class Board {
    private final int[][] grid;
    private int turn;
    private int blocks;

    public Board() {
        grid = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                grid[i][j] = 0;
            }
        }
        blocks = 16;
        turn = 1;
    }

    public int move() {
        return turn;
    }

    public void nextMove() {
        if (turn == 1) {
            turn = 2;
        }
        else if (turn == 2) {
            turn = 1;
        }
    }

    public void clear() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                grid[i][j] = 0;
            }
        }
        turn = 1;
        blocks = 16;
    }

    public boolean isDraw() {
        return blocks == 0;
    }

    public boolean isWinner(int row, int col) {
        if (grid[row][0] == turn && grid[row][1] == turn && grid[row][2] == turn && grid[row][3] == turn) {
            return true;
        }

        else if (grid[0][col] == turn && grid[1][col] == turn && grid[2][col] == turn && grid[3][col] == turn) {
            return true;
        }

        else if (row == col && grid[0][0] == turn && grid[1][1] == turn && grid[2][2] == turn && grid[3][3] == turn) {
            return true;
        }

        else return row + col == 3 && grid[0][3] == turn && grid[1][2] == turn && grid[2][1] == turn && grid[3][0] == turn;
    }

    public boolean move(int row, int col) {
        if (!isWinner(row,col) || !isDraw()) {
            if (grid[row][col] == 0) {
                grid[row][col] = turn;
                blocks--;
                return true;
            }
        }
        return false;
    }

    public void endGame(ImageView[] image) {
        for (ImageView imageView : image) {
            imageView.setDisable(true);
        }
        turn = 1;
        blocks = 16;
    }
}
