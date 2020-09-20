package backtrackingwithrecursion;

public class JosephusProblem {
    public static void main(String[] args) {
        System.out.println(solution(5,3));
    }
    private static int  solution(int n ,int k) {
        if(n == 0){
            return 0;
        }
        int x = solution(n-1,k);
        int y = (x+k)%n;
        return y;
    }
}
