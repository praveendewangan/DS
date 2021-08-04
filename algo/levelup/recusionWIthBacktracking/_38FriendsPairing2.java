import java.io.*;
import java.util.*;

public class _38FriendsPairing2 {
  static int counter = 1;


  public static void solution(int i, int n, boolean[] used, String asf) {
    if(i > n) {
        System.out.println(counter+"."+asf);
        counter++;
        return;
    }
    if(used[i]) {
        // Already included in lowercase
        solution(i+1,n,used,asf);
    } else {
        // Single call
        used[i] = true;
        solution(i+1,n,used,asf+"("+i+") ");
        // Pairup call
        for(int j = i+1; j <= n; j++){
            if(!used[j]) {
                used[j] = true;
                solution(i+1,n,used,asf+"("+i+","+j+") ");
                used[j] = false;
            }
        }
        used[i] = false;
    }
    
  }

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    boolean[] used = new boolean[n + 1];
    solution(1, n, used, "");
  }
}