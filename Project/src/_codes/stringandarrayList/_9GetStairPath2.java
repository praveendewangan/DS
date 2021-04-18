import java.io.*;
import java.util.*;
public class _9GetStairPath2 {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(getStairPaths(n));
    }

    public static ArrayList<String> getStairPaths(int n) {
        if(n == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        ArrayList<String> res = new ArrayList<>();
        if(n-1 >= 0){
            ArrayList<String> li = getStairPaths(n-1);
            for(String s : li){
                res.add(1 + s);
            }
        }
        if(n-2 >= 0){
            ArrayList<String> li = getStairPaths(n-2);
            for(String s : li){
                res.add(2 + s);
            }
        }
        if(n-3 >= 0){
            ArrayList<String> li = getStairPaths(n-3);
            for(String s : li){
                res.add(3 + s);
            }
        }
        return res;
    }

}
