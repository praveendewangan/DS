package practice.string;

public class _14NextGreaterNumberNextPerm {
    static List<Integer> nextPermutation(int N, int a[]){
        int idx = -1;
        int len = a.length;
        for(int i=len-1;i>0;i--){
            if(a[i] > a[i-1]){
                idx = i;
                break;
            }
        }
        if(idx == -1) {
            reverse(a,0,len-1);
        } else {
            int prev = idx;
            for(int i=idx+1;i<len;i++){
                if(a[prev] >= a[i] && a[idx-1] < a[i]){
                    prev = i;
                }
            }
            swap(a,idx-1,prev);
            reverse(a,idx,len-1);
        }
        List<Integer> list = new ArrayList<>();
        for(int n : a) {
            list.add(n);
        }
        return list;
    }
    private static void swap(int[] a,int i,int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    private static void reverse(int[] a,int i,int j){
        while(i < j) {
            swap(a,i,j);
            i++;
            j--;
        }
    }
}
