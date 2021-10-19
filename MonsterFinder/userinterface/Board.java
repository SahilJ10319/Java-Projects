package userinterface;
import model.Fokimon;
import model.Tokimon;
import model.User;

import java.util.ArrayList;
import static model.User.userSymbol;

/**
 * Board Class:
 * Initialize, Display and Update the board under player's will
 */
public class Board {
    public char[][] board = new char[10][20];
    private int tokiCounter = 0;

    public int getTokiCounter() {
        return tokiCounter;
    }

    public void initialize() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                if (j % 2 == 0) {
                    board[i][j] = '~';
                } else {
                    board[i][j] = ' ';
                }
            }
        }
    }

    public void displayBoard() {
        char letter = 'A';
        System.out.print("   ");
        for (int i = 1; i <= 10; i++) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.print('\n');
        for (int i = 0; i < 10; i++) {
            System.out.print("|");
            System.out.print(letter);
            System.out.print(" ");
            letter++;
            for (int j = 0; j < 20; j++) {
                System.out.print(board[i][j]);
            }
            System.out.print("|");
            System.out.print("\n");
        }
    }

    public void update(User user, ArrayList<Tokimon> tokimons, ArrayList<Fokimon> fokimons, SetUp setup) {
        int x = user.getUserPositionX();
        int y = user.getUserPositionY();
        for (int[] pair : user.visited) {
            board[pair[1]][pair[0]] = ' ';
        }
        for (Tokimon tokimon : tokimons) {
            int[] pos = tokimon.getPosition();
            if (pos[1] == x && pos[0] == y + 1 && !tokimon.checkFound()) {
                System.out.println("Congratulations! You Found a Tokimon!");
                tokiCounter++;
                tokimon.found();
                board[pos[1]][pos[0]] = '$';
                if (setup.getTokiNum() == this.getTokiCounter()) {
                    System.out.println("You win ! You found all the Tokimon! ");
                    endDisplay(user, tokimons, fokimons);
                    System.exit(0);
                }
            }
        }
        for (Fokimon fokimon : fokimons) {
            int[] pos = fokimon.getPosition();
            if (pos[1] == x && pos[0] == y + 1) {
                fokimon.found();
                System.out.println("Game Over! You ran into a Fokimon :( ");
                board[pos[1]][pos[0]] = 'X';
                endDisplay(user, tokimons, fokimons);
                displayBoard();
                System.exit(0);
            }
        }
        board[x][y] = userSymbol;
    }

    public void endDisplay(User user, ArrayList<Tokimon> tokimons, ArrayList<Fokimon> fokimons) {
        int x = user.getUserPositionX();
        int y = user.getUserPositionY();
        board[x][y] = userSymbol;
        for (Tokimon tokimon : tokimons) {
            int[] pos = tokimon.getPosition();
            board[pos[1]][pos[0]] = '$';
        }
        for (Fokimon fokimon : fokimons) {
            int[] pos = fokimon.getPosition();
            board[pos[1]][pos[0]] = 'X';
        }

    }
}
