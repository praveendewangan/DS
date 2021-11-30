import java.io.*;
import java.util.*;

public class _1ImplementTrieLC208 {
  public static class Trie {

    static class Node {
        Node[] children;
        boolean isEnd;
        
        Node() {
            this.children = new Node[26];
            this.isEnd = false;
        }
    }
    private Node root;
    /** Initialize your data structure here. */
    public Trie() {
        this.root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node ptr = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(ptr.children[ch - 'a'] == null){
               ptr.children[ch - 'a'] = new Node();
            }
            ptr = ptr.children[ch - 'a'];
        }
        ptr.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node ptr = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(ptr.children[ch - 'a'] == null){
               return false;
            }
            ptr = ptr.children[ch - 'a'];
        }
        return ptr.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String word) {
        Node ptr = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(ptr.children[ch - 'a'] == null){
               return false;
            }
            ptr = ptr.children[ch - 'a'];
        }
        return true;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    Trie obj = new Trie();

    while (read.ready()) {
      String inp[] = read.readLine().split(" ");

      if (inp[0].equals("insert")) {
        obj.insert(inp[1]);
      } else if (inp[0].equals("search")) {
        System.out.println(obj.search(inp[1]));
      } else if (inp[0].equals("startsWith")) {
        System.out.println(obj.startsWith(inp[1]));
      }
    }

  }
}
