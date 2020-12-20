package recursion;

public class _12LastIndex {
    static int count = 0;
    public static void main(String[] args) {
        int[] a = {15,11,40,4,4,9};
        int n = 4;
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
    /*Efficient approch*/
    private static int find(int[] a,int idx,int x) {
        if(idx < 0) return -1;
        if(a[idx] == x){
            return idx;
        } else {
            return find(a,idx-1,x);
        }
    }
}
