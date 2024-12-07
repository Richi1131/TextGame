package textGame;

import java.util.Scanner;

public class App {
    public static Scene scene = new Scene(new Position(0, 0));
    public static Player player = new Player(scene);

    public static void main(String[] args) throws Exception {
        scene.setPlayer(player);
        player.inventory.addItem(new HealingItem());
        while (true) {
            playerTurn();
            for (Npc npc : player.scene.getNpcs()) {
                npcTurn(npc);
            }
        }
    }
    public static void printSituation() {
        System.out.println("Location: " + player.scene + " at " + player.scene.getPosition());
        System.out.println("Encounter: " + Utility.characterArrayToString(player.scene.getNpcs()));
    }
    public static void playerTurn() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printSituation();
            String input = scanner.nextLine();
            input = input.toLowerCase();
            if (input.startsWith("help")) {
                playerCommandHelp(input);
            } else if (input.startsWith("move ")) {
                playerCommandMove(input);
            } else if (input.startsWith("look")) {
                playerCommandLook(input);
            } else if (input.startsWith("attack ")) {
                if (playerCommandAttack(input)) return;
            } else if (input.startsWith("wait")) {
                return;
            } else if (input.startsWith("use")) {
                if (playerCommandUse(input)) return;
            } else {
                System.out.println("unknown input \"" + input + "\", use \"help\" for a list of commands");
            }
        }
    }

    private static boolean playerCommandUse(String input) {
        Item item = player.inventory.getItemByName(input.split(" ")[1]);
        if (item != null) {
            if (item instanceof UsableOnGameObject usableOnGameObject) {
                GameObject target = player.scene.getGameObjectByName(input.split(" ")[2]);
                return usableOnGameObject.useOn(target);
                // TODO: implement healing on body parts of characters
            }
        }
        return false;
    }

    private static boolean playerCommandAttack(String input) {
        if (input.matches("attack [a-z]*")) {
            String target = input.split(" ")[1];
            if (target.equals("self")) {
                System.out.println("You try to hit yourself.");
                player.attack(player);
                return true;
            }
            else if (player.scene.getNpc(target) != null) {
                System.out.println("You try to hit " + player.scene.getNpc(target) + ".");
                player.attack(player.scene.getNpc(target));
                return true;
            }
            else {
                System.out.println("Unknown target.");
            }
        }
        return false;
    }

    private static void playerCommandLook(String input) {
        System.out.println("You see " + player.scene.getDescription() + ".");
    }

    private static void playerCommandMove(String input) {
        if (input.matches("move [0-3]")) {
            player.move(input.charAt(5) - '0');
        }
    }

    private static void playerCommandHelp(String input) {
        String leftAlignFormat = "| %-15s | %-4d |%n";
        System.out.format("+---------+-----------+%n");
        System.out.format("| command |description|%n");
        System.out.format("+---------+-----------+%n");

        System.out.format("+---------+-----------+%n");
    }

    public static void npcTurn(Npc npc) {
        if (npc != null) {
            npc.takeTurn();
        }
    }
    public static void endGame() {
        System.out.println("You are dead, the game is over.");
        System.exit(0);
    }
}
