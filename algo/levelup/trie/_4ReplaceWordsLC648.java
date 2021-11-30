import java.io.*;
import java.util.*;

public class _4ReplaceWordsLC648 {
    static class Node {
        Node[] children;
        String word;

        Node() {
            this.children = new Node[26];
            this.word = null;
        }
    }
    private static void insert(String word, Node root) {
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(root.children[ch - 'a'] == null) {
                root.children[ch - 'a'] = new Node();
            }
            root = root.children[ch - 'a'];
            if(root.word != null)
                return;
        }
        root.word = word;
    }
  public static String searchPrefix(Node root, String str) {
      
        StringBuilder sb = new StringBuilder();
        for(char ch : str.toCharArray()){
            if(root.children[ch - 'a'] == null){
                return null;
            } 
            root = root.children[ch - 'a'];
            if(root.word != null) {
                return root.word;
            }
        }
        return null;
  }
  
  public static String replaceWords(String dictionary[], String sentence) {
        Node root = new Node();
        for(String word : dictionary) {
            insert(word, root);
        }
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(sentence);
        Node ptr = root;
        while(st.hasMoreTokens()) {
            String word = st.nextToken();
            String prefix = searchPrefix(root,word);
            if(prefix != null) {
                sb.append(prefix);
            } else {
                sb.append(word);
            }
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
    return sb.toString();
  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(read.readLine());

    String[]dictionary = new String[n];

    for (int i = 0; i < n; i++) {
      dictionary[i] = read.readLine();
    }

    String sentence = read.readLine();

    String result = replaceWords(dictionary, sentence);
    System.out.println(result);

  }
}
