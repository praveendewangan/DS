import java.io.*;
import java.util.*;

public class _8StreamofCharactersLC1032 {
  public static class StreamChecker {
      class Node {
          Node[] children;
          boolean isEnd;
          Node() {
              children = new Node[26];
              isEnd = false;
          }
      }
      private Node root;
      private StringBuilder stream;
      public void insert(Node root, String word) {
        for(int i = word.length()-1; i >= 0; i--) {
            char ch = word.charAt(i);

            if(root.children[ch - 'a'] == null) {
                root.children[ch - 'a'] = new Node();
            }
            root = root.children[ch - 'a'];
        }
        root.isEnd = true;
    }
    public StreamChecker(String[] words) {
        root = new Node();
        stream = new StringBuilder();
        for(String word : words) {
            insert(root,word);
        }
    }
    private boolean find() {
        Node temp = root;
        for(int i = stream.length()-1; i>= 0; i--){
            char ch = stream.charAt(i);

            if(temp.children[ch - 'a'] == null) {
                return false;
            }   
            temp = temp.children[ch - 'a'];
            if(temp.isEnd) {
                return true;
            }
        }
        return false;
    }
    public boolean query(char letter) {
        stream.append(letter);
        return find();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(read.readLine());

    String[]words = new String[n];

    for (int i = 0; i < n; i++) {
      words[i] = read.readLine();
    }

    StreamChecker obj = new StreamChecker(words);

    n = Integer.parseInt(read.readLine());
    for (int i = 0; i < n; i++) {
      System.out.println(obj.query(read.readLine().charAt(0)));
    }
  }
}
