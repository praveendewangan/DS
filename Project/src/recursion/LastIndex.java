package recursion;

public class LastIndex {
    static int count = 0;
    public static void main(String[] args) {
        int[] a = {2,3,2,4,5,6,8,4};
        int n = 9;
        System.out.println(lastIndex(a,a.length - 1,n));
        System.out.println(count);
    }
    private static int lastIndex(int[] a,int n,int f) {
        count++;
        if(n == a.length - 1 ) return -1;
        if(a[n] == f) {
            return n;
        } else {
            int id = lastIndex(a,n-1,f);
            return id;
        }

    }
}
