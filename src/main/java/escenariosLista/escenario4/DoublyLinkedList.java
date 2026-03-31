package escenariosLista.escenario4;

public class DoublyLinkedList<T>{
    private Node<T> nodeFirst;
    private Node<T> nodeLast;
    private Node<T> currentNode;
    private int size;

    public DoublyLinkedList(){
        nodeFirst = null;
        nodeLast = null;
        currentNode = null;
        size = 0;
    }

    public boolean isEmpty(){  // empty list verification
        return size == 0;
    }

    private void linkedIfEmpty(Node<T> node){  //  connection if it is empty
        nodeFirst = nodeLast = node;

        node.setNextNode(node);
        node.setPreviousNode(node);

        currentNode = node;
    }

    private void linkedNewNode(Node<T> node){  //  connection between nodes
        node.setNextNode(nodeFirst);
        node.setPreviousNode(nodeLast);

        nodeFirst.setPreviousNode(node);
        nodeLast.setNextNode(node);
    }

    public void addFirst(T value){  //  add at the start
        Node<T> newNode = new Node<>(value);

        if(isEmpty()){
            linkedIfEmpty(newNode);
        }else {
            linkedNewNode(newNode);

            nodeFirst = newNode;
        }
        size++;
    }

    public void addLast(T value){  // add at the end
        Node<T> newNode = new Node<>(value);

        if(isEmpty()){
            linkedIfEmpty(newNode);
        }else {
            linkedNewNode(newNode);

            nodeLast = newNode;
        }
        size++;
    }

    public void add(T value, int index){  // add in the middle

        if (index < 0 || index > size){  // when it is an invalid position
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node<T> newNode = new Node<>(value);

        if(isEmpty()){  // when it is empty

            linkedIfEmpty(newNode);

        }else if (index == 0){  // when it is the first position

            addFirst(value);

        }else if (index == size){  // when it is the last position

            addLast(value);

        }else {  // when it is inserted in the middle

            Node<T> aux = nodeFirst;

            for (int i = 0; i < index; i++){
                aux = aux.getNextNode();
            }

            Node<T> aux2 = aux.getPreviousNode();

            aux2.setNextNode(newNode);
            aux.setPreviousNode(newNode);

            newNode.setNextNode(aux);
            newNode.setPreviousNode(aux2);

            size++;
        }
    }

    public int searchPosition(T value){  //  searches the value and returns the value position

        if (isEmpty()){
            return -1;
        }

        Node<T> aux = nodeFirst;

        for (int i = 0; i < size; i++){

            if(aux.getValueNode().equals(value)){
                return i;
            }

            aux = aux.getNextNode();
        }
        return -1;
    }

    public Node<T> searchNode(T value){  // searches the value and returns a specific node

        if (isEmpty()){
            return null;
        }

        Node<T> aux = nodeFirst;

        for (int i = 0; i < size; i++){

            if(aux.getValueNode().equals(value)){
                return aux;
            }

            aux = aux.getNextNode();
        }
        return null;
    }

    public T removeFirst(){  //  delete the first element
        if (isEmpty()){
            return null;
        }else {
            Node<T> aux = nodeFirst;
            T value = aux.getValueNode();

            if(size == 1){
                nodeFirst = nodeLast = currentNode =null;
            }else {

                nodeFirst = nodeFirst.getNextNode();

                nodeFirst.setPreviousNode(nodeLast);
                nodeLast.setNextNode(nodeFirst);

                if(currentNode == aux){
                    currentNode = nodeFirst;
                }
            }
            size--;
            return value;
        }
    }

    public T removeLast(){  //  delete the last element
        if (isEmpty()){
            return null;
        }else {
            Node<T> aux = nodeLast;
            T value = aux.getValueNode();

            if(size == 1){
                nodeLast = nodeFirst = currentNode = null;
            }else {
                nodeLast = nodeLast.getPreviousNode();

                nodeLast.setNextNode(nodeFirst);
                nodeFirst.setPreviousNode(nodeLast);

                if(currentNode == aux){
                    currentNode = nodeLast;
                }
            }
            size--;
            return value;
        }
    }

    public T remove(T value){  //  delete the element in any position
        if (isEmpty()){
            return null;
        }else {
            Node<T> node = searchNode(value);

            if (node == null){

                return null;

            } else if (node == nodeFirst){

                return removeFirst();

            }else if (node == nodeLast){

                return removeLast();

            }else {

                Node<T> aux = node.getPreviousNode();
                Node<T> aux2 = node.getNextNode();

                aux.setNextNode(aux2);
                aux2.setPreviousNode(aux);

                if(currentNode == node){
                    currentNode = aux2;
                }

                size--;
                return value;
            }
        }
    }

    public T removeCurrentNode(){  //  delete the current node
        if (isEmpty()){
            return null;
        }

        T value = currentNode.getValueNode();

        if(size == 1){
            nodeFirst = nodeLast = currentNode =null;
        }else {
            Node<T> aux = currentNode.getPreviousNode();
            Node<T> aux2 = currentNode.getNextNode();

            aux.setNextNode(aux2);
            aux2.setPreviousNode(aux);

            if(currentNode == nodeFirst){
                nodeFirst = aux2;
            }else if(currentNode == nodeLast){
                nodeLast = aux;
            }

            currentNode = aux2;
        }
        size--;
        return value;
    }

    public void printList(){  //  print the list

        if (isEmpty()){
            System.out.println("the list is empty");
        }

        Node<T> aux = nodeFirst;

        for (int i = 0; i < size; i++){

            if(aux == currentNode){
                System.out.println(aux.getValueNode() + " <- current node");
            }else {
                System.out.println(aux.getValueNode());
            }

            aux = aux.getNextNode();
        }
    }

    public T nextTurn(){  //  go to next turn
        if (isEmpty()){
            return null;
        }
        currentNode = currentNode.getNextNode();

        return currentNode.getValueNode();
    }

    public T previousTurn(){  //  go to the previous turn
        if (isEmpty()){
            return null;
        }
        currentNode = currentNode.getPreviousNode();

        return currentNode.getValueNode();
    }

    public T consultPrevious(){  //  consult previous node
        if (isEmpty()){
            return null;
        }

        return currentNode.getPreviousNode().getValueNode();
    }

    public T consultNext(){  //  consult next node
        if (isEmpty()){
            return null;
        }

        return currentNode.getNextNode().getValueNode();
    }

    public T getCurrentNode(){  //  current node
        if (isEmpty()){
            return null;
        }

        return currentNode.getValueNode();
    }
}