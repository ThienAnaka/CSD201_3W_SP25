class Node{
    Phone info;
    Node next;
    Node () {}
    Node (Phone x, Node p) {
        this.info = x; // data stored inside the node
        this.next = p; // link to the next node
    }
    Node (Phone x) {
        this(x,null);
    }
 }

class Phone{
    String name;
    float price;
    Phone () {}
    Phone (String n, float p) {
        this.name = n; // data stored inside the node
        this.price = p; // link to the next node
    }
 }

