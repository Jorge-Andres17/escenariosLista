package escenariosLista.escenario2;

public class DoubleLinkedList<T> implements Iterable<T> {

    private Node<T> nodeFirst;
    private Node<T> nodeLast;
    private Node<T> current;


    // Visit new page
    public void visit(T page) {

        Node<T> newNode = new Node<>(page);

        // First page
        if (nodeFirst == null) {

           nodeFirst = newNode;
            nodeLast = newNode;
            current = newNode;

            return;
        }

        // Delete forward history
        if (current.next != null) {

            Node<T> temp = current.next;

            while (temp != null) {

                Node<T> nextNode = temp.next;

                temp.previous = null;
                temp.next = null;

                temp = nextNode;
            }

            current.next = null;
            nodeLast = current;
        }

        // Insert new page
        current.next = newNode;
        newNode.previous = current;

        nodeLast = newNode;
        current = newNode;
    }


    // Move backward
    public void back() {

        if (current == null || current.previous == null) {

            System.out.println("No previous page");

            return;
        }

        current = current.previous;
    }


    // Move forward
    public void forward() {

        if (current == null || current.next == null) {

            System.out.println("No next page");

            return;
        }

        current = current.next;
    }


    // Show current page
    public T getCurrentPage() {

        if (current == null) {
            return null;
        }

        return current.data;
    }


    // Show full history
    public void showHistory() {

        Node<T> temp =nodeFirst;

        while (temp != null) {

            if (temp == current) {
                System.out.println("[CURRENT] " + temp.data);
            } else {
                System.out.println(temp.data);
            }

            temp = temp.next;
        }
    }


    // Iterator implementation
    @Override
    public HistoryIterator iterator() {
        return new HistoryIterator();
    }


    private class HistoryIterator implements java.util.Iterator<T> {

        private Node<T> temp =nodeFirst;

        @Override
        public boolean hasNext() {
            return temp != null;
        }

        @Override
        public T next() {

            T data = temp.data;

            temp = temp.next;

            return data;
        }

    }

}
