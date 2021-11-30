import java.io.*;
import java.util.*;

public class _7LongestWordinDictionaryLC720 {
    private static class Node {
        Node[] children;
        String s;
        Node() {
            this.children = new Node[26];
        }
    }
    public static void insert(Node root, String word) {
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if(root.children[ch - 'a'] == null) {
                root.children[ch - 'a'] = new Node();
            }
            root = root.children[ch - 'a'];
        }
        root.s = word;
    }
    private static String str;
    private static void dfsTrie(Node node) {
        if(node.s == null) return;
        if(node.s.length() > str.length()) {
            str = node.s;
        }
        
        for(int i=0; i < 26; i++) {
            if(node.children[i] != null) {
                dfsTrie(node.children[i]);
            }
        }
    }
  public static String longestWord(String[] words) {
        Node root = new Node();
        for(String word : words) {
            insert(root,word);
        }
        str = "";
        for(int i=0; i < 26; i++) {
            if(root.children[i] != null) {
                dfsTrie(root.children[i]);
            }
        }
        return str;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(read.readLine());

    String[]words = new String[n];

    for (int i = 0; i < n; i++) {
      words[i] = read.readLine();
    }

    String result = longestWord(words);
    System.out.println(result);

  }
}
