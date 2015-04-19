package com.company;

public class GrayCodeCECS428 {

    public static void main(String[] args) {
       // int N = Integer.parseInt(args[0]);
<<<<<<< HEAD
        int N = 3;
        gray("", N);
=======
        int N = 17;
        BufferedWriter writer = null;
        try {
            File output = new File("17N.txt");
            writer = new BufferedWriter(new FileWriter(output, true));
            System.out.println(output.getCanonicalPath());
            gray("", N);
        } catch (Exception e){
            e.printStackTrace();
        } finaly {
            try{
                writer.close();
            } catch (Exception e){

            }
        }
>>>>>>> 08fc7600e8e3aea474e17901618b51f6e1ff03e7
    }

    // append reverse of order n gray code to prefix string, and print
    public static void grayRev(String prefix, int n) {
        if (n == 0) { //System.out.println(prefix);
            writer.write(java.text.MessageFormat.format("{0}\n", prefix))
        }
            else {
            gray(prefix + "1", n - 1);
            grayRev(prefix + "0", n - 1);
        }
    }

    // append order n gray code to end of prefix string, and print
    public static void gray(String prefix, int n) {
        if (n == 0){ //System.out.println(prefix);
            writer.write(java.text.MessageFormat.format("{0}\n", prefix))
        }
        else {
            gray(prefix + "0", n - 1);
            grayRev(prefix + "1", n - 1);
        }
    }


}
