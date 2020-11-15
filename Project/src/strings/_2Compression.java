package strings;

import java.util.Scanner;

public class _2Compression {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        String str = ""+s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            char prevch = s.charAt(i-1);
            if(ch != prevch) {
                str += ch;
            }
        }
        System.out.println(str);
        System.out.println(compress(s));
    }
    private static String compress(String s) {
        int count = 1;
        String str = ""+ s.charAt(0);

        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            char prevch = s.charAt(i-1);
            if(ch != prevch) {
                str += count;
                str += ch;
                count = 1;
            } else {
                count++;
            }
        }
        return str+count;
    }
}
