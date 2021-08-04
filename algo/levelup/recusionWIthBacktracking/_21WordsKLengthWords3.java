import java.io.*;
import java.util.*;

public class _21WordsKLengthWords3 {



  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());
    Map<Character,Integer> mp = new HashMap<>();
    for(char ch : str.toCharArray()) {
        mp.put(ch,-1);
    }
    Character[] slots = new Character[k];
    permutation(str,0,0,k,mp,slots);

  }
  
  private static void permutation(String str,int cci,int ssf,int ts,Map<Character,Integer> mp, Character[] slots) {
      if(cci == str.length()) {
          if(ssf == ts) {
              for(char ch : slots) {
                  System.out.print(ch);
              }
                  System.out.println();
          }
          return;
      }
      
      char ch = str.charAt(cci);
      int loc = mp.get(ch);
      
      for(int i = loc+1; i < slots.length; i++) {
          if(slots[i] == null) {
              slots[i] = ch;
              mp.put(ch,i);
              permutation(str,cci+1,ssf+1,ts,mp,slots);
              mp.put(ch,loc);
              slots[i] = null;
          }
      }
      
      if(loc == -1) {
              permutation(str,cci+1,ssf,ts,mp,slots);
      }
  }

}