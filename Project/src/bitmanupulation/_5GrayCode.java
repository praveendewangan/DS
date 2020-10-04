package bitmanupulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _5GrayCode {
    private static List<String> solution(int n) {
        if(n == 1) {
            List<String> list = new ArrayList<>();
            list.add("0");
            list.add("1");
            return list;
        }
        List<String> rlist = solution(n - 1);
        List<String> mlist = new ArrayList<>();
        for (int i = 0; i < rlist.size(); i++) {
            mlist.add("0" + rlist.get(i));
        }
        for (int i = rlist.size() - 1; i >= 0; i--) {
            mlist.add("1" + rlist.get(i));
        }
        return mlist;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n =  scn.nextInt();
        List<String> list = solution(n);
        for (String str : list) {
            for (int i = 0; i < str.length(); i++) {
                System.out.print(str.charAt(i) + " ");
            }
            System.out.println();
        }
    }
}
