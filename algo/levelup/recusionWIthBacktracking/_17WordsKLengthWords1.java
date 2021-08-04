
import java.io.*;
import java.util.*;

public class _17WordsKLengthWords1 {

 

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());

    HashSet<Character> unique = new HashSet<>();
    String ustr = "";
    for (char ch : str.toCharArray()) {
      if (unique.contains(ch) == false) {
        unique.add(ch);
        ustr += ch;
      }
    }
    Character[] slots = new Character[k];
    permutation(ustr,0,0,slots);
  }
  
  private static void permutation(String str,int li,int ssf,Character[] slots) {
      if(li == str.length()) {
          if(ssf == slots.length) {
              for(char ch : slots){
                  System.out.print(ch);
              }
              System.out.println();
          }
          return;
      }
      char ch = str.charAt(li);
      for(int i = 0; i < slots.length; i++){
          if(slots[i] == null) {
              slots[i] = ch;
              permutation(str,li+1,ssf+1,slots);
              slots[i] = null;
          }
      }
      permutation(str,li+1,ssf,slots);
      
  }

}
