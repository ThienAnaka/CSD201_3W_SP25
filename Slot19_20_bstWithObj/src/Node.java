
public class Node {
    Student info;
    Node left, right;

    

    public Node(Student info, Node left, Node right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }

    public Node(Student info) {
        this.info = info;
        this.left = null;
        this.right = null;
    }

    public Node() {
        this.info = info;
        this.left = null;
        this.right = null;
    }
    
    
    
    
}
