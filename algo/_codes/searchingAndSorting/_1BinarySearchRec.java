public class _1BinarySearchRec {
    public static void main(String[] args) {
        
    }
    private static boolean binarySeachRec(int[] a,int lo,int hi,int data) {
        if(lo > hi) {
            return false;
        }
        int m = (lo + hi) / 2; // (lo + (hi - lo)/2)
        if(data < a[m]) {
            return binarySeachRec(a,lo,m,data);
        } else if(data > a[m]) {
            return binarySeachRec(a,m,hi,data);
        } else {
            return true;
        }
    }
}
