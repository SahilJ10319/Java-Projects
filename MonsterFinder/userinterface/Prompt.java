package userinterface;

import model.Fokimon;
import model.Spell;
import model.Tokimon;
import model.User;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Prompt Class:
 * Ask and Validate user input
 */

public class Prompt {
    public static void userMove(User user, Board board, Spell spell, ArrayList<Tokimon> tokimons, ArrayList<Fokimon> fokimons) {
        System.out.println("You have found " + board.getTokiCounter() + " tokimon(s) so far");
        System.out.println("Choose S for Spell any other key for move");
        Scanner input;
        input = new Scanner(System.in);
        String choice = input.next().toLowerCase();
        if (choice.equals("s")) {
            if (spell.getSpellCounter() == 0) {
                System.out.println("You are out of spells!");
                userMove(user, board, spell, tokimons, fokimons);
                return;
            }
            System.out.println("Choose a spell: J for Jump, F to remove a Fokimon, T to reveal a Tokimon");
            String spellChoice = input.next().toLowerCase();
            if (spellChoice.equals("j")) {
                spell.jump(user, board);
            } else if (spellChoice.equals("f")) {
                spell.removeFoki(fokimons, board);
            } else if (spellChoice.equals("t")) {
                spell.findToki(tokimons, board);
            } else {
                System.out.println("That is not a valid option");
                userMove(user, board, spell, tokimons, fokimons);
            }
        } else {
            getDirection(user);
        }
    }

    public static void getDirection(User user) {
        System.out.println("Choose a direction (W for up, S for down, A for left, D for right");
        Scanner input;
        input = new Scanner(System.in);
        String direction = input.next().toLowerCase();

        if (direction.equals("w")) {
            if (user.getUserPositionX() == 0) {
                System.out.println("You cannot move up");
                return;
            }
            user.moveUp();
        } else if (direction.equals("s")) {
            if (user.getUserPositionX() == 9) {
                System.out.println("You cannot move down");
                return;
            }
            user.moveDown();
        } else if (direction.equals("a")) {
            if (user.getUserPositionY() == 0) {
                System.out.println("You cannot move left");
                return;
            }
            user.moveLeft();
        } else if (direction.equals("d")) {
            if (user.getUserPositionY() == 18) {
                System.out.println("You cannot move right");
                return;
            }
            user.moveRight();
        } else {
            System.out.println("not a valid direction");
            getDirection(user);
        }
    }
}
