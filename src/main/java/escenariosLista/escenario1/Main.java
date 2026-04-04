package escenariosLista.escenario1;

public class Main {

    public static void main(String[] args) {

        LinkedList<String> queue = new LinkedList<>();

        queue.add("Carlos");
        queue.add("Maria");
        queue.add("Juan");

        System.out.println("Current queue:");
        queue.show();

        System.out.println("Next client: " + queue.peek());

        queue.remove();

        System.out.println("Queue after serving one client:");
        queue.show();


        System.out.println("Searching Maria:");
        System.out.println(queue.search("Maria"));


        System.out.println("Using iterator:");

        for (String client : queue) {
            System.out.println(client);
        }

    }

}
