package userinterface;

import model.Fokimon;
import model.Tokimon;
import model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static java.lang.Character.toLowerCase;

/**
 * Initialize board with Tokimon, Fokimon and keeps track of arguments to main
 */
public class SetUp {
    private int TokiNum = 10;

    public int getTokiNum() {
        return TokiNum;
    }

    private int FokiNum = 5;

    private boolean cheat;

    public boolean checkCheat() {
        return cheat;
    }

    public boolean startingArgs(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].substring(0, 7).equals("--cheat")) {
                cheat = true;
            } else if (args[i].substring(0, 10).equals("--numToki=")) {
                int toki = Integer.parseInt(args[i].substring(10));
                TokiNum = toki;
            } else if (args[i].substring(0, 10).equals("--numFoki=")) {
                int foki = Integer.parseInt(args[i].substring(10));
                FokiNum = foki;
            } else {
                System.out.println("Not valid starting arguments");
                return false;
            }
        }
        if (TokiNum + FokiNum >= 99) {
            System.out.println("Not a valid number of Tokimons and Fokimons");
            return false;
        }
        if (TokiNum < 5 || FokiNum < 5){
            System.out.println("Not a valid number of Tokimons and Fokimons");
            return false;
        }
        return true;
    }

    public void initializeTokiFoki(User user, Board b, ArrayList<Tokimon> tokimons, ArrayList<Fokimon> fokimons) {
        Random randomGenerator = new Random();
        int xMax = 9;
        int yMax = 19;
        for (int i = 0; i < TokiNum; i++) {
            int[] pair = {(randomGenerator.nextInt(xMax) + 1), (randomGenerator.nextInt(yMax) + 1)};
            if (b.board[pair[0]][pair[1]] == ' ' && (pair[1] != user.getUserPositionX() && pair[0] != user.getUserPositionY() + 1)) {
                Tokimon tok = new Tokimon();
                tok.setPosition(pair);
                tokimons.add(tok);
                b.board[pair[0]][pair[1]] = '$';
            } else {
                i--;
            }
        }
        for (int i = 0; i < FokiNum; i++) {
            int[] pair = {(randomGenerator.nextInt(xMax) + 1), (randomGenerator.nextInt(yMax ) + 1)};
            if (b.board[pair[0]][pair[1]] == ' ' && (pair[1] != user.getUserPositionX() && pair[0] != user.getUserPositionY() + 1)) {
                Fokimon fok = new Fokimon();
                fok.setPosition(pair);
                fokimons.add(fok);
                b.board[pair[0]][pair[1]] = 'X';
            } else {
                i--;
            }
        }
        if (cheat == false) {
            for (Tokimon t : tokimons) {
                int[] pair = t.getPosition();
                b.board[pair[1]][pair[0]] = ' ';
            }
            for (Fokimon f : fokimons) {
                int[] pair = f.getPosition();
                b.board[pair[1]][pair[0]] = ' ';
            }
        }
    }
    public static int[] getPosition(String pos) {
        char posY = toLowerCase(pos.charAt(0));
        String stringX = pos.substring(1);
        int posX = Integer.parseInt(stringX);
        final Map<Character, Integer> map;

        map = new HashMap<>();
        map.put('a', 1);
        map.put('b', 2);
        map.put('c', 3);
        map.put('d', 4);
        map.put('e', 5);
        map.put('f', 6);
        map.put('g', 7);
        map.put('h', 8);
        map.put('i', 9);
        map.put('j', 10);

        Integer y = map.get(posY);
        int[] pair = new int[2];
        pair[0] = posX;
        pair[1] = y;
        return pair;
    }
}
