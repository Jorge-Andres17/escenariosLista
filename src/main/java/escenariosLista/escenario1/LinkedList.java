package escenariosLista.escenario1;

public class LinkedList<T> implements Iterable<T> {

    private Node<T> nodeFirst;
    private Node<T> nodeLast;

    public LinkedList() {
        nodeFirst = null;
        nodeLast = null;
    }

    // Add element at the end
    public void add(T data) {

        Node<T> newNode = new Node<>(data);

        if (nodeFirst == null) {
            nodeFirst = newNode;
            nodeLast = newNode;
        } else {
            nodeLast.next = newNode;
            nodeLast = newNode;
        }

        System.out.println("Element added: " + data);
    }


    // Remove first element
    public void remove() {

        if (nodeFirst == null) {
            System.out.println("List is empty");
            return;
        }

        System.out.println("Removed element: " + nodeFirst.data);

        nodeFirst = nodeFirst.next;

        if (nodeFirst == null) {
            nodeLast = null;
        }
    }


    // Search element
    public boolean search(T data) {

        Node<T> current = nodeFirst;

        while (current != null) {

            if (current.data.equals(data)) {
                return true;
            }

            current = current.next;
        }

        return false;
    }


    // Peek first element
    public T peek() {

        if (nodeFirst == null) {
            return null;
        }

        return nodeFirst.data;
    }


    // Show all elements
    public void show() {

        if (nodeFirst == null) {
            System.out.println("List is empty");
            return;
        }

        Node<T> current = nodeFirst;

        while (current != null) {

            System.out.println(current.data);

            current = current.next;
        }
    }


    // Iterator implementation
    @Override
    public MyIterator iterator() {
        return new MyIterator();
    }


    private class MyIterator implements java.util.Iterator<T> {

        private Node<T> current = nodeFirst;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {

            T data = current.data;

            current = current.next;

            return data;
        }

    }

}
