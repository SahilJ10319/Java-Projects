package ca.cmpt213.tokimon;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Sahil Janjua
 * @version 1.0
 */
public class Main {
    /**
     * Displays Main Function, Array List for Tokimon and The Menu
     * @name - Name of Tokimon, Must be String
     * @height - Height of Tokimon, Must be Numerical Value
     * @weight - Weight of Tokimon, Must be Numerical Value
     * @type - Must Choose One of The Types given by Professor
     */
    String name, type;
    double height, weight;
    List<Tokimon>tokimonList = new ArrayList<>();

    public void displayAllTokis() {
        System.out.println("********************");
        System.out.println("* List of Tokimons *");
        System.out.println("********************");
        for(int i = 0; i < tokimonList.size(); i++) {
            System.out.println(i + 1 + ". " + tokimonList.get(i).getName() + " " + tokimonList.get(i).getHeight() + " m " +
            tokimonList.get(i).getWeight() + " lbs " + tokimonList.get(i).getType() + " ability " +
                    tokimonList.get(i).getStrength() + " strength \n");
        }
    }

    public void addNewToki() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Tokimon's Name: ");
        name = input.nextLine();
        System.out.println("Enter Tokimon's Type: ");
        type = input.nextLine();
        System.out.println("Enter Tokimon's Height: ");
        height = input.nextDouble();
        input.nextLine();
        System.out.println("Enter Tokimon's Weight: ");
        weight = input.nextDouble();
        input.nextLine();
        System.out.println("Tokimon Added");
        Tokimon finder = new Tokimon(name, type, height, weight);
        tokimonList.add(finder);
    }

    public void deleteToki() {
        displayAllTokis();
        Scanner input = new Scanner(System.in);
        System.out.println("Choose the Tokimon you would like to remove or Enter 0 to cancel: ");
        System.out.print("> ");
        int user_choice = input.nextInt();
        input.nextLine();
        while(user_choice < 0 || user_choice > tokimonList.size()) {
            System.out.println("Please enter Valid Input: ");
            user_choice = input.nextInt();
            input.nextLine();
        }
        if(user_choice == 0) {
            displayMenu();
        }
        tokimonList.remove(user_choice - 1);
        System.out.println("Tokimon " + user_choice + " has been removed \n");
    }

    public void alterToki() {
        displayAllTokis();
        Scanner input = new Scanner(System.in);
        System.out.println("Choose the Tokimon you would like to Alter or Enter 0 to cancel");
        System.out.print("> ");
        int user_choice = input.nextInt();
        input.nextLine();
        while(user_choice < 0 || user_choice > tokimonList.size()) {
            System.out.println("Please Enter a Valid Input");
            user_choice = input.nextInt();
            input.nextLine();
        }
        if(user_choice == 0) {
            displayMenu();
        }
        System.out.println("By How Much: ");
        System.out.print("> ");
        int new_strength = input.nextInt();
        input.nextLine();
        Tokimon toki = tokimonList.get(user_choice-1);
        // toki.strength = toki.strength + new_strength;
        while(toki.strength + new_strength < 0 || toki.strength + new_strength > 100) {
            System.out.println("Please Re-enter Strength Change, Strength must lie between 0 and 100");
            System.out.print("> ");
            new_strength = input.nextInt();
            input.nextLine();
        }
        toki.strength = toki.strength + new_strength;
        System.out.println(toki.getName() + "now has strength " + toki.strength);
        displayMenu();
    }

    public void exit() {
        System.out.println("GOODBYE!");
        System.exit(0);
    }

    public void displayMenu() {
        System.out.println("**********************************************");
        System.out.println("* Tokimon Tracker by Sahil Janjua sn 301358823");
        System.out.println("**********************************************");
        System.out.print("\n");
        System.out.println("*************");
        System.out.println("* Main Menu *");
        System.out.println("*************");
        System.out.println("1. List Tokimons");
        System.out.println("2. Add a new Tokimon");
        System.out.println("3. Remove a Tokimon");
        System.out.println("4. Change Tokimon strength");
        System.out.println("5. DEBUG: Dump objects (toString)");
        System.out.println("6. Exit");
        usersChoice();
    }

    public void usersChoice() {
        Scanner input = new Scanner(System.in);
        System.out.print("> ");
        int user_choice = input.nextInt();
        input.nextLine();
        while(user_choice < 1 || user_choice >6) {
            System.out.println("Please Enter a Valid Input");
            System.out.print("> ");
            user_choice = input.nextInt();
            input.nextLine();
        }
        if(user_choice == 1) {
            displayAllTokis();
            displayMenu();
        }
        else if(user_choice == 2) {
            addNewToki();
            displayMenu();
        }
        else if(user_choice == 3) {
            deleteToki();
            displayMenu();
        }
        else if(user_choice == 4) {
            alterToki();
        }
        else if(user_choice == 5) {
            for (Tokimon tokimon : tokimonList) {
                System.out.println(tokimon);
            }
            displayMenu();
        }
        else {
            exit();
        }
    }

    public static void main(String[] args) {
        Main game = new Main();
        game.displayMenu();
    }
}
