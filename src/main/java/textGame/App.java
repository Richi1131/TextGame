package textGame;

import java.util.*;

public class App {
    public static Scene originScene = Scene.Companion.newRandomScene(new Position(0, 0));
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
        String[] args = input.split(" ");
        List<String> list = new ArrayList<>(Arrays.asList(args));
        list.removeFirst();
        String keyword = args[0];
        args = list.toArray(new String[0]);
        for (PlayerCommand command : PlayerCommand.Companion.getCommands()) {
            if (Arrays.asList(command.getKeywords()).contains(keyword)) {
                if (command.execute(args)) {
                    return command.endsTurn();
                }
                else {return false;}
            }
        }
        System.out.println("unknown command \"" + input + "\", use \"help\" for a list of valid commands");
        return false;
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
