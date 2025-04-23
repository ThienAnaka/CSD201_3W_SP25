
import java.util.*;
import java.io.*;

public class MyList {

    Node head, tail;
    int size;

    MyList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            f.writeBytes(p.info.name + "-" + p.info.price + "     "); // write data in the node p to the file f
            p = p.next;
        }

        f.writeBytes("\r\n");
    }

    void loadData(int k) {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        String[] b = Lib.readLineToStrArray("data.txt", k + 1);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int p = Integer.parseInt(b[i]);

            addLast(a[i], p);
        }
    }

    // Luu y: doc ky dieu kien trong de bai
    void addLast(String n, float p) {
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        if (p > 0) {
            Phone data = new Phone(n, p);
            Node newNode = new Node(data);
            if (isEmpty()) {
                head = tail = newNode;

            } else if (data.price > 0) {
                tail.next = newNode;
                tail = newNode;
            }
            size++;
        }

        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
    }

    void f1() throws Exception {
        clear();
        loadData(0);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        f.close();
    }

    void f2() throws Exception {
        clear();
        loadData(0);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        Phone t = new Phone("FPT_Phone", 100);
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        if (!isEmpty()) {
            Node current = this.head;
            Node maxPrice = this.head;
            while (current != null) {
                if (maxPrice.info.price < current.info.price) {
                    maxPrice = current;
                }
                current = current.next;
            }
            Node newNode = new Node(t);

            newNode.next = maxPrice.next;
            maxPrice.next = newNode;

            if (maxPrice == tail) {
                tail = newNode;
            }

            size++;
        }

        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    void f3() throws Exception {
        clear();
        loadData(0);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        float avg_S = 0;
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        int count = 0;
        float sum = 0;

        Node current = this.head;
        while (current != null) {
            if (current.info.name.startsWith("S")) {
                sum += current.info.price;
                count++;
            }
            current = current.next;
        }

        if (count > 0) {
            avg_S = sum / count;
        }
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        f.writeBytes(avg_S + "\n"); // write data
        ftraverse(f);
        f.close();
    }

    void f4() throws Exception {
        clear();
        loadData(0);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        if (!isEmpty()) {
            int count = 0;
            Node p = this.head;
            while (p != null) {
                count++;
                if (count == 3) {
                    this.head = p.next;
                    if (this.tail == p) {
                        this.tail = this.head = null;
                    }
                    p.next = null;
                    break;
                }
                p = p.next;
            }
        }
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    void f5() throws Exception {
        clear();
        loadData(0);
        String fname = "f5.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        if (head == null || head.next == null) {
            return;
        }

        Node prev = null, curr = head;

        Node prevMax = null, maxNode = head;
        Node prevMin = null, minNode = head;

        while (curr != null) {
            if (curr.info.price > maxNode.info.price) {
                maxNode = curr;
                prevMax = prev;
            }
            if (curr.info.price < minNode.info.price) {
                minNode = curr;
                prevMin = prev;
            }
            prev = curr;
            curr = curr.next;
        }

        if (maxNode == minNode) {
            ftraverse(f);
            f.close();
            return;
        }

        if (maxNode.next == minNode) {

            if (prevMax != null) {
                prevMax.next = minNode;
            } else {
                head = minNode;
            }
            maxNode.next = minNode.next;
            minNode.next = maxNode;

        } else if (minNode.next == maxNode) {

            if (prevMin != null) {
                prevMin.next = maxNode;
            } else {
                head = maxNode;
            }
            minNode.next = maxNode.next;
            maxNode.next = minNode;

        } else {

            Node temp = maxNode.next;
            maxNode.next = minNode.next;
            minNode.next = temp;

            if (prevMax != null) {
                prevMax.next = minNode;
            } else {
                head = minNode;
            }

            if (prevMin != null) {
                prevMin.next = maxNode;
            } else {
                head = maxNode;
            }
        }

        if (maxNode.next == null) {
            tail = maxNode;
        }
        if (minNode.next == null) {
            tail = minNode;
        }
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

}
