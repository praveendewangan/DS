package practice.string;

import java.util.ArrayList;
import java.util.List;

public class _19GetKpc {
    public static void main(String[] args) {
        System.out.println(printKPC("78"));
    }   
    
    static String[] kp = {".","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static List<String> printKPC(String str) {
        if(str.length() == 0) {
            List<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        char ch = str.charAt(0);
        String restStr = str.substring(1);
        int i = ch - '0';
        List<String> list = printKPC(restStr);
        List<String> res = new ArrayList<>();
        
        String kpcstr = kp[i];
        for(int j = 0;j<kpcstr.length();j++){
            char c = kpcstr.charAt(j);
            for (String s : list) {
                res.add(c+s);
            }
        }
        return res;
    } 
}
