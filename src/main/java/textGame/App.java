package textGame;

import java.util.Scanner;

public class App {
    public static Scene scene = new Scene(new Position(0, 0));
    public static Player player = new Player(scene);

    public static void main(String[] args) throws Exception {
        scene.setPlayer(player);
        while (true) {
            printSituation();
            playerTurn();
            npcTurn();
        }
    }
    public static void printSituation() {
        System.out.println("Location: " + player.scene + " at " + player.scene.getPosition());
        System.out.println("Encounter: " + player.scene.getNpc());
    }
    public static void playerTurn() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            input = input.toLowerCase();
            if (input.equals("help")) {
                String leftAlignFormat = "| %-15s | %-4d |%n";
                System.out.format("+---------+-----------+%n");
                System.out.format("| command |description|%n");
                System.out.format("+---------+-----------+%n");

                System.out.format("+---------+-----------+%n");
            } else if (input.startsWith("move ")) {
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
                        return;
                    }
                    else if (target.equals(player.scene.getNpc().toString())) {
                        System.out.println("You try to hit " + player.scene.getNpc() + ".");
                        player.attack(player.scene.getNpc());
                        return;
                    }
                }
            } else if (input.startsWith("wait")) {
                return;
            } else {
                System.out.println("unknown input \"" + input + "\", use \"help\" for a list of commands");
            }
        }
    }
    public static void npcTurn() {
        Npc npc = player.scene.getNpc();
        if (npc != null) {
            npc.takeTurn();
        }
    }
    public static void endGame() {
        System.out.println("You are dead, the game is over.");
        System.exit(0);
    }
}
