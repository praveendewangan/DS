import java.io.*;
import java.util.*;

public class _16Abbreviation1UsingBits {

    public static void solve(String str){
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < (1 << str.length()); i++) {
            int count = 0;
            for(int j = 0; j < str.length(); j++) {
                int k = str.length() - 1 - j; // bit index, because bit index begin from right to left

                // check if kth bit is ON or OFF in 'i'
                int bm = 1 << k;
                char ch = str.charAt(j);
                if((i & bm) == 0) {
                    // bit is OFF
                    if(count == 0) {
                        res.append(ch);
                    } else {
                        res.append(count);
                        res.append(ch);
                        count = 0; // reset count
                    }
                } else {
                    // bit is ON
                    count++;
                }
            }
            if(count != 0) {
                res.append(count);
            }
            res.append("\n");
        }
        System.out.println(res);

    }
    
	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        solve(str);
    }
}