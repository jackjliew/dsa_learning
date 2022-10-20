package gmail.jackjliew.test;

import javax.swing.*;

public class Zigzag {

    public static void main(String[] args) {
        String s = "paypayishiring";
        int numRows = 4;
        int group = (int) Math.ceil( (double) s.length() / (numRows + (numRows - 2)) );
        int numCols = group * (numRows - 1);
                System.out.println("s length: " + s.length());

        System.out.println("numRows=" + numRows);
        System.out.println("numbCols=" + numCols);

        int[][] coord = new int[numRows][numCols];

        System.out.println("0%3:" + 0%3);
        System.out.println("1%3:" + 1%3);
        System.out.println("2%3:" + 2%3);
        System.out.println("3%3:" + 3%3);


        for (int i = 0; i < coord.length; i++) {
            for (int j = 0; j < coord[i].length; j++) {
                if ( j % (numRows - 1) == 0 || (i + j) % (numRows - 1) == 0)
                    System.out.print("(" + i + "," + j + ")");
            }
            System.out.println();
        }
    }
}
