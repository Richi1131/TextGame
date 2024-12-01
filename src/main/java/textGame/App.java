package textGame;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        Scene scene = new Scene(new Position(0, 0));
        Player player = new Player(scene);

        while (true) {
            System.out.println("Location: " + player.scene + " at " + player.scene.getPosition());
            System.out.println("Encounter: " + player.scene.getNpc());
            String input = scanner.nextLine();
            input = input.toLowerCase();
            if (input.equals("help")) {
                String leftAlignFormat = "| %-15s | %-4d |%n";
                System.out.format("+---------+-----------+%n");
                System.out.format("| command |description|%n");
                System.out.format("+---------+-----------+%n");

                System.out.format("+---------+-----------+%n");
            } else if (input.equals("move ")) {
                if (input.matches("move [0-3]")) {
                    player.move(input.charAt(5) - '0');
                }
            } else if (input.startsWith("look")) {
                System.out.println("You see " + player.scene.getDescription() + ".");
            } else if (input.startsWith("attack ")) {
                if (input.matches("attack [a-z]*")) {
                    String target = input.split(" ")[1];
                    if (target.equals("self")) {
                        System.out.println("You try to hit yourself.");
                        player.attack(player);
                    }
                    else if (target.equals(player.scene.getNpc().toString())) {
                        System.out.println("You try to hit " + player.scene.getNpc() + ".");
                        player.attack(player.scene.getNpc());
                    }
                }
            }else {
                System.out.println("unknown input \"" + input + "\", use \"help\" for a list of commands");
            }
        }
    }
    public static void endGame() {
        System.out.println("You are dead, the game is over.");
        System.exit(0);
    }
}
