package practice.searchingAndSorting;

public class _31RotiParatha {
    
    public static void main(String[] args) {
        int p = 10;
        int n = 4;
        int[] s = new int[]{1,2,3,4};
        int lo = 0;
        int hi = (int) Math.pow(10, 8);
        int ans = 0;
        while(lo<=hi) {
            int mid = (lo+hi)/2;
            if(isValid(s,mid,p)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        System.out.println(ans);
    }
    private static boolean isValid(int[] s,int mid,int p) {
        int time = 0;
        int paratha = 0;
        for(int i=0;i<s.length;i++){
            time = s[i];
            int j = 2;
            while(time <= mid) {
                paratha++;
                time = time + (s[i] * j);
                j++;
            }
        }
        if(paratha >= p) {
            return true;
        }
        return false;

    }
}
