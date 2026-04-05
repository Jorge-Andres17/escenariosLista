package escenariosLista.escenario2;

public class Main {
    public static void main(String[] args) {

        DoubleLinkedList<String> history = new DoubleLinkedList<>();

        history.visit("google.com");
        history.visit("youtube.com");
        history.visit("github.com");

        history.back();

        System.out.println("Current page:");
        System.out.println(history.getCurrentPage());

        history.forward();

        System.out.println("Current page:");
        System.out.println(history.getCurrentPage());

        history.back();

        history.visit("stackoverflow.com");

        System.out.println("Full history:");

        history.showHistory();


        System.out.println("Iterator traversal:");

        for (String page : history) {
            System.out.println(page);
        }

    }

}
