package practice.arrays;

import java.util.ArrayList;
import java.util.List;

public class _25MajorityElement2 {
    public List<Integer> majorityElement(int[] nums) {
        int n1 = -1;
        int n2 = -1;
        int c1 = 0;        
        int c2 = 0;
        int m = nums.length / 3;
        
        for(int a : nums) {
            if(a == n1) {
                c1++;
            } else if(a == n2) {
                c2++;
            } else if(c1 == 0) {
                n1 = a;
                c1 = 1;
            } else if(c2 == 0) {
                n2 = a;
                c2 = 1;
            } else {
                c1--;
                c2--;
            }
        }
        List<Integer> list = new ArrayList<>();
        c1 = 0;
        c2 = 0;
        for(int a : nums) {
            if(a == n1) {
                c1++;
            } else if(a == n2) {
                c2++;
            }
        }
        if(c1 > m) {
            
            list.add(n1);
        }
        
        if(c2 > m) {
            
            list.add(n2);
        }
        
        return list;
    }

}
