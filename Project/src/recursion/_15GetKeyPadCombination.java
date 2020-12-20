package recursion;

import java.util.ArrayList;
import java.util.List;

public class _15GetKeyPadCombination {
    private static int count = 0;
    private static String[] codes = {".;","abc","def","ghi","jkl","mno","pqrst","uv","wxyz"};
    public static void main(String[] args) {
        System.out.println(getKPD("567"));
        System.out.println(count);
    }

    private static List<String> getKPD(String s) {
        if(s.length() == 0) {
            List<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        char c = s.charAt(0);
        String sb = s.substring(1);
        List<String> list = getKPD(sb);
        List<String> mres = new ArrayList<>();
        System.out.println(c);
        String sc = codes[c-'0'];
        for (int i=0;i<sc.length();i++) {
            char ch = sc.charAt(i);
            for (String ss : list) {
                mres.add(ch + ss);
                count++;
            }
        }
        return mres;
    }
}
