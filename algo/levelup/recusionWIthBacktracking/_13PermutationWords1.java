import java.io.*;
import java.util.*;

public class _13PermutationWords1 {

  public static void generateWords(int cb, int tb, HashMap<Character, Integer> fmap, String asf) {
    if(cb > tb) {
        System.out.println(asf);
        return;
    }
        for(char ch : fmap.keySet()) {
            int f = fmap.get(ch); 
            if(f > 0){
                fmap.put(ch,f-1);
                generateWords(cb+1,tb,fmap,asf+ch);
                fmap.put(ch,f);
            }
        }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    HashMap<Character, Integer> fmap = new HashMap<>();
    for(char ch: str.toCharArray()){
      if(fmap.containsKey(ch)){
        fmap.put(ch, fmap.get(ch) + 1);
      } else {
        fmap.put(ch, 1);
      }
    }

    generateWords(1, str.length(), fmap, "");
  }

}
