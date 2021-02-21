package practice.searchingAndSorting;

public class _29SmallestFactorialWithTrailingZero {
    // O(nlogn),O(1)
    int findNum(int n)
    {
        if(n == 1) return 5;
        int lo = 0;
        int hi = 5*n;
        while(lo < hi) {
            int mid = (lo + hi)/2;
            if(isValid(mid,n)){
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
    boolean isValid(int mid,int n){
        int ans = 0;
        int p = 5;
        while((mid/p) > 0) {
            ans += (mid/p);
            p = p * 5;
        }
        if(ans >= n){
            return true;
        } else {
            return false;
        }
    }
}
