import java.io.*;
import java.net.Inet4Address;
import java.util.*;

public class _3WordSearchllLC212_1 {
    static class Node {
        Node[] children;
        boolean isEnd;
        int freq;

        Node() {
            this.children = new Node[26];
            this.isEnd = false;
            this.freq = 0;
        }
    }
    private static void insert(String word, Node root) {
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(root.children[ch - 'a'] == null) {
                root.children[ch - 'a'] = new Node();
            }
            root = root.children[ch - 'a'];
        }
        root.isEnd = true;
    }

    private static int[] xdir = {-1, 0, 1, 0};
    private static int[] ydir = {0, -1, 0, 1};

    private static void travelAndAdd(char[][] board, int i, int j, boolean[][] vis,
         Node root, ArrayList<String> res, StringBuilder str) {
        char ch = board[i][j];
        if(root.children[ch - 'a'] == null)
            return;
        
        str.append(ch);
        vis[i][j] = true;
        root = root.children[ch - 'a'];
        if(root.isEnd == true) {
            res.add(str.toString());
            root.isEnd = false;
        }
        for(int d = 0; d < 4; d++) {
            int r = i + xdir[d];
            int c = j + ydir[d];

            if(r >= 0 && r < board.length && c >= 0 && c < board[0].length && vis[r][c] == false) {
                travelAndAdd(board, r, c, vis, root, res, str);
            }
        }
        str.deleteCharAt(str.length() - 1);
        vis[i][j] = false;
    }

    public static ArrayList<String> findWords(char[][] board, String[] words) {
        // make a TRIE and add word in it
        Node root = new Node();
        for(String word : words) {
            insert(word, root);
        }
        // travel in cell and find similar words from dictionary
        boolean[][] vis = new boolean[board.length][board[0].length];
        ArrayList<String> res = new ArrayList<>();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                StringBuilder str = new StringBuilder();
                travelAndAdd(board, i, j, vis, root, res, str);
            }
        }
        return res;
    }



  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(read.readLine());
    int m = Integer.parseInt(read.readLine());
    char[][]board = new char[n][];
    for (int i = 0; i < n; i++) {
      board[i] = read.readLine().trim().toCharArray();
    }
    int count = Integer.parseInt(read.readLine());
    String words[] = new String[count];
    for (int i = 0; i < count; i++) {
      words[i] = read.readLine();
    }

    ArrayList<String> result = findWords(board, words);
    Collections.sort(result);
    System.out.println(result);

  }
}
