
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

    void ftraverseFW(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            f.writeBytes(p.info.ID + "-" + p.info.name + "-" + p.info.price + "     "); // write data in the node p to the file f
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void ftraverseBW(RandomAccessFile f) throws Exception {
        Node p = tail;
        while (p != null) {
            f.writeBytes(p.info.ID + "-" + p.info.name + "-" + p.info.price + "     "); // write data in the node p to the file f
            p = p.pre;
        }
        f.writeBytes("\r\n");
    }

    void loadData(int k) {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        String[] b = Lib.readLineToStrArray("data.txt", k + 1);
        String[] c = Lib.readLineToStrArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(a[i]);
            int y = Integer.parseInt(c[i]);
            addLast(x, b[i], y);
        }
    }

    void addLast(int id, String name, int price) {
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------

        if (price > 0) {
            Phone data = new Phone(id, name, price);
            Node newNode = new Node(data);
            if (isEmpty()) {
                head = tail = newNode;

            } else {
                newNode.pre = tail;
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
        ftraverseFW(f);
        ftraverseBW(f);
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
        ftraverseFW(f);
        ftraverseBW(f);
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        if (!isEmpty()) {
            int count = 0;
            Node p = this.head;
            while (p != null) {
                count++;
                if (count == 2) {
                    this.head = p.next;
                    this.head.pre = null;
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
        ftraverseFW(f);
        ftraverseBW(f);
        f.close();
    }

    // f3: remove the all Phone 'I'
    void f3() throws Exception {
        clear();
        loadData(0);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverseFW(f);
        ftraverseBW(f);
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        Node p = head;
        while (p != null) {
            if (p.info.name.equals("I")) {
                Node toDelete = p;

                // Nếu là head
                if (toDelete == head) {
                    head = toDelete.next;
                    if (head != null) {
                        head.pre = null;
                    }
                }

                // Nếu là tail
                if (toDelete == tail) {
                    tail = toDelete.pre;
                    if (tail != null) {
                        tail.next = null;
                    }
                }

                // Nếu ở giữa
                if (toDelete.pre != null) {
                    toDelete.pre.next = toDelete.next;
                }
                if (toDelete.next != null) {
                    toDelete.next.pre = toDelete.pre;
                }

                size--;
            }
            p = p.next;
        }
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverseFW(f);
        ftraverseBW(f);
        f.close();
    }

    // f4: add a new Phone to the possition "after the head node"
    // (only add if the list does not contain the ID of the new Phone).
    // This also means that: 
    // (1) you should check the ID of the new Phone exist in the list or not; 
    // (2) if it does not exist, you write your code to add it to the list.
    void f4() throws Exception {
        clear();
        loadData(0);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverseFW(f);
        ftraverseBW(f);
        Phone t = new Phone(999, "FPT", 25);
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        boolean exist = false;
        Node p = head;
        while (p != null) {
            if (p.info.ID == t.ID) {
                exist = true;
                break;
            }
            p = p.next;
        }

        
        if (!exist) {
            Node newNode = new Node(t);

            if (head == null) {
                head = tail = newNode;
            } else {
                newNode.next = head.next;
                newNode.pre = head;
                if (head.next != null) {
                    head.next.pre = newNode;
                } else {
                    tail = newNode; 
                }
                head.next = newNode;
            }
            size++;
        }
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverseFW(f);
        ftraverseBW(f);
        f.close();
    }

    // f5: swap min and max 
    void f5() throws Exception {
        clear();
        loadData(0);
        String fname = "f5.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverseFW(f);
        ftraverseBW(f);
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------

        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverseFW(f);
        ftraverseBW(f);
        f.close();
    }

}
