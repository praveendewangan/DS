package backtrackingwithrecursion;

public class LexicographicalOrder {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            dfs(i,30);
        }
    }
    private static void dfs(int i ,int n) {
        if(i > n) {
            return;
        }
        System.out.println(i);
        for (int j = 0; j < 10; j++) {
            dfs(10*i+j,n);
        }
    }
}
