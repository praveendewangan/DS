import java.util.*;
import java.io.*;
public class _7GetSubSequence {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(gss(str));
    }

    public static ArrayList<String> gss(String str) {
        if(str.length() == 0){
            ArrayList<String> res = new ArrayList<>();
            res.add("");
            return res;
        }
        char ch = str.charAt(0);
        String rstr = str.substring(1);
        ArrayList<String> list = gss(rstr);
        ArrayList<String> res = new ArrayList<>();
        
        for(String s : list) {
            res.add(""+s);
            // res.add(ch + s);
        }
        for(String s : list) {
            // res.add(""+s);
            res.add(ch + s);
        }
        return res;
    }
}
