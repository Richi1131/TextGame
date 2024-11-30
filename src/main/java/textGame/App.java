package textGame;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        Scene scene = new Scene(new Position(0, 0));
        Player player = new Player(scene);

        while (true) {
            System.out.println("Location: " + player.scene + " at " + player.scene.getPosition());
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
            } else if (input.startsWith("look")) {
                System.out.println("You see " + player.scene.getDescription() + ".");
            }else {
                System.out.println("unknown input \"" + input + "\", use \"help\" for a list of commands");
            }
        }
    }
}
