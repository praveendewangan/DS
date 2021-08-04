import java.io.*;
import java.util.*;

public class _20WordsKSelection4 {

  

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());

    HashMap<Character, Integer> unique = new HashMap<>();
    String ustr = "";
    for (char ch : str.toCharArray()) {
      if (unique.containsKey(ch) == false) {
        unique.put(ch, 1);
        ustr += ch;
      } else {
        unique.put(ch, unique.get(ch) + 1);
      }
    }

    combination(ustr,unique,0,"",0,k);
  }
  
  private static void combination(String ustr,HashMap<Character, Integer> mp,int li,String asf,int cs,int ts) {
      if(cs == ts) {
          System.out.println(asf);
          return;
      }
      for(int i = li; i < ustr.length(); i++ ) {
          char ch = ustr.charAt(i);
          int f = mp.get(ch);
          if(f > 0) {
              mp.put(ch,f-1);
              combination(ustr,mp,i,asf+ch,cs+1,ts);
              mp.put(ch,f);
          }
      }
  }

}
