package textGame;

import java.util.Scanner;

public class App {
    public static Scene originScene = Scene.newRandomScene(new Position(0, 0));
    public static Player player = new Player(originScene);

    public static void main(String[] args) throws Exception {
        originScene.setPlayer(player);
        player.getInventory().addItem(FactoryManager.generateRandomLoot());
        while (true) {
            playerTurn();
            for (Npc npc : player.getScene().getNpcs()) {
                npcTurn(npc);
            }
        }
    }
    public static void printSituation() {
        System.out.println("Location: " + player.getScene() + " at " + player.getScene().getPosition());
        System.out.println("Encounter: " + Utility.characterArrayToString(player.getScene().getNpcs()));
    }
    public static void playerTurn() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printSituation();
            String input = scanner.nextLine();
            input = input.toLowerCase();
            if (evaluatePlayerInput(input)) return;

        }
    }

    private static boolean evaluatePlayerInput(String input) {
        if (input.startsWith("help")) {
            playerCommandHelp(input.split(" "));
        } else if (input.startsWith("move ")) {
            playerCommandMove(input.split(" "));
        } else if (input.startsWith("look")) {
            playerCommandLook(input.split(" "));
        } else if (input.startsWith("attack ")) {
            if (playerCommandAttack(input.split(" ")))
                return true;
        } else if (input.startsWith("wait")) {
            return true;
        } else if (input.startsWith("use")) {
            if (playerCommandUse(input.split(" "))) return true;
        } else if (input.startsWith("search")) {
            playerCommandSearch(input.split(" "));
        } else if (input.startsWith("loot")) {
            playerCommandLoot(input.split(" "));
        } else if (input.startsWith("inventory")) {
            playerCommandInventory(input.split(" "));
        } else if (input.startsWith("inspect")) {
            playerCommandInspect(input.split(" "));
        } else if (input.startsWith("discard")) {
            playerCommandDiscard(input.split(" "));
        } else {
            System.out.println("unknown command \"" + input + "\", use \"help\" for a list of valid commands");
        }
        return false;
    }

    private static void playerCommandDiscard(String[] args) {
        if (args.length != 2) {
            System.out.println("Argument has the wrong length.");
            System.out.println("discard <target_item>");
        }
        Item item = player.getInventory().getItemByName(args[1]);
        if (item != null) {
            System.out.println("Discarded " + item + ".");
            player.getInventory().removeItem(item);
        }
    }

    private static void playerCommandInspect(String[] args) {
        if (args.length == 3) {
            GameObject target = null;
            if (args[2].equals("inventory")) {
                target = player.getInventory().getItemByName(args[1]);
            }
            else if (args[2].equals("scene")) {
                target = player.getScene().getGameObjectByName(args[1]);
            }
            if (target instanceof Inspectable inspectable) {
                inspectable.inspect();
            }
            else {
                System.out.println(target + " is not inspectable.");
            }
        }
        else {
            System.out.println("Argument has the wrong length.");
            System.out.println("inspect <target_item> <target_container>");
        }
    }

    private static void playerCommandInventory(String[] args) {
        System.out.println(player.getInventory());
    }

    private static void playerCommandLoot(String[] args) {
        if (args.length == 3) {
            if (args[2].equals("scene")) {
                player.loot(player.getScene(), args[1]);
            }
            else {
                GameObject target = player.getScene().getGameObjectByName(args[2]);
                if (target instanceof Lootable lootable) {
                    player.loot(lootable, args[1]);
                }
                else {
                    System.out.println(target + " is not lootable.");
                }
            }
        }
        else {
            System.out.println("Argument has the wrong length.");
            System.out.println("loot <target_item> <target_container>");
        }
    }

    private static void playerCommandSearch(String[] args) {
        if (args.length >= 2) {
            if (args[1].equals("scene")) {
                player.getScene().search();
            }
            else {
                GameObject target = player.getScene().getGameObjectByName(args[1]);
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
        if (args.length == 1 ) {
            System.out.println("Argument too short");
            System.out.println("use <item> <?target> <?subtarget>");
            return false;
        }
        if (args.length == 2) {
            Item item = player.getInventory().getItemByName(args[1]);
            if (item instanceof Usable usable) {
                return usable.use();
            }
            else {
                System.out.println(args[1] + " is not usable on another object.");
            }
        }
        if (args.length == 3) {
            Item item = player.getInventory().getItemByName(args[1]);
            if (item instanceof UsableOnGameObject usableOnGameObject) {
                GameObject target = player.getScene().getGameObjectByName(args[2]);
                return usableOnGameObject.useOn(target);
            }
            else {
                System.out.println(args[1] + " is not usable on another object.");
            }
        }
        if (args.length == 4) {
            Item item = player.getInventory().getItemByName(args[1]);
            if (item instanceof UsableOnGameObject usableOnGameObject) {
                GameObject target = player.getScene().getGameObjectByName(args[2]);
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
            else if (player.getScene().getNpc(target) != null) {
                System.out.println("You try to hit " + player.getScene().getNpc(target) + ".");
                player.attack(player.getScene().getNpc(target));
                return true;
            }
            else {
                System.out.println("Unknown target.");
            }
        }
        return false;
    }

    private static void playerCommandLook(String[] args) {
        System.out.println("You see " + player.getScene().getDescription() + ".");
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
        if (npc != null && npc.isAlive) {
            npc.takeTurn();
        }
    }
    public static void endGame() {
        System.out.println("You are dead, the game is over.");
        System.exit(0);
    }
}
