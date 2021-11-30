import java.io.*;
import java.util.*;

public class _6MapSumPairsLC677 {
  public static class MapSum {
    private static class Node {
        Node[] children;
        int impact;
        Node() {
            this.children = new Node[26];
        }
    }

    
    private static Map<String,Integer> map;
    private static Node root;
    /** Initialize your data structure here. */
    public MapSum() {
        root = new Node();
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        int oval = map.getOrDefault(key,0);
        int nval = val;
        int impact = nval - oval;
        map.put(key,val);
        Node ptr = root;
        for(int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);

            if(ptr.children[ch - 'a'] == null) {
                ptr.children[ch - 'a'] = new Node();
            }
            ptr = ptr.children[ch - 'a'];
            ptr.impact += impact;
        }
    }

    public int sum(String prefix) {
         Node ptr = root;
        for(int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);

            if(ptr.children[ch - 'a'] == null) {
                ptr.children[ch - 'a'] = new Node();
            }
            ptr = ptr.children[ch - 'a'];
        }
        return ptr.impact;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    MapSum obj = new MapSum();

    while (read.ready()) {
      String inp[] = read.readLine().split(" ");
      if (inp[0].equals("exit"))break;

      if (inp.length == 2) {
        obj.insert(inp[0], Integer.parseInt(inp[1]));
      } else {
        System.out.println(obj.sum(inp[0]));
      }
    }
  }
}
