package array;

import java.util.Scanner;

public class SubsetArray {
    public static void main(String[] args) {
//        Scanner scn = new Scanner(System.in);
        /*int[] a = new int[scn.nextInt()];
        for (int i = 0; i <a.length ; i++) {
            a[i] = scn.nextInt();
        }*/
        int[] a = {1,2,3};
        int limit = (int) Math.pow(2,a.length);
        for (int i = 0; i < limit; i++) {
            int temp = i;
            String set = "";
            for (int j = a.length-1; j >= 0; j--) {
                int r = temp % 2;
                temp = temp / 2;
                if(r == 0) {
                    set = "-\t" + set ;
                } else {
                    set = a[j] + "\t" + set ;
                }
            }
            System.out.println(set);
        }

    }
}
