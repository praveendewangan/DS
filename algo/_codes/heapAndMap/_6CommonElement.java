
import java.io.*;
import java.util.*;

public class _6CommonElement {

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n1 = scn.nextInt();
    Map<Integer,Integer> mp1 = new HashMap<>();
    for(int i = 0; i < n1; i++ ) {
        mp1.put(scn.nextInt(),0);
    }
    int n2 = scn.nextInt();
    for(int i = 0; i < n2; i++ ) {
        int val = scn.nextInt();
        if(mp1.containsKey(val)) {
            System.out.println(val);
            mp1.remove(val);
        }
    }
 }

}