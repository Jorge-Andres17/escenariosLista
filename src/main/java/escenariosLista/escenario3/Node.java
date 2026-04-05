package escenariosLista.escenario3;

public class Node<T> {

    private Node<T> nextNode;
    private T nodeValue;

    public Node(T nodeValue){
        this.nodeValue = nodeValue;
    }

    public Node(T nodeValue, Node<T> nextNode){
        this.nodeValue = nodeValue;
        this.nextNode = nextNode;
    }

    public Node<T> getNextNode(){
        return nextNode;
    }

    public void setNexNode(Node<T> nextNode){
        this.nextNode = nextNode;
    }

    public T getNodeValue(){
        return nodeValue;
    }

    public void setNodeValue(T nodeValue){
        this.nodeValue = nodeValue;
    }
}