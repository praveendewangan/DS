package strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _3RemovePrimeNumber {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scn.nextInt());
        }
        for (int i = list.size()-1; i >=0 ; i--) {
            if(isPalindrome(list.get(i))) {
                list.remove(i);
            }
        }
        System.out.println(list);
    }
    private static boolean isPalindrome(int n) {
        for (int i = 2; i * i < n ; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
