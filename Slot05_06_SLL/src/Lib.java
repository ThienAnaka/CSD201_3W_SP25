// =========================================================
// Do NOT modify this file 
// =========================================================

import java.io.*;
import java.util.*;

public class Lib {

    /**
     * Helper function: read data from file and display these data on screen
     *
     * @param fname the file name storing data
     * @throws Exception
     */
    static void viewFile(String fname) throws Exception {
        File g = new File(fname);
        if (!g.exists()) {//check whether or not the file fname exists
            System.out.println(" The file " + fname + " does not exist!");
            return;
        }

        RandomAccessFile f;
        String s;
        f = new RandomAccessFile(fname, "r");
        System.out.println(" Content of the file " + fname + ":");

        while ((s = f.readLine()) != null) {
            System.out.println("  " + s);
        }

        f.close();
    }

    /**
     * Helper function: load one line in the fname
     *
     * @param fname the file name storing data
     * @param k the k-th line in the file fname (k = 0, 1, 2,...)
     * @return
     */
    static public String readLineToStr(String fname, int k) {
        String s = null;
        try {
            RandomAccessFile f = new RandomAccessFile(fname, "r");
            for (int i = 0; i < k; i++) {
                f.readLine(); //skip the (k-1) line from the beginning
            }
            s = f.readLine(); //just read data in the k-th line of the file
        } catch (Exception e) {
        }

        return s;
    }

//Read line k (k=0,1,2,...) and extracts it to thearray strings and return this array
    static public String[] readLineToStrArray(String fname, int k) {
        String s = null;
        try {
            RandomAccessFile f = new RandomAccessFile(fname, "r");
            for (int i = 0; i < k; i++) {
                f.readLine();
            }
            s = f.readLine();
        } catch (Exception e) {
        }

        String[] a = new String[100];
        StringTokenizer t = new StringTokenizer(s);
        int i = 0;
        while (t.hasMoreTokens()) {
            a[i++] = t.nextToken().trim();
        }
        int n = i;
        String[] b = new String[n];
        for (i = 0; i < n; i++) {
            b[i] = a[i];
        }
        return (b);
    }

//Read line k (k=0,1,2,...) and extracts it to the array of integers and return this array
    static public int[] readLineToIntArray(String fname, int k) {
        String s = null;
        try {
            RandomAccessFile f = new RandomAccessFile(fname, "r");
            for (int i = 0; i < k; i++) {
                f.readLine();
            }
            s = f.readLine();
        } catch (Exception e) {
        }

        int[] a = new int[100];
        StringTokenizer t = new StringTokenizer(s);
        int r, i;
        i = 0;
        while (t.hasMoreTokens()) {
            r = Integer.parseInt(t.nextToken().trim());
            a[i++] = r;
        }
        int n = i;
        int[] b = new int[n];
        for (i = 0; i < n; i++) {
            b[i] = a[i];
        }
        return (b);
    }

//Read line k (k=0,1,2,...) and extracts it to the array of double numbers and return this array
    static public double[] readLineToDoubleArray(String fname, int k) {
        String s = null;
        try {
            RandomAccessFile f = new RandomAccessFile(fname, "r");
            for (int i = 0; i < k; i++) {
                f.readLine();
            }
            s = f.readLine();
        } catch (Exception e) {
        }

        double[] a = new double[100];
        StringTokenizer t = new StringTokenizer(s);
        int i;
        double r;
        i = 0;
        while (t.hasMoreTokens()) {
            r = Double.parseDouble(t.nextToken().trim());
            a[i++] = r;
        }
        int n = i;
        double[] b = new double[n];
        for (i = 0; i < n; i++) {
            b[i] = a[i];
        }
        return (b);
    }

    //Display string
    static public void dispStr(String s) {
        System.out.println(s);
    }

