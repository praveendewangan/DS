package bitmanupulation;

import java.util.Scanner;

public class _16UTF_8_Encoding {
    private static void solution(int[] a) {
        boolean flag = true;
        int rb = 0;
        for (int n : a) {
            if(rb == 0) {
                if((n >> 7) == 0b0) { // 1st byte of 1 length char
                    rb = 0;
                } else if((n >> 5) == 0b110) {  // 1st byte of 2 length char
                    rb = 1;
                } else if((n >> 4) == 0b1110) {  // 1st byte of 3 length char
                    rb = 2;
                } else if((n >> 3) == 0b11110) {  // 1st byte of 4 length char
                    rb = 3;
                }
            } else {
                if((n >> 6) == 0b10) {
                    rb--;
                } else {
                    flag = false;
                    break;
                }
            }
        }
        if(rb == 0) {
            System.out.println(flag);
        } else {
            System.out.println(false);
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n =  scn.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }
        solution(a);
    }
}
