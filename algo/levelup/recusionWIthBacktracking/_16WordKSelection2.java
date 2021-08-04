
import java.io.*;
import java.util.*;

public class _16WordKSelection2 {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();
    int k = scn.nextInt();
    
    HashSet<Character> unique = new HashSet<>();
    String ustr = "";
    for(char ch : str.toCharArray()){
        if(unique.contains(ch)== false){
            unique.add(ch);
            ustr+=ch;
        }
    }
    combination(ustr,0,k,"",-1);
  }
  
  private static void combination(String str,int ssf,int ts,String asf,int lc) {
      if(ssf == ts) {
          System.out.println(asf);
          return;
      }
      
      for(int i = lc+1; i < str.length(); i++) {
          combination(str,ssf+1,ts,asf+str.charAt(i),i);
      }
  }

}