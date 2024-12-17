package textGame;

import java.util.Scanner;

public class App {
    public static Scene scene = new Scene(new Position(0, 0));
    public static Player player = new Player(scene);

    public static void main(String[] args) throws Exception {
        scene.setPlayer(player);
        player.getInventory().addItem(HealingItem.generateFromCSV(1));
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
                playerCommandHelp(input.split(" "));
            } else if (input.startsWith("move ")) {
                playerCommandMove(input.split(" "));
            } else if (input.startsWith("look")) {
                playerCommandLook(input.split(" "));
            } else if (input.startsWith("attack ")) {
                if (playerCommandAttack(input.split(" ")))
                    return;
            } else if (input.startsWith("wait")) {
                return;
            } else if (input.startsWith("use")) {
                if (playerCommandUse(input.split(" "))) return;
            } else if (input.startsWith("search")) {
                playerCommandSearch(input.split(" "));
            } else if (input.startsWith("loot")) {
                playerCommandLoot(input.split(" "));
            } else if (input.startsWith("inventory")) {
                playerCommandInventory(input.split(" "));
            } else {
                System.out.println("unknown input \"" + input + "\", use \"help\" for a list of commands");
            }
        }
    }

    private static void playerCommandInventory(String[] args) {
        System.out.println(player.getInventory());
    }

    private static void playerCommandLoot(String[] args) {
        if (args.length == 1) {
            System.out.println("Argument too short");
            System.out.println("loot <target_item> <target_container>");
            return;
        }
        if (args.length == 3) {
            // TODO: bug if player inventory is full item gets removed from scene, but not added to player
            if (args[2].equals("scene")) {
                player.loot(player.scene, args[1]);
            }
            else {
                GameObject target = player.scene.getGameObjectByName(args[2]);
                if (target instanceof Lootable lootable) {
                    player.loot(lootable, args[1]);
                }
                else {
                    System.out.println(target + " is not lootable.");
                }
            }
            return;
        }
    }

    private static void playerCommandSearch(String[] args) {
        if (args.length >= 2) {
            if (args[1].equals("scene")) {
                player.scene.search();
            }
            else {
                GameObject target = player.scene.getGameObjectByName(args[1]);
                if (target instanceof Searchable searchable) {
                    searchable.search();
                }
                else {
                    System.out.println(target + " is not searchable.");
                }
            }
        }
    }

    private static boolean playerCommandUse(String[] args) {
        // TODO: refactor
        // BUG: currently entries are being separated by spaces, but some names contain spaces such as 'right leg'
        if (args.length == 1 ) {
            System.out.println("Argument too short");
            System.out.println("use <item> <?target> <?subtarget>");
            return false;
        }
        if (args.length == 2) {
            // TODO: items usable without target
            return false;
        }
        if (args.length == 3) {
            Item item = player.getInventory().getItemByName(args[1]);
            if (item instanceof UsableOnGameObject usableOnGameObject) {
                GameObject target = player.scene.getGameObjectByName(args[2]);
                return usableOnGameObject.useOn(target);
            }
            else {
                System.out.println(args[1] + " is not usable.");
            }
        }
        if (args.length == 4) {
            Item item = player.getInventory().getItemByName(args[1]);
            if (item instanceof UsableOnGameObject usableOnGameObject) {
                GameObject target = player.scene.getGameObjectByName(args[2]);
                if (target instanceof  Character targetCharacter) {
                    if (targetCharacter.body.getBodyPartByName(args[3]) != null) {
                        target = targetCharacter.body.getBodyPartByName(args[3]);
                        return usableOnGameObject.useOn(target);
                    }
                    else {
                        System.out.println(args[3] + " is not a BodyPart of " + targetCharacter.body);
                        return false;
                    }
                } else {
                    System.out.println(args[3] + "has no subtargets.");
                    return false;
                }
            }
        }
        return false;
    }

    private static boolean playerCommandAttack(String[] args) {
        if (args.length == 2) {
            String target = args[1];
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

    private static void playerCommandLook(String[] args) {
        System.out.println("You see " + player.scene.getDescription() + ".");
    }

    private static void playerCommandMove(String[] args) {
        if (args.length == 2){
            player.move(args[1].charAt(0) - '0');
        }
    }

    private static void playerCommandHelp(String[] args) {
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
