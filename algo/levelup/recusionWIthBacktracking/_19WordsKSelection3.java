import java.io.*;
import java.util.*;

public class _19WordsKSelection3 {

  
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
    combination(ustr,0,unique,"",k);
   
  }
  
  private static void combination(String str,int cc,HashMap<Character, Integer> mp,String asf,int k) {
      int ssf = asf.length();
      if(ssf == k) {
          System.out.println(asf);
          return;
      }
      if(cc == str.length()) return;
      char ch = str.charAt(cc);
      int f = mp.get(ch);
    //   Yes call
      for(int i = f; i > 0; i--) {
          if(i + ssf <= k){
              String s = "";
              for(int j = 0; j < i;j++) {
                  s += ch;
              }
              combination(str,cc+1,mp,asf+s,k);
          }
      }
    //   No call
      combination(str,cc+1,mp,asf,k);
  }

}