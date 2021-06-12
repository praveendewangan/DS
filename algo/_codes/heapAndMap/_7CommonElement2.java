import java.io.*;
import java.util.*;

public class _7CommonElement2{

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        Map<Integer,Integer> mp1 = new HashMap<>();
        for(int i = 0; i < n1; i++ ) {
            int val = scn.nextInt();
            mp1.put(val,mp1.getOrDefault(val,0)+1);
        }
        int n2 = scn.nextInt();
        for(int i = 0; i < n2; i++ ) {
            int val = scn.nextInt();
            if(mp1.containsKey(val) && mp1.get(val) > 0) {
                System.out.println(val);
                mp1.put(val,mp1.get(val)-1);
            }
        }
    }

}