import java.io.*;
import java.util.*;

public class _2PrintKPC {

    private static String[] codes = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        printKPC(str);
    }

    public static void printKPC(String str) {
        printAllKPC(str,"");
    }
    
    private static void printAllKPC(String str,String asf) {
        if(str.length() == 0){
            System.out.println(asf);
            return;
        }
        
        char ch = str.charAt(0);
        String roq = str.substring(1);
        int key = ch - '0';
        String code = codes[key];
        for(char c : code.toCharArray()){
            printAllKPC(roq,asf + c);
        }
    } 

}

