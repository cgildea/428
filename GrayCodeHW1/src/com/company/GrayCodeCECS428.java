package com.company;

public class GrayCodeCECS428 {

    public static void main(String[] args) {
       // int N = Integer.parseInt(args[0]);
        int N = 3;
        gray("", N);
    }

    // append reverse of order n gray code to prefix string, and print
    public static void grayRev(String prefix, int n) {
        if (n == 0) System.out.println(prefix);
        else {
            gray(prefix + "1", n - 1);
            grayRev(prefix + "0", n - 1);
        }
    }

    // append order n gray code to end of prefix string, and print
    public static void gray(String prefix, int n) {
        if (n == 0) System.out.println(prefix);
        else {
            gray(prefix + "0", n - 1);
            grayRev(prefix + "1", n - 1);
        }
    }


}
