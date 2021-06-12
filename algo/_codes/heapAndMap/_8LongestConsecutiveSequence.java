
import java.io.*;
import java.util.*;

public class _8LongestConsecutiveSequence{

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        Set<Integer> set = new HashSet<>();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
        a[i] = scn.nextInt();
        }
        
        for(int i = 0; i < n; i++) {
            set.add(a[i]);
        }
        
        int count = 0;
        int num = 0;
        for(int i = 0; i < n; i++){
            if(!set.contains(a[i]-1)){
                int c = 1;
                int temp = a[i]+1;
                while(set.contains(temp)) {
                    temp++;
                    c++;
                }
                if(c > count){
                    count = c; 
                    num = a[i];
                }
            }
        }
        for(int i = 0; i <count; i++){
            System.out.println(num + i);
        }

    }

}
