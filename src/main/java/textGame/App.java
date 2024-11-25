package textGame;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        Scene scene = new Scene();
        Player player = new Player(scene);

        //List<Command> commands = new ArrayList<Command>();
        //commands.add(new Command());
        while (true) {
//            if (player.location.equals("road")) {
//                System.out.println("You are on a road in the middle of nowhere.");
//                System.out.println();
//
//                printPossibleActions(scene);
//            }

            String input = scanner.nextLine();
            input = input.toLowerCase();
            if (input.equals("help")) {
                String leftAlignFormat = "| %-15s | %-4d |%n";
                System.out.format("+---------+-----------+%n");
                System.out.format("| command |description|%n");
                System.out.format("+---------+-----------+%n");

                System.out.format("+---------+-----------+%n");
            } else if (input.startsWith("move ")) {
                try {
                    player.move(input.charAt(5) - '0');
                }
                catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println(e);
                }
            } else {
                System.out.println("unknown input \"" + input + "\", use \"help\" for a list of commands");
            }
        }
    }
    public static void printPossibleActions(Scene scene) {
        System.out.println("You can:");
        for (int i = 0; i < scene.possibleActions.length; i++) {
            System.out.println(i+1+". " + scene.possibleActions[i]);
        }
    }
}
