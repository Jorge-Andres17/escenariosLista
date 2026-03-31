package escenariosLista.escenario4;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<String> players = new DoublyLinkedList<>();

        System.out.println("=== ADD PLAYERS ===");

        players.addLast("Ana");
        players.addLast("Luis");
        players.addLast("Carlos");
        players.addLast("Maria");
        players.addFirst("Jose");
        players.addFirst("Jason");
        players.add("Steven", 3);

        players.printList();


        System.out.println("\n=== CURRENT PLAYER ===");
        System.out.println("Current: " + players.getCurrentNode());


        System.out.println("\n=== NEXT TURN ===");
        System.out.println("Next turn: " + players.nextTurn());
        System.out.println("Next turn: " + players.nextTurn());
        System.out.println("Next turn: " + players.nextTurn());
        players.printList();


        System.out.println("\n=== PREVIOUS TURN ===");
        System.out.println("Previous turn: " + players.previousTurn());
        System.out.println("Previous turn: " + players.previousTurn());
        players.printList();


        System.out.println("\n=== CONSULT NEXT AND PREVIOUS ===");
        System.out.println("Next player: " + players.consultNext());
        System.out.println("Previous player: " + players.consultPrevious());


        System.out.println("\n=== ADD PLAYER IN POSITION 2 ===");
        players.add("Pedro", 2);
        players.printList();


        System.out.println("\n=== REMOVE FIRST PLAYER ===");
        players.removeFirst();
        players.printList();


        System.out.println("\n=== REMOVE LAST PLAYER ===");
        players.removeLast();
        players.printList();


        System.out.println("\n=== REMOVE SPECIFIC PLAYER (Carlos) ===");
        players.remove("Carlos");
        players.printList();


        System.out.println("\n=== REMOVE CURRENT PLAYER ===");
        System.out.println("Removed: " + players.removeCurrentNode());
        players.printList();
        System.out.println("New current: " + players.getCurrentNode());


        System.out.println("\n=== SEARCH POSITION ===");
        int position = players.searchPosition("Luis");
        System.out.println("Luis position: " + position);


        System.out.println("\n=== SIMULATE TURNS (Circular behavior) ===");

        for (int i = 0; i < 8; i++) {
            System.out.println("Turn for: " + players.nextTurn());
        }


        System.out.println("\n=== FINAL LIST ===");
        players.printList();

    }
}
