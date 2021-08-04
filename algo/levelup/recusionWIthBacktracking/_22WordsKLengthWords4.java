import java.io.*;
import java.util.*;

public class _22WordsKLengthWords4 {

 

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());
    
    Map<Character,Integer> mp = new HashMap<>();
    String ustr = "";
    
    for(char ch : str.toCharArray()) {
        if(!mp.containsKey(ch)){
            ustr += ch;
            mp.put(ch,1);
        } else {
            mp.put(ch,mp.get(ch)+1);
        }
    }
    
    permutation(ustr,0,k,mp,"");
  
  }
  
  private static void permutation(String str,int cs,int ts,Map<Character,Integer> mp,String asf) {
      if(cs == ts) {
          System.out.println(asf);
          return;
      }
      
      for(int i = 0; i < str.length(); i++){
          char ch = str.charAt(i);
          int f = mp.get(ch);
          if(f > 0) {
              mp.put(ch,f-1);
              permutation(str,cs+1,ts,mp,asf+ch);
              mp.put(ch,f);
          }
      }
  }

}