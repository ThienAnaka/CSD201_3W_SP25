package data;

import java.util.Random;
import java.util.Scanner;

public class MyList {

    Node head, tail;

    public MyList() {
        this.head = null;
    }

    public boolean isEmpty() {
//        if(this.head == null){
//            return true;
//        }else{
//            return false;
//        }
        return this.head == null;
    }

    public void clear() {
        this.head = null;
    }

    public void traverse() {
        Node p = head;
        while (p != null) {
            System.out.print(p.info);
            System.out.print(" ");
            p = p.next;
        }
    }

    void loadData(int k) {
        Random generator = new Random();
        for (int i = 0; i < k; i++) {
            int number = generator.nextInt(1000) + 1;
            //add into list
            addFirst(number);

        }
    }

    public void addFirst(int n) {
        Node newNode = new Node(n);

        newNode.next = head;
        head = newNode;
    }

    public void addLast(int n) {
        Node newNode = new Node(n);

        //if list is empty, make the new node as head
        if (head == null) {
            head = newNode;
            return;
        }

        //if list is not empty
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }

        //add new node at the end
        last.next = newNode;
    }

    void f1() {
        System.out.println("Linked List: ");
        this.traverse();
    }

    //f2: nhap du lieu 1 con so tu ban phim => addLast
    void f2() {
        System.out.println("\nBefore: ");
        this.traverse();

        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter number: ");
        int number = sc.nextInt();
        addLast(number);
        System.out.println("\nAfter: ");
        this.traverse();
    }

    //f3: addPos => them node vao vi tri thu k 
    void f3() {
        System.out.print("\nBefore: ");
        this.traverse();

        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter a value: ");
        int value = sc.nextInt();
        System.out.print("Enter position k: ");
        int k = sc.nextInt();

        //special case for head
        if (k == 0) {
            addFirst(value);
        } else {
            //find the node at position k-1
            Node current = head;
            int currentIndex = 0;
            while (currentIndex < k - 1 && current != null) {
                current = current.next;
                currentIndex++;
            }
            //insert new node
            Node newNode = new Node(value);
            newNode.next = current.next;
            current.next = newNode;
        }
        System.out.print("After: ");
        this.traverse();
    }

    // f4: removeFirst
    void f4() {
        System.out.print("Before:   ");
        this.traverse();
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        if (isEmpty()) {
            return;
        }
        System.out.println("\n");
        if (head != null) {
            head = head.next;
        }

        //------ End your code here-----------------------------------------------------------
        System.out.print("After:    ");
        this.traverse();
    }

    // f5: removeLast
    public void f5() throws Exception {
        System.out.print("Before:   ");
        this.traverse();
        //------ Start your code here---------------------------------------------------------
        if (isEmpty()) {
            return;
        }

        if (head != null) {
            if (head.next == null) {
                head = null;
            } else {
                //find the second last node
                Node secondLast = head;
                while (secondLast.next.next != null) {
                    secondLast = secondLast.next;
                }
                //remove last node
                secondLast.next = null;
            }
        }
        System.out.println("\n");

        //------ End your code here-----------------------------------------------------------
        System.out.print("After:    ");
        this.traverse();
    }
}
