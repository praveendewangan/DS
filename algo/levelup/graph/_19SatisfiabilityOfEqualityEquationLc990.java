import java.io.*;
import java.util.*;

public class _19SatisfiabilityOfEqualityEquationLc990 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    String[] arr = new String[n];
    for (int i = 0; i < n; i++) {
      arr[i] = br.readLine();
    }

    System.out.println(equationsPossible(arr));
  }

private static int find(int[] parent, int x) {
        if(parent[x] == x) {
            return x;
        }

        int temp = find(parent, parent[x]);
        parent[x] = temp;
        return temp;
  }
  public static void union(int lx, int ly, int[] rank, int[] parent) {
        if(rank[lx] > rank[ly]) {
            parent[ly] = lx;
        } else if(rank[lx] < rank[ly]) {
            parent[lx] = ly;
        } else {
            parent[ly] = lx;
            rank[lx]++;
        }
    }
  public static boolean equationsPossible(String[] equations) {
    // process '==' and union then
        int[] parent = new int[26];
        int[] rank = new int[26];
        for(int i = 0; i < 26; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for(int i = 0; i < equations.length; i++) {
            if(equations[i].charAt(1) == '=') {
                int x = equations[i].charAt(0) - 'a';
                int y = equations[i].charAt(3) - 'a';

                int lx = find(parent, x);
                int ly = find(parent, y);

                if(lx == ly) {
                    continue;
                }
                union(lx, ly, rank, parent);
            }
        }
        
        // check set leader for '!=' equality, if same then return false;
        for(int i = 0; i < equations.length; i++) {
            if(equations[i].charAt(1) == '!') {
                int x = equations[i].charAt(0) - 'a';
                int y = equations[i].charAt(3) - 'a';
                int lx = find(parent, x);
                int ly = find(parent, y);
                if(lx == ly) return false;
            }
        }
        return true;
    }
}
