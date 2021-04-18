package practice.arrays;

public class _15NextPermutation2 {
    public static void main(String[] args) {
        int[] a = {1,3,5,4,2}; // Ans = { 1,4,2,3,5} 
        nextPt(a);
        for(int val : a) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
    private static void nextPt(int[] a) {
        int idx1 = nextSmallerElement(a);
        // System.out.println(idx1 + " - idx1");
        if(idx1 == -1) {
            reverse(a,0,a.length-1);
        } else {
            int idx2 = nextGreaterElement(a,idx1);
            swap(a,idx1,idx2);
            reverse(a,idx1+1,a.length-1);
        }
    }
    
    private static int nextSmallerElement(int[] a) {
        int idx = -1;
        for(int i = a.length-1; i > 0; i--){
            if(a[i] > a[i-1]){
                idx = i-1;
                break;
            }
        }
        return idx;
    }
    
    private static void reverse(int[] a, int i,int j) {
        while(i < j) {
            swap(a,i,j);
            i++;
            j--;
        }
    }
    
    private static int nextGreaterElement(int[] a, int idx1) {
        int idx2 = -1;
        for(int i = a.length - 1; i >= 0; i--){
            if(a[i] > a[idx1]){
                idx2 = i;
                break;
            }
        }
        return idx2;
    }
    private static void swap(int[] a,int i, int j) {
        int val = a[i];
        a[i] = a[j];
        a[j] = val;
    }
}
