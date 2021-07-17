import java.io.*;
import java.util.*;

public class _16CountABCSequence {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        // System.out.println(solve(str,0,"",'a'));
        System.out.println(solve(str));
    }
    
    private static int solve(String s) {
        int a_count = 0;
        int b_count = 0;
        int c_count = 0;
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == 'a') {
                a_count = 2 * a_count + 1;
            } else if(ch == 'b') {
                b_count = a_count + 2 * b_count;
            } else {
                c_count = b_count + 2 * c_count;
            }
        }
        return c_count;
    }
    
    private static int solve(String str,int idx,String psf,char lc) {
        if(str.length() == idx) {
            if(psf.length() >= 3 && psf.charAt(0) == 'a' && psf.charAt(psf.length()-1) == 'c') {
                return 1;
            }
            return 0;
        }
        
        char ch = str.charAt(idx);
        int count = 0;
        if(ch == 'a' && lc == 'a') {
            count += solve(str,idx+1,psf+ch,ch);
        } else if(ch == 'b' && (lc == 'a' || lc == 'b')) {
            count += solve(str,idx+1,psf+ch,ch);
        } else if(ch == 'c' && (lc == 'b' || lc == 'c')) {
            count += solve(str,idx+1,psf+ch,ch);
        }
        
        count += solve(str,idx+1,psf,lc);
        return count;
    }
}