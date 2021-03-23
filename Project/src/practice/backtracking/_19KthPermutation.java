package practice.backtracking;

import java.util.ArrayList;
import java.util.List;

public class _19KthPermutation {
    // O(n!n),O(k)
    static int set = 0;
    public static void main(String[] args) {
        String str = "123";
        int k = 4;
        int n= 3;
        int fact = 1;
        List<Integer> list = new ArrayList<>();
        for(int i=1; i < n; i++) {
            fact *=  i;
            list.add(i);
        }
        list.add(n);
        k -= 1;
        String ans = "";
        while(true) {
            ans = ans + list.get(k/fact);
            list.remove(k / fact);
            if(list.size() == 0){
                break;
            }
            k = k % fact;
            fact = fact / list.size();
        }
        System.out.println(ans);
    }

}
