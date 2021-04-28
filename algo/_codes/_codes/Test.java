package _codes;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.exit(0);
        int[] a = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
        int i = 0;
        int j = a.length-1;
        while(i <= j) {
            if(a[i] > 0){
                swap(a,i,j);
                j--;
            } else {
                i++;
            }
        }
        for (int val : a) {
            System.out.print(val + " ");
        }
    }
    private static void swap(int[] a,int i,int j) {
        int val = a[i];
        a[i] = a[j];
        a[j] = val;
    }
    static ArrayList<Integer> factorial(int n){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(n);
        int mul = 1;
        int c = 0;
        for(int i = n-1; i > 1; i--){
            for(int j = 0; j < list.size(); j++) {
                mul = list.get(j) * i + c;
                int r = mul % 10;
                c /= 10;
                list.set(j,r);
        // System.out.println(list);
                
            }
            if(c != 0){
                list.add(c);
                c = 0;
        //     }
        // System.out.println(list);
        }
        return list;
    }
}
