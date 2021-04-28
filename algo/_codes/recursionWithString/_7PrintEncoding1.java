import java.io.*;
import java.util.*;
public class _7PrintEncoding1 {
    public static char[] chars= {'0','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        printEncodings(str,"");
    }

    public static void printEncodings(String str,String asf) {
        if(str.length() == 0) {
            System.out.println(asf);
            return;
        }
        
        int idx = str.charAt(0) - '0';
        
        char ch = chars[idx];
        String roq = str.substring(1);
        if(ch != '0'){
            printEncodings(roq, asf + ch);
            if(2 <= str.length()){
                int idx2 = str.charAt(1) - '0';
                idx2 = idx * 10 + idx2;
                if(idx2 <= 26) {
                    ch = chars[idx2];
                    roq = str.substring(2);
                    printEncodings(roq, asf + ch);
                }
            }
        }
    }
}
