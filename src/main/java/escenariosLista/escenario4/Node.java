package escenariosLista.escenario4;

public class Node<T> {
    private Node<T> nextNode;
    private Node<T> previousNode;
    private T valueNode;

    public Node(T valueNode) {
        this.valueNode = valueNode;
    }

    public Node(T valueNode, Node<T> nextNode,  Node<T> previousNode) {
        super();
        this.valueNode = valueNode;
        this.nextNode = nextNode;
        this.previousNode = previousNode;
    }

    public Node<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }

    public Node<T> getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(Node<T> previousNode) {
        this.previousNode = previousNode;
    }

    public T getValueNode() {
        return valueNode;
    }

    public void setValueNode(T valueNode) {
        this.valueNode = valueNode;
    }
}
