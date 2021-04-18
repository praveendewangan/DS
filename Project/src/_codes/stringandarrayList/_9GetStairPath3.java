
import java.io.*;
import java.util.*;
public class _9GetStairPath3 {
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
        for(int i = 1; i <= 3 && n- i >= 0;i++) {
            ArrayList<String> li = getStairPaths(n-i);
            for(String s : li){
                res.add(i + s);
            }
        }
        return res;
    }
}
