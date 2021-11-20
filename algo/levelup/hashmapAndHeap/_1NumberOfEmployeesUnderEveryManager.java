import java.io.*;
import java.util.*;

public class _1NumberOfEmployeesUnderEveryManager {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    Map<String,Set<String>> map = new HashMap<>();
    String man = null; 
    for(int i=0; i < n; i++){
        String s1 = scn.next();
        String s2 = scn.next();
        if(s1.equals(s2)){
            man = s1;
        } else if(map.containsKey(s2)) {
            map.get(s2).add(s1);
        } else {
            Set<String> set = new HashSet<>();
            set.add(s1);
            map.put(s2,set);
        }
    }
    // System.out.println(map);
    
    Map<String,Integer> ans = new HashMap<>();
    getSize(map,ans,man);
    for(String key : ans.keySet()){
        System.out.println(key + " " + ans.get(key));
    }
  }
  
  private static int getSize(Map<String,Set<String>> map,Map<String,Integer> ans,String man) {
      if(!map.containsKey(man)){
          ans.put(man,0);
          return 1;
      }
      int size = 0;
      for(String emp : map.get(man)) {
          size += getSize(map,ans,emp);
      }
      ans.put(man,size);
      return size+1;
  }

}