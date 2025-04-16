package data;

public class Node {

     int info;
     Node next;

    //default constructor(no parameter)
    public Node() {
    }

    // Constructor for a typical node
    public Node(int info, Node next) {
        this.info = info;//data stored inside the node 
        this.next = next; //link to the next node 
    }

    public Node(int info) {
        this.info = info;
    }

    

}
