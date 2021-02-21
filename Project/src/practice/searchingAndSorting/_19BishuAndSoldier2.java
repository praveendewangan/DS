package practice.searchingAndSorting;

public class _19BishuAndSoldier2 {
    // O(nlogn),O(n)
    public static void main(String[] args) {
        int n = 7;
        int[] a = new int[]{1,2,3,4,5,6,7};
        int m =  3;
        int[] b = new int[]{3,10,2};
        int[] prefix = new int[n];
        prefix[0] = a[0];
        for(int i=1;i<n;i++){
            prefix[i] = prefix[i-1] + a[i];
        }

        for(int i=0;i<m;i++) {
            int j = 0;
            int k = n;
            int mid = 0;
            while(j < k) {
                mid = (j + k) / 2;
                if(a[mid] > b[i]){
                    k = mid;
                } else  if(a[mid] < b[i]){
                    j = mid + 1;
                } else {
                    break;
                }
            }
            System.out.println((mid+1) + " " + prefix[mid]);
        }    
    }
}
