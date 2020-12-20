package recursion;

import java.util.ArrayList;
import java.util.List;

public class _14GetSubsequence {
    public static void main(String[] args) {
        System.out.println(getsc("abc"));
    }

    private static List<String> getsc(String s){
        if(s.length() == 0){
            List<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        char ch = s.charAt(0);
        String sb = s.substring(1);
        List<String> list = getsc(sb);
        List<String> mres = new ArrayList<>();
        for (String res: list) {
            mres.add("" + res);
        }
        for (String res: list) {
            mres.add(ch + res);
        }
        return mres;
    }
}
