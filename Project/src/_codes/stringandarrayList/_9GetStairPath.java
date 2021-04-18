import java.io.*;
import java.util.*;
public class _9GetStairPath {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(getStairPaths(n));
    }

    public static ArrayList<String> getStairPaths(int n) {
        if(n <= 0) {
            ArrayList<String> list = new ArrayList<>();
            if(n == 0) {
                list.add("");
            }
            return list;
        }
        ArrayList<String> res = new ArrayList<>();
        ArrayList<String> l1 = getStairPaths(n-1);
        ArrayList<String> l2 = getStairPaths(n-2);
        ArrayList<String> l3 = getStairPaths(n-3);
        for(String s : l1){
            res.add(1 + s);
        }
        for(String s : l2){
            res.add(2 + s);
        }
        for(String s : l3){
            res.add(3 + s);
        }
        return res;
    }

}
