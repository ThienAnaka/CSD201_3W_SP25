package slot2_a;

import java.util.ArrayList;

public class Slot2_A {

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<Integer>();

        list1.add(5);
        list1.add(10);
        for (int i = 0; i < 100000; i++) {
            list1.add(i);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(list1.get(i));
        }

//        list1.remove(0);
//        list1.remove(list1.size() - 1);
        list1.add(0,-1);
        list1.add(list1.size()-1,-100);
        
        list1.indexOf(5);//vị trí 
        list1.get(list1.indexOf(5));

        System.out.println("Số lượng: " + list1.size());
    }

}
