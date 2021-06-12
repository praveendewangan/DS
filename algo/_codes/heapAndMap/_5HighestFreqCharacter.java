
import java.io.*;
import java.util.*;

public class _5HighestFreqCharacter {

    public static void main(String[] args) throws Exception {
       Scanner scn = new Scanner(System.in);
       String str = scn.next();
       Map<Character,Integer> mp = new HashMap<>();
       for(char ch : str.toCharArray()){
           mp.put(ch,mp.getOrDefault(ch,0)+1);
       }
       int count = 0;
       char c = 0;
       for(char key :mp.keySet()){
           if(mp.get(key) > count){
               count = mp.get(key);
               c = key; 
           }
       }  
       System.out.println(c);
    }

}