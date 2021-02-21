package practice.searchingAndSorting;

public class _25AllocateMinNumOfPages {
    // O(nlogn),O(1)
    public static int findPages(int[]a,int n,int m)
    {
        int lo = 0;
        int totalPages = 0;
        for(int val : a){
            totalPages += val;
            lo = Math.max(lo,val);
        }
        int hi = totalPages;
        int ans = 0;
        while(lo <= hi) {
            int mid = (lo+hi)/2;
            
            if(isValid(a,n,m,mid)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    static boolean isValid(int[] b,int n,int k,int ans) {
        int student = 1;
        int curPages = 0;
        for(int i=0;i<n;i++) {
            if(curPages+b[i] > ans) {
                curPages = b[i];
                student++;
                if(student > k) {
                    return false;
                }
            } else {
                curPages += b[i];
            }
        }
        return true;
    }
}
