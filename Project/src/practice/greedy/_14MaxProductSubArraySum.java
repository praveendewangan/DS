package practice.greedy;

public class _14MaxProductSubArraySum {
    // O(n),O(1)
    public static void main(String[] args) {
        int a[] = { 0, 0, 0 };//{ -1, 0 };//{-1, -1, -2, 4, 3};
        int n = a.length;
        System.out.println(maxProductSubset(a, n));
    }
    static int maxProductSubset(int a[], int n) {
        if(n == 1) {
            return a[0];
        }
        int max = 0;
        int min = 0;
        int res = max;
        int zero = 0;
        int neg = 0;
        for(int i = 0;i < n;i++) {
            if(a[i] == 0) {
                zero++;
                if(res < max){
                    res = max;
                }
                max = 1;
                min = 1;
                continue;
            }
            if(a[i] < 0) {
                neg++;
            }   
            max = Math.max(a[i], Math.max(a[i]*max, a[i]*min));         
            min = Math.min(a[i], Math.min(a[i]*max, a[i]*min));  
            if(res < max){
                res = max;
            }       
        }
        if(zero == n || zero + neg == n){
            return 0;
        }
        return res;
    }
}
