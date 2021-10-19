package ca.cmpt213.A2;

import model.Fokimon;
import model.Spell;
import model.Tokimon;
import model.User;
import userinterface.Board;
import userinterface.Prompt;
import userinterface.SetUp;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Tokimon Finder Class:
 * Has the main function
 * This class controls the process of the whole game
 * Prompts User for Inputs
 */
public class TokimonFinder {

    public static void main(String[] args) {
        SetUp setup = new SetUp();
        boolean valid = setup.startingArgs(args);
        if (!valid) {
            System.exit(-1);
        }
        Board board = new Board();
        ArrayList<Tokimon> tokimons = new ArrayList<>();
        ArrayList<Fokimon> fokimons = new ArrayList<>();

        board.initialize();
        board.displayBoard();

        Scanner input;
        User user = new User();
        input = new Scanner(System.in);
        System.out.println("Set user where (ex. A5)");
        String position = input.nextLine();
        int[] pair = SetUp.getPosition(position);
        user.setPosition(pair);
        setup.initializeTokiFoki(user, board, tokimons, fokimons);
        board.update(user, tokimons, fokimons, setup);

        Spell spell = new Spell();
        board.displayBoard();
        if (!setup.checkCheat()) {
            while (true) {
                Prompt.userMove(user, board, spell, tokimons, fokimons);
                user.updateVisited();
                board.update(user, tokimons, fokimons, setup);
                board.displayBoard();
            }
        } else {
            while (true) {
                Prompt.userMove(user, board, spell, tokimons, fokimons);
                user.updateVisited();
                board.update(user, tokimons, fokimons, setup);
                board.endDisplay(user, tokimons, fokimons);
                board.displayBoard();
            }
        }
    }
}

