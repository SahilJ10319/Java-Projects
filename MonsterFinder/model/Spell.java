package model;
import userinterface.Board;
import userinterface.SetUp;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Spell Class:
 * Code for the spells for players
 * findToki: Find the Tokimon on the board when covered
 * jump: Jump to location on the board
 * removeFoki: remove "Foki" from Board
 * Max 3 spells
 */
public class Spell {
    private int spellCounter = 3;

    public int getSpellCounter() {
        return this.spellCounter;
    }

    public void jump(User user, Board board) {
        Scanner input;
        input = new Scanner(System.in);
        System.out.println("Jump to where? (ex. A5)");
        String position = input.nextLine();
        int[] pair = SetUp.getPosition(position);
        user.setPosition(pair);
        spellCounter--;
    }

    public void removeFoki(ArrayList<Fokimon> fokimons, Board b) {
        if (fokimons.size() >= 1) {
            Random randomGenerator = new Random();
            int max = fokimons.size();
            int random = randomGenerator.nextInt(max);
            Fokimon fok = fokimons.get(random);
            int[] pos = fok.getPosition();
            b.board[pos[1]][pos[0]] = 'X';
            fokimons.remove(random);
            spellCounter--;
        } else {
            System.out.println("There are no fokimons left!");
        }
    }

    public void findToki(ArrayList<Tokimon> tokimons, Board b) {
        Random randomGenerator = new Random();
        int max = tokimons.size();
        int random = randomGenerator.nextInt(max);
        Tokimon fok = tokimons.get(random);
        int[] pos = fok.getPosition();
        b.board[pos[1]][pos[0]] = '$';
        spellCounter--;
    }
}
