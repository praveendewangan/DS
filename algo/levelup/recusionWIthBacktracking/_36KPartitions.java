import java.io.*;
import java.util.*;

public class _36KPartitions {
    static int count = 1;
  public static void solution(int i, int n, int k, int rssf, ArrayList<ArrayList<Integer>> ans) {
    
    if(i > n) {
        if(ans.size() == k) {
            System.out.print(count+". ");
            for(int j = 0; j < ans.size(); j++) {
                System.out.print(ans.get(j) + " ");
            }
            System.out.println();
            count++;
        }
        return;
    }
    
    // n-1 , k work, add with prev options
    for(int j = 0; j < ans.size();j++){
        ArrayList<Integer> list = ans.get(j);
        list.add(i);
        solution(i+1,n,k,rssf,ans);
        list.remove(list.size()-1);
    }
    
    // n-1 , k-1 work, start from myself 
    if(ans.size() + 1 <= k) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(i);
        ans.add(list);
        solution(i+1,n,k,rssf,ans);
        ans.remove(ans.size()-1);
    }
}
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int k = scn.nextInt();
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    // for (int i  = 0; i < k; i++) {
    //   ans.add(new ArrayList<>());
    // }
    solution(1, n, k, 0, ans);

  }

}