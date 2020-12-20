package recursion;

public class _10MaxOfArray {
    public static void main(String[] args) {
        int[] a = {1,9,5,4,3};
        System.out.println(printMax(a,0));
    }
    private static int printMax(int[] a, int n) {
        if(n == a.length - 1) return a[n];
        int cp = printMax(a,n+1);
        if(a[n] > cp){
            return a[n];
        } else {
            return cp;
        }
    }
}
