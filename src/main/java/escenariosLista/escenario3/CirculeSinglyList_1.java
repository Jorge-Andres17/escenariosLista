package escenariosLista.escenario3;

import java.util.Iterator;

public class CirculeSinglyList_1<T> implements Iterable<T> {

    private Node_1<T> firstNode;
    private Node_1<T> lastNode;
    private Node_1<T> current;
    private int size;

    public CirculeSinglyList_1(){
        firstNode = null;
        lastNode = null;
        current = null;
        size = 0;
    }

    private boolean IsEmpty() {
        return size == 0;
    }

    // Agregar al inicio
    public void addHome(T value){
        Node_1<T> newNode = new Node_1<>(value);

        if(IsEmpty()){
            firstNode = newNode;
            lastNode = newNode;
            newNode.setNexNode(newNode);
            current = firstNode;
        } else {
            newNode.setNexNode(firstNode);
            lastNode.setNexNode(newNode);
            firstNode = newNode;
        }
        size++;
    }

    // Siguiente canción
    public T nextSong(){
        if(IsEmpty()) return null;

        if(current == null){
            current = firstNode;
        } else {
            current = current.getNextNode();
        }

        return current.getNodeValue();
    }

    // Eliminar canción
    public void remove(T value){
        if(IsEmpty()) return;

        Node_1<T> currentNode = firstNode;
        Node_1<T> previous = lastNode;

        do {
            if(currentNode.getNodeValue().equals(value)){

                if(size == 1){
                    firstNode = null;
                    lastNode = null;
                    current = null;
                } else {
                    previous.setNexNode(currentNode.getNextNode());

                    if(currentNode == firstNode){
                        firstNode = currentNode.getNextNode();
                    }

                    if(currentNode == lastNode){
                        lastNode = previous;
                    }

                    if(current == currentNode){
                        current = currentNode.getNextNode();
                    }
                }

                size--;
                return;
            }

            previous = currentNode;
            currentNode = currentNode.getNextNode();

        } while(currentNode != firstNode);
    }

    // Mostrar lista
    public void showList(){
        if(IsEmpty()){
            System.out.println("Lista vacía");
            return;
        }

        Node_1<T> temp = firstNode;

        do {
            System.out.println(temp.getNodeValue());
            temp = temp.getNextNode();
        } while(temp != firstNode);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node_1<T> currentNode = firstNode;
            private int count = 0;

            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public T next() {
                T value = currentNode.getNodeValue();
                currentNode = currentNode.getNextNode();
                count++;
                return value;
            }
        };
    }
}