
public class Node {

    int info;
    Node next;

    public Node() {
    }

    public Node(int info, Node next) {
        this.info = info;
        this.next = next;
    }

    //Overloading
    public Node(int info) {
        this.info = info;
    }

}
