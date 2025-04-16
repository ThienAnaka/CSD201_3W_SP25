package slot1_a;

import java.util.Scanner;

public class Slot1_A {

    public static void main(String[] args) {
        int n =3;
        int[] array = new int[n];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i <= n; i++) {
            try {
                System.out.println("Input a[" + i + "]=");
                array[i] = sc.nextInt();
            } catch (Exception e) {

            }

        }
        System.out.println(array);
//        System.out.println("\n------");
//        for (int i = 0; i < n; i++) {
//            System.out.println(array[i]+" ");
//            array[i] = 1;
//        }
//        System.out.println("\n------");
//        for (int i : array) {
//            System.out.println(i + " ");
//        }
        
        System.out.println("\n------");
        for (int i : array) {
            i=1;
        }
        
        for (int i : array) {
            System.out.println(i + " ");
        }
        System.out.println("Số lượng: " + array.length);
        
        String str = "Chao mung ban quay tro lai voi CSD201! :D";
        System.out.println(str.length());
        
    }

}
