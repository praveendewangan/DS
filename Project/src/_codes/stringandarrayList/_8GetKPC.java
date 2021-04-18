import java.io.*;
import java.util.*;
public class _8GetKPC {
    public static String[] kstr = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next(); 
        ArrayList<String> res = getKPC(str);
        System.out.println(res);
    }

    public static ArrayList<String> getKPC(String str) {
        if(str.length() == 0){
            ArrayList<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        char ch = str.charAt(0);
        String s = str.substring(1);
        
        ArrayList<String> list = getKPC(s);
        ArrayList<String> res = new ArrayList<>();
        String code = kstr[ch - '0'];
        for(char c : code.toCharArray()){
            for(String cs : list){
                res.add(c + cs);
            }
        }
        return res;
    }
}
