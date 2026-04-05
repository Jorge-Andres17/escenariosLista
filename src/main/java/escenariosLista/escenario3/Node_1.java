package escenariosLista.escenario3;

public class Node_1<T> {

    private Node_1<T> nextNode;
    private T nodeValue;

    public Node_1(T nodeValue){
        this.nodeValue = nodeValue;
    }

    public Node_1(T nodeValue, Node_1<T> nextNode){
        this.nodeValue = nodeValue;
        this.nextNode = nextNode;
    }

    public Node_1<T> getNextNode(){
        return nextNode;
    }

    public void setNexNode(Node_1<T> nextNode){
        this.nextNode = nextNode;
    }

    public T getNodeValue(){
        return nodeValue;
    }

    public void setNodeValue(T nodeValue){
        this.nodeValue = nodeValue;
    }
}