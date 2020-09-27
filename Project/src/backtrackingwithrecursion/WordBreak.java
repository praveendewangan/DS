package backtrackingwithrecursion;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WordBreak {
    private static void solution(String str,String asf, Set<String> list) {
        if (str.length() == 0) {
            System.out.println(asf);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            String left = str.substring(0,i + 1);
            if(list.contains(left)) {
                String right = str.substring(i+1);
                solution(right,asf+left+" ",list);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        Set<String> list = new HashSet<>();
        for (int i = 0; i < n; i++) {
            list.add(scn.next());
        }
        String sentance = scn.next();
        solution(sentance,"",list);
    }
}
