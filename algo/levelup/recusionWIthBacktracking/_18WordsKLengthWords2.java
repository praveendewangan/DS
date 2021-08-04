import java.io.*;
import java.util.*;

public class _18WordsKLengthWords2 {

 
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
    Set<Character> set = new HashSet<>();
    permutation(ustr,set,0,k,"");
   
  }
  
  private static void permutation(String str,Set<Character> set,int cs,int ts,String asf) {
      if(cs == ts) {
          System.out.println(asf);
          return;
      }
      
      for(int i = 0; i < str.length(); i++) {
          char ch = str.charAt(i);
          if(!set.contains(ch)) {
              set.add(ch);
              permutation(str,set,cs+1,ts,asf+ch);
              set.remove(ch);
          }
      }
  }

}