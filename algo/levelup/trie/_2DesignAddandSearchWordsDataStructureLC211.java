import java.io.*;
import java.util.*;

public class _2DesignAddandSearchWordsDataStructureLC211 {
    public static class WordDictionary {
        private class Node {
            Node[] children;
            boolean isEnd;
    
            Node() {
                this.children = new Node[26];
                this.isEnd = false;
            }
        }
        
        private Node root = null;
    
        public WordDictionary() {
            root = new Node();
        }
    
        /** Adds a word into the data structure. */
        public void addWord(String word) {
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
    
        /**
         * Returns if the word is in the data structure. A word could contain the dot
         * character '.' to represent any one letter.
         */
        public boolean search(String word) {
            return find(root,word,0);
        }
        
        private static boolean find(Node node,String word, int idx) {
            if(idx == word.length()) {
                return node.isEnd;
            }
            char ch = word.charAt(idx);
            if(ch == '.') {
                for(int i = 0; i < 26; i++) {
                    Node child = node.children[i];
                    if(child != null && find(child,word,idx+1)) {
                        return true;
                    }
                }
            } else if(node.children[ch-'a'] != null) {
                return find(node.children[ch-'a'],word,idx+1);
            }
            return false;
        }
  }


  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    WordDictionary obj = new WordDictionary();

    while (read.ready()) {
      String inp[] = read.readLine().split(" ");

      if (inp[0].equals("addWord")) {
        obj.addWord(inp[1]);
      } else if (inp[0].equals("search")) {
        System.out.println(obj.search(inp[1]));
      }
    }

  }
}