    //Display all elements of the array of strings
    static public void dispStrArray(String a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " | ");
        }
        System.out.println();
    }

    //Display elements of the array of strings from idex k to index h, k>=0. k<=h and h<=a.length-1
    static public void dispStrArray(String a[], int k, int h) {
        if (k < 0 || k > h || h > a.length - 1) {
            return;
        }
        for (int i = k; i <= h; i++) {
            System.out.print(a[i] + " | ");
        }
        System.out.println();
    }

    //Display all elements of the array of inttegers
    static public void dispIntArray(int a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    //Display elements of the array of inttegers from idex k to index h, k>=0. k<=h and h<=a.length-1
    static public void dispIntArray(int a[], int k, int h) {
        if (k < 0 || k > h || h > a.length - 1) {
            return;
        }
        for (int i = k; i <= h; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
//=======================================================

    //Display string to file
    static public void dispStr(String s, String out_fname) {
        if (s == null) {
            return;
        }
        File g = new File(out_fname);
        if (g.exists()) {
            g.delete();
        }
        RandomAccessFile f;
        try {
            f = new RandomAccessFile(out_fname, "rw");
            if (s != null) {
                f.writeBytes(s + "\r\n");
            }
            f.close();
        } catch (Exception e) {
        }
    }

    //Display string to file
    static public void dispStr(String s, RandomAccessFile f) {
        if (s == null) {
            return;
        }
        try {
            f.writeBytes(s + "\r\n");
        } catch (Exception e) {
        }
    }

    //Display to file elements of the array of strings from idex k to index h, k>=0. k<=h and h<=a.length-1
    static public void dispStrArray(String a[], int k, int h, String out_fname) {
        if (a == null) {
            return;
        }
        if (k < 0 || k > h || h > a.length - 1) {
            return;
        }
        File g = new File(out_fname);
        if (g.exists()) {
            g.delete();
        }
        RandomAccessFile f;
        try {
            f = new RandomAccessFile(out_fname, "rw");
            for (int i = k; i <= h; i++) {
                f.writeBytes(a[i] + " | ");
            }
            f.writeBytes("\r\n");
            f.close();
        } catch (Exception e) {
        }
    }

    //Display to file elements of the array of strings from idex k to index h, k>=0. k<=h and h<=a.length-1
    static public void dispStrArray(String a[], int k, int h, RandomAccessFile f) {
        if (a == null) {
            return;
        }
        if (k < 0 || k > h || h > a.length - 1) {
            return;
        }
        try {
            for (int i = k; i <= h; i++) {
                f.writeBytes(a[i] + " | ");
            }
            f.writeBytes("\r\n");
        } catch (Exception e) {
        }
    }

    //Display to file all elements of the array of strings
    static public void dispStrArray(String a[], String out_fname) {
        if (a == null) {
            return;
        }
        File g = new File(out_fname);
        if (g.exists()) {
            g.delete();
        }
        RandomAccessFile f;
        try {
            f = new RandomAccessFile(out_fname, "rw");
            for (int i = 0; i < a.length; i++) {
                f.writeBytes(a[i] + " | ");
            }
            f.writeBytes("\r\n");
            f.close();
        } catch (Exception e) {
        }
    }

    //Display to file all elements of the array of strings
    static public void dispStrArray(String a[], RandomAccessFile f) {
        if (a == null) {
            return;
        }
        try {
            for (int i = 0; i < a.length; i++) {
                f.writeBytes(a[i] + " | ");
            }
            f.writeBytes("\r\n");
        } catch (Exception e) {
        }
    }

    //Display elements of the array of inttegers from idex k to index h, k>=0. k<=h and h<=a.length-1
    static public void dispIntArray(int a[], int k, int h, String out_fname) {
        if (a == null) {
            return;
        }
        if (k < 0 || k > h || h > a.length - 1) {
            return;
        }
        File g = new File(out_fname);
        if (g.exists()) {
            g.delete();
        }
        RandomAccessFile f;
        try {
            f = new RandomAccessFile(out_fname, "rw");
            for (int i = k; i <= h; i++) {
                f.writeBytes(a[i] + " ");
            }
            f.writeBytes("\r\n");
            f.close();
        } catch (Exception e) {
        }
    }

    //Display elements of the array of inttegers from idex k to index h, k>=0. k<=h and h<=a.length-1
    static public void dispIntArray(int a[], int k, int h, RandomAccessFile f) {
        if (a == null) {
            return;
        }
        if (k < 0 || k > h || h > a.length - 1) {
            return;
        }
        try {
            for (int i = k; i <= h; i++) {
                f.writeBytes(a[i] + " ");
            }
            f.writeBytes("\r\n");
        } catch (Exception e) {
        }
    }

    //Display to file all elements of the array of inttegers
    static public void dispIntArray(int a[], String out_fname) {
        if (a == null) {
            return;
        }
        File g = new File(out_fname);
        if (g.exists()) {
            g.delete();
        }
        RandomAccessFile f;
        try {
            f = new RandomAccessFile(out_fname, "rw");
            for (int i = 0; i < a.length; i++) {
                f.writeBytes(a[i] + " ");
            }
            f.writeBytes("\r\n");
            f.close();
        } catch (Exception e) {
        }
    }

    //Display to file all elements of the array of inttegers
    static public void dispIntArray(int a[], RandomAccessFile f) {
        if (a == null) {
            return;
        }
        try {
            for (int i = 0; i < a.length; i++) {
                f.writeBytes(a[i] + " ");
            }
            f.writeBytes("\r\n");
        } catch (Exception e) {
        }
    }

}
