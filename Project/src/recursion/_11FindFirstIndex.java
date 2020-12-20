package recursion;

public class FindFirstIndex {
    public static void main(String[] args) {
        int[] a = {2,3,2,4,5,6,8,4};
        int n = 5;
        System.out.println(firstIndex(a,0,n));
    }
    private static int firstIndex(int[] a,int n,int f) {
        if(n == a.length ) return -1;
        if(a[n] == f) {
            return n;
        } else {
            int id = firstIndex(a,n+1,f);
            return id;
        }

    }
}
